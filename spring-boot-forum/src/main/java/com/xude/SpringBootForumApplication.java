package com.xude;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

// 也可以在配置类上用这个注解来扫描所有的mapper文件
// 但本项目本着学习的原则，选择在每一个mapper类上添加@mapper注解
//@MapperScan("com.xude.persistence.dao")
@EnableAsync
@SpringBootApplication
public class SpringBootForumApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootForumApplication.class, args);
	}

	@Bean
	public LocaleResolver localeResolver() {
		SessionLocaleResolver sessionLocaleResolver = new SessionLocaleResolver();
		sessionLocaleResolver.setDefaultLocale(Locale.CHINA);
		return sessionLocaleResolver;
	}

}
//@EnableAsync
//@SpringBootApplication
//public class SpringBootForumApplication extends SpringBootServletInitializer {
//
//	public static void main(String[] args) {
//		SpringApplication.run(SpringBootForumApplication.class, args);
//	}
//
//	@Override
//	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
//		return builder.sources(SpringBootForumApplication.class);
//	}
//
//		@Bean
//	public LocaleResolver localeResolver() {
//		SessionLocaleResolver sessionLocaleResolver = new SessionLocaleResolver();
//		sessionLocaleResolver.setDefaultLocale(Locale.CHINA);
//		return sessionLocaleResolver;
//	}
//}
