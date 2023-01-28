package Tables;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Tomek
 */
import com.sun.rowset.*;
import java.awt.event.*;
import java.io.*;
import java.sql.*;
import java.util.*;
import javax.swing.table.*;
import javax.sql.rowset.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ResultSetTable extends JFrame {
  
    private Container container;
   



// combo box to select database table

//class ResultSetFrame extends JFrame
//{
     
  public ResultSetTable()
    {
        super("Tables");
       // setTitle("Tables");
        
         setLayout (new FlowLayout());
  
        container = getContentPane();
        container.setBackground(Color.orange);

        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
         setLayout (new FlowLayout(FlowLayout.CENTER, 42,60));
        setSize(475,570);
        setResizable(false);
        // find tables and add them to combo box
        
        tableNames = new JComboBox();
        tableNames.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent event)
            {
                try
                {
                    if (scrollPane != null) remove(scrollPane);
                    String tableName = (String) tableNames.getSelectedItem();
                    if(rs != null) rs.close();
                    String query = "SELECT * FROM " + tableName;
                    rs= stat.executeQuery(query);
                    if (scrolling)
                        model= new ResultSetTableModel(rs);
                    else
                    {
                        CachedRowSet crs = new CachedRowSetImpl();
                        crs.populate(rs);
                        model = new ResultSetTableModel(rs);
                        
                    }
                        JTable table = new JTable (model);
                        scrollPane = new JScrollPane(table);
                        add(scrollPane, BorderLayout.CENTER);
                        validate();
                    }
                    catch (SQLException e)
                    {
                        e.printStackTrace();
                            
                    }
                    
                 }
                });
        
            
            JPanel p = new JPanel();
            
            p.add(tableNames);
            add(p, BorderLayout.NORTH);
            
            try
            {
                conn= getConnection();
                DatabaseMetaData meta = conn.getMetaData();
                if(meta.supportsResultSetType(ResultSet.TYPE_SCROLL_INSENSITIVE))
                {
                    scrolling = true;
                    stat = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                            ResultSet.CONCUR_READ_ONLY);
                }
                else
                {
                    stat= conn.createStatement();
                    scrolling = false;
                }
                
                ResultSet tables = meta.getTables(null, null, null, new String[] {"TABLE"});
                while (tables.next())
                    tableNames.addItem(tables.getString(3));
                tables.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
                    
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
       addWindowListener(new
               WindowAdapter()
       {
           public void windowClosing(WindowEvent event)
           {
               try
               {
                   if (conn != null) conn.close();
               }
               catch (SQLException e)
               {
                   e.printStackTrace();
               }
           }
       });
    }
    
    public static Connection getConnection()
    throws SQLException, IOException
    {
        Properties props = new Properties();
       
         try {
                Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
   
  
     
        String drivers = props.getProperty("sun.jdbc.odbc.JdbcOdbcDriver");
      
       // String url = props.getProperty("jdbc:odbc:AddressBook");
       // String username = props.getProperty("jdbc.username");
       // String password = props.getProperty("jdbc.password");
        return DriverManager.getConnection("jdbc:odbc:AddressBook","sa" ,"sarah1");
      
       
      
        
    }


    private JScrollPane scrollPane;
    private ResultSetTableModel model;
    private JComboBox tableNames;
    private ResultSet rs;
    private Connection conn;
    private Statement stat;
    private boolean scrolling;
    
    private static final int DEFAULT_WIDTH = 400;
    private static final int DEFAULT_HEIGHT= 300;
}

class ResultSetTableModel extends AbstractTableModel
{
    public ResultSetTableModel(ResultSet aResultSet)
    {
        rs= aResultSet;
        try
        {
            rsmd = rs.getMetaData();
            
        }
        catch  (SQLException e)
        {
            e.printStackTrace();
        }
    }
    
    public String getColumnName(int c)
    {
        try
        {
            return rsmd.getColumnName(c+1);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
           return "";
        }
    }
    public int getColumnCount()
    {
        try
        {
            return rsmd.getColumnCount();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return 0;
        }
    }
    public Object getValueAt(int r, int c)
    {
        try
        {
            rs.absolute(r+1);
            return rs.getObject(c+1);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return null;
        }
    }
    public int getRowCount()
    {
        try
        {
            rs.last();
            return rs.getRow();
            
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return 0;
        }
    }
    private ResultSet rs;
    private ResultSetMetaData rsmd;
    
     public static void main (String[] args)
    {
       ResultSetTable result = new ResultSetTable(); 
       result.setSize(550, 420);
       result.setResizable(true);
       result.setVisible(true);
        new ResultSetTable();
    }
}
