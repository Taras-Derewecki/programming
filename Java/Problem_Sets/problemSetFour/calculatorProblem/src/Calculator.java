import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;


public class Calculator extends JFrame implements ActionListener
{
    private JMenu fileM, helpM;
    private JMenuItem exitI, aboutI;
    private JLabel outputL;
    private JButton buttonB[];
    private JPanel masterP, backspaceP, controlP;

    double numberOfLastDigit;
    boolean isClearOnNextNumber;
    String finalOperation;

    int showCase;
    final int RESULT = 1;
    final int ERRORS = 2;
    final int MAX_INPUT = 20;
    final int INPUT = 0;

    public Calculator() {
        fileM = new JMenu("File");
        exitI = new JMenuItem("Exit");
        helpM = new JMenu("Help");
        aboutI = new JMenuItem("About Calculator");

        fileM.add(exitI);
        helpM.add(aboutI);

        JMenuBar mb = new JMenuBar();
        mb.add(fileM);
        mb.add(helpM);
        setJMenuBar(mb);


        masterP = new JPanel();
        outputL = new JLabel("0");

        getContentPane().add(outputL, BorderLayout.NORTH); // display numbers chosen

        buttonB = new JButton[23];

        JPanel jplButtons = new JPanel();            // container for Jbuttons

        // Create numeric Jbuttons
        for (int i = 0; i <= 9; i++) {
            buttonB[i] = new JButton(String.valueOf(i));
        }

        // Create operator Jbuttons
        buttonB[10] = new JButton("+/-");
        buttonB[11] = new JButton(".");
        buttonB[12] = new JButton("=");
        buttonB[13] = new JButton("/");
        buttonB[14] = new JButton("*");
        buttonB[15] = new JButton("-");
        buttonB[16] = new JButton("+");
        buttonB[17] = new JButton("sqrt");
        buttonB[18] = new JButton("1/x");
        buttonB[19] = new JButton("%");

        backspaceP = new JPanel();

        buttonB[20] = new JButton("Backspace");
        backspaceP.add(buttonB[20]);

        controlP = new JPanel();

        buttonB[21] = new JButton(" CE ");
        buttonB[22] = new JButton("C");

        controlP.add(buttonB[21]);
        controlP.add(buttonB[22]);

        // 4 x 5 matrix layout
        jplButtons.setLayout(new GridLayout(4, 5));

        // First row's buttons contains:
        for (int i = 7; i <= 9; i++) {
            jplButtons.add(buttonB[i]);
        }

        // add button / and sqrt
        jplButtons.add(buttonB[13]);
        jplButtons.add(buttonB[17]);

        // Second row's buttons contains:
        for (int i = 4; i <= 6; i++) {
            jplButtons.add(buttonB[i]);
        }

        // add button * and x^2
        jplButtons.add(buttonB[14]);
        jplButtons.add(buttonB[18]);

        // Third row's buttons contains:
        for (int i = 1; i <= 3; i++) {
            jplButtons.add(buttonB[i]);
        }

        //adds button - and %
        jplButtons.add(buttonB[15]);
        jplButtons.add(buttonB[19]);

        //Fourth Row
        // add 0, +/-, ., +, and =
        jplButtons.add(buttonB[0]);
        jplButtons.add(buttonB[10]);
        jplButtons.add(buttonB[11]);
        jplButtons.add(buttonB[16]);
        jplButtons.add(buttonB[12]);

        masterP.setLayout(new BorderLayout());
        masterP.add(backspaceP, BorderLayout.WEST);
        masterP.add(controlP, BorderLayout.EAST);
        masterP.add(jplButtons, BorderLayout.SOUTH);

        getContentPane().add(masterP, BorderLayout.SOUTH);
//        requestFocus();

        // ActionListener comes into play and uses the functions of all buttons
        for (int i = 0; i < buttonB.length; i++) {
            buttonB[i].addActionListener(this);
        }

        aboutI.addActionListener(this);
        exitI.addActionListener(this);

        clearAll();
    }


    // Perform action
    public void actionPerformed(ActionEvent e)
    {
        double result;

        // functions

        if(e.getSource() == aboutI)
        {
            JDialog aboutD = new CustomABOUTDialog(this, "About Java Swing Calculator", true);
            aboutD.setVisible(true);
        }

        else if(e.getSource() == exitI) {System.exit(0);}

        // Search for the button pressed until end of array or key found
        for (int i = 0; i < buttonB.length; i++)
        {
            if(e.getSource() == buttonB[i])
            {
                switch(i)
                {
                    case 0:
                        addDigitToDisplay(i);
                        break;

                    case 1:
                        addDigitToDisplay(i);
                        break;

                    case 2:
                        addDigitToDisplay(i);
                        break;

                    case 3:
                        addDigitToDisplay(i);
                        break;

                    case 4:
                        addDigitToDisplay(i);
                        break;

                    case 5:
                        addDigitToDisplay(i);
                        break;

                    case 6:
                        addDigitToDisplay(i);
                        break;

                    case 7:
                        addDigitToDisplay(i);
                        break;

                    case 8:
                        addDigitToDisplay(i);
                        break;

                    case 9:
                        addDigitToDisplay(i);
                        break;

                    case 10:	// +/-
                        processSignChange();
                        break;

                    case 11:	// decimal point
                        addDecimalPoint();
                        break;

                    case 12:	// =
                        processEquals();
                        break;

                    case 13:	// divide
                        processOperator("/");
                        break;

                    case 14:	// *
                        processOperator("*");
                        break;

                    case 15:	// -
                        processOperator("-");
                        break;

                    case 16:	// +
                        processOperator("+");
                        break;

                    case 17:	// sqrt
                        if (showCase != ERRORS)
                        {
                            try
                            {
                                if (getDisplayString().indexOf("-") == 0)
                                    displayError("Invalid input for function!");

                                result = Math.sqrt(getNumberInDisplay());
                                displayResult(result);
                            }

                            catch(Exception ex)
                            {
                                displayError("Invalid input for function!");
                                showCase = ERRORS;
                            }
                        }
                        break;

                    case 18:	// 1/x
                        if (showCase != ERRORS){
                            try
                            {
                                if (getNumberInDisplay() == 0)
                                    displayError("Cannot divide by zero!");

                                result = 1 / getNumberInDisplay();
                                displayResult(result);
                            }

                            catch(Exception ex)
                            {
                                displayError("Cannot divide by zero!");
                                showCase = ERRORS;
                            }
                        }
                        break;

                    case 19:	// %
                        if (showCase != ERRORS)
                        {
                            try
                            {
                                result = getNumberInDisplay() / 100;
                                displayResult(result);
                            }

                            catch(Exception ex)
                            {
                                displayError("Invalid input for function!");
                                showCase = ERRORS;
                            }
                        }
                        break;

                    case 20:	// backspace
                        if (showCase != ERRORS)
                        {
                            setDisplayString(getDisplayString().substring(0,
                                    getDisplayString().length() - 1));

                            if (getDisplayString().length() < 1)
                                setDisplayString("0");
                        }
                        break;

                    case 21:	// CE
                        clearExisting();
                        break;

                    case 22:	// C
                        clearAll();
                        break;
                }
            }
        }
    }

    void setDisplayString(String s){
        outputL.setText(s);
    }

    String getDisplayString (){
        return outputL.getText();
    }

    void addDigitToDisplay(int digit)
    {
        if (isClearOnNextNumber)
            setDisplayString("");

        String inputString = getDisplayString();

        if (inputString.indexOf("0") == 0) {inputString = inputString.substring(1);}

        if ((!inputString.equals("0") || digit > 0)  && inputString.length() < MAX_INPUT){setDisplayString(inputString + digit);}

        showCase = INPUT;
        isClearOnNextNumber = false;
    }

    void addDecimalPoint()
    {
        showCase = INPUT;

        if (isClearOnNextNumber)
            setDisplayString("");

        String inputString = getDisplayString();


        if (inputString.indexOf(".") < 0){setDisplayString(new String(inputString + "."));}
    }

    void processSignChange()
    {
        if (showCase == INPUT)
        {
            String input = getDisplayString();

            if (input.length() > 0 && !input.equals("0"))
            {
                if (input.indexOf("-") == 0) {setDisplayString(input.substring(1));}

                else {setDisplayString("-" + input);}
            }
        }

        else if (showCase == RESULT)
        {
            double numberInDisplay = getNumberInDisplay();

            if (numberInDisplay != 0) {displayResult(-numberInDisplay);}
        }
    }

    void clearAll()
    {
        setDisplayString("0");
        finalOperation = "0";
        numberOfLastDigit = 0;
        showCase = INPUT;
        isClearOnNextNumber = true;
    }

    void clearExisting()
    {
        setDisplayString("0");
        isClearOnNextNumber = true;
        showCase = INPUT;
    }

    double getNumberInDisplay()
    {
        String input = outputL.getText();
        return Double.parseDouble(input);
    }

    void processOperator(String op)
    {
        if (showCase != ERRORS)
        {
            double numberInDisplay = getNumberInDisplay();

            if (!finalOperation.equals("0"))
            {
                try
                {
                    double result = processLastOperator();
                    displayResult(result);
                    numberOfLastDigit = result;
                }

                catch (DivideByZeroException e) {}
            }

            else {numberOfLastDigit = numberInDisplay;}

            isClearOnNextNumber = true;
            finalOperation = op;
        }
    }

    void processEquals()
    {
        double result;

        if (showCase != ERRORS)
        {
            try
            {
                result = processLastOperator();
                displayResult(result);
            }

            catch (DivideByZeroException e) {displayError("Cannot divide by zero!");}

            finalOperation = "0";
        }
    }

    double processLastOperator() throws DivideByZeroException
    {
        double result = 0;
        double numberInDisplay = getNumberInDisplay();

        if (finalOperation.equals("/"))
        {
            if (numberInDisplay == 0) {throw (new DivideByZeroException());}

            result = numberOfLastDigit / numberInDisplay;
        }

        if (finalOperation.equals("*"))
            result = numberOfLastDigit * numberInDisplay;

        if (finalOperation.equals("-"))
            result = numberOfLastDigit - numberInDisplay;

        if (finalOperation.equals("+"))
            result = numberOfLastDigit + numberInDisplay;

        return result;
    }

    void displayResult(double result)
    {
        setDisplayString(Double.toString(result));
        numberOfLastDigit = result;
        showCase = RESULT;
        isClearOnNextNumber = true;
    }

    void displayError(String errorMessage)
    {
        setDisplayString(errorMessage);
        numberOfLastDigit = 0;
        showCase = ERRORS;
        isClearOnNextNumber = true;
    }

    public static void main(String args[])
    {
        Calculator calc = new Calculator();
//        Container contentPane = calc.getContentPane();

        calc.setTitle("Java Swing Calculator");
        calc.setSize(555, 444);
        calc.pack();
        calc.setVisible(true);
        calc.setResizable(false);
    }

}		//End of Swing Calculator Class.

class DivideByZeroException extends Exception
{
    public DivideByZeroException()
    {
        super();
    }

    public DivideByZeroException(String s)
    {
        super(s);
    }
}

class CustomABOUTDialog extends JDialog implements ActionListener
{
    JButton buttonJ;

    CustomABOUTDialog(JFrame parent, String title, boolean modal)
    {
        super(parent, title, modal);
        setBackground(Color.black);

        JPanel p1 = new JPanel(new FlowLayout(FlowLayout.CENTER));

        StringBuffer text = new StringBuffer();
        text.append("Calc stuff\n\n");
        text.append("Developer:	Taras Derewecki\n");
        text.append("Version:	5.0");

        JTextArea jtAreaAbout = new JTextArea(5, 21);
        jtAreaAbout.setText(text.toString());
        jtAreaAbout.setEditable(false);

        p1.add(jtAreaAbout);
        getContentPane().add(p1, BorderLayout.CENTER);

        JPanel p2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonJ = new JButton(" OK ");
        buttonJ.addActionListener(this);

        p2.add(buttonJ);
        getContentPane().add(p2, BorderLayout.SOUTH);

        setResizable(false);

        pack();
    }

    public void actionPerformed(ActionEvent e) {if(e.getSource() == buttonJ) {this.dispose();}}
}