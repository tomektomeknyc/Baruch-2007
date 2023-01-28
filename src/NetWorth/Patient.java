package NetWorth;

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
    private String net;
    private String payment;
    private String due;
    private String due2;
    private String date;
 public Patient()
    {
        
    }
    public Patient (String id, String Payment, String Date, String Due, String Due2, String Net)
    {
        setAddressID(id);
        setpayment(Payment);
        setnet(Net);
        setdue(Due);
        setdue2(Due2);
        setdate(Date);
    }
    
    public void setdue2(String Due2)
    {
        due2 = Due2;
    }
    
    public String getdue2()
    {
         due2 = String.format("%.2f", Double.parseDouble(due2));
        return due2;
    }
   
    public void setdate(String Date)
    {
        date = Date;
    }
    public String getdate()
    {
        return date;
    }
    public void setdue(String Due)
    {
        due = Due;
    }
    public String getdue()
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
    
    public void setnet (String Net)
    {
        net = Net;
    }
    public String getnet()
    {
         net = String.format("%.2f", Double.parseDouble(net));
        return net;
    }
    
    public void setAddressID(String id)
    {
        addressID = id;
    }
    public String getAddressID()
    {
        return addressID;
    }

 
 }

