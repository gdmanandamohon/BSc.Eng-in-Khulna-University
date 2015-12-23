package myForgy;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ForgysClustering {

	/**
	 * @param args
	 * @author Ananda  Mohon Ghosh
	 */
	static Scanner sc =new Scanner(System.in);
	static Scanner scf;
	static StringTokenizer string_token;
	static float distance[];
	static int k, counter[];
	static int positionFixer[];
	static List<List<String>> listOfLists;
	static float [][] dataset;
	static float seeds [][],tempSeeds [][];
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		System.out.print("Enter number of Cluster");
		k =sc.nextInt();
		seeds = new float[k][2]; 
		tempSeeds= new float[k][2];
		dataset = new float[5][2];
		counter =new int[k];
		distance =new float[k];
		positionFixer =new int[5];
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
			counter[i]=0;
			tempSeeds[i][0]=0;
			tempSeeds[i][1]=0;
			
		}
		//executes
		while(true)
		{
			for (int i = 0; i < dataset.length; i++) 
			{
				int position =findsmallest_index(seeds, dataset[i][0], dataset[i][1]);
				//System.out.println(position);
				positionFixer[i]=position;
				
			}
			for (int i = 0; i < dataset.length; i++) {
				//System.out.println(tempSeeds[positionFixer[i]][0]+"   "+ tempSeeds[positionFixer[i]][1]);
				//System.out.println(dataset[i][0]+"   "+ dataset[i][1]);
				tempSeeds[positionFixer[i]][0]=(dataset[i][0]+tempSeeds[positionFixer[i]][0]*counter[positionFixer[i]])/(counter[positionFixer[i]]+1);
				tempSeeds[positionFixer[i]][1]=(dataset[i][1]+tempSeeds[positionFixer[i]][1]*counter[positionFixer[i]])/(counter[positionFixer[i]]+1);
				//System.out.println(tempSeeds[positionFixer[i]][0]+"   "+ tempSeeds[positionFixer[i]][1]);
				++counter[positionFixer[i]];
			}
			/*for (int i = 0; i < k; i++) 
			{
				System.out.println("Seeds X=" +tempSeeds[i][0]+"Y = "+ tempSeeds[i][1]);
			}*/
			int loclCount=0;
			for (int i = 0; i < k; i++) 
			{
				if(tempSeeds[i][0]!=seeds[i][0]&&tempSeeds[i][1]!=seeds[i][1])
				{
					seeds[i][0]=tempSeeds[i][0];
					seeds[i][1]=tempSeeds[i][1];
				}
				else {
					loclCount++;
				}	
			}
			if(loclCount==k)
			{
				
				for (int i = 0; i < k; i++) {
					System.out.println("Seeds X=" +tempSeeds[i][0]+"Y = "+ tempSeeds[i][1]);
				}
				
				clustering() ;
				showCluster();
				System.out.println("\n\nEnter the Testing value X,Y ");
				float x =sc.nextFloat();
				float y = sc.nextFloat();
				
				search_a_Data(x,y);
				System.exit(0);
				
			}
		}
	}
	private static void search_a_Data(float x, float y) {
		
		int position =findsmallest_index(seeds, x, y);
		System.out.println("Nearest Cluster is "+(position+1));
	}
	private static void showCluster() {
		// TODO Auto-generated method stub
		for (int i = 0; i < k; i++) {
			
			System.out.println("Cluster "+(i+1)+" : "+listOfLists.get(i));
			
		}
		
	}
	private static void clustering() 
	{
		// TODO Auto-generated method stub
		for (int i = 0; i < dataset.length; i++) 
		{
			int position =findsmallest_index(seeds, dataset[i][0], dataset[i][1]);
			listOfLists.get(position).add("{"+String.valueOf(dataset[i][0])+","+String.valueOf(dataset[i][1])+"}");
		}
		
		
	}
	private static  int findsmallest_index( float [][]seeds, float x, float y) 
	{
		for (int i = 0; i < k; i++) 
		{
			distance[i] =(float) Math.sqrt( (seeds[i][0] -x)*(seeds[i][0] -x)+(seeds[i][1] -y)*(seeds[i][1] -y) );
			//System.out.println(distance[i]);
		}
		float small =100000000;
		int index=0;
		for (int i = 0; i < distance.length; i++) 
		{
			if(small>distance[i])
			{
				index = i;
				small=distance[i];
			}
		}
		
		return index;
	}

}
