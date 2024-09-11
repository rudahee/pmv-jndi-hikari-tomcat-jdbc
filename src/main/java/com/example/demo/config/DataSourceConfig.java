package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.jndi.JndiObjectFactoryBean;

import javax.naming.*;
import javax.sql.DataSource;
import java.util.Properties;


@Configuration
public class DataSourceConfig {

    @Bean
    public DataSource dataSource() {
         JndiDataSourceLookup jndiDataSourceLookup = new JndiDataSourceLookup();
         return jndiDataSourceLookup.getDataSource("java:/comp/env/jdbc/customJNDI");
    }
}