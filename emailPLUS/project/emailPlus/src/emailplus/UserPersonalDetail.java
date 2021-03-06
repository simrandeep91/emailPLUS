/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * UserPersonalDetail.java
 *
 * Created on 6 Jul, 2011, 3:06:44 PM
 */

package emailplus;

import emailplus.operations.DBOperations;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import emailplus.operations.UserPersonalDetailBean;

/**
 *
 * @author Vishal
 */
public class UserPersonalDetail extends javax.swing.JPanel {

    /** Creates new form UserPersonalDetail */
    int count=0;
    DBOperations obj=null;
    ArrayList al=null;
    public UserPersonalDetail() {
        initComponents();
        disable(false);
        txtUserId.setEditable(false);
        btnSave.setEnabled(false);
        al=new ArrayList();
        obj=new DBOperations();
        al=obj.getAllUserPersonalDetail();
        if(al.size()>0)
        {
           UserPersonalDetailBean objBean=(UserPersonalDetailBean)al.get(count);
           showRecords(objBean);
        }
    }
    public UserPersonalDetail(int count) {
        initComponents();
        txtUserId.setEditable(false);
        disable(false);
        btnSave.setEnabled(false);
        this.count=count;
        obj=new DBOperations();
        al=obj.getAllUserPersonalDetail();
        if(al.size()>0)
        {
           UserPersonalDetailBean objBean=(UserPersonalDetailBean)al.get(count);
           showRecords(objBean);
        }
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
    public void showRecords(UserPersonalDetailBean objBean)
    {
        txtUserId.setText(String.valueOf(objBean.getUserId()));
        txtName.setText(objBean.getName());
        txtDateOfBirth.setText(objBean.getDate());
        txtAddress.setText(objBean.getAddress());
        txtPhone.setText(objBean.getPhone());
        txtMobile.setText(objBean.getMobile());
        txtEmail.setText(objBean.getEmail());
    }
    void clear()
    {
        txtName.setText("");
        txtDateOfBirth.setText("");
        txtAddress.setText("");
        txtPhone.setText("");
        txtMobile.setText("");
        txtEmail.setText("");
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
        btnFirst = new javax.swing.JButton();
        btnPrevious = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnLast = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        btnAccountDetail = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 20));
        jLabel1.setText("User Personal Detail");

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

        btnFirst.setText("First");
        btnFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirstActionPerformed(evt);
            }
        });

        btnPrevious.setText("Previous");
        btnPrevious.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreviousActionPerformed(evt);
            }
        });

        btnNext.setText("Next");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnLast.setText("Last");
        btnLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLastActionPerformed(evt);
            }
        });

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

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

        btnAccountDetail.setText("Account Detail");
        btnAccountDetail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAccountDetailActionPerformed(evt);
            }
        });

        jLabel9.setText("(YYYY-MM-DD)");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(57, 57, 57)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtUserId, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnAccountDetail, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnNext, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE))
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnCancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnLast, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
                                .addComponent(txtMobile, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
                                .addComponent(txtEmail, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
                                .addComponent(txtPhone, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(txtDateOfBirth, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel9)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnFirst, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE))
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnPrevious, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(183, 183, 183)
                        .addComponent(jLabel1)))
                .addContainerGap(99, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtUserId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAccountDetail))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDateOfBirth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel9))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtMobile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFirst)
                    .addComponent(btnPrevious)
                    .addComponent(btnLast)
                    .addComponent(btnNext))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnUpdate)
                    .addComponent(btnCancel)
                    .addComponent(btnSave))
                .addContainerGap(50, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirstActionPerformed
        // TODO add your handling code here:
        if(al.size()>0)
        {
            count=0;
            UserPersonalDetailBean objBean=(UserPersonalDetailBean)al.get(count);
            showRecords(objBean);
        }
    }//GEN-LAST:event_btnFirstActionPerformed

    private void btnPreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreviousActionPerformed
        // TODO add your handling code here:
        if(count>0)
        {
            count--;
            UserPersonalDetailBean objBean=(UserPersonalDetailBean)al.get(count);
            showRecords(objBean);
        }
    }//GEN-LAST:event_btnPreviousActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        // TODO add your handling code here:
         if(count<al.size()-1)
        {
            count++;
            UserPersonalDetailBean objBean=(UserPersonalDetailBean)al.get(count);
            showRecords(objBean);
        }
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastActionPerformed
        // TODO add your handling code here:
        if(al.size()>0)
        {
            count=al.size()-1;
            UserPersonalDetailBean objBean=(UserPersonalDetailBean)al.get(count);
            showRecords(objBean);
        }
    }//GEN-LAST:event_btnLastActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
        MainFrame.c.removeAll();
        MainFrame.c.setVisible(false);
        MainFrame.c.setVisible(true);
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        MainFrame.c.removeAll();
        UserAcountDetail act=new UserAcountDetail();
        act.addAction();
        act.setBounds(170,50,600,600);
        MainFrame.c.add(act);
        MainFrame.c.setVisible(false);
        MainFrame.c.setVisible(true);
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
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here
        String result="";
        int flag=0;
        if(txtName.getText().equals("")||txtDateOfBirth.getText().equals("")||txtAddress.getText().equals("")||txtMobile.getText().equals("")||txtPhone.getText().equals("")||txtEmail.getText().equals(""))
        {
            JOptionPane.showMessageDialog(this,"No field should be empty","Error",2);
            return;
        }
        UserPersonalDetailBean objBean=new UserPersonalDetailBean();
        objBean.setUserId(Integer.parseInt(txtUserId.getText()));

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

        objBean.setDate(txtDateOfBirth.getText());

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
                al=obj.getAllUserPersonalDetail();
               UserPersonalDetailBean objbean=(UserPersonalDetailBean)al.get(count);
                showRecords(objbean);
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
    }//GEN-LAST:event_btnSaveActionPerformed
    }
        private void btnAccountDetailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAccountDetailActionPerformed
            // TODO add your handling code here:
            MainFrame.c.removeAll();
        UserAcountDetail ad=new UserAcountDetail(count);
        ad.setBounds(170,50,600, 600);
        MainFrame.c.add(ad);
        MainFrame.c.setVisible(false);
        MainFrame.c.setVisible(true);
        }//GEN-LAST:event_btnAccountDetailActionPerformed

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
    private javax.swing.JButton btnAccountDetail;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCancel;
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
