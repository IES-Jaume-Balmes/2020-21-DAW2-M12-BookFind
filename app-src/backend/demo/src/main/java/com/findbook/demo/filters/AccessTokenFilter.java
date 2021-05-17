package com.findbook.demo.filters;

import com.findbook.demo.exception.InvalidTokenException;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AnyRequestMatcher;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
/*
 * Project Lombok is very handy tool for removing the boilerplate code from application. Lombok can also be used to
 * configure logging in spring boot applications and thus removing the boilerplate code for getting the logger instance.
 * Annotation Type Slf4j Causes lombok to generate a logger field
 */

public class AccessTokenFilter extends AbstractAuthenticationProcessingFilter {

    private final JwtTokenValidator tokenVerifier;

    public AccessTokenFilter(
            JwtTokenValidator jwtTokenValidator,
            AuthenticationManager authenticationManager) {

        super(AnyRequestMatcher.INSTANCE);
        setAuthenticationManager(authenticationManager);
        this.tokenVerifier = jwtTokenValidator;
    }

    //@SneakyThrows can be used to sneakily throw checked exceptions without actually declaring this in your method's throws clause.
    @SneakyThrows
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
                                                HttpServletResponse response) {

        log.info("Attempting to authenticate for a request {}", request.getRequestURI());

        String authorizationHeader = extractAuthorizationHeaderAsString(request);
        AccessToken accessToken = tokenVerifier.validateAuthorizationHeader(authorizationHeader);
        return this.getAuthenticationManager()
                .authenticate(new JwtAuthentication(accessToken));
    }

    /**
     * here will be the logic if authentication finished successfully
     */
    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain,
                                            Authentication authResult) throws IOException, ServletException {

        log.info("Successfully authentication for the request {}", request.getRequestURI());

        SecurityContextHolder.getContext().setAuthentication(authResult);
        chain.doFilter(request, response);
    }

    private String extractAuthorizationHeaderAsString(HttpServletRequest request) throws InvalidTokenException {
        try {
            return request.getHeader("Authorization");
        } catch (Exception ex) {
            throw new InvalidTokenException();
        }
    }
}
