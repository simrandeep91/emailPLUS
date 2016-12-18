
package emailplus.pop;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * This class is the MessageServiceProvider class. This class acts as a wrapper
 * for the collection of messages. We have implements collection in this class
 */
public class MessageServiceProvider {
    
    /**
     * Creates a new instance of MessageServiceProvider 
     */
    // List containing all the messages
    List messageList;
    /**
     * constructor initializing the List containing messages
     */
    public MessageServiceProvider() {
        messageList=new ArrayList();
    }
    
    /**
     * "addMessageHeader(MessageHeader)" method used to add message in the List
     */
    public void addMessageHeader(MessageHeader mh){
        messageList.add(mh);
    }
    
    /**
     * "getAllMessages()" method to get All Message data needed to disp
     */
    public Object[][] getAllMessages(){
        int size = messageList.size();        
        Object[][] data=new Object[size][];
        
        Iterator messageItr=messageList.iterator();
        int counter = 0;
        while(messageItr.hasNext()){
            MessageHeader mh=(MessageHeader)messageItr.next();
            data[counter]=mh.toArray();
            counter++;
        }
        return data;
    }
    
    /**
     * "getMessage(String messageId)" methos to get particular message 
     * according to messageId
     */
    public MessageHeader getMessage(String messageId){
        Iterator messageItr=messageList.iterator();
        MessageHeader mh1=new MessageHeader();
        while(messageItr.hasNext()){
            MessageHeader mh=(MessageHeader)messageItr.next();
            if(mh.getMessageId().equals(messageId)){
                mh1=mh;
                break;
            }
        }
        return mh1;
    }

    public List getMessageList()
    {
        return messageList;
    }
}
