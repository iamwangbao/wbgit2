package download;

import java.io.IOException;


public class MyThread extends Thread{  // �̳�Thread�࣬��Ϊ�̵߳�ʵ����
    

 public  String file;
 public  String downpath;
 public  String savapath;
 public String name ;       // ��ʾ�̵߳����� 
      public MyThread(String name){ 
          this.name = name ;      // ͨ�����췽������name���� 
     } 
 
    public void downinformation(String file,String downpath,String savapath){  // name��ʾ�̵߳�����
    	// ͨ����name��ֵ���߳�ID���� 
    	       
    	         this.file=file;
    	         this.downpath=downpath;
    	         this.savapath=savapath;
    	      } 
    
  

    public void run(){  // ��дrun()��������Ϊ�߳� �Ĳ�������
    	 String token="v32Eo2Tw+qWI/eiKW3D8ye7l19mf1NngRLushO6CumLMHIO1aryun0/Y3N3YQCv/TqzaO/TFHw4=";
    	 try {
			HttpRequest.downLoadFromUrl(this.downpath, this.file,this.savapath,token);
			 System.out.println(this.name+"�������");
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
    
    }
    
};
