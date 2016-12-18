/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ProfilePersonalDetail.java
 *
 * Created on 6 Jul, 2011, 2:53:29 PM
 */

package emailplus;

import emailplus.operations.DBOperations;
import javax.swing.JOptionPane;
import emailplus.operations.UserPersonalDetailBean;

/**
 *
 * @author Vishal
 */
public class ProfilePersonalDetail extends javax.swing.JPanel {

    /** Creates new form ProfilePersonalDetail */
    int userid;
    DBOperations obj=null;
    public ProfilePersonalDetail() {
        initComponents();
        disable(false);
         txtUserId.setEditable(false);
        btnSave.setEnabled(false);
        userid=MainFrame.userid;
        obj=new DBOperations();
        UserPersonalDetailBean objBean=new  UserPersonalDetailBean();
        objBean=obj.getAllPersonalRecord(userid);
        showRecord(objBean);
    }
    void disable(boolean flag)
    {
       
        txtName.setEditable(flag);
        txtDateOfBirth.setEditable(flag);
        txtAddress.setEditable(flag);
        txtPhone.setEditable(flag);
        txtMobile.setEditable(flag);
        txtEmail.setEditable(flag);
    }
    public void showRecord(UserPersonalDetailBean objBean)
    {
        txtUserId.setText(String.valueOf(objBean.getUserId()));
        txtName.setText(objBean.getName());
        txtDateOfBirth.setText(objBean.getDate());
        txtAddress.setText(objBean.getAddress());
        txtPhone.setText(objBean.getPhone());
        txtMobile.setText(objBean.getMobile());
        txtEmail.setText(objBean.getEmail());
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
        jLabel2 = new javax.swing.JLabel();
        txtUserId = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtDateOfBirth = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAddress = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        txtPhone = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtMobile = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        btnUpdate = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setPreferredSize(new java.awt.Dimension(600, 600));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 20));
        jLabel1.setText("Profile Personal Detail");

        jLabel2.setText("User ID");

        jLabel3.setText("Name");

        jLabel4.setText("Date Of Birth");

        jLabel5.setText("Address");

        txtAddress.setColumns(20);
        txtAddress.setRows(5);
        jScrollPane1.setViewportView(txtAddress);

        jLabel6.setText("Phone");

        jLabel7.setText("Mobile");

        jLabel8.setText("Email");

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        jLabel9.setText("(YYYY-MM-DD)");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel4)
                        .addComponent(jLabel8)
                        .addComponent(jLabel7)
                        .addComponent(jLabel6)
                        .addComponent(jLabel5)
                        .addComponent(jLabel3)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtName, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
                            .addComponent(txtPhone, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
                            .addComponent(txtMobile, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
                            .addComponent(txtUserId, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtDateOfBirth, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel9))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(97, 97, 97))
            .addGroup(layout.createSequentialGroup()
                .addGap(178, 178, 178)
                .addComponent(jLabel1)
                .addContainerGap(196, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtUserId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtDateOfBirth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtMobile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancel)
                    .addComponent(btnUpdate)
                    .addComponent(btnSave))
                .addGap(65, 65, 65))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
        MainFrame.c.removeAll();
        MainFrame.c.setVisible(false);
        MainFrame.c.setVisible(true);
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        disable(true);
        btnSave.setEnabled(true);
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        String result="";
        int flag=0;
        if(txtName.getText().equals("")||txtDateOfBirth.getText().equals("")||txtAddress.getText().equals("")||txtMobile.getText().equals("")||txtPhone.getText().equals("")||txtEmail.getText().equals(""))
        {
            JOptionPane.showMessageDialog(this,"No field should be empty","Error",2);
            return;
        }
        UserPersonalDetailBean objBean=new UserPersonalDetailBean();
        objBean.setUserId(Integer.parseInt(txtUserId.getText()));
        objBean.setDate(txtDateOfBirth.getText());
        if(txtName.getText().charAt(0)==' ')
        {
            JOptionPane.showMessageDialog(this,"first character of Name cannot be a space","Error",2);
                return;
        }
        for(int i=0;i<txtName.getText().length();i++)
        {
            int j=txtName.getText().codePointAt(i);
            char ch=txtName.getText().charAt(i);
            if(!((j>=65 & j<=90)||(j>=97 & j<=122) || ch==' '))
            {
                JOptionPane.showMessageDialog(this,"Name can have only alphabets or space character","Error",2);
                return;
            }
        }
        objBean.setName(txtName.getText());
        objBean.setAddress(txtAddress.getText());
        for(int i=0;i<txtPhone.getText().length();i++)
        {
            int j=txtPhone.getText().codePointAt(i);
            if(!(j>=48 & j<=57))
            {
                JOptionPane.showMessageDialog(this,"Phone number must contain only numerics","Error",2);
                return;
            }
        }
        objBean.setPhone(txtPhone.getText());
        for(int i=0;i<txtMobile.getText().length();i++)
        {
            int j=txtMobile.getText().codePointAt(i);
            if(!(j>=48 & j<=57))
            {
                JOptionPane.showMessageDialog(this,"Mobile number must contain only numerics","Error",2);
                return;
            }
        }
        objBean.setMobile(txtMobile.getText());
        if(!validateEmail(txtEmail.getText()))
        {
                return;
        }
        objBean.setEmail(txtEmail.getText());
        result=obj.updatePersonalRecord(objBean);
        if(result.equals("failed"))
        {
                JOptionPane.showMessageDialog(this,"Record not updated","Error",2);
         }
            else if(result.equals("updated"))
            {
                JOptionPane.showMessageDialog(this,"Record updated","Message",1);
                flag=1;
            }
        if(flag==1)
        {
            disable(false);
            btnSave.setEnabled(false);

        }
    }//GEN-LAST:event_btnSaveActionPerformed

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
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtAddress;
    private javax.swing.JTextField txtDateOfBirth;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtMobile;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtUserId;
    // End of variables declaration//GEN-END:variables

}
