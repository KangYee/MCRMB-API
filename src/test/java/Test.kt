import top.hhm.minecraft.mcrmb.MinecraftRMBUtils
import java.lang.Thread.sleep

/**
 * Project MCRMB-API
 *
 * @author hhm-GrowZheng
 * @createDate 2020/2/28 22:28
 */

suspend fun main(args: Array<String>) {
    MinecraftRMBUtils.getPoint("hhm", { data, _ -> println(data.toJSONString()) }, hashMapOf())
    sleep(50000)
}

object Test {
}