/**
 * Created by Taras on 2/2/2017.
 */

import javax.swing.*;
import java.awt.*;
import static java.lang.Math.*;

public class KochSnowflake extends JApplet
{
    public void paint(Graphics graphics)
    {
        trace(graphics,5,20,280,280,280);
        trace(graphics,5,280,280,150,20);
        trace(graphics,5,150,20,20,280);
        this.setSize(new Dimension(375,375));
    }

    private static void trace(Graphics graphics, int layer, int x1, int y1, int x5, int y5)
    {
        if (layer == 0) {graphics.drawLine(x1, y1, x5, y5);}
        else
        {
           Integer deltaX = x5 - x1;
           Integer deltaY = y5 - y1;
           Integer x2 = x1 + (deltaX / 3);
           Integer y2 = y1 + (deltaY / 3);
           Integer x3 = (int) (0.5 * (x1 + x5) + sqrt(3) * (y1 - y5) / 6);
           Integer y3 = (int) (0.5 * (y1 + y5) + sqrt(3) * (x5 - x1) / 6);
           Integer x4 = x1 + 2 * (deltaX / 3);
           Integer y4 = y1 + 2 * (deltaY / 3);

           trace(graphics,layer - 1, x1, y1, x2, y2);
           trace(graphics,layer - 1, x2, y2, x3, y3);
           trace(graphics,layer - 1, x3, y3, x4, y4);
           trace(graphics,layer - 1, x4, y4, x5, y5);
        }
    }
}
