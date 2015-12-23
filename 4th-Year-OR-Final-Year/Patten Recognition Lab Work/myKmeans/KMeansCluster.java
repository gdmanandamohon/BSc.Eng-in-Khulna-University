package myKmeans;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class KMeansCluster {

	/**
	 * @param args
	 * @author Ananda  Mohon Ghosh
	 */
	static Scanner sc =new Scanner(System.in);
	static Scanner scf;
	static StringTokenizer string_token;
	static float distance[];
	static int k, counter[];
	static List<List<String>> listOfLists;
	static float [][] dataset;
	static float seeds [][];
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		k =sc.nextInt();
		seeds = new float[k][2]; 
		dataset = new float[7][2];
		counter =new int[k];
		distance =new float[k];
		listOfLists= new ArrayList<List<String>>(k);
		for(int i = 0; i < k; i++)  {
	        listOfLists.add(new ArrayList<String>());
	    }
		
		
		try {
			 scf =new Scanner(new FileReader("F:/Java pgram class/PatternLab/src/myKmeans/aa.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i = 0; i < dataset.length; i++) 
		{
			//System.out.print(scf.nextLine());
			dataset[i][0]=scf.nextFloat();
			dataset[i][1] =scf.nextFloat();
			
		}
		//setting seeds
		for (int i = 0; i < k; i++) 
		{
			seeds[i][0]=dataset[i][0];
			seeds[i][1]=dataset[i][1];
			counter[i]=1;
			
		}
		
		for (int i = k; i < dataset.length; i++) 
		{
			int position =findsmallest_index(seeds, dataset[i][0], dataset[i][1]);
			System.out.println(position);
			
			seeds[position][0]= (seeds[position][0]*counter[position]+dataset[i][0])/(counter[position]+1);
			seeds[position][1]= (seeds[position][1]*counter[position]+dataset[i][1])/(counter[position]+1);
			counter[position]+=1;
			
		}
		for (int i = 0; i < k; i++) 
		{
			System.out.println("Seeds X=" +seeds[i][0]+"Y = "+ seeds[i][1]);
		}
		clustering();
		showCluster();
		search_a_Data();
		
		
	}
	private static void search_a_Data() {
		// TODO Auto-generated method stub
		int x =sc.nextInt();
		int y =sc.nextInt();
		String key = (x+","+y).toString();
		for (int i = 0; i < k; i++) {
			for (int j = 0; j < listOfLists.get(i).size(); j++) {
				if(listOfLists.get(i).get(j).trim().compareTo(key)==0)
					System.out.println("Found in Cluster "+i+1);
			}
			
		}
		
	}
	private static void showCluster() {
		// TODO Auto-generated method stub
		for (int i = 0; i < k; i++) {
			
			System.out.println(listOfLists.get(i));
			
		}
		
	}
	private static void clustering() 
	{
		// TODO Auto-generated method stub
		for (int i = 0; i < dataset.length; i++) 
		{
			int position =findsmallest_index(seeds, dataset[i][0], dataset[i][1]);
			listOfLists.get(position).add((dataset[i][0]+","+dataset[i][1]).toString());
		}
		
		
	}
	private static  int findsmallest_index( float [][]seeds, float x, float y) 
	{
		for (int i = 0; i < k; i++) 
		{
			distance[i] =(float) Math.sqrt( (seeds[i][0] -x)*(seeds[i][0] -x)+(seeds[i][1] -y)*(seeds[i][1] -y) );
			System.out.println(distance[i]);
		}
		float small =100000000;
		int index=0;
		for (int i = 0; i < distance.length; i++) 
		{
			//System.out.println("small"+small+" "+"Diast"+distance[i]);
			if(small>distance[i])
			{
				index = i;
				small=distance[i];
			}
			//System.out.println(small+"  "+i+"   "+index);
		}
		
		return index;
	}

}
