package simulation;

import java.util.Random;

public class MyProject {

	int Queue_size = 10000;
	  int next_event_type;
	  int num_KG_METAL[]= new int[9];
	  int num_events=9;
	  int num_in_q[]= new int[9];
	  int server_status[]= new int[9];
	  double area_num_in_q[]=new double[9];
	  double area_server_status[]= new double[9];
	  double sim_time;
	  double time_last_event[]= new double[9];
	  double total_of_delays[]= new double[9];
	  
	  double mean_interarrival_1st_Server;
	  
	  double mean_service[]=new double[9];
	  
	 
	  double[][] time_arrival = new double [9][Queue_size];
	  double[] time_next_event=new double[10];
	  Random random = new Random(10000);
	  Random ran = new Random();
	 
	
	
	public  void initialize()
	{
		sim_time = 0.0;
		time_next_event[1] = sim_time + expon(mean_interarrival_1st_Server) ;
		time_next_event[2] = Math.pow(10, +30);
		time_next_event[3] = Math.pow(10, +30);
		time_next_event[4] = Math.pow(10, +30);
		time_next_event[5] = Math.pow(10, +30);
		time_next_event[6] = Math.pow(10, +30);
		time_next_event[7] = Math.pow(10, +30);
		time_next_event[8] = Math.pow(10, +30);
		time_next_event[9] = Math.pow(10, +30);
		
	}
	 
	
	 
	 public  void timing()
	{
		
		double min_time_next_event = Math.pow(10, +29);
		next_event_type=0;
		
		for(int i=1;i<=num_events;++i)
		{
			if (time_next_event[i] < min_time_next_event)
				{
					min_time_next_event=time_next_event[i];
					next_event_type=i;
				}
		}
			
		if(next_event_type==0)
		{
			System.out.println("Event List is Empty");
			System.exit(1);
		}
		sim_time = min_time_next_event;
	}
	
	
	 
	
	public void arrive(double newTime,int ServerName)
	{
		double delay;
		if(ServerName==1)
		{
			time_next_event[1]= sim_time+expon(mean_interarrival_1st_Server);
		}
		num_KG_METAL[ServerName]+=1;
		if (server_status[ServerName] == 1)
		{
			num_in_q[ServerName]+=1;
			if(num_in_q[ServerName]>Queue_size)
			{
				System.out.println("Over flow of the queue time arrival at "+sim_time);
				System.exit(2);
			}
			time_arrival[ServerName][num_in_q[ServerName]] = newTime;
		}
	 
		else
		{
			delay = 0;
			total_of_delays[ServerName] += delay;
			server_status[ServerName] = 1;
			time_next_event[ServerName+1] = sim_time + expon(mean_service[ServerName]);
			
		}
	}
	
	
	
	
	public  void depart(int ServerName)
	{
		
		double delay;
		if (num_in_q[ServerName] == 0)
		{
			server_status[ServerName] = 0;
			time_next_event[ServerName+1] = Math.pow(10, +30);
		}
		else
		{
			num_in_q[ServerName]-=1;
			delay = sim_time-time_arrival[ServerName][1];
			total_of_delays[ServerName]  += delay;
			time_next_event[ServerName+1] = sim_time + expon(mean_service[ServerName]);
			
			for (int i = 1; i <= num_in_q[ServerName]; ++i)
				time_arrival[ServerName][i] = time_arrival[ServerName][i+1];
		}
		double x =ran.nextDouble();
		if(ServerName==1)
		{
			//double x =ran.nextDouble();
			if(x>0.9)
			{
				arrive(sim_time,2);
				update_time_avg_stats(2);
			}
			else if(x>.70&&x<=.9){
				arrive(sim_time,3);
				update_time_avg_stats(3);
			}
			else if(x>.30&&x<=.7)
			{
				arrive(sim_time,4);
				update_time_avg_stats(4);
			}
			else if(x>.10&&x<=.3)
			{
				arrive(sim_time,5);
				update_time_avg_stats(5);
			}
			else
			{
				arrive(sim_time,6);
				update_time_avg_stats(6);
			}
		
		}
		if(ServerName==6)
		{
			//double x =ran.nextDouble();
			if(x>.3)
			{
				arrive(sim_time,7);
				update_time_avg_stats(7);
			}
			else 
			{
				arrive(sim_time,8);
				update_time_avg_stats(8);
			}
		}
		
	}
	String result;
	public  String Report(int ServerName)
	{  
            result="-------------------------------------------------------------------------\nTotal num_KG_METAL server "+num_KG_METAL[ServerName]+"\nAverage number in  queue "+area_num_in_q[ServerName]/ sim_time+"\nServer utilization  "+area_server_status[ServerName] / sim_time+"\n---------------------------------\n";
            
            return result;
	}
	
	public  void update_time_avg_stats(int ServerName)
	{
		double time_since_last_event;
	 
		time_since_last_event = sim_time - time_last_event[ServerName];
		time_last_event[ServerName] = sim_time;	 
		area_num_in_q[ServerName] += num_in_q[ServerName] * time_since_last_event;	 
		area_server_status[ServerName] += server_status[ServerName] * time_since_last_event;
	}


	public  double expon(double  mean)
	{
		return (-mean * Math.log(random.nextDouble()));
	}
	

}
