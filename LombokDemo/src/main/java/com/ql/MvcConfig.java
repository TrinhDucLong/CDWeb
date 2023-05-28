package com.ql;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// TODO Auto-generated method stub
		exposeDirectory("uploads", registry);
	}

	public void exposeDirectory(String dirName, ResourceHandlerRegistry registry) {
		// chuyen chuoi thanh dg dan
		Path uploadDir = Paths.get(dirName);

		/**
		 * lay ra dg dan cua file trong may E:\ CDW\ BC\ LombokDemo\ uploads
		 */

		String uploadPath = uploadDir.toFile().getAbsolutePath();

		if (dirName.startsWith("../")) {
			dirName = dirName.replace("../", "");

		}
		// /uploads/1.jpn ->E:\CDW\BC\LombokDemo\ uploads/1.jpn
		registry.addResourceHandler("/" + dirName + "/**").addResourceLocations("file:/" + uploadPath + "/");
	}
//
//	@Bean(name = "localeResolver")
//	public LocaleResolver getLocaleResolver() {
//		CookieLocaleResolver resolver = new CookieLocaleResolver();
//		// md la viet nam
//		resolver.setDefaultLocale(new Locale("vi"));
//		return resolver;
//	}
//
//	@Bean
//	public LocaleChangeInterceptor localeChangeInterceptor() {
//		LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
//		// bien de hien thi ngon ngu muon dc hieu thi
//		lci.setParamName("lang");
//		return lci;
//	}
//
//	@Override
//	public void addInterceptors(InterceptorRegistry registry) {
//		registry.addInterceptor(localeChangeInterceptor());
//	}
//
//	@Bean(name = "messageSource")
//	public MessageSource getMessageResource() {
//		ReloadableResourceBundleMessageSource messageResource = new ReloadableResourceBundleMessageSource();
//
//		// Đọc vào file messages_xxx.properties
//		// Ví dụ: messages_en.properties
//		messageResource.setBasename("message/message");
//		messageResource.setDefaultEncoding("UTF-8");
//		return messageResource;
//	}

}
