package download;
import java.text.SimpleDateFormat;
import java.util.Date; //����ʱ���
public class time {
	public  String starttime=new String(); //��ʼʱ��
	public  String endtime=new String(); //����ʱ��
	
	
	   public String formattime(Date dNow) { //��ʽ��ʱ���ʽΪ��-��-��-ʱ-��-��
		   
		     SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss");
		 
		     // System.out.println("��ǰʱ��Ϊ: " + ft.format(dNow));
		      return ft.format(dNow);
		   }
	
	
	public void setstarttime() //ʱ��
	{
		 Date date = new Date();
		 //����ʼ����ʱ����ȡһ��ʱ����Ϊ��ʼʱ��
		
		 this.starttime=formattime(date);

				 
	}
	
	public void setendtime() //ʱ��
	{
		 Date date = new Date();
	
		/*����������ʱ����ȡһ��ʱ����Ϊ����ʱ��
		Ԥ��ʱ��=ʣ���ļ���С/��ǰ�����ٶ�*/
		 this.endtime =formattime(date);
		 
		 
	}
	
	public void getstarttime() ///��ӡ��ʼʱ��
	{
		
	 System.out.print("��ʼʱ���ǣ�"+this.starttime +'\n');
	}
	
	public void getendtime() ///��ӡ����ʱ��
	{
		
	 System.out.print("����ʱ���ǣ�"+this.endtime +'\n');
	}
}
