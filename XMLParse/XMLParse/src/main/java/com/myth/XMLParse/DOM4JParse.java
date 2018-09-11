package com.myth.XMLParse;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.omg.CORBA.PUBLIC_MEMBER;
/**
 * 
 * 二、使用dom4j后程序变得更简单

// 字符串转XML
String xmlStr = "......";
Document document = DocumentHelper.parseText(xmlStr);

// XML转字符串 
Document document = ...;
String text = document.asXML();

这里的XML DOCUMENT为org.dom4j.Document

 * 
*<p> Title: DOM4JParse  </p>
*<p> Description: </p>
*<p> Copyright: Copyright (c) 2018</p>  
*<p> Company: myth</p>  
* @author myth
* @date 2018年9月12日  
* @version v1.0
 */
public class DOM4JParse {

	
	/**
	 * DOM4J解析xml
	 * <p>Description: </p>  
	 * @param src xml文档的路径.
	 * 	得到xml文件对应的资源，可以是xml的输入流，文件和uri
	 */
	public static void DOM4JParse(String src) {
		SAXReader reader = new SAXReader();
		try {
			// 读取文档
			Document document = reader.read(new File(src));
			// 解析根节点.
			Element bookstore = document.getRootElement();
			System.out.println("根节点:" + bookstore.getName());
			// 迭代根节点下的所有子节点
			Iterator it = bookstore.elementIterator();
			while (it.hasNext()) {
				Element book = (Element) it.next();
				System.out.println("当前节点名称:" + book.getName());
				listNodes(book);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	/**
	 * 遍历当前节点下的所有子节点
	 * <p>Description: </p>  
	 * @param node
	 */
	public static void listNodes(Element node) {
		// 节点名称,节点值.
		/**
		 * getText()
		 */
		System.out.println("当前节点的名称: "+ node.getName() + ", "+ node.getTextTrim());
		// 遍历属性 
		List<Attribute> listattrs = node.attributes();
		for (Attribute attribute : listattrs) {
			System.out.println("当前节点有属性: "+ attribute.getName() +  "属性值:" + attribute.getValue());
		}
		
		Iterator<Element> it = node.elementIterator();
		while (it.hasNext()) {
			Element element = it.next();
			listNodes(element);
		}
	}
	
	// 
	public static void modifyXML(String src) {
		SAXReader reader = new SAXReader();
		try {
			// 读取文档
			Document document = reader.read(new File(src));
			// 解析根节点.
			Element bookstore = document.getRootElement();
			System.out.println("根节点:" + bookstore.getName());
			// 迭代根节点下的所有子节点
			Iterator it = bookstore.elementIterator();

			while(it.hasNext()) {
				Element ele = (Element) it.next();
				if("flag".equals(ele.getName())) {
					System.out.println("flag 值为 :" + ele.getTextTrim());
					// 修改标签值.
					ele.setText("2");
				}
			}
			
			// listNodes(bookstore);
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
