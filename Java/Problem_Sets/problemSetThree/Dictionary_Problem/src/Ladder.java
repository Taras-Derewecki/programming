import java.util.List;

public class Ladder
{
    private List<String> trail;
    private String finalWord;
    private int length;

    public Ladder(List<String> trail) { this.trail = trail; }

    public Ladder(List<String> trail, int length, String finalWord) {
        this.trail = trail;
        this.length = length;
        this.finalWord = finalWord;
    }

    public List<String> getTrail() { return trail; }
    public int getLength() { return length; }
    public String getFinalWord() { return finalWord; }

    public void setTrail(List<String> trail) { this.trail = trail; }
    public void setLength(int length) { this.length = length; }
}