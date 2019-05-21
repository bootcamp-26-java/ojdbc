/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import controllers.JobHistoryController;
import daos.JobHistoryDAO;
import icontrollers.IJobHistoryController;
import idaos.IJobHistoryDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.JobHistory;
import tools.DBConnection;

/**
 *
 * @author WINDOWS 10
 */
public class JobHistoryView extends javax.swing.JFrame {
    DefaultTableModel model = new DefaultTableModel();
//    private IJobHistoryDAO data = new JobHistoryDAO(connection);
//    private JobHistory jobs;
    DBConnection connection = new DBConnection();
    IJobHistoryController ijc = new JobHistoryController(connection.getConnection());




    /**
     * Creates new form RegionView
     */
    
    
    public JobHistoryView() {
        initComponents();

        tblJob.setModel(model);
        model.addColumn("Employee ID");
        model.addColumn("Start Date");
        model.addColumn("End Date");
        model.addColumn("JOB ID");
        model.addColumn("Department ID");
        
        getData();
                
    }
    
    public  void getData(){
        DefaultTableModel model = (DefaultTableModel) tblJob.getModel();
        Object[] row = new Object[5];
        List<JobHistory> jobHistory = new ArrayList<>();
        jobHistory = ijc.getAll();
        for (int i = 0; i < jobHistory.size(); i++) {
            row[0] = jobHistory.get(i).getEmployee_id();
            row[1] = jobHistory.get(i).getStart_date();
            row[2] = jobHistory.get(i).getEnd_date();
            row[3] = jobHistory.get(i).getJob_id();
            row[4] = jobHistory.get(i).getDepartment_id();
            model.addRow(row);
        }      
    }
    public void getData(String key){
        DefaultTableModel model = (DefaultTableModel) tblJob.getModel();
        Object[] row = new Object[5];
        List<JobHistory> jobHistory = new ArrayList<>();
        jobHistory = ijc.search(key);
        for (int i = 0; i < jobHistory.size(); i++) {
            row[0] = jobHistory.get(i).getEmployee_id();
            row[1] = jobHistory.get(i).getStart_date();
            row[2] = jobHistory.get(i).getEnd_date();
            row[3] = jobHistory.get(i).getJob_id();
            row[4] = jobHistory.get(i).getDepartment_id();
            model.addRow(row);
        } 
}
        public void UpdateTabel() {
        DefaultTableModel model = (DefaultTableModel) tblJob.getModel();
        model.setRowCount(0);
        getData();
    }
        public void UpdateTabel(String key){
            DefaultTableModel model = (DefaultTableModel) tblJob.getModel();
    model.setRowCount(0);
        if (key == "") {
            getData();
        }
        getData(key);
    }
                public void resetText() {
        jEmployee.setText("");
        jStart.setDate(null);
        jEnd.setDate(null);
        jJob.setText("");
        jDepartment.setText("");
        jInsert.setEnabled(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jEmployee = new javax.swing.JTextField();
        jJob = new javax.swing.JTextField();
        jDepartment = new javax.swing.JTextField();
        jCariF = new javax.swing.JTextField();
        jCari = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblJob = new javax.swing.JTable();
        jInsert = new javax.swing.JButton();
        jDelete = new javax.swing.JButton();
        jUpdate = new javax.swing.JButton();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        tbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tbl);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 255, 204));
        setForeground(new java.awt.Color(0, 255, 204));

        jLabel1.setFont(new java.awt.Font("Sylfaen", 1, 18)); // NOI18N
        jLabel1.setText("Insert New Job History");

        jLabel2.setText("Employee ID");

        jLabel3.setText("Start Date");

        jLabel4.setText("End Date");

        jLabel5.setText("Job ID");

        jLabel6.setText("Department ID");

        jEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jEmployeeActionPerformed(evt);
            }
        });

        jCariF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCariFActionPerformed(evt);
            }
        });
        jCariF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jCariFKeyTyped(evt);
            }
        });

        jCari.setText("CARI");
        jCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCariActionPerformed(evt);
            }
        });

        tblJob.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Employee ID", "Start Date", "End Date", "Job ID", "Department ID"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblJob.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblJobMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblJob);
        if (tblJob.getColumnModel().getColumnCount() > 0) {
            tblJob.getColumnModel().getColumn(0).setHeaderValue("Employee ID");
            tblJob.getColumnModel().getColumn(1).setHeaderValue("Start Date");
            tblJob.getColumnModel().getColumn(2).setHeaderValue("End Date");
            tblJob.getColumnModel().getColumn(3).setHeaderValue("Job ID");
            tblJob.getColumnModel().getColumn(4).setHeaderValue("Department ID");
        }

        jInsert.setText("Insert");
        jInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jInsertActionPerformed(evt);
            }
        });

        jDelete.setText("Delete");
        jDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jDeleteActionPerformed(evt);
            }
        });

        jUpdate.setText("Update");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(118, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(135, 135, 135))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jEmployee, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                            .addComponent(jJob)
                            .addComponent(jDepartment)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(jUpdate)
                        .addGap(18, 18, 18)
                        .addComponent(jInsert)
                        .addGap(28, 28, 28)
                        .addComponent(jDelete)))
                .addContainerGap(120, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(jCariF, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jCari)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addComponent(jLabel3)
                .addGap(20, 20, 20)
                .addComponent(jLabel4)
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jJob, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jDepartment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jInsert)
                    .addComponent(jDelete)
                    .addComponent(jUpdate))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCariF, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCari, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jEmployeeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jEmployeeActionPerformed

    private void jCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCariActionPerformed
//        // TODO add your handling code here: 

    }//GEN-LAST:event_jCariActionPerformed

    private void jCariFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCariFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCariFActionPerformed

    private void jInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jInsertActionPerformed
        // TODO add your handling code here:
        IJobHistoryDAO ijob = new JobHistoryDAO(connection.getConnection());
        JobHistoryView jobHistoryView = new JobHistoryView();
        int employee_id = Integer.parseInt(jEmployee.getText());
        String Start_date = jStart.getDateFormatString();
        String End_date = jEnd.getDateFormatString();
        String Job_id = jJob.getText();
        int department_id = Integer.parseInt(jDepartment.getText());
        
        JobHistory jobHistory = new JobHistory();
        jobHistory.setEmployee_id(employee_id);
        jobHistory.setStart_date(Start_date);
        jobHistory.setEnd_date(End_date);
        jobHistory.setJob_id(Job_id);
        jobHistory.setDepartment_id(department_id);
        
        ijob.insert(jobHistory);
    }//GEN-LAST:event_jInsertActionPerformed

    private void jStartPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jStartPropertyChange
        // TODO add your handling code here:
        jStart.setDateFormatString("dd-m-yyyy");
    }//GEN-LAST:event_jStartPropertyChange

    private void jCariFKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCariFKeyTyped
        UpdateTabel(jCariF.getText());
    }//GEN-LAST:event_jCariFKeyTyped

    private void tblJobMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblJobMouseClicked
        DefaultTableModel model = (DefaultTableModel) tblJob.getModel();
        int SelectRowIndex = tblJob.getSelectedRow();
        
        jInsert.setEnabled(false);
        jEmployee.setText(model.getValueAt(SelectRowIndex, 0).toString());
        jStart.setDateFormatString(model.getValueAt(SelectRowIndex, 1).toString());
        jEnd.setDateFormatString(model.getValueAt(SelectRowIndex, 2).toString());
        jJob.setText(model.getValueAt(SelectRowIndex, 3).toString());
        jDepartment.setText(model.getValueAt(SelectRowIndex, 4).toString());
    }//GEN-LAST:event_tblJobMouseClicked

    private void jDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jDeleteActionPerformed
        int confirm = JOptionPane.showConfirmDialog(this, "Kamu yakin mau menghapus data?", "Konfirmasi", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (confirm == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null, ijc.delete(Integer.parseInt(jEmployee.getText())));
            UpdateTabel();
            resetText();
        }
    }//GEN-LAST:event_jDeleteActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JobHistoryView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JobHistoryView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JobHistoryView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JobHistoryView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        
        DBConnection connection = new DBConnection();
        System.out.println(connection.getConnection());
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JobHistoryView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jCari;
    private javax.swing.JTextField jCariF;
    private javax.swing.JButton jDelete;
    private javax.swing.JTextField jDepartment;
    private javax.swing.JTextField jEmployee;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JButton jInsert;
    private javax.swing.JTextField jJob;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton jUpdate;
    public static javax.swing.JTable tbl;
    public static javax.swing.JTable tblJob;
    // End of variables declaration//GEN-END:variables
}
