package ShortestJobFirst;
public class Que {
	/**
	 * @author Ananda  Mohon Ghosh
	 * @param args
	 */
	public Node front = null, rear=null;
	public void insertIntoQue(String Process,int arrivaltime,int brustTime)
	{
		
		Node node = new Node (Process,arrivaltime,brustTime);
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
	public void deleteFromQue(Node SlectNode)
	{
		Node temp=front;
		Node prev=front;
		while(temp!=SlectNode)
		{
			prev=temp;
			temp=temp.next;
		}
		if(temp==front)
			front=front.next;
		else
			prev.next=temp.next;
	}
	public void print()
	{
		Node tempv= front;
		while(tempv !=null)
		{
		
			//System.out.print(tempv.process +" "+ tempv.arrivaltime+ " "+ tempv.brustTime+"\n");
			System.out.print(tempv+"  ");
			tempv = tempv.getNext();
		}
		System.out.println();
	}
	
}
