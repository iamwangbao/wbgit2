package com.down.ssm.service.impl;

import org.apache.commons.logging.LogFactory;


public class Logfile {
	   static org.apache.commons.logging.Log log = LogFactory.getLog(MyThread.class.getName());
	//static  Logger log = Logger.getLogger(MyThread.class.getName());
	   
	 
	   public static  void inputlog() {
	    
	    //  log.info("Going to create HelloWord Obj");
	   // 记录debug级别的信息
			log.debug(">>This is debug message");
			// 记录info级别的信息
			log.info(">>This is info message");
			// 记录error级别的信息
			log.error(">>This is error message");
	     
	    //  log.info("Exiting the program");
	   }
}
