package com.cornelius.util;

/**
 * ʱ�乤��
 * @author wxk
 *
 */
public class DateUtil {

	/**
	 * ��ȡ��ǰʱ������룩
	 * @return
	 */
	public static Integer getCurrentTime(){
		return new Long(System.currentTimeMillis() / 1000).intValue();
	}
}
