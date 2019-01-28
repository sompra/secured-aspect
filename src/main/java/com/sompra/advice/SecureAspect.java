package com.sompra.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by somprasong
 * Date: 2019-01-28
 * Time: 07:20
 */

@Aspect
@Component
public class SecureAspect {

    private static final Logger LOG = LoggerFactory.getLogger(SecureAspect.class);

    @Around("@within(com.sompra.advice.Secured) || @annotation(Secured)")
    public Object addSecurity(ProceedingJoinPoint joinPoint) throws Throwable {

        LOG.info("Start Join point secured aspect");
        Object proceed = joinPoint.proceed();
        LOG.info("End Join point secured aspect");
        return proceed;
    }

}
