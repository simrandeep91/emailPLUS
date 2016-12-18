/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package emailplus.pop;

import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.InternetAddress;

/**
 *
 * @author deepika
 */
public class SimpleReceiver {
    static MessageHeader mh;
    int flag = 1;
    static Folder folder = null;
    public static int msgcount=0;
    static String username;
    static boolean openFlag;
    private ArrayList inboxList=null,spamMessageList=null;

    /**
     * "receive" method to fetch messages and process them.
     */
    public SimpleReceiver(boolean openFlag)
    {
        this.openFlag=openFlag;
        inboxList=new ArrayList();
        spamMessageList=new ArrayList();
    }
    public ArrayList receive(String popServer, String popUser, String popPassword) {
        Store store = null;
        //System.out.println(popUser+"  "+popPassword);
        username=popUser;
        try {
            // -- Get hold of the default session --
            Properties props = System.getProperties();
            props.setProperty("mail.pop3.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            props.setProperty("mail.pop3.port", "995");
            props.setProperty("mail.pop3.socketFactory.port", "995");

            Session session = Session.getDefaultInstance(props, null);
            //Session session = Session.getInstance(props, auth);

            store = session.getStore("pop3");

            store.connect(popServer, popUser, popPassword);
            //store.connect();


            // -- Try to get hold of the default folder --
            folder = store.getDefaultFolder();

            //System.out.println("The new folder is created " + folder.create(Folder.HOLDS_MESSAGES));


            if (folder == null) {
                throw new Exception("No default folder");
            }



            folder = folder.getFolder("INBOX");

            if (folder == null) {
                throw new Exception("No POP3 INBOX");
            }
            // -- Open the folder for read only --
            folder.open(Folder.READ_WRITE);

            // -- Get the message wrappers and process them --
            Message[] msgs = folder.getMessages();
            msgcount=msgs.length;

            
            for (int msgNum = msgs.length - 1; msgNum >= 0; msgNum--) {
                processMessageHeader(msgs[msgNum]);
            }
        } catch (Exception ex) {
            flag = 0;
            ex.printStackTrace();
        } finally {
            // -- Close down nicely --
            try {
                if (folder != null) {
                    folder.close(false);
                }
                if (store != null) {
                    store.close();
                }
            } catch (Exception ex2) {
                ex2.printStackTrace();
            }
        }
        if (flag == 0) {
            inboxList = null;
        }
        return inboxList;
    }

    /**
     * "processMessageHeader()" method to process the message header.
     */
    public void processMessageHeader(Message message) {
        try {
            //Get All the headers information in msg
            String senderEmailId = ((InternetAddress) message.getFrom()[0]).getAddress();
            //System.out.println("senderEmailId " + senderEmailId);
            String domainName = senderEmailId.substring(senderEmailId.indexOf("@") + 1);
            //System.out.println("the from address in process message method is = " + domainName);
            mh = new MessageHeader();
            String from = ((InternetAddress) message.getFrom()[0]).getPersonal();
            if (from == null) {
                from = ((InternetAddress) message.getFrom()[0]).getAddress();
            }

            
            String messageId = message.getHeader("Message-ID")[0];
            String messageTo = message.getHeader("To")[0];
            String messageSubject = message.getSubject();
            Date messageSentDate = message.getSentDate();
            

                
                
              
            mh.setEmailId(message.getMessageNumber());             
            mh.setMessageFrom(from);
            mh.setMessageId(messageId);
            mh.setMessageSubject(messageSubject);
            mh.setMessageSentDate(messageSentDate);
            mh.setMessageTo(messageTo);
            mh.setDomainName(domainName);
            mh.setSenderEmailIdName(senderEmailId);
            //System.out.println("before adding to vector = " + messageSubject);
            if(SpamDetector.isSpamMessage(message,username))
            {
                    mh.setSpamFlag(true);
                    spamMessageList.add(mh);
             }
            else
            {
                inboxList.add(mh);
            }


        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public void deleteMails(boolean[] flag)
    {
        try
        {
            if(!openFlag)
                folder.open(Folder.READ_WRITE);
            //msgcount=folder.getMessageCount();
            for(int i=0;i<flag.length;i++)
            {
                if(flag[i])
                {
                    folder.getMessage(msgcount-i).setFlag(Flags.Flag.DELETED, true);
                }
            }
            openFlag=true;
            //Message[] m=folder.expunge();
            //System.out.println(m.length);
        }
        catch(Exception e)
        {
            System.out.println("in catch of deleteMail function "+e);
        }
        
    }
    public void closeFolder()
    {
        try
        {
            if(openFlag)
            folder.close(true);
        }
        catch(Exception e)
        {
            System.out.println("in catch of closeFolder "+e);
        }
    }
    public ArrayList getMessageList()
    {
        return inboxList;
    }
    public ArrayList getSpamMessageList()
    {
        return spamMessageList;
    }
}
