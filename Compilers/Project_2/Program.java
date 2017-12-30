public class Program {
	public static void main(String[] args) throws Exception
    {
        //java.io.Reader r = new java.io.StringReader
        //("int main()\n"
        //+"begin\n"
        //+"    x = 1;\n"
        //+"    x = x + 1;\n"
        //+"    x = x + 1;\n"
        //+"    // abce \n"
        //+"    print x;\n"
        //+"end\n"
        //);

        if(args.length < 0)
            return;

        java.io.Reader r = new java.io.FileReader(args[0]);
        Parser parser = new Parser(r);
        parser.yyparse();
	}
}
