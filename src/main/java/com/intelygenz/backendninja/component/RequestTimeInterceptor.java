package com.intelygenz.backendninja.component;

import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.apache.commons.logging.Log;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static java.lang.System.currentTimeMillis;

@Component("requestTimeInterceptor")
public class RequestTimeInterceptor extends HandlerInterceptorAdapter {

    private static final Log LOG = LogFactory.getLog(RequestTimeInterceptor.class);

    // Se ejecuta primero
    // Se ejecuta antes de sacar la vista del controlador
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        request.setAttribute("startTime", currentTimeMillis());
        return true;
    }


    //Se ejecuta segundo
    //Se ejecuta antes de entrar en el metodo del controlador.
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        long startTime = (long) request.getAttribute("startTime");
        LOG.info("URL to:'" + request.getRequestURL().toString() + "'IN: '" + (currentTimeMillis() - startTime) + "'ms");
    }


}
