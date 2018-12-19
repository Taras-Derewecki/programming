public class Node {
    private String data;
    private Node north, south, east, west;


    public Node(String data) {
        this.data = data;
        north = null;
        south = null;
        east = null;
        west = null;
    }

    public Node(String data, Node north, Node south, Node east, Node west) {
        this.data = data;
        this.north = north;
        this.south = south;
        this.east = east;
        this.west = west;
    }


    public String getData() { return data; }
    public Node getNorth() { return north; }
    public Node getSouth() { return south; }
    public Node getEast() { return east; }
    public Node getWest() { return west; }


    public void setData(String data) { this.data = data; }
    public void setEast(Node east) { this.east = east; }
    public void setWest(Node west) { this.west = west; }
    public void setSouth(Node south) { this.south = south; }
    public void setNorth(Node north) { this.north = north; }
}