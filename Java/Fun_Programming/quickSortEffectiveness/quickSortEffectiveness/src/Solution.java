/***********************************************************************************************************************



 2. The One Size Fits One t-shirt company that makes unique sizes for its customers.
 Unfortunately, in the latest batch of t-shirts, the customer assignments for each t-shirt have been lost.
 Moreover, it is impossible to sort the shirts (or the people) just by looking at them.
 The customers have been invited to try on the shirts to try to figure out how to assign shirts.
 When a customer tries on a shirt, you will be only tell if the shirt is too small, fits, or is too large.

 Your task is to write two methods in Java to help with the assignment given n unique customers and n unique shirts.
 You should use the following template when writing your code.

 a)	The first method should be an θ(n^2) expected time algorithm that rearranges the people
 and/or the shirts such that such that persons.get(i) fits shirts.get(i) for all 1 <= i <= n. (30 points)

 b)	The second method should be a θ(n log(n)) expected time algorithm that rearranges the nuts
 and/or the bolts such that such that persons.get(i) fits shirts.get(i) for all 1 <= i <= n. (40 points)


 The algorithms should use the classes in the template,
 but you may only call the equals (aka fits) and isTooSmall methods in your algorithm,
 i.e. you may not access the protected size variables.



 **********************************************************************************************************************/



import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Solution {

    static Random prng = new Random();

    public static void main(String[] args) {
        // Create people/shirts collection
        ArrayList<Shirt> shirts = new ArrayList<>();
        ArrayList<Person> persons = new ArrayList<>();
        int n = prng.nextInt(1000) + 5000;
        for (int j = 0; j < n; j++) {
            shirts.add(new Shirt(0.01*j));
            persons.add(new Person(0.01*j));
        }

        Collections.shuffle(shirts);
        Collections.shuffle(persons);
        // long startTime = System.currentTimeMillis();
        methodA(shirts,persons);
        // long endTime = System.currentTimeMillis();
        // System.out.println("Total execution time for methodA: " + (endTime - startTime));

        Collections.shuffle(shirts);
        Collections.shuffle(persons);
        // startTime = System.currentTimeMillis();
        methodB(shirts,persons);
        // endTime = System.currentTimeMillis();
        // System.out.println("Total execution time for methodB: " + (endTime - startTime));

    }

    static void methodA(ArrayList<Shirt> shirts, ArrayList<Person> persons) {
        for(int i=0;i<shirts.size();i++){
            for(int j=0;j<persons.size();j++){
                if(shirts.get(i).equals(persons.get(j))){
                    Person p = persons.get(j);
                    persons.set(j,persons.get(i));
                    persons.set(i,p);
                }
            }
        }
    }

    private static int partitionShirts(ArrayList<Shirt> shirts, int low, int high, Person pivot)
    {
        int i = low;
        for (int j = low; j < high; j++)
        {
            if(shirts.get(j).isTooSmallFor(pivot)){
                Shirt temp = shirts.get(i);
                shirts.set(i,shirts.get(j));
                shirts.set(j,temp);
                i++;
            }
            else if(shirts.get(j).equals(pivot)){
                Shirt temp = shirts.get(j);
                shirts.set(j,shirts.get(high));
                shirts.set(high,temp);
                j--;
            }
        }
        Shirt temp = shirts.get(i);
        shirts.set(i,shirts.get(high));
        shirts.set(high,temp);
        return i;
    }

    private static int partitionPersons(ArrayList<Person> persons, int low, int high, Shirt pivot)
    {
        int i = low;
        for (int j = low; j < high; j++)
        {
            if(persons.get(j).isTooSmallFor(pivot)){
                Person temp = persons.get(i);
                persons.set(i,persons.get(j));
                persons.set(j,temp);
                i++;
            }
            else if(persons.get(j).equals(pivot)){
                Person temp = persons.get(j);
                persons.set(j,persons.get(high));
                persons.set(high,temp);
                j--;
            }
        }
        Person temp = persons.get(i);
        persons.set(i,persons.get(high));
        persons.set(high,temp);
        return i;
    }

    private static void matchShirtToPerson(ArrayList<Shirt> shirts, ArrayList<Person> persons, int low, int high)
    {
        if (low < high)
        {
            int pivot = partitionShirts(shirts, low, high, persons.get(high)); //Get position in shirts for a given person
            partitionPersons(persons, low, high, shirts.get(pivot)); //Partion persons based on the shirt of the given person
            matchShirtToPerson(shirts, persons, low, pivot-1); //Recurse over left half
            matchShirtToPerson(shirts, persons, pivot+1, high); //Recurse over right half
        }
    }

    static void methodB(ArrayList<Shirt> shirts, ArrayList<Person> persons) {
        matchShirtToPerson(shirts,persons,0,shirts.size()-1); //Call Quick Sort Method
    }
}

class Item {
    protected double size;

    public Item(double size) { this.size = size; }

    @Override
    public boolean equals(Object other) {
        if (other == null) return false;
        if (other == this) return true;
        if (!(other instanceof Item)) return false;
        Item that = (Item) other;
        return this.size == that.size;
    }
}

class Shirt extends Item {
    Shirt(double size) { super(size);};

    boolean isTooSmallFor(Person p) {
        return p.size > size;
    }
}

class Person extends Item {
    Person(double size) { super(size); };

    boolean isTooSmallFor(Shirt s) {
        return s.size > size;
    }
}