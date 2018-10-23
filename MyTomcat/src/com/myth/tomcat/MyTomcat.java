package com.myth.tomcat;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

import com.myth.config.ServletConfig;
import com.myth.config.ServletMapping;
import com.myth.rr.MyRequest;
import com.myth.rr.MyResponse;
import com.myth.servlet.MyServlet;
import com.sun.xml.internal.ws.wsdl.writer.document.Port;

public class MyTomcat {
	private int port = 8080;
	
	private Map<String, String> urlservletmapping = new HashMap<>();
	
	public MyTomcat(int port) {
		this.port = port;
	}
	// 启动Tomcat
	public void start() {
		initServiceMapping();
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(port);
			System.out.println("Tomcat is ready to start...");
			while (true) {
				Socket socket = serverSocket.accept();
				System.out.println("接收到请求...");
				InputStream in = socket.getInputStream();
				OutputStream out = socket.getOutputStream();
				MyRequest request = new MyRequest(in);
				MyResponse response = new MyResponse(out);
				
				dispatch(request, response);
				// socket.close();
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			if (serverSocket != null) {
				try {
					serverSocket.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}
		
		
	}
	// 初始化
	public void initServiceMapping() {
		
		for (ServletMapping mapping:ServletConfig.servletMappings) {
			urlservletmapping.put(mapping.getUrl(), mapping.getClazz());
		}
		
	}
	// 分发
	public void dispatch(MyRequest request,MyResponse response) {
		System.out.println("准备分发...");
		String clazz = urlservletmapping.get(request.getUrl());
		try {
			Class<MyServlet> myclazz = (Class<MyServlet>) Class.forName(clazz);
			MyServlet servlet = myclazz.newInstance();
			servlet.service(request, response);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
	}
	// 启动
	public static void main(String[] args) {
		new MyTomcat(8080).start();
	}
}
