package ProduceConsumerProblem;
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
    	 if(cQueue.spaceremain==10&&cQueue.front==null)
    	 {
    		 System.out.println("Queue is Empty. \n Now Producer is Producing");
    		 
    		 
    	 }
    	 if(cQueue.spaceremain<10)
    	 {
    		 String consumed=cQueue.front.getData();
 			++counter;
 			System.out.println("Consumed : "+consumed);
 			cQueue.deleteFromQue();
 			
 			
    	 }
     }
          
	}
      
  
}  