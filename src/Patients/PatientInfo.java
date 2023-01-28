package Patients;

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
    private JButton updateButton;
 
    private JLabel dateLabel;
    private JTextField dateTextField;
    
    private JLabel prLabel;
    private JTextField prTextField;
    
    private JLabel roomLabel;
    private JTextField roomTextField;
    
   
    
    private JLabel patientIDLabel;
    private JTextField patientIDTextField;
    
    private JLabel firstNameLabel;
    private JTextField firstNameTextField;
    
    private JLabel idLabel;
    private JTextField idTextField;
    
    private JTextField indexTextField;
    
    private JLabel lastNameLabel;
    private JTextField lastNameTextField;
    
    private JLabel addressLabel;
    private JTextField addressTextField;
    
    private JLabel paymentLabel;
    private JTextField paymentTextField;
    
    private JLabel dueLabel;
    private JTextField dueTextField;
    
    private JLabel balanceLabel;
    private JTextField balanceTextField;
    
   
    
    private JTextField maxTextField;
    private JButton nextButton;
    private JLabel ofLabel;
  
    private JButton previousButton;
    private JButton queryButton;
    private JLabel queryLabel;
    private JPanel queryPanel;
    private JPanel navigatePanel;
    private JPanel displayPanel;
    private JTextField queryTextField;
    private JButton insertButton;
    private JButton deleteButton;

    private Image logo;

   
    
    public PatientInfo()
    {
        super ("Patients Records");
        patientQueries = new PatientQueries();
        // create GUI
        navigatePanel = new JPanel();
    
        previousButton = new JButton();
        indexTextField = new JTextField(2);
        ofLabel = new JLabel();
        maxTextField = new JTextField(2);
        nextButton = new JButton();
        displayPanel = new JPanel();
        
        Calendar cal = Calendar.getInstance(TimeZone.getDefault());
    
        String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
        java.text.SimpleDateFormat sdf = 
        new java.text.SimpleDateFormat(DATE_FORMAT);
 
        sdf.setTimeZone(TimeZone.getDefault());          
          
        dateLabel = new JLabel();
        dateTextField = new JTextField(sdf.format(cal.getTime()));
        patientIDLabel = new JLabel();
        patientIDTextField = new JTextField(15);
        idLabel = new JLabel();
        idTextField = new JTextField(15);
        firstNameLabel = new JLabel();
        firstNameTextField = new JTextField(15);
        lastNameLabel = new JLabel();
        lastNameTextField = new JTextField(15);
        addressLabel = new JLabel();
        addressTextField = new JTextField(15);
        paymentLabel = new JLabel();
        paymentTextField = new JTextField(15);
        dueLabel = new JLabel();
        dueTextField = new JTextField(15);
        balanceLabel = new JLabel();
        balanceTextField = new JTextField(15);
        prLabel = new JLabel();
        prTextField = new JTextField(15);
        roomLabel = new JLabel();
        roomTextField = new JTextField(15);
        
        
      
        queryPanel = new JPanel();
        queryLabel = new JLabel();
        queryTextField = new JTextField(14);
        queryButton = new JButton();
        browseButton = new JButton();
        browseButton2 = new JButton();
        browseButton3 = new JButton();
        insertButton = new JButton();
        deleteButton = new JButton();
        updateButton = new JButton();
        
        setLayout (new FlowLayout(FlowLayout.CENTER, 40,40));
        setSize(730,550);
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
    
    displayPanel.setLayout (new GridLayout (6,4,11,10));
    
    idLabel.setText("Patient SS:");
    displayPanel.add (idLabel);
    displayPanel.add(idTextField);
    
    patientIDLabel.setText("Patient ID:");
    displayPanel.add(patientIDLabel);
    displayPanel.add(patientIDTextField);
    
    firstNameLabel.setText("First Name:");
    displayPanel.add(firstNameLabel);
    displayPanel.add(firstNameTextField);
    
    addressLabel.setText("Address:");
    displayPanel.add (addressLabel);
    displayPanel.add(addressTextField);
    
      lastNameLabel.setText ("Last Name:");
    displayPanel.add(lastNameLabel);
    displayPanel.add (lastNameTextField);
    
     prLabel.setText("Procedure:");
    displayPanel.add(prLabel);
    displayPanel.add(prTextField);
    
    paymentLabel.setText("Payment:");
    displayPanel.add(paymentLabel);
    displayPanel.add(paymentTextField);
    
    dateLabel.setText("Date:");
    displayPanel.add(dateLabel);
    displayPanel.add(dateTextField);
    
    dueLabel.setText("Due:");
    displayPanel.add(dueLabel);
    displayPanel.add(dueTextField);
    
    roomLabel.setText("Room:");
    displayPanel.add(roomLabel);
    displayPanel.add(roomTextField);
    
    
    balanceLabel.setText("Balance:");
    displayPanel.add(balanceLabel);
    displayPanel.add(balanceTextField);
    

   
 
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
  
  deleteButton.setText("Delete ");
  deleteButton.addActionListener(
       new ActionListener()
  {
      public void actionPerformed( ActionEvent evt)
      {
          browseButton1ActionPerformed(evt);
      }
   }
  );
  
  add (deleteButton);
  
 
  ////////////////////
  
  queryPanel.add(queryButton);
  queryPanel.add(Box.createHorizontalStrut(13));
  add (queryPanel);
  
  updateButton.setText("Update ");
  updateButton.addActionListener(
       new ActionListener()
  {
      public void actionPerformed( ActionEvent evt)
      {
        insertButton2ActionPerformed(evt);
      }
   }
  );
  
  add (updateButton);
  
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
  
  
  insertButton.setText("Insert New Entry");
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
            paymentTextField.setText(currentEntry.getpayment());
            dueTextField.setText(currentEntry.getdue());
            balanceTextField.setText(currentEntry.getbalance());
            dateTextField.setText(currentEntry.getdate());
            patientIDTextField.setText(currentEntry.getpatientID());
            prTextField.setText(currentEntry.getpr());
            roomTextField.setText(currentEntry.getroom());
           
         
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
            paymentTextField.setText(currentEntry.getpayment());
            dueTextField.setText(currentEntry.getdue());
            balanceTextField.setText(currentEntry.getbalance());
            dateTextField.setText(currentEntry.getdate());
            patientIDTextField.setText(currentEntry.getpatientID());
            prTextField.setText(currentEntry.getpr());
            roomTextField.setText(currentEntry.getroom());
            
           
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
                firstNameTextField.setText (currentEntry.getFirstName());
                lastNameTextField.setText(currentEntry.getLastName());
                addressTextField.setText(currentEntry.getaddress());
                paymentTextField.setText(currentEntry.getpayment());
                dueTextField.setText(currentEntry.getdue());
                balanceTextField.setText(currentEntry.getbalance());
                dateTextField.setText(currentEntry.getdate());
                patientIDTextField.setText(currentEntry.getpatientID());
                prTextField.setText(currentEntry.getpr());
                roomTextField.setText(currentEntry.getroom());
              
               
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
    
      private void browseButton1ActionPerformed(ActionEvent evt)
    {
        try
        {
            results = patientQueries.delete();
            numberOfEntries = results.size();
            
            if (numberOfEntries !=0)
            {
                currentEntryIndex = 0;
                currentEntry = results.get(currentEntryIndex);
                idTextField.setText("" + currentEntry.getAddressID());
                firstNameTextField.setText (currentEntry.getFirstName());
                lastNameTextField.setText(currentEntry.getLastName());
                addressTextField.setText(currentEntry.getaddress());
                paymentTextField.setText(currentEntry.getpayment());
                dueTextField.setText(currentEntry.getdue());
                balanceTextField.setText(currentEntry.getbalance());
                dateTextField.setText(currentEntry.getdate());
                patientIDTextField.setText(currentEntry.getpatientID());
                prTextField.setText(currentEntry.getpr());
                roomTextField.setText(currentEntry.getroom());
                JOptionPane.showMessageDialog (this,"Record Deleted" ,
                "Record with 0 Balance", JOptionPane.PLAIN_MESSAGE);
              
               
                maxTextField.setText("" + numberOfEntries);
                indexTextField.setText("" +(currentEntryIndex + 1));
                nextButton.setEnabled(true);
                previousButton.setEnabled(true);
                
           }
            else
                  JOptionPane.showMessageDialog (this,"Patient not found!" ,
                    "Patient not found", JOptionPane.PLAIN_MESSAGE);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    
    
    
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
                firstNameTextField.setText (currentEntry.getFirstName());
                lastNameTextField.setText(currentEntry.getLastName());
                addressTextField.setText(currentEntry.getaddress());
                paymentTextField.setText(currentEntry.getpayment());
                dueTextField.setText(currentEntry.getdue());
                balanceTextField.setText(currentEntry.getbalance());
                dateTextField.setText(currentEntry.getdate());
                patientIDTextField.setText(currentEntry.getpatientID());
                prTextField.setText(currentEntry.getpr());
                roomTextField.setText(currentEntry.getroom());
             
               
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
                firstNameTextField.setText (currentEntry.getFirstName());
                lastNameTextField.setText(currentEntry.getLastName());
                addressTextField.setText(currentEntry.getaddress());
                paymentTextField.setText(currentEntry.getpayment());
                dueTextField.setText(currentEntry.getdue());
                balanceTextField.setText(currentEntry.getbalance());
                dateTextField.setText(currentEntry.getdate());
                patientIDTextField.setText(currentEntry.getpatientID());
                prTextField.setText(currentEntry.getpr());
                roomTextField.setText(currentEntry.getroom());
          
               
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
     ///////////////////////
       
        private void insertButton2ActionPerformed(ActionEvent evt)
   
        {
            int result = patientQueries.updatePerson(idTextField.getText(), firstNameTextField.getText(),
                    lastNameTextField.getText(), addressTextField.getText(), paymentTextField.getText(), dueTextField.getText(), balanceTextField.getText(), dateTextField.getText(), patientIDTextField.getText(), prTextField.getText(), roomTextField.getText());
            
            if (result == 1)
                    JOptionPane.showMessageDialog (this,"Patient updated!" ,
                    "Patient updated", JOptionPane.PLAIN_MESSAGE);
            else
                JOptionPane.showMessageDialog(this, "Patient not updated!", 
                        "Error", JOptionPane.PLAIN_MESSAGE);
            browseButtonActionPerformed(evt);
            
        }
       
     ///////////////////////
     
  
        private void insertButtonActionPerformed (ActionEvent evt)
        {
            int result = patientQueries.addPatient(idTextField.getText(), firstNameTextField.getText(),
                    lastNameTextField.getText(), addressTextField.getText(), paymentTextField.getText(), dueTextField.getText(), balanceTextField.getText(), dateTextField.getText(), patientIDTextField.getText(),prTextField.getText(), roomTextField.getText());
            
          
            
            if (result == 1)
                    JOptionPane.showMessageDialog (this,"Patient added!" ,
                    "Patient added", JOptionPane.PLAIN_MESSAGE);
            else
                JOptionPane.showMessageDialog(this, "Patient not added!", 
                        "Error", JOptionPane.PLAIN_MESSAGE);
            browseButtonActionPerformed(evt);
            
        }
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
        
    