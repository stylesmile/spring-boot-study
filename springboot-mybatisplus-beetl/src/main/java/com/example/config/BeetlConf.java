package com.example.config;

import com.ibeetl.starter.BeetlTemplateCustomize;
import org.beetl.core.GroupTemplate;
import org.beetl.core.resource.WebAppResourceLoader;
import org.beetl.ext.spring.BeetlGroupUtilConfiguration;
import org.beetl.ext.spring.BeetlSpringViewResolver;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternUtils;

import java.io.IOException;

@Configuration
public class BeetlConf {
        //Starter可以实现BeetlTemplateCustomize来定制Beetl
        @Bean
        public BeetlTemplateCustomize beetlTemplateCustomize(){
                return new BeetlTemplateCustomize(){
                        public void customize(GroupTemplate groupTemplate){

                        }
                };
        }
        //配置模板引擎
        @Bean(initMethod = "init", name = "beetlConfig")
        public BeetlGroupUtilConfiguration getBeetlGroupUtilConfiguration() {
                BeetlGroupUtilConfiguration beetlGroupUtilConfiguration = new BeetlGroupUtilConfiguration();
                ResourcePatternResolver patternResolver = ResourcePatternUtils.getResourcePatternResolver(new DefaultResourceLoader());
                try {
                        // WebAppResourceLoader 配置root路径是关键
                        WebAppResourceLoader webAppResourceLoader =
                                new WebAppResourceLoader(patternResolver.getResource("classpath:/").getFile().getPath());
                        beetlGroupUtilConfiguration.setResourceLoader(webAppResourceLoader);
                } catch (IOException e) {
                        e.printStackTrace();
                }
                //读取配置文件信息
                //beetlGroupUtilConfiguration.init();

                return beetlGroupUtilConfiguration;
        }

        @Bean(name = "beetlViewResolver")
        public BeetlSpringViewResolver getBeetlSpringViewResolver(@Qualifier("beetlConfig") BeetlGroupUtilConfiguration beetlGroupUtilConfiguration) {
                BeetlSpringViewResolver beetlSpringViewResolver = new BeetlSpringViewResolver();
                //beetlSpringViewResolver.setPrefix("WEB-INF/views/
                //html路径
                beetlSpringViewResolver.setPrefix("/templates/");
                //省略“.html”
                //beetlSpringViewResolver.setSuffix(".html");
                beetlSpringViewResolver.setContentType("text/html;charset=UTF-8");
                beetlSpringViewResolver.setOrder(0);
                beetlSpringViewResolver.setConfig(beetlGroupUtilConfiguration);
                return beetlSpringViewResolver;
        }


 }