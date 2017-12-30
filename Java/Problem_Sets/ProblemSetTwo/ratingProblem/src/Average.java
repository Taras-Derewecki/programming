/**
 * Created by Taras on 10/1/2016.
 */
public class Average
{
    private double summedRatings;
    private double totalRatings;

    public Average(double summedRatings, double totalRatings)
    {
        this.summedRatings = summedRatings;
        this.totalRatings = totalRatings;

        double average = getSummedRatings() / getTotalRatings();
        System.out.println("average of " + average + " / 5");
    }

    public double getSummedRatings() {return summedRatings;}
    public double getTotalRatings() {return totalRatings;}

    public void setSummedRatings(double summedRatings) {this.summedRatings = summedRatings;}
    public void setTotalRatings(double totalRatings) {this.totalRatings = totalRatings;}
}
