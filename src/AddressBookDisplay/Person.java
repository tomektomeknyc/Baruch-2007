package AddressBookDisplay;

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
    private String addressID;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String patientID;
    
    public Person()
    {
        
    }
    public Person (String id, String first, String last, String emailAddress, String phone, String PatientID)
    {
        setAddressID(id);
        setFirstName(first);
        setLastName(last);
        setEmail(emailAddress);
        setPhoneNumber(phone);
        setpatientID (PatientID);
        
    }
    
    public void setpatientID(String PatientID)
    {
        patientID = PatientID;
    }
    
    public String getpatientID()
    {
        return patientID;
    }
    public void setAddressID(String id)
    {
        addressID = id;
    }
    public String getAddressID()
    {
        return addressID;
    }
    public void setFirstName(String first)
    {
        firstName = first;
    }
    
    public String getFirstName()
    {
        return firstName;
    }
    
    public void setLastName (String last)
    {
        lastName = last;
    }
    
    public String getLastName()
    {
        return lastName;
    }
    
    public void setEmail(String emailAddress)
    {
        email = emailAddress;
    }
    
    public String getEmail()
    {
        return email;
        
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