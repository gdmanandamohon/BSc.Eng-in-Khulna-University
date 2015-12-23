/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ananda Mohon Ghosh
 */

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Kmeans_Class 
{
    static Scanner sc =new Scanner(System.in);
    static Scanner scf;
    static StringTokenizer string_token;
    static float distance[];
    static int k, counter[];
    static List<List<String>> listOfLists;
    static float [][] dataset;
     public static float seeds [][];
    Random rnd ;
    Random rndInt;
    public float generate_random( )
    {
        
        return 0;
    }
    public  void execute(int no_k) 
    {
                k =no_k;
                rnd = new Random();
		seeds = new float[k][2]; 
		dataset = new float[1000][2];
		counter =new int[k];
		distance =new float[k];
		listOfLists= new ArrayList<List<String>>(k);
		for(int i = 0; i < k; i++)  {
	        listOfLists.add(new ArrayList<String>());
                }
		
		
		
		for (int i = 0; i < dataset.length; i++) 
		{
			//System.out.print(scf.nextLine());
			dataset[i][0]=rnd.nextInt(no_k-1);
                        
			dataset[i][1] = dataset[i][0]*rnd.nextFloat();
			
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
			//System.out.println(position);
			
			seeds[position][0]= (seeds[position][0]*counter[position]+dataset[i][0])/(counter[position]+1);
			seeds[position][1]= (seeds[position][1]*counter[position]+dataset[i][1])/(counter[position]+1);
			counter[position]+=1;
			
		}
		for (int i = 0; i < k; i++) 
		{
			//System.out.println("Seeds X=" +seeds[i][0]+"Y = "+ seeds[i][1]);
		}
		clustering();
		//showCluster();
		//search_a_Data();   
    }
    
    
    public static  int findsmallest_index( float [][]seeds, float x, float y) 
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
    
    
    public  int search_a_Data(float xX, float yY) 
    {
        /*//System.out.println(xX+" "+yY);
		// TODO Auto-generated method stub
		int x =xX;//sc.nextInt();
		int y =yY;//sc.nextInt();
		String key = ("{"+x+","+y+"}").toString();
		for (int i = 0; i < k; i++) {
			for (int j = 0; j < listOfLists.get(i).size(); j++) {
				if(listOfLists.get(i).get(j).trim().compareTo(key)==0)
					//System.out.println("Found in Cluster "+i+1);
                                    return (i+1);
                                        
			}
			
		}*/
        int cluster=findsmallest_index(seeds, xX, yY);
		return cluster;
	}
	public  List<List<String>> showCluster() {	
		return listOfLists;
	}
        
	private static void clustering() 
	{
		// TODO Auto-generated method stub
		for (int i = 0; i < dataset.length; i++) 
		{
			int position =findsmallest_index(seeds, dataset[i][0], dataset[i][1]);
			listOfLists.get(position).add("{"+(dataset[i][0]+","+dataset[i][1]).toString()+"}");
		}
		
		
	}
}
