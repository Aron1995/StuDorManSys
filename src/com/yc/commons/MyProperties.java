package com.yc.commons;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 自定义一个MyProperties类继承Properties，当前类拥有Properties公共属性和方法
 * 整个系统只要创建一个对象
 * 设计成单例模式
 */

@SuppressWarnings("serial")
public class MyProperties extends Properties{
	private static MyProperties myProperties;
	
	private MyProperties() throws IOException{
		InputStream in =MyProperties.class.getClassLoader().getResourceAsStream("db.properties");
		this.load(in);
	}
	
	public static MyProperties getInstance() throws IOException {
		if(null==myProperties){
			myProperties = new MyProperties();
		}
		return myProperties;
	}
}
