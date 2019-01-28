package com.sompra.configuration;

import com.sompra.entity.DataStore;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.aop.target.ThreadLocalTargetSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

/**
 * Created by somprasong
 * Date: 2019-01-27
 * Time: 14:31
 */

@Configuration
public class AppConfiguration {

    @Bean(destroyMethod = "destroy")
    public ThreadLocalTargetSource threadLocalTenantStore() {
        ThreadLocalTargetSource result = new ThreadLocalTargetSource();
        result.setTargetClass(DataStore.class);
        result.setTargetBeanName("dataStore");
        return result;
    }

    @Bean
    @Primary
    public ProxyFactoryBean proxiedThreadLocalTargetSource(ThreadLocalTargetSource threadLocalTargetSource) {
        ProxyFactoryBean result = new ProxyFactoryBean();
        result.setTargetSource(threadLocalTargetSource);
        return result;
    }

    @Bean
    @Scope(scopeName = "prototype")
    public DataStore dataStore() {
        return new DataStore();
    }
}
