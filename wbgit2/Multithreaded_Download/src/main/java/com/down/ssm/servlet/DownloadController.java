package com.down.ssm.servlet;

import com.down.ssm.service.impl.Logfile;
import com.down.ssm.service.impl.MyThread;
import lombok.SneakyThrows;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class DownloadController {


   @RequestMapping(value = "/student", method = RequestMethod.GET)
   public ModelAndView student() {
      return new ModelAndView("student", "command", new MyThread());
   } 

   
   @SneakyThrows
   @RequestMapping(value = "/addStudent", method = RequestMethod.POST)
   public String addStudent(@ModelAttribute("SpringWeb")MyThread down1, 
   ModelMap model) {

      model.addAttribute("file",  down1.getfile());
      model.addAttribute("downpath", down1.getdownpath());
      model.addAttribute("savapath", down1.getsavapath());    

      String [] file1 = down1.getfile().split(",");
      String[] url1=down1.getdownpath().split(",");
      String[] savapath1=down1.getsavapath().split(",");

	   ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
	   //    MyThread down1 = (MyThread) context.getBean("Down");
	   MyThread down2 = (MyThread) context.getBean("Down");
	   MyThread down3 = (MyThread) context.getBean("Down");
	   MyThread down4 = (MyThread) context.getBean("Down");
	   MyThread down5 = (MyThread) context.getBean("Down");

      for(int i=0;i<file1.length;i++)
      {
    	  if(i==0) {
			  down2.setName("线程A");
			  down2.setfile(file1[0]);
			  down2.setdownpath(url1[0]);
			  down2.setsavapath(savapath1[0]);
              System.out.println(down2.getName()+"启动");
			   down2.start();
			  Thread.sleep(5000);

		  }

    	  if(i==1)
    	  {
    		  down3.setName("线程B");
    		  down3.setfile(file1[1]);
    		  down3.setdownpath(url1[1]);
    		  down3.setsavapath(savapath1[1]);
    		  System.out.println(down3.getName()+"启动");
			    down3.start();
			  Thread.sleep(5000);
			 // new Thread(down3).start();
    	  }
    	  
    	  if(i==2)
    	  {
    		  down4.setName("线程C");
    		  down4.setfile(file1[2]);
    		  down4.setdownpath(url1[2]);
    		  down4.setsavapath(savapath1[2]);
    		  System.out.println(down4.getName()+"启动");
			    down4.start();
			  Thread.sleep(5000);
			 // new Thread(down4).start();
    	  }
    	  
    	  if(i==3)
    	  {
    		  down5.setName("线程D");
    		  down5.setfile(file1[3]);
    		  down5.setdownpath(url1[3]);
    		  down5.setsavapath(savapath1[3]);
    		  System.out.println(down5.getName()+"启动");
			    down5.start();
			  Thread.sleep(5000);
    	  }

      }
  
      
      Logfile.inputlog(); //调用方法用于生成debug，异常，错误日志。并输出到控制台


      down2.interrupt();
      down3.interrupt();
      down4.interrupt();
      down5.interrupt();
      return "result";
   }



}