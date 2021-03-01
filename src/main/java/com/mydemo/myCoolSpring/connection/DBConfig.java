package com.mydemo.myCoolSpring.connection;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InjectionPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

@Configuration
public class DBConfig {

    @Autowired
    private Environment env;

    @Bean(name = "employee-named-param-jdbc")
    public NamedParameterJdbcTemplate namedParameterJdbcTemplate(@Qualifier("employee-datasource") DataSource dataSource) throws PropertyVetoException {
        return new NamedParameterJdbcTemplate(dataSource);
    }

    @Bean(name = "employee-trasc-mgr")
    public DataSourceTransactionManager dataSourceTransactionManager(@Qualifier("employee-datasource") DataSource dataSource) throws PropertyVetoException {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "employee-datasource")
    public DataSource popsaxonyDataSource() {

        HikariConfig config = new HikariConfig();

        config.setJdbcUrl(env.getProperty("employee.jdbc.url"));
        config.setUsername(env.getProperty("employee.jdbc.user"));
        config.setPassword(env.getProperty("employee.jdbc.pass"));
        config.setMaximumPoolSize(Integer.parseInt(env.getProperty("employee.jdbc.connectionPool")));
        //config.setMaxLifetime(1800000);
        config.setLeakDetectionThreshold(120000);
//        config.addDataSourceProperty("oracle.jdbc.timezoneAsRegion","false");
        return new HikariDataSource(config);
    }

    @Bean
    @ConditionalOnMissingBean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public Logger logger(InjectionPoint injectionPoint) {
        return LoggerFactory.getLogger(injectionPoint.getMember().getDeclaringClass().getName());
    }
}

