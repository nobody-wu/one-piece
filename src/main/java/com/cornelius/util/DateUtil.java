package com.cornelius.util;

/**
 * 时间工具
 * @author wxk
 *
 */
public class DateUtil {

	/**
	 * 获取当前时间戳（秒）
	 * @return
	 */
	public static Integer getCurrentTime(){
		return new Long(System.currentTimeMillis() / 1000).intValue();
	}
}
