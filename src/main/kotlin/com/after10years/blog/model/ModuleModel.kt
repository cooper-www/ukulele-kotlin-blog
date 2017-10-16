package com.after10years.blog.model

import java.sql.Timestamp

class ModuleModel {

    var moduleId : Int? = null
    var uriRoute : String? = null
    var moduleName : String? = null
    var img : String? = null
    var pid : Int? = null
    var addTime : Timestamp? = null
    var commentCount : Int? = null
    override fun toString(): String {
        return "ModuleModel(moduleId=$moduleId, uriRoute=$uriRoute, moduleName=$moduleName, img=$img, pid=$pid, addTime=$addTime, commentCount=$commentCount)"
    }

}