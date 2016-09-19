package RoundRobinScheduling;
import java.util.Scanner;
public class RoundRobin {

	/**
	 * @param args
	 * @author Ananda Mohon Ghosh
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter the number of process : ");
		Scanner scan = new Scanner(System.in);
		int numberProcess =scan.nextInt();
		
		int brustTime[] = new int[numberProcess];
		String processName[] = new  String [numberProcess];
		
	
		
		
		int TotalBrustTIme=0;
		for (int i = 0; i < processName.length; i++) {
			System.out.println(" Enter process name : ");
			processName[i]=scan.next();
			System.out.println(" Enter the Brust time : ");
			brustTime[i] = scan.nextInt();
			TotalBrustTIme +=brustTime[i];
		}
		System.out.println("Enter Quantum : ");
		int Quantum = scan.nextInt();
		int i=0;
		int timer=0;
		while(true)
		{
			if(timer == TotalBrustTIme)
			{
				//turnarroundTime[i] =timer;
				System.out.println(" Schedules Ends at : " +timer);
				break;
			}
			else if(brustTime[i]==0)
			{
				
				i=i+1;
				if(i==numberProcess)
					i=0;
				continue;
			}
			else if(brustTime[i]<Quantum)
			{
				
				
				System.out.println("Processor "+processName[i]+" starts at "+timer);				
				timer = timer + brustTime[i];
				brustTime[i]=0;
			}
			else
			{
				
				System.out.println("Processor "+processName[i]+" starts at "+timer);
				timer =timer+Quantum;
				
				brustTime[i] -= Quantum;
			}
			i=i+1;
			if(i==numberProcess)
				i=0;
		}
		
		// print time
		}

}
