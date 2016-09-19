package ProduceConsumerProblem;
/**
 * @author Ananda  Mohon Ghosh
 * @param args
 */
import java.text.BreakIterator;
import java.util.Random;

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
        		System.out.println("Produced : "+number);
        		cQueue.insertIntoQue(Integer.toString(number));
        		
        	}
        	else if(cQueue.spaceremain==0)
        	{
    			System.out.println("Queue is full now consumer wili consume");
    			String consumed=cQueue.front.getData();
     			System.out.println("Consumed : "+consumed);
     			cQueue.deleteFromQue();
     			
     			
    			 
    			 
        	}
    		else
        	{
        		int number=rndom.nextInt(100);
        		++counter;
        		System.out.println("Produced  : "+number);
        		cQueue.insertIntoQue(Integer.toString(number));
        		
        		
             
        	}
    	}
    }
}  