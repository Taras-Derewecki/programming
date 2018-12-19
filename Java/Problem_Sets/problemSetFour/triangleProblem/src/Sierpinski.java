import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Sierpinski extends JApplet
{
    private JTextField textField = new JTextField("0", 5); // Order
    private SierpinskiPanel trianglePattern = new SierpinskiPanel(); // To display the pattern

    public Sierpinski()
    {
        // New JPanel holds label, text field, and one button
        JPanel panel = new JPanel();
        panel.add(new JLabel("Enter an order: "));
        panel.add(textField);
        textField.setHorizontalAlignment(SwingConstants.RIGHT);

        // Add a Sierpinski Triangle panel to the applet
        add(trianglePattern);
        add(panel, BorderLayout.SOUTH);

        // Register a listener
        textField.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {trianglePattern.setOrder(Integer.parseInt(textField.getText()));}
        });
    }

    static class SierpinskiPanel extends JPanel
    {
        private int sequence = 0;

        /* Set a new sequence */
        public void setOrder(int sequence)
        {
            this.sequence = sequence;
            repaint();
        }

        @Override
        protected void paintComponent(Graphics graphic)
        {
            super.paintComponent(graphic);

            // Select 3 pts with attention to panel size
            Point ptOne = new Point(getWidth() / 2, 10);
            Point ptTwo = new Point(10, getHeight() - 10);
            Point ptThree = new Point(getWidth() - 10, getHeight() - 10);

            displayTriangles(graphic, sequence, ptOne, ptTwo, ptThree);
        }

        private static void displayTriangles(Graphics g, int sequence, Point ptOne, Point ptTwo, Point ptThree)
        {
            // Base Case
            if (sequence == 0)
            {
                // Draw a triangle to connect three points
                g.drawLine(ptOne.x, ptOne.y, ptTwo.x, ptTwo.y);
                g.drawLine(ptOne.x, ptOne.y, ptThree.x, ptThree.y);
                g.drawLine(ptTwo.x, ptTwo.y, ptThree.x, ptThree.y);
            }

            // Recursive Case
            else
            {
                // Get the midpoint on each edge in the triangle
                Point ptOne2 = midpoint(ptOne, ptTwo);
                Point ptTwo3 = midpoint(ptTwo, ptThree);
                Point ptThree1 = midpoint(ptThree, ptOne);

                // Recursively display three triangles
                displayTriangles(g, sequence - 1, ptOne, ptOne2, ptThree1);
                displayTriangles(g, sequence - 1, ptOne2, ptTwo, ptTwo3);
                displayTriangles(g, sequence - 1, ptThree1, ptTwo3, ptThree);
            }
        }

        private static Point midpoint(Point ptOne, Point ptTwo)
            {return new Point((ptOne.x + ptTwo.x) / 2, (ptOne.y + ptTwo.y) / 2);}
    }

    public static void main(String[] args)
    {
        JFrame frame = new JFrame("Java Swing Sierpinski Triangle");
        Sierpinski applet = new Sierpinski();
        frame.add(applet);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setVisible(true);
    }
}