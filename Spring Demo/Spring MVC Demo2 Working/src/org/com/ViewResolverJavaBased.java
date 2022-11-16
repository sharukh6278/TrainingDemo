package org.com;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Component
public class ViewResolverJavaBased {
	@Bean
	public ViewResolver viewResolver(){
	   InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
	   viewResolver.setPrefix("/WEB-INF/jsp/");
	   viewResolver.setSuffix(".jsp");
	   return viewResolver;
	}
}

