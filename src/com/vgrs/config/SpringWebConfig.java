package com.vgrs.config;

import java.sql.SQLException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.vgrs.dao.AccountDAO;
import com.vgrs.dao.impl.SQLAccountDAO;

@EnableWebMvc
@Configuration
@ComponentScan({ "com.vgrs.controller" })
@Import({ SpringSecurityConfig.class })
public class SpringWebConfig extends WebMvcConfigurerAdapter {

	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/jsp/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	
	@Bean
	public AccountDAO accountDAO() {
		try {
			return new SQLAccountDAO();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}