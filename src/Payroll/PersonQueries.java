package Payroll;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Tomek
 */
// PersonQueries.java

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

public class PersonQueries
{
    private static final String URL = "jdbc:odbc:AddressBook";
    private static final String USERNAME = "sa";
    private static final String PASSWORD = "sarah1";
 
    
    private Connection connection = null;
    private PreparedStatement selectAllPeople = null;
    private PreparedStatement selectPeopleByLastName = null;
    private PreparedStatement insertNewPerson = null;
    private PreparedStatement selectPartTime = null;
   
    
    public PersonQueries()
    {
        try
        {
            try {
                Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        
     
           connection = 
                   DriverManager.getConnection(URL, USERNAME, PASSWORD);
           selectPartTime = 
                   connection.prepareStatement (" SELECT Employees.addressID, Employees.firstName1, Employees.lastName1 , HoursWorked, Overtime, EmployeeRate, SickPay, Vacation, Holiday , HoursWorked * EmployeeRate As Gross, 0.12 * HoursWorked * EmployeeRate As StateTax, HoursWorked * EmployeeRate * .3 As FederalTax, KPlan, Insurance,EmployeeRate * HoursWorked  - 0.12 * HoursWorked * EmployeeRate -  HoursWorked * EmployeeRate * .3 - KPlan - Insurance  As Net, date FROM Payroll INNER JOIN Employees ON Employees.addressID = Payroll.addressID  WHERE HoursWorked < 40");
            
           selectAllPeople =
                   connection.prepareStatement ("SELECT Employees.addressID, Employees.firstName1, Employees.lastName1 , HoursWorked,  HoursWorked - 40 As Overtime , EmployeeRate, SickPay, Vacation, Holiday , (40 * EmployeeRate) + (HoursWorked - 40) * EmployeeRate * 1.5 As Gross  ,  0.12 * HoursWorked * EmployeeRate As StateTax, HoursWorked * EmployeeRate * .3 As FederalTax, KPlan, Insurance, 40 * EmployeeRate + (HoursWorked - 40) * 1.5 * EmployeeRate - 0.12 * HoursWorked * EmployeeRate -  HoursWorked * EmployeeRate * .3 - KPlan - Insurance  As Net, date  FROM Payroll INNER JOIN Employees ON Employees.addressID = Payroll.addressID  WHERE HoursWorked >= 40 ");
                 
            selectPeopleByLastName = connection.prepareStatement(
                    "SELECT Employees.addressID, Employees.firstName1, Employees.lastName1, HoursWorked, HoursWorked - 40 As Overtime , EmployeeRate, SickPay, Vacation, Holiday ,(40 * EmployeeRate) + (HoursWorked - 40) * EmployeeRate * 1.5  As Gross ,  0.12 * HoursWorked * EmployeeRate As StateTax, HoursWorked * EmployeeRate * .3 As FederalTax, KPlan, Insurance,HoursWorked * EmployeeRate - 0.12 * HoursWorked * EmployeeRate -  HoursWorked * EmployeeRate * .3 - KPlan - Insurance As Net, date  FROM Payroll INNER JOIN Employees ON Employees.addressID = Payroll.addressID   WHERE Employees.lastName1  = ?");
            
            insertNewPerson = connection.prepareStatement(
                    "INSERT INTO Payroll" +
                    "(addressID, firstName1, lastName1, HoursWorked, Overtime, EmployeeRate, SickPay, Vacation, Holiday , Gross , StateTax, FederalTax, KPlan, Insurance , Net, date )" +
                    "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)" );
          
        } 
        catch (SQLException sqlException)
        {
        sqlException.printStackTrace();
            System.exit(1);
        } // end catch
    }  // end constructor
    
    public List<Person> getAllPeople()
    {
        List< Person > results = null;
        ResultSet resultSet = null;
        
        try
        {
          resultSet = selectAllPeople.executeQuery();
          results = new ArrayList< Person > ();
          while (resultSet.next())
          {
              results.add (new Person(
                      resultSet.getString("addressID"),
                      resultSet.getString("firstName1"),
                      resultSet.getString("lastName1"),
                      resultSet.getString("HoursWorked"),
                      resultSet.getString("Overtime"),
                      resultSet.getString("EmployeeRate"),
                      resultSet.getString("SickPay"),
                      resultSet.getString("Vacation"),
                      resultSet.getString("Holiday"),
                      resultSet.getString("Gross"),
                      resultSet.getString("StateTax"),
                      resultSet.getString("FederalTax"),
                      resultSet.getString("KPlan"),
                      resultSet.getString("Insurance"),
                      resultSet.getString("Net"),
                      resultSet.getString("Date")));
                      
          }
       }
        catch (SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
       finally
       {
           try
           {
               resultSet.close();
           }
           catch (SQLException sqlException)
           {
               sqlException.printStackTrace();
               close();
           }
       }
       return results;
    }
    //////////////////////
     public List<Person> getAllPeople2()
    {
        List< Person > results = null;
        ResultSet resultSet = null;
        
        try
        {
          resultSet = selectPartTime.executeQuery();
          results = new ArrayList< Person > ();
          while (resultSet.next())
          {
              results.add (new Person(
                      resultSet.getString("addressID"),
                      resultSet.getString("firstName1"),
                      resultSet.getString("lastName1"),
                      resultSet.getString("HoursWorked"),
                      resultSet.getString("Overtime"),
                      resultSet.getString("EmployeeRate"),
                      resultSet.getString("SickPay"),
                      resultSet.getString("Vacation"),
                      resultSet.getString("Holiday"),
                      resultSet.getString("Gross"),
                      resultSet.getString("StateTax"),
                      resultSet.getString("FederalTax"),
                      resultSet.getString("KPlan"),
                      resultSet.getString("Insurance"),
                      resultSet.getString("Net"),
                      resultSet.getString("Date")));
                      
          }
       }
        catch (SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
       finally
       {
           try
           {
               resultSet.close();
           }
           catch (SQLException sqlException)
           {
               sqlException.printStackTrace();
               close();
           }
       }
       return results;
    }
    
    
    
    /////////////////////
    public List< Person > getPeopleByLastName (String name)
    {
        List <Person> results = null;
        ResultSet resultSet = null;
        
        try
        {
            selectPeopleByLastName.setString( 1,name );
            resultSet = selectPeopleByLastName.executeQuery();
            results = new ArrayList< Person >();
            while (resultSet.next())
            {
                results.add(new Person(
                      resultSet.getString("addressID"),
                      resultSet.getString("firstName1"),
                      resultSet.getString("lastName1"),
                      resultSet.getString("HoursWorked"),
                      resultSet.getString("Overtime"),
                      resultSet.getString("EmployeeRate"),
                      resultSet.getString("SickPay"),
                      resultSet.getString("Vacation"),
                      resultSet.getString("Holiday"),
                      resultSet.getString("Gross"),
                      resultSet.getString("StateTax"),
                      resultSet.getString("FederalTax"),
                      resultSet.getString("KPlan"),
                      resultSet.getString("Insurance"),
                      resultSet.getString("Net"),
                      resultSet.getString("Date")));
                
            }
        }  //end try
        catch (SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        finally
        {
            try
            {
                resultSet.close();
            }
            catch (SQLException  sqlException)
            {
                sqlException.printStackTrace();
                close();
            }
        }
        
        return results;
    }
    
    public int addPerson(
           String ID, String fname, String lname, String hours, String overtime, String rate, String sick, String vacation, String holidays, String gross, String state_tax, String fed_tax, String K_Plan, String Insurance, String Net , String date)
    {
        int result = 0;
        
        try
        {  
            insertNewPerson.setString(1,ID);
            insertNewPerson.setString(2, fname);
            insertNewPerson.setString(3,lname);
            insertNewPerson.setString(4, hours);
            insertNewPerson.setString(5, overtime);
            insertNewPerson.setString(6, rate);
            insertNewPerson.setString(7, sick);
            insertNewPerson.setString(8, vacation);
            insertNewPerson.setString(9, holidays);
            insertNewPerson.setString(10, gross);
            insertNewPerson.setString(11, state_tax);
            insertNewPerson.setString(12, fed_tax);
            insertNewPerson.setString(13, K_Plan);
            insertNewPerson.setString(14, Insurance);
            insertNewPerson.setString(15, Net);
            insertNewPerson.setString(16, date);
            
            result = insertNewPerson.executeUpdate();
        }
        catch (SQLException sqlException)
        {
            sqlException.printStackTrace();
            close();
            
        }
        return result;
    }
    public void close()
    {
        try 
        {
            connection.close();
            
        }
        catch (SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
    }

   

  
}

