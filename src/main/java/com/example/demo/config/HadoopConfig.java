package com.example.demo.config;

import com.alibaba.druid.pool.DruidDataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * @author liuxiaokun
 * @version 1.0
 * @since 2020年8月5日
 */
@Configuration
@Slf4j
public class HadoopConfig {

    @Autowired
    private Environment env;

    @Bean(name = "hadoopDataSource")
    @Qualifier("hadoopDataSource")
    public DataSource hadoopDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(env.getProperty("hadoop.url"));
        dataSource.setDriverClassName(env.getProperty("hadoop.driver-class-name"));
        dataSource.setUsername("");
        dataSource.setPassword("");
        dataSource.setDefaultAutoCommit(true);
        return dataSource;
    }

    @Bean(name = "hadoopJdbcTemplate")
    public JdbcTemplate hadoopJdbcTemplate(
            @Qualifier("hadoopDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
