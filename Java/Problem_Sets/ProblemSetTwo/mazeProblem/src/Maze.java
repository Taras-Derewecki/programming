///**
// * Created by Taras_Derewecki on 9/20/16.
// */

import java.util.Scanner;

public class Maze {

    private Node a;
    private Node b;
    private Node c;
    private Node d;
    private Node e;
    private Node f;
    private Node g;
    private Node h;
    private Node i;
    private Node j;
    private Node k;
    private Node l;

    public Maze()
    {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
        this.g = g;
        this.h = h;
        this.i = i;
        this.j = j;
        this.k = k;
        this.l = l;

        a.setSouth(e);
        e.setSouth(i);
        e.setNorth(a);
        i.setNorth(e);
        i.setEast(j);
        j.setWest(i);

        a.setEast(b);
        b.setWest(a);
        b.setSouth(f);
        f.setNorth(b);
        f.setEast(g);
        g.setWest(f);

        g.setNorth(c);
        c.setSouth(g);
        c.setEast(d);
        d.setWest(c);

        g.setSouth(k);
        k.setNorth(g);

        g.setEast(h);
        h.setWest(g);
        h.setSouth(l);
        l.setNorth(h);
    }


    public void run()
    {
        Node current = a;
        Boolean isNotWon = true;
        while (isNotWon)
        {
            Scanner scan = new Scanner(System.in);
            String direction = scan.nextLine();

            System.out.println("You are in node A: " + direction);

            case (direction)
            {
                switch "N":
                current = current.getNorth();
                break;

                switch "S":
                current = current.getSouth();
                break;

                switch "E":
                current = current.getEast();
                break;

                switch "W":
                current = current.getWest();
                break;
             }

             if (current.getName().equals("L")) {isNotWon = false;}
        }


    }
}


//
//import java.util.Scanner;
//
//public class Maze
//{
//    public Maze(){}
//
//    public Maze(char node)
//    {
////        this.node = node;
//
//        System.out.println("You are in room " + node
//                + " ... Congratulations! You've reached the end of the maze!");
//    }
//
//    public Maze(char node, String n)
//    {
////        super(node, n);
////        this.directionOne = directionOne;
//        //Scanner scan = new Scanner(System.in);
//
//        System.out.println("You are in room " + node +
//                " of a maze of twisty little passages, all alike. You can only go " +
//                n +".");
//
//        //scan.nextLine();
//    }
//
//    public Maze(char node, String n, String s)
//    {
////        super(node, n, s);
////        this.directionOne = directionOne;
////        this.directionTwo = directionTwo;
//        //Scanner scan = new Scanner(System.in);
//
//        System.out.println("You are in room " + node +
//                           " of a maze of twisty little passages, all alike. You can go " +
//                            n + " or " + s + ".");
//        //scan.nextLine();
//    }
//
//    public Maze(char node, String n, String s, String e, String w)
//    {
////        super(node, n, s, e, w);
//        //Scanner scan = new Scanner(System.in);
//
//        System.out.println("You are in room " + node +
//                " of a maze of twisty little passages, all alike. You can go " +
//                n + ", " + s + ", " + e +
//                ", or " + w + ".");
//
//         //scan.nextLine();
//    }
//
////    public String getDirectionOne() {return directionOne;}
////    public String getDirectionTwo() {return directionTwo;}
////    public String getDirectionThree() {return directionThree;}
////    public String getDirectionFour() {return directionFour;}
////
////    public void setDirectionOne(String directionOne) {this.directionOne = directionOne;}
////    public void setDirectionTwo(String directionTwo) {this.directionTwo = directionTwo;}
////    public void setDirectionThree(String directionThree) {this.directionThree = directionThree;}
////    public void setDirectionFour(String directionFour) {this.directionFour = directionFour;}
//}
