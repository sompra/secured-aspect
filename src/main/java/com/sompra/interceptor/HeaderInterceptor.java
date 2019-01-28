package com.sompra.interceptor;

import com.sompra.entity.DataStore;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by somprasong
 * Date: 2019-01-27
 * Time: 15:00
 */

@Component
@NoArgsConstructor
@AllArgsConstructor
public class HeaderInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private DataStore dataStore;

    private static final Logger LOG = LoggerFactory.getLogger(HeaderInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        LOG.info("Pre-Handle : passage de cookie");
        dataStore.setValue("Thread : " + Thread.currentThread().getId());
        return super.preHandle(request, response, handler);
    }


    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        LOG.info("Post-Handle : récupération de cookie");
        super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        LOG.info("After-Completion");
        super.afterCompletion(request, response, handler, ex);
    }
}
