///**
// * Created by Taras_Derewecki on 9/20/16.
// */

public class Node
{
    private String name;
    private Node north;
    private Node south;
    private Node east;
    private Node west;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Node getNorth() {
        return north;
    }

    public void setNorth(Node north) {
        this.north = north;
    }

    public Node getSouth() {
        return south;
    }

    public void setSouth(Node south) {
        this.south = south;
    }

    public Node getEast() {
        return east;
    }

    public void setEast(Node east) {
        this.east = east;
    }

    public Node getWest() {
        return west;
    }

    public void setWest(Node west) {
        this.west = west;
    }
}


//public class Node
//{
//    protected char node;
//    protected String n;
//    protected String s;
//    protected String e;
//    protected String w;
//
//    public Node(){}
//
//    public Node(char node){this.node = node;}
//
//    public Node(char node, String n)
//    {
//        this.node = node;
//        this.n = n;
//    }
//
//    public Node(char node, String n, String s, String e, String w)
//    {
//        this.node = node;
//        this.n = n;
//        this.s = s;
//        this.e = e;
//        this.w = w;
//    }
//
//    public Node(char node, String n, String s)
//    {
//        this.node = node;
//        this.n = n;
//        this.s = s;
//    }
//
//    public void setNode(char node) {this.node = node;}
//    public void setN(String n) {this.n = n;}
//    public void setS(String s) {this.s = s;}
//    public void setE(String e) {this.e = e;}
//    public void setW(String w) {this.w = w;}
//
//    public char getNode() {return node;}
//    public String getN() {return n;}
//    public String getS() {return s;}
//    public String getE() {return e;}
//    public String getW() {return w;}
//}
