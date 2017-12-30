/**
 * Created by Taras_Derewecki on 9/12/16.
 */
/*****************************************************
 Developer: Taras Derewecki
 Account Management in Java
 09/19/2016
 *****************************************************/

import java.util.Scanner;

public class Account
{
    private long acctNum;
    private String acctType;
    private String fName;
    private String lName;
    private double balance;
    private double sum;


    public Account() {}

    public Account(double balance) {
        this.balance = balance;
    }

    public double add(double sum)
    {
        balance += sum;
        return sum;
    }

    public double deposit(double sum)
    {
        if (sum <= 0)
        {
            System.out.println("Oops! You either deposited nothing or attempted to deposit a negative amount in to your account! :o");
            return 0;
        }

        else
        {
            balance += sum;
            return balance;
        }
    }

    public double withdraw(double sum)
    {
        if (sum > balance)
        {
            System.out.println("Oops! You attempted to withdraw an amount greater than your balance! :o");
            return 0;
        }

        else
        {
            balance -= sum;
            return balance;
        }
    }
    
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter, 'D' if you wish to deposit to your account or enter, 'W' if you wish to withdraw from your account.");
        char decision = scan.next().charAt(0);

        Account wifeAccount = new Account(50000);
        if ((decision == 'D' || decision == 'd'))
        {

        }
    }
}

