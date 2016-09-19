package ThreadExamples;  
  
/**
 * @author Ananda  Mohon Ghosh
 * @param args
 */
class Item {     
        
    volatile int content;     
    
        public synchronized void setContent(int content) {     
            this.content=content;     
        }     
    
        public synchronized int getContent() {     
            return content;     
        }     
}     
    
class Producer implements Runnable {     
    
    Item item;     
    
    Producer(Item item) {     
         this.item=item;     
    }   
      
    
    public Item getItem() {  
        return item;  
    }  
  
  
    public void setItem(Item item) {  
        this.item = item;  
    }  
  
  
    public void run() {    
        int i =0;  
        synchronized(this)  
        {  
            while(true)  
            {     
                ++i;  
                if (i==10) return;  
                System.out.println("Putting the value in item " + i  );     
                item.setContent(i);  
                notify();     
                try{  
                    wait();  
                }  
                catch(InterruptedException e){  
                    e.printStackTrace();  
                }  
            }     
        }     
    }     
}  
    
    
class Consumer implements Runnable {     
         
    Producer producer;     
      
    
    Consumer(Producer producer) {     
        this.producer = producer;     
    }     
    
    
    public void run()   
    {   
        synchronized(producer)  
        {  
            while(true){  
                    System.out.println("Consuming " +producer.getItem().getContent());  
                    producer.notify();  
                        try {  
                            if(producer.getItem().getContent() == 9)     
                                return;    
                            producer.wait();  
                        } catch (InterruptedException e) {  
                            // TODO Auto-generated catch block  
                            e.printStackTrace();  
                        }  
                      
            }  
          
        }     
    
    }    
}  
    
public class  Execute{     
    
    public static void main(String arg[]) {     
        Item item1 = new Item();     
    
        Producer producer = new Producer(item1);     
        Consumer consumer = new Consumer(producer);     
    
        Thread producerThread = new Thread(producer);     
        Thread consumerThread = new Thread(consumer);     
    
        producerThread.start();     
        consumerThread.start();     
    }     
}  