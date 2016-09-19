package ProcessCreation;

import java.util.Random;
import java.util.Scanner;

public class ProcessControlClass {

	/**
	 * @param args
	 * AUTHOR ANANDA MOHON GHOSH
	 */
	
	public static void main(String[] args) {
		System.out.println("Enter The Size Of the Queue : ");
		Scanner scanner=new Scanner(System.in);
		int QueLenth = scanner.nextInt();
		CircularQueu cQueue=new CircularQueu(QueLenth);
		Producer produce=new Producer(QueLenth,cQueue);
		Consumer consumer=new Consumer(QueLenth,cQueue);
		
		produce.start();
		consumer.start();
		/*cQueue.insertIntoQue("sdasd");
		cQueue.insertIntoQue("sdfdgrwerewrewafddfgsd");
		cQueue.insertIntoQue("sdasewfbfdmmdd");
		cQueue.insertIntoQue("sfgfdgfdgfdasd");
		cQueue.insertIntoQue("sdasd");
		cQueue.insertIntoQue("sdfgafdgfgfgsd");
		cQueue.print();
		cQueue.deleteFromQue();
		cQueue.print();
		Random rndom=new Random();
		for (int i = 0; i <QueLenth; i++) 
    	{
    		float number=rndom.nextFloat();
    		System.out.println("Produced : "+number);
    		cQueue.insertIntoQue(Float.toString(number));
		}
		cQueue.print();*/
	}

}


  
  


