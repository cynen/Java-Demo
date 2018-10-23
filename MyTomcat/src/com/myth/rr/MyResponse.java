package com.myth.rr;

import java.io.IOException;
import java.io.OutputStream;

/**
 * 自定义响应.
*<p> Title: MyResponse  </p>
*<p> Description: </p>
*<p> Copyright: Copyright (c) 2018</p>  
*<p> Company: myth</p>  
* @author myth
* @date 2018年10月23日  
* @version v1.0
 */
public class MyResponse {
	// 定义一个输出流
	private OutputStream outputStream;

	public MyResponse(OutputStream outputStream) {
		super();
		this.outputStream = outputStream;
	}
	// 输出数据的方法.
	public void write(String content) throws IOException{
		
		StringBuffer httpresponse = new StringBuffer();
		httpresponse.append("HTTP/1.1 200 OK\n")
			.append("Content-Type:text/html\n")
			.append("\r\n")
			.append("<html><body>")
			.append(content)
			.append("</body></html>");
		outputStream.write(httpresponse.toString().getBytes());
		outputStream.close();
	}
	
}
