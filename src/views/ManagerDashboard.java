/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import java.awt.Color;
import javax.swing.JOptionPane;

/**
 *
 * @author Anaclita
 */
public class ManagerDashboard extends javax.swing.JFrame {

    /**
     * Creates new form AdminDashboard
     */
    Color DefaultColor,ClickedColor;
    
    
    
    public ManagerDashboard(String name) {
        initComponents();
        labelManagerName.setText(name);
        mainPane.add(new ManagerDashboardPanel()).setVisible(true);
        
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        
        DefaultColor=new Color(25,118,211);
        ClickedColor=new Color (255,255,255);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        DashName = new javax.swing.JLabel();
        logo = new javax.swing.JLabel();
        labelManagerName = new javax.swing.JLabel();
        btnLogout = new javax.swing.JButton();
        labelManagerName1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        Transactions = new javax.swing.JPanel();
        transactionsLabel = new javax.swing.JLabel();
        Customers = new javax.swing.JPanel();
        customersLabel = new javax.swing.JLabel();
        Products = new javax.swing.JPanel();
        productsLabel = new javax.swing.JLabel();
        mainPane = new javax.swing.JDesktopPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(25, 118, 211));

        DashName.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        DashName.setForeground(new java.awt.Color(255, 255, 255));
        DashName.setText("Nackingspol Water Refilling Station");
        DashName.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DashName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DashNameMouseClicked(evt);
            }
        });

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/smallLogo.jpg"))); // NOI18N
        logo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        logo.setIconTextGap(0);
        logo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoMouseClicked(evt);
            }
        });

        labelManagerName.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        labelManagerName.setForeground(new java.awt.Color(255, 255, 255));
        labelManagerName.setText("MANAGER");

        btnLogout.setBackground(new java.awt.Color(255, 255, 0));
        btnLogout.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btnLogout.setForeground(new java.awt.Color(25, 118, 211));
        btnLogout.setText("LOGOUT");
        btnLogout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLogout.setFocusable(false);
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        labelManagerName1.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        labelManagerName1.setForeground(new java.awt.Color(255, 255, 255));
        labelManagerName1.setText("MANAGER");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(logo)
                .addGap(35, 35, 35)
                .addComponent(DashName, javax.swing.GroupLayout.PREFERRED_SIZE, 652, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(labelManagerName1)
                .addGap(18, 18, 18)
                .addComponent(labelManagerName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLogout)
                .addGap(73, 73, 73))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(logo)
                .addGap(65, 65, 65))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DashName)
                    .addComponent(labelManagerName)
                    .addComponent(btnLogout)
                    .addComponent(labelManagerName1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(25, 118, 211));

        Transactions.setBackground(new java.awt.Color(25, 118, 211));
        Transactions.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Transactions.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TransactionsMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TransactionsMousePressed(evt);
            }
        });

        transactionsLabel.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        transactionsLabel.setForeground(new java.awt.Color(255, 255, 255));
        transactionsLabel.setText("TRANSACTIONS");

        javax.swing.GroupLayout TransactionsLayout = new javax.swing.GroupLayout(Transactions);
        Transactions.setLayout(TransactionsLayout);
        TransactionsLayout.setHorizontalGroup(
            TransactionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TransactionsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(transactionsLabel)
                .addGap(9, 9, 9))
        );
        TransactionsLayout.setVerticalGroup(
            TransactionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TransactionsLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(transactionsLabel)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        Customers.setBackground(new java.awt.Color(25, 118, 211));
        Customers.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Customers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CustomersMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                CustomersMousePressed(evt);
            }
        });

        customersLabel.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        customersLabel.setForeground(new java.awt.Color(255, 255, 255));
        customersLabel.setText("CUSTOMERS");

        javax.swing.GroupLayout CustomersLayout = new javax.swing.GroupLayout(Customers);
        Customers.setLayout(CustomersLayout);
        CustomersLayout.setHorizontalGroup(
            CustomersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CustomersLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(customersLabel)
                .addGap(14, 14, 14))
        );
        CustomersLayout.setVerticalGroup(
            CustomersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CustomersLayout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(customersLabel)
                .addGap(15, 15, 15))
        );

        Products.setBackground(new java.awt.Color(25, 118, 211));
        Products.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Products.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ProductsMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ProductsMousePressed(evt);
            }
        });

        productsLabel.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        productsLabel.setForeground(new java.awt.Color(255, 255, 255));
        productsLabel.setText("PRODUCTS");

        javax.swing.GroupLayout ProductsLayout = new javax.swing.GroupLayout(Products);
        Products.setLayout(ProductsLayout);
        ProductsLayout.setHorizontalGroup(
            ProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ProductsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(productsLabel)
                .addGap(15, 15, 15))
        );
        ProductsLayout.setVerticalGroup(
            ProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ProductsLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(productsLabel)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Products, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Customers, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Transactions, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(Transactions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Customers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Products, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(543, Short.MAX_VALUE))
        );

        mainPane.setBackground(new java.awt.Color(255, 255, 255));
        mainPane.setPreferredSize(new java.awt.Dimension(1100, 491));

        javax.swing.GroupLayout mainPaneLayout = new javax.swing.GroupLayout(mainPane);
        mainPane.setLayout(mainPaneLayout);
        mainPaneLayout.setHorizontalGroup(
            mainPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 886, Short.MAX_VALUE)
        );
        mainPaneLayout.setVerticalGroup(
            mainPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 770, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81)
                .addComponent(mainPane, javax.swing.GroupLayout.PREFERRED_SIZE, 886, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mainPane, javax.swing.GroupLayout.DEFAULT_SIZE, 770, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(774, 774, 774))
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TransactionsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TransactionsMouseClicked
        // TODO add your handling code here:
        ManagerTransactionPanel Order = new ManagerTransactionPanel();
        mainPane.removeAll();
        mainPane.add(Order).setVisible(true);
    }//GEN-LAST:event_TransactionsMouseClicked

    private void TransactionsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TransactionsMousePressed
        // TODO add your handling code here:
        Transactions.setBackground(ClickedColor);
        Customers.setBackground(DefaultColor);
        Products.setBackground(DefaultColor);
        
        transactionsLabel.setForeground(Color.BLACK);
        customersLabel.setForeground(Color.WHITE);
        productsLabel.setForeground(Color.WHITE);
    }//GEN-LAST:event_TransactionsMousePressed

    private void CustomersMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CustomersMousePressed
        // TODO add your handling code here:
       
        Customers.setBackground(ClickedColor);
        Transactions.setBackground(DefaultColor);
        Products.setBackground(DefaultColor);
        
        customersLabel.setForeground(Color.BLACK);
        transactionsLabel.setForeground(Color.WHITE);
        productsLabel.setForeground(Color.WHITE);
    }//GEN-LAST:event_CustomersMousePressed

    private void CustomersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CustomersMouseClicked
        // TODO add your handling code here:
        ManagerCustomerPanel ManagerCustomer = new ManagerCustomerPanel();
        mainPane.removeAll();
        mainPane.add(ManagerCustomer).setVisible(true);
    }//GEN-LAST:event_CustomersMouseClicked

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        // TODO add your handling code here:
        int answer = JOptionPane.showConfirmDialog(null, "Are you sure you want to logout?", "Logout", JOptionPane.YES_NO_OPTION);
        
        if (answer == 0) {
            this.dispose();
            new Login();
        }
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void logoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoMouseClicked
        // TODO add your handling code here:
        Customers.setBackground(DefaultColor);
        Transactions.setBackground(DefaultColor);
        Products.setBackground(DefaultColor);
        
        customersLabel.setForeground(Color.WHITE);
        transactionsLabel.setForeground(Color.WHITE);
        productsLabel.setForeground(Color.WHITE);
        
        ManagerDashboardPanel dashboardPanel = new ManagerDashboardPanel();
        mainPane.removeAll();
        mainPane.add(dashboardPanel).setVisible(true);
    }//GEN-LAST:event_logoMouseClicked

    private void DashNameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashNameMouseClicked
        // TODO add your handling code here:
        Customers.setBackground(DefaultColor);
        Transactions.setBackground(DefaultColor);
        Products.setBackground(DefaultColor);
        
        customersLabel.setForeground(Color.WHITE);
        transactionsLabel.setForeground(Color.WHITE);
        productsLabel.setForeground(Color.WHITE);
        
        ManagerDashboardPanel dashboardPanel = new ManagerDashboardPanel();
        mainPane.removeAll();
        mainPane.add(dashboardPanel).setVisible(true);
    }//GEN-LAST:event_DashNameMouseClicked

    private void ProductsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProductsMouseClicked
        // TODO add your handling code here:
        ManagerProductPanel Product = new ManagerProductPanel();
        mainPane.removeAll();
        mainPane.add(Product).setVisible(true);
    }//GEN-LAST:event_ProductsMouseClicked

    private void ProductsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProductsMousePressed
        // TODO add your handling code here:
        Customers.setBackground(DefaultColor);
        Transactions.setBackground(DefaultColor);
        Products.setBackground(ClickedColor);
        
        customersLabel.setForeground(Color.WHITE);
        transactionsLabel.setForeground(Color.WHITE);
        productsLabel.setForeground(Color.BLACK);
    }//GEN-LAST:event_ProductsMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JPanel Customers;
    private javax.swing.JLabel DashName;
    public static javax.swing.JPanel Products;
    public static javax.swing.JPanel Transactions;
    private javax.swing.JButton btnLogout;
    public static javax.swing.JLabel customersLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel labelManagerName;
    private javax.swing.JLabel labelManagerName1;
    private javax.swing.JLabel logo;
    public static javax.swing.JDesktopPane mainPane;
    public static javax.swing.JLabel productsLabel;
    public static javax.swing.JLabel transactionsLabel;
    // End of variables declaration//GEN-END:variables
}
