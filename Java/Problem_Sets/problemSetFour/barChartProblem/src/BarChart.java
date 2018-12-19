import java.awt.Color;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

public class BarChart extends JPanel
{
    private Map<Color, Integer> bars = new LinkedHashMap<Color, Integer>(); // linked hash map is useful for accepting user input, copying the data, then returning in that same order... ideal for bar charts

    // function for adding a bar's color and value to it
    public void addBar(Color color, int value)
    {
        bars.put(color, value);
        repaint();
    }

    @Override
    protected void paintComponent(Graphics graphic)
    {
        // See what the longest bar is
        int max = Integer.MIN_VALUE;
        for (Integer value : bars.values()) {max = Math.max(max, value);} // for each loop


        // paint bars
        int width = (getWidth() / bars.size()) - 2;
        int x = 1;

        for (Color color : bars.keySet()) // for each loop
        {
            int value = bars.get(color);
            int height = (int)
            ((getHeight()-5) * ((double)value / max));
            graphic.setColor(color);
            graphic.fillRect(x, getHeight() - height, width, height);
            graphic.setColor(Color.black);
            graphic.drawRect(x, getHeight() - height, width, height);
            x += (width + 2);
        }
    }

    @Override
    public Dimension getPreferredSize() {return new Dimension(bars.size() * 350, 350);} // size of the graph

    public static void main(String[] args) {
        JFrame frame = new JFrame("Java Swing Bar Chart");
        BarChart chart = new BarChart();

        chart.addBar(Color.decode("#EB2B36"), 3000); // Royal Red
        chart.addBar(Color.decode("#7851E9"), 2000); // Royal Purple
        chart.addBar(Color.decode("#4169E1"), 3000); // Royal Blue
        chart.addBar(Color.decode("#FFB7C5"), 4000); // Sakura Pink

        frame.getContentPane().add(chart);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}