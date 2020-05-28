package top.alin.bbs.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer  {

    @Override
    public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/login.html").setViewName("login");

        registry.addViewController("/index.html").setViewName("index");
        registry.addViewController("/user/list.html").setViewName("user/list");
        registry.addViewController("/user/view").setViewName("user/list");
        registry.addViewController("/user/add.html").setViewName("user/add");
        registry.addViewController("/user/save").setViewName("user/add");
        registry.addViewController("/user/edit.html").setViewName("user/edit");
        registry.addViewController("/user/edit").setViewName("user/edit");

        registry.addViewController("/role/list.html").setViewName("role/list");
        registry.addViewController("/role/view").setViewName("role/list");
        registry.addViewController("/role/add.html").setViewName("role/add");
        registry.addViewController("/role/save").setViewName("role/add");
        registry.addViewController("/role/edit.html").setViewName("role/edit");
        registry.addViewController("/role/edit").setViewName("role/edit");
    }
}
