package com.after10years.blog.controller

import com.after10years.blog.service.ModuleService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.servlet.ModelAndView

@Controller
class WelcomeController(val moduleService: ModuleService) {

    @GetMapping("/")
    fun index() : ModelAndView {
        val navModules = moduleService.getModuleList(0)
        val mav = ModelAndView()
        mav.addObject("navModules",navModules)
        //获取轮播图
        return mav
    }
}