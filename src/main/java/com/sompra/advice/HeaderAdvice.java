package com.sompra.advice;

import com.sompra.entity.DataStore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * Created by somprasong
 * Date: 2019-01-27
 * Time: 14:39
 */

@ControllerAdvice
public class HeaderAdvice implements ResponseBodyAdvice {

    private static final Logger LOG = LoggerFactory.getLogger(HeaderAdvice.class);

    @Autowired
    private DataStore dataStore;

    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        LOG.info("call supports method {} {}", methodParameter, aClass);
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        LOG.info("call before write body : " + dataStore.getValue());
        //serverHttpResponse.getHeaders().set("Set-Cookie", "sompra");
        return o;
    }
}
