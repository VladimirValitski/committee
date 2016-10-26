package filters;

import javax.servlet.*;
import java.io.IOException;

/**
 * Class Encoding seting encoding UTF-8
 */
public class Encoding implements Filter {
    /**
     * Method doFilter() seting encoding into request and response
     */
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        chain.doFilter(request, response);
    }

    public void init(FilterConfig filterConfig) {
    }

    @Override
    public void destroy() {
    }
}
