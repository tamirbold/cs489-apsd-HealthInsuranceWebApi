package edu.miu.cs.cs489.healthinsurancesys.filter;

import edu.miu.cs.cs489.healthinsurancesys.service.impl.InsuranceUserDetailsService;
import edu.miu.cs.cs489.healthinsurancesys.utils.service.JWTManagementUtilityService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JWTAuthFilter extends OncePerRequestFilter {
    private InsuranceUserDetailsService insuranceUserDetailsService;
    private JWTManagementUtilityService jwtManagementUtilityService;

    public JWTAuthFilter(InsuranceUserDetailsService insuranceUserDetailsService, JWTManagementUtilityService jwtManagementUtilityService) {
        this.insuranceUserDetailsService = insuranceUserDetailsService;
        this.jwtManagementUtilityService = jwtManagementUtilityService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authorizationHeader = request.getHeader("Authorization");
        // Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhbmEuYWRtaW4iLCJleHAiOjE2NTE0MzUwODEsImlhdCI6MTY1MTM5OTA4MX0.aPH-bBsaRETUip91m3y3_UTR_EwFFbIpkyOdKSTgM70KT0a7v0uAYh4NtnFqvwEgCN7kuR8MDO5VB3rktBAwpA
        String jwtToken = null;
        String username = null;
        if(authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            jwtToken = authorizationHeader.substring(7);
            username = jwtManagementUtilityService.extractUsername(jwtToken);
        }
        if(username != null
                && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails = insuranceUserDetailsService.loadUserByUsername(username);
            if(jwtManagementUtilityService.validateToken(jwtToken, userDetails)) {
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails,
                        null, userDetails.getAuthorities());
                usernamePasswordAuthenticationToken
                        .setDetails(
                                new WebAuthenticationDetailsSource()
                                        .buildDetails(request)
                        );
                SecurityContextHolder.getContext()
                        .setAuthentication(usernamePasswordAuthenticationToken);
            }
        }
        filterChain.doFilter(request, response);
    }
}
