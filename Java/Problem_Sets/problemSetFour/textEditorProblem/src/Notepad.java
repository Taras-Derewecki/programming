/**
 * Created by Taras on 10/22/2016.
 */

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class Notepad extends JFrame implements ActionListener
{
    private JTextArea textArea;
    private JMenuBar menuBar;
    private JMenu fileM;
    private JScrollPane scrollPane;
    private JMenuItem exitI, saveI, openI, newI;
    private Component modalToComponent;

    public Notepad()
    {
        super("Notepad");
        setSize(555, 444);
        Container pane = getContentPane();
        pane.setLayout(new BorderLayout());

        textArea = new JTextArea();             // Textarea
        menuBar = new JMenuBar();               // Menu Bar
        fileM = new JMenu("File");              // File Menu
        scrollPane = new JScrollPane(textArea); // Scroll Pane and add textarea to scroll pane
        newI = new JMenuItem("New");            // Menu Item
        exitI = new JMenuItem("Exit");          // Menu Item
        saveI = new JMenuItem("Save");          // Menu item
        openI = new JMenuItem("Open");          // Menu item

        textArea.setLineWrap(true);      // Text wraps around to next line
        textArea.setWrapStyleWord(true); // Full word enters new line during wrapping process

        setJMenuBar(menuBar);
        menuBar.add(fileM);

        // Adds to the file menu
        fileM.add(newI);
        fileM.add(openI);
        fileM.add(saveI);
        fileM.add(exitI);

        pane.add(scrollPane, BorderLayout.CENTER); // allows for text to be entered

        // Implement functions
        newI.addActionListener(this);
        saveI.addActionListener(this);
        openI.addActionListener(this);
        exitI.addActionListener(this);

        setVisible(true); // Display notepad itself
    }

    public void actionPerformed(ActionEvent e) {
        JMenuItem choice = (JMenuItem) e.getSource();
        JFileChooser fileChooser = new JFileChooser(); // creating a file chooser

        if (e.getSource() == openI)
        {
            if (fileChooser.showOpenDialog(modalToComponent) == JFileChooser.APPROVE_OPTION) // if user selects a file
            {
                String line = null;
                File file = fileChooser.getSelectedFile();
//                BufferedReader br = new BufferedReader(new FileReader(line));
//
//
//
//                while (line = br.readLine() != null)
//                {
//                    textArea.append(line);
//

//                }

                textArea.append(file.toString());
            }

            if (choice == saveI)
            {

                if (fileChooser.showSaveDialog(modalToComponent) == JFileChooser.APPROVE_OPTION)
                {
                    File file = fileChooser.getSelectedFile();
//                    file.add(file.getName() + ".txt");
//                    fileChooser.getSelectedFile(file);

                }
            }

            if (choice == newI) {textArea.setText("");}

            if (choice == exitI) {System.exit(0);}
        }
    }

    public static void main(String[] args) {new Notepad();}
}
