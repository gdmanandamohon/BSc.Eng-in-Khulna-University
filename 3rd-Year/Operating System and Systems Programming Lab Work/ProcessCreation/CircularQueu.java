package ProcessCreation;
/**
 * @author Ananda  Mohon Ghosh
 * @param args
 */

public class CircularQueu {
	
	public Node front = null, rear=null;
	public int spaceremain;
	CircularQueu(int QueLenth)
	{
		this.spaceremain=QueLenth;
	}
	public void insertIntoQue(String number)
	{
		spaceremain--;
		Node node = new Node (number);
		if(front == null)
		{
			//node.setNext(node);
			front=node;
			rear=node;
		}
		else
		{
			rear.setNext(node);
			rear=node;
		}
	}
	public void deleteFromQue()
	{
		front=front.getNext();
		spaceremain++;
	}
	public void print()
	{
		Node tempv= front;
		while(tempv !=null)
		{
			System.out.print(tempv.getData()+"  ");
			tempv = tempv.getNext();
		}
		System.out.println();
	}
	
}
