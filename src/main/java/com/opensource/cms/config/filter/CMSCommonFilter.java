package com.opensource.cms.config.filter;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;

@Component
public class CMSCommonFilter implements Filter {
    private Logger logger = LoggerFactory.getLogger(CMSCommonFilter.class);

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain next)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        next.doFilter(request, response);
        logger.info("Committing a transaction for req : {} ", req.getRequestURI());
    }

}
