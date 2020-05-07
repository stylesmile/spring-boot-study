package com.example.demo;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity()
public class SecurityConfig extends WebSecurityConfigurerAdapter {
      @Override
      protected void configure(HttpSecurity http) throws Exception {
         /**
         * .anyRequest() :全部拦截：配置权限
         */
        http.authorizeRequests().anyRequest().hasRole("USER")//权限ROLE_USER
                .and().formLogin().loginPage("/loginPage")//登录页面
                .loginProcessingUrl("/login")//登录请求（自带）
                .defaultSuccessUrl("/")//成功之后
                .failureUrl("/loginPage")//失败之后
                .permitAll()
                .and().exceptionHandling().accessDeniedPage("/accessdenied")//没有权限的页面
                .and().logout().logoutUrl("/logout")//登出(自带)
                .logoutSuccessUrl("/login").invalidateHttpSession(true); //登出之后的页面和清楚session
        http.rememberMe()//基于token的remember-me的认证
            .tokenValiditySeconds(604800);//token过期时间
        http.headers().frameOptions()//请求头
            .sameOrigin();//响应头
      }

      @Override
      protected void configure(AuthenticationManagerBuilder auth) throws Exception {
          auth
               .inMemoryAuthentication()
                    .withUser("admin")//用户名：admin
                         .password("123456")//密码：12346
                         .roles("USER");//权限ROLE_USER
      }
}