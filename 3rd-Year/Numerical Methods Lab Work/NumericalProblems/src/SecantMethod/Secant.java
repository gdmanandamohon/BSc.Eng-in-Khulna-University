package SecantMethod;
import java.util.Scanner;
public class Secant {
	/**
	 * @param args
	 * Ananda Mohon Ghosh
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub x0=1.4,x1=1.45
		System.out.println("Secant method for the equation of { x^3+3x-5 }  ");
		Scanner sc=new Scanner(System.in);
		double x0,xi,xi_old,et=100;
		System.out.println("enter initial estimate of xi-1:");
		x0=sc.nextDouble();
		System.out.println("enter finall estimate of xi:");
		xi=sc.nextDouble();
		
		if(check_function(x0,xi)==1)
		{
				System.out.println();
				System.out.println("------------------------------------------------");
				System.out.println("i        xi-1			xi                  et% ");
				System.out.println("------------------------------------------------");
				System.out.println("1"+"     "+x0 +"    "+xi+"        "+"   --");
				for(int itreation=1;;itreation++)
				{
					
					xi_old=xi;
					xi=xi-(function_x(xi)*(x0-xi))/(function_x(x0)-function_x(xi));
					et=function_error_count(x0,xi);
					x0=xi_old;
					System.out.println(itreation+1+"     "+x0 +"    "+xi+"        "+et);
					
					if(et<0.000000000001)
					{
						System.out.println(itreation+1+"     "+x0 +"    "+xi+"        "+et);
						System.out.println("\n So the root is : "+xi);
						break;
						
					}		
				}
		}
		
		
	}
	static int check_function(double x1,double x2){
		if( ((function_x(x1)*function_x(x2)))>0)
	    {
	        System.out.println("\n\t INTIAL VALUES ARE NOT PERFECT.");
	        return(0);
	    }
		return 1;
	}
	
	static double function_error_count( double xi_old,double xi){
		return Math.abs(((xi- xi_old)/xi)*100);
	}

	static double function_x( double value_x){
		return (value_x*value_x*value_x+3*value_x - 5);
	}
}
