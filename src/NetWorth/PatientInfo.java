package NetWorth;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Tomek
 */
//PatientInfo.java



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.List;
import javax.swing.JButton;
import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import javax.swing.BoxLayout;
import javax.swing.BorderFactory;




public  class PatientInfo extends JFrame
{
    private Patient currentEntry;
    private PatientQueries patientQueries;
    private List< Patient> results;
    private int numberOfEntries = 0;
    private int currentEntryIndex;
    
    private JLabel netLabel;
    private JTextField netTextField;
    
    private JLabel dueLabel;
    private JTextField dueTextField;
    
    private JLabel due2Label;
    private JTextField due2TextField;
    
    private JLabel idLabel;
    private JTextField idTextField;
    
    private JTextField indexTextField;
    private JTextField maxTextField;
    
    private JLabel paymentLabel;
    private JTextField paymentTextField;
    
    private JLabel dateLabel;
    private JTextField dateTextField;
    

    private JButton nextButton;
    private JButton browseButton;
 
    private JButton queryButton;
    private JLabel ofLabel;
  
    private JButton previousButton;
 
    private JLabel queryLabel;
    private JPanel queryPanel;
    private JPanel navigatePanel;
    private JPanel displayPanel;
    private JTextField queryTextField;



   

   
    
    public PatientInfo()
    {
        super ("Payment Info");
        patientQueries = new PatientQueries();
        // create GUI
        navigatePanel = new JPanel();
       
        previousButton = new JButton();
        indexTextField = new JTextField(2);
        ofLabel = new JLabel();
        maxTextField = new JTextField(2);
        nextButton = new JButton();
        displayPanel = new JPanel();
        
        idLabel = new JLabel();
        idTextField = new JTextField(15);
        
        paymentLabel = new JLabel();
        paymentTextField = new JTextField(15);
       
        netLabel = new JLabel();
        netTextField = new JTextField(15);
        
        dueLabel = new JLabel();
        dueTextField = new JTextField(15);
        
        due2Label = new JLabel();
        due2TextField = new JTextField(15);
        
        dateLabel = new JLabel();
        dateTextField = new JTextField(15);
      
        queryPanel = new JPanel();
        queryLabel = new JLabel();
        queryTextField = new JTextField(15);
       
        browseButton = new JButton();
        queryButton = new JButton();
    
      
       
      
        
        setLayout (new FlowLayout(FlowLayout.CENTER, 25,10));
        setSize(380,590);
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
        navigatePanel.add(Box.createHorizontalStrut(70));
        
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
    navigatePanel.add(Box.createHorizontalStrut(10));
    
    ofLabel.setText("of");
    navigatePanel.add(ofLabel);
    navigatePanel.add(Box.createHorizontalStrut(10));
    
    maxTextField.setHorizontalAlignment(
            JTextField.CENTER);
    maxTextField.setEditable(false);
    navigatePanel.add(maxTextField);
    navigatePanel.add(Box.createHorizontalStrut(10));
    
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
    
    displayPanel.setLayout (new GridLayout (10,2,4,4));
    
    idLabel.setText("Patient ID:");
    displayPanel.add (idLabel);
    displayPanel.add(idTextField);
    
   
    paymentLabel.setText("Paid:");
    displayPanel.add(paymentLabel);
    displayPanel.add(paymentTextField);
    
    dueLabel.setText("Balance:");
    displayPanel.add(dueLabel);
    displayPanel.add(dueTextField);
    
    
    due2Label.setText("Total Due:");
    displayPanel.add(due2Label);
    displayPanel.add(due2TextField);
    
    dateLabel.setText("Date:");
    displayPanel.add(dateLabel);
    displayPanel.add(dateTextField);
    
    netLabel.setText("Net Total:");
    displayPanel.add(netLabel);
    displayPanel.add(netTextField);
 
    add (displayPanel);
    
    //////////////////
  
    queryPanel.setLayout(
            new BoxLayout (queryPanel, BoxLayout.X_AXIS));
    
    
    ////////////////
      queryPanel.setBorder(BorderFactory.createTitledBorder(
            "Find an entry by date"));
    queryLabel.setText ("Date:");
    queryLabel.add (Box.createHorizontalStrut(2));
    queryPanel.add(queryLabel);
    queryPanel.add (Box.createHorizontalStrut(2));
    queryPanel.add (queryTextField);
    queryPanel.add (Box.createHorizontalStrut(2));
    
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
  queryPanel.add(Box.createHorizontalStrut(10));
  add (queryPanel);
    
    
  
  browseButton.setText("Patients Payments ");
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
  /////////////
  
  
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
          paymentTextField.setText(currentEntry.getpayment());
            dateTextField.setText(currentEntry.getdate());
            dueTextField.setText(currentEntry.getdue());
            due2TextField.setText(currentEntry.getdue2());
            netTextField.setText(currentEntry.getnet());
         
            maxTextField.setText("" + numberOfEntries);
            indexTextField.setText("" + (currentEntryIndex + 1));
            nextButton.setEnabled(true);
            previousButton.setEnabled(true);
            
        }
        else
            browseButtonActionPerformed( evt );
        
    }
 
    private void indexTextFieldActionPerformed (ActionEvent evt)
    {
        currentEntryIndex= 
                (Integer.parseInt (indexTextField.getText()) - 1);
        
        if (numberOfEntries != 0 && currentEntryIndex < numberOfEntries)
        {
            currentEntry = results.get(currentEntryIndex);
            idTextField.setText("" + currentEntry.getAddressID());
           
            paymentTextField.setText(currentEntry.getpayment());
            dateTextField.setText(currentEntry.getdate());
            dueTextField.setText(currentEntry.getdue());
            due2TextField.setText(currentEntry.getdue2());
            netTextField.setText(currentEntry.getnet());
           
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
               
                paymentTextField.setText(currentEntry.getpayment());
                 dateTextField.setText(currentEntry.getdate());
                dueTextField.setText(currentEntry.getdue());
                due2TextField.setText(currentEntry.getdue2());
                netTextField.setText(currentEntry.getnet());
               
                maxTextField.setText("" + numberOfEntries);
                indexTextField.setText("" +(currentEntryIndex + 1));
                nextButton.setEnabled(true);
                previousButton.setEnabled(true);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
//////////////////////
  
    
  
    
  public static void main (String args[])
        {
            new PatientInfo();
        }
    }
        
    

