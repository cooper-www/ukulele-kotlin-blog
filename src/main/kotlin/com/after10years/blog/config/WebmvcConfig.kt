package com.after10years.blog.config

import com.after10years.blog.interceptor.TemplateInterceptor
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter

@Configuration
class WebmvcConfig(val templateInterceptor: TemplateInterceptor) : WebMvcConfigurerAdapter() {

    override fun addInterceptors(registry: InterceptorRegistry?) {
        registry?.addInterceptor(templateInterceptor)?.addPathPatterns("/**")
        super.addInterceptors(registry)
    }
}