package com.fyl.house.sms;

import java.util.HashMap;
import java.util.Map;

/**  
 * @Title: http://www.smschinese.cn/api.shtml
 * @date 2011-3-22
 * @version V1.2  
 */
public class SmsUtil {
	
	//用户名
	private static String Uid = "带带大师兄";
	
	//接口安全秘钥
	private static String Key = "d41d8cd98f00b204e980";
	


	/**
	 * 发送消息的方法
	 * @param tel 接收消息的手机号，支持群发，手机号用逗号隔开
	 * @param smsText 发送的信息
	 * @return
	 */
	public static int sendMsg(String tel,String smsText) {
		HttpClientUtil client = HttpClientUtil.getInstance();
		//UTF发送
		int result = client.sendMsgUtf8(Uid, Key, smsText, tel);
		return result;
	}
}
