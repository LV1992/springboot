package com.aliyunstudy.config;

import com.aliyunstudy.interceptor.CommonInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**注册拦截器
 * Created by lvyihang on 17/5/21.
 */
@Configuration
public class CommonInterceptorConfig extends WebMvcConfigurerAdapter{
    /**
     * 增加拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new CommonInterceptor()).addPathPatterns("/**");
    }
}
