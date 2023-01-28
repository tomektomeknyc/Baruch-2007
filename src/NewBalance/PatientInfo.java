package NewBalance;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Tomek
 */
//PatientInfo.java


import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;
import javax.swing.JButton;
import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.BoxLayout;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;



public  class PatientInfo extends JFrame
{
    private Patient currentEntry;
    private PatientQueries patientQueries;
    private List< Patient> results;
    private int numberOfEntries = 0;
    private int currentEntryIndex;
    
    private JButton browseButton;
    private JButton browseButton2;
    private JButton browseButton3;
    private JButton insertButton;
 
    private JLabel newdateLabel;
    private JTextField newdateTextField;
    
    private JLabel firstNameLabel;
    private JTextField firstNameTextField;
    
    private JLabel idLabel;
    private JTextField idTextField;
    
    private JTextField indexTextField;
    
    private JLabel lastNameLabel;
    private JTextField lastNameTextField;
    
    private JLabel addressLabel;
    private JTextField addressTextField;
    
    private JLabel newpaymentLabel;
    private JTextField newpaymentTextField;
    
    
    
    private JLabel newbalanceLabel;
    private JTextField newbalanceTextField;
    
  
   
    
    private JTextField maxTextField;
    private JButton nextButton;
    private JButton updateButton;
    private JLabel ofLabel;
  
    private JButton previousButton;
    private JButton queryButton;
    private JLabel queryLabel;
    private JPanel queryPanel;
    private JPanel navigatePanel;
    private JPanel displayPanel;
    private JTextField queryTextField;
 
   

    private Image logo;

    private JTextField balanceTextField;

    private JLabel balanceLabel;

   
    
    public PatientInfo()
    {
        super ("Patient Balance Updates");
        patientQueries = new PatientQueries();
        // create GUI
        navigatePanel = new JPanel();
    
        previousButton = new JButton();
        indexTextField = new JTextField(2);
        ofLabel = new JLabel();
        maxTextField = new JTextField(2);
        nextButton = new JButton();
        updateButton = new JButton();
        displayPanel = new JPanel();
        
        Calendar cal = Calendar.getInstance(TimeZone.getDefault());
    
        String DATE_FORMAT = "yyyy-MM-dd   HH:mm:ss";
        java.text.SimpleDateFormat sdf = 
        new java.text.SimpleDateFormat(DATE_FORMAT);
 
        sdf.setTimeZone(TimeZone.getDefault());          
          
       
       
        idLabel = new JLabel();
        idTextField = new JTextField(18);
        
        firstNameLabel = new JLabel();
        firstNameTextField = new JTextField(18);
        
        lastNameLabel = new JLabel();
        lastNameTextField = new JTextField(18);
        
        addressLabel = new JLabel();
        addressTextField = new JTextField(18);
        
        balanceLabel = new JLabel();
        balanceTextField = new JTextField(18);
        
        newpaymentLabel = new JLabel();
        newpaymentTextField = new JTextField(18);
       
        newbalanceLabel = new JLabel();
        newbalanceTextField = new JTextField(18);
        
        newdateLabel = new JLabel();
        newdateTextField = new JTextField(sdf.format(cal.getTime()));
     
      
        
        
        
      
        queryPanel = new JPanel();
        queryLabel = new JLabel();
        queryTextField = new JTextField(14);
        queryButton = new JButton();
        browseButton = new JButton();
        browseButton2 = new JButton();
        browseButton3 = new JButton();
        insertButton = new JButton();
       
        
        setLayout (new FlowLayout(FlowLayout.CENTER, 40,40));
        setSize(530,620);
        setResizable(false);
    
        navigatePanel.setLayout(
                new BoxLayout (navigatePanel, BoxLayout.X_AXIS));
        previousButton.setText("Previous");
        previousButton.setEnabled(false);
        previousButton.addActionListener(
                new ActionListener()
        {
            public void actionPerformed(ActionEvent evt)
            {
                previousButtonActionPerformed(evt);
            
            }
        }
        );
        navigatePanel.add(previousButton);
        navigatePanel.add(Box.createHorizontalStrut(0));
        
        indexTextField.setHorizontalAlignment(
                JTextField.CENTER );
        indexTextField.addActionListener(
                new ActionListener()
        {
            public void actionPerformed (ActionEvent evt)
            {
                indexTextFieldActionPerformed(evt);
            }
        }
    );
    
    navigatePanel.add(indexTextField);
    navigatePanel.add(Box.createHorizontalStrut(30));
    
    ofLabel.setText("of");
    navigatePanel.add(ofLabel);
    navigatePanel.add(Box.createHorizontalStrut(30));
    
    maxTextField.setHorizontalAlignment(
            JTextField.CENTER);
    maxTextField.setEditable(false);
    navigatePanel.add(maxTextField);
    navigatePanel.add(Box.createHorizontalStrut(30));
    
    nextButton.setText("Next");
    nextButton.setEnabled(false);
    nextButton.addActionListener(
            new ActionListener()
    {
        public void actionPerformed(ActionEvent evt)
        {
            nextButtonActionPerformed (evt);
            
        }
     }
    
   );
    
    navigatePanel.add(nextButton);
    add(navigatePanel);
    
    displayPanel.setLayout (new GridLayout (8,9,11,10));
    
    idLabel.setText("Patient SS:");
    displayPanel.add (idLabel);
    displayPanel.add(idTextField);
    
   
    
    firstNameLabel.setText("First Name:");
    displayPanel.add(firstNameLabel);
    displayPanel.add(firstNameTextField);
    
    lastNameLabel.setText ("Last Name:");
    displayPanel.add(lastNameLabel);
    displayPanel.add (lastNameTextField);
    
    
    addressLabel.setText("Address:");
    displayPanel.add (addressLabel);
    displayPanel.add(addressTextField);
    

    balanceLabel.setText("Current Balance:");
    displayPanel.add(balanceLabel);
    displayPanel.add(balanceTextField);
    
   
    
    newpaymentLabel.setText("New Payment:");
    displayPanel.add(newpaymentLabel);
    displayPanel.add(newpaymentTextField);
    
    newdateLabel.setText("Date:");
    displayPanel.add(newdateLabel);
    displayPanel.add(newdateTextField);
   
    
 
    newbalanceLabel.setText("Updated Balance:");
    displayPanel.add(newbalanceLabel);
    displayPanel.add(newbalanceTextField);
    

   
 
    add (displayPanel);
    
    queryPanel.setLayout(
            new BoxLayout (queryPanel, BoxLayout.X_AXIS));
    
    queryPanel.setBorder(BorderFactory.createTitledBorder(
            "Find an entry by last name"));
    queryLabel.setText ("Last Name:");
    queryLabel.add (Box.createHorizontalStrut(5));
    queryPanel.add(queryLabel);
    queryPanel.add (Box.createHorizontalStrut(5));
    queryPanel.add (queryTextField);
    queryPanel.add (Box.createHorizontalStrut(5));
    
    queryButton.setText ("Find");
    queryButton.addActionListener(
            new ActionListener()
    {
        public void actionPerformed (ActionEvent evt)
        {
            queryButtonActionPerformed(evt);
            
        }
    }
  );
  
  
  queryPanel.add(queryButton);
  queryPanel.add(Box.createHorizontalStrut(13));
  add (queryPanel);
  
  browseButton.setText("Balance Paid ");
  browseButton.addActionListener(
       new ActionListener()
  {
      public void actionPerformed( ActionEvent evt)
      {
          browseButtonActionPerformed(evt);
      }
   }
  );
  
  add (browseButton);
  
  ///////////////////////
  
   queryPanel.add(queryButton);
  queryPanel.add(Box.createHorizontalStrut(13));
  add (queryPanel);
  

  
 
  ////////////////////
  
  queryPanel.add(queryButton);
  queryPanel.add(Box.createHorizontalStrut(13));
  add (queryPanel);
  
  
  
  ///////////////////
    queryPanel.add(queryButton);
  queryPanel.add(Box.createHorizontalStrut(13));
  add (queryPanel);
  
  browseButton2.setText("Balance Unpaid ");
  browseButton2.addActionListener(
       new ActionListener()
  {
      public void actionPerformed( ActionEvent evt)
      {
          browseButton2ActionPerformed(evt);
      }
   }
  
  );
  
  add (browseButton2);
///////////////////////////  
  
  
  queryPanel.add(queryButton);
  queryPanel.add(Box.createHorizontalStrut(13));
  add (queryPanel);
  
  insertButton.setText("Insert New Payment");
  insertButton.addActionListener(
          new ActionListener()
  {
      public void actionPerformed (ActionEvent evt)
      {
          insertButtonActionPerformed(evt);
      }
  }
   );
   
   add(insertButton);
   
   addWindowListener(
           new WindowAdapter()
   {
       public void windowClosing( WindowEvent evt)
       {
           patientQueries.close();
           System.exit(0);
       }
   }
 );
 
 setVisible(true);
 
  /////////////////
   queryPanel.add(queryButton);
  queryPanel.add(Box.createHorizontalStrut(13));
  add (queryPanel);
  
  browseButton3.setText("Select All Patients ");
  browseButton3.addActionListener(
       new ActionListener()
  {
      public void actionPerformed( ActionEvent evt)
      {
          browseButton3ActionPerformed(evt);
      }
   }
  );
  
  add (browseButton3);
  
  

   
   addWindowListener(
           new WindowAdapter()
   {
       public void windowClosing( WindowEvent evt)
       {
           patientQueries.close();
           System.exit(0);
       }
   }
 );
 
 setVisible(true);
 
 }  // end no argument constructor
    
    // handles call when previousButton is clicked
    
    private void previousButtonActionPerformed (ActionEvent evt)
    {
        currentEntryIndex--;
        
        if (currentEntryIndex < 0)
            currentEntryIndex = numberOfEntries - 1;
        indexTextField.setText("" + (currentEntryIndex + 1 ));
        indexTextFieldActionPerformed (evt);
    }
    // handles call when nextButton is clicked
    private void nextButtonActionPerformed (ActionEvent evt)
    {
        currentEntryIndex++;
        if (currentEntryIndex >= numberOfEntries)
            currentEntryIndex = 0;
        indexTextField.setText("" + (currentEntryIndex +1));
        indexTextFieldActionPerformed( evt );
        
    }
    private  void queryButtonActionPerformed (ActionEvent evt)
    {
        results =
                patientQueries.getPeopleByLastName(queryTextField.getText());
        numberOfEntries = results.size();
        
        if (numberOfEntries !=0)
        {
            currentEntryIndex = 0;
            currentEntry = results.get(currentEntryIndex);
            idTextField.setText("" + currentEntry.getAddressID());
            firstNameTextField.setText(currentEntry.getFirstName());
            lastNameTextField.setText(currentEntry.getLastName());
            addressTextField.setText(currentEntry.getaddress());
            balanceTextField.setText(currentEntry.getbalance());
           
            newpaymentTextField.setText(currentEntry.getnewpayment());
           
            newbalanceTextField.setText(currentEntry.getnewbalance());
           
          
          
           
            
           
         
            maxTextField.setText("" + numberOfEntries);
            indexTextField.setText("" + (currentEntryIndex + 1));
            nextButton.setEnabled(true);
            previousButton.setEnabled(true);
            
        }
        else
            JOptionPane.showMessageDialog (this,"Patient not found!" ,
                    "Patient not found", JOptionPane.PLAIN_MESSAGE);
        
    }
    private void indexTextFieldActionPerformed (ActionEvent evt)
    {
        currentEntryIndex= 
                (Integer.parseInt (indexTextField.getText()) - 1);
        
        if (numberOfEntries != 0 && currentEntryIndex < numberOfEntries)
        {
            currentEntry = results.get(currentEntryIndex);
           idTextField.setText("" + currentEntry.getAddressID());
            firstNameTextField.setText(currentEntry.getFirstName());
            lastNameTextField.setText(currentEntry.getLastName());
            addressTextField.setText(currentEntry.getaddress());
             balanceTextField.setText(currentEntry.getbalance());
             
              newpaymentTextField.setText(currentEntry.getnewpayment());
              
            newbalanceTextField.setText(currentEntry.getnewbalance());
          
            
           
            maxTextField.setText("" + numberOfEntries);
            indexTextField.setText ("" + (currentEntryIndex + 1 ));
            
            
        }
    }
    
    private void browseButtonActionPerformed(ActionEvent evt)
    {
        try
        {
            results = patientQueries.getAllPeople();
            numberOfEntries = results.size();
            
            if (numberOfEntries !=0)
            {
                currentEntryIndex = 0;
                currentEntry = results.get(currentEntryIndex);
                idTextField.setText("" + currentEntry.getAddressID());
            firstNameTextField.setText(currentEntry.getFirstName());
            lastNameTextField.setText(currentEntry.getLastName());
            addressTextField.setText(currentEntry.getaddress());
             balanceTextField.setText(currentEntry.getbalance());
            
              newpaymentTextField.setText(currentEntry.getnewpayment());
              
            newbalanceTextField.setText(currentEntry.getnewbalance());
       
              
               
                maxTextField.setText("" + numberOfEntries);
                indexTextField.setText("" +(currentEntryIndex + 1));
                nextButton.setEnabled(true);
                previousButton.setEnabled(true);
            }
            else
                  JOptionPane.showMessageDialog (this,"Paid balance not found!" ,
                    "Patient not found", JOptionPane.PLAIN_MESSAGE);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
 
             
    }
    //////////////////////////
    
   
    
    
    
    /////////////////////////
   
     private void browseButton2ActionPerformed(ActionEvent evt)
    {
        try
        {
            results = patientQueries.getAllPeople2();
            numberOfEntries = results.size();
            
            if (numberOfEntries !=0)
            {
                currentEntryIndex = 0;
                currentEntry = results.get(currentEntryIndex);
                
                idTextField.setText("" + currentEntry.getAddressID());
            firstNameTextField.setText(currentEntry.getFirstName());
            lastNameTextField.setText(currentEntry.getLastName());
            addressTextField.setText(currentEntry.getaddress());
             balanceTextField.setText(currentEntry.getbalance());
             
              newpaymentTextField.setText(currentEntry.getnewpayment());
               
            newbalanceTextField.setText(currentEntry.getnewbalance());
       
             
               
                maxTextField.setText("" + numberOfEntries);
                indexTextField.setText("" +(currentEntryIndex + 1));
                nextButton.setEnabled(true);
                previousButton.setEnabled(true);
            }
            else
                  JOptionPane.showMessageDialog (this,"Unpaid Balance Not Found!" ,
                    "All Balances Paid", JOptionPane.PLAIN_MESSAGE);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    ///////////////
     
       private void browseButton3ActionPerformed(ActionEvent evt)
    {
        try
        {
            results = patientQueries.getAllPeople3();
            numberOfEntries = results.size();
            
            if (numberOfEntries !=0)
            {
                currentEntryIndex = 0;
                currentEntry = results.get(currentEntryIndex);
                
            idTextField.setText("" + currentEntry.getAddressID());
            firstNameTextField.setText(currentEntry.getFirstName());
            lastNameTextField.setText(currentEntry.getLastName());
            addressTextField.setText(currentEntry.getaddress());
            balanceTextField.setText(currentEntry.getbalance());
       
            newpaymentTextField.setText(currentEntry.getnewpayment());
          
            newbalanceTextField.setText(currentEntry.getnewbalance());
           
          
               
                maxTextField.setText("" + numberOfEntries);
                indexTextField.setText("" +(currentEntryIndex + 1));
                nextButton.setEnabled(true);
                previousButton.setEnabled(true);
            }
            else
                  JOptionPane.showMessageDialog (this,"Patient Not Found!" ,
                    "Patient Not Found", JOptionPane.PLAIN_MESSAGE);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
       
        private void insertButtonActionPerformed (ActionEvent evt)
        {
            int result = patientQueries.addPatient(idTextField.getText(), newpaymentTextField.getText(), newdateTextField.getText());
            
          
            
            if (result == 1)
                    JOptionPane.showMessageDialog (this,"Payment received!" ,
                    "Patient added", JOptionPane.PLAIN_MESSAGE);
            else
                JOptionPane.showMessageDialog(this, "Payment not received!", 
                        "Error", JOptionPane.PLAIN_MESSAGE);
            browseButtonActionPerformed(evt);
            
        }
     ///////////////////////
       
     
        public static void main (String args[])
        {
            new PatientInfo();
            Calendar cal = Calendar.getInstance(TimeZone.getDefault());
    
    String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    java.text.SimpleDateFormat sdf = 
          new java.text.SimpleDateFormat(DATE_FORMAT);
 
    sdf.setTimeZone(TimeZone.getDefault());          
          
    System.out.println("" + sdf.format(cal.getTime())); 
            
        }
    }
        
    
