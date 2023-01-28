package NetWorth;

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
   connection =  DriverManager.getConnection(URL, USERNAME, PASSWORD);
            
   selectAllPeople =
   connection.prepareStatement ("SELECT addressID,payment,date,due, (due-payment) AS due2,(SELECT SUM (payment) FROM Patients WHERE addressID <= O.addressID) AS net FROM  Patients O ORDER BY date ASC");
   
   selectAllPeople2= 
           connection.prepareStatement("SELECT addressID,payment,date,due, (due-payment) AS due2,(SELECT SUM (payment) FROM Patients WHERE addressID <= O.addressID) AS net FROM  Patients O WHERE date = ? ");
  
            
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
                      resultSet.getString("payment"),
                      resultSet.getString("date"),
                      resultSet.getString("due"),
                      resultSet.getString("due2"),
                      resultSet.getString("net")));
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
    
    /////////////
    
      public List<Patient> getPeopleByLastName (String date)
    {
        List <Patient> results = null;
        ResultSet resultSet = null;
        
        try
        {
            selectAllPeople2.setString( 1,date );
            resultSet = selectAllPeople2.executeQuery();
            results = new ArrayList< Patient >();
            while (resultSet.next())
            {
                results.add(new Patient(
                         resultSet.getString("addressID"),
                      resultSet.getString("payment"),
                      resultSet.getString("date"),
                      resultSet.getString("due"),
                      resultSet.getString("due2"),
                      resultSet.getString("net")));
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
    
    ////////////
  
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
