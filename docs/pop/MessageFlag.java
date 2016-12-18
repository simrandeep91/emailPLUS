
package emailplus.pop;

public class MessageFlag {
    
    /** Creates a new instance of MessageFlag */
    private String spamFlag;
    private String seenFlag;
    public MessageFlag(String spamFlag,String seenFlag) {
        this.spamFlag=spamFlag;
        this.seenFlag=seenFlag;
    }
    public void setSpamFlag(String spamFlag){
        this.spamFlag=spamFlag;
    }
    public String getSpamFlag(){
        return this.spamFlag;
    }
    public void setSeenFlag(String seenFlag){
        this.seenFlag=seenFlag;
    }
    public String getSeenFlag(){
        return this.seenFlag;
    }
}
