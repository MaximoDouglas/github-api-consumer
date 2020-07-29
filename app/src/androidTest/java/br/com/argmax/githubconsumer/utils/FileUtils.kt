package br.com.argmax.githubconsumer.utils

object FileUtils {

    @JvmStatic
    fun getJsonFromFile(path: String): String {
        val url = this.javaClass.classLoader?.getResource(path)
        return String(url?.readBytes()!!)
    }
    
}