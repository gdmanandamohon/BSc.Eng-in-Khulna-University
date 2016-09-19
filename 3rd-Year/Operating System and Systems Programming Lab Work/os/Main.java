package os;

import java.util.Random;
import java.util.Scanner;

public class Main extends Thread
{
	

	public static void main(String[] args) throws InterruptedException 
	{
  		System.out.println("Enter The Size Of the Queue : ");
  		Scanner sc=new Scanner(System.in);
  		int QueLenth = sc.nextInt();
  		Queue q=new Queue(QueLenth);
  		Random random=new Random();
  		for(int i=0;i<QueLenth;i++)
  		{
  			q.Produce();
  		}
  		for(;;)
  	      {
  	        int rnd=random.nextInt(2);
  	        if(rnd==0)
  	        	q.Produce(); 
  	        	else
  	            q.Consume();
  	        	sleep(1500);
  		 } 
    }
}
