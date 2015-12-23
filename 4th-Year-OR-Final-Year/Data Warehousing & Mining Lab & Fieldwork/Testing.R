mymat = matrix(nrow=30, ncol=30) 

for(i in 1:dim(mymat)[1])  # for each row 
{ 
  for(j in 1:dim(mymat)[2]) # for each column 
  { 
    mymat[i,j] = i*j     # assign values based on position: product of two 
    mymat
  } 
}
mymat
for (i in dim(mymat)) {
 print(mymat) 
}

name <- c("Anne", "Pete", "Frank", "Julia", "Cath") 
age <- c(28, 30, 21, 39, 35) 
child <- c(FALSE, TRUE, TRUE, FALSE, TRUE ,  stringsAsFactors = FALSE) 
people <- data.frame(name, age, child) 
people

#list 
similar_song <- list(title = "R you on time?",duration = 230)
song <- list(title = "Rsome times", duration = 190, track = 5, similar = similar_song) 
song[[0]]
