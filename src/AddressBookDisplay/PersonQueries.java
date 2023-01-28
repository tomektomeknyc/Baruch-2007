package AddressBookDisplay;

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
            
            selectAllPeople =
                    connection.prepareStatement ("SELECT addressID, firstName1, lastName1, email, phoneNumber, patientID1  FROM Employees");
                 
            selectPeopleByLastName = connection.prepareStatement(
                    "SELECT addressID, firstName1, lastName1, email, phoneNumber, patientID1 FROM Employees WHERE lastName1 = ?");
            
            insertNewPerson = connection.prepareStatement(
                    "INSERT INTO Employees" +
                    "(addressID, firstName1, lastName1, email, phoneNumber, patientID1 )" +
                    "VALUES (?,?,?,?,?,?)" );
          
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
                      resultSet.getString("email"),
                      resultSet.getString("phoneNumber"),
                      resultSet.getString("patientID1")));
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
                      resultSet.getString("email"),
                      resultSet.getString("phoneNumber"),
                      resultSet.getString("patientID1")));
                
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
           String ID, String fname, String lname, String email, String num, String patientID)
    {
        int result = 0;
        
        try
        {  
            insertNewPerson.setString(1,ID);
            insertNewPerson.setString(2, fname);
            insertNewPerson.setString(3,lname);
            insertNewPerson.setString(4, email);
            insertNewPerson.setString(5, num);
            insertNewPerson.setString(6, patientID);
            
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

