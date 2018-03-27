package com.github.xc145214.ajaxCors;

import com.github.xc145214.ajaxCors.web.CrosFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import java.util.logging.Filter;

/**
 * Hello world!
 *
 * @author xiachuan
 */
@SpringBootApplication
public class AjaxserverApplication {
    public static void main(String[] args) {
        SpringApplication.run(AjaxserverApplication.class, args);
    }

    /**
     * 配置过滤器
     * @return
     */
    @Bean
    public FilterRegistrationBean registerFilter() {

        FilterRegistrationBean bean = new FilterRegistrationBean();

        bean.addUrlPatterns("/*");
        bean.setFilter(new CrosFilter());

        return bean;
    }
}
