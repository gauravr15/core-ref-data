package com.odin.core_ref_data.tracing;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class TraceFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        String traceId = TraceContext.resolveTraceId(request);
        TraceContext.setTraceId(traceId);
        response.setHeader(TraceContext.CORRELATION_ID_HEADER, traceId);
        response.setHeader(TraceContext.REQUEST_CHECKSUM_HEADER, traceId);
        String traceparent = TraceContext.currentTraceparent();
        if (traceparent != null) {
            response.setHeader(TraceContext.TRACEPARENT_HEADER, traceparent);
        }
        try {
            filterChain.doFilter(request, response);
        } finally {
            TraceContext.clear();
        }
    }
}
