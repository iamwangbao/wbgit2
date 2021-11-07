package com.down.ssm.service.impl;

import com.down.ssm.pojo.time;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;




public class MyThread extends Thread{  // 继承Thread类，作为线程的实现类

    public static final int MAX_THREAD_COUNT = 5;
    /*
     * 线程下载成功标志
     */
 //   public static int flag = 0;
    /*
     * 线程ID
     */
  //  public String threadId;
    /*
     * 下载起始位置
     */
    public static long[] startIndex=new long[10];
    /*
     * 下载结束位置
     */
    public static long[] endIndex=new long[10];


    /*
     * 线程计数同步辅助
     */
  //  public CountDownLatch latch;

    public  String file;
    public   String downpath;
    public  String savapath;
    //public String name=MyThread.currentThread().getName();      // 表示线程的名称

    public static time Time=new time();//时间类


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

    //获取分段下载每段文件大小
    public static void SegmentDownload(String url) throws IOException
    {
        int partSize;
        long filesize;

        int partCount =  MAX_THREAD_COUNT;
        int partCount2=0;

        if(getFileLength(url)%2==0)
        {
            partSize = (int)( getFileLength(url) / partCount); //用于获取分段大小
        }
        else
        {
            partSize = (int)(( getFileLength(url)-1) / partCount); //用于获取分段大小
        }


        filesize= getFileLength(url); //获取总大小

        //	partCount2=partCount;
        for(int j=0;j<partCount;j++) {

            // 每一个下载的开始位置
            startIndex[j] = (partCount2) * partSize;
            // 每一个下载的开始位置
            endIndex[j] = startIndex[j] + partSize- 1;

            partCount2=partCount2+1;

        }

        //从0字节的位置开始下载，文件大小的位置收尾

        endIndex[partCount-1] =getFileLength(url);



        System.out.println(MyThread.currentThread().getName()+"所下载的总大小为"+filesize + "字节");

        for(int j=0;j<partCount;j++) {
            //最后一个下载的长度稍微长一点
            System.out.print(MyThread.currentThread().getName() + "下载:" + startIndex[j] + "字节~" + endIndex[j] + "字节"+"\n");
        }



    }


    public void run(){  // 覆写run()方法，作为线程 的操作主体
        String token="v32Eo2Tw+qWI/eiKW3D8ye7l19mf1NngRLushO6CumLMHIO1aryun0/Y3N3YQCv/TqzaO/TFHw4=";

        try {

            downLoadFromUrl(this.downpath, this.file,this.savapath,token);
            System.out.println(this.file+"下载完成");
            //	 interrupt();
        } catch (IOException | InterruptedException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
            //	interrupt();

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
     */

    public static void  downLoadFromUrl(String urlStr,String fileName,String savePath,String toekn) throws IOException, InterruptedException{

        long size= getFileLength(urlStr); //获取总大小

        Time.setstarttime();//获取开始时间

        SegmentDownload(urlStr);
        System.out.print(MyThread.currentThread().getName()+"正在执行\n");


        for(int j=0;j<MAX_THREAD_COUNT;j++) {

            URL url=new URL(urlStr);
            HttpURLConnection conn=(HttpURLConnection)url.openConnection();
            int code;

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

            long time_s =System.currentTimeMillis()/1000;
            long time_s2 =System.currentTimeMillis()/1000;
            long nowSpeed;
            long nowSize;
            long upnowSize=0;

            raf.seek(startIndex[j]);//定位文件
            int len;
            byte[] buffer = new byte[1024];
            while ((len = is.read(buffer)) != -1) {
                raf.write(buffer, 0, len);

                time_s2 =System.currentTimeMillis()/1000;
                if(time_s2-time_s>=1)
                {
                    //    System.out.println("文件"+fileName+"的大小为:"+raf.length()+"KB");

                    nowSize=raf.length();

                    nowSpeed=nowSize-upnowSize;
                    upnowSize=nowSize;


                    System.out.print("文件"+fileName+"下载速度为："+nowSpeed +"B"+ "/s" +'\n');
                    System.out.print("文件"+fileName+"当前下载进度为："+String.format("%.2f",((nowSize*1.0)/(size*1.0))*100) +"%" +'\n');

                    time_s=time_s2;
                }

            }

            is.close();
            raf.close();
            Time.setendtime();//获取结束时间
            System.out.print(MyThread.currentThread().getName() + "下载完毕"+"\n");

        }

        System.out.println(savePath+File.separator+fileName);
        Time.getstarttime();//输出开始时间
        System.out.println(savePath+File.separator+fileName);
        Time.getendtime();//输出结束时间
        System.out.println(savePath+File.separator+fileName+"下载完成");
        System.out.println("info:"+urlStr+" download success");
    }



}
