/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package emailplus.pop;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Vishal
 */
public class MessageHeader {
    private int emailId=0;
private String messageId="";
    private String messageFrom="";
    private String messageSubject="";
    private Date messageSentDate;
    private String messageContent="";
    private String messageTo="";
    private boolean spamFlag=false;
    private boolean seenFlag=false;
    private String domainName="";
    private ArrayList fileNameList=null;
    private ArrayList partList=null;
    private String senderEmailIdName="";  //contains emailid only without domainname like abc in case of abc@yahoo.com

    public MessageHeader() {
    }

    public int getEmailId() {
        return emailId;
    }

    public void setEmailId(int emailId) {
        this.emailId = emailId;
    }

    public ArrayList getFileNameList() {
        return fileNameList;
    }

    public ArrayList getPartList() {
        return partList;
    }

    public void setPartList(ArrayList partList) {
        this.partList = partList;
    }

    public void setFileNameList(ArrayList fileNameList) {
        this.fileNameList = fileNameList;
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

    public Date getMessageSentDate() {
        return messageSentDate;
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

    public void setSpamFlag(boolean spamFlag) {
        this.spamFlag = spamFlag;
    }

    public boolean getSpamFlag() {
        return this.spamFlag;
    }

    public void setSeenFlag(boolean seenFlag) {
        this.seenFlag = seenFlag;
    }

    public boolean getSeenFlag() {
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
