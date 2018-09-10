package com.myth.WordTest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Map;


import freemarker.template.Configuration;
import freemarker.template.Template;

/**
 * 
* <p>Title: WordUtils</p>  
* <p>Description: 
*  仅仅使用freemarker实现
* wrod模板生成wrod文档.
* </p>  
* @author myth
* @date 2018年9月10日
 */
public class WordUtils {
    //配置信息,代码本身写的还是很可读的,就不过多注解了
    private static Configuration configuration = null;
    //这里注意的是利用WordUtils的类加载器动态获得模板文件的位置
    // 实际加载的src目录下的.
    private static final String templateFolder =  WordUtils.class.getClassLoader().getResource("./").getPath();
    static {
    	// 设置版本.
    	configuration = new Configuration(Configuration.VERSION_2_3_23);
    	configuration.setDefaultEncoding("utf-8");
        try {
        	// 设置模板路径文件夹.
            configuration.setDirectoryForTemplateLoading(new File(templateFolder));
        } catch (Exception e) {
            e.printStackTrace();
        }
   }
    /**
     * 
     * <p>Description: </p>  
     * @param map
     * @throws Exception
     */
    public static void creatWord(Map map) throws Exception {
    	// 具体的模板对象.
        Template freemarkerTemplate = configuration.getTemplate("demo.ftl");
        File file = null;
        try {
            // 调用工具类的createDoc方法生成Word文档
            file = createDoc(map,freemarkerTemplate);
        } finally {
           //  if(file != null) file.delete(); // 删除临时文件
        }
    }
 
    /**
     * 生成word 数据.
     * 
     * @param dataMap
     * @param template
     * @return
     * @throws Exception
     */
    private static File createDoc(Map<?, ?> dataMap, Template template) throws Exception {
        String name =  "F:/test2.doc";
        File f = new File(name);
        if(!f.exists()) {
        	f.createNewFile();
        }
        Template t = template;
        try {
            // 这个地方不能使用FileWriter因为需要指定编码类型否则生成的Word文档会因为有无法识别的编码而无法打开
            Writer w = new OutputStreamWriter(new FileOutputStream(f), "utf-8");
            t.process(dataMap, w);
            w.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        return f;
    }
}
