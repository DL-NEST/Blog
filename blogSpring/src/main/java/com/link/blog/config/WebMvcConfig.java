package com.link.blog.config;

import com.link.blog.filter.MessageFilter;
import com.link.blog.filter.ArticleFilter;
import com.link.blog.filter.UserFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @apiNote webmvc配置
 * @author dl-nest
 * @date 2021/11/25 17:46
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {

    @Bean
    public UserFilter getUserFilter() {
        return new UserFilter();
    }
    @Bean
    public MessageFilter getMessageFilter() {
        return new MessageFilter();
    }
    @Bean
    public ArticleFilter getArticleFilter() {
        return new ArticleFilter();
    }
    /**
      * @apiNote 注册拦截器  asList（拦截列表）
      * @author dl-nest
      * @date 2021/11/25 17:46
     */
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        super.addInterceptors(registry);
        //List<String> asList = Arrays.asList("/user/**", "/cs/login");
        //注册用户拦截器
        registry.addInterceptor(getUserFilter())
                .addPathPatterns("/user/**")    //拦截
                .excludePathPatterns("/user/login","/user/cvv","/user/signUp");  //除去
        //注册留言拦截器
        registry.addInterceptor(getMessageFilter()).addPathPatterns("/dev/**");
        //注册文章数据拦截器
        registry.addInterceptor(getArticleFilter()).addPathPatterns("/Rf/**");
    }

    @Bean
    public HttpMessageConverter<String> responseBodyStringConverter() {
        StringHttpMessageConverter converter = new StringHttpMessageConverter(StandardCharsets.UTF_8);
        return converter;
    }

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        List<StringHttpMessageConverter> stringHttpMessageConverters = converters.stream()
                .filter(converter -> converter.getClass().equals(StringHttpMessageConverter.class))
                .map(converter -> (StringHttpMessageConverter) converter)
                .collect(Collectors.toList());

        if (stringHttpMessageConverters.isEmpty()) {
            converters.add(responseBodyStringConverter());
        } else {
            stringHttpMessageConverters.forEach(converter -> converter.setDefaultCharset(StandardCharsets.UTF_8));
        }
    }

    @Deprecated
    public static final String APPLICATION_JSON_UTF8_VALUE = "application/json;charset=UTF-8";
}