package com.after10years.blog.mapper

import com.after10years.blog.model.ModuleModel
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Param

@Mapper
interface ModuleMapper {

    //获取列表
    fun getListByPid(@Param("pid") pid : Int) : List<ModuleModel>

    //获取单个
    fun getById(@Param("moduleId") moduleId : Int) : List<ModuleModel>


}