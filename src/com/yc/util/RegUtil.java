package com.yc.util;

import java.util.Map;
import java.util.Map.Entry;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

public class RegUtil {
	//存入注册表中
	//HKEY_CURRENT_USER\Software\JavaSoft\Prefs\com\yc\...
	public void addRegester(Map<String,String> map){
		Preferences pfs= Preferences.userNodeForPackage(RegUtil.class);
		if(null!=map){
			for(Entry<String,String> entry:map.entrySet() ){
				pfs.put(entry.getKey(), entry.getValue());
			}
			try {
				pfs.flush();
			} catch (BackingStoreException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	//读取注册表
	public String getRegester(String key){
		Preferences pfs= Preferences.userNodeForPackage(RegUtil.class);
		return pfs.get(key,null);
	}
	
	//删除注册表
	public void deleteRegester(String key){
		Preferences pfs= Preferences.userNodeForPackage(RegUtil.class);
		pfs.remove(key);
	}
}
