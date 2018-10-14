package com.icbc.myth;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class UploadFile extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//得到上传文件的保存目录，将上传的文件存放于WEB-INF目录下，不允许外界直接访问，保证上传文件的安全
		// String savePath = req.getS
		
		String savePath = req.getSession().getServletContext().getRealPath("/upload/");
		
		File savefile  = new File(savePath);
		if(!savefile.exists()) {
			savefile.mkdirs();
		}
		String msg = "";
		try {
			DiskFileItemFactory factory = new DiskFileItemFactory();
			
			ServletFileUpload upload = new ServletFileUpload(factory);
			
			upload.setHeaderEncoding("utf-8");
			
			if(!ServletFileUpload.isMultipartContent(req)) {
				// 不是文件上传组件.
				return ;
			}
			
			
			// 使用ServletFileUpload 解析请求.
			List<FileItem> list = upload.parseRequest(req);
			for (FileItem fileItem : list) {
				// 遍历上传文件对象.每一个item都是一个属性.
				if(fileItem.isFormField()) {
					// 是表单属性.
					System.out.println("属性名: "+fileItem.getFieldName());
					System.out.println("属性值: "+ fileItem.getString("utf-8"));
				}else {
					// 是文件对象,
					String filename = fileItem.getName();
					if(filename == null || filename == "") {
						continue;
					}
					System.out.println("文件名是 :" + filename);
					// 取后缀名.
					filename = filename.substring(filename.lastIndexOf("\\")+1);
					System.out.println(filename);
					
					
					InputStream in = fileItem.getInputStream();
					String filerealpath = savefile+"/"+filename;
					System.out.println("上传文件到 :" + filerealpath);
					FileOutputStream fos = new FileOutputStream(filerealpath);
					
					// 缓冲读取,写入.
					byte[] buffer = new byte[1024];
					int len = 0 ;
					//读取数据,循环读取
					while(true) {
						len = in.read(buffer);
						if(len == -1) {
							break;
						}
						
						fos.write(buffer, 0, len);
					}
					in.close();
					fos.close();
					fileItem.delete();
					msg = "上传文件成功";
					
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("文件上传失败.");
			msg = "失败";
		}
		
		// 向request域中存放消息,后续跳转页面的时候,可以拿到该消息.
		req.setAttribute("msg", msg);
		
		//resp.sendRedirect("/");
		
		// 通过request进行转发. 注意转发(应用内)和重定向(应用外)的区别.
		req.getRequestDispatcher("/msg.jsp").forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// super.doPost(req, resp);
		doGet(req, resp);
	}
	
	
	
	
}
