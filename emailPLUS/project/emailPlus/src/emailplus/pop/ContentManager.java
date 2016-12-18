/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package emailplus.pop;

import java.io.InputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import javax.mail.Flags.Flag;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Part;

/**
 *
 * @author Vishal
 */
public class ContentManager {
    ArrayList partList=null;   //hold list of bodyparts that have file attached with them
    ArrayList fileNameList=null;  //hold names of attached filenames
    //static boolean openFlag=false;
    public ContentManager()
    {
        //partList=new ArrayList();
        //fileNameList=new ArrayList();
    }
    public void getMessageContent(MessageHeader mh,int count)
    {
        String content="";
        partList=new ArrayList();
        fileNameList=new ArrayList();
        try
        {
            //System.out.println(SimpleReceiver.openFlag);
            if(!SimpleReceiver.openFlag)
                SimpleReceiver.folder.open(Folder.READ_ONLY);
            //SimpleReceiver.msgcount=SimpleReceiver.folder.getMessageCount();
            //System.out.println(SimpleReceiver.msgcount);
            Message msg=SimpleReceiver.folder.getMessage(count);
            content=getPartContent(msg);
            mh.setFileNameList(fileNameList);
            mh.setPartList(partList);
            mh.setMessageContent(content);
            SimpleReceiver.openFlag=true;
            
        }
        catch(Exception e)
        {
            System.out.println("in catch of getMessagecontent "+e);
        }
        
    }
    private String getPartContent(Part p)
    {
        String content="";
        String filename;
        try
        {
            Object obj=p.getContent();
            if(p.isMimeType("text/plain"))
            {
                filename=p.getFileName();
                if(filename!=null)
                {
                    partList.add(p);
                    fileNameList.add(p.getFileName());
                }
                else
                    content+=(String)obj;
            }
            else if(obj instanceof Multipart)
            {
                Multipart mp=(Multipart)obj;
                for(int i=0;i<mp.getCount();i++)
                    content+=getPartContent(mp.getBodyPart(i));
            }
            else if(obj instanceof InputStream)
            {
                partList.add(p);
                fileNameList.add(p.getFileName());
                
                /*InputStream ip=(InputStream)obj;
                byte[] b=new byte[8];
                int i=ip.read(b);
                while(i!=-1)
                {
                    content+=b.toString();
                    i=ip.read(b);
                }*/
            }
        }
        catch(Exception e)
        {
            System.out.println("in catch of getPartContent "+e);
            return content;
        }
        return content;
    }
    public String downloadFile(Part p,String path) 
	{
            FileOutputStream fout=null;
            InputStream ip=null;
            String result="failed";
		try
		{
                    Object obj=p.getContent();
                    if(p.isMimeType("text/plain"))
                    {
                        String content=(String)obj;
                        fout=new FileOutputStream(path);
                        fout.write(content.getBytes());
                    }
                    //String filename=p.getFileName();
                    //System.out.println(filename);
                    //String path="C:\\Users\\deepika\\Downloads\\"+filename;
                    else
                    {
                        fout=new FileOutputStream(path);
                        ip=(InputStream)obj;
                        byte[] b=new byte[8];
                        int i=ip.read(b);
                        while(i!=-1)
                        {
                            fout.write(b);
                            //content+=b.toString();
                            i=ip.read(b);
                        }  
                    }
                        result="complete";
		}
		catch(Exception e)
		{
			System.out.println("in catch of downloadFile function "+e);
                        return result;
		}
                finally
                {
                    try
                    {
                        if(fout!=null)
                        fout.close();
                        if(ip!=null)
                            ip.close();
                    }
                    catch(Exception e)
                    {
                        System.out.println("in finally of downloadFile "+e);
                        return result;
                    }
                }
                return result;
	}
    
}
