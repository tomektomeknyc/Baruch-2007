package DoctorsPatients2;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Tomek
 */
//Person.java
public class Person
{
 
    private String dfirstName;
    private String dlastName;
    private String phoneNumber;
    private String firstName2;
    private String lastName2;
    private String date;
    private String patientID;
    private String pr;
    private String room;
    
    public Person()
    {
        
    }
    public Person (String first, String last, String phone,String first2, String last2, String Date, String PatientID, String Pr, String Room)
    {
     
        setdFirstName(first);
        setdLastName(last);
        setPhoneNumber(phone);
        setFirstName2(first2);
        setLastName2(last2);
        setDate(Date);
        setpatientID (PatientID);
        setpr (Pr);
        setroom(Room);
        
    }
    
    public void setpr(String Pr)
    {
        pr = Pr;
    }
    public String getpr()
    {
        return pr;
    }
    
    public void setroom(String Room)
    {
        room = Room;
    }
    
    public String getroom()
    {
        return room;
    }
    
    public void setDate(String Date)
    {
        date = Date;
    }
    
    public String getDate()
    {
        return date;
    }
    
    public void setpatientID(String PatientID)
    {
        patientID = PatientID;
    }
    
    public String getpatientID()
    {
        return patientID;
    }
   
    public void setdFirstName(String first)
    {
        dfirstName = first;
    }
    
    public String getdFirstName()
    {
        return dfirstName;
    }
    
    public void setdLastName (String last)
    {
        dlastName = last;
    }
    
    public String getdLastName()
    {
        return dlastName;
    }
    
   public void setFirstName2(String first2)
    {
        firstName2 = first2;
    }
    
    public String getFirstName2()
    {
        return firstName2;
    }
    
    public void setLastName2 (String last2)
    {
        lastName2 = last2;
    }
    
    public String getLastName2()
    {
        return lastName2;
    }
    public void setPhoneNumber (String phone)
    {
        phoneNumber = phone;
    }
    
    public String getPhoneNumber()
    {
        return phoneNumber;
    }

  
 
    
}