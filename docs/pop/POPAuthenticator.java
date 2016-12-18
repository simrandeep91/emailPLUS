
package emailplus.pop;
import javax.mail.*;


/**
 *
 * @author Administrator
 */
public class POPAuthenticator extends Authenticator {
    
    /** Creates a new instance of POPAuthenticator */
    
    private String username,password;
    public POPAuthenticator(String username,String password) {
        this.username=username;
        this.password=password;
    }
    public javax.mail.PasswordAuthentication getPasswordAuthentication(){
       // System.out.println("verifying username and password with ="+this.username);
        return new PasswordAuthentication(this.username,this.password);
    }
}
