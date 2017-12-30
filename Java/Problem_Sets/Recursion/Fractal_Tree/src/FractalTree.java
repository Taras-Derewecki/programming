/**
 * Created by Taras on 2/2/2017.
 */
import javax.swing.JFrame;
import java.awt.Graphics;
import static java.lang.Math.*;

public class FractalTree extends JFrame
{
    public FractalTree() {setSize(800, 800);}

    @Override
    public void paint(Graphics graphics) {traceFractalTree(graphics, 400, 500, -90, 9);}

    private void traceFractalTree(Graphics graphics, int x1, int y1, double theta, int iterations)
    {
        if (iterations == 0) {return;}

        int x2 = x1 + (int)(cos(toRadians(theta)) * iterations * 10.0);
        int y2 = y1 + (int)(sin(toRadians(theta)) * iterations * 10.0);
        graphics.drawLine(x1, y1, x2, y2);
        traceFractalTree(graphics, x2, y2, theta - 20, iterations - 1);
        traceFractalTree(graphics, x2, y2, theta + 20, iterations - 1);
    }

    public static void main(String[] args) {new FractalTree().setVisible(true);}
}