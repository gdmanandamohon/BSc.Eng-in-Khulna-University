package ProduceConsumerProblem;
/**
 * @author Ananda  Mohon Ghosh
 * @param args
 */
public class Node{
	
	  private String data;
	  private Node next;
	  
	  public Node ( String data ){
	    this.data = data;
	  }
	  
	  public void setData ( String newData ) {
	    data = newData;
	  }
	  
	  public String getData ( ) 
	  {
	    return data;
	  }
	  
	  public void setNext ( Node next ){
	    this.next = next;
	  }
	  
	  public Node getNext () {
	    return next;
	  }
	    
	}