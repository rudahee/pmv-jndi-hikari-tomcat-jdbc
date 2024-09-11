package com.example.demo.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.eclipse.jetty.plus.jndi.Resource;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.webapp.WebAppContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.jetty.JettyServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
public class JettyEmbeddedServerConfig {

    @Bean
    public WebServerFactoryCustomizer<JettyServletWebServerFactory> jettyCustomizer() {
        return factory -> {
            factory.addServerCustomizers(server -> {
                ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
                server.setHandler(context);

                // Configura el recurso JNDI en Jetty
                try {
                    // Configura HikariCP
                    HikariConfig hikariConfig = new HikariConfig();
                    hikariConfig.setJdbcUrl("jdbc:mysql://localhost:3306/db_KhrissDB");
                    hikariConfig.setUsername("khrissDB");
                    hikariConfig.setPassword("ztX7TaP9QOU0cH1fpovgMD");
                    hikariConfig.setDriverClassName("com.mysql.cj.jdbc.Driver");
                    hikariConfig.setMaximumPoolSize(10);

                    HikariDataSource dataSource = new HikariDataSource(hikariConfig);

                    // Registrar el recurso JNDI
                    context.setAttribute("java:/comp/env/jdbc/customJNDI", dataSource);

                    // Configura el contexto JNDI
                    Properties jndiProps = new Properties();
                    jndiProps.setProperty(Context.INITIAL_CONTEXT_FACTORY, "org.eclipse.jetty.jndi.InitialContextFactory");
                    jndiProps.setProperty(Context.PROVIDER_URL, "file:///");
                    InitialContext initialContext = new InitialContext(jndiProps);
                    initialContext.bind("java:/comp/env/jdbc/customJNDI", dataSource);

                    System.out.println("JNDI Resource registered: java:/comp/env/jdbc/customJNDI");
                } catch (NamingException e) {
                    e.printStackTrace();
                }
            });
        };
    }
}