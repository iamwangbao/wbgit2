package download;

import java.io.IOException;


public class MyThread extends Thread{  // 继承Thread类，作为线程的实现类
    

 public  String file;
 public  String downpath;
 public  String savapath;
 public String name ;       // 表示线程的名称 
      public MyThread(String name){ 
          this.name = name ;      // 通过构造方法配置name属性 
     } 
 
    public void downinformation(String file,String downpath,String savapath){  // name表示线程的名称
    	// 通过将name赋值给线程ID命名 
    	       
    	         this.file=file;
    	         this.downpath=downpath;
    	         this.savapath=savapath;
    	      } 
    
  

    public void run(){  // 覆写run()方法，作为线程 的操作主体
    	 String token="v32Eo2Tw+qWI/eiKW3D8ye7l19mf1NngRLushO6CumLMHIO1aryun0/Y3N3YQCv/TqzaO/TFHw4=";
    	 try {
			HttpRequest.downLoadFromUrl(this.downpath, this.file,this.savapath,token);
			 System.out.println(this.name+"下载完成");
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
    
    }
    
};
