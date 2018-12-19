public class Pizza {

    // Instance Data
    private String sizeOfPizza;
    private int cheeseToppings, pepperoniToppings, hamToppings;


    // Constructor
    private Pizza(String sizeOfPizza, int cheeseToppings, int pepperoniToppings, int hamToppings){
        this.sizeOfPizza = sizeOfPizza;
        this.cheeseToppings = cheeseToppings;
        this.pepperoniToppings = pepperoniToppings;
        this.hamToppings = hamToppings;
    }

    // Getters or Accessors
    public int getCheeseToppings() { return cheeseToppings; }
    public int getPepperoniToppings() { return pepperoniToppings; }
    public int getHamToppings() { return hamToppings; }
    public String getSizeOfPizza() { return sizeOfPizza; }


    // Setters or Mutators
    public void setCheeseToppings(int cheeseToppings) { this.cheeseToppings = cheeseToppings; }
    public void setPepperoniToppings(int pepperoniToppings) { this.pepperoniToppings = pepperoniToppings; }
    public void setHamToppings(int hamToppings) { this.hamToppings = hamToppings; }
    public void setSizeOfPizza(String sizeOfPizza) { this.sizeOfPizza = sizeOfPizza; }


    // Public Methods
    public static double calcCost(String description){
        double price = 0;
        double priceSizeOfPizza = 0;
        int[] detailsOfToppings = new int[3];
        StringBuilder pizzaSize = new StringBuilder();

        for(char c: description.toCharArray()) {
            switch (c) {
                case 'S': pizzaSize.append(c); break;
                case 'M': pizzaSize.append(c); break;
                case 'L': pizzaSize.append(c); break;

                default: break;
            }
        }

            switch(pizzaSize.toString()){
                case "S": priceSizeOfPizza += 10; break;
                case "M": priceSizeOfPizza += 12; break;
                case "L": priceSizeOfPizza += 14; break;

                default: break;
            }

            if(isInteger(description.substring(5,8))) {
                detailsOfToppings[0] = Integer.parseInt(description.substring(5,6));
                detailsOfToppings[1] = Integer.parseInt(description.substring(6,7));
                detailsOfToppings[2] = Integer.parseInt(description.substring(7));
            }

            else if(isInteger(description.substring(6,9))) {
                detailsOfToppings[0] = Integer.parseInt(description.substring(6,7));
                detailsOfToppings[1] = Integer.parseInt(description.substring(7,8));
                detailsOfToppings[2] = Integer.parseInt(description.substring(8));
            }

            price += (detailsOfToppings[0] * 2) + (detailsOfToppings[1] * 2) +
                    (detailsOfToppings[2] * 2) + priceSizeOfPizza;

            return price;
    }

    public static boolean isInteger( String input ) {
        try {
            Integer.parseInt( input );
            return true;
        }
        catch( Exception e ) {
            return false;
        }
    }

    public static String getDescription(String sizeOfPizza, int cheeseToppings, int pepperoniToppings, int hamToppings){
        return (sizeOfPizza + Integer.toString(cheeseToppings) +
                Integer.toString(pepperoniToppings) + Integer.toString(hamToppings));
    }

    // Main Method
    public static void main(String[] args) {
        System.out.println("$ " + calcCost(getDescription(
                "Large", 1,1,2)));

        System.out.println("$ " + calcCost(getDescription(
                "Medium", 1,1,2)));

        System.out.println("$ " + calcCost(getDescription(
                "Small", 1,1,2)));
        

        System.out.println("$ " + calcCost(getDescription(
                "Large", 2,2,4)));

        System.out.println("$ " + calcCost(getDescription(
                "Medium", 2,2,4)));

        System.out.println("$ " + calcCost(getDescription(
                "Small", 2,2,4)));
    }
}
