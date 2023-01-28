package DoctorsPatients2;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Tomek
 */
//AddressBookDisplay.java

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
import javax.swing.JOptionPane;



public  class AddressBookDisplay extends JFrame
{
    private Person currentEntry;
    private PersonQueries personQueries;
    private List< Person> results;
    private int numberOfEntries = 0;
    private int currentEntryIndex;
    
    private JButton browseButton;
  
    private JLabel dfirstNameLabel;
    private JTextField dfirstNameTextField;
    
    private JLabel dlastNameLabel;
    private JTextField dlastNameTextField;
    
    private JLabel phoneLabel;
    private JTextField phoneTextField;
    
    private JLabel firstName2Label;
    private JTextField firstName2TextField;
    
    private JLabel lastName2Label;
    private JTextField lastName2TextField;
    
    private JLabel dateLabel;
    private JTextField dateTextField;
    
    private JLabel patientIDLabel;
    private JTextField patientIDTextField;
    
    private JLabel prLabel;
    private JTextField prTextField;
    
    private JLabel roomLabel;
    private JTextField roomTextField;
  
    private JTextField indexTextField;
    
    
    
    
    
    
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
  
    public AddressBookDisplay()
    {
        super ("Scheduling");
        personQueries = new PersonQueries();
        // create GUI
        navigatePanel = new JPanel();
       
        previousButton = new JButton();
        indexTextField = new JTextField(2);
        ofLabel = new JLabel();
        maxTextField = new JTextField(2);
        nextButton = new JButton();
        displayPanel = new JPanel();
        
        dfirstNameLabel = new JLabel();
        dfirstNameTextField = new JTextField(15);
        
        dlastNameLabel = new JLabel();
        dlastNameTextField = new JTextField(15);
        
        phoneLabel = new JLabel();
        phoneTextField = new JTextField(15);
        
        firstName2Label = new JLabel();
        firstName2TextField = new JTextField(15);
        lastName2Label = new JLabel();
        lastName2TextField = new JTextField(15);
        
        dateLabel = new JLabel();
        dateTextField = new JTextField(15);
       
        
        patientIDLabel = new JLabel();
        patientIDTextField = new JTextField(15);
        
        prLabel = new JLabel();
        prTextField = new JTextField(15);
        
        roomLabel = new JLabel();
        roomTextField = new JTextField(15);
      
        
        queryPanel = new JPanel();
        queryLabel = new JLabel();
        queryTextField = new JTextField(15);
        queryButton = new JButton();
        browseButton = new JButton();
        insertButton = new JButton();
        
        setLayout (new FlowLayout(FlowLayout.CENTER, 42,40));
        setSize(475,570);
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
    
    dfirstNameLabel.setText("Doctor's First Name:");
    displayPanel.add(dfirstNameLabel);
    displayPanel.add(dfirstNameTextField);
    
    dlastNameLabel.setText ("Doctor's Last Name:");
    displayPanel.add(dlastNameLabel);
    displayPanel.add (dlastNameTextField);
    
    phoneLabel.setText("Doctor's Phone:");
    displayPanel.add(phoneLabel);
    displayPanel.add(phoneTextField);
    
    firstName2Label.setText("Patient's First Name:");
    displayPanel.add(firstName2Label);
    displayPanel.add(firstName2TextField);
    
    lastName2Label.setText ("Patient's Last Name:");
    displayPanel.add(lastName2Label);
    displayPanel.add (lastName2TextField);
    
    dateLabel.setText ("Registration Date:");
    displayPanel.add(dateLabel);
    displayPanel.add (dateTextField);
    
    patientIDLabel.setText("Doctor's ID:");
    displayPanel.add(patientIDLabel);
    displayPanel.add(patientIDTextField);
    
    prLabel.setText("Procedures:");
    displayPanel.add(prLabel);
    displayPanel.add(prTextField);
    
    roomLabel.setText("Room:");
    displayPanel.add(roomLabel);
    displayPanel.add(roomTextField);
    
   
    
    add (displayPanel);
    
    queryPanel.setLayout(
            new BoxLayout (queryPanel, BoxLayout.X_AXIS));
    
    queryPanel.setBorder(BorderFactory.createTitledBorder(
            "Find registration by Doctor's last name"));
    queryLabel.setText ("Last Name:");
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
  queryPanel.add(Box.createHorizontalStrut(6));
  add (queryPanel);
  
  browseButton.setText("Browse All Entries ");
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
  
 
   
   addWindowListener(
           new WindowAdapter()
   {
       public void windowClosing( WindowEvent evt)
       {
           personQueries.close();
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
                personQueries.getPeopleByLastName(queryTextField.getText());
        numberOfEntries = results.size();
        
        if (numberOfEntries !=0)
        {
            currentEntryIndex = 0;
            currentEntry = results.get(currentEntryIndex);
            
            dfirstNameTextField.setText(currentEntry.getdFirstName());
            dlastNameTextField.setText(currentEntry.getdLastName());
            
            phoneTextField.setText(currentEntry.getPhoneNumber());
           
            firstName2TextField.setText(currentEntry.getFirstName2());
            lastName2TextField.setText(currentEntry.getLastName2());
            dateTextField.setText(currentEntry.getDate());
           patientIDTextField.setText(currentEntry.getpatientID());
           
            maxTextField.setText("" + numberOfEntries);
            indexTextField.setText("" + (currentEntryIndex + 1));
            nextButton.setEnabled(true);
            previousButton.setEnabled(true);
            
        }
        else
           
                JOptionPane.showMessageDialog (this,"Person not found!" ,
                    "Person not found", JOptionPane.PLAIN_MESSAGE);
           
        
    }
    private void indexTextFieldActionPerformed (ActionEvent evt)
    {
        currentEntryIndex= 
                (Integer.parseInt (indexTextField.getText()) - 1);
        
        if (numberOfEntries != 0 && currentEntryIndex < numberOfEntries)
        {
            currentEntry = results.get(currentEntryIndex);
            
            dfirstNameTextField.setText(currentEntry.getdFirstName());
            dlastNameTextField.setText(currentEntry.getdLastName());
            
            phoneTextField.setText(currentEntry.getPhoneNumber());
           
            firstName2TextField.setText(currentEntry.getFirstName2());
            lastName2TextField.setText(currentEntry.getLastName2());
            dateTextField.setText(currentEntry.getDate());
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
            results = personQueries.getAllPeople();
            numberOfEntries = results.size();
            
            if (numberOfEntries !=0)
            {
                currentEntryIndex = 0;
                currentEntry = results.get(currentEntryIndex);
                
            dfirstNameTextField.setText(currentEntry.getdFirstName());
            dlastNameTextField.setText(currentEntry.getdLastName());
            
            phoneTextField.setText(currentEntry.getPhoneNumber());
           
            firstName2TextField.setText(currentEntry.getFirstName2());
            lastName2TextField.setText(currentEntry.getLastName2());
            dateTextField.setText(currentEntry.getDate());
            patientIDTextField.setText(currentEntry.getpatientID());
            prTextField.setText(currentEntry.getpr());
            roomTextField.setText(currentEntry.getroom());
                
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
       
        public static void main (String args[])
        {
            new AddressBookDisplay();
        }
    }
        
    