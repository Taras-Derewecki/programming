import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;


public class Notepad extends JFrame implements ActionListener {
    public static final int WIDTH = 600;
    public static final int HEIGHT = 600;

    private JTextArea txtField;

    public static void main(String[] args) {
        Notepad text = new Notepad("Text File");
        text.setVisible(true);
    }

    public Notepad(String title) {
        super(title);
        setSize(WIDTH,HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        txtField = new JTextArea();
        add(txtField);

        JMenu menu = new JMenu("File");

        JMenuItem newOption = new JMenuItem("New");
        newOption.addActionListener(this);
        menu.add(newOption);

        JMenuItem openOption = new JMenuItem("Open");
        openOption.addActionListener(this);
        menu.add(openOption);

        JMenuItem saveOption = new JMenuItem("Save");
        saveOption.addActionListener(this);
        menu.add(saveOption);

        JMenuItem exitOption = new JMenuItem("Exit");
        exitOption.addActionListener(this);
        menu.add(exitOption);

        JMenuBar bar = new JMenuBar();
        bar.add(menu);
        setJMenuBar(bar);
    }

    public void actionPerformed(ActionEvent event) {

        String actionTaken = event.getActionCommand();
        switch (actionTaken) {
            case "New": txtField.setText(""); break;

            case "Save":
                JFileChooser file = new JFileChooser();
                int op = file.showOpenDialog(this);

                if(op == JFileChooser.APPROVE_OPTION) {
                    try {
                        BufferedWriter write = new BufferedWriter(new FileWriter(file.getSelectedFile().getPath()));
                        write.write(txtField.getText());
                        write.close();
                    }

                    catch(Exception exception){ System.out.println("Error"); }
                }
                break;

            case "Open":                                                    //Case for Opening an Existing file
                JFileChooser open = new JFileChooser();
                int OP = open.showOpenDialog(this);

                if (OP == JFileChooser.APPROVE_OPTION) {
                    try {
                        BufferedReader read = new BufferedReader(new FileReader(open.getSelectedFile()));

                        while (read.readLine()!=null)
                            txtField.append(read.readLine());
                    }

                    catch (Exception exception){ System.out.println("Error"); }
                }
                break;

            case "Exit": this.dispose(); break;
        }
    }
}