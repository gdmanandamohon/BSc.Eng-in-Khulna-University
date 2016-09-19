package gausjordan;
/**
 * Ananda Mohon Ghosh
 */
import java.util.*;
public class NewGsJrdn
{
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
		System.out.println("Enter coeff. in format  \n \t\t\t ax1+bx2+c3=d");
		
		for(int row=0;row<unknowns;row++)
		{
			for(int column=0;column<unknowns+1;column++)
			{
				dimention_array [row][column]=sc.nextFloat();
			}
		}
		
		/*for(int row=0;row<unknowns;row++)
		{
			for(int column=0;column<unknowns+1;column++)
			{
				System.out.print(dimention_array [row][column]+"  ");
			}
			System.out.println("\n");
		}
		System.out.println("\n");*/
		
		
		
		//elimination
		/*float pivote;
		for(int k=0;k<unknowns-1;k++)
		{
			for(int i=k+1;i<unknowns;i++)
			{
				divider=dimention_array[i][k]/dimention_array[k][k];
				pivote=dimention_array[k][k];
				for(int j=0;j<unknowns+1;j++)
				{
					if(i==k)
					dimention_array[i][j]/=pivote;
					else
						dimention_array[i][j]=dimention_array[i][j]-dimention_array[k][j]*divider;
				}
			}
		}*/
		/*for(int i=0;i<unknowns;i++){
			float temp1=dimention_array[i][i];
			for(int j=0;j<unknowns+1;j++){
				dimention_array[i][j]=dimention_array[i][j]/temp1;	
			}
			for(int row=0;row<unknowns;row++)
			{
				for(int column=0;column<unknowns+1;column++)
				{
					System.out.print(dimention_array [row][column]+"  ");
				}
				System.out.println("\n");
			}
			System.out.println("\n");
			for(int k=0;k<unknowns;k++){
				if(i!=k){
					for(int l=0;l<unknowns+1;l++){
						//System.out.println("\n dimention_array[k][l]=dimention_array[k][l]-dimention_array[i][l]*dimention_array[k][i] "+dimention_array[k][l]+"  "+(dimention_array[k][l]-dimention_array[i][l]*dimention_array[k][i])+"   "+dimention_array[k][l]+"  "+dimention_array[i][l]+" "+dimention_array[k][i]+" ");
						dimention_array[k][l]=dimention_array[k][l]-dimention_array[i][l]*dimention_array[k][i];	
					}
				}
			}
		}*/
		
		int k,i,j;
		float m,p;
		for(k=0; k<=unknowns-1; k++)
	    {
			
	        for(i=0; i<=unknowns-1; i++)
	        {
	            m=dimention_array[i][k]/dimention_array[k][k];
	            p=dimention_array[k][k];

	            //
	            for(int row=0;row<unknowns;row++)
				{
					for(int column=0;column<unknowns+1;column++)
					{
						System.out.print(dimention_array [row][column]+"  ");
					}
					System.out.println("\n");
				}
	            System.out.println("\n");System.out.println("\n");
	            
	            //
	            
	            for(j=k; j<=unknowns; j++)
	            {
	                if(i==k)
	                    dimention_array[i][j]=dimention_array[i][j]/p;
	                else
	                    dimention_array[i][j]=dimention_array[i][j]-m*dimention_array[k][j];
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