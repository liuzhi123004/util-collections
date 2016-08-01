package com.util.core;

import java.util.UUID;
import java.util.function.IntSupplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SecretUtil {
	
	private static final int KEYBORD_USERD_START = 33;
	
	private static final int KEYBORD_USERD_END = 127;
	
	private static final int KEYBORD_USERD_LENGTH = KEYBORD_USERD_END-KEYBORD_USERD_START;

	private static final int CHINESE_USED_START = (int)'\u4e00';
	
	private static final int CHINESE_USED_END = (int)'\u9fa5';
	
	private static final int CHINESE_USERD_LENGTH = CHINESE_USED_END-CHINESE_USED_START;
	
	public static final char[] KEYBORD_USED_CHARACTERSET = new char[KEYBORD_USERD_LENGTH];
	
	public static final char[] CHINESE_USED_CHARACTERSET = new char[KEYBORD_USERD_LENGTH+CHINESE_USERD_LENGTH];

	static{
		int count = 0;
		for (int i = KEYBORD_USERD_START; i < KEYBORD_USERD_END; i++) {
			KEYBORD_USED_CHARACTERSET[count] = (char)i;
			CHINESE_USED_CHARACTERSET[count] = (char)i;
			count++;
		}
		for (int i = CHINESE_USED_START; i < CHINESE_USED_END; i++) {
			CHINESE_USED_CHARACTERSET[count++] = (char)i;
		}
	}

	//获取UUID
	public static String getRandomUUID(){
		return UUID.randomUUID().toString();
	}
	
	//默认生成随机密码
	public static String defaultGenRandomPass(int passLen){
		return IntStream.generate(new IntSupplier() {
					public int getAsInt() {
						return (int)(Math.random()*KEYBORD_USERD_LENGTH);
					}
				}).mapToObj(each->Character.toString(KEYBORD_USED_CHARACTERSET[each]))
				.limit(passLen)
				.collect(Collectors.joining());
	}
	
}
