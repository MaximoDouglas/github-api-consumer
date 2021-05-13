package com.maximo.douglas.githubconsumer.testutils

object FileUtils {

    @JvmStatic
    fun getJsonFromFile(path: String): String {
        val url = this.javaClass.classLoader?.getResource(path)
        return String(url?.readBytes()!!)
    }
    
}