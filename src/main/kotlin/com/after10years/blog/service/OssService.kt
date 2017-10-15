package com.after10years.blog.service

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class OssService(@Value("\${oss.read-domain}")val objectReadDomain : String) {

    fun getObjectLink(key : String):String{
        return objectReadDomain+key
    }
}