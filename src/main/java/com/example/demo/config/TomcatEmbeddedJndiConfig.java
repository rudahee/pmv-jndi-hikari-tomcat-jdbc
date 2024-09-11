package com.example.demo.config;

/*
import org.apache.catalina.Context;
import org.apache.catalina.core.StandardContext;
import org.apache.tomcat.util.descriptor.web.ContextResource;
import org.apache.tomcat.util.descriptor.web.ContextResourceLink;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TomcatEmbeddedJndiConfig {

    @Value("${uwu.spring.datasource.url}")
    private String url;
    @Value("${uwu.spring.datasource.username}")
    private String username;
    @Value("${uwu.spring.datasource.password}")
    private String password;
    @Value("${uwu.spring.datasource.driver-class-name}")
    private String driverClassName;

    @Bean
    public ServletWebServerFactory servletContainer() {
        return new TomcatServletWebServerFactory() {
            @Override
            protected void postProcessContext(Context context) {
                if (context instanceof StandardContext) {
                    StandardContext standardContext = (StandardContext) context;

                    // Definir el recurso JNDI para HikariCP
                    ContextResource resource = new ContextResource();
                    resource.setName("java:/comp/env/jdbc/customJNDI");
                    resource.setType("javax.sql.DataSource");
                    resource.setProperty("factory", "com.zaxxer.hikari.HikariJNDIFactory");
                    resource.setProperty("driverClassName", driverClassName);
                    resource.setProperty("jdbcUrl", url);
                    resource.setProperty("username", username);
                    resource.setProperty("password", password);
                    resource.setProperty("maximumPoolSize", "10");
                    resource.setProperty("minimumIdle", "5");
                    resource.setProperty("connectionTimeout", "30000");
                    resource.setProperty("idleTimeout", "60000");
                    resource.setProperty("maxLifetime", "1800000");

                    standardContext.getNamingResources().addResource(resource);

                    ContextResourceLink resourceLink = new ContextResourceLink();
                    resourceLink.setName("java:/comp/env/jdbc/customJNDI");
                    resourceLink.setType("javax.sql.DataSource");
                    resourceLink.setGlobal("java:/comp/env/jdbc/customJNDI");
                    standardContext.getNamingResources().addResourceLink(resourceLink);
                }
            }
        };
    }
}*/