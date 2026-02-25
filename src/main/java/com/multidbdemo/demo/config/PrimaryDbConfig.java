package com.multidbdemo.demo.config; 

import java.util.HashMap;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = {"com.multidbdemo.demo.repository.primary"}, 
        transactionManagerRef = "primaryTransactionManager",
        entityManagerFactoryRef = "primaryEntityManagerFactory"
)
@Profile("!test")
public class PrimaryDbConfig {

    @Bean(name="db1")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.primary") 
    public DataSource dataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean("primaryEntityManagerFactory")
    @Primary
    public LocalContainerEntityManagerFactoryBean getEntityManagerBean(EntityManagerFactoryBuilder builder, @Qualifier("db1") DataSource dataSource){
        HashMap<String,String> prop = new HashMap<>();
        prop.put("hibernate.dialect","org.hibernate.dialect.PostgreSQLDialect");
        
        return builder.dataSource(dataSource)
                .properties(prop)
                .packages("com.multidbdemo.demo.model.primary")
                .build();
    }

    @Bean("primaryTransactionManager")
    @Primary
    public PlatformTransactionManager getTransactionManager(@Qualifier("primaryEntityManagerFactory") EntityManagerFactory factory){
        return new JpaTransactionManager(factory);
    }
}