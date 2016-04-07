package simulation;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class MultiServerCarREp {

	static Random random = new Random(10000);
	static Scanner sc = new Scanner(System.in);
	
	int Q_LIMIT=10000;
	int BUSY=1;
	int IDLE=0;
	int BUSY2=1;
	int IDLE2=0;
	
	int next_event_type;
	int num_custs_delayed_ins,num_custs_delayed_rep;
	int num_delayes_required_ins,num_delayes_required_rep;
	int num_events=3 ;
	int num_in_q_ins,num_in_q_rep;
	int server_status_ins,server_status_rep;
	
	double area_num_in_q_ins,area_num_in_q_rep;
	double area_server_status_ins,area_server_status_rep;
	double mean_interarrival;
	double sim_time;
	
	double []time_arrival_ins= new double[Q_LIMIT+1];
	double []time_arrival_rep = new double[Q_LIMIT+1];
	double time_last_event_ins,time_last_event_rep;
	double []time_next_event = new double[4];
	double total_of_delays_ins,total_of_delays_rep;
	
	double inspection_dis_up;
	double inspection_dis_down;
	
	double repair_dis_up;
	double repair_dis_down;
	
	public void initialize()
	{
		sim_time=0;
		server_status_ins = IDLE;
		server_status_rep = IDLE;
		num_in_q_ins=0;num_in_q_rep = 0;
		time_last_event_ins = 0;time_last_event_rep=0;
		
		num_custs_delayed_ins = 0;num_custs_delayed_rep = 0;
		total_of_delays_ins = 0;total_of_delays_rep = 0;
		area_num_in_q_ins = 0;area_num_in_q_rep = 0;
		area_server_status_ins = 0;area_server_status_rep = 0;
		time_next_event[1] = sim_time+expon(mean_interarrival);
		time_next_event[2] = (float) Math.pow(10, +30);
		time_next_event[3] = (float) Math.pow(10, +30);
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
	
	public void update_time_avg_stats_inspection()
	{
		double time_since_last_event;
		time_since_last_event = sim_time - time_last_event_ins;
		time_last_event_ins = sim_time;
		area_num_in_q_ins+=num_in_q_ins*time_since_last_event;
		area_server_status_ins+=server_status_ins*time_since_last_event;
	}
	
	public void update_time_avg_stats_repair()
	{
		double time_since_last_event2;
		time_since_last_event2 = sim_time - time_last_event_rep;
		time_last_event_rep = sim_time;
		area_num_in_q_rep+=num_in_q_rep*time_since_last_event2;
		area_server_status_rep+=server_status_rep*time_since_last_event2;
	}
	
	public void arrive_inspectation(double arrival_time)
	{
		double delay;
		time_next_event[1]=arrival_time;
		if(server_status_ins==BUSY)
		{
			++num_in_q_ins;
			if(num_in_q_ins>Q_LIMIT)
			{				
				System.out.print("overflow of array at"+sim_time);
				System.exit(2);
			}
			time_arrival_ins[num_in_q_ins]=arrival_time;
		}
		else
		{
			delay=0;
			total_of_delays_ins+=delay;
			++num_custs_delayed_ins;
			server_status_ins=BUSY;
			time_next_event[2]=sim_time+uniform_dis(inspection_dis_down, inspection_dis_up);
		}
	}
	public  void start_repair_station(double time)
	{	
		update_time_avg_stats_repair();	
		arrive_repair(time);			
	}
	public void arrive_repair(double arrival_time)
	{
		double delay;
		time_next_event[2]=arrival_time;
		if(server_status_rep==BUSY2)
		{
			++num_in_q_rep;
			if(num_in_q_rep>Q_LIMIT)
			{
				System.out.print("Server 2 overflow of array  at"+sim_time);
				System.exit(2);
			}
			time_arrival_rep[num_in_q_rep]=sim_time;
		}
		else
		{
			delay=0;
			total_of_delays_rep+=delay;
			++num_custs_delayed_rep;
			server_status_rep=BUSY2;
			time_next_event[3]=sim_time+uniform_dis(repair_dis_down, repair_dis_up);
		}
	}
	public void depart_inspectation()
	{
		int i;
		double delay;
		if(num_in_q_ins==0)
		{
			server_status_ins=IDLE;
			time_next_event[2]=(double) Math.pow(10, +30);
		}
		else
		{
			--num_in_q_ins;
			delay=sim_time-time_arrival_ins[1];
			total_of_delays_ins+=delay;
			
			++num_custs_delayed_ins;	
			time_next_event[2]=sim_time+uniform_dis(inspection_dis_down, inspection_dis_up);
			for(i=1;i<=num_in_q_ins;++i)
				time_arrival_ins[i]=time_arrival_ins[i+1];
		}
	}
	public void depart_repair()
	{
		int i;
		double delay;
		if(num_in_q_rep==0)
		{
			server_status_rep=IDLE2;
			time_next_event[3]=(double) Math.pow(10, +30);
		}
		else
		{
			--num_in_q_rep;
			delay=sim_time-time_arrival_rep[1];
			total_of_delays_rep+=delay;
			
			++num_custs_delayed_rep;
			
			
			
			time_next_event[3]=sim_time+uniform_dis(repair_dis_down, repair_dis_up );
			for(i=1;i<=num_in_q_rep;++i)
				time_arrival_rep[i]=time_arrival_rep[i+1];
		}
	}
	String sttr;
	public String report_inspectation() 
	{
		
		/*System.out.println("For inspection");
		System.out.println("-------------------------------------");
		System.out.println( "Total buses this server " +num_custs_delayed_ins + "\n");
		System.out.println("Average delay in queue  "+(-total_of_delays_ins/sim_time));
		System.out.println("Average number in queue  "+area_num_in_q_ins/sim_time);
		System.out.println("Server utilization  "+area_server_status_ins/sim_time);*/
            sttr ="For inspection\n"+"-------------------------------------"+"Total buses this server " + num_custs_delayed_ins + "\n"+"Average delay in queue  "+-total_of_delays_ins/sim_time+"\nServer utilization  "+area_server_status_ins/sim_time+"\n------------------------------------------------\n\n";
                return sttr;
		
		
	}
	public String report_repair() 
	{
		//System.out.println();
		//System.out.println("For repairing");
		//System.out.println("-------------------------------------");
		//System.out.println( "Total buses this server " + num_custs_delayed_rep + "\n");	
		//System.out.println("Average delay in queue  "+total_of_delays_rep/sim_time);
		//System.out.println("Average number in queue  "+area_num_in_q_rep/sim_time);
		//System.out.println("Server utilization  "+area_server_status_rep/sim_time);
		//System.out.println("\n \n Total simulation Ends time  "+(sim_time));
            sttr ="For repairing\n"+"-------------------------------------"+"Total buses this server " + num_custs_delayed_rep + "\n"+"Average delay in queue  "+total_of_delays_rep/sim_time+"\nServer utilization  "+area_server_status_rep/sim_time+"\n-------------------------------------------------------\n\n";
                return sttr;
	}

    private double expon(double mean_interarrival) {
        return -mean_interarrival*Math.log(random.nextDouble());
    }

    private double uniform_dis(double inspection_dis_down, double inspection_dis_up) {
       return (inspection_dis_down+(inspection_dis_up-inspection_dis_down)*random.nextDouble());
    }
}
