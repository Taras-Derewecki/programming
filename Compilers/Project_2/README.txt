compile: java *.java
run: java Program test.foo 


test.foo is a text file that you want to the program to read.
I also included the flex file needed for when you compile it. command for creating a java file with the flex file is:
java -jar flex-1.6.1.jar Lexer.flex