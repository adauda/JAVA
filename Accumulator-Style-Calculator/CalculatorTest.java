/**
* @author kksv
* @email kksv@u.northwestern.edu
*
* @File name: CalculatorTest.java
*
* @Description A simple Accumulator calculator for single digit numbers implementing Java Swing UI
*                                 KeyEvents,Presses included for numbers and operations +,-,/,*,c,C.
*                                 Decimal Numbers formatted to 4 Points of precision.
*                                 Checks for Arithmetic Exception manually and throws it if exists in the case of
*                                 divide by zero.
*
*/

import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import java.awt.Container;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;


public class CalculatorTest{

        /**
         * @param args
         */
        public static void main (String[] args) {
                // TODO Auto-generated method stub
                
                /*Initialize the frame which will contain all the components*/
                CalculatorTestUI frame=new CalculatorTestUI();
                
                /*Set a title, size and other parameters*/
                frame.setTitle("Accumulator Calculator");
                frame.setResizable(false);
                frame.setVisible(true);
                frame.setSize(300,300);
                
                /*Center the window*/
                frame.setLocationRelativeTo(null);

        }//main ending

}//CalculatorTest ending

class CalculatorTestUI extends JFrame
{        
        private static final long serialVersionUID = 1L;

        /*Declare buttons to be used in the Calculator*/
        private JButton b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,bc,bplus,bminus,bmul,bdiv;
        
        /*Declare the two TextFields*/
        private JTextField t1,t2;
        
        /*Declare two panels, one for the text fields, and one for the buttons*/
        private JPanel p1, p2;
        
        /*Temporary variables to store the numbers used in the operations*/
        private double acc;
        private double secondNumber;
        
        /*Key Event Manager Start*/
        private class MyDispatcher implements KeyEventDispatcher {
         @Override
         public boolean dispatchKeyEvent(KeyEvent e)
         {
         if (e.getID() == KeyEvent.KEY_PRESSED)
         {
                 /*Get the pressed key's chracter to pressedWhat*/
                 char pressedWhat=e.getKeyChar();
                 
                 /*Check if key pressed was a digit*/
                 if(Character.isDigit(pressedWhat))
                 {
                         secondNumber=Character.getNumericValue(pressedWhat);
                 }
                 else
                 {
                 if(pressedWhat=='+')
                         Add();
                 if(pressedWhat=='-')
                         Substract();
                 if(pressedWhat=='*')
                         Multiply();
                 if(pressedWhat=='/')
                         Divide();
                 if(pressedWhat=='c' || pressedWhat=='C')
                         Reset();
                 }
         }
         return false;
         }//dispatchKeyEvent Ending
        
        }//MyDispatcher Class Ending
        /*Key Event Manager End*/
        
        /*All the components will be initialized in this constructor*/
        public CalculatorTestUI()
        {
                /*Add a keyboard manager event for the full JFrame*/
                KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
         manager.addKeyEventDispatcher(new MyDispatcher());
        
         /*Set what to do on the close operation*/
                setDefaultCloseOperation(EXIT_ON_CLOSE);
                
                /*Initialize the container window to modify later on*/
                Container window=getContentPane();
                
                /*Set a border layout for the window*/
                window.setLayout(new BorderLayout(10,10));

                /*Initialize temporary variables acc stores the calculated results,
                 *secondNumber stores the Number pressed*/
                acc=0.0;
                secondNumber=0.0;
                
                /*t1 represents the accumulator, answer, set a color and not editable*/
                t1=new JTextField("0.0",2);
                t1.setEditable(false);
                t1.setToolTipText("Result/Accumulator"); // an informative tool tip
                t1.setBackground(new Color(238,238,238)); //Color just to match the example in the assignment
                
                /*t2 represents the negative or positive smiley, set a color and not editable*/
                t2=new JTextField(":-)",2);
                t2.setEditable(false);
                t2.setToolTipText("+ve :-) , -ve :-("); // an informative tool tip
                t2.setBackground(new Color(238,238,238)); //Color just to match the example in the assignment
        
                /*Initialize the Panels and set a grid layout for appearance*/
                p1=new JPanel();
                p1.setLayout(new GridLayout(1,2,10,2));
                p1.setBorder(BorderFactory.createEmptyBorder(5,10,5,10)); //gap between the border

                /*Initialize and set a grid for 5 rows 3 columns*/
                p2=new JPanel();
                p2.setLayout(new GridLayout(5,3,2,2)); //keeping it simple for 15 buttons
                p2.setBorder(BorderFactory.createEmptyBorder(5,10,20,10)); //gap between the border
                
                /*Initialize all the buttons used and set tool tips for some*/
                b0=new JButton("0");
                b1=new JButton("1");
                b2=new JButton("2");
                b3=new JButton("3");
                b4=new JButton("4");
                b5=new JButton("5");
                b6=new JButton("6");
                b7=new JButton("7");
                b8=new JButton("8");
                b9=new JButton("9");
                
                bc=new JButton("C");
                bc.setForeground(Color.red);
                bc.setToolTipText("Clears the Calculator");
                
                bmul=new JButton("*");
                bmul.setForeground(Color.blue);
                bmul.setToolTipText("Multiply the last entered Number");

                bplus=new JButton("+");
                bplus.setForeground(Color.blue);
                bplus.setToolTipText("Add the last entered Number");

                bminus=new JButton("-");
                bminus.setForeground(Color.blue);
                bminus.setToolTipText("Subtract the last entered Number");

                bdiv=new JButton("/");
                bdiv.setForeground(Color.blue);
                bdiv.setToolTipText("Divide by the last entered Number");
                
                /*Add the text fields to the first panel*/
                p1.add(t1);
                p1.add(t2);
                
                /*Add the buttons the second panel*/
                p2.add(b0);
                p2.add(b1);
                p2.add(b2);
                p2.add(b3);
                p2.add(b4);
                p2.add(b5);
                p2.add(b6);
                p2.add(b7);
                p2.add(b8);
                p2.add(b9);
                p2.add(bc);
                p2.add(bplus);
                  p2.add(bminus);
                p2.add(bmul);
                p2.add(bdiv);
                
                /*Add the first panel to the north portion*/
                window.add("North",p1);
                /*Add the second panel to the Center portion*/
                window.add("Center",p2);

                /*Add a Click Action handler and listener to all the buttons*/
                ClickAction handler=new ClickAction();
                b0.addActionListener(handler);
                b1.addActionListener(handler);
                b2.addActionListener(handler);
                b3.addActionListener(handler);
                b4.addActionListener(handler);
                b5.addActionListener(handler);
                b6.addActionListener(handler);
                b7.addActionListener(handler);
                b8.addActionListener(handler);
                b9.addActionListener(handler);
                bc.addActionListener(handler);
                bplus.addActionListener(handler);
                bminus.addActionListener(handler);
                bmul.addActionListener(handler);
                bdiv.addActionListener(handler);
                
        }//Constructor ending
        
        private void smileyCheck()
        {
                /*Check for smiley*/
                if(acc<0)
                        t2.setText(":-(");
                else
                        t2.setText(":-)");
        }
        
        /*Add the accumulator and number entered by the user*/
        private void Add()
        {
                acc=acc+secondNumber;
                
                /*Set the answer field to the answer after operation
                 *set the answer text field to the String value of the
                 *Double value of the temporary variable acc*/
                t1.setText(Double.toString(acc));
                
                /*Check for smiley*/
                smileyCheck();
                
        }

        /*Subtract the number entered by the user from the Accumulator*/
        private void Substract()
        {
                acc=acc-secondNumber;
                
                /*Set the answer field to the answer after operation
                 *set the answer text field to the String value of the
                 *Double value of the temporary variable acc*/
                t1.setText(Double.toString(acc));
                
                /*Check for smiley*/
                smileyCheck();
                }
        
        /*Divide the accumalator with the number entered by the user*/
        private void Divide ()
        {
                /*Check and warn user of the Divide by zero error*/
                
                try
                        /*Operate if no divide by zero error*/
                        {
                        /*We have to manually check if secondNumber is 0.0 because
                         *Double allows Division by Zero and results in "Infinity"
                         *or "NaN" but not an Exception*/
                        if(secondNumber==0.0)
                                throw new ArithmeticException();
                        
                        acc=acc/secondNumber;
                        
                        /*Format it to 4 points of precision*/
                        DecimalFormat df = new DecimalFormat("#.####");
                        acc=Double.valueOf(df.format(acc));
                        
                        /*Set it to the TextField*/
                        t1.setText(Double.toString(acc));
                        }
                
                /*Catch the Arithmetic Exception thrown*/
                catch(ArithmeticException ae)
                {
                        JPanel warning=new JPanel();
                        JOptionPane.showMessageDialog
                        (warning,
                                        "Please Repeat Operation!!!\nDivide by zero Error!!!",
                                        "Divide by Zero Error",
                                        JOptionPane.ERROR_MESSAGE
                                        );
                }
                
                /*Check for smiley*/
                smileyCheck();
                }
        
        /*Multiply the accumulator and entered Number*/
        private void Multiply()
        {
                /*Set the answer field to the answer after operation
                 *set the answer text field to the String value of
                 *the Double value of the temporary variable acc*/
                acc=acc*secondNumber;
                
                /*Format it to 4 points of precision*/
                DecimalFormat df = new DecimalFormat("#.####");
                acc=Double.valueOf(df.format(acc));
                
                t1.setText(Double.toString(acc));
                
                /*Check for smiley*/
                smileyCheck();
                }
        
        /*Reset Everything*/
        private void Reset()
        {
                /*Reset Everything*/
                acc=0.0;
                secondNumber=0.0;
                t1.setText("");
                t2.setText("");
        }
        
        private class ClickAction implements ActionListener
        {
                public void actionPerformed(ActionEvent event)
                {
                        /*Check for the source of the events and act accordingly
                         *In the case of numbers, make the temporary variable secondNumber=the button Number
                         *In the case of operations, Perform the operation accordingly*/
                        if(event.getSource()==b0)
                        {
                                secondNumber=0;
                        }
                        else if(event.getSource()==b1)
                        {
                                secondNumber=1;
                        }
                        else if(event.getSource()==b2)
                        {
                                secondNumber=2;
                        }
                        else if(event.getSource()==b3)
                        {
                                secondNumber=3;
                        }
                        else if(event.getSource()==b4)
                        {
                                secondNumber=4;
                        }
                        else if(event.getSource()==b5)
                        {
                                secondNumber=5;
                        }
                        else if(event.getSource()==b6)
                        {
                                secondNumber=6;
                        }
                        else if(event.getSource()==b7)
                        {
                                secondNumber=7;
                        }
                        else if(event.getSource()==b8)
                        {
                                secondNumber=8;
                        }
                        else if(event.getSource()==b9)
                        {
                                secondNumber=9;
                        }
                        else if(event.getSource()==bc)
                        {
                        Reset();        
                        }
                        else if(event.getSource()==bplus)
                        {
                        Add();
                        }
                        else if(event.getSource()==bminus)
                        {
                        Substract();
                        }
                        else if(event.getSource()==bmul)
                        {
                        Multiply();
                        }
                        else if(event.getSource()==bdiv)
                        {
                        Divide();
                        }
                        
                        
                }//actionPerformed ending
                
        }//ClickAction ending

} //CalculatorTestUI ending

