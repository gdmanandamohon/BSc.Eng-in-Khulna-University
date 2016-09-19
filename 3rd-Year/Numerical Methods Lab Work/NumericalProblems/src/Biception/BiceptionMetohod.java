package Biception;
import java.util.Scanner;
public class BiceptionMetohod 
{

	/**
	 * @param args
	 * Ananda Mohon Ghosh
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		System.out.println("Biception method for the equation of {  x^3+3x-5 }  ");
		Scanner sc=new Scanner(System.in);
		double x_low,x_up,xi_old,x_mid=0, et=100;
		System.out.println("enter initial guess of x0:");
		x_low=sc.nextDouble();
		System.out.println("enter finall guess of x0:");
		x_up=sc.nextDouble();
		System.out.println();
		System.out.println("-------------------------------");
		System.out.println("i        xi            xu            x_mid          es% ");
		System.out.println("-------------------------------");
		System.out.println(" 1"+"    "+x_low+"			"+x_up+"		"+"  "+"        "+"  ");
		for(int itreation=2;;itreation++)
		{
			xi_old=x_mid;
			x_mid=(x_up+x_low)/2;
			if(et==0)
			{
				System.out.println(itreation+"    "+x_low+"			"+x_up+"		"+x_mid+"        "+et);
				System.out.println("estimated value is : "+x_mid);
				break;
			}
			else if(function_x(x_mid)*function_x(x_low)>0)
			{
				x_low=x_mid;
				et=function_error_count(xi_old,x_mid);
				System.out.println(itreation+"    "+x_low+"			"+x_up+"		"+x_mid+"        "+et);
			}
			else if(function_x(x_mid)*function_x(x_low)<0)
			{
				x_up=x_mid;
				et=function_error_count(xi_old,x_mid);
				System.out.println(itreation+"    "+x_low+"			"+x_up+"		"+x_mid+"        "+et);
			}
			else 
			{
				System.out.println("estimated value is : "+x_mid);
				break;
			}
		}
	}
	static double function_error_count( double xi_old,double xi){
		return Math.abs(((xi- xi_old)/xi)*100);
	}
	static double function_x( double value_x)
	{
		return (value_x*value_x*value_x+3*value_x - 5);
	}
}


