package com.lc.utils;


import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.springframework.util.ResourceUtils;

/**
 * @author zhengjianhua
 * @version 创建时间：2016年4月13日 上午8:58:48
 * 
 */
public class GeneratorSqlmap {

	public static void main(String[] args) throws Exception {
		List<String> warnings = new ArrayList<String>();
		boolean overwrite = true;
		// 指定 逆向工程配置文件
		ClassLoader classloader = Thread.currentThread().getContextClassLoader();
		File file = ResourceUtils.getFile("classpath:generatorConfig.xml");
//		InputStream file = classloader.getResourceAsStream("generatorConfig.xml");
//		File configFile = new File("classpath:generatorConfig.xml");
		ConfigurationParser cp = new ConfigurationParser(warnings);
		Configuration config = cp.parseConfiguration(file);
		DefaultShellCallback callback = new DefaultShellCallback(overwrite);
		MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config,
				callback, warnings);
		myBatisGenerator.generate(null);
		System.out.println("Success");
    }

	 public static InputStream getResourceAsStream(String path){
	        return Thread.currentThread().getContextClassLoader().getResourceAsStream(path);
	    }

}
