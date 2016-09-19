package GausSeidal;

import java.util.Scanner;

public class GausSeidaMethod {

	/**
	 * @param args
	 */
	
	public static void main(String[] args){
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the no of unknowns\n");
		int unknowns=sc.nextInt();
		float dimention_array [][]=new float[unknowns][unknowns+1];
		float divider,sum,backward_array[]=new float[unknowns+1];
		float[] absolute_solution=new float[unknowns];
		System.out.println("Enter coeffecient in this format  \n \t\t\t ax1+bx2+c3=d");
		
		for(int row=0;row<unknowns;row++)
		{
			for(int column=0;column<unknowns+1;column++)
			{
				dimention_array [row][column]=sc.nextFloat();
				if(dimention_array [row][column]==0&&row==column)
				{
					System.out.print("Error input try again");
					System.exit(1);
				}
			}
		}
		System.out.println("\n \t Enter absolute value of Unknowns : ");
		for(int i=0;i<unknowns;i++)
		{
			System.out.print(" \n unknown"+(i+1)+" : ");
			absolute_solution[i]=sc.nextFloat();
			
		}
		
		for(int row=0;row<unknowns;row++)
		{
			for(int column=0;column<unknowns+1;column++)
			{
				System.out.print(dimention_array [row][column]+"  ");
			}
			System.out.println("\n");
		}
		
		for(int pp=0;pp<20;pp++){
			for(int row=0;row<unknowns;row++){
				sum=dimention_array[row][unknowns];
				for(int column=0;column<unknowns;column++){
					if(row!=column)
						sum-=dimention_array[row][column]*backward_array[column];
				}
				backward_array[row]=sum/dimention_array[row][row];
			}
		
			for(int i=0;i<unknowns;i++)
			{
				System.out.print("unknown"+(i+1)+" : "+backward_array[i]+" ");
				System.out.println("\terror for unknown"+(i+1)+"="+(Math.abs(backward_array[i]-absolute_solution[i])/absolute_solution[i]*100));
				
			}
			if((Math.abs(backward_array[0]-absolute_solution[0])/absolute_solution[0]*100)<0.01)
				break;
	}
		for(int i=0;i<unknowns;i++)
		{
			System.out.print("unknown"+(i+1)+" : "+backward_array[i]+"\n");
			
			
		}
	}

}
