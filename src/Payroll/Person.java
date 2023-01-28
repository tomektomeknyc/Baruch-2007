package Payroll;

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
    private String hours;
    private String overtime;
    private String rate;
    private String sick;
    private String vacation;
    private String holidays;
    private String state_tax;
    private String fed_tax;
    private String K_Plan;
    private String Insurance;
    private String Net;
    private String date;
    private String gross;
    int i = 40;
    int j = 0;
    String str = Integer.toString(i);
    
    String strr = Integer.toString(j);

  
    
    
    public Person()
    {
        
    }
    public Person (String id, String first, String last, String Hours, String Overtime, String Rate, String Sick, String Vacation, String Holidays, String Gross, String State_tax, String Fed_tax, String k_Plan, String insurance, String net, String Date)
    {
        setAddressID(id);
        setFirstName(first);
        setLastName(last);
        setHours(Hours);
        setOvertime(Overtime);
        setRate (Rate);
        setSick (Sick);
        setVacation (Vacation);
        setHolidays (Holidays);
        setgross(Gross);
        setStateTax(State_tax);
        setFedTax(Fed_tax);
        setKPlan (k_Plan);
        setInsurance(insurance);
        setNet (net);
        setDate(Date);
       
    }
    
    public void setgross(String Gross)
    {
        gross = Gross;
    }
    public String getgross()
    {
         gross = String.format("%.2f", Double.parseDouble(gross));
        
        return gross;
    }
    
     public void setDate(String Date)
    {
        date = Date;
    }
    
    public String getDate()
    {
        return date;
    }
    
    public void setNet(String net)
    {
        Net = net;
    }
    public String getNet()
    {
         Net = String.format("%.2f", Double.parseDouble(Net));
        return Net;
    }
    
    public void setInsurance(String insurance)
    {
        Insurance = insurance;
    }
    public String getInsurance()
    {
         Insurance = String.format("%.2f", Double.parseDouble(Insurance));
        return Insurance;
    }
    public void setKPlan(String k_Plan)
    {
        K_Plan = k_Plan;
    }
    public String getKPlan()
    {
         K_Plan = String.format("%.2f", Double.parseDouble(K_Plan));
        return K_Plan;
    }
    
    
    public void setFedTax(String Fed_tax)
    {
        fed_tax= Fed_tax;
    }
    public String getFedTax()
    {
         fed_tax = String.format("%.2f", Double.parseDouble(fed_tax));
        return fed_tax;
    }
    
    public void setStateTax(String State_tax)
    {
        state_tax = State_tax;
    }
    public String getStateTax()
    {
         state_tax = String.format("%.2f", Double.parseDouble(state_tax));
        return state_tax;
    }
    public void setHolidays (String Holidays)
    {
        holidays = Holidays;
    }
    public String getHolidays ()
    {
         holidays = String.format("%.2f", Double.parseDouble(holidays));
        return holidays;
    }
    public void setVacation (String Vacation)
    {
        vacation = Vacation;
    }
    public String getVacation ()
    {
         vacation = String.format("%.2f", Double.parseDouble(vacation));
        return vacation;
    }
    public void setSick(String Sick)
    {
        sick = Sick;
    }
    public String getSick()
    {
         sick = String.format("%.2f", Double.parseDouble(sick));
        return sick;
    }
    
    public void setRate (String Rate)
    {
        rate = Rate;
    }
    public String getRate()
    {
         rate = String.format("%.2f", Double.parseDouble(rate));
        return rate;
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
    
    public void setHours(String Hours)
    {
      hours = Hours;
    }
    
    public String getHours()
    {
         hours = String.format("%.2f", Double.parseDouble(hours));
        return hours;
        
    }
    
  
    
    public void setOvertime (String Overtime)
    {
        if(hours == str )
        overtime = strr;
        else
         overtime = Overtime;
        
    }
    
    public String getOvertime()
    {
         overtime = String.format("%.2f", Double.parseDouble(overtime));
        return overtime;
    }
}

