package top.hhm.minecraft.mcrmb

import com.alibaba.fastjson.JSON
import com.alibaba.fastjson.JSONObject
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


/**
 * Project MCRMB-API
 *
 * @author hhm-GrowZheng
 * @createDate 2020/2/28 22:10
 */
object MinecraftRMBUtils {
    private var MCRMB_SID = ""
    private var MCRMB_KEY = ""

    fun init(sid: String, key: String) {
        MCRMB_KEY = key
        MCRMB_SID = sid
    }

    /**
     * MCRMB-获取玩家点券<br></br>
     *
     * @param player String 玩家名字<br></br>
     * @param callback (data: JSONObject, otherParams: Map<Any, Any>) -> Unit 回调方法,data为返回数据,otherParams为调用时提供的其他参数
     * @param otherParams Map<Any, Any> 回调方法其他参数<br></br>
     */
    suspend fun getPoint(player: String, callback: (data: JSONObject, otherParams: Map<Any, Any>) -> Unit, otherParams: Map<Any, Any>) {
        GlobalScope.launch {
            callback(JSON.parseObject(HTTPUtils.asyncGet("http://www.mcrmb.com/Api/CheckMoney?sign=" + (MCRMB_SID + player + MCRMB_KEY).doMD5() + "&sid=" + MCRMB_SID + "&wname=$player")), otherParams)
        }
    }

    /**
     * MCRMB-增加玩家点券<br></br>
     *
     * @param player String 玩家名字<br></br>
     * @param money Int 数量<br></br>
     * @param reason String 原因<br></br>
     * @param callback (data: JSONObject, otherParams: Map<Any, Any>) -> Unit 回调方法,data为返回数据,otherParams为调用时提供的其他参数<br></br>
     * @param otherParams Map<Any, Any> 回调方法其他参数
     */
    suspend fun addMoney(player: String, money: Int, reason: String, callback: (data: JSONObject, otherParams: Map<Any, Any>) -> Unit, otherParams: Map<Any, Any>) {
        GlobalScope.launch {
            callback(JSON.parseObject(HTTPUtils.asyncGet("http://www.mcrmb.com/Api/Manual?sign=" + (MCRMB_SID + player + 1 + reason + money + MCRMB_KEY).doMD5() + "&sid=" + MCRMB_SID + "&wname=$player&type=1&text=$reason&money=$money")), otherParams)
        }
    }

    /**
     * MCRMB-减少玩家点券数量<br></br>
     *
     * @param player String 玩家名字<br></br>
     * @param money Int 数量<br></br>
     * @param reason String 原因<br></br>
     * @param callback (data: JSONObject, otherParams: Map<Any, Any>) -> Unit 回调方法,data为返回数据,otherParams为调用时提供的其他参数<br></br>
     * @param otherParams Map<Any, Any> 回调方法其他参数
     */
    suspend fun reduceMoney(player: String, money: Int, reason: String, callback: (data: JSONObject, otherParams: Map<Any, Any>) -> Unit, otherParams: Map<Any, Any>) {
        GlobalScope.launch {
            callback(JSON.parseObject(HTTPUtils.asyncGet("http://www.mcrmb.com/Api/Manual?sign=" + (MCRMB_SID + player + 2 + reason + money + MCRMB_KEY).doMD5() + "&sid=" + MCRMB_SID + "&wname=$player&type=2&text=$reason&money=$money")), otherParams)
        }
    }

    /**
     * MCRMB-设置玩家点券数量<br></br>
     *
     * @param player String 玩家名字<br></br>
     * @param money Int 数量<br></br>
     * @param reason String 原因<br></br>
     * @param callback (data: JSONObject, otherParams: Map<Any, Any>) -> Unit 回调方法,data为返回数据,otherParams为调用时提供的其他参数<br></br>
     * @param otherParams Map<Any, Any> 回调方法其他参数
     */
    suspend fun setMoney(player: String, money: Int, reason: String, callback: (data: JSONObject, otherParams: Map<Any, Any>) -> Unit, otherParams: Map<Any, Any>) {
        GlobalScope.launch {
            callback(JSON.parseObject(HTTPUtils.asyncGet("http://www.mcrmb.com/Api/Manual?sign=" + (MCRMB_SID + player + 3 + reason + money + MCRMB_KEY).doMD5() + "&sid=" + MCRMB_SID + "&wname=$player&type=3&text=$reason&money=$money")), otherParams)
        }
    }

    /**
     * MCRMB-玩家支付接口<br></br>
     *
     * @param player String 玩家名字<br></br>
     * @param money Int 数量<br></br>
     * @param reason String 原因<br></br>
     * @param callback (data: JSONObject, otherParams: Map<Any, Any>) -> Unit 回调方法,data为返回数据,otherParams为调用时提供的其他参数<br></br>
     * @param otherParams Map<Any, Any> 回调方法其他参数
     */
    suspend fun pay(player: String, money: Int, reason: String, callback: (data: JSONObject, otherParams: Map<Any, Any>) -> Unit, otherParams: Map<Any, Any>) {
        GlobalScope.launch {
            callback(JSON.parseObject(HTTPUtils.asyncGet("http://www.mcrmb.com/Api/Pay?sign=" + (MCRMB_SID + player + reason + money + MCRMB_KEY).doMD5() + "&sid=" + MCRMB_SID + "&wname=$player&use=$reason&money=$money")), otherParams)
        }
    }
}