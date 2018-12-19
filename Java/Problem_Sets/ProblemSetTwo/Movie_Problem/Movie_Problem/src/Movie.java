public class Movie {
    private String ratings;
    private String id;
    private String title;

    public Movie() {}

    public String getRatings() {
        return ratings;
    }
    public String getNumber() {
        return id;
    }
    public String getTitle() {
        return title;
    }

    public void setRatings(String rate) { this.ratings = rate; }
    public void setTitle(String title) { this.title = title; }
    public void setNumber(String number) {
        this.id = number;
    }


    public boolean equals(Movie movie) {
        if(this.id == movie.getNumber()) return true;
        else return false;
    }

    public double calculateLateFees(int days)
    {
        return (days * 2);
    }

    public static void main(String[] args) {
        Action action = new Action();
        Comedy comedy = new Comedy();
        Drama drama = new Drama();
        Movie movie = new Movie();

        action.setNumber("621");
        comedy.setNumber("7412");
        drama.setNumber("13800007");

        System.out.println("Action movie = Comedy Movie?");
        System.out.println(action.equals(comedy));

        System.out.println("\nComedy movie = Drama Movie?");
        System.out.println(drama.equals(comedy));

        System.out.println("\nLate Fees for 2555 days overdue movies: " +
                "\n\tDrama   : $" + drama.calculateLateFees(2436) +
                "\n\tComedy  : $" + comedy.calculateLateFees(30) +
                "\n\tAction  : $" + action.calculateLateFees(467) +
                "\n\tDefault : $" + movie.calculateLateFees(632)
        );
    }
}