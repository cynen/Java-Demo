package com.myth.servlet;

import com.myth.rr.MyRequest;
import com.myth.rr.MyResponse;

public abstract class MyServlet {
	public abstract void doGet(MyRequest request,MyResponse response) ;
	public abstract void doPost(MyRequest request,MyResponse response);
	
	public void service(MyRequest request,MyResponse response) throws Exception {
		System.out.println("准备调用service方法...");
		if ("POST".equals(request.getMethod())) {
			doPost(request, response);
		}else if("GET".equals(request.getMethod())){
			doGet(request, response);
		}
	}
}
