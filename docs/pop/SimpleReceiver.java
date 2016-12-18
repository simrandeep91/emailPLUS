package emailplus.pop;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.Map;
import java.util.Properties;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Part;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.InternetAddress;

/**
 * A simple email receiver class.
 */
public class SimpleReceiver {

    /**
     * Main method to receive messages from the mail server specified
     * as command line arguments.
     */
    private static MessageHeader mh;
    public static Map spamFlagsMap;
    public MessageServiceProvider totalMessagesHeader;
    int flag = 1;

    /**
     * "receive" method to fetch messages and process them.
     */
    public MessageServiceProvider receive(String popServer, String popUser, String popPassword) {
        Store store = null;
        Folder folder = null;
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

            System.out.println("The new folder is created " + folder.create(Folder.HOLDS_MESSAGES));


            if (folder == null) {
                throw new Exception("No default folder");
            }
            // -- ...and its INBOX --

            try {
                Folder[] folders = folder.list();
                System.out.println("Total number of folders are = " + folders.length);
                for (int i = 0; i < folders.length; i++) {
                    System.out.println("Folder[" + i + "] is =" + folders[i].getFullName());
                }
            } catch (Exception e) {
                totalMessagesHeader = null;
                flag = 0;
                e.printStackTrace();
            }



            folder = folder.getFolder("INBOX");

            if (folder == null) {
                throw new Exception("No POP3 INBOX");
            }
            // -- Open the folder for read only --
            folder.open(Folder.READ_WRITE);



            int number = folder.getMessageCount();
            System.out.println("Total number of messages in this folder are = " + number);
            // -- Get the message wrappers and process them --
            Message[] msgs = folder.getMessages();

            // Store message in a collection
            totalMessagesHeader = new MessageServiceProvider();
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
            totalMessagesHeader = null;
        }
        return totalMessagesHeader;
    }

    /**
     * "processMessageHeader()" method to process the message header.
     */
    public void processMessageHeader(Message message) {
        try {
            //Get All the headers information in msg

            String senderEmailId = ((InternetAddress) message.getFrom()[0]).getAddress();
            System.out.println("senderEmailId " + senderEmailId);
            String domainName = senderEmailId.substring(senderEmailId.indexOf("@") + 1);
            System.out.println("the from address in process message method is = " + domainName);
            mh = new MessageHeader();
            String from = ((InternetAddress) message.getFrom()[0]).getPersonal();
            if (from == null) {
                from = ((InternetAddress) message.getFrom()[0]).getAddress();
            }

            String messageId = message.getHeader("Message-ID")[0];
            String messageTo = message.getHeader("To")[0];
            String messageSubject = message.getSubject();
            Date messageSentDate = message.getSentDate();
            String messageContent = new String();
            Part messagePart = message;

            String fromIP = messagePart.getHeader("Received")[0];
            // System.out.println("The IP of machine Received from : "+fromIP.substring(fromIP.indexOf("[")+1,fromIP.indexOf("]"))+"\n");
            Object content = messagePart.getContent();
            // -- or its first body part if it is a multipart message --
            if (content instanceof Multipart) {
                messagePart = ((Multipart) content).getBodyPart(0);
            }
            System.out.println("[ Multipart Message ]");
            // -- Get the content type --
            String contentType = messagePart.getContentType();
            // -- If the content is plain text, we can print it --
            System.out.println("CONTENT:" + contentType);
            if (contentType.startsWith("text/plain") || contentType.startsWith("text/html")) {
                InputStream is = messagePart.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(is));
                String thisLine = reader.readLine();
                while (thisLine != null) {
                    messageContent += "\n" + thisLine;
                    thisLine = reader.readLine();
                }
            }
            mh.setMessageFrom(from);
            mh.setMessageId(messageId);
            mh.setMessageSubject(messageSubject);
            mh.setMessageSentDate(messageSentDate);
            mh.setMessageContent(messageContent);
            mh.setMessageTo(messageTo);
            mh.setDomainName(domainName);
            mh.setSenderEmailIdName(senderEmailId);
            System.out.println("before adding to vector = " + messageSubject);
            totalMessagesHeader.addMessageHeader(mh);


        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}