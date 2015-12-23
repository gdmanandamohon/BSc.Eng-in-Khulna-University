irisdata <- read.csv("C:/Users/Ananda  Mohon Ghosh/Documents/MyRProject/iris.data" , header = T)
print(irisdata)

X5.1<-irisdata[,"X5.1"]

X5.1
X3.5<-irisdata[,"X3.5"]
#X3.5
X1.4<-irisdata[,"X1.4"]
#X1.4
X0.2<-irisdata[,"X0.2"]
#X0.2
Iris_setosa<-irisdata[,"Iris.setosa"]

#Iris_setosa


X5.1 <- as.matrix(sort(X5.1))
print(count(X5.1) )
X3.5<-sort(X3.5)
X1.4<-sort(X1.4)
X0.2<-sort(X0.2)  

class1<-0
class2<-0
class3<-0

print(X5.1[1])

for(i in 1:dim(irisdata)[1]-1) 
{ 
 
  fQuartile<- (X5.1[i]+X5.1[i+1])/2
  #secQuartile<- 2*(X5.1[i]+X5.1[i+1])/3
  
  
  
  print(fQuartile)
  print("hi")
  print(X5.1[i])
  
  for(j in 1:dim(irisdata)[1]-1) 
  {
    print("Man")
    print(fQuartile)
    print("hi")
    print(X5.1[i])
    class(fQuartile)
    class(X5.1[i])
    if(fQuartile[0]<X5.1[i][0])
      print("Smaller")
  }
}

