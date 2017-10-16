package com.after10years.blog.service

import com.after10years.blog.mapper.ModuleMapper
import com.after10years.blog.model.ModuleModel
import org.springframework.stereotype.Service

@Service
class ModuleService(val moduleMapper: ModuleMapper) {

    fun getModuleList(pid : Int) : List<ModuleModel>{
        return moduleMapper.getListByPid(pid)
    }


    //根据评论热度获取模块列表
    fun getModuleListByCommentHot(limit : Int):List<ModuleModel>{
        return moduleMapper.getListByCommentHot(limit)
    }
}