package ProcessCreation;
import java.util.Random;
/**
 * @author Ananda  Mohon Ghosh
 * @param args
 */

class Producer extends Thread 
{
	static int QueuSize;
	static CircularQueu cQueue;
	Random rndom=new Random();
    Producer( int CircularQueu, CircularQueu cQueue) 
    {  
    	this.QueuSize=QueuSize;
    	this.cQueue=cQueue;
    }
    int counter=0;
    public void run() 
    {  
        for(;;) 
        {  
        	if(cQueue.spaceremain==10)
        	{
        		System.out.println("Queue is Empty. \n Now Producer is Producing");
        		int number=rndom.nextInt(100);
        		++counter;
        		System.out.println("Produced NO-"+counter+" :"+number);
        		cQueue.insertIntoQue(Integer.toString(number));
        		
        	}
        	else if(cQueue.spaceremain==0)
        	{
				try {
					sleep(MAX_PRIORITY);
					sleep(1500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        	}
			else
        	{
        		int number=rndom.nextInt(100);
        		++counter;
        		System.out.println("Produced NO-"+counter+" :"+number);
        		cQueue.insertIntoQue(Integer.toString(number));
        		
        		try 
        		{
					sleep(1500);
				} catch (InterruptedException e) 
				{
					e.printStackTrace();
				}
        	}
             
        }  
    } 
}  