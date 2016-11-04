/**
 * Created by Taras on 10/7/2016.
 */
public class Average extends Exception
{
    private String exception = "N must be postive. Try again.";
    //public Average(){ super("N must be postive. Try again.");}

    public Average(String message)
    {
        super(message);
        exception = message;
    }

    @Override
    public String getMessage() {return exception;}
}
