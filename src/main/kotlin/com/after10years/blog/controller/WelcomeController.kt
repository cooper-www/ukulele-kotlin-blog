package com.after10years.blog.controller

import com.after10years.blog.service.ModuleService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.servlet.ModelAndView

@Controller
class WelcomeController(val moduleService: ModuleService) {

    @GetMapping("/")
    fun index() : ModelAndView {
        val navModules = moduleService.getModuleList(0)
        val mav = ModelAndView()
        mav.addObject("navModules",navModules)
        //查询热度前5名的模块，!!!注意没有任何评论过时模块不显示
        val hotModules = moduleService.getModuleListByCommentHot(5)
        mav.addObject("hotModules",hotModules)
        //获取轮播图
        return mav
    }


    @GetMapping("/test")
    fun test() : ModelAndView{
        return ModelAndView("welcome/test")
    }

    @GetMapping("/test/users")
    @ResponseBody
    fun testUsers():List<Map<String,Any>>{
        var users : List<Map<String,Any>> = ArrayList()
        for (i in 1..10){
            var user = HashMap<String,Any>()
            user["s"] = 1

        }
    }
}