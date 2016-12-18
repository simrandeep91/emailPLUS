package emailplus.pop;

import java.util.Date;

/**
 * This is bean class for message. All the information regarding a mail is 
 * stored as an object of this class. This class only contain setter and getter
 * methods
 */
public class MessageHeader {

    /** Creates a new instance of MessageHeader */
    private String messageId;
    private String messageFrom;
    private String messageSubject;
    private Date messageSentDate;
    private String messageContent;
    private String messageTo;
    private String spamFlag;
    private String seenFlag;
    private String domainName;
    private String senderEmailIdName;  //contains emailid only without domainname like abc in case of abc@yahoo.com

    public MessageHeader() {
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public void setMessageFrom(String messageFrom) {
        this.messageFrom = messageFrom;
    }

    public void setMessageSubject(String messageSubject) {
        this.messageSubject = messageSubject;
    }

    public void setMessageSentDate(Date messageSentDate) {
        this.messageSentDate = messageSentDate;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public String getMessageId() {
        return messageId;
    }

    public String getMessageFrom() {
        return messageFrom;
    }

    public String getMessageSubject() {
        return messageSubject;
    }

    public String getMessageSentDate() {
        return messageSentDate.toString();
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageTo(String messageTo) {
        this.messageTo = messageTo;
    }

    public String getMessageTo() {
        return this.messageTo;
    }

    public void setSpamFlag(String spamFlag) {
        this.spamFlag = spamFlag;
    }

    public String getSpamFlag() {
        return this.spamFlag;
    }

    public void setSeenFlag(String seenFlag) {
        this.seenFlag = seenFlag;
    }

    public String getSeenFlag() {
        return this.seenFlag;
    }

    public void setDomainName(String domainName) {
        this.domainName = domainName;
    }

    public String getDomainName() {
        return this.domainName;
    }

    public void setSenderEmailIdName(String senderEmailIdName) {
        this.senderEmailIdName = senderEmailIdName;
    }

    public String getSenderEmailIdName() {
        return this.senderEmailIdName;
    }

    public Object[] toArray() {
        Object[] data = {this.seenFlag, this.messageFrom, this.messageSubject, this.messageSentDate, this.messageId};
        return data;
    }
}
