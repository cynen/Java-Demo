package com.myth.config;
/**
 * 
*<p> Title: ServletMapping  </p>
*<p> Description: 
*	做映射处理的.POJO类.
*</p>
*<p> Copyright: Copyright (c) 2018</p>  
*<p> Company: myth</p>  
* @author myth
* @date 2018年10月23日  
* @version v1.0
 */
public class ServletMapping {
	private String servletName;
	private String url;
	private String clazz;
	public String getServletName() {
		return servletName;
	}
	public void setServletName(String servletName) {
		this.servletName = servletName;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getClazz() {
		return clazz;
	}
	public void setClazz(String clazz) {
		this.clazz = clazz;
	}
	public ServletMapping(String servletName, String url, String clazz) {
		super();
		this.servletName = servletName;
		this.url = url;
		this.clazz = clazz;
	}
	public ServletMapping() {
		super();
	}
	
	
}
