package br.jus.tjms.nomeacao.app.filter;

import br.jus.tjms.nomeacao.model.context.ContextHolder;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class ContextFilter extends OncePerRequestFilter {
    private final ContextHolder contextHolder;

    public ContextFilter(ContextHolder contextHolder) {
        this.contextHolder = contextHolder;
    }

    @Override
    protected void doFilterInternal(
        HttpServletRequest request,
        HttpServletResponse response,
        FilterChain filterChain
    ) throws ServletException, IOException {
        String requestId = request.getHeader("requestId");
        try {
            if (requestId == null || requestId.isEmpty()) {
                response.sendError(
                    HttpServletResponse.SC_BAD_REQUEST,
                    "Missing mandatory header"
                );
            }
            contextHolder.setRequestId(requestId);
            filterChain.doFilter(request, response);
        } finally {
            contextHolder.reset();
        }
    }
}
