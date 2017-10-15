package com.after10years.blog.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.servlet.ModelAndView

@Controller
class WelcomeController {

    @GetMapping("/")
    fun index() : ModelAndView {
        val mav = ModelAndView()

        //获取轮播图

        return mav
    }
}