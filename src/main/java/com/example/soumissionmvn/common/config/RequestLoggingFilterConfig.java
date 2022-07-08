package com.example.soumissionmvn.common.config;
import org.slf4j.MDC;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.AbstractRequestLoggingFilter;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

import javax.servlet.http.HttpServletRequest;

@Configuration
public class RequestLoggingFilterConfig extends AbstractRequestLoggingFilter {

    @Bean
    public CommonsRequestLoggingFilter logFilter() {
        CommonsRequestLoggingFilter filter = new CommonsRequestLoggingFilter();
        filter.setIncludeQueryString(true);
        filter.setIncludePayload(true);
        filter.setMaxPayloadLength(10000);
        filter.setIncludeHeaders(false);
        filter.setAfterMessagePrefix("Confidential : true; ");
        return filter;
    }

    @Override
    protected void beforeRequest(HttpServletRequest request, String message) {
        MDC.put("confidential", "true");
    }

    @Override
    protected void afterRequest(HttpServletRequest request, String message) {
        MDC.remove("confidential");
    }
}
