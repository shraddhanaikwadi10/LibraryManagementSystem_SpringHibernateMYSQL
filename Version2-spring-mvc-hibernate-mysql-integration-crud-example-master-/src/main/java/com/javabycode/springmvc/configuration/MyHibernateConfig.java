package com.javabycode.springmvc.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.javabycode.springmvc.model.Add_user_main;
import com.javabycode.springmvc.model.Book_details;
import com.javabycode.springmvc.model.Users;
import com.javabycode.springmvc.model.library_add_book_main;
import com.javabycode.springmvc.service.BookService;
import com.javabycode.springmvc.service.LoginService;
import com.javabycode.springmvc.service.RegistrationService;

@Configuration
@EnableTransactionManagement
@ComponentScan({ "com.javabycode.springmvc.configuration" })
@PropertySource(value = { "classpath:jdbc.properties" })
public class MyHibernateConfig {

    @Autowired
    private Environment environment;

   /* @Autowired
    @Bean(name = "sessionFactory")
    public SessionFactory getSessionFactory(DataSource dataSource) {
        LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
        sessionBuilder.addProperties(hibernateProperties());
        sessionBuilder.addAnnotatedClasses(Users.class);
        return sessionBuilder.buildSessionFactory();
    }*/
    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan(new String[] { "com.javabycode.springmvc.model" });
        sessionFactory.setHibernateProperties(hibernateProperties());
        return sessionFactory;
     }
	
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getRequiredProperty("jdbc.driverClassName"));
        dataSource.setUrl(environment.getRequiredProperty("jdbc.url"));
        dataSource.setUsername(environment.getRequiredProperty("jdbc.username"));
        dataSource.setPassword(environment.getRequiredProperty("jdbc.password"));
        return dataSource;
    }
    
    private Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));
        properties.put("hibernate.show_sql", environment.getRequiredProperty("hibernate.show_sql"));
        properties.put("hibernate.format_sql", environment.getRequiredProperty("hibernate.format_sql"));
        return properties;        
    }
    
	@Bean
    @Autowired
    public HibernateTransactionManager transactionManager(SessionFactory s) {
       HibernateTransactionManager txManager = new HibernateTransactionManager();
       txManager.setSessionFactory(s);
       return txManager;
    }
	

	@Bean
	public library_add_book_main getLibraryAddBookService() {
		return new library_add_book_main();
	}
	
	@Bean
	public Book_details getBookDetailsEntity() {
		return new Book_details();
	}
	
	@Bean
	public RegistrationService getRegistrationService() {
		return new RegistrationService();
	}
	
	@Bean
	public Users getUsers() {
		return new Users();
	}
	
	@Bean
	public Add_user_main getAdd_user_main() {
		return new Add_user_main();
	}
	
	
	
}

