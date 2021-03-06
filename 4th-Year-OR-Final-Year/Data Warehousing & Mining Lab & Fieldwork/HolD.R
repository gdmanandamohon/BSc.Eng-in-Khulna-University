

iris_data <- read.csv("C:/Users/Ananda  Mohon Ghosh/Documents/MyRProject/iris.data" , header = F)

w = table(iris_data$V5)
class(w)
frequency = as.data.frame(w)
frequency

v1 <- iris_data$V1
sort_v1 <- sort(v1)
sort_v1


v2 <- iris_data$V2
sort_v2 <- sort(v2)
sort_v2


split_points <- 0
for(i in 1:149)
{
  mid_pointAvg <- (sort_v1[i]+sort_v1[i+1])/2
  split_points <- c(split_points,mid_pointAvg)
}

split_points2 <- 0
for(i in 1:149)
{
  mid_pointAvg <- (sort_v2[i]+sort_v2[i+1])/2
  split_points2 <- c(split_points,mid_pointAvg)
}

split_points
Class1_1 <-0
Class1_2 <-0
Class2_1 <-0
Class2_2 <-0
Class3_1 <-0
Class3_2 <-0

marged_vector<-c(0);
for (i in 1:length(split_points)) 
{
  print("split")
  print(split_points[i])
  for (j in 1:length(split_points)) 
  {
    if(iris_data[j,1]<split_points[i])
    {
      if(iris_data[j,5]=="Iris-setosa")
      {
        Class1_1<-Class1_1+1
      }
      if(iris_data[j,5]=="Iris-versicolor")
      {
        Class2_1<-Class2_1+1
      }
      if(iris_data[j,5]=="Iris-virginica")
      {
        Class3_1<-Class3_1+1
      }
      
      
    }
    else
    {
      
        if(iris_data[j,5]=="Iris-setosa")
        {
          Class1_<-Class1_2+1
        }
        if(iris_data[j,5]=="Iris-versicolor")
        {
          Class2_2<-Class2_2+1
        }
        if(iris_data[j,5]=="Iris-virginica")
        {
          Class3_2<-Class3_2+1
        }
    }
    
    
  }
  print("Class1_1");
  print(Class1_1);
  print("Class1_2");
  print(Class1_2); 
  print("Class2_1");
  print(Class2_1);
  print("Class2_2");
  print(Class2_2);
  print("Class3_1");
  print(Class3_1);
  print("Class3_2");
  print(Class3_2);
  
  
  Total = Class1_1+Class1_2+Class2_1+Class2_2+Class3_1+Class3_2
  
  giniN1 = 1-(Class1_1/(Class1_1+Class1_2))-(Class2_1/(Class2_1+Class2_2))-(Class3_1/(Class3_1+Class3_2))
  giniN2 = 1-(Class1_2/(Class1_1+Class1_2))-(Class2_2/(Class2_1+Class2_2))-(Class3_2/(Class3_1+Class3_2))
  
  
  
  GiniChild = -giniN1*(Class1_1+Class2_1+Class3_1)/Total - giniN2*(Class1_2+Class2_2+Class3_2)/Total 
    
  marged_vector<- c(marged_vector, GiniChild)
  Class1_1=0
  Class2_2=0
  Class2_1=0
  Class2_2=0
  Class3_1=0
  Class3_2=0
}
print(marged_vector)

minGini <- min(marged_vector)
minGini