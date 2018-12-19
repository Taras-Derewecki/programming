import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Maze {
    private Node head;
    private Node tail;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public void addE(Node node) {

        if (head == null) {
            head = node;
            tail = node;
        }

        else tail.setEast(node);
    }

    public void addW(Node node) {

        if (head == null) {
            head = node;
            tail = node;
        }

        else tail.setWest(node);
    }

    public void addS(Node node) {

        if (head == null) {
            head = node;
            tail = node;
        }

        else tail.setSouth(node);
    }

    public void addN(Node node) {

        if (head == null) {
            head = node;
            tail = node;
        }

        else tail.setNorth(node);
    }


    public static void main(String[] args) throws IOException
    {
        Maze maze = new Maze();
        Node a = new Node("A");
        Node b = new Node("B");
        Node c = new Node("C");
        Node d = new Node("D");
        Node e = new Node("E");
        Node f = new Node("F");
        Node g = new Node("G");
        Node h = new Node("H");
        Node i = new Node("I");
        Node j = new Node("J");
        Node k = new Node("K");
        Node l = new Node("L");

        a.setEast(b);
        a.setSouth(e);
        b.setWest(a);
        b.setSouth(f);
        c.setEast(d);
        c.setSouth(g);
        d.setWest(c);
        e.setSouth(i);
        e.setNorth(a);
        f.setEast(g);
        f.setNorth(b);
        g.setNorth(c);
        g.setSouth(k);
        g.setEast(h);
        g.setWest(f);
        h.setSouth(l);
        h.setWest(g);
        i.setEast(j);
        i.setNorth(e);
        j.setWest(i);
        k.setNorth(g);
        l.setNorth(h);


        int count = 0;

        String s;
        boolean eastL = false;
        boolean westL = false;
        boolean southL = false;
        boolean northL = false;
        boolean possible = false;
        Node current = a;



        while(current != l)
        {
            count =  0;
            eastL = false;
            westL = false;
            southL = false;
            northL = false;

            System.out.print("You are in room " + current.getData() +
                    " of a maze of twisty little passages, all alike. You can go");


            if (current.getEast() != null) {
                eastL = true;
                System.out.print(" east");
                count++;
            }

            if (current.getWest() != null) {
                westL = true;
                if (count > 0) System.out.print(" or");
                System.out.print(" west");
                count++;
            }

            if (current.getSouth() != null) {
                southL = true;

                if(a.getSouth() == null) {
                    a.setSouth(e);
                }

                if (count > 0) System.out.print(" or");
                System.out.print(" south");
                count++;
            }

            if (current.getNorth() != null) {
                northL = true;
                if (count > 0) System.out.print(" or");
                System.out.print(" north");
                count++;
            }

            System.out.println(".");
            possible = false;
            while (!possible) {
                s = br.readLine();
                if (s.equalsIgnoreCase("E")) {
                    if(current.getEast() != null) {
                        current = current.getEast();
                        possible = true;
                    }

                    else System.out.println("This is an invalid input, please try again.");
                }

                else if (s.equalsIgnoreCase("W")) {
                    if(current.getWest() != null) {
                        current = current.getWest();
                        possible = true;
                    }

                    else System.out.println("This is an invalid input, please try again.");
                }

                else if (s.equalsIgnoreCase("S")) {
                    if(current.getSouth() != null) {
                        current = current.getSouth();
                        possible = true;
                    }

                    else System.out.println("This is an invalid input, please try again.");
                }

                else  if (s.equalsIgnoreCase("N")) {
                    if(current.getNorth() != null) {
                        current = current.getNorth();
                        possible = true;
                    }

                    else System.out.println("This is an invalid input, please try again.");
                }

                else {
                    possible = false;
                    System.out.println("This is an invalid input, please try again.");
                }
            }
        }
        System.out.println("You have finished the maze");
    }
}