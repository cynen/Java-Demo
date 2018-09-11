package com.myth.XMLParse;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;

public class SaxHandler implements ContentHandler{

	public void setDocumentLocator(Locator locator) {
		// TODO Auto-generated method stub
		
	}

	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		
	}

	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub
		
	}

	public void startPrefixMapping(String prefix, String uri) throws SAXException {
		// TODO Auto-generated method stub
		
	}

	public void endPrefixMapping(String prefix) throws SAXException {
		// TODO Auto-generated method stub
		
	}

    public void startElement(String uri, String localName, String qName,
            Attributes atts) throws SAXException {
        System.out.print("<"+qName);
        for(int i=0;atts!=null&&i<atts.getLength();i++){
            String attName=atts.getQName(i);
            String attValueString=atts.getValue(i);
            System.out.print(" "+attName+"="+attValueString);
        }
        System.out.print(">");

    }

    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        System.out.print("</"+qName+">");

    }

    public void characters(char[] ch, int start, int length)
            throws SAXException {
        System.out.print(new String(ch,start,length));

    }

	public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {
		// TODO Auto-generated method stub
		
	}

	public void processingInstruction(String target, String data) throws SAXException {
		// TODO Auto-generated method stub
		
	}

	public void skippedEntity(String name) throws SAXException {
		// TODO Auto-generated method stub
		
	}

}
