package ScheduleAlg_ShortestJobScheduling;

import java.util.Scanner;

public class ShortestJobScheduling {

	/**
	 * @param args
	 * @author Ananda Mohon Ghosh
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		float totalProcessTime=0;
        float avg;
        Scanner sn = new Scanner(System.in);
        System.out.print("\nEnter the number of processes : \n");
        int n = sn.nextInt();
        String Process_id[]=new String[n];
        float brust_time[]=new float[n];
        float Process_TimeStartsAt[]=new float[n];
        for (int i=0;i<n;i++)      
        {
            System.out.println();
            System.out.print("Enter the process ID of process "+(i+1)+" : ");
            Process_id[i]=sn.next();
            System.out.print("Enter the burst time of process "+(i+1)+" : ");
            brust_time[i]=sn.nextInt();
        }
        //Shooting
        for(int i=0;i<n-1;i++)
        {
            for(int j=i+1;j<n;j++)           
            {   
            	if(brust_time[i]>brust_time[j])
                {
                    float temp = brust_time[i];
                    brust_time[i] = brust_time[j];
                    brust_time[j] = temp;
                    String temp2 = Process_id[i];
                    Process_id[i] = Process_id[j];
                    Process_id[j] = temp2;
                }
            }
        }
        
        Process_TimeStartsAt[0]=0;
        for (int i=1;i<n;i++)        
        {
        	Process_TimeStartsAt[i] = Process_TimeStartsAt[i-1]+brust_time[i-1];
        	totalProcessTime=totalProcessTime+Process_TimeStartsAt[i];
        }
        avg=(float)totalProcessTime/n;
        System.out.println("\nProcess_ID\tBurst_time\tWait_time");
        for(int i=0;i<n;i++)
        {
            System.out.println(Process_id[i]+"\t\t"+brust_time[i]+"\t\t"+Process_TimeStartsAt[i]);
        }
        System.out.println("\nTotal wait time: "+totalProcessTime+"\nAverage wait time: "+avg);
	}

}
