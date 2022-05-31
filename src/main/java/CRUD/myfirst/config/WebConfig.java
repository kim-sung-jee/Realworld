package CRUD.myfirst.config;

import CRUD.myfirst.interceptor.AdminCheckInterceptor;
import CRUD.myfirst.interceptor.LoginCheckInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 여기서 먼저 걸렸다...
        // excludePathPatterns 에 추가해 줘야 한다!
        registry.addInterceptor(new LoginCheckInterceptor())
                .order(1)
                .addPathPatterns("/**")
                .excludePathPatterns("/login","/","/logout","/admin","/join","/joinDo","/books/addbooks","books/addbook");


        registry.addInterceptor(new AdminCheckInterceptor())
                .order(2)
                .addPathPatterns("/books/addbooks","/books/addbook");

    }
}
