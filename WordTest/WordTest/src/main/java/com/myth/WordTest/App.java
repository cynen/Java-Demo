package com.myth.WordTest;

import java.util.HashMap;
import java.util.Map;

/**
 * 
* <p>Title: App</p>  
* <p>Description: </p>  
* @author shenlan  
* @date 2018年9月10日
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        Map<String, Object> map = new HashMap<String,Object>();
        map.put("name", "蔡能");
        map.put("sex", "男");
        map.put("age", "18");
        map.put("addr", "广东");
        map.put("phone", "189");
        map.put("yourname", "蔡能2");
        map.put("year", "2018");
        map.put("month", "12");
        map.put("date", "11");
        
        
        try {
			WordUtils.creatWord(map);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println("根据word模板生成word完成");
    }
}
