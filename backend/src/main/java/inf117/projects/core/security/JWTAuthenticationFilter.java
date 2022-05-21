package inf117.projects.core.security;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE + 99)
public class JWTAuthenticationFilter extends OncePerRequestFilter
{
    private final List<String> methods = new ArrayList<>(Arrays.asList(
            HttpMethod.OPTIONS.name(),
            HttpMethod.POST.name(),
            HttpMethod.GET.name(),
            HttpMethod.DELETE.name()
    ));

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException
    {
        if (methods.contains(request.getMethod())){
            filterChain.doFilter(request, response);
            return;
        } else {
            response.sendError(
                    HttpServletResponse.SC_UNAUTHORIZED,
                    "Invalid request caught in filter."
            );
        }
    }
}
