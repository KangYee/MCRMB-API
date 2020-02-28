package top.hhm.minecraft.mcrmb

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.URL
import java.net.URLConnection


/**
 * Project MCRMB-API
 *
 * @author hhm-GrowZheng
 * @createDate 2020/2/28 22:11
 */
object HTTPUtils {
    suspend fun asyncGet(url: String): String = GlobalScope.async {
        return@async doGet(url)
    }.await()

    private fun doGet(url: String): String {
        val realUrl = URL(url)
        val connection: URLConnection = realUrl.openConnection()
        connection.setRequestProperty("accept", "*/*")
        connection.setRequestProperty("connection", "Keep-Alive")
        connection.setRequestProperty("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/52.0.2743.116 Safari/537.36 Edge/15.16199 java")
        connection.connect()
        val inb = BufferedReader(InputStreamReader(connection.getInputStream()))
        var line = inb.readLine()
        var result = ""
        while (line != null) {
            result += line
            line = inb.readLine()
        }
        return result
    }
}