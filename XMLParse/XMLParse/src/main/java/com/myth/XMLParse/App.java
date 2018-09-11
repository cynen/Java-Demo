package com.myth.XMLParse;

import org.junit.Test;

/**
 * Hello world!
 *
 */
public class App 
{
/*    public static void main( String[] args )
    {
       //  System.out.println( "Hello World!" );
        
        String src =  "source/books.xml";
        String src2 = "source/works.xml";
        DOM4JParse.DOM4JParse(src);
    }*/
    
    /**
     * DOM4J解析.
     * <p>Description: </p>
     */
    public void DOM4Jtest() {
    	// parse
    	String src =  "source/books.xml";
    	DOM4JParse.DOM4JParse(src);
    }
    
    public void DOM4Jtest2() {
    	// parse
    	String src =  "source/books.xml";
    	DOM4JParse.modifyXML(src);
    }
    
}
