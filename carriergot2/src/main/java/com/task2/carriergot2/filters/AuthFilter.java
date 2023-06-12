package com.task2.carriergot2.filters;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;
import java.util.Objects;

@Configuration
@Order(1)
public class AuthFilter implements Filter
{

    private static final List<String> ALLOWED_ORIGINS = Arrays.asList(
            "http://localhost:3000",
            "http://localhost:3000/"
            // Add other allowed origins as needed
    );

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

        Filter.super.init(filterConfig);
        System.out.println("AuthFilter init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        if(request.getMethod().equals("OPTIONS")){
            String origin = request.getHeader("Origin");
            if (origin != null && ALLOWED_ORIGINS.contains(origin)) {
                response.setHeader("Access-Control-Allow-Origin", "*");
                response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE, PUT");
                response.setHeader("Access-Control-Allow-Headers", "Authorization, Content-Type");
                response.setHeader("Access-Control-Max-Age", "3600");
                // Add any other headers you need to allow
                response.setStatus(HttpServletResponse.SC_OK);
                chain.doFilter(request, response);
            } else {
                response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            }
        } else {
    //        Decrypting JWT logic.
            String uri = "https://dev-apps.blumesolutions.com/jwt/decrypt";
            RestTemplate temp = new RestTemplate();
            if(request.getHeader("Authorization") == null){
                response.setStatus(401);
                return;
            }
            String req = "{\"token\":\"" + request.getHeader("Authorization").substring(7) + "\"}";
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<String> entity = new HttpEntity<String>(req, headers);
            String result = null;
            try {result = temp.postForObject(uri, entity, String.class);}
            catch (Exception e) {
                e.printStackTrace();
                response.setStatus(401);
                return;
            }

    //        getting username from JWT.
            try {
                JsonNode jsonNode = new ObjectMapper().readTree(result);
                String name = jsonNode.get("firstName").asText() + " " + jsonNode.get("lastName").asText();
                request.setAttribute("username", name);
            } catch (Exception e) {
                e.printStackTrace();
            }
            chain.doFilter(request, response);
        }

    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
