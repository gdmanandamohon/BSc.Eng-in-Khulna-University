package NavGAUS;

import java.util.Scanner;

public class NvGassPB {

	/**
	 * @param args
	 * Ananda Mohon Ghosh
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the no of unknowns\n");
		int unknowns=sc.nextInt();
		float dimention_array [][]=new float[unknowns][unknowns+1];
		float divider,sum,backward_array[]=new float[unknowns+1];
		System.out.println("Enter coeffecient in this format  \n \t\t\t ax1+bx2+c3=d");
		
		for(int row=0;row<unknowns;row++)
		{
			for(int column=0;column<unknowns+1;column++)
			{
				dimention_array [row][column]=sc.nextFloat();
			}
		}
		for(int row=0;row<unknowns;row++)
		{
			for(int column=0;column<unknowns+1;column++)
			{
				System.out.print(dimention_array [row][column]+"  ");
			}
			System.out.println("\n");
		}
		
		//divide with divider
		
		for(int k=0;k<unknowns-1;k++)
		{
			for(int i=k+1;i<unknowns;i++)
			{
				divider=dimention_array[i][k]/dimention_array[k][k];
				for(int j=0;j<unknowns+1;j++)
				{
					dimention_array[i][j]=dimention_array[i][j]-dimention_array[k][j]*divider;
				}
			}
		}
		
		/*for(int row=0;row<unknowns;row++)
		{
			for(int column=0;column<unknowns+1;column++)
			{
				System.out.print(dimention_array [row][column]+"  ");
			}
			System.out.println("\n");
		}*/
		
		
		//
		
		////System.out.print("\n\n");
		//Forward Elimination
		for(int i=0;i<unknowns;i++)
		{
			for(int j=0;j<unknowns+1;j++)
			{
				System.out.print(dimention_array[i][j]+"\t");
			}
			System.out.print("\n");
		}
		
		System.out.print("\n");
		//Backward substituation
		for(int i=unknowns-1;i>=0;i--)
		{
			sum=dimention_array[i][unknowns];
			for(int j=i+1;j<unknowns;j++)
			{
				
				sum=sum-dimention_array[i][j]*backward_array[j];
				System.out.println("   "+i+"  "+j+" dimention_array[i][j]: "+dimention_array[i][j]+" sum: "+sum);
			}
			System.out.println();
			backward_array[i]=sum/dimention_array[i][i];
			
		}
		for(int i=0;i<unknowns;i++)
		{
			System.out.print("unknown"+(i+1)+" : "+backward_array[i]+"\n");
		}
		//
		/*
		for(int row=0;row<3;row++)
		{
			for(int column=0;column<4;column++)
			{
				System.out.print(dimention_array [row][column]+"  ");
			}
			System.out.println();
		}*/
	}

}
