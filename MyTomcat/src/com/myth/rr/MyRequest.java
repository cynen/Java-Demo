package com.myth.rr;

import java.io.IOException;
import java.io.InputStream;

/**
 * 
*<p> Title: MyRequest  </p>
*<p> Description: 
*
*	自定义请求类.
*</p>
*<p> Copyright: Copyright (c) 2018</p>  
*<p> Company: myth</p>  
* @author myth
* @date 2018年10月23日  
* @version v1.0
 */
public class MyRequest {
	// 请求的url
	private String url;
	// 请求的方法.
	private String method;
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	
	// 自定义MyRequest对象的构造.
	public MyRequest(InputStream inputStream) throws IOException{
		String httprequest = "";
		byte[] bytes = new byte[1024];
		int len = 0;
		/*while((len = (inputStream.read(bytes))) != -1) {
			httprequest += new String(bytes, 0,len); 
			System.out.println(httprequest);
		}*/
		if ((len = inputStream.read(bytes)) > 0) {
			httprequest += new String(bytes, 0,len); 
		}
		// 解析.
		String httphead = httprequest.split("\\n")[0];
		method = httphead.split("\\s")[0];
		url = httphead.split("\\s")[1];
		
	}
	
	
	
	
	
}
