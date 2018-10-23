package com.myth.servlet;

import java.io.IOException;

import com.myth.rr.MyRequest;
import com.myth.rr.MyResponse;

public class FirstServlet extends MyServlet{

	@Override
	public void doGet(MyRequest request, MyResponse response){
		// TODO Auto-generated method stub
		try {
			response.write("GET Method....");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void doPost(MyRequest request, MyResponse response){
		// TODO Auto-generated method stub
		try {
			response.write("POST Method....");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
