package com.springsecurity.demo.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.logging.Logger;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.springsecurity.demo")
@PropertySource("classpath:persistence-postgre.properties")
public class DemoAppConfig {
    //set up variable to hold data  from the properties
    @Autowired
    private Environment environment;

    private Logger logger = Logger.getLogger(getClass().getName());


    //define bean for ViewResolver

    @Bean
    public ViewResolver viewResolver(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();

        viewResolver.setPrefix("/WEB-INF/view/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    //define a bean for our security datasource
    @Bean
    public DataSource securityDataSource(){
        //create connection pool
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        //set the jdbc driver class
        try {
            dataSource.setDriverClass(environment.getProperty("jdbc.driver"));
        } catch (PropertyVetoException e) {
            throw new RuntimeException(e);
        }
        //log the connection properties
    logger.info(">>>>>JDBC.url= "+ environment.getProperty("jdbc.url"));
    logger.info(">>>>>JDBC.user= "+ environment.getProperty("jdbc.user"));
        //set database connection props
        dataSource.setJdbcUrl(environment.getProperty("jdbc.url"));
        dataSource.setUser(environment.getProperty("jdbc.user"));
        dataSource.setPassword(environment.getProperty("jdbc.password"));

        //set connection pool props
        dataSource.setInitialPoolSize(getIntProperty("connection.pool.initialPoolSize"));
        dataSource.setMinPoolSize(getIntProperty("connection.pool.minPoolSize"));
        dataSource.setMaxPoolSize(getIntProperty("connection.pool.maxPoolSize"));
        dataSource.setMaxIdleTime(getIntProperty("connection.pool.maxIdleTime"));

        return dataSource;
    }

    //convert prop to int
    private int getIntProperty(String propName){
        String value = environment.getProperty(propName);
        int intVal = Integer.parseInt(value);
        return intVal;
    }
}
