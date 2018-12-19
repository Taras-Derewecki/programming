public class Odometer {

    // Instance Data
    private double miles, mpg;

    // Constructors
    private Odometer(double miles, double mpg) {
        this.miles = miles;
        this.mpg = mpg;
    }


    // Getters or Accessors
    private double getMiles(){ return miles; }                  // get miles driven
    private double getMpg(){ return mpg; }                      // get miles per gallon
    private double getGallons(){ return miles / mpg; }          // get number of gallons consumed since last reset

    //Setters or Mutators
    private void setMiles(double miles){ this.miles += miles; } // set miles and increment to current miles
    private void setMpg(double mpg){ this.mpg = mpg; }          // set miles per gallon
    private void resetOdometer(double miles, double mpg){       // set miles and mpg
        this.miles = miles;
        this.mpg = mpg;
    }


    // Main Method
    public static void main(String[] args) {

        Odometer car = new Odometer(60, 30);
        System.out.format("Miles: %.2f%n", car.getMiles());
        System.out.format("Miles per Gallon: %.2f%n", car.getMpg());
        System.out.format("Gallons: %.2f%n", car.getGallons());
        car.resetOdometer(0,0);
        System.out.println("Odometer Reset!" + "\n");


        for(int i = 0; i < 9999; i++){

            car.setMiles(Math.ceil(Math.random() * 300));
            car.setMpg(Math.ceil(Math.random() * (136) + 10));

            System.out.format("Miles: %.2f%n", car.getMiles());
            System.out.format("Miles per Gallon: %.2f%n", car.getMpg());
            System.out.format("Gallons: %.2f%n", car.getGallons());

            car.setMiles(Math.ceil(Math.random() * 300));
            car.setMpg(Math.ceil(Math.random() * (136) + 10));

            System.out.format("Miles: %.2f%n", car.getMiles());
            System.out.format("Miles per Gallon: %.2f%n", car.getMpg());
            System.out.format("Gallons: %.2f%n", car.getGallons());
            car.resetOdometer(0,0);
            System.out.println("Odometer Reset!" + "\n");
        }
    }
}