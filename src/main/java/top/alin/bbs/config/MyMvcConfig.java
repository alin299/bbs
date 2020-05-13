package top.alin.bbs.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/login.html").setViewName("login");

        registry.addViewController("/index.html").setViewName("index");
        registry.addViewController("/admin/list.html").setViewName("admin/list");
        registry.addViewController("/admin/add.html").setViewName("admin/add");
        registry.addViewController("/user/save").setViewName("admin/add");
    }

    //登录拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/","/login.html","/user/login","/css/**","/fonts/**","/js/**","/images/**","/lib/**");
    }
}
