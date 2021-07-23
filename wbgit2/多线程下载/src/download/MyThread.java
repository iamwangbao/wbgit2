package download;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.CountDownLatch;



import java.io.IOException;



public class MyThread extends Thread{  // 继承Thread类，作为线程的实现类

	 public static final int MAX_THREAD_COUNT = 5; 
    /**
     * 线程下载成功标志
     */
    public static int flag = 0;
    /**
     * 线程ID
     */
    public String threadId;
    /**
     * 下载起始位置
     */
    public static long[] startIndex=new long[10];
    /**
     * 下载结束位置
     */
    public static long[] endIndex=new long[10];
   

    /**
     * 线程计数同步辅助
     */
    public CountDownLatch latch;

 public  String file;
 public   String downpath;
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
    
  //多个线程下载单个文件的不同部分，顺序下载多个文件
    public static void SegmentDownload(String url) throws IOException
    {
    	int partSize=0;
  
    
        int partCount =  MAX_THREAD_COUNT;
        int partCount2=partCount;
        
     
         partSize = (int)( getFileLength(url) / partCount);
        
       
       
        	partCount2=partCount;
        	for(int j=0;j<partCount;j++) {
        		partCount2=partCount2-1;
        		
                // 每一个线程下载的开始位置
                startIndex[j] = (partCount2) * partSize;
               // 每一个线程下载的开始位置
                endIndex[j] = startIndex[j] + partSize- 1;
           
        	}
        
        	for(int j=0;j<partCount;j++) {
        		//最后一个线程下载的长度稍微长一点
        	     endIndex[partCount-1] = endIndex[partCount-1] + 1;
        System.out.print(MyThread.currentThread().getName() + "下载:" + startIndex[j] + "字节~" + endIndex[j] + "字节"+"\n");
        }
        
        
        
    }
    

    public void run(){  // 覆写run()方法，作为线程 的操作主体
    	 String token="v32Eo2Tw+qWI/eiKW3D8ye7l19mf1NngRLushO6CumLMHIO1aryun0/Y3N3YQCv/TqzaO/TFHw4=";
    	 try {
			downLoadFromUrl(this.downpath, this.file,this.savapath,token);
			 System.out.println(this.name+"下载完成");
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
    
    }
    
    public static  long getFileLength(String fileUrl) throws IOException {  //获取文件大小

        if (fileUrl == null || "".equals(fileUrl)) {
            return 0 ;
        }
        URL url = new URL(fileUrl);
        HttpURLConnection conn = null;
        try {
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("HEAD");
            conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows 7; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.73 Safari/537.36 YNoteCef/5.8.0.1 (Windows)");
            return (long) conn.getContentLength();
        } catch (IOException e) {
            return 0 ;
        } finally {

            conn.disconnect();
        }

    }
    
    /**
     * 从输入流中获取字节数组
     * @param inputStream
     * @return
     * @throws IOException
     */
    
    public static void  downLoadFromUrl(String urlStr,String fileName,String savePath,String toekn) throws IOException{
    	
    	SegmentDownload(urlStr);
    	 System.out.print(MyThread.currentThread().getName()+"正在执行\n");
    	
   	
    		for(int j=0;j<MAX_THREAD_COUNT;j++) {
  
    	URL url=new URL(urlStr);
    	HttpURLConnection conn=(HttpURLConnection)url.openConnection();    	        	    	
    	int code=0;	
    			
        //防止屏蔽程序抓取而返回403错误
        conn.setRequestProperty("Connection", "Keep-Alive");
        conn.setRequestMethod("GET");
        //请求服务器下载部分的文件的指定位置
        conn.setRequestProperty("Range", "bytes=" + startIndex[j] + "-" + endIndex[j]);
      //设置超时间为5秒
        conn.setConnectTimeout(5000);
         code = conn.getResponseCode(); //返回状态码，标识http状态返回
        System.out.print(MyThread.currentThread().getName() + "请求返回code=" + code+"\n");
        
    	InputStream is=conn.getInputStream(); //返回资源
       	RandomAccessFile raf=  new RandomAccessFile(savePath+File.separator+fileName, "rwd");
      
        //随机写文件的时候从哪个位置开始写
      
        raf.seek(startIndex[j]);//定位文件
        int len = 0;
        byte[] buffer = new byte[1024];
        while ((len = is.read(buffer)) != -1) {
            raf.write(buffer, 0, len);               
        }
        
	     is.close();
         raf.close();
         System.out.print(MyThread.currentThread().getName() + "下载完毕"+"\n");
       
    	}
            System.out.println(savePath+File.separator+fileName+"下载完成");
            System.out.println("info:"+urlStr+" download success");
    	}



};
