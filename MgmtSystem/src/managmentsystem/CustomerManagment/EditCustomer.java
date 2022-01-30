/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managmentsystem.CustomerManagment;

import managmentsystem.DAOs.CustomerDAO;
import managmentsystem.CustomerManagment.CustomerMgmt;
import managmentsystem.DAOs.EmployeeDAO;
import managmentsystem.EmployeeManagment.EmployeeMgmt;
import managmentsystem.Models.Customer;
import managmentsystem.Models.Employee;
import managmentsystem.Utilities;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import managmentsystem.Models.User;

/**
 *
 * @author DELL
 */
public class EditCustomer extends javax.swing.JFrame {

    /**
     * Creates new form EditCustomer
     */
    public EditCustomer() {
        initComponents();
        
        warning.setVisible(false);
        CustomerDAO cdao = new CustomerDAO();
        
        findbtn.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae){
        
            if(idfield.getText().toString().isEmpty())
            {
                warning.setText("ID input field empty!");
                warning.setVisible(true);
            }
            else if(!Utilities.isInteger(idfield.getText().toString()))
            {
                warning.setText("ID must be numbers only");
                warning.setVisible(true);
            }
            else
            {
                User customer=cdao.getCustomerById(idfield.getText().toString());
                if(customer!=null)
                {
                    fnamefield.setText(customer.getFirstName());
                    lnamefield.setText(customer.getLastName());
                    cnicfield.setText(customer.getCnic());
                    phonefield.setText(customer.getPhone());
                    emailfield.setText(customer.getEmail());
                    addressfield.setText(customer.getAddress());
                }
                else
                {
                    warning.setText("Does not exist!");
                    warning.setVisible(true);
                }
            }
        }
        });
        
        
        finishBtn.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae){
        
            if(fnamefield.getText().toString().isEmpty()
                    || lnamefield.getText().toString().isEmpty()
                    || cnicfield.getText().toString().isEmpty()
                    || phonefield.getText().toString().isEmpty()
                    || emailfield.getText().toString().isEmpty()
                    || addressfield.getText().toString().isEmpty())
            {
                warning.setVisible(true);
                warning.setText("Please fill all input fields");
            }
            else if(!Utilities.isInteger(cnicfield.getText().toString()))
            {
                warning.setText("CNIC must be numbers only");
                warning.setVisible(true);
            }
            else if(!Utilities.validCnic(cnicfield.getText().toString()))
            {
                warning.setText("CNIC length must have 13 digits");
                warning.setVisible(true);
            }
            
            else if(!Utilities.isInteger(phonefield.getText().toString()))
            {
                warning.setText("Phone must be numbers only");
                warning.setVisible(true);
            }
            else if(!Utilities.validPhone(phonefield.getText().toString()))
            {
                warning.setText("Invalid phone number");
                warning.setVisible(true);
            }
            else if(!Utilities.validEmail(emailfield.getText().toString()))
            {
                warning.setText("Invalid email");
                warning.setVisible(true);
            }
            
            else
            {
                Customer customer = new Customer();
                customer.setId(Integer.parseInt(idfield.getText().toString()));
                customer.setFirstName(fnamefield.getText().toString());
                customer.setLastName(lnamefield.getText().toString());
                customer.setCnic(cnicfield.getText().toString());
                customer.setPhone(phonefield.getText().toString());
                customer.setEmail(emailfield.getText().toString());
                customer.setAddress(addressfield.getText().toString());
                
                cdao.editCustomer(customer);
                CustomerMgmt add = new CustomerMgmt();
                add.show();
                dispose(); 
            }
        }
        });
        backbtn.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae){
            CustomerMgmt add = new CustomerMgmt();
            add.show();
            dispose();
      // .... do some operation on value ...
            }
         });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        idfield = new javax.swing.JTextField();
        fnamefield = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        addressfield = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        lnamefield = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        cnicfield = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        emailfield = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        phonefield = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        finishBtn = new javax.swing.JButton();
        backbtn = new javax.swing.JButton();
        findbtn = new javax.swing.JButton();
        warning = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("ID");

        idfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idfieldActionPerformed(evt);
            }
        });

        fnamefield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fnamefieldActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("First Name");

        addressfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addressfieldActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Address");

        lnamefield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lnamefieldActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Last Name");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("CNIC");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Edit Customer");

        cnicfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cnicfieldActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 51, 0));
        jLabel2.setText("(Customer Record with this ID will be updated)");

        emailfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailfieldActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Email");

        phonefield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phonefieldActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Phone");

        finishBtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        finishBtn.setText("FINISH");

        backbtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        backbtn.setText("< Back");

        findbtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        findbtn.setText("FIND");

        warning.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        warning.setForeground(new java.awt.Color(204, 51, 0));
        warning.setText("Alert");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(130, 130, 130)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(74, 74, 74)
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(idfield, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(findbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(fnamefield)
                                                .addComponent(lnamefield)
                                                .addComponent(cnicfield)
                                                .addComponent(emailfield)
                                                .addComponent(phonefield)
                                                .addComponent(addressfield)
                                                .addComponent(finishBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(71, 71, 71)
                                        .addComponent(warning)))))
                        .addGap(0, 35, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(backbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(13, 13, 13)
                .addComponent(findbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(fnamefield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel4)))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lnamefield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cnicfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(phonefield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addressfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(22, 22, 22)
                .addComponent(warning)
                .addGap(18, 18, 18)
                .addComponent(finishBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(backbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void idfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idfieldActionPerformed

    private void fnamefieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fnamefieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fnamefieldActionPerformed

    private void addressfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addressfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addressfieldActionPerformed

    private void lnamefieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lnamefieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lnamefieldActionPerformed

    private void cnicfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cnicfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cnicfieldActionPerformed

    private void emailfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailfieldActionPerformed

    private void phonefieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phonefieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_phonefieldActionPerformed

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
            java.util.logging.Logger.getLogger(EditCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditCustomer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField addressfield;
    private javax.swing.JButton backbtn;
    private javax.swing.JTextField cnicfield;
    private javax.swing.JTextField emailfield;
    private javax.swing.JButton findbtn;
    private javax.swing.JButton finishBtn;
    private javax.swing.JTextField fnamefield;
    private javax.swing.JTextField idfield;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField lnamefield;
    private javax.swing.JTextField phonefield;
    private javax.swing.JLabel warning;
    // End of variables declaration//GEN-END:variables
}
