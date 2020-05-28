package top.alin.bbs.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import top.alin.bbs.service.impl.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyAuthenticationSuccessHandler myAuthenticationSuccessHandler;
    @Autowired
    private MyAuthenticationFailHandler myAuthenticationFailHandler;
    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder(10));
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.headers().frameOptions().disable()//防止iframe
                .and().csrf().disable()//禁用了 csrf 功能
                .authorizeRequests()
                .antMatchers("/user/login","/css/**","/font/**","/images/**","/js/**","/lib/layui/**").permitAll()
                .antMatchers("/user/view","/user/search","/index.html").hasAnyRole("SUPERADMIN","ADMIN")
                .antMatchers("/user/save","/user/del","/role/save","/role/del","/role/edit").hasRole("SUPERADMIN")
                //.anyRequest().hasRole("ADMIN")
                .and().formLogin()
                .loginPage("/login.html")
                //这个url要跟登录页面的ajax中的url对应
                .loginProcessingUrl("/login")
                //自定义登录成功处理类
                .successHandler(myAuthenticationSuccessHandler)
                //自定义登录失败处理类
                .failureHandler(myAuthenticationFailHandler)
                .and().httpBasic();//启用http 基础验证
    }

}


