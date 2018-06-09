package com.pritesh.us.api;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@PropertySource(value = "classpath:application.properties" )
public class JPAConf {

	@Autowired
	private Environment env;
	
	
	@Bean
	public LocalContainerEntityManagerFactoryBean emf()
	{
		LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
		emf.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		emf.setDataSource(getDataSource());
		emf.setPackagesToScan("com.pritesh.us.api.entity");
		emf.setJpaProperties(jpaProperties());
		return emf;
	}

	@Bean
	public DataSource getDataSource()
	{
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl(env.getProperty("db.url"));
		ds.setUsername(env.getProperty("db.username"));
		ds.setPassword(env.getProperty("db.password"));
		return ds;
	}
	
	@Bean
	public PlatformTransactionManager txn(EntityManagerFactory em)
	{
		JpaTransactionManager txnManager = new JpaTransactionManager(em);
		return txnManager;
	}
	
	@Bean
	public Properties jpaProperties()
	{
		Properties prop = new Properties();
		prop.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		prop.setProperty("hibernate.hbm2ddl.auto",env.getProperty("hibernate.hbm2ddl"));
		prop.setProperty("hibernate.show_sql",env.getProperty("hibernate.show_sql"));
		prop.setProperty("hibernate.format_sql",env.getProperty("hibernate.format_sql"));
		return prop;
	}
}

