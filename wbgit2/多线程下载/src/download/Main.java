package download;



import java.io.IOException;
import java.util.Scanner;

import download.MyThread;

public class Main {
	
	public static  Scanner input = new Scanner(System.in);
	
    public static void main(String[] args) throws IOException {

    	
    	MyThread mt1 = new MyThread("�߳�A");
    	MyThread mt2 = new MyThread("�߳�B");
    	MyThread mt3 = new MyThread("�߳�C");
    	mt1.setName("�߳�A");
    	mt2.setName("�߳�B");	
    	mt3.setName("�߳�C");	
     	 
     	mt1.downinformation("tx1.exe","https://dldir1.qq.com/qqtv/TencentVideo11.25.3008.0.exe","D:\\1") ; 
     	mt2.downinformation("tx2.exe","https://dldir1.qq.com/qqtv/TencentVideo11.25.3008.0.exe","D:\\1") ; 
     	mt3.downinformation("tx3.exe","https://dldir1.qq.com/qqtv/TencentVideo11.25.3008.0.exe","D:\\1") ; 
     	
     	mt1.start();
     	mt2.start();
     	mt3.start();

    }
}