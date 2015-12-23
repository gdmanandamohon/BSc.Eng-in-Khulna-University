package myComplete;

import java.util.ArrayList;
import java.util.List;

public class CompltetLinkage 
{

	double [][] clustermatrix;
    int FirstIndex=0,LastIndex=0;
    int i,j;
    String classes[];
    
    CompltetLinkage(int n)
    {
        clustermatrix=new double[n][n];
        classes =new String[n];
        for (int i = 0; i < classes.length; i++) {
			classes[i]=String.valueOf(i+1);
		}
        
    }
   
   
    public void SearchCompleteLinkage(int totalSampleData)
    {
        double minimum_value=10000000.0;

        for(int i=0;i<totalSampleData;i++)
        {
            for(int j=0;j<totalSampleData;j++)
            {
	           	if(clustermatrix[i][j]!=0.0)
	            {
	             	    if(clustermatrix[i][j]<minimum_value)
	                    {
	                        minimum_value=clustermatrix[i][j];
	                        FirstIndex=i; 
	                        LastIndex=j;
	                    }
	             }
	           	else
	           		continue;
            }
    	}
        
	System.out.println("Sample data "+(FirstIndex+1)+" and "+(LastIndex+1)+" are merged at a distance "+ minimum_value);
	System.out.println("Sample Merging "+classes[FirstIndex]+" And "+classes[LastIndex]);
	classes[FirstIndex]= String.valueOf(classes[FirstIndex])+","+String.valueOf(classes[LastIndex]);
	classes[LastIndex]="visited";
	
	
    }

    public void calculateAndMerge(int totalSampleData)
    {
    	for(i=0;i<totalSampleData;i++)
      	{
            for(j=0;j<totalSampleData;j++)
            {
                System.out.print(String.format("%.1f", clustermatrix[i][j])+"\t");
            }                   
            System.out.println();
      	}
        
        SearchCompleteLinkage(totalSampleData);
        
        mergeTheDataMatrix(totalSampleData);
        
        
    }
    
    public void name() {
		
    	for (int i = 0; i < classes.length; i++) {
			if(classes[i].compareTo("visited")==0)
				continue;
			else {
				System.out.println(classes[i]);
			}
		}
	}

    
    public void mergeTheDataMatrix(int totalSampleData)
    {       
        for(int count=0; count <2; count++)
        {
            for(int j=0;j<totalSampleData;j++)
            {
                if(clustermatrix[FirstIndex][j]>clustermatrix[LastIndex][j])
                {
                    clustermatrix[j][FirstIndex] = clustermatrix[FirstIndex][j];
                }
                else
                {
                    clustermatrix[FirstIndex][j]=clustermatrix[j][FirstIndex]=clustermatrix[LastIndex][j];
                }
            }
        }
        
          
        for(int i=0;i<totalSampleData;i++)
        {
            for(int j=0;j<totalSampleData;j++)
            {
                if(i==j)
            	{
                    clustermatrix[i][j]=0.0;
                }
            }
        }
          
        for(int k=0;k<totalSampleData;k++)
        {
            clustermatrix[LastIndex][k]=clustermatrix[k][LastIndex]=0;
        }
    }
}
