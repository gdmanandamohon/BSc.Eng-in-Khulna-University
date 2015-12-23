import java.io.*;
import java.util.*;
public class Test {
	public static void main(String[] args) {
	
		Vector<Student> v=new Vector<Student>();
		
		try {
			Scanner sc =new Scanner (new File ("C:\\input.txt"));
				while (sc.hasNext()) 
				{
					Student st=new Student();
					st.name = sc.next();
					st.roll = sc.next();
					st.year = sc.next();
					st.adress = sc.next();
					v.addElement(st);
				} 
				//new student adding
				System.out.println("Enter Number of Student to join");
				Scanner sr=new Scanner(System.in);
				int newst=sr.nextInt();
				for(int i=0;i<newst;i++)
				{
					Student st=new Student();
					st.name = sr.next();
					st.roll = sr.next();
					st.year = sr.next();
					st.adress = sr.next();
					v.addElement(st);
				}
				int count=0;
				for(int j=0;j<v.size();j++)
					{
					if(v.elementAt(j).address.compareToIgnoreCase("Khulna")==0)
					System.out.println(v.elementAt(j).name+" "+v.elementAt(j).roll+" "+v.elementAt(j).year+" "+v.elementAt(j).address);
					}
			
			sc.close();	
		}
			
			catch (FileNotFoundException e) {
				e.printStackTrace();
		}
		
		
	}	

}

