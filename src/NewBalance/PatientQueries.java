package NewBalance;

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
    private PreparedStatement insertNewPerson = null;
   
    private PreparedStatement selectPeopleByLastName = null;
   
   

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
                    connection.prepareStatement ("SELECT Patients.addressID , firstName , lastName , address, payment, due, due - payment AS balance  , Patients.date, newpay , due - payment - newpay As newbal  FROM Patients INNER JOIN NewBalance ON Patients.addressID = NewBalance.addressID    WHERE due - payment - newpay = 0.00 ");
            
            selectAllPeople2 = 
                    connection.prepareStatement ("SELECT Patients.addressID , firstName , lastName , address , payment , due , due - payment AS balance  , Patients.date , newpay , due - payment - newpay As newbal  FROM Patients  INNER JOIN NewBalance ON Patients.addressID = NewBalance.addressID WHERE due - payment - newpay > 0.00 ");
            selectAllPeople3 = 
                    connection.prepareStatement ("SELECT Patients.addressID , firstName , lastName , address , payment , due , due - payment AS balance , Patients.date ,  newpay, due - payment - newpay As newbal FROM  Patients INNER JOIN NewBalance ON Patients.addressID = NewBalance.addressID   ");
           
                 
            selectPeopleByLastName = connection.prepareStatement(
                    "SELECT Patients.addressID , firstName , lastName , address , payment , due , due - payment AS balance , Patients.date, newpay, due - payment - newpay As newbal FROM Patients INNER JOIN NewBalance ON Patients.addressID = NewBalance.addressID  WHERE lastName = ?  ");
            
          insertNewPerson = connection.prepareStatement(
                  "INSERT INTO NewBalance" +
                   "(addressID, newpay, date )" +
                   " VALUES (?, ? , ?)" );
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
                      resultSet.getString("newpay"),
                     
                      resultSet.getString("newbal")));
                     
                  
                    
             
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
                      resultSet.getString("newpay"),
                     
                      resultSet.getString("newbal")));
                      
                    
                    
                 
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
                      resultSet.getString("newpay"),
                    
                      resultSet.getString("newbal")));
                      
                     
                    
                  
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
       
        public int addPatient(String ID, String newpay, String date)
    {
        int result = 0;
        
       
            
        
        
        try
        {
            insertNewPerson.setString(1, ID);
            insertNewPerson.setString(2, newpay);
            insertNewPerson.setString(3, date);
           
           
          
           
          
            
            result = insertNewPerson.executeUpdate();
        }
        catch (SQLException sqlException)
        {
            sqlException.printStackTrace();
            close();
            
        }
        return result;
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
                           resultSet.getString("newpay"),
                      
                      resultSet.getString("newbal")));
                    
                     
                    
                    
                
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

