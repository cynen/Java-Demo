package com.myth.XMLParse;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.XMLReader;

/**
 * SAX解析属于事件   驱动类型.
 * 
*<p> Title: SAXParse  </p>
*<p> Description: </p>
*<p> Copyright: Copyright (c) 2018</p>  
*<p> Company: myth</p>  
* @author myth
* @date 2018年9月12日  
* @version v1.0
 */
public class SAXParse {
	public static void SAXParse(String src) throws Exception {
		
		SAXParserFactory factory = SAXParserFactory.newInstance();
		
		SAXParser sp = factory.newSAXParser();
		
		XMLReader reader = sp.getXMLReader();
		
		reader.setContentHandler(new SaxHandler());
		
		reader.parse(src);
		
	}
}
