package com.ercan.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan(basePackages = "com.ercan")
@PropertySource("classpath:db.properties")
public class SpringConfig {

	@Autowired
	Environment environment;

	// define a bean for ViewResolver

	@Bean
	public ViewResolver viewResolver() {

		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");

		return viewResolver;

	}

	@SuppressWarnings("serial")
	Properties hibernateProperties1() {
		return new Properties() {
			{
				setProperty("hibernate.dialect", environment.getProperty("hibernate.dialect"));

				setProperty("hibernate.show_sql", environment.getProperty("hibernate.show_sql"));
			}
		};
	}

	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager txManager = new HibernateTransactionManager();
		txManager.setSessionFactory(sessionFactory);
		return txManager;
	}

	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setPackagesToScan(new String[] { "com.ercan.domain" });
		sessionFactory.setHibernateProperties(hibernateProperties1());
		return sessionFactory;
	}

	@Bean
	public DataSource dataSource() {
		// DriverManagerDataSource dataSource = new DriverManagerDataSource();
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		try {
			dataSource.setDriverClass(environment.getRequiredProperty("jdbc.driver"));
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}

		// dataSource.setDriverClassName(environment.getRequiredProperty("jdbc.driver"));
		dataSource.setJdbcUrl(environment.getRequiredProperty("jdbc.url"));
		dataSource.setUser(environment.getRequiredProperty("jdbc.user"));
		dataSource.setPassword(environment.getRequiredProperty("jdbc.password"));
		dataSource.setInitialPoolSize(Integer.parseInt(environment.getProperty("connection.pool.initialPoolSize")));
		dataSource.setMaxPoolSize(Integer.parseInt(environment.getProperty("connection.pool.maxPoolSize")));
		dataSource.setMinPoolSize(Integer.parseInt(environment.getProperty("connection.pool.minPoolSize")));

		return dataSource;
	}

	/*
	 * private Properties hibernateProperties() { Properties properties = new
	 * Properties(); properties.put("hibernate.dialect",
	 * environment.getRequiredProperty("hibernate.dialect"));
	 * properties.put("hibernate.show_sql",
	 * environment.getRequiredProperty("hibernate.show_sql"));
	 * properties.put("hibernate.format_sql",
	 * environment.getRequiredProperty("hibernate.format_sql")); return properties;
	 * }
	 */

}
