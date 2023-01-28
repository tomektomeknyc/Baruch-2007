/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Plot;

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
                connection.prepareStatement ("SELECT firstName1, lastName1, phoneNumber, firstName, lastName, date, patientID1, pr, room FROM Patients, Employees WHERE Employees.patientID1 = Patients.patientID ORDER BY lastName1 ASC");
       
                 
            selectPeopleByLastName = connection.prepareStatement(
                    "SELECT  firstName1, lastName1, phoneNumber, firstName, lastName, date, patientID1, pr, room FROM Employees, Patients WHERE Employees.patientID1 = Patients.patientID AND lastName1 = ?");
            
           
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
                      resultSet.getString("firstName1"),
                      resultSet.getString("lastName1"),
                      resultSet.getString("phoneNumber"),
                      resultSet.getString("firstName"),
                      resultSet.getString("lastName"),
                      resultSet.getString("date"),
                      resultSet.getString("patientID1"),
                      resultSet.getString("pr"),
                      resultSet.getString("room")));
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
                      resultSet.getString("firstName1"),
                      resultSet.getString("lastName1"),
                      resultSet.getString("phoneNumber"),
                      resultSet.getString("firstName"),
                      resultSet.getString("lastName"),
                      resultSet.getString("date"),
                      resultSet.getString("patientID1"),
                      resultSet.getString("pr"),
                      resultSet.getString("room")));
                
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

