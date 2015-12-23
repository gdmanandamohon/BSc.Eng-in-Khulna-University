package myCompleteLinkage;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class Execution 
{

	static int datalength; 
    public static void main(String[] args) throws IOException
    {
        double dataset[][] = new double[5][2];
        int count=0;
        
        Scanner scf = new Scanner( new File("F:/Java pgram class/PatternLab/src/myComplete/new.txt"));
       
        System.out.println("Input Matrix is");
        
        for (int i = 0; i < dataset.length; i++) {
        	dataset[count][0] = scf.nextDouble();
            dataset[count][1] = scf.nextDouble();
            count++;
		}
        scf.close();
        datalength = count;
        
        CompltetLinkage CompLink = new CompltetLinkage(datalength);
        
        System.out.println("\nMatrix:");
          
        for(int p = 0; p < datalength; p++)
        {
            for(int q = 0; q < datalength; q++)
            {
                if(q>p)
                {
                    double z = Math.sqrt(Math.pow(dataset[p][0]-dataset[q][0], 2) + Math.pow(dataset[p][1]-dataset[q][1], 2));
                    CompLink.clustermatrix[p][q] = CompLink.clustermatrix[q][p] = z;
                    
                }
            }
        }


        
        
        
        
        while (count>2) {
        	CompLink.calculateAndMerge(datalength);
            count--;
			
		}
        CompLink.name();
    }
    
}
