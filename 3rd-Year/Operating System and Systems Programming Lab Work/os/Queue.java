package os;

import java.util.Random;


public class Queue {

	public Node front = null, rear=null;
	public int QueLenth;
	Random rndom=new Random();
		
	Queue(int QueLenth)
	{
		this.QueLenth=QueLenth;
	}


	public void Produce()
	{
		if(count()<QueLenth){
		int rnd=rndom.nextInt(100);
	    Node node = new Node(Integer.toString(rnd));
	   
		if(front == null)
		{
			front=node;
			rear=node;
		}
		else
		{
			rear.setNext(node);
			rear=node;
		}
		 System.out.println("Number Added = "+node.getData());
		 print();
		 }
		
		else 
			 System.out.println("Queue is full");
	}
	
	
	
	public void print()
	{
		Node temp= front;
		if(temp!=null)
		{
			while(temp!=null)
			{
				System.out.print(temp.getData()+"  ");
				temp = temp.getNext();
			}
			System.out.println();
		}
		
		else 
			System.out.println("Null");
		
	}
	
	
	public void Consume()
	{
		if(front!=null){
		System.out.println("Number Deleted = "+front.getData());
		front=front.getNext();
		print();}
		else
			System.out.println("Queue is empty");
	}
	
	
	public int count()
	
	{
		int count=0;
		Node temp= front;
			while(temp!=null)
			{
				count++;
				temp=temp.getNext();
			}
		return count;
	}
}
