package GausJordanMethod;

import java.util.Scanner;

public class GausJordan {

	/**
	 * @param args
	 * Ananda Mohon Ghosh
	 */
	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the no of unknowns\n");
		int unknowns=3;//sc.nextInt();
		float dimention_array [][]=new float[unknowns][unknowns+1];
		float divider,sum,backward_array[]=new float[unknowns+1];
		System.out.println("Enter coeff. in format  \n \t\t\t ax1+bx2+c3=d");
		
		for(int row=0;row<unknowns;row++)
		{
			for(int column=0;column<unknowns+1;column++)
			{
				dimention_array [row][column]=sc.nextFloat();
			}
		}
		//devide 1st row by a11
		float devider=dimention_array[0][0];
		for(int i=0;i<unknowns+1;i++)
		{
			dimention_array[0][i]=dimention_array[0][i]/devider;
		}
			
		//subtract 2nd row=2nd row-1st row*a21
		float multiplier=dimention_array[1][0];
		//System.out.println(multiplier);
		for(int i=0;i<unknowns+1;i++)
		{
			dimention_array[1][i]=dimention_array[1][i]-dimention_array[0][i]*multiplier;	
		}
		
		//subtract 3rd row=3rd row-1st row*a21
		multiplier=dimention_array[2][0];
		//System.out.println(multiplier);
		for(int i=0;i<unknowns+1;i++)
		{			
			dimention_array[2][i]=dimention_array[2][i]-dimention_array[0][i]*multiplier;
		}
		
		//devide 2nd row by a22
		 devider=dimention_array[1][1];
		for(int i=0;i<unknowns+1;i++)
		{
			dimention_array[1][i]=dimention_array[1][i]/devider;
		}	
		//subtract 1st row=1st row-2nd row*a22
		multiplier=dimention_array[0][1];
		//System.out.println(multiplier);
		for(int i=0;i<unknowns+1;i++)
		{
					
			dimention_array[0][i]=dimention_array[0][i]-dimention_array[1][i]*multiplier;
		}
		//subtract3rd row=3rd row-2nd row*a22
		multiplier=dimention_array[2][1];
		//System.out.println(multiplier);
		for(int i=0;i<unknowns+1;i++)
		{
							
			dimention_array[2][i]=dimention_array[2][i]-dimention_array[1][i]*multiplier;
		}
		
		//3rd step
		//devide 2nd row by a33
		 devider=dimention_array[2][2];
		for(int i=0;i<unknowns+1;i++)
		{
			dimention_array[2][i]=dimention_array[2][i]/devider;
		}

		//subtract 1st row=1st row-3rd row*a33
		multiplier=dimention_array[0][2];
		//System.out.println(multiplier);
		for(int i=0;i<unknowns+1;i++)
		{
					
			dimention_array[0][i]=dimention_array[0][i]-dimention_array[2][i]*multiplier;
		}
		//subtract 2nd row=2nd row-3rd row*a33
		multiplier=dimention_array[1][2];
		//System.out.println(multiplier);
		for(int i=0;i<unknowns+1;i++)
		{
							
			dimention_array[1][i]=dimention_array[1][i]-dimention_array[2][i]*multiplier;
		}

		for(int row=0;row<unknowns;row++)
		{
			for(int column=0;column<unknowns+1;column++)
			{
				System.out.print(dimention_array [row][column]+"  ");
			}
			System.out.println("\n");
		}
		System.out.println(" the Solution is : \n");
		for(int i=0;i<unknowns;i++)
			System.out.println("Unknown"+i+" "+dimention_array[i][3]);
		
		
	}*/
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter the no of unknowns\n");
			int unknowns=sc.nextInt();
			float dimention_array [][]=new float[unknowns][unknowns+1];
			float divider,sum,backward_array[]=new float[unknowns+1];
			System.out.println("Enter coeff. in format  \n \t\t\t ax1+bx2+c3=d");
			
			for(int row=0;row<unknowns;row++)
			{
				for(int column=0;column<unknowns+1;column++)
				{
					dimention_array [row][column]=sc.nextFloat();
				}
			}
			
			
			for(int i=0;i<unknowns;i++){
				float temp1=dimention_array[i][i];
				for(int j=0;j<unknowns+1;j++){
					dimention_array[i][j]=dimention_array[i][j]/temp1;	
				}
				for(int row=0;row<unknowns;row++){
					for(int column=0;column<unknowns+1;column++){
						System.out.print(dimention_array [row][column]+"  ");
					}
					System.out.println("\n");
				}
				System.out.println("\n");
				for(int k=0;k<unknowns;k++){
					float value=dimention_array[k][i];
					if(i!=k){
						for(int l=0;l<unknowns+1;l++){
							
							dimention_array[k][l]=dimention_array[k][l]-dimention_array[i][l]*value;	
						}
					}
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
			System.out.println("\n\t\t The Solutions are \n");
			for(int column=0;column<unknowns;column++)
			{
				System.out.println("unknown"+column+1+" : "+dimention_array[column][unknowns]);
			}
			
		}
}
