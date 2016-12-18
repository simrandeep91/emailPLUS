/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * UserPersonalReport.java
 *
 * Created on 7 Jul, 2011, 10:45:45 AM
 */

package emailplus;

import emailplus.operations.DBOperations;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.JTable;
import emailplus.report.JasperReportGenerator;
import emailplus.operations.UserPersonalDetailBean;

/**
 *
 * @author Vishal
 */
public class UserPersonalReport extends javax.swing.JFrame {

    /** Creates new form UserPersonalReport */
    DBOperations obj=null;
    ArrayList al=null;
    public UserPersonalReport() {
        initComponents();
        obj=new DBOperations();
        al=obj.getAllUserPersonalDetail();
        generateTable();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(Toolkit.getDefaultToolkit().getScreenSize());
    }
    public void generateTable()
    {
        String header[]={"User ID","Name","Date Of Birth","Address","Mobile","Phone","Email"};
        Object data[][]=new Object[al.size()][7];
        for(int i=0;i<al.size();i++)
        {
            UserPersonalDetailBean objBean=(UserPersonalDetailBean)al.get(i);
            data[i][0]=objBean.getUserId();
            data[i][1]=objBean.getName();
            data[i][2]=objBean.getDate();
            data[i][3]=objBean.getAddress();
            data[i][4]=objBean.getMobile();
            data[i][5]=objBean.getPhone();
            data[i][6]=objBean.getEmail();
        }
        UserPersonalTable=new JTable(data,header);
        jScrollPane.setViewportView(UserPersonalTable);
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
        jScrollPane = new javax.swing.JScrollPane();
        UserPersonalTable = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        miPrint = new javax.swing.JMenuItem();
        miExit = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 20));
        jLabel1.setText("User Personal Detail Report");

        UserPersonalTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "User ID", "Name", "Date Of Birth", "Address", "Mobile", "Phone", "Email"
            }
        ));
        jScrollPane.setViewportView(UserPersonalTable);

        jMenu1.setText("File");

        miPrint.setText("Print");
        miPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miPrintActionPerformed(evt);
            }
        });
        jMenu1.add(miPrint);

        miExit.setText("Exit");
        miExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miExitActionPerformed(evt);
            }
        });
        jMenu1.add(miExit);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 775, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(231, 231, 231)
                        .addComponent(jLabel1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 523, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void miPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miPrintActionPerformed
        // TODO add your handling code here:
        String path=getClass().getResource("../emailplus/report/userpersonalreport.jrxml").getPath();
        JasperReportGenerator obj2=new JasperReportGenerator(path);
    }//GEN-LAST:event_miPrintActionPerformed

    private void miExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miExitActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_miExitActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserPersonalReport().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable UserPersonalTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JMenuItem miExit;
    private javax.swing.JMenuItem miPrint;
    // End of variables declaration//GEN-END:variables

}
