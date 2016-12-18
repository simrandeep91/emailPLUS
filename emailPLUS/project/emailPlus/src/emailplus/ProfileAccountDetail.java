/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ProfileAccountDetail.java
 *
 * Created on 6 Jul, 2011, 2:42:02 PM
 */

package emailplus;

import emailplus.operations.DBOperations;
import emailplus.operations.UsermasterBean;
import javax.swing.JOptionPane;

/**
 *
 * @author Vishal
 */
public class ProfileAccountDetail extends javax.swing.JPanel {

    /** Creates new form ProfileAccountDetail */
    DBOperations obj=null;
    int userid;
    public ProfileAccountDetail() {
        initComponents();
        btnSave.setEnabled(false);
        txtUserId.setEditable(false);
        userid=MainFrame.userid;
        obj=new DBOperations();
        UsermasterBean objBean=new UsermasterBean();
        objBean=obj.getAllProfileAccountDetail(userid);
        disable(false);
        showProfileDetail(objBean);
    }
    public void disable(boolean flag)
    {
        
        txtUsername.setEditable(flag);
        txtPassword.setEditable(flag);
        ddlSecurityQuestion.setEnabled(flag);
        txtSecurityAnswer.setEditable(flag);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    public void showProfileDetail(UsermasterBean objBean)
    {
        txtUserId.setText(String.valueOf(objBean.getUserId()));
        txtUsername.setText(objBean.getUsername());
        txtPassword.setText(objBean.getPassword());
        ddlSecurityQuestion.setSelectedItem(objBean.getSecurityQuestion());
        txtSecurityAnswer.setText(objBean.getSecurityAnswer());
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtUserId = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        ddlSecurityQuestion = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        txtSecurityAnswer = new javax.swing.JTextField();
        btnUpdate = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setPreferredSize(new java.awt.Dimension(600, 600));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 20));
        jLabel1.setText("Profile Account Detail");

        jLabel2.setText("User ID");

        jLabel3.setText("Username");

        jLabel4.setText("Password");

        jLabel5.setText("Security Question");

        ddlSecurityQuestion.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "What is your first school name?", "your favourite color?", "What is your hobby?" }));

        jLabel6.setText("Security Answer");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(141, 141, 141)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5))
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtUserId, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(ddlSecurityQuestion, javax.swing.GroupLayout.Alignment.LEADING, 0, 184, Short.MAX_VALUE)
                            .addComponent(txtUsername, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                            .addComponent(txtSecurityAnswer, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                            .addComponent(txtPassword, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE))
                        .addGap(128, 128, 128))))
            .addGroup(layout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(79, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(177, 177, 177)
                .addComponent(jLabel1)
                .addContainerGap(202, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUserId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(ddlSecurityQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtSecurityAnswer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(75, 75, 75)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUpdate)
                    .addComponent(btnCancel)
                    .addComponent(btnSave))
                .addContainerGap(123, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        disable(true);
        btnSave.setEnabled(true);
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        String result="";
        int flag=0;
        if(txtUsername.getText().equals("")||txtPassword.getPassword().toString().equals("")||txtSecurityAnswer.getText().equals(""))
        {
             JOptionPane.showMessageDialog(this,"No field should be empty","Error",2);
             return;
        }
        UsermasterBean objBean=new UsermasterBean();
        objBean.setUserId(Integer.parseInt(txtUserId.getText()));
        int i=txtUsername.getText().codePointAt(0);
        if(!((i>=65 & i<=90)||(i>=97 & i<=122)))
        {
            JOptionPane.showMessageDialog(this,"First character of username should be alphabet","Error",2);
            return;
        }
        objBean.setUsername(txtUsername.getText());
        if(txtPassword.getPassword().length<8)
        {
            JOptionPane.showMessageDialog(this,"password must be of 8 characters","Error",2);
             return;
        }
        objBean.setPassword(new String(txtPassword.getPassword()));
        objBean.setSecurityAnswer(txtSecurityAnswer.getText());
        objBean.setSecurityQuestion(ddlSecurityQuestion.getSelectedItem().toString());
        result=obj.updateProfileRecord(objBean);
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
            }
        if(flag==1)
        {
            disable(false);
            btnSave.setEnabled(false);

        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
        MainFrame.c.removeAll();
        MainFrame.c.setVisible(false);
        MainFrame.c.setVisible(true);
    }//GEN-LAST:event_btnCancelActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox ddlSecurityQuestion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtSecurityAnswer;
    private javax.swing.JTextField txtUserId;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables

}
