package NewtonRapson;
import java.util.Scanner;
public class Newtonrapsonmethod {
	/**
	 * @param args
	 * Aannada Mohon Ghosh
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub x0=0
		System.out.println("Newton Rapson method for the equation of { x^3+3x-5 }  ");
		Scanner sc=new Scanner(System.in);
		double x0,xi,xi_old,et=100;
		System.out.println("enter initial guess of x0:");
		x0=sc.nextDouble();
		xi=x0;
		System.out.println();
		System.out.println("-------------------------------");
		System.out.println("i        xi                  et% ");
		System.out.println("-------------------------------");
		for(int itreation=1;;itreation++){
			System.out.println(itreation+"    "+xi+"        "+et);
			xi_old=xi;
			xi=xi-(function_x(xi)/function_dx(xi));
			et=function_error_count(xi_old,xi);
			if(et==0){
				System.out.println(itreation+1+"    "+xi+"        "+et);
				System.out.println("estimated value is : "+xi);
				break;
			}
		}
	}
	static double function_error_count( double xi_old,double xi){
		return Math.abs(((xi- xi_old)/xi)*100);
	}
	static double function_x( double value_x){
		return (value_x*value_x*value_x+3*value_x - 5);
	}
	static double function_dx( double value_x){
		return (3*value_x*value_x+3);
	}
}
