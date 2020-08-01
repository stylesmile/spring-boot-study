//package com.futve.common.interceptor;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@Configuration
//public class AppConfig implements WebMvcConfigurer {
//
//    @Autowired
//    private AppInterceptor appInterceptor;
//
//    /**
//     * interceptor配置
//     */
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(appInterceptor)
//                // 添加需要验证登录用户操作权限的请求
//                .addPathPatterns("/**")
//                // 排除不需要验证登录用户操作权限的请求
//                .excludePathPatterns("/art/dictionary/**")
//                //.excludePathPatterns("/art/textTasks/updateTextTaskCount")
//                .excludePathPatterns("/art//dictionary/getList")
//                .excludePathPatterns("/css/**").excludePathPatterns("/js/**").excludePathPatterns("/images/**")
//                .excludePathPatterns("/art/swagger-resources/**", "/art/webjars/**", "/art/v2/**", "/art/swagger-ui.html/**");
//    }
//    /**
//     * 静态资源配置
//     */
//    /*
//     * @Override public void addResourceHandlers(ResourceHandlerRegistry registry) {
//     * registry.addResourceHandler("/img/**")
//     * .addResourceLocations("classpath:/imgs/");
//     *
//     * super.addResourceHandlers(registry); }
//     */
//
////	/**
////	 * 默认首页配置
////	 */
////	@Override
////	public void addViewControllers(ViewControllerRegistry registry) {
////		registry.addViewController("/").setViewName("forward:/index");
////		registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
////		super.addViewControllers(registry);
////	}
////
//
//}
