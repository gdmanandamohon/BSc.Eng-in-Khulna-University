mydata <- read.csv("sponge.csv")
print(mydata)

print("Total missing Tuples are: ")
MissingValueCounter<-0
Missing_List <-0


mat <- matrix( "",nrow = 1, ncol =ncol(mydata))

for(i in 1:dim(mydata)[1]) 
{ 
  temp <- mydata[i,"OTROS"]
  if(temp=='?')
  {
    MissingValueCounter<-MissingValueCounter+1
    
    
   print(mydata[i,])
   #rbind(Missing_List,mydata[i,])
   a = mydata[i,]
   a<-as.matrix(a)
   
   rbind(mat,a)
  }
} 
mat


for(i in 1:dim(mydata)[1]) 
{ 
  temp <- mydata[i,"OTROS"]
  if(temp=='?')
  {
    MissingValueCounter<-MissingValueCounter+1
  }
}



mat <- matrix(nrow = MissingValueCounter, ncol =ncol(mydata))
for(i in 1:dim(mydata)[1]) 
{ 
  temp <- mydata[i,"OTROS"]
  if(temp=='?')
  {
    a = mydata[i,]
    rbind(mat,a)
  }
} 
mat


print("Total missing Value is: ")
MissingValueCounter




print("Tuples Except missing Value is: ")

for(i in 1:dim(mydata)[1]) 
{ 
  temp <- mydata[i,"OTROS"]
  if(temp=='?')
  {
    #MissingValueCounter<-MissingValueCounter+1
    #rbind(Missing_List, mydata[i,])
    
    #print(mydata[i,])
    #rbind(Missing_List,mydata[i,])
  }
  else
    print(mydata[i,])
} 









#Missing replace by Custom input
fillWithCustom=mydata
input<-"HI"

for(i in 1:dim(fillWithCustom)[1]) 
{ 
  temp <- fillWithCustom[i,"OTROS"]
  if(temp=='?')
  {
    fillWithCustom[i,"OTROS"]<-input
  }
} 

print("AfterReplacing by Custom Input")
fillWithCustom





fillWithNA=mydata
#handle Missing Value With NA
GlobalConstant <-"NA"

for(i in 1:dim(fillWithNA)[1]) 
{ 
  temp <- fillWithNA[i,"OTROS"]
  if(temp=='?')
  {
    fillWithNA[i,"OTROS"]<-GlobalConstant
  }
} 

print("AfterReplacing by NA")
fillWithNA










X3 <- mydata[,"X3"]
sumX3 <- sum(X3)
MaxX3 <- max(X3)
AvgSumOfX3 <- mean(X3)
MaxX3
AvgSumOfX3


X3_1 <- mydata[,"X3.1"]
sumX3_1 <- sum(X3_1)
MaxX3_1 <- max(X3_1)
AvgSumOfX3_1 <- mean(X3_1)

AvgSumOfX3_1 
MaxX3_1

X0 <- mydata[,"X0"]
sumX0 <- sum(X0)
MaxX0 <- max(X0)
AvgSumOfX0 <- mean(X0)
AvgSumOfX0
MaxX0


mat <- matrix( nrow = 3, ncol = 5)
a<-matrix(nrow=10,ncol=5)
b<-matrix(nrow=20,ncol=5)
rbind(a,b)
a
rbind(a,mat)
a


