package Payroll;


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Tomek
 */
//EmployeeRecords.java
import java.util.Calendar;
import java.util.TimeZone;
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



public  class EmployeeRecords extends JFrame
{
    private Person currentEntry;
    private PersonQueries personQueries;
    private List< Person> results;
    private int numberOfEntries = 0;
    private int currentEntryIndex;
    private JButton browseButton;
    private JButton browseButtonn;
    private JLabel hoursLabel;
    private JTextField hoursTextField;
    private JLabel firstNameLabel;
    private JTextField firstNameTextField;
    private JLabel overtimeLabel;
    private JTextField overtimeTextField;
    private JLabel idLabel;
    private JTextField idTextField;
    private JTextField indexTextField;
    private JLabel lastNameLabel;
    private JTextField lastNameTextField;
    private JTextField maxTextField;
    private JButton nextButton;
    private JLabel ofLabel;
    private JLabel rateLabel;
    private JTextField rateTextField;
    private JLabel sickLabel;
    private JTextField sickTextField;
    private JLabel vacationLabel;
    private JTextField vacationTextField;
    private JLabel holidaysLabel;
    private JTextField holidaysTextField;
    private JLabel state_taxLabel;
    private JTextField state_taxTextField;
    private JLabel fed_taxLabel;
    private JTextField fed_taxTextField;
    private JLabel KPlanLabel;
    private JTextField KPlanTextField;
    private JLabel InsuranceLabel;
    private JTextField InsuranceTextField;
    private JLabel NetLabel;
    private JTextField NetTextField;
    private JLabel dateLabel;
    private JTextField dateTextField;
    private JLabel grossLabel;
    private JTextField grossTextField;
    private JButton exitButton;
    private JButton previousButton;
    private JButton queryButton;
    private JLabel queryLabel;
    private JPanel queryPanel;
    private JPanel navigatePanel;
    private JPanel displayPanel;
    private JTextField queryTextField;
    private JButton insertButton;
  
    public EmployeeRecords()
    {
        super ("Employee Payroll");
        personQueries = new PersonQueries();
        // create GUI
        navigatePanel = new JPanel();
       
        previousButton = new JButton();
        indexTextField = new JTextField(2);
        ofLabel = new JLabel();
        maxTextField = new JTextField(2);
        nextButton = new JButton();
        displayPanel = new JPanel();
        ////////////////
        
        JButton printButton = new JButton("Print ");
        printButton.addActionListener(new HelloWorldPrinter());
        add("Center", printButton);
        pack();
        setVisible(true);
        
        ///////////////
exitButton= new JButton ("Exit" );
exitButton.addActionListener(new ActionListener()
        {
       public void actionPerformed (ActionEvent e)
         {

// shut down the whole application
setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
//System.exit(0);
         }
       }
     );
     add(exitButton);
  pack();
  setVisible(true);
  
  //////////////
        
        idLabel = new JLabel();
        idTextField = new JTextField(15);
        
        Calendar cal = Calendar.getInstance(TimeZone.getDefault());
    
        String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
        java.text.SimpleDateFormat sdf = 
        new java.text.SimpleDateFormat(DATE_FORMAT);
 
        sdf.setTimeZone(TimeZone.getDefault());          
        
         
        dateLabel = new JLabel();
        dateTextField = new JTextField(sdf.format(cal.getTime()));
       
        firstNameLabel = new JLabel();
        firstNameTextField = new JTextField(15);
        lastNameLabel = new JLabel();
        lastNameTextField = new JTextField(15);
        
        hoursLabel= new JLabel();
        hoursTextField = new JTextField(15);
        overtimeLabel = new JLabel();
        overtimeTextField = new JTextField(15);
        rateLabel = new JLabel();
        rateTextField = new JTextField(15);
        sickLabel = new JLabel();
        sickTextField = new JTextField(15);
        vacationLabel = new JLabel();
        vacationTextField = new JTextField(15);
        holidaysLabel = new JLabel();
        holidaysTextField = new JTextField(15);
        state_taxLabel = new JLabel();
        state_taxTextField = new JTextField(15);
        fed_taxLabel = new JLabel();
        fed_taxTextField = new JTextField(15);
        KPlanLabel = new JLabel();
        KPlanTextField = new JTextField(15);
        InsuranceLabel = new JLabel();
        InsuranceTextField = new JTextField(15);
        grossLabel = new JLabel();
        grossTextField = new JTextField(15);
        NetLabel = new JLabel();
        NetTextField = new JTextField(15);
        queryPanel = new JPanel();
        queryLabel = new JLabel();
        queryTextField = new JTextField(15);
        queryButton = new JButton();
        browseButton = new JButton();
        browseButtonn = new JButton();
        insertButton = new JButton();
        
        setLayout (new FlowLayout(FlowLayout.CENTER, 48,46));
        setSize(730,600);
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
        navigatePanel.add(Box.createHorizontalStrut(90));
        
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
    
    displayPanel.setLayout (new GridLayout (8,8,12,13));
    
    idLabel.setText("SS #:");
    displayPanel.add (idLabel);
    displayPanel.add(idTextField);
    
    vacationLabel.setText("Vacation:");
    displayPanel.add(vacationLabel);
    displayPanel.add(vacationTextField);
    
    firstNameLabel.setText("First Name:");
    displayPanel.add(firstNameLabel);
    displayPanel.add(firstNameTextField);
    
    holidaysLabel.setText("Holidays:");
    displayPanel.add(holidaysLabel);
    displayPanel.add(holidaysTextField);
    
    lastNameLabel.setText ("Last Name:");
    displayPanel.add(lastNameLabel);
    displayPanel.add (lastNameTextField);
    
    grossLabel.setText("Gross Total:");
    displayPanel.add(grossLabel);
    displayPanel.add(grossTextField);
 
    hoursLabel.setText("Hours:");
    displayPanel.add (hoursLabel);
    displayPanel.add(hoursTextField);
    
  
    fed_taxLabel.setText("Federal Tax:");
    displayPanel.add(fed_taxLabel);
    displayPanel.add(fed_taxTextField);
   
   
    overtimeLabel.setText("Overtime:");
    displayPanel.add(overtimeLabel);
    displayPanel.add(overtimeTextField);
    
    state_taxLabel.setText("State Tax:");
    displayPanel.add(state_taxLabel);
    displayPanel.add(state_taxTextField);
  
    rateLabel.setText("Rate:");
    displayPanel.add(rateLabel);
    displayPanel.add(rateTextField);
    
    InsuranceLabel.setText("Insurance:");
    displayPanel.add(InsuranceLabel);
    displayPanel.add(InsuranceTextField);
    
    
    sickLabel.setText("Sick:");
    displayPanel.add(sickLabel);
    displayPanel.add(sickTextField);
    
    KPlanLabel.setText("401 K:");
    displayPanel.add(KPlanLabel);
    displayPanel.add(KPlanTextField);
    
    dateLabel.setText ("Date:");
    displayPanel.add(dateLabel);
    displayPanel.add (dateTextField);
    
    NetLabel.setText("Net:");
    displayPanel.add(NetLabel);
    displayPanel.add(NetTextField);
    
    
   
    
    
   
    
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
  queryPanel.add(Box.createHorizontalStrut(230));
  add (queryPanel);
  
  browseButton.setText("Browse All Full Time Employees ");
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
  //////////
   browseButtonn.setText("Browse All Part Time Employees ");
  browseButtonn.addActionListener(
       new ActionListener()
  {
      public void actionPerformed( ActionEvent evt)
      {
          browseButtonActionPerformed2(evt);
      }
   }
  );
  
  add (browseButtonn);
  
  
  //////////
  
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
            idTextField.setText("" + currentEntry.getAddressID());
            firstNameTextField.setText(currentEntry.getFirstName());
            lastNameTextField.setText(currentEntry.getLastName());
            hoursTextField.setText(currentEntry.getHours());
            overtimeTextField.setText(currentEntry.getOvertime());
            rateTextField.setText(currentEntry.getRate());
            sickTextField.setText(currentEntry.getSick());
            vacationTextField.setText(currentEntry.getVacation());
            holidaysTextField.setText(currentEntry.getHolidays());
            grossTextField.setText(currentEntry.getgross());
            state_taxTextField.setText(currentEntry.getStateTax());
            fed_taxTextField.setText(currentEntry.getFedTax());
            KPlanTextField.setText(currentEntry.getKPlan());
            InsuranceTextField.setText(currentEntry.getInsurance());
            NetTextField.setText(currentEntry.getNet());
            dateTextField.setText(currentEntry.getDate());
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
            idTextField.setText("" + currentEntry.getAddressID());
            firstNameTextField.setText(currentEntry.getFirstName());
            lastNameTextField.setText(currentEntry.getLastName());
            hoursTextField.setText(currentEntry.getHours());
            overtimeTextField.setText(currentEntry.getOvertime());
            rateTextField.setText(currentEntry.getRate());
            sickTextField.setText(currentEntry.getSick());
            vacationTextField.setText(currentEntry.getVacation());
            holidaysTextField.setText(currentEntry.getHolidays());
            grossTextField.setText(currentEntry.getgross());
            state_taxTextField.setText(currentEntry.getStateTax());
            fed_taxTextField.setText(currentEntry.getFedTax());
            KPlanTextField.setText(currentEntry.getKPlan());
            InsuranceTextField.setText(currentEntry.getInsurance());
            NetTextField.setText(currentEntry.getNet());
            dateTextField.setText(currentEntry.getDate());
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
                idTextField.setText("" + currentEntry.getAddressID());
            firstNameTextField.setText(currentEntry.getFirstName());
            lastNameTextField.setText(currentEntry.getLastName());
            hoursTextField.setText(currentEntry.getHours());
            overtimeTextField.setText(currentEntry.getOvertime());
            rateTextField.setText(currentEntry.getRate());
            sickTextField.setText(currentEntry.getSick());
            vacationTextField.setText(currentEntry.getVacation());
            holidaysTextField.setText(currentEntry.getHolidays());
            grossTextField.setText(currentEntry.getgross());
            state_taxTextField.setText(currentEntry.getStateTax());
            fed_taxTextField.setText(currentEntry.getFedTax());
            KPlanTextField.setText(currentEntry.getKPlan());
            InsuranceTextField.setText(currentEntry.getInsurance());
            NetTextField.setText(currentEntry.getNet());
            dateTextField.setText(currentEntry.getDate());
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
    
    /////////////////
     private void browseButtonActionPerformed2(ActionEvent evt)
    {
        try
        {
            results = personQueries.getAllPeople2();
            numberOfEntries = results.size();
            
            if (numberOfEntries !=0)
            {
                currentEntryIndex = 0;
                currentEntry = results.get(currentEntryIndex);
                idTextField.setText("" + currentEntry.getAddressID());
            firstNameTextField.setText(currentEntry.getFirstName());
            lastNameTextField.setText(currentEntry.getLastName());
            hoursTextField.setText(currentEntry.getHours());
            overtimeTextField.setText(currentEntry.getOvertime());
            rateTextField.setText(currentEntry.getRate());
            sickTextField.setText(currentEntry.getSick());
            vacationTextField.setText(currentEntry.getVacation());
            holidaysTextField.setText(currentEntry.getHolidays());
            grossTextField.setText(currentEntry.getgross());
            state_taxTextField.setText(currentEntry.getStateTax());
            fed_taxTextField.setText(currentEntry.getFedTax());
            KPlanTextField.setText(currentEntry.getKPlan());
            InsuranceTextField.setText(currentEntry.getInsurance());
            NetTextField.setText(currentEntry.getNet());
            dateTextField.setText(currentEntry.getDate());
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
    
    
    
    /////////////////
        private void insertButtonActionPerformed (ActionEvent evt)
        {
            int result = personQueries.addPerson( idTextField.getText(),firstNameTextField.getText(),
                    lastNameTextField.getText(), hoursTextField.getText(),
                    overtimeTextField.getText(), rateTextField.getText(),sickTextField.getText(),vacationTextField.getText(),holidaysTextField.getText(), grossTextField.getText(),state_taxTextField.getText(),fed_taxTextField.getText(),KPlanTextField.getText(),InsuranceTextField.getText(),NetTextField.getText(), dateTextField.getText());
            
            if (result == 1)
                    JOptionPane.showMessageDialog (this,"Person added!" ,
                    "Person added", JOptionPane.PLAIN_MESSAGE);
            else
                JOptionPane.showMessageDialog(this, "Person not added!", 
                        "Error", JOptionPane.PLAIN_MESSAGE);
            browseButtonActionPerformed(evt);
            
        }
        public static void main (String args[])
        {
    
        JFrame f = new JFrame("Hello World Printer");
        f.addWindowListener(new WindowAdapter() {
           public void windowClosing(WindowEvent e) {System.exit(0);}
        });
         new EmployeeRecords();
       
        
         
         
         
         Calendar cal = Calendar.getInstance(TimeZone.getDefault());
    
         String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
         java.text.SimpleDateFormat sdf = 
          new java.text.SimpleDateFormat(DATE_FORMAT);
 
         sdf.setTimeZone(TimeZone.getDefault());          
          
        System.out.println("" + sdf.format(cal.getTime())); 
        }
    }
        
    