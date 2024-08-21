package com.inetBanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class readConfig {
	
	Properties pro;
	public readConfig(){
		File src = new File("./Configuration/config.properties");
		
		
		try {
			FileInputStream fis = new FileInputStream(src) ; // can read values from file
			pro = new Properties();
			pro.load(fis);  //it will load config values by using fis
		} catch (IOException e) {
			System.out.println("Exception is : "+e.getMessage());
		}
	}
	public String getAppurl() {
		String url = pro.getProperty("url");  //getProperty method***
		return url;
	}
	public String getuserName() {
		String userName = pro.getProperty("userName");
		return userName;
	}
	public String getPassword() {
		String password = pro.getProperty("passWord");
		return password;
	}
}
