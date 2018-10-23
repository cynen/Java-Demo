package com.myth.config;

import java.util.ArrayList;
import java.util.List;

/**
 * 配置具体的映射关系.
 * 
 * 我们在servlet开发中，
 * 会在web.xml中通过<servlet></servlet>
 * 和<servlet-mapping></servlet-mapping>
 * 来进行指定哪个URL交给哪个servlet进行处理。
*<p> Title: ServletConfig  </p>
*<p> Description: </p>
*<p> Copyright: Copyright (c) 2018</p>  
*<p> Company: myth</p>  
* @author myth
* @date 2018年10月23日  
* @version v1.0
 */
public class ServletConfig {
	
	public static List<ServletMapping> servletMappings = new ArrayList<>();
	static {
		servletMappings.add(new ServletMapping("first", "/first", "com.myth.servlet.FirstServlet"));
	//	servletMappings.add(new ServletMapping(servletName, url, clazz));
		
	}
	
}
