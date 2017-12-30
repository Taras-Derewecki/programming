1. java -jar jflex-1.6.1.jar Lexer.flex
2. ./yacc.macosx -Jthrows="Exception" -Jextends=ParserBase -Jnorun -J Parser.y
3. javac *.java
4a. (For error files) java SemanticChecker error/*.foo
4b. (For success files) java SemanticChecker success/*.foo