package com.myth.test;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 
 * 
*<p> Title: SocketTest  </p>
*<p> Description: 
*	自定义实现Tomcat的启动类.
*</p>
*<p> Copyright: Copyright (c) 2018</p>  
*<p> Company: myth</p>  
* @author myth
* @date 2018年10月31日  
* @version v1.0
 */
public class SocketTest {
	
	
	public static void main(String[] args) throws Exception {
		
		ServerSocket serverSocket = new ServerSocket(8081);
		while(true) {
			Socket socket = serverSocket.accept();
			System.out.println("接收到请求.....");
			InputStream in = socket.getInputStream();
			
			byte[] bytes = new byte[1024];
			int len = 0;
			String msg = "";
			/*while( (len = (in.read(bytes))) != -1) {
				System.out.println(len);
				msg += new String(bytes, 0, len);
			}*/
			if( (len = (in.read(bytes))) != -1) {
				System.out.println(len);
				msg += new String(bytes, 0, len);
			}
			System.out.println(msg);
		}
		
	}
}
