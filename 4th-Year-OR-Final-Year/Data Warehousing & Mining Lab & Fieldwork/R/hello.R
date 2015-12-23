# Hello, world!
#
# This is an example function named 'hello'
# which prints 'Hello, world!'.
#
# You can learn more about package authoring with RStudio at:
#
#   http://r-pkgs.had.co.nz/
#
# Some useful keyboard shortcuts for package authoring:
#
#   Build and Reload Package:  'Ctrl + Shift + B'
#   Check Package:             'Ctrl + Shift + E'
#   Test Package:              'Ctrl + Shift + T'

#hello <- function() {
 # print("Hello, world!")
  #x<-545644.464646
  #x
#}


vc <- c(1,2,3)
xx<-vc+c(2,3,4)
xx
xx[c(FALSE,TRUE,TRUE)]
xx
elements <-c(10,36,47,52,52,56,60,63,70,70,110)
sumation <-sum(elements)
avg_ <- sumation/length(elements)
avg_
mean(elements)

temp <- (elements-avg_)^2
mean(temp)


vctr<-c(12,30,36,51)
vctr [vctr>30]

vctr<-c(12,30,36,51)
vctr [vctr!=30]

vctr <-c(vctr, 10, 100)
vctr


matrix(1:6, nrow =3)
matrix(1:6, nrow =3, byrow = TRUE)
matrix(1:10, ncol = 4)
matrix(1:10, ncol = 4, byrow = TRUE)
byMatrix =matrix(1:10, ncol = 4, byrow = TRUE)

cbind(1:3, 1:3)
rbind(byMatrix, 1:4)
cbind(byMatrix, 10:14)
rownames(byMatrix)<-c("A","B","C","D")
name <-c("A","B","C","D")
colnames(byMatrix)<-names
byMatrix
rownames(byMatrix)<-names


num <- matrix(1:8, ncol = 2)
char <- matrix(LETTERS[1:6], nrow = 4, ncol = 3)
cbind(num, char)
num
char

xar<-matrix(1:5)
xar<-xar/2
xar
#Module 3, 4 5

