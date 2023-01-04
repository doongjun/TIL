package hello.exception

import hello.exception.filter.LogFilter
import hello.exception.interceptor.LogInterceptor
import org.springframework.boot.web.servlet.FilterRegistrationBean
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer
import javax.servlet.DispatcherType
import javax.servlet.Filter

@Configuration
class WebConfig: WebMvcConfigurer {
    override fun addInterceptors(registry: InterceptorRegistry) {
        registry.addInterceptor(LogInterceptor())
            .order(1)
            .addPathPatterns("/**")
            .excludePathPatterns(
                "/css/**", "/*.ico", "/error", "/error-page/**"
            )
    }

//    @Bean
    fun logFilter(): FilterRegistrationBean<Filter> {
        val filterRegistrationBean = FilterRegistrationBean<Filter>()
        filterRegistrationBean.filter = LogFilter()
        filterRegistrationBean.order = 1
        filterRegistrationBean.addUrlPatterns("/*")
        filterRegistrationBean.setDispatcherTypes(DispatcherType.REQUEST, DispatcherType.ERROR)
        return filterRegistrationBean
    }
}