/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ConfigureServerClient.java
 *
 * Created on 6 Jul, 2011, 3:18:23 PM
 */

package emailplus;

import emailplus.operations.DBOperations;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import emailplus.operations.ServerClientBean;
import java.awt.Cursor;

/**
 *
 * @author Vishal
 */
public class ConfigureServerClient extends javax.swing.JPanel {

    /** Creates new form ConfigureServerClient */
    DBOperations obj=null;
    ArrayList al=null;
    int count=0;
    String addupdateflag="";
    int userId;
    public ConfigureServerClient() {
        initComponents();
        txtConfigurationId.setEditable(false);
        disable(false);
        btnSave.setEnabled(false);
        userId=MainFrame.userid;
        obj=new DBOperations();
        al=obj.getAllConfigurationDetail();
        if(al.size()>0)
        {
            ServerClientBean objBean=(ServerClientBean)al.get(count);
            showRecords(objBean);
        }
    }
     public void showRecords(ServerClientBean objBean)
    {
        txtConfigurationId.setText(String.valueOf(objBean.getConfigId()));
        txtUsername.setText(objBean.getUsername());
        txtPassword.setText(objBean.getPassword());
        txtSMTPServerAddress.setText(objBean.getSmtpServer());
        txtPOPServerAddress.setText(objBean.getPopServer());
        if(objBean.getConfigId()==1)
            btnDelete.setEnabled(false);
        else
            btnDelete.setEnabled(true);
    }
    public void disable(boolean vol)
    {
        txtUsername.setEditable(vol);
        txtPassword.setEditable(vol);
        txtUsername.setEditable(vol);
        txtSMTPServerAddress.setEnabled(vol);
        txtPOPServerAddress.setEnabled(vol);
    }
    void clear()
    {
        txtUsername.setText("");
        txtPassword.setText("");
         txtSMTPServerAddress.setText("");
        txtPOPServerAddress.setText("");
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtConfigurationId = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtPOPServerAddress = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtSMTPServerAddress = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        btnConnect = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        btnFirst = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnPrevious = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnLast = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 20));
        jLabel1.setText("Configure Server Client");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("SetUp"));

        jLabel2.setText("Configuration ID");

        jLabel3.setText("POP Server Address");

        jLabel4.setText("SMTPServerAddress");

        jLabel5.setText("Username");

        jLabel6.setText("Password");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(txtPOPServerAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addGap(18, 18, 18)
                            .addComponent(txtSMTPServerAddress, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE))
                        .addComponent(jLabel6)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addGap(67, 67, 67)
                            .addComponent(txtUsername, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(37, 37, 37)
                                .addComponent(txtConfigurationId, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(115, 115, 115)
                                .addComponent(txtPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)))))
                .addGap(36, 36, 36))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtConfigurationId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtPOPServerAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtSMTPServerAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        btnConnect.setText("Connect");
        btnConnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConnectActionPerformed(evt);
            }
        });

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnFirst.setText("First");
        btnFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirstActionPerformed(evt);
            }
        });

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnPrevious.setText("Previous");
        btnPrevious.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreviousActionPerformed(evt);
            }
        });

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnNext.setText("Next");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnLast.setText("Last");
        btnLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLastActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(169, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(199, 199, 199))
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnCancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnConnect, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE))
                .addContainerGap(71, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnFirst, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnPrevious, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnNext, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLast, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE))
                .addContainerGap(108, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel1)
                        .addGap(26, 26, 26)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(128, 128, 128)
                        .addComponent(btnConnect)
                        .addGap(34, 34, 34)
                        .addComponent(btnCancel)))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFirst)
                    .addComponent(btnPrevious)
                    .addComponent(btnNext)
                    .addComponent(btnLast))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnUpdate)
                    .addComponent(btnSave)
                    .addComponent(btnDelete))
                .addContainerGap(76, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirstActionPerformed
        // TODO add your handling code here:
         if(al.size()>0)
        {
            count=0;
            ServerClientBean objBean=(ServerClientBean)al.get(count);
            showRecords(objBean);
        }
    }//GEN-LAST:event_btnFirstActionPerformed

    private void btnPreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreviousActionPerformed
        // TODO add your handling code here:
        if(count>0)
        {
            count--;
            ServerClientBean objBean=(ServerClientBean)al.get(count);
            showRecords(objBean);
        }
    }//GEN-LAST:event_btnPreviousActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        // TODO add your handling code here:
        if(count<al.size()-1)
        {
            count++;
            ServerClientBean objBean=(ServerClientBean)al.get(count);
            showRecords(objBean);
        }
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastActionPerformed
        // TODO add your handling code here:
        if(al.size()>0)
        {
            count=al.size()-1;
           ServerClientBean objBean=(ServerClientBean)al.get(count);
            showRecords(objBean);
        }
    }//GEN-LAST:event_btnLastActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        disable(true);
        clear();
        int maxid=obj.getMaxConfigId();
        txtConfigurationId.setText(String.valueOf(maxid+1));
        btnSave.setEnabled(true);
        btnFirst.setEnabled(false);
        btnPrevious.setEnabled(false);
        btnNext.setEnabled(false);
        btnLast.setEnabled(false);
        btnUpdate.setEnabled(false);
        addupdateflag="add";
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        disable(true);
        btnSave.setEnabled(true);
        btnFirst.setEnabled(false);
        btnPrevious.setEnabled(false);
        btnNext.setEnabled(false);
        btnLast.setEnabled(false);
        btnAdd.setEnabled(false);
        addupdateflag="update";
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        String result="";
        int flag=0;
        if(txtUsername.getText().equals("")||txtPassword.getPassword().toString().equals("")||txtSMTPServerAddress.getText().equals("")||txtPOPServerAddress.getText().equals(""))
        {
             JOptionPane.showMessageDialog(this,"No field should be empty","Error",2);
             return;
        }
        ServerClientBean objBean=new ServerClientBean();
        objBean.setConfigId(Integer.parseInt(txtConfigurationId.getText()));
        if(!validateEmail(txtUsername.getText()))
            return;
        objBean.setUsername(txtUsername.getText());
        if(txtPassword.getPassword().length<8)
        {
            JOptionPane.showMessageDialog(this,"password must be of 8 characters","Error",2);
             return;
        }
        objBean.setPassword(new String(txtPassword.getPassword()));
        //System.out.println(txtPassword.getPassword().length);
        if(!validateSmtp(txtSMTPServerAddress.getText()))
        {
            JOptionPane.showMessageDialog(this,"smtp address should of the form smtp.domain_name","Error",2);
             return;
        }
        objBean.setSmtpServer(txtSMTPServerAddress.getText());
        if(!validatePop(txtPOPServerAddress.getText()))
        {
            JOptionPane.showMessageDialog(this,"pop address should of the form pop.domain_name","Error",2);
             return;
        }
        objBean.setPopServer(txtPOPServerAddress.getText());
        objBean.setUserId(userId);
        if (addupdateflag.equals("add"))
        {
            result=obj.addConfigRecord(objBean);
            if(result.equals("failed"))
            {
                JOptionPane.showMessageDialog(this,"Record not added","Error",2);
            }
            else if(result.equals("exits"))
            {
                JOptionPane.showMessageDialog(this,"Username already exits","Error",2);
            }
            else if(result.equals("added"))
            {
                JOptionPane.showMessageDialog(this,"Record added","Message",1);
                flag=1;
                al=obj.getAllConfigurationDetail();
                count=al.size()-1;
                ServerClientBean objbean=(ServerClientBean)al.get(count);
                showRecords(objbean);
            }
        }
        else if(addupdateflag.equals("update"))
        {
            result=obj.updateConfigRecord(objBean);
            if(result.equals("failed"))
            {
                JOptionPane.showMessageDialog(this,"Record not updated","Error",2);
            }
            else if(result.equals("exits"))
            {
                JOptionPane.showMessageDialog(this,"Username already exits","Error",2);
            }
            else if(result.equals("updated"))
            {
                JOptionPane.showMessageDialog(this,"Record updated","Message",1);
                flag=1;
                al=obj.getAllConfigurationDetail();
                 ServerClientBean objbean=(ServerClientBean)al.get(count);
                showRecords(objbean);
            }
        }
        if(flag==1)
        {

            disable(false);
            btnFirst.setEnabled(true);
            btnLast.setEnabled(true);
            btnPrevious.setEnabled(true);
            btnAdd.setEnabled(true);
            btnNext.setEnabled(true);
            btnUpdate.setEnabled(true);
            btnSave.setEnabled(false);

        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        int configid=Integer.parseInt(txtConfigurationId.getText());
        String result=obj.deleteServerRecord(configid);
        if(result.equals("deleted"))
        {
            JOptionPane.showMessageDialog(this, "record deleted", "Message", 1);
            al=obj.getAllConfigurationDetail();
            count=0;
            ServerClientBean objBean=(ServerClientBean)al.get(count);
            showRecords(objBean);
        }
        else
        {
            JOptionPane.showMessageDialog(this, "record not deleted", "Error", 2);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnConnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConnectActionPerformed
        // TODO add your handling code here:
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        int id=Integer.parseInt(txtConfigurationId.getText());
        //new MaintainMailsFrame(id).setVisible(true);
        new MailAccountManager(id).setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnConnectActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
        MainFrame.c.removeAll();
        MainFrame.c.setVisible(false);
        MainFrame.c.setVisible(true);
    }//GEN-LAST:event_btnCancelActionPerformed

    public boolean validateSmtp(String smtp)
    {
        if(smtp.indexOf(".")==-1 || smtp.indexOf(".")==smtp.lastIndexOf(".") ||smtp.indexOf(".")+1==smtp.lastIndexOf("."))
            return false;
        else if(!smtp.startsWith("smtp."))
            return false;
        return true;
    }
    public boolean validatePop(String smtp)
    {
        if(smtp.indexOf(".")==-1 || smtp.indexOf(".")==smtp.lastIndexOf(".") ||smtp.indexOf(".")+1==smtp.lastIndexOf("."))
            return false;
        else if(!smtp.startsWith("pop."))
            return false;
        return true;
    }

    public boolean validateEmail(String emailAddress)
    {

    // a string without a "@" is an invalid email address
        int index=emailAddress.indexOf("@");
    if ( index < 0 || index!=emailAddress.lastIndexOf("@"))
      return false;

    if(index==0 || index==emailAddress.length()-1)
        return false;


    String[] str=emailAddress.split("@");
    for(int i=1;i<str[0].length()-1;i++)
    {
        int j=str[0].codePointAt(i);
        if(!((j>=65 & j<=90) || (j>=97 & j<=122) || (j>=48 & j<=57)))
        {
            if(j==str[0].codePointAt(i+1))
            {
                JOptionPane.showMessageDialog(this,"username cannot contain consective special symbols","Error",2);
                return false;
            }
        }
    }


    if(str[1].indexOf(".")<0)
    {
        JOptionPane.showMessageDialog(this,"in-correct domain name","Error",2);
        return false;
    }
    index=str[1].codePointAt(0);
    if(!(index>=97 & index<=122))
    {
        JOptionPane.showMessageDialog(this,"in-correct domain name","Error",2);
        return false;
    }
    int i=str[1].codePointAt(str[1].length()-1);
    if(!(i>=97 & i<=122))
    {
        JOptionPane.showMessageDialog(this,"in-correct domain name","Error",2);
        return false;
    }
    for(i=1;i<str[1].length()-1;i++)
    {
        int j=str[1].codePointAt(i);
        if(!((j>=65 & j<=90) || (j>=97 & j<=122) || (j>=48 & j<=57)))
        {
            if(j==str[1].codePointAt(i+1))
            {
                JOptionPane.showMessageDialog(this,"in-correct domain name","Error",2);
                return false;
            }
        }
    }

    return true;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnConnect;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnFirst;
    private javax.swing.JButton btnLast;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrevious;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtConfigurationId;
    private javax.swing.JTextField txtPOPServerAddress;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtSMTPServerAddress;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables

}
