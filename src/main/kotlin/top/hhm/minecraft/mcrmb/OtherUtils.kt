package top.hhm.minecraft.mcrmb

/**
 * Project MCRMB-API
 *
 * @author hhm-GrowZheng
 * @createDate 2020/2/28 22:17
 */
import java.security.MessageDigest

fun String.doMD5(): String {
    val md = MessageDigest.getInstance("MD5")
    md.update(toByteArray())
    val b = md.digest()
    var i: Int
    val sb = StringBuffer("")
    for (offset in b.indices) {
        i = b[offset].toInt()
        if (i < 0) i += 256
        if (i < 16) sb.append("0")
        sb.append(Integer.toHexString(i))
    }
    return sb.toString()
}