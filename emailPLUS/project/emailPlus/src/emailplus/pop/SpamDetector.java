/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package emailplus.pop;

import javax.mail.Address;
import javax.mail.Message;

/**
 *
 * @author deepika
 */
public class SpamDetector {
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
            if(toadd==null)
            {
                spamflag+=.34;
            }

            //[--check both field empty or not
            if(toadd==null & ccadd==null)
            {
                spamflag+=.34+.64;
            }

           //[--check receipient-address in TO or CC field
            int i=0,j=0,f=0;
                while(i<toLen || j<ccLen)
                {
                    if(toadd!=null && radd.equals(toadd[i].toString()))
                    {
                        f=1;
                        break;
                    }
                    if(ccadd!=null && radd.equals(ccadd[j].toString()))
                    {
                        f=1;
                        break;
                    }
                    if(i<toLen)
                    i++;
                    if(j<ccLen)
                    j++;
                }
                if(f==1)
                    spamflag+=.64;


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
            if(msg.getRecipients(Message.RecipientType.BCC)!=null)
            {
                spamflag+=.02;
            }

            //[--check if message-ID field exits
            if(msg.getHeader("Message-ID")==null)
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
                i=Integer.parseInt(str[0]);
                if(i==1)
                    spamflag+=.02;
            }

            //[--net evalution
            if(spamflag>=.90)
                fl=true;
        }
        catch(Exception e)
        {
                System.out.println("in isSpamMessage function "+e);
                return fl;
        }
        return fl;
    }

}
