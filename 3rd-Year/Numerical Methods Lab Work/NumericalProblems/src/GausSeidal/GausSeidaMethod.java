package GausSeidal;

import java.util.Scanner;

public class GausSeidaMethod {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the no of unknowns\n");
		int unknowns=sc.nextInt();
		float dimention_array [][]=new float[unknowns][unknowns+1];
		float divider,sum,backward_array[]=new float[unknowns+1];
		float absolute_value[]=new float[unknowns];
		System.out.println("Enter coeffecient in this format  \n \t\t\t ax1+bx2+c3=d");
		
		for(int row=0;row<unknowns;row++){
			for(int column=0;column<unknowns+1;column++){
				dimention_array [row][column]=sc.nextFloat();
			}
		}
		
		for(int i=0;i<unknowns;i++){
			System.out.print("absolute_value of unknown"+(i+1)+" : \n");
			absolute_value[i]=sc.nextFloat();
		}
		
		for(int row=0;row<unknowns;row++){
				for(int column=0;column<unknowns+1;column++){
					System.out.print(dimention_array [row][column]+"  ");
				}
				System.out.println("\n");
		}
	
			
		for(int k=0;k<50;k++){
	
			for(int i=0;i<unknowns;i++){
				sum=dimention_array[i][unknowns];
				for(int j=0;j<unknowns;j++){
					sum=sum-dimention_array[i][j]*backward_array[j];
					System.out.println("   "+i+"  "+j+" dimention_array[i][j]: "+dimention_array[i][j]+" sum: "+sum);
				}
				System.out.println();
				backward_array[i]=sum/dimention_array[i][i];
			}
			System.out.println();
			for(int i=0;i<unknowns;i++)
			{
				System.out.print("unknown"+(i+1)+" : "+backward_array[i]+"\n");
			}
			//if(true)
				//break;
		}
		System.out.println();
		for(int i=0;i<unknowns;i++)
		{
			System.out.print("unknown"+(i+1)+" : "+backward_array[i]+"\n");
		}
		
	
	}
	
}
