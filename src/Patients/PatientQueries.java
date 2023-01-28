package Patients;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Tomek
 */
// PatientQueries.java



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

public class PatientQueries
{
    private static final String URL = "jdbc:odbc:AddressBook";
    private static final String USERNAME = "sa";
    private static final String PASSWORD = "sarah1";
 
    
    private Connection connection = null;
    private PreparedStatement selectAllPeople = null;
    private PreparedStatement selectAllPeople2 = null;
    private PreparedStatement selectAllPeople3 = null;
   
    private PreparedStatement selectPeopleByLastName = null;
    private PreparedStatement insertNewPerson = null;
    private PreparedStatement deletePerson = null;
    private PreparedStatement updatePerson = null;

    private Object ID;

   
    
    public PatientQueries()
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
                    connection.prepareStatement ("SELECT addressID, firstName, lastName, address, payment, due, due - payment AS balance, date, patientID, pr, room  FROM Patients WHERE due- payment = 0");
            
            selectAllPeople2 = 
                    connection.prepareStatement ("SELECT addressID, firstName, lastName, address, payment, due, due - payment AS balance, date, patientID, pr , room   FROM Patients WHERE due - payment > 0");
            selectAllPeople3 = 
                    connection.prepareStatement ("SELECT addressID, firstName, lastName, address, payment, due, due - payment AS balance, date, patientID, pr , room  FROM Patients ");
           
                 
            selectPeopleByLastName = connection.prepareStatement(
                    "SELECT addressID, firstName, lastName, address, payment, due, due - payment AS balance, date, patientID, pr , room FROM Patients WHERE LastName = ?");
            
            insertNewPerson = connection.prepareStatement(
                    "INSERT INTO Patients" +
                    "(addressID,FirstName, LastName, Address, payment, due, balance, date, patientID, pr , room )" +
                     "VALUES (?,?,?,?,?,?,?,?,?,?,?)" );
            deletePerson = connection.prepareStatement( "DELETE FROM Patients WHERE due - payment = 0.00 ");
            
            updatePerson = connection.prepareStatement(
                    "UPDATE Patients SET addressID = addressID + ?, firstName = firstName + ?, lastName = lastName + ?, address = address + ?, payment = payment + ?, due = due + ?, balance = balance + ?, date = date + ?, patientID = patientID + ?, pr = pr + ?, room = room + ?");
        } 
        catch (SQLException sqlException)
        {
        sqlException.printStackTrace();
            System.exit(1);
        } // end catch
    }  // end constructor
    
    public List<Patient> getAllPeople()
    {
        List< Patient > results = null;
        ResultSet resultSet = null;
        
        try
        {
          resultSet = selectAllPeople.executeQuery();
          results = new ArrayList< Patient > ();
          while (resultSet.next())
          {
              results.add (new Patient(
                      resultSet.getString("addressID"),
                      resultSet.getString("firstName"),
                      resultSet.getString("lastName"),
                      resultSet.getString("address"),
                      resultSet.getString("payment"),
                      resultSet.getString("due"),
                      resultSet.getString("balance"),
                      resultSet.getString("date"),
                      resultSet.getString("patientID"),
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
     
    //////////////////
    
      public List<Patient> delete()
    {
        List< Patient > results = null;
        ResultSet resultSet = null;
        
        try
        {
          resultSet = deletePerson.executeQuery();
          results = new ArrayList< Patient > ();
          while (resultSet.next())
          {
              results.add (new Patient(
                      resultSet.getString("addressID"),
                      resultSet.getString("firstName"),
                      resultSet.getString("lastName"),
                      resultSet.getString("address"),
                      resultSet.getString("payment"),
                      resultSet.getString("due"),
                      resultSet.getString("balance"),
                      resultSet.getString("date"),
                      resultSet.getString("patientID"),
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
     
    
    
    
    
    ////////////////
       
       
     public   List<Patient> getAllPeople2()
    {
        List< Patient > results = null;
        ResultSet resultSet = null;
        
        try
        {
          resultSet = selectAllPeople2.executeQuery();
          results = new ArrayList< Patient > ();
          while (resultSet.next())
          {
              results.add (new Patient(
                      resultSet.getString("addressID"),
                      resultSet.getString("firstName"),
                      resultSet.getString("lastName"),
                      resultSet.getString("address"),
                      resultSet.getString("payment"),
                      resultSet.getString("due"),
                      resultSet.getString("balance"),
                      resultSet.getString("date"),
                      resultSet.getString("patientID"),
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
    //////////////////
     
     
       public   List<Patient> getAllPeople3()
    {
        List< Patient > results = null;
        ResultSet resultSet = null;
        
        try
        {
          resultSet = selectAllPeople3.executeQuery();
          results = new ArrayList< Patient > ();
          while (resultSet.next())
          {
              results.add (new Patient(
                      resultSet.getString("addressID"),
                      resultSet.getString("firstName"),
                      resultSet.getString("lastName"),
                      resultSet.getString("address"),
                      resultSet.getString("payment"),
                      resultSet.getString("due"),
                      resultSet.getString("balance"),
                      resultSet.getString("date"),
                      resultSet.getString("patientID"),
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
 
  public List<Patient> getPeopleByLastName (String name)
    {
        List <Patient> results = null;
        ResultSet resultSet = null;
        
        try
        {
            selectPeopleByLastName.setString( 1,name );
            resultSet = selectPeopleByLastName.executeQuery();
            results = new ArrayList< Patient >();
            while (resultSet.next())
            {
                results.add(new Patient(
                        resultSet.getString("addressID"),
                        resultSet.getString("firstName"),
                        resultSet.getString("lastName"),
                        resultSet.getString ("address"),
                        resultSet.getString("payment"),
                        resultSet.getString("due"),
                        resultSet.getString("balance"),
                        resultSet.getString("date"),
                        resultSet.getString("patientID"),
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
    
    public int addPatient(
          String addressID,String fname, String lname, String address, String payment,String due, String balance, String date, String patientID, String pr, String room)
    {
        int result = 0;
        
       
            
        
        
        try
        {
            insertNewPerson.setString(1, addressID);
            insertNewPerson.setString(2, fname);
            insertNewPerson.setString(3, lname);
            insertNewPerson.setString(4, address);
            insertNewPerson.setString(5, payment);
            insertNewPerson.setString(6, due);
            insertNewPerson.setString(7, balance);
            insertNewPerson.setString(8, date);
            insertNewPerson.setString(9, patientID);
            insertNewPerson.setString(10, pr);
            insertNewPerson.setString(11, room);
         
           
          
            
            result = insertNewPerson.executeUpdate();
        }
        catch (SQLException sqlException)
        {
            sqlException.printStackTrace();
            close();
            
        }
        return result;
    }
    
    /////////////////////////////
    
     public int updatePerson(
          String addressID,String fname, String lname, String address, String payment,String due, String balance, String date, String patientID, String pr , String room )
    {
        int result = 0;
        
        try
        {
            updatePerson.setString(1, addressID);
            updatePerson.setString(2, fname);
            updatePerson.setString(3, lname);
            updatePerson.setString(4, address);
            updatePerson.setString(5, payment);
            updatePerson.setString(6, due);
            updatePerson.setString(7, balance);
            updatePerson.setString(8, date);
            updatePerson.setString(9, patientID);
            updatePerson.setString(10, pr);
            updatePerson.setString(11, room);
         
           
          
            
            result = updatePerson.executeUpdate();
        }
        catch (SQLException sqlException)
        {
            sqlException.printStackTrace();
            close();
            
        }
        return result;
     }
    /////////////////////////////
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

