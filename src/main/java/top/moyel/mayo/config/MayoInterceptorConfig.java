package top.moyel.mayo.config;

import cn.dev33.satoken.interceptor.SaInterceptor;
import cn.dev33.satoken.stp.StpUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author moyel
 */
@Configuration
@RequiredArgsConstructor
public class MayoInterceptorConfig implements WebMvcConfigurer {
    private final MayoRecordInterceptor mayoRecordInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(mayoRecordInterceptor).addPathPatterns("/**");
        registry.addInterceptor(new SaInterceptor(handle -> StpUtil.checkLogin())).addPathPatterns("/**")
                .excludePathPatterns("/login");
    }

    @Bean
    public RepeatableRequestFilter repeatableRequestFilter() {
        return new RepeatableRequestFilter();
    }

    @Bean
    public FilterRegistrationBean<RepeatableRequestFilter> filterRegistration(RepeatableRequestFilter repeatableRequestFilter) {
        FilterRegistrationBean<RepeatableRequestFilter> filterRegistration = new FilterRegistrationBean<>();

        filterRegistration.setFilter(repeatableRequestFilter);
        filterRegistration.addUrlPatterns("/*");
        filterRegistration.setName("repeatableFilter");
        filterRegistration.setOrder(1);

        return filterRegistration;
    }
}
