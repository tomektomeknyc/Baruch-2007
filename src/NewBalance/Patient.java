package NewBalance;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Tomek
 */
//Patient.java


public class Patient
{
    private String addressID;
    private String firstName;
    private String lastName;
    private String address;
    private String payment;
    private String due;
    private String balance;
  
    private String newpay;
    private String newbal;
   
    
   

   
   

  
    
    public Patient()
    {
        
    }
    public Patient (String id, String first, String last, String Address, String Payment,String Due, String Balance, String Newpay , String Newbal )
    {
        setAddressID(id);
        setFirstName(first);
        setLastName(last);
        setaddress(Address);
        setpayment(Payment);
  
        setdue(Due);
        setbalance(Balance);
         
        setnewpayment(Newpay);
        setnewbalance(Newbal);
      
      
    }
    
  
    
    public void setnewbalance(String Newbal)
    {
        newbal = Newbal;
    }
    public String getnewbalance()
    {
        newbal = String.format("%.2f", Double.parseDouble(newbal));
        return newbal;
    }
    
     public void setnewpayment(String Newpay)
    {
        newpay = Newpay;
    }
    
    public String getnewpayment ()
    {
        newpay = String.format("%.2f", Double.parseDouble(newpay));
        return newpay;
    }
   
  public void setdue(String Due)
    {
    
      due = Due;
        
    }
    
    public String getdue ()
    {
        due = String.format("%.2f", Double.parseDouble(due));
      
        return due;
    }
   
    public void setpayment(String Payment)
    {
        payment = Payment;
    }
    public String getpayment()
    {
         payment = String.format("%.2f", Double.parseDouble(payment));
        return payment;
    }
    
    public void setbalance (String Balance)
    {
        balance = Balance;
    }
    public String getbalance()
    {
         balance = String.format("%.2f", Double.parseDouble(balance));
        return balance;
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
    
    public void setaddress(String Address)
    {
        address = Address;
    }
    
    public String getaddress()
    {
        return address;
        
    }

   
  
 

  

}

