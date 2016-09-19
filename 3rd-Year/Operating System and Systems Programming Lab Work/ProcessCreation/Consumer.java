package ProcessCreation;
/**
 * @author Ananda  Mohon Ghosh
 * @param args
 */

class Consumer extends Thread 
{ 
	int QueuSize;
	static CircularQueu cQueue;
	Consumer(int QueuSize,CircularQueu cQueue) 
	{  
         this.QueuSize=QueuSize;
         this.cQueue=cQueue;
    }  
	int counter=0;
	public void run() 
	{  
        for(;;) 
        {  
        	
        	 if(cQueue.spaceremain==0)
        		{
        			
        			String consumed=cQueue.front.getData();
        			++counter;
        			System.out.println("Consumed NO-" +counter+" :"+consumed);
        			cQueue.deleteFromQue();
        			
        			try {
						sleep(1500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
        			
        		}
        	
        }  
    }  
  
}  