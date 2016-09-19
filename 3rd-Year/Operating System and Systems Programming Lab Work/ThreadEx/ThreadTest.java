package ThreadEx;
/**
 * @author Ananda  Mohon Ghosh
 * @param args
 */

class ThreadTest 
{ 
          public static void main(String args[]) 
           { 
                    new A().start(); 
                    new B().start(); 
                    new C().start(); 
           } 
} 
class C extends Thread 
{ 
       public void run() 
       
         { 
              for(int k=1;k<=155;k++) 
                { 
                      System.out.println("\t From Thread C: k= "+k); 
                } 
 
                 System.out.println("Exit from C"); 
         } 
} 
class A extends Thread 
{ 
       public void run() 
         { 
              for(int i=1;i<=155;i++) 
                { 
                      System.out.println("\t From Thread A: i= "+i); 
                } 
                 System.out.println("Exit from A"); 
         } 
} 
 
class B extends Thread 
{ 
       public void run() 
         { 
              for(int j=1;j<=155;j++) 
                { 
                      System.out.println("\t From Thread B: j= "+j); 
                } 
                 System.out.println("Exit from B"); 
         } 
} 