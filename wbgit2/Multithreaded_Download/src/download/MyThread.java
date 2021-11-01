package download;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.channels.FileChannel;
import java.util.concurrent.CountDownLatch;



import java.io.IOException;



public class MyThread extends Thread{  // �̳�Thread�࣬��Ϊ�̵߳�ʵ����

	 public static final int MAX_THREAD_COUNT = 5; 
    /**
     * �߳����سɹ���־
     */
    public static int flag = 0;
    /**
     * �߳�ID
     */
    public String threadId;
    /**
     * ������ʼλ��
     */
    public static long[] startIndex=new long[10];
    /**
     * ���ؽ���λ��
     */
    public static long[] endIndex=new long[10];
   

    /**
     * �̼߳���ͬ������
     */
    public CountDownLatch latch;

 public  String file;
 public   String downpath;
 public  String savapath;
 //public String name=MyThread.currentThread().getName();      // ��ʾ�̵߳����� 
 
 public static time Time=new time();//ʱ����

 
 public void setfile(String file) {
     this.file = file;
  }
  public String getfile() {
     return file;
  }
  public void setdownpath(String downpath) {
     this.downpath = downpath;
  }
  public String getdownpath() {
     return downpath;
  }
  public void setsavapath(String savapath) {
     this.savapath = savapath;
  }
  public String getsavapath() {
     return savapath;
  }   
 /*
    public void downinformation(String file,String downpath,String savapath){ 
    
    	       
    	         this.file=file;
    	         this.downpath=downpath;
    	         this.savapath=savapath;
    	      } 
   */
  
  //��ȡ�ֶ�����ÿ���ļ���С
    public static void SegmentDownload(String url) throws IOException
    {
    	int partSize=0;
        long filesize=0;
    
        int partCount =  MAX_THREAD_COUNT;
        int partCount2=0;
         
        if(getFileLength(url)%2==0)
        {
        	partSize = (int)( getFileLength(url) / partCount); //���ڻ�ȡ�ֶδ�С
        }
        else
        {
        	partSize = (int)(( getFileLength(url)-1) / partCount); //���ڻ�ȡ�ֶδ�С
        }
         
         
         filesize= getFileLength(url); //��ȡ�ܴ�С 
         
        //	partCount2=partCount;
        	for(int j=0;j<partCount;j++) {
        		        		
                // ÿһ�����صĿ�ʼλ��
                startIndex[j] = (partCount2) * partSize;
               // ÿһ�����صĿ�ʼλ��
                endIndex[j] = startIndex[j] + partSize- 1;
                
            	partCount2=partCount2+1; 
           
        	}
        	
        	//��0�ֽڵ�λ�ÿ�ʼ���أ��ļ���С��λ����β
        
        	endIndex[partCount-1] =getFileLength(url);
        	
        	
        	
        	System.out.println(MyThread.currentThread().getName()+"�����ص��ܴ�СΪ"+filesize + "�ֽ�");
        	
        	for(int j=0;j<partCount;j++) {
        		//���һ�����صĳ�����΢��һ��
        System.out.print(MyThread.currentThread().getName() + "����:" + startIndex[j] + "�ֽ�~" + endIndex[j] + "�ֽ�"+"\n");
        }
        
        
        
    }
    

    public void run(){  // ��дrun()��������Ϊ�߳� �Ĳ�������
    	 String token="v32Eo2Tw+qWI/eiKW3D8ye7l19mf1NngRLushO6CumLMHIO1aryun0/Y3N3YQCv/TqzaO/TFHw4=";
    	 
    	 try {
    		
			downLoadFromUrl(this.downpath, this.file,this.savapath,token);
			 System.out.println(this.file+"�������");
		//	 interrupt();
		} catch (IOException | InterruptedException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		//	interrupt();
			return;
		}
    
    }
    
    public static  long getFileLength(String fileUrl) throws IOException {  //��ȡ�ļ���С

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
     * ���������л�ȡ�ֽ�����
     * @param inputStream
     * @return
     * @throws IOException
     * @throws InterruptedException 
     */
    
    public static void  downLoadFromUrl(String urlStr,String fileName,String savePath,String toekn) throws IOException, InterruptedException{
    	
    	long size= getFileLength(urlStr); //��ȡ�ܴ�С 
    	
    	 Time.setstarttime();//��ȡ��ʼʱ��
    	 
    	SegmentDownload(urlStr);
    	 System.out.print(MyThread.currentThread().getName()+"����ִ��\n");
    	
   	
    		for(int j=0;j<MAX_THREAD_COUNT;j++) {
  
    	URL url=new URL(urlStr);
    	HttpURLConnection conn=(HttpURLConnection)url.openConnection();    	        	    	
    	int code=0;	
    			
        //��ֹ���γ���ץȡ������403����
        conn.setRequestProperty("Connection", "Keep-Alive");
        conn.setRequestMethod("GET");
        //������������ز��ֵ��ļ���ָ��λ��
        conn.setRequestProperty("Range", "bytes=" + startIndex[j] + "-" + endIndex[j]);
      //���ó�ʱ��Ϊ5��
        conn.setConnectTimeout(5000);
         code = conn.getResponseCode(); //����״̬�룬��ʶhttp״̬����
        System.out.print(MyThread.currentThread().getName() + "���󷵻�code=" + code+"\n");
        
    	InputStream is=conn.getInputStream(); //������Դ
       	RandomAccessFile raf=  new RandomAccessFile(savePath+File.separator+fileName, "rwd");
      
        //���д�ļ���ʱ����ĸ�λ�ÿ�ʼд
      
        long time_s =System.currentTimeMillis()/1000;
        long time_s2 =System.currentTimeMillis()/1000;
        long nowSpeed=0;
    	long nowSize=0;
    	long upnowSize=0;
           	
        raf.seek(startIndex[j]);//��λ�ļ�
        int len = 0;
        byte[] buffer = new byte[1024];
        while ((len = is.read(buffer)) != -1) {
            raf.write(buffer, 0, len);    
            
            time_s2 =System.currentTimeMillis()/1000;        
            if(time_s2-time_s>=1)
            {            	
        //    System.out.println("�ļ�"+fileName+"�Ĵ�СΪ:"+raf.length()+"KB");
                       
            nowSize=raf.length();
    		
    		nowSpeed=nowSize-upnowSize;
    		upnowSize=nowSize;
    		
    	
    		System.out.print("�ļ�"+fileName+"�����ٶ�Ϊ��"+nowSpeed +"B"+ "/s" +'\n');
    		System.out.print("�ļ�"+fileName+"��ǰ���ؽ���Ϊ��"+String.format("%.2f",((nowSize*1.0)/(size*1.0))*100) +"%" +'\n');
            
            time_s=time_s2;
            }
            
        }
        
	     is.close();
         raf.close();
         Time.setendtime();//��ȡ����ʱ��
         System.out.print(MyThread.currentThread().getName() + "�������"+"\n");
       
    	}
    		
    		System.out.println(savePath+File.separator+fileName);
    		Time.getstarttime();//�����ʼʱ��
    		System.out.println(savePath+File.separator+fileName);
    		Time.getendtime();//�������ʱ��
            System.out.println(savePath+File.separator+fileName+"�������");
            System.out.println("info:"+urlStr+" download success");
    	}



};
