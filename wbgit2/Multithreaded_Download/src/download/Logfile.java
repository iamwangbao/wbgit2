package download;

import org.apache.commons.logging.LogFactory;


public class Logfile{
	   static org.apache.commons.logging.Log log = LogFactory.getLog(MyThread.class.getName());
	//static  Logger log = Logger.getLogger(MyThread.class.getName());
	   
	 
	   public static  void inputlog() {
	    
	    //  log.info("Going to create HelloWord Obj");
	   // ��¼debug�������Ϣ
			log.debug(">>This is debug message");
			// ��¼info�������Ϣ
			log.info(">>This is info message");
			// ��¼error�������Ϣ
			log.error(">>This is error message");
	     
	    //  log.info("Exiting the program");
	   }
}
