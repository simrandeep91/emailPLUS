/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package emailplus.operations;

/**
 *
 * @author Simran
 */
public class UserMailBean {
    private int mailid=0;
    private String username="";
    private String from="";
    private String to="";
    private String subject="";
    private String date="";
    private String content="";
    private int configId=0;

    public int getMailid() {
        return mailid;
    }

    public void setMailid(int mailid) {
        this.mailid = mailid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getConfigId() {
        return configId;
    }

    public void setConfigId(int configId) {
        this.configId = configId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }
    

}
