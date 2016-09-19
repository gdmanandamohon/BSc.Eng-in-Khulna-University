
/**
 * The Program Takes Number of Eqautions and Then Creates An
 * Square Matrix of Order x Order and Formulates a Top Triangle
 * My Continuous Elimination and Then Solves the Set of Equations
 * to Find the Values of the Order number of Variables.
 * @author SHANTANU KHAN
 * @mail shantanukhan1995@gmail.com
 * @website 0code.blogspot.com
 * Program Type : BlueJ Program - Java
 */
import java.util.*;
public class GaussMatrix
{
    // INSTANCE VARIABLES
    private double[][] m;    // MATRIX OF CO-EFFICIENTS
    private double[] constants; // VECTOR OF CONSTANT TERMS
    private double[] solution; // SOLUTION SET
    private int numEq;      // NUMBER OF EQUATIONS
    static Scanner sc=new Scanner(System.in);
    
    public GaussMatrix(int equations)   // CONSTRUCTOR
    {
        numEq=equations;
        m=new double[numEq][numEq];
        constants=new double[numEq];
        solution=new double[numEq];
    }
    
    public void fillMatrix()
    {
        for(int i=0;i<numEq;i++){
            System.out.println("Enter the co-efficients of unknowns and constant term for Equation "+(i+1)+" :");
            for(int j=0;j<numEq;j++){
                System.out.print("Enter Co-efficient "+(j+1)+" : ");
                m[i][j]=sc.nextDouble();
            }
            System.out.print("Enter Constant Term : ");
            constants[i]=sc.nextDouble();
        }
    }
    
    public void printSolution()
    {
        System.out.println("\nSolution Set is : ");
        for(int i=0;i<numEq;i++)
            System.out.println((char)('A'+i)+" = "+solution[i]);
    }
    
    public void printMatrix()   // FOR DEBUGGING PURPOSE
    {
        for(int i=0;i<numEq;i++){
            for(int j=0;j<numEq;j++){
                if(m[i][j]>=0)
                    System.out.print(" +"+m[i][j]+((char)('A'+j))+" ");
                else if(m[i][j]<0)
                    System.out.print(" "+m[i][j]+((char)('A'+j))+" ");
            }
            System.out.println(" = "+constants[i]);
        }
    }
    
    public void swapRows(int row1,int row2)
    {
        double temp;
        for(int j=0;j<numEq;j++){   // SWAPPING CO-EFFICIENT ROWS
            temp=m[row1][j];
            m[row1][j]=m[row2][j];
            m[row2][j]=temp;
        }
        temp=constants[row1];   // SWAPPING CONSTANTS VECTOR
        constants[row1]=constants[row2];
        constants[row2]=temp;
    }
    
    public void eliminate()
    {
        int i,j,k,l;
        for(i=0;i<numEq;i++){   // i -> ROW ; MATRIX ORDER DECREASES DURING ELIMINATION
            // FIND LARGEST CO-EFFICIENTSOF THE CURRENT COLUMN MOVING ROW-WISE
            double largest=Math.abs(m[i][i]);
            int index=i;
            for(j=i+1;j<numEq;j++){
                if(Math.abs(m[j][i])>largest){
                    largest=m[j][i];
                    index=j;
                }
            }
            swapRows(i,index);  // SWAPPING i-th ROW to index-th ROW
            for(k=i+1;k<numEq;k++){
                double factor=m[k][i]/m[i][i];
                // PROCESSING COLUMN WISE
                for(l=i;l<numEq;l++){
                    m[k][l]-=factor*m[i][l];
                }
                constants[k]-=factor*constants[i];  // PROCESSING CONSTANTS
            }
        }
    }
    
    public void solve()
    {
        for(int i=numEq-1;i>=0;i--){
            solution[i]=constants[i];   // COPY
            for(int j=numEq-1;j>i;j--){
                solution[i]-=m[i][j]*solution[j];
            }
            solution[i]/=m[i][i];
        }
    }
    
    public static void main(String args[])
    {
        System.out.print("Enter the Number of Terms : ");
        GaussMatrix obj=new GaussMatrix(sc.nextInt());
        obj.fillMatrix();
        System.out.println("\fYou Have Entered The Following Equations :");
        obj.printMatrix();
        obj.eliminate();
        obj.solve();
        obj.printSolution();
    }
}