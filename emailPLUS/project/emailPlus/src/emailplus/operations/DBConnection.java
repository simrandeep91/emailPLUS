/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package emailplus.operations;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author student
 */
public class DBConnection {
    public static Connection getConnection()
{
     Connection con = null;
     try
 {
           Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql:///emailplus", "root","mysql");
     }
catch (Exception e)
 {
       System.out.println("Exception in getConnection of DBConnection : " + e);
     }
     return con;
   }

}
