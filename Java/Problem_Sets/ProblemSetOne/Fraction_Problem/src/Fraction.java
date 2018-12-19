import java.util.Scanner;

public class Fraction {

    // instance data
    private int numerator;
    private int denominator;

    // constructors
    private Fraction(){}

    private Fraction(int numerator, int denominator){
        this.numerator = numerator;
        this.denominator = denominator;



        if( numerator / gcd(numerator, denominator) ==  numerator &&
                denominator / gcd(numerator, denominator) == denominator ) {

            doDivision(numerator, denominator);
            System.out.println(" is already reduced.");
        }


        else {

            doDivision(numerator, denominator);
            System.out.println(" -> " + numerator / gcd(numerator, denominator) + "/" +
                    denominator / gcd(numerator, denominator));
        }

    }

    // getters or accessors (not used since everything is done in constructor)
    public int getNumerator(){ return numerator; }
    public int getDenominator(){ return denominator; }

    // setters or mutators (not used since everything is done in constructor)
    public void setNumerator(int numerator) { this.numerator = numerator; }
    public void setDenominator(int denominator) { this.denominator = denominator; }

    // methods
    private void doDivision(int numerator, int denominator){ System.out.print(numerator + "/" + denominator); }

    private int gcd(int numerator, int denominator) {
        if (denominator == 0)
            return numerator;

        else return gcd(denominator, numerator % denominator);
    }

    public static void main(String[] args) {

        new Fraction(30,50);
        new Fraction(25,50);
        new Fraction(15,45);
        new Fraction(3,5);
        new Fraction(10,50);
    }
}