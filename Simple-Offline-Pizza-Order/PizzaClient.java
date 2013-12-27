/**
* @author kksv
* @author Kartheeka S V Konduru
* @File name: PizzaClient.java
*
* @Description A Simple GUI to implement a Pizza Ordering Sample Application
*                                 The GUI is implemented using the JAVA Swing
*                                 An Exception Handler only exists for the Number of Pizzas
*                                 No other Exception will occur because preInitialized Input Components
*                                 If no topping is selected, Default Regular Toppings is chosen
*                                 If no size is selected , user is prompted and warned to enter a size
*                                 Image image.jpeg has to be with the PizzaClient.java file while running it
*                                 Image Opens with "javac PizzaClient.java" but not in Eclipse
*/

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.BorderFactory;
import java.awt.Container;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class PizzaClient{

        /**
         * @param args
         */
        public static void main (String[] args) {
                // TODO Auto-generated method stub
                
                /*Initialize the frame which will contain all the components*/
                PizzaUI frame=new PizzaUI();
                
                /*Set a title, size and other parameters*/
                frame.setTitle("Pizza House");
                frame.setResizable(false);
                frame.setVisible(true);
                frame.setSize(650,600);
                
                /*Center the window*/
                frame.setLocationRelativeTo(null);

        }//main ending

}//PizzaClient ending

class PizzaUI extends JFrame
{        
        private static final long serialVersionUID = 1L;

        /*Declare Components to be used in the PizzaUI*/
        
        private JButton CalcPrice,AnotherOrder,NewCust,Exit;
        
        private JLabel PizzaSizeLabel,Toppings;
        private JRadioButton S,M,L;
        private JCheckBox GBeef,Mushroom,ExtraCheese,Pepporoni,GreenPepper;
        private ButtonGroup group;
        
        private JLabel imageLabel,imageLabel2,imageLabel3;
        private JTextField NumberOfPizzasText;
        private JTextArea ta;
        private JScrollPane scrollPane;
        
        private JPanel pNorth, pSouth, pCenter, pSideText;
        
        private JPanel pSidePanel,pTopSide,pBotSide,pMidSide;
        
        /*Temporary Variables*/
        private double grandTotal=0;
        ImageIcon image;
        private double price;
        private int toppingsCount,pizzaCount;
        private String toppingsList;
        private String pizzaSize;
        
        /*All the components will be initialized in this constructor*/
        public PizzaUI()
        {
                toppingsList="Regular";
         grandTotal=0;
                /*Set what to do on the close operation*/
                setDefaultCloseOperation(EXIT_ON_CLOSE);
                
                /*Initialize the container window to modify later on*/
                Container window=getContentPane();
                
                /*Set a border layout for the window*/
                window.setLayout(new BorderLayout(10,10));

                NumberOfPizzasText=new JTextField("0",2);
                NumberOfPizzasText.setEditable(true);
                NumberOfPizzasText.setToolTipText("Number of Pizzas"); // an informative tool tip
                
                /*Initialize Text Area*/
                ta=new JTextArea("",20,20);
                ta.setEditable(false);
                /*Set A Scroll Pane to contain the Text Area for neat Presentation*/
                scrollPane=new JScrollPane(ta);
                
                /*Initialize the Panels and set a grid layout for appearance*/
                pNorth=new JPanel();
                pNorth.setLayout(new GridLayout(1,3));
                
                pCenter=new JPanel();
                pCenter.setLayout(new GridLayout(1,2));
                
                pTopSide=new JPanel();
                pTopSide.setLayout(new GridLayout(1,4));
                pTopSide.setBorder(BorderFactory.createMatteBorder(
                0, 0, 5, 0, Color.gray));
                pMidSide=new JPanel();
                pMidSide.setLayout(new GridLayout(6,1));
                
                pBotSide=new JPanel();
                pBotSide.setLayout(new GridLayout(1,4));
                pBotSide.setBorder(BorderFactory.createMatteBorder(
                5, 0, 0, 0, Color.gray));
                
                pSouth=new JPanel();
                pSouth.setLayout(new GridLayout(1,4));
                
                /*Initiallize the RadioButtons*/
                S=new JRadioButton("S");
                M=new JRadioButton("M");
                L=new JRadioButton("L");
                
                /*Initialize a Button Group to contain the buttons for simplicity of operations later*/
                group=new ButtonGroup();
                group.add(S);
                group.add(M);
                group.add(L);

                imageLabel=new JLabel();
                imageLabel2=new JLabel();
                imageLabel3=new JLabel();
                
                /*Make the Image an Icon*/
                image = new ImageIcon("image.jpeg");

                /*Make the Icon a Label*/
                imageLabel.setIcon(image);
                imageLabel.setOpaque(true);
                imageLabel.setBackground(Color.WHITE);
                
                /*A Lable to contain the Welcome Text*/
                imageLabel2.setText("<html><FONT SIZE=14>Welcome to</FONT><br>" +
                         "<FONT SIZE=14>Pizza House</FONT></html>");
                imageLabel2.setOpaque(true);
                imageLabel2.setBackground(Color.WHITE);
                
                /*Make the Icon a Lable Again*/
                imageLabel3.setIcon(image);
                imageLabel3.setOpaque(true);
                imageLabel3.setBackground(Color.WHITE);
                
                /*Add the Images and Welcome Text to the North Panel*/
                pNorth.add(imageLabel);
                pNorth.add(imageLabel2);
                pNorth.add(imageLabel3);

                /*Side Text Panel*/
                pSideText=new JPanel();
                pSideText.setLayout(new GridLayout(1,1));
                pSideText.add(scrollPane);
                
                /*Initialize Labels in the Option Side Panel*/
                Toppings=new JLabel("Toppings:");
                GBeef=new JCheckBox("Ground Beef");
                Mushroom=new JCheckBox("Mushroom");
                ExtraCheese=new JCheckBox("Extra Cheese");
                Pepporoni=new JCheckBox("Pepporoni");
                GreenPepper=new JCheckBox("GreenPepper");
                
                /*Add the Label and the CheckBoxes to the Grid Layout to the Middle Panel of the Side Panel*/
                pMidSide.add(Toppings);
                pMidSide.add(GBeef);
                pMidSide.add(Mushroom);
                pMidSide.add(ExtraCheese);
                pMidSide.add(Pepporoni);
                pMidSide.add(GreenPepper);
                
                /*Add the TextField to the Bottom Panel of the Side Panel*/
                pBotSide.add(new JLabel("Number of Pizzas: "));
                pBotSide.add(NumberOfPizzasText);

                PizzaSizeLabel=new JLabel("Pizza Size");

                /*Add the label and Radio Buttons to the Top Panel of the Side Panel*/
                pTopSide.add(PizzaSizeLabel);
                pTopSide.add(S);
                pTopSide.add(M);
                pTopSide.add(L);
                
                /*Initialize and set a grid for 5 rows 3 columns*/
                pSidePanel=new JPanel();
                pSidePanel.setLayout(new BorderLayout(10,10));
                pSidePanel.add("North",pTopSide);
                pSidePanel.add("Center",pMidSide);
                pSidePanel.add("South",pBotSide);
                
                /*Initialize all the buttons*/
                CalcPrice = new JButton("Calculate Price");
                AnotherOrder=new JButton("Another Order");
                NewCust=new JButton("New Customer");
                Exit=new JButton("Exit");
                
                /*Add Buttons to the South Panel*/
                pSouth.add(CalcPrice);
                pSouth.add(AnotherOrder);
                pSouth.add(NewCust);
                pSouth.add(Exit);
                
                /*Add Action Handlers*/
                ClickAction handler=new ClickAction();
                CalcPrice.addActionListener(handler);
                NewCust.addActionListener(handler);
                AnotherOrder.addActionListener(handler);
                Exit.addActionListener(handler);
                
                
                /*Add the options Panel*/
                pCenter.add(pSidePanel);
                /*Add the Text Area Scrollable Panel*/
                pCenter.add(pSideText);
                
                /*Let the panel with pictures and Welcome Text go to North*/
                window.add("North",pNorth);
                /*Let the Center Panel have The Text Area Panel and Options Panel*/
                window.add("Center",pCenter);
                /*Let the South Panel have the Buttons*/
                window.add("South",pSouth);
                
                
        }//Constructor ending
        
        private class ClickAction implements ActionListener
        {
                public void actionPerformed(ActionEvent event)
                {
                        /*Calculate Price Button*/
                        if(event.getSource()==CalcPrice)
                        {
                                getRadioButton();
                                getCheckedBoxes();
                                try
                                {
                                        /*Integer.valueOf throws an Exception if an Integer is not entered which is necessary for Number of pizzas*/
                                        pizzaCount=Integer.valueOf(NumberOfPizzasText.getText());
                                        
                                        /*If its not a positive integer above 0 also lets throw the same Exception */
                                        if(pizzaCount<1)
                                                throw new Exception();
                                        
                                        else if(pizzaCount>0)
                                        {
                                                
                                                ta.append("Pizza Size: ");
                                                ta.append(pizzaSize+"($"+price+")"+"\n");
                                                ta.append("Price of each Pizza without Tax: ");
                                                if(toppingsCount>1)
                                                {
                                                        price+=toppingsCount-1;
                                                }
                                                ta.append(price+"\n");
                                                ta.append("Number of Toppings: ");
                                                ta.append(toppingsCount+"\n");
                                                ta.append("Toppings: ");
                                                ta.append(toppingsList+"\n");
                                                ta.append("NumberOfPizzas: ");
                                                ta.append(pizzaCount+"\n");
                                                ta.append("SalesTax: ");
                                                ta.append(((0.08*price*pizzaCount))+"\n");
                                                ta.append("Total: ");
                                                
                                                /*Calculate Price with 8% Sales Tax*/
                                                price=((0.08*price*pizzaCount)+price*pizzaCount);
                                                ta.append(price+"\n\n");
                                                
                                                /*Add Current Pizza Price to the GrandTotal*/
                                                grandTotal+=price;
                                                ta.append("Grand Total: $");
                                                ta.append(grandTotal+"\n\n");
                                        }
                                }
                                catch(Exception e)
                                {
                                        JPanel warning=new JPanel();
                                        JOptionPane.showMessageDialog
                                        (warning,
                                                        "Please Enter a Positive Integer more than 0 in the Number of Pizzas Field!!!",
                                                        "Not a Integer Problem!!!",
                                                        JOptionPane.ERROR_MESSAGE
                                                        );
                                }
                                
                                /*Clear everything*/
                                group.clearSelection();
                                GBeef.setSelected(false);
                                Mushroom.setSelected(false);
                                ExtraCheese.setSelected(false);
                                Pepporoni.setSelected(false);
                                GreenPepper.setSelected(false);
                                NumberOfPizzasText.setText("");
                                
                        }//Calc Price Button
                        
                        /*Exit Button*/
                        if(event.getSource()==Exit)
                        {
                                        System.exit(0);
                        }//Exit Button
                        
                        /*Another Order Button*/
                        if(event.getSource()==AnotherOrder)
                        {
                                /*Clear the selections for a fresh order*/
                                group.clearSelection();
                                GBeef.setSelected(false);
                                Mushroom.setSelected(false);
                                ExtraCheese.setSelected(false);
                                Pepporoni.setSelected(false);
                                GreenPepper.setSelected(false);
                                NumberOfPizzasText.setText("");
                        }
                        
                        /*New Customer Button*/
                        if(event.getSource()==NewCust)
                        {
                                /*Clear the selections and Grand Total and Text Area*/
                                ta.setText("");
                                grandTotal=0;
                                group.clearSelection();
                                GBeef.setSelected(false);
                                Mushroom.setSelected(false);
                                ExtraCheese.setSelected(false);
                                Pepporoni.setSelected(false);
                                GreenPepper.setSelected(false);
                                NumberOfPizzasText.setText("");
                        }
                }
        }//Click Action End
        
        private void getRadioButton()
        {        
                /*Find the selected Size*/
                price = 0.0;
                if(S.isSelected())
                {
                pizzaSize="Small";
                price = 12.0;
                }
                else if(M.isSelected())
                {
                pizzaSize="Medium";
                price = 14.0;
                }
                else if(L.isSelected())
                {
                pizzaSize="Large";
                price = 16.0;
                }
                else
                {
                JPanel warning=new JPanel();
                JOptionPane.showMessageDialog
                (warning,
                                "Please Choose a Size!!!\nFrom the RadioButtons!!!",
                                "You Didn't Choose a Size!!!",
                                JOptionPane.ERROR_MESSAGE
                                );
                }
        }//Radio Button Selection Find
        
        private void getCheckedBoxes()
        {
                toppingsCount=0;
                toppingsList="Regular";
                /*Price is 0 if no size has been selected in prechecked condition*/
                if(price==0.0)
                {
                        JPanel warning=new JPanel();
                        JOptionPane.showMessageDialog
                        (warning,
                                        "Please Choose a Size!!!\nFrom the RadioButtons!!!",
                                        "You Didn't Choose a Size!!!",
                                        JOptionPane.ERROR_MESSAGE
                                        );
                }
                
                /*Check the toppings Selection*/
                else
                {
                        if(GBeef.isSelected())
                        {
                                toppingsCount++;
                                toppingsList=toppingsList+", Ground Beef";
                        }
                        if(GreenPepper.isSelected())
                        {
                                toppingsCount++;
                                toppingsList=toppingsList+", Green Pepper";
                        }
                        if(Mushroom.isSelected())
                        {
                                toppingsCount++;
                                toppingsList=toppingsList+", Mushroom";
                        }
                        if(ExtraCheese.isSelected())
                        {
                                toppingsCount++;
                                toppingsList=toppingsList+", Extra Cheese";
                        }
                        if(Pepporoni.isSelected())
                        {
                                toppingsCount++;
                                toppingsList=toppingsList+", Pepperoni";
                        }
                        
        
                }
        }//Check Boxes Selection Find
        
        
} //PizzaUI ending
