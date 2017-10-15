package com.after10years.blog.config

import org.springframework.context.annotation.Configuration
import org.beetl.ext.spring.BeetlSpringViewResolver
import org.beetl.ext.spring.BeetlGroupUtilConfiguration
import java.io.IOException
import org.beetl.core.resource.WebAppResourceLoader
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.core.io.DefaultResourceLoader
import org.springframework.core.io.support.ResourcePatternUtils
import org.springframework.context.annotation.PropertySource

@Configuration
@PropertySource(value = "classpath:/config/beetl.properties")
class BeetlTplConfig {

    @Value("\${beetl.templatesPath}")
    private val templatesPath: String? = null//模板根目录


    @Bean(initMethod = "init")
    fun getBeetlGroupUtilConfiguration(): BeetlGroupUtilConfiguration {

        val beetlGroupUtilConfiguration = BeetlGroupUtilConfiguration()
        val patternResolver = ResourcePatternUtils.getResourcePatternResolver(DefaultResourceLoader())
        // WebAppResourceLoader 配置root路径是关键
        val webAppResourceLoader = WebAppResourceLoader(patternResolver.getResource(this.templatesPath!!).file.path)
        beetlGroupUtilConfiguration.setResourceLoader(webAppResourceLoader)
        //读取配置文件信息
        beetlGroupUtilConfiguration.setConfigFileResource(patternResolver.getResource("classpath:config/beetl.properties"))
        return beetlGroupUtilConfiguration
    }

    @Bean(name = arrayOf("beetlViewResolver"))
    fun getBeetlSpringViewResolver(@Autowired beetlGroupUtilConfiguration: BeetlGroupUtilConfiguration): BeetlSpringViewResolver {
        val beetlSpringViewResolver = BeetlSpringViewResolver()
        beetlSpringViewResolver.setPrefix("/")
        beetlSpringViewResolver.setSuffix(".html")
        beetlSpringViewResolver.setContentType("text/html;charset=UTF-8")
        beetlSpringViewResolver.order = 0
        beetlSpringViewResolver.config = beetlGroupUtilConfiguration
        return beetlSpringViewResolver
    }

}