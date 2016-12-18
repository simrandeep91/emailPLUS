/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package emailplus.operations;

/**
 *
 * @author student
 */
import java.util.Date;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import emailplus.MainFrame;
import emailplus.pop.MessageHeader;
public class DBOperations {
    public UsermasterBean checkUser(String username,String password)
    {
        Connection con=null;
        Statement stmt=null;
        ResultSet rs=null;
        UsermasterBean objBean=new UsermasterBean();
        try
        {
            con=DBConnection.getConnection();
            stmt=con.createStatement();
            String q="select *from usermaster where username='"+username+"';";
            rs=stmt.executeQuery(q);
            while(rs.next())
            {
                if(rs.getString("password").equals(password))
                {
                    objBean.setUserId(rs.getInt("user_id"));
                    objBean.setUsername(rs.getString("username"));
                    objBean.setPassword(rs.getString("password"));
                    objBean.setUserType(rs.getString("user_type"));
                    objBean.setUserStatus(rs.getString("user_status"));
                    objBean.setSecurityQuestion(rs.getString("security_question"));
                    objBean.setSecurityAnswer(rs.getString("security_answer"));
                }
            }
        }
        catch(Exception e)
        {
            System.out.println("in checkuser of DBOperation"+e);
            return objBean;
        }
        finally
        {
            try
            {
             rs.close();
             stmt.close();
             con.close();
            }
            catch(Exception e)
            {
            System.out.println("in finally of checkuser of DBOperation"+e);
            return objBean;
            }
        }
        return objBean;
    }
    public ArrayList getAllUserAccountDetail()
    {
        Connection con=null;
        Statement stmt=null;
        ResultSet rs=null;
        ArrayList al=new ArrayList();

        try
        {
            con=DBConnection.getConnection();
            stmt=con.createStatement();
            String q="select *from usermaster;";
            rs=stmt.executeQuery(q);
            while(rs.next())
            {
                    UsermasterBean obj=new UsermasterBean();
                    obj.setUserId(rs.getInt("user_id"));
                    obj.setUsername(rs.getString("username"));
                    obj.setPassword(rs.getString("password"));
                    obj.setUserType(rs.getString("user_type"));
                    obj.setUserStatus(rs.getString("user_status"));
                    obj.setSecurityQuestion(rs.getString("security_question"));
                    obj.setSecurityAnswer(rs.getString("security_answer"));
                    al.add(obj);
            }
        }
        catch(Exception e)
        {
            System.out.println("in getAllUserAccountDetail of DBOperation"+e);
            return al;
        }
        finally
        {
            try
            {
             rs.close();
             stmt.close();
             con.close();
            }
            catch(Exception e)
            {
            System.out.println("in finally of getAllUserAccountDetail of DBOperation"+e);
            return al;
            }
        }
        return al;
    }
     public UsermasterBean getAllProfileAccountDetail(int userid)
    {
        Connection con=null;
        Statement stmt=null;
        ResultSet rs=null;
        UsermasterBean objBean=new UsermasterBean();
        try
        {
            con=DBConnection.getConnection();
            stmt=con.createStatement();
            rs=stmt.executeQuery("select * from usermaster where User_id='"+userid+"';");
            while(rs.next())
            {
                objBean.setUserId(userid);
                objBean.setUsername(rs.getString("username"));
                objBean.setPassword(rs.getString("password"));
                objBean.setUserType(rs.getString("user_type"));
                objBean.setUserStatus(rs.getString("user_status"));
                objBean.setSecurityQuestion(rs.getString("Security_Question"));
                objBean.setSecurityAnswer(rs.getString("Security_Answer"));
            }
        }
        catch(Exception e)
        {
            System.out.println("in getAllProfileAccountDetail of DBOperation"+e);
            return objBean;
        }
        finally
        {
            try
            {
             rs.close();
             stmt.close();
             con.close();
            }
            catch(Exception e)
            {
            System.out.println("in finally of getAllProfileAccountDetail of DBOperation"+e);
            return objBean;
            }
        }
        return objBean;
    }
    public String addRecord(UsermasterBean objBean)
    {
        Connection con=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        String result="failed";
        try
        {
            if(objBean.getUsername().equals(""))
            {

            }
            con=DBConnection.getConnection();
            pstmt=con.prepareStatement("select * from usermaster where username=?;");
            pstmt.setString(1,objBean.getUsername());
            rs=pstmt.executeQuery();
            if(rs.next())
            {
                result="exits";
            }
            else
            {
                pstmt=con.prepareStatement("insert into usermaster(user_id,username,password,user_type,user_status,security_question,security_answer) values(?,?,?,?,?,?,?);");
                pstmt.setInt(1,objBean.getUserId());
                pstmt.setString(2,objBean.getUsername());
                pstmt.setString(3,objBean.getPassword());
                pstmt.setString(4,objBean.getUserType());
                pstmt.setString(5,objBean.getUserStatus());
                pstmt.setString(6,objBean.getSecurityQuestion());
                pstmt.setString(7,objBean.getSecurityAnswer());
                int i=pstmt.executeUpdate();
                if(i>0)
                {
                    pstmt=con.prepareStatement("insert into userpersonaldetail(user_id) values(?);");
                    pstmt.setInt(1, objBean.getUserId());
                    int j=pstmt.executeUpdate();
                    if(j>0)
                    result="added";
                }
            }
        }
        catch(Exception e)
        {
                System.out.println("in addRecord function"+e);
                return result;
        }
        finally
        {
            try
            {
                rs.close();
                pstmt.close();
                con.close();
            }
              catch(Exception e)
             {
                System.out.println("in finally of addRecord function"+e);
                return result;
               }
        }
        return result;
    }
    public String updateRecord(UsermasterBean objBean)
    {
        Connection con=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        String result="failed";
        try
        {
            con=DBConnection.getConnection();
            pstmt=con.prepareStatement("select * from usermaster where username=? and user_id!=?;");
            pstmt.setString(1,objBean.getUsername());
             pstmt.setInt(2,objBean.getUserId());
            rs=pstmt.executeQuery();
            if(rs.next())
            {
                result="exits";
            }
            else
            {
                pstmt=con.prepareStatement("update usermaster set username=?,password=?,user_type=?,user_status=?,security_question=?,security_answer=? where user_id=?;");
                pstmt.setInt(7,objBean.getUserId());
                pstmt.setString(1,objBean.getUsername());
                pstmt.setString(2,objBean.getPassword());
                pstmt.setString(3,objBean.getUserType());
                pstmt.setString(4,objBean.getUserStatus());
                pstmt.setString(5,objBean.getSecurityQuestion());
                pstmt.setString(6,objBean.getSecurityAnswer());
                int i=pstmt.executeUpdate();
                if(i>0)
                    result="updated";
            }
        }
        catch(Exception e)
        {
                System.out.println("in updateRecord function"+e);
                return result;
        }
        finally
        {
            try
            {
                rs.close();
                pstmt.close();
                con.close();
            }
              catch(Exception e)
             {
                System.out.println("in finally of updateRecord function"+e);
                return result;
               }
        }
        return result;
    }
    public ArrayList getAllUserPersonalDetail()
    {
        Connection con=null;
        Statement stmt=null;
        ResultSet rs=null;
        ArrayList al=new ArrayList();

        try
        {
            con=DBConnection.getConnection();
            stmt=con.createStatement();
            String q="select *from userpersonaldetail;";
            rs=stmt.executeQuery(q);
            while(rs.next())
            {
                    UserPersonalDetailBean obj=new UserPersonalDetailBean();
                    obj.setUserId(rs.getInt("user_id"));
                    obj.setName(rs.getString("name"));
                    obj.setDate(rs.getString("date_of_birth"));
                    obj.setAddress(rs.getString("address"));
                    obj.setPhone(rs.getString("phone"));
                    obj.setMobile(rs.getString("mobile"));
                    obj.setEmail(rs.getString("email"));
                    al.add(obj);
            }
        }
        catch(Exception e)
        {
            System.out.println("in getAllUserPersonaltDetail of DBOperation"+e);
            return al;
        }
        finally
        {
            try
            {
             rs.close();
             stmt.close();
             con.close();
            }
            catch(Exception e)
            {
            System.out.println("in finally of getAllUserPersonaltDetail of DBOperation"+e);
            return al;
            }
        }
        return al;
    }
    public UserPersonalDetailBean getAllPersonalRecord(int userid)
    {
        Connection con=null;
        Statement stmt=null;
        ResultSet rs=null;
        UserPersonalDetailBean objBean=new UserPersonalDetailBean();
        try
        {
            con=DBConnection.getConnection();
            stmt=con.createStatement();
            rs=stmt.executeQuery("select * from userpersonaldetail where User_id='"+userid+"';");
            while(rs.next())
            {
                objBean.setUserId(userid);
                objBean.setName(rs.getString("name"));
                objBean.setAddress(rs.getString("address"));
                objBean.setDate(rs.getString("Date_Of_Birth"));
                objBean.setPhone(rs.getString("phone"));
                objBean.setMobile(rs.getString("mobile"));
                objBean.setEmail(rs.getString("email"));
            }
        }
        catch(Exception e)
        {
            System.out.println("in getAllProfileAccountDetail of DBOperation"+e);
            return objBean;
        }
        finally
        {
            try
            {
             rs.close();
             stmt.close();
             con.close();
            }
            catch(Exception e)
            {
            System.out.println("in finally of getAllProfileAccountDetail of DBOperation"+e);
            return objBean;
            }
        }
        return objBean;
    }
    public String updatePersonalRecord(UserPersonalDetailBean objBean)
    {
        Connection con=null;
        PreparedStatement pstmt=null;
        String result="failed";
        try
        {
            con=DBConnection.getConnection();
                pstmt=con.prepareStatement("update userpersonaldetail set name=?,date_of_birth=?,address=?,phone=?,mobile=?,email=? where user_id=?;");
                pstmt.setInt(7,objBean.getUserId());
                pstmt.setString(1,objBean.getName());
                pstmt.setString(2,objBean.getDate());
                pstmt.setString(3,objBean.getAddress());
                pstmt.setString(4,objBean.getPhone());
                pstmt.setString(5,objBean.getMobile());
                pstmt.setString(6,objBean.getEmail());
                int i=pstmt.executeUpdate();
                if(i>0)
                    result="updated";
            
        }
        catch(Exception e)
        {
                System.out.println("in updatePersonalRecord function"+e);
                return result;
        }
        finally
        {
            try
            {
                pstmt.close();
                con.close();
            }
              catch(Exception e)
             {
                System.out.println("in finally of updatePersonalRecord function"+e);
                return result;
               }
        }
        return result;
    }
    public int getMaxConfigId()
    {
        Connection con=null;
        Statement stmt=null;
        ResultSet rs=null;
        int id=0;
        try
        {
            con=DBConnection.getConnection();
            stmt=con.createStatement();
            String q="select max(configuration_id) from mailserverconfigurationmaster;";
            rs=stmt.executeQuery(q);
            while(rs.next())
            {
               id=rs.getInt("max(configuration_id)");
            }
        }
        catch(Exception e)
        {
            System.out.println("in getMaxConfigId of DBOperation"+e);
            return id;
        }
        finally
        {
            try
            {
             rs.close();
             stmt.close();
             con.close();
            }
            catch(Exception e)
            {
            System.out.println("in finally of getMaxConfigId of DBOperation"+e);
            return id;
            }
        }
        return id;
    }
    public int getMaxId()
    {
        Connection con=null;
        Statement stmt=null;
        ResultSet rs=null;
        int id=0;
        try
        {
            con=DBConnection.getConnection();
            stmt=con.createStatement();
            String q="select max(user_id) from usermaster;";
            rs=stmt.executeQuery(q);
            while(rs.next())
            {
               id=rs.getInt("max(user_id)");
            }
        }
        catch(Exception e)
        {
            System.out.println("in getMaxId of DBOperation"+e);
            return id;
        }
        finally
        {
            try
            {
             rs.close();
             stmt.close();
             con.close();
            }
            catch(Exception e)
            {
            System.out.println("in finally of getMaxId of DBOperation"+e);
            return id;
            }
        }
        return id;
    }
    public UsermasterBean getPasswordAndEmail(String username)
    {
        Connection con=null;
        Statement stmt=null;
        ResultSet rs=null;
        UsermasterBean objBean=new UsermasterBean();
        objBean.setEmail("failed");
        try
        {
            con=DBConnection.getConnection();
            stmt=con.createStatement();
            String q="select password,email from usermaster,userpersonaldetail where usermaster.user_id=userpersonaldetail.user_id and username='"+username+"';";
            rs=stmt.executeQuery(q);
            while(rs.next())
            {
               objBean.setEmail(rs.getString("email"));
               objBean.setPassword(rs.getString("password"));
            }
        }
        catch(Exception e)
        {
            System.out.println("in getPasswordAndEmail of DBOperation"+e);
            return objBean;
        }
        finally
        {
            try
            {
             rs.close();
             stmt.close();
             con.close();
            }
            catch(Exception e)
            {
            System.out.println("in finally of getPasswordAndEmail of DBOperation"+e);
            return objBean;
            }
        }
        return objBean;
    }
    public UsermasterBean getAdminPasswordAndEmail(String username)
    {
        Connection con=null;
        Statement stmt=null;
        ResultSet rs=null;
        UsermasterBean objBean=new UsermasterBean();
        objBean.setEmail("failed");
        try
        {
            con=DBConnection.getConnection();
            stmt=con.createStatement();
            String q="select password,username from mailserverconfigurationmaster where configuration_id=1;";
            rs=stmt.executeQuery(q);
            while(rs.next())
            {
               objBean.setEmail(rs.getString("username"));
               objBean.setPassword(rs.getString("password"));
            }
        }
        catch(Exception e)
        {
            System.out.println("in getPasswordAndEmail of DBOperation"+e);
            return objBean;
        }
        finally
        {
            try
            {
             rs.close();
             stmt.close();
             con.close();
            }
            catch(Exception e)
            {
            System.out.println("in finally of getPasswordAndEmail of DBOperation"+e);
            return objBean;
            }
        }
        return objBean;
    }
    public String updateProfileRecord(UsermasterBean objBean)
    {
        Connection con=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        String result="failed";
        try
        {
            con=DBConnection.getConnection();
            pstmt=con.prepareStatement("select * from usermaster where username=? and user_id!=?;");
            pstmt.setString(1,objBean.getUsername());
             pstmt.setInt(2,objBean.getUserId());
            rs=pstmt.executeQuery();
            if(rs.next())
            {
                result="exits";
            }
            else
            {
                pstmt=con.prepareStatement("update usermaster set username=?,password=?,security_question=?,security_answer=? where user_id=?;");
                pstmt.setInt(5,objBean.getUserId());
                pstmt.setString(1,objBean.getUsername());
                pstmt.setString(2,objBean.getPassword());
                pstmt.setString(3,objBean.getSecurityQuestion());
                pstmt.setString(4,objBean.getSecurityAnswer());
                int i=pstmt.executeUpdate();
                if(i>0)
                    result="updated";
            }
        }
        catch(Exception e)
        {
                System.out.println("in updateProfileRecord function"+e);
                return result;
        }
        finally
        {
            try
            {
                rs.close();
                pstmt.close();
                con.close();
            }
              catch(Exception e)
             {
                System.out.println("in finally of updateProfileRecord function"+e);
                return result;
               }
        }
        return result;
    }
    public ArrayList getAllConfigurationDetail()
    {
        Connection con=null;
        Statement stmt=null;
        ResultSet rs=null;
        ArrayList al=new ArrayList();

        try
        {
            con=DBConnection.getConnection();
            stmt=con.createStatement();
            String q="select *from mailserverconfigurationmaster where user_id='"+MainFrame.userid+"';";
            rs=stmt.executeQuery(q);
            while(rs.next())
            {
                    ServerClientBean obj=new ServerClientBean();
                    obj.setConfigId(rs.getInt("configuration_id"));
                    obj.setUsername(rs.getString("username"));
                    obj.setPassword(rs.getString("password"));
                    obj.setSmtpServer(rs.getString("smtp_server"));
                    obj.setPopServer(rs.getString("pop_server"));
                    al.add(obj);
            }
        }
        catch(Exception e)
        {
            System.out.println("in getAllConfigurationDetail of DBOperation"+e);
            return al;
        }
        finally
        {
            try
            {
             rs.close();
             stmt.close();
             con.close();
            }
            catch(Exception e)
            {
            System.out.println("in finally of getAllConfigurationDetail of DBOperation"+e);
            return al;
            }
        }
        return al;
    }
    public String addConfigRecord(ServerClientBean objBean)
    {
        Connection con=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        String result="failed";
        try
        {
            con=DBConnection.getConnection();
            pstmt=con.prepareStatement("select * from mailserverconfigurationmaster where username=?;");
            pstmt.setString(1,objBean.getUsername());
            rs=pstmt.executeQuery();
            if(rs.next())
            {
                result="exits";
            }
            else
            {
                pstmt=con.prepareStatement("insert into mailserverconfigurationmaster(configuration_id,username,password,smtp_server,pop_server,user_id) values(?,?,?,?,?,?);");
                pstmt.setInt(1,objBean.getConfigId());
                pstmt.setString(2,objBean.getUsername());
                pstmt.setString(3,objBean.getPassword());
                pstmt.setString(4,objBean.getSmtpServer());
                pstmt.setString(5,objBean.getPopServer());
                pstmt.setInt(6, objBean.getUserId());
                int i=pstmt.executeUpdate();
                if(i>0)
                    result="added";
            }
        }
        catch(Exception e)
        {
                System.out.println("in addConfigRecord function"+e);
                return result;
        }
        finally
        {
            try
            {
                rs.close();
                pstmt.close();
                con.close();
            }
              catch(Exception e)
             {
                System.out.println("in finally of addConfigRecord function"+e);
                return result;
               }
        }
        return result;
    }
    public String updateConfigRecord(ServerClientBean objBean)
    {
        Connection con=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        String result="failed";
        try
        {
            con=DBConnection.getConnection();
            pstmt=con.prepareStatement("select * from mailserverconfigurationmaster where username=? and configuration_id!=?;");
            pstmt.setString(1,objBean.getUsername());
             pstmt.setInt(2,objBean.getConfigId());
            rs=pstmt.executeQuery();
            if(rs.next())
            {
                result="exits";
            }
            else
            {
                pstmt=con.prepareStatement("update mailserverconfigurationmaster set username=?,password=?,smtp_server=?,pop_server=? where configuration_id=?;");
                pstmt.setInt(5,objBean.getConfigId());
                pstmt.setString(1,objBean.getUsername());
                pstmt.setString(2,objBean.getPassword());
                pstmt.setString(3,objBean.getSmtpServer());
                pstmt.setString(4,objBean.getPopServer());
                int i=pstmt.executeUpdate();
                if(i>0)
                    result="updated";
            }
        }
        catch(Exception e)
        {
                System.out.println("in updatePersonalRecord function"+e);
                return result;
        }
        finally
        {
            try
            {
                rs.close();
                pstmt.close();
                con.close();
            }
              catch(Exception e)
             {
                System.out.println("in finally of updatePersonalRecord function"+e);
                return result;
               }
        }
        return result;
    }
    public String deleteServerRecord(int configid)
    {
        Connection con=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        String result="failed";
        try
        {
            con=DBConnection.getConnection();
            pstmt=con.prepareStatement("delete from mailserverConfigurationmaster where configuration_id=?;");
            pstmt.setInt(1, configid);
            int i=pstmt.executeUpdate();
            if(i>0)
            {
                result="deleted";
            }
        }
        catch(Exception e)
        {
                System.out.println("in deleteServerRecord function"+e);
                return result;
        }
        finally
        {
            try
            {
                rs.close();
                pstmt.close();
                con.close();
            }
              catch(Exception e)
             {
                System.out.println("in finally of deleteServerRecord function"+e);
                return result;
               }
        }
        return result;
    }
    public ArrayList getAllUserMailingRecord()
    {
        Connection con=null;
        Statement stmt=null;
        ResultSet rs=null;
        ArrayList al=new ArrayList();

        try
        {
            con=DBConnection.getConnection();
            stmt=con.createStatement();
            String q="select mailserverconfigurationmaster.username,mail_to,mail_subject,mail_date,usermaster.username from mailmaster,mailserverconfigurationmaster,usermaster where mailserverconfigurationmaster.user_id=usermaster.user_id and mailserverconfigurationmaster.configuration_id=mailmaster.configuration_id;";
            rs=stmt.executeQuery(q);
            while(rs.next())
            {
                    UserMailBean obj=new UserMailBean();
                    obj.setFrom(rs.getString(1));
                    obj.setTo(rs.getString("mail_to"));
                    obj.setSubject(rs.getString("mail_subject"));
                    obj.setDate(rs.getString("mail_date"));
                    obj.setUsername(rs.getString(5));
                    al.add(obj);
            }
        }
        catch(Exception e)
        {
            System.out.println("in getAllUserMailingRecord of DBOperation"+e);
            return al;
        }
        finally
        {
            try
            {
             rs.close();
             stmt.close();
             con.close();
            }
            catch(Exception e)
            {
            System.out.println("in finally of getAllUserMailingRecord of DBOperation"+e);
            return al;
            }
        }
        return al;
    }
    public ArrayList getAllUserActivityRecord()
    {
        Connection con=null;
        Statement stmt=null;
        ResultSet rs=null;
        ArrayList al=new ArrayList();

        try
        {
            con=DBConnection.getConnection();
            stmt=con.createStatement();
            String q="select username,useractivitymaster.user_id,login_time,logout_time from usermaster,useractivitymaster where useractivitymaster.user_id=usermaster.user_id;";
            rs=stmt.executeQuery(q);
            while(rs.next())
            {
                    UserActivityBean obj=new UserActivityBean();
                    obj.setUserId(rs.getInt("user_id"));
                    obj.setUsername(rs.getString("username"));
                    obj.setLoginTime(rs.getString("login_time"));
                    obj.setLogoutTime(rs.getString("logout_time"));
                    al.add(obj);
            }
        }
        catch(Exception e)
        {
            System.out.println("in getAllUserActivityRecord of DBOperation"+e);
            return al;
        }
        finally
        {
            try
            {
             rs.close();
             stmt.close();
             con.close();
            }
            catch(Exception e)
            {
            System.out.println("in finally of getAllUserActivityRecord of DBOperation"+e);
            return al;
            }
        }
        return al;
    }
    public ArrayList getAllUsername()
    {
        Connection con=null;
        Statement stmt=null;
        ResultSet rs=null;
        ArrayList al=new ArrayList();

        try
        {
            con=DBConnection.getConnection();
            stmt=con.createStatement();
            String q="select username from usermaster;";
            rs=stmt.executeQuery(q);
            while(rs.next())
            {
                    al.add(rs.getString("username"));
            }
        }
        catch(Exception e)
        {
            System.out.println("in getAllUserActivityRecord of DBOperation"+e);
            return al;
        }
        finally
        {
            try
            {
             rs.close();
             stmt.close();
             con.close();
            }
            catch(Exception e)
            {
            System.out.println("in finally of getAllUserActivityRecord of DBOperation"+e);
            return al;
            }
        }
        return al;
    }
    public String addMailRecord(UserMailBean objBean)
    {
        Connection con=null;
        PreparedStatement pstmt=null;
        String result="failed";
        try
        {
                con=DBConnection.getConnection();
                pstmt=con.prepareStatement("insert into mailmaster(configuration_id,mail_to,mail_subject,mail_content,mail_date) values(?,?,?,?,?);");
                pstmt.setInt(1,objBean.getConfigId());
                pstmt.setString(2,objBean.getTo());
                pstmt.setString(3,objBean.getSubject());
                pstmt.setString(4,objBean.getContent());
                pstmt.setString(5,objBean.getDate());
                int i=pstmt.executeUpdate();
                if(i>0)
                {
                    result="added";
                }
            }
        
        catch(Exception e)
        {
                System.out.println("in addMailRecord function"+e);
                return result;
        }
        finally
        {
            try
            {
                pstmt.close();
                con.close();
            }
              catch(Exception e)
             {
                System.out.println("in finally of addMailRecord function"+e);
                return result;
               }
        }
        return result;
    }
    public void addLoginTime(int userid)
    {
        Connection con=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        try
        {
                con=DBConnection.getConnection();
                int activityId=getMaxActivityId()+1;
                pstmt=con.prepareStatement("insert into useractivitymaster(activity_id,user_id,login_time) values(?,?,?);");
                pstmt.setInt(1, activityId);
                pstmt.setInt(2,userid);
                Date d=new Date();
                SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String str=sdf.format(d);
                pstmt.setString(3,str);
                pstmt.executeUpdate();
            }

        catch(Exception e)
        {
                System.out.println("in addLoginTime function"+e);
        }
        finally
        {
            try
            {
                pstmt.close();
                con.close();
            }
              catch(Exception e)
             {
                System.out.println("in finally of addLoginTime function"+e);
               }
        }
    }
    public void addLogoutTime()
    {
        Connection con=null;
        PreparedStatement pstmt=null;
        try
        {
                con=DBConnection.getConnection();
                pstmt=con.prepareStatement("update useractivitymaster set logout_time=? where activity_id=?;");
                pstmt.setInt(2,getMaxActivityId());
                Date d=new Date();
                SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String str=sdf.format(d);
                pstmt.setString(1, str);
                pstmt.executeUpdate();
            }

        catch(Exception e)
        {
                System.out.println("in addLogoutTime function"+e);
        }
        finally
        {
            try
            {
                pstmt.close();
                con.close();
            }
              catch(Exception e)
             {
                System.out.println("in finally of addLogoutTime function"+e);
               }
        }
    }
        public int getMaxActivityId()
        {
            Connection con=null;
        Statement stmt=null;
        ResultSet rs=null;
        int id=0;
        try
        {
            con=DBConnection.getConnection();
            stmt=con.createStatement();
            String q="select max(activity_id) from useractivitymaster;";
            rs=stmt.executeQuery(q);
            while(rs.next())
            {
               id=rs.getInt("max(activity_id)");
            }
        }
        catch(Exception e)
        {
            System.out.println("in getMaxActivityId of DBOperation"+e);
            return id;
        }
        finally
        {
            try
            {
             rs.close();
             stmt.close();
             con.close();
            }
            catch(Exception e)
            {
            System.out.println("in finally of getMaxActivityId of DBOperation"+e);
            return id;
            }
        }
        return id;
        }
        public ServerClientBean getConfigDetail(int configId)
        {
            Connection con=null;
            Statement stmt=null;
            ResultSet rs=null;
            ServerClientBean obj=new ServerClientBean();
            try
        {
            con=DBConnection.getConnection();
            stmt=con.createStatement();
            String q="select *from mailserverconfigurationmaster where configuration_id='"+configId+"';";
            rs=stmt.executeQuery(q);
            while(rs.next())
            {
                    obj.setConfigId(rs.getInt("configuration_id"));
                    obj.setUsername(rs.getString("username"));
                    obj.setPassword(rs.getString("password"));
                    obj.setSmtpServer(rs.getString("smtp_server"));
                    obj.setPopServer(rs.getString("pop_server"));
            }
        }
        catch(Exception e)
        {
            System.out.println("in getConfigDetail of DBOperation"+e);
            return obj;
        }
        finally
        {
            try
            {
             rs.close();
             stmt.close();
             con.close();
            }
            catch(Exception e)
            {
            System.out.println("in finally of getConfigDetail of DBOperation"+e);
            return obj;
            }
        }
        return obj;
        }
        public ArrayList getSentMailsDetail(int configId)
        {
            Connection con=null;
            Statement stmt=null;
            ResultSet rs=null;
            ArrayList al=new ArrayList();
            try
        {
            con=DBConnection.getConnection();
            stmt=con.createStatement();
            String q="select *from mailmaster where configuration_id='"+configId+"';";
            rs=stmt.executeQuery(q);
            while(rs.next())
            {
                UserMailBean obj=new UserMailBean();
                    obj.setTo(rs.getString("mail_to"));
                    obj.setSubject(rs.getString("mail_subject"));
                    obj.setContent(rs.getString("mail_content"));
                    obj.setDate(rs.getString("mail_date"));
                    al.add(obj);
            }
        }
        catch(Exception e)
        {
            System.out.println("in getSentMailsDetail of DBOperation"+e);
            return al;
        }
        finally
        {
            try
            {
             rs.close();
             stmt.close();
             con.close();
            }
            catch(Exception e)
            {
            System.out.println("in finally of getSentMailsDetail of DBOperation"+e);
            return al;
            }
        }
        return al;
        }
        public String addDeletedMailRecord(ArrayList al,int id)
    {
        Connection con=null;
        PreparedStatement pstmt=null;
        String result="failed";
        try
        {
                con=DBConnection.getConnection();
                pstmt=con.prepareStatement("insert into deletemailmaster(configuration_id,mail_to,mail_subject,mail_content,mail_date,mail_from) values(?,?,?,?,?,?);");
                for(int i=0;i<al.size();i++)
                {
                    MessageHeader objBean=(MessageHeader)al.get(i);
                    pstmt.setInt(1,id);
                    pstmt.setString(2,objBean.getMessageTo());
                    pstmt.setString(3,objBean.getMessageSubject());
                    pstmt.setString(4,objBean.getMessageContent());
                    Date d=objBean.getMessageSentDate();
                    String date=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(d);
                    pstmt.setString(5,date);
                    pstmt.setString(6,objBean.getMessageFrom());
                    pstmt.executeUpdate();
                }
                result="added";
            }
        
        catch(Exception e)
        {
                System.out.println("in adddeletedMailRecord function"+e);
                return result;
        }
        finally
        {
            try
            {
                pstmt.close();
                con.close();
            }
              catch(Exception e)
             {
                System.out.println("in finally of addDeletedMailRecord function"+e);
                return result;
               }
        }
        return result;
    }
        public String addSpamMailRecord(ArrayList al,int id)
    {
        Connection con=null;
        PreparedStatement pstmt=null;
        String result="failed";
        try
        {
                con=DBConnection.getConnection();
                pstmt=con.prepareStatement("insert into spammailmaster(configuration_id,mail_from,mail_subject,mail_content,mail_date) values(?,?,?,?,?);");
                for(int i=0;i<al.size();i++)
                {
                    MessageHeader objBean=(MessageHeader)al.get(i);
                    pstmt.setInt(1,id);
                    pstmt.setString(2,objBean.getMessageFrom());
                    pstmt.setString(3,objBean.getMessageSubject());
                    pstmt.setString(4,objBean.getMessageContent());
                    Date d=objBean.getMessageSentDate();
                    String date=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(d);
                    pstmt.setString(5,date);
                    pstmt.executeUpdate();
                }
                result="added";
            }
        
        catch(Exception e)
        {
                System.out.println("in addSpamMailRecord function"+e);
                return result;
        }
        finally
        {
            try
            {
                pstmt.close();
                con.close();
            }
              catch(Exception e)
             {
                System.out.println("in finally of addSpamMailRecord function"+e);
                return result;
               }
        }
        return result;
    }
        public ArrayList getAllDeletedMailRecord(int configid)
    {
        Connection con=null;
        Statement stmt=null;
        ResultSet rs=null;
        ArrayList al=new ArrayList();

        try
        {
            con=DBConnection.getConnection();
            stmt=con.createStatement();
            String q="select mail_id,mail_to,mail_subject,mail_content,mail_date,mail_from from deletemailmaster where configuration_id='"+configid+"';";
            rs=stmt.executeQuery(q);
            while(rs.next())
            {
                    MessageHeader obj=new MessageHeader();
                    obj.setEmailId(rs.getInt("mail_id"));
                    obj.setMessageFrom(rs.getString("mail_from"));
                    obj.setMessageTo(rs.getString("mail_to"));
                    obj.setMessageSubject(rs.getString("mail_subject"));
                    Date d=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(rs.getString("mail_date"));
                    obj.setMessageSentDate(d);
                    obj.setMessageContent(rs.getString("mail_content"));
                    al.add(obj);
            }
        }
        catch(Exception e)
        {
            System.out.println("in getAllDeletedMailRecord of DBOperation "+e);
            return al;
        }
        finally
        {
            try
            {
             rs.close();
             stmt.close();
             con.close();
            }
            catch(Exception e)
            {
            System.out.println("in finally of getAllDeletedMailRecord of DBOperation "+e);
            return al;
            }
        }
        return al;
    }
        public String deleteMailRecord(ArrayList al)
    {
        Connection con=null;
        PreparedStatement pstmt=null;
        String result="failed";
        try
        {
            con=DBConnection.getConnection();
            pstmt=con.prepareStatement("delete from deletemailmaster where mail_id=?;");
            for(int i=0;i<al.size();i++)
            {
                MessageHeader objBean=(MessageHeader)al.get(i);
                pstmt.setInt(1, objBean.getEmailId());
                pstmt.executeUpdate();
            }
            result="deleted";
        }
        catch(Exception e)
        {
                System.out.println("in deleteMailRecord function"+e);
                return result;
        }
        finally
        {
            try
            {
                pstmt.close();
                con.close();
            }
              catch(Exception e)
             {
                System.out.println("in finally of deleteMailRecord function"+e);
                return result;
               }
        }
        return result;
    }
        public String addDraft(UserMailBean objBean)
    {
        Connection con=null;
        PreparedStatement pstmt=null;
        String result="failed";
        try
        {
            con=DBConnection.getConnection();
                pstmt=con.prepareStatement("insert into draftmailmaster(configuration_id,mail_subject,mail_content,mail_date,mail_to) values(?,?,?,?,?);");
                pstmt.setInt(1,objBean.getConfigId());
                pstmt.setString(2,objBean.getSubject());
                pstmt.setString(3,objBean.getContent());
                pstmt.setString(4,objBean.getDate());
                pstmt.setString(5,objBean.getTo());
                int i=pstmt.executeUpdate();
                if(i>0)
                    result="added";
        }
        catch(Exception e)
        {
                System.out.println("in addDraft function "+e);
                return result;
        }
        finally
        {
            try
            {
                pstmt.close();
                con.close();
            }
              catch(Exception e)
             {
                System.out.println("in finally of addDraft function"+e);
                return result;
               }
        }
        return result;
    }
        public ArrayList getAllDrafts(int configId)
        {
            Connection con=null;
            Statement stmt=null;
            ResultSet rs=null;
            ArrayList al=new ArrayList();
            try
        {
            con=DBConnection.getConnection();
            stmt=con.createStatement();
            String q="select *from draftmailmaster where configuration_id='"+configId+"';";
            rs=stmt.executeQuery(q);
            while(rs.next())
            {
                UserMailBean obj=new UserMailBean();
                obj.setMailid(rs.getInt("mail_id"));
                    obj.setTo(rs.getString("mail_to"));
                    obj.setSubject(rs.getString("mail_subject"));
                    obj.setContent(rs.getString("mail_content"));
                    obj.setDate(rs.getString("mail_date"));
                    al.add(obj);
            }
        }
        catch(Exception e)
        {
            System.out.println("in getAllDrafts of DBOperation "+e);
            return al;
        }
        finally
        {
            try
            {
             rs.close();
             stmt.close();
             con.close();
            }
            catch(Exception e)
            {
            System.out.println("in finally of getAllDraft of DBOperation "+e);
            return al;
            }
        }
        return al;
        }
        public String deleteDraftRecord(UserMailBean objBean)
    {
        Connection con=null;
        PreparedStatement pstmt=null;
        String result="failed";
        try
        {
            con=DBConnection.getConnection();
            pstmt=con.prepareStatement("delete from draftmailmaster where mail_id=?;");
            pstmt.setInt(1, objBean.getMailid());
            int i=pstmt.executeUpdate();
            if(i>0)
            {
                result="deleted";
            }
        }
        catch(Exception e)
        {
                System.out.println("in draftMailRecord function"+e);
                return result;
        }
        finally
        {
            try
            {
                pstmt.close();
                con.close();
            }
              catch(Exception e)
             {
                System.out.println("in finally of draftMailRecord function"+e);
                return result;
               }
        }
        return result;
    }
}