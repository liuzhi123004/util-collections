package com.util.core;

import java.util.Optional;

public class StringUtil{
	
	//处理字符串的null值,如果为null返回空
	public static String handleNullString(String str) {
		Optional<String> optional = Optional.ofNullable(str);
		return optional.map(String::toString).orElse("");
	}

}