package Interface;



/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Tomek
 */

import Tables.ResultSetTable;
import java.awt.*;
import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

public class Interface extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel buttonPanel;
    private JButton exitButton; 
    private JButton helpButton; 
    private Container container;
    private JButton buttonNetWorth;  
    private JButton buttonPayroll; 
    private JButton buttonAddressBookDisplay; 
    private JButton buttonPatients; 
    private JButton buttonDoctorsPatients2; 
    private JButton buttonTables; 
    int count  = 0;
    int count1 = 0;
    int count2 = 0;
    int count3 = 0;
    int count4 = 0;
    int count5 = 0;
    
    public Interface()
    {
        super ("Medical Office");
        setLayout (new FlowLayout());
  
        container = getContentPane();
        container.setBackground(Color.orange);
	         
// Creating 2 rows of buttons, 4 in each row
        
        buttonPanel = new JPanel();
        buttonPanel.setLayout(
                new GridLayout(2,8));
        
//  create event for south button
        buttonPayroll= new JButton ("Payroll" ); 
        buttonPayroll.addActionListener(new ActionListener()
       {
          public void actionPerformed (ActionEvent e)
        {  
            
         Object pressed = e.getSource();
         if (pressed == buttonPayroll && count == 0)
         {
          new Payroll.EmployeeRecords();
        
         }
          count++;
         if (pressed == buttonPayroll && count> 1)
         {
         JOptionPane.showMessageDialog(null, "Window already opened");
         
         }
          
        }
      }
   );
 buttonPanel.add(buttonPayroll); 
       buttonNetWorth = new JButton ("Net Worth" );
        buttonNetWorth.addActionListener(new ActionListener()
        {
         
		public void actionPerformed (ActionEvent e)
         {
         		 Object pressed = e.getSource();
			 if (pressed == buttonNetWorth && count1 ==0) 
                         {
			new NetWorth.PatientInfo();
                         }
                         count1++;
                          if (pressed == buttonNetWorth && count1 > 1)
                     {
                       JOptionPane.showMessageDialog(null, "Window already opened");
                     }
                              
          }
              
         }
     );
            buttonPanel.add( buttonNetWorth);
          
// event for east button
            
            buttonAddressBookDisplay= new JButton ("Employee Records" );
            buttonAddressBookDisplay.addActionListener(new ActionListener()
        {
           public void actionPerformed (ActionEvent e)
         {

        	   
        	 Object pressed = e.getSource();
        	 if (pressed == buttonAddressBookDisplay && count2 == 0)
                 {
                   new AddressBookDisplay.EmployeesOnFile();
                  
                 }
                 count2 ++;
                 if (pressed == buttonAddressBookDisplay && count2 > 1)
                 {
                      JOptionPane.showMessageDialog(null, "Window already opened");
                 }
           }
         }
            
         );
        buttonPanel.add(buttonAddressBookDisplay);
        
// event for west button
        
        buttonPatients= new JButton ("Patients on File" );
        buttonPatients.addActionListener(new ActionListener()
        {
           public void actionPerformed (ActionEvent e)
         {
        	   
        	Object pressed = e.getSource();
        	if (pressed == buttonPatients && count3 ==0)

             new Patients.PatientInfo();
                count3++;
                if (pressed == buttonPatients && count3 >1)
                     JOptionPane.showMessageDialog(null, "Window already opened");

         }
                }
            
         );
        
           buttonPanel.add(buttonPatients);
           

           
           buttonDoctorsPatients2= new JButton ("Patient Registration" );
           buttonDoctorsPatients2.addActionListener(new ActionListener()
        {
       public void actionPerformed (ActionEvent e)
         {

  Object pressed = e.getSource();
        	if (pressed == buttonDoctorsPatients2 && count4 == 0)
                    new DoctorsPatients2.AddressBookDisplay();
                   count4 ++;
                if (pressed == buttonDoctorsPatients2 && count4 > 1)
                   JOptionPane.showMessageDialog(null, "Window already opened");
         }
        
        }
       
     );
 buttonPanel.add(buttonDoctorsPatients2);
 
 buttonTables= new JButton ("Database" );
 buttonTables.addActionListener(new ActionListener()
      {
     public void actionPerformed (ActionEvent e)
       {
         Object pressed = e.getSource();
         if (pressed == buttonTables && count5 == 0)
             
new ResultSetTable();
      count5 ++;
      
      if (pressed == buttonTables && count5 >1)
           JOptionPane.showMessageDialog(null, "Window already opened");
       }
      
       }
     
   );
 
 // add button
 
buttonPanel.add(buttonTables);
 
// exit button to exit game and interface

exitButton= new JButton ("Exit" );
exitButton.addActionListener(new ActionListener()
        {
       public void actionPerformed (ActionEvent e)
         {

// shut down the whole application

System.exit(0);
         }
       }
     );
// add exitButton to buttonPanel

 buttonPanel.add(exitButton);
 
// add buttonPanel with all attached buttons to container
 
container.add (buttonPanel, BorderLayout.SOUTH);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

// help button to display a message

helpButton= new JButton ("Help" );
helpButton.addActionListener(new ActionListener()
        {
       public void actionPerformed (ActionEvent e)
         {
// display message dialog
    	   
JOptionPane.showMessageDialog(null, "Make appropriate selection to access or edit clinic information");

         
         }
       }
     );
// add button to buttonPanel and then to container

 buttonPanel.add(helpButton);

container.add (buttonPanel, BorderLayout.SOUTH);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      	
 } // end constructor
    
 
    
     public static void main (String args[])
        {
     Interface application = new Interface();
     application.setSize(550,420);
     application.setResizable(false);
     application.setVisible(true);

        }
}





//}
