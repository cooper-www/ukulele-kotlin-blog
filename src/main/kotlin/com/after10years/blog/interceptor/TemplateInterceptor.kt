package com.after10years.blog.interceptor

import org.springframework.stereotype.Component
import org.springframework.web.method.HandlerMethod
import org.springframework.web.servlet.ModelAndView
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Component
class TemplateInterceptor : HandlerInterceptorAdapter() {

    override fun postHandle(request: HttpServletRequest?, response: HttpServletResponse?, handler: Any?, modelAndView: ModelAndView?) {
        val hm = handler as HandlerMethod
        //以controller前缀作为模板文件夹名
        if (modelAndView?.viewName.isNullOrBlank()){
            val controllerName = hm.beanType.simpleName.replace("Controller","").toLowerCase()
            //如果modelAndView对象里边没有viewName则以action名作为模板名
            val actionName = hm.method.name
            modelAndView?.viewName = controllerName+"/"+actionName
        }
        super.postHandle(request, response, handler, modelAndView)
    }
}