package simulation;
import java.util.Random;
import java.util.Scanner;

public class SingleServeerQueueSystem {

	static Random random = new Random(10000);
	static Scanner sc = new Scanner(System.in);
	
	int Q_LIMIT=10000;
	int BUSY=1;
	int IDLE=0;
	int next_event_type;
	int num_custs_delayed;
	int num_delayes_required;
	int num_events=2 ;
	int num_in_q;
	int server_status;
	
	double area_num_in_q;
	double area_server_status;
	 double mean_interarrival;
	double mean_service;
	double sim_time;
	
	double []time_arrival= new double[Q_LIMIT+1];
	double time_last_event;
	double []time_next_event = new double[3];
	double total_of_delays;
	public void initialize()
	{
		sim_time=0;
		server_status = IDLE;
		server_status = IDLE;
		num_in_q = 0;
		time_last_event=0;
		
		num_custs_delayed = 0;
		total_of_delays = 0;
		area_num_in_q= 0;
		area_server_status = 0;
		time_next_event[1] = sim_time+expon(mean_interarrival);
		time_next_event[2] = (float) Math.pow(10, +30);
	}
	public void timing()
	{
		int i;
		double min_time_next_event=(float) Math.pow(10, +29);
		next_event_type=0;
		
		for(i=1;i<=num_events;++i)
		{
			if(time_next_event[i]<min_time_next_event)
			{
				min_time_next_event=time_next_event[i];
				next_event_type=i;
			}
		}
		if(next_event_type==0)
		{
			System.out.print("EventList empty"+sim_time);
			System.exit(1);
		}
		sim_time = min_time_next_event;
	}
	
	public void update_time_avg_stat()
	{
		double time_since_last_event;
		time_since_last_event = sim_time - time_last_event;
		time_last_event = sim_time;
		area_num_in_q+=num_in_q*time_since_last_event;
		area_server_status+=server_status*time_since_last_event;
	}
	public void arrive(double arrival_time)
	{
		double delay;
		time_next_event[1]=arrival_time;
		if(server_status==BUSY)
		{
			++num_in_q;
			if(num_in_q>Q_LIMIT)
			{				
				System.out.print("overflow of array at"+sim_time);
				System.exit(2);
			}
			time_arrival[num_in_q]=arrival_time;
		}
		else
		{
			delay=0;
			total_of_delays+=delay;
			++num_custs_delayed;
			server_status=BUSY;
			time_next_event[2]=sim_time+expon(mean_interarrival);
		}
	}
	public void depart()
	{
		int i;
		double delay;
		if(num_in_q==0)
		{
			server_status=IDLE;
			time_next_event[2]=(double) Math.pow(10, +30);
		}
		else
		{
			--num_in_q;
			delay=sim_time-time_arrival[1];
			total_of_delays+=delay;
			
			++num_custs_delayed;	
			time_next_event[2]=sim_time+expon(mean_service);
			for(i=1;i<=num_in_q;++i)
				time_arrival[i]=time_arrival[i+1];
		}
	}
	public String report() 
	{
		
		
		return "Report From Server"+"-------------------------------------\n"+ "Total customer this server " +num_custs_delayed + "\n"+"Average delay in queue  "+(total_of_delays/sim_time)+"\n Average number in queue  "+area_num_in_q/sim_time+"\n Server utilization  "+area_server_status/sim_time;
		
	}

    private double expon(double mean_interarrival) {
        return -mean_interarrival*Math.log(random.nextDouble());
    }
	
}

