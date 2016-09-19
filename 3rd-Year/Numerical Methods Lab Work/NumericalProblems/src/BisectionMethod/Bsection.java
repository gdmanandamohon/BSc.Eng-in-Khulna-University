package BisectionMethod;

/**************************************************
 
 * Description: Simple implementation of the
 *              bisection algorithm in Java
 **************************************************/

import java.io.*;

class Bisection {
  private double X1;
  private double Y1;
  private double X2;
  private double Y2;
  private double X;
  private double Y;
  private double Tol;
  private int Limit;
  private Function F;
  private boolean OK;
  private int N;
  
  public Bisection () {
    F = new Function ();
  }
  
  private double ReadDouble () {
    byte [] Line;
    String Line2;
    Line = new byte [80];
    try {
      System.in.read (Line);
    } catch (IOException e) {
      System.out.println ("Input Error.");
    } 
    Line2 = new String (Line);
    return Double.parseDouble (Line2);    
  }
  
  private int ReadInteger () {
    byte [] Line;
    String Line2;
    int i;
    int j;
    Line = new byte [80];
    try {
      System.in.read (Line);
    } catch (IOException e) {
      System.out.println ("Input Error.");
    } 
    i = 0;
    while (Line[i] == ' ') ++i;
    j = 79;
    while ((j > 0) && (Line[j] == Line[79])) {
      --j;
    }
    Line2 = new String (Line, i, j - i - 1);
    return Integer.parseInt (Line2);    
  }
  
  private void Input () {
    System.out.print ("First X Value?  ");
    X1 = ReadDouble ();
    System.out.println ("X1 = " + X1);
    System.out.print ("Second X Value?  ");
    X2 = ReadDouble ();
    System.out.print ("Tolerance?  ");
    Tol = ReadDouble ();
    System.out.print ("Maximum iterations?  ");
    Limit = ReadInteger ();
  }
  
  private void Output () {
    if (OK) {
      System.out.println ("Algorithm succeeded after " + N + " steps");
    } else {
      System.out.println ("Algorithm failed after " + N + " steps");
    }
    //System.out.println ("X = %f\nY = %f\n", X, Y);
  }
  
  private boolean Bisect () {
    Y1 = F.Y (X1);
    Y2 = F.Y (X2);
    OK = (Y1 > 0) != (Y2 > 0);
    System.out.println (" 0  " + X1 + "  " + Y1);
    System.out.println (" 0  " + X2 + "  " + Y2);
    if (OK) {
      N = 0;
      while ((Math.abs (X1 - X2) > Tol) && (N < Limit)) {
        Step ();
        ++N;
        System.out.println (N + "  " + X + "  " + Y);
      }
    }
    return OK;  
  }
  
  public void Run () {
    Input ();
    OK = Bisect ();
    Output ();
  }
  
  public void Step () {
    X = (X1 + X2) / 2.0;
    Y = F.Y (X);
    if ((Y1 < 0) == (Y < 0)) {
      X1 = X;
      Y1 = Y;
    } else {
      X2 = X;
      Y2 = Y;
    }
  }

  public static void main (String [] Argv) {
    Bisection App;
    System.out.print ("Bisection algorithm - Java\n");
    App = new Bisection();
    App.Run ();
  }
} 

class Function {
  double Y (double X) {
    return 1.0 + 3.0 * X * (X + 4.0);
  }
}
  