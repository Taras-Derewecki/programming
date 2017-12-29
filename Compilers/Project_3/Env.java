import java.util.HashMap;

public class Env 
{
    private HashMap<String, Object> table;
    public Env prev; // declaring prev for usage in constructor

    public Env(Env p)
    {
        // Create a new scope environment by creating new symbol table
        table = new HashMap<String, Object>();
        
        // Assigning prev as p
        prev = p; 
    }

    public void Put(String name, Object value)
    {
        if( (name != null) && (value != null) )  
            table.put(name, value);
    }

    public Object Get(String name)
    {

        if ( table.containsKey(name) )
            return table.get(name);

        else if (prev != null)
            return prev.Get(name);

        return null; // return null if the symbol table didn't find the name
    }
}