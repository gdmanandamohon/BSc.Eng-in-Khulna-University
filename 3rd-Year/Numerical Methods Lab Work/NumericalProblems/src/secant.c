#include<conio.h>
#include<stdio.h>
#include<stdlib.h>
#include<math.h>
#define e 0.0001


int i=0,cnt=0,flag=0;
float x1,x2,x3=0,t=0;
float fx1=0,fx2=0,fx3=0,temp=0;



float func(float f)
{
    return(log10(f)-cos(f));
}


int check()
{
    printf("\n\n\tINTIAL X1---->");
    scanf("%f",&x1);

    printf("\n\tINTIAL X2---->");
    scanf("%f",&x2);

    fx1=fx2=fx3=0.0;


    if( ((func(x1)*func(x2)))>0)
    {
        printf("\n\t INTIAL VALUES ARE NOT PERFECT.");
        return(1);
    }
    return(0);
}

void main()
{
    //clrscr();
    printf("\n\n\t\t PROGRAM FOR SECANT METHOD");

    printf("\n\t PARTICULAR EQUATION IS ::: log(x)-cos(x)");

    while(1)
    {
        if(check()==0)
        {
            flag=1;
            break;
        }
        check();
    }

    printf("\n ******************************************************");
    printf("\n ITERATION    X1    FX1    X2    FX2     X3       FX3   ");
    printf("\n **********************************************************");

    if(flag==1)
    {
        do
        {
            cnt++;
            fx1=fx2=fx3=0;
            fx1=func(x1);
            fx2=func(x2);
            x3=((x1*fx2)-(x2*fx1))/(fx2-fx1);
            fx3=func(x3);

            printf("\n %d     %.4f  %.4f  %.4f  %.4f  %.4f  %.4f",cnt,x1,fx1,x2,fx2,x3,fx3);
            x1=x2;
            x2=x3;
            getch();
        }while(fabs(x2 - x1)>=e);
        printf("\n\t ROOT OF EQUATION IS  %f",x3);
       }
    getch();
}


/*******************************OUTPUT************************************


         PROGRAM FOR SECANT METHOD


     PARTICULAR EQUATION IS ::: log(x)-cos(x)

    INTIAL X1---->1.4

    INTIAL X2---->1.45

 ******************************************************
 ITERATION    X1    FX1    X2    FX2     X3       FX3
 ******************************************************
 1     1.4000  -0.0238  1.4500  0.0409  1.4184  0.0000
 2     1.4500   0.0409  1.4184  0.0000  1.4184  0.0000
 ******************************************************

     ROOT OF EQUATION IS  1.418406                           **/
