package Payroll;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Tomek
 */
import java.util.*;

public class Now {

public static void  main(String arg[]) {
    /* 
    ** on some JDK, the default TimeZone is wrong
    ** we must set the TimeZone manually!!!
    **   Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("EST"));
    */
    Calendar cal = Calendar.getInstance(TimeZone.getDefault());
    
    String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    java.text.SimpleDateFormat sdf = 
          new java.text.SimpleDateFormat(DATE_FORMAT);
 
    sdf.setTimeZone(TimeZone.getDefault());          
          
    System.out.println("" + sdf.format(cal.getTime()));
    }
}

