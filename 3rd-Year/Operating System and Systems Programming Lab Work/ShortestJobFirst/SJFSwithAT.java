package ShortestJobFirst;

import java.util.Scanner;

public class SJFSwithAT {

	/**
	 * @param args
	 * @author Ananda Mohon Ghosh
	 */
	public static void main(String[] args) {
		Que qq=new Que();
		Scanner sc =new Scanner(System.in);
		int arrivalTime ;
		int brustTime,totalbrustTime=0;
		String processName;
		for(int i=0;i<4;i++)
		{
			processName=sc.next();
			 arrivalTime =sc.nextInt();
			 brustTime =sc.nextInt();
			 totalbrustTime=totalbrustTime+brustTime;
			 qq.insertIntoQue(processName, arrivalTime, brustTime);
		}
		int timer=0;
		while(timer<=totalbrustTime)
		{
			Node temp=qq.front;
			if(timer==0)
			{
				System.out.println("starts "+temp.process+" time : " +timer);
				timer=timer+1;
				temp.brustTime=temp.brustTime-timer;
				
			}
			else
			{
				
				Node SlectNode=null;
				int minimum=100;
				while(temp!=null)
		        {
					//System.out.println("temp.getNext : "+temp.next);
		            if(minimum>temp.brustTime&&timer>=temp.arrivaltime)
		            {
		            	
		            	minimum=temp.brustTime;
		            	SlectNode=temp;	
		            	if(minimum==0)
		            		qq.deleteFromQue(SlectNode);
		            }
		            temp=temp.next; 
		        }
				if(SlectNode!=null)
				{
					//qq.print();
					
						System.out.println("starts "+SlectNode.process+" time : " +timer);
						timer=timer+1;
						SlectNode.brustTime=SlectNode.brustTime-1;
					
					
					//qq.print();
				}
				if(totalbrustTime<=timer)
				{
					System.out.print("Sheduling Ends at :  " +totalbrustTime);
					System.exit(0);
				}
					
			}
		}
		
		
	}

}
