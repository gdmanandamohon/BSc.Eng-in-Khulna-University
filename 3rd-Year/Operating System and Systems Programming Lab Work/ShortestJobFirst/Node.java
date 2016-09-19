package ShortestJobFirst;
/**
 * @author Ananda  Mohon Ghosh
 * @param args
 */
public class Node{
	
	  String process;
	  int arrivaltime;
	  int brustTime;
	  Node next;
	  
	  public  Node ( String Process,int arrivaltime,int brustTime)
	  {
		    this.process = Process;
		    this.arrivaltime=arrivaltime;
		    this.brustTime=brustTime;
		    
	  }
	  
	  public void setNext ( Node next ){
	    this.next = next;
	  }
	  
	  public Node getNext () {
	    return next;
	  }
	    
	}