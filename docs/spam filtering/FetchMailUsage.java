import java.util.*;
import java.io.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.search.*;
import javax.activation.*;


public class FetchMailUsage {

    public static void main(String[] args) {

        // SUBSTITUTE YOUR ISP's POP3 SERVER HERE!!!
        String host = "pop.gmail.com";
        // SUBSTITUTE YOUR USERNAME AND PASSWORD TO ACCESS E-MAIL HERE!!!

	//get properties
	Properties props = System.getProperties();
        props.setProperty("mail.pop3.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.setProperty("mail.pop3.port", "995");
        props.setProperty("mail.pop3.socketFactory.port", "995");

        // Get a session.  Use a blank Properties object.
        Session session = Session.getInstance(props,null);

        try {

            // Get a Store object
            Store store = session.getStore("pop3");
            store.connect(host, user, password);

            // Get "INBOX"
            Folder fldr = store.getFolder("INBOX");
            fldr.open(Folder.READ_WRITE);
            int count = fldr.getMessageCount();
            System.out.println(count  + " total messages");

            // Message numebers start at 1
            for(int i = 1; i <= count; i++) {
								// Get  a message by its sequence number
                Message m = fldr.getMessage(i);

                // Get some headers
                Date date = m.getSentDate();
                //Address [] from = m.getFrom();
                //String subj = m.getSubject();
                //String mimeType = m.getContentType();
                //System.out.println(date + "\t" + from[0] + "\t" +subj + "\t" + mimeType);
		System.out.println(date+" message is spam "+isSpamMessage(m,user));
            }

               
            fldr.close(false);
            store.close();

        }
        catch (MessagingException mex) {
            // Prints all nested (chained) exceptions as well
            mex.printStackTrace();
        }
        catch (Exception ioex) {
            ioex.printStackTrace();
        }

    }
	public static boolean isSpamMessage(Message msg,String radd)
    {
        boolean fl=false;
        double spamflag=0;
        String[] str;
        Address[] toadd=null;
        Address[] ccadd=null;
        int toLen=0,ccLen=0;
        try
        {
            toadd=msg.getRecipients(Message.RecipientType.TO);
            if(toadd!=null)
                toLen=toadd.length;
            ccadd=msg.getRecipients(Message.RecipientType.CC);
            if(ccadd!=null)
                ccLen=ccadd.length;

            //[--check to field empty or not
            if(toLen==0)
            {
                spamflag+=.34;
            }

            //[--check both field empty or not
            if(toLen==0 & ccLen==0)
            {
                spamflag+=.34+.64;
            }

           //[--check receipient-address in TO or CC field
            if(toLen!=0 || ccLen!=0)
            {
                int i;
                for(i=0;i<toLen;i++)
                {
                    if(radd.equals(toadd[i].toString()))
                        break;
                }
                if(i==toLen)
                {
                    if(ccLen>0)
                    {
                        for(i=0;i<ccLen;i++)
                        {
                            if(radd.equals(ccadd[i].toString()))
                                break;
                        }
                        if(i==ccLen)
                            spamflag+=.64;
                    }
                }
            }

            //[--check no. of cc-address in  CC field
            if(ccLen>15)
            {
                spamflag+=.17;
            }

            //[--check no. of to-address in  TO field
            if(toLen>20)
            {
                spamflag+=.03;
            }

            //[--check if BCC field exits
            if(msg.getRecipients(Message.RecipientType.BCC).length>0)
            {
                spamflag+=.02;
            }

            //[--check if message-ID field exits
            if(msg.getHeader("Message-ID").length>0)
            {
                spamflag+=.20;
            }

            //[--check for UIDL field
            //it allow for multiple time downloading throgh mails
            //disabled in legitimate mails
            if(msg.getHeader("X_UIDL")!=null)
            {
                spamflag+=.01;
            }
	    
            //[--check sent mail-priority
            if(msg.getHeader("X_PRIORITY")!=null)
            {
                str=msg.getHeader("X_PRIORITY");
                int i=Integer.parseInt(str[0]);
                if(i==1)
                    spamflag+=.02;
            }

            //[--net evalution
            if(spamflag>=.90)
                fl=true;
        }
        catch(Exception e)
        {
                //System.out.println("in isSpamMessage function "+e);
                return fl;
        }
        return fl;
    }


} //End of class