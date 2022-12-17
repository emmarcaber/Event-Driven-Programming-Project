/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package views;

import java.awt.Color;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import java.sql.*;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static views.ManagerDashboard.Customers;
import static views.ManagerDashboard.Products;
import static views.ManagerDashboard.Transactions;
import static views.ManagerDashboard.customersLabel;
import static views.ManagerDashboard.mainPane;
import static views.ManagerDashboard.productsLabel;
import static views.ManagerDashboard.transactionsLabel;

/**
 *
 * @author Anaclita
 */
public class ManagerDashboardPanel extends javax.swing.JInternalFrame {

    Statement stmt = null;
    ResultSet rs = null;
    PreparedStatement pstmt = null;
    
    Color DefaultColor,ClickedColor;

    public static HashMap<String, Integer> cashierMap = new HashMap<>();

    /**
     * Creates new form TableCashier
     */
    public ManagerDashboardPanel() {
        initComponents();
        txtTotalTransactions.setText(String.valueOf(getTotalTransactions()));
        txtTotalCustomers.setText(String.valueOf(getTotalCustomers()));
        txtTotalProducts.setText(String.valueOf(getTotalProducts()));
        
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI ui = (BasicInternalFrameUI) this.getUI();
        
        DefaultColor=new Color(25,118,211);
        ClickedColor=new Color (255,255,255);
        
        ui.setNorthPane(null);

        
    }
    
    private int getTotalTransactions() {
        int totalCashier = 0;
        try {
            stmt = DBConnect.getInstance().createStatement();
            
            String sql = "SELECT COUNT(*) AS 'Transactions' FROM transactions";
            rs = stmt.executeQuery(sql);
            
            rs.next();
            totalCashier = rs.getInt("Transactions");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return totalCashier;
    }
    
    private int getTotalCustomers() {
        int totalManager = 0;
        try {
            stmt = DBConnect.getInstance().createStatement();
            
            String sql = "SELECT COUNT(*) AS 'Customers' FROM customer";
            rs = stmt.executeQuery(sql);
            
            rs.next();
            totalManager = rs.getInt("Customers");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return totalManager;
    }
    
    private int getTotalProducts() {
        int totalManager = 0;
        try {
            stmt = DBConnect.getInstance().createStatement();
            
            String sql = "SELECT COUNT(*) AS 'Products' FROM product";
            rs = stmt.executeQuery(sql);
            
            rs.next();
            totalManager = rs.getInt("Products");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return totalManager;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        transactionPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtTotalTransactions = new javax.swing.JLabel();
        customerPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtTotalCustomers = new javax.swing.JLabel();
        productPanel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtTotalProducts = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setVisible(true);

        transactionPanel.setBackground(new java.awt.Color(255, 255, 51));
        transactionPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        transactionPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                transactionPanelMouseClicked(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/transactionLogo.jpg"))); // NOI18N

        jLabel5.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel5.setText("TRANSACTIONS");

        txtTotalTransactions.setFont(new java.awt.Font("Century Gothic", 0, 48)); // NOI18N
        txtTotalTransactions.setText("0");

        javax.swing.GroupLayout transactionPanelLayout = new javax.swing.GroupLayout(transactionPanel);
        transactionPanel.setLayout(transactionPanelLayout);
        transactionPanelLayout.setHorizontalGroup(
            transactionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(transactionPanelLayout.createSequentialGroup()
                .addContainerGap(52, Short.MAX_VALUE)
                .addGroup(transactionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, transactionPanelLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(47, 47, 47))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, transactionPanelLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(33, 33, 33))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, transactionPanelLayout.createSequentialGroup()
                        .addComponent(txtTotalTransactions)
                        .addGap(104, 104, 104))))
        );
        transactionPanelLayout.setVerticalGroup(
            transactionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(transactionPanelLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(txtTotalTransactions)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        customerPanel.setBackground(new java.awt.Color(0, 51, 204));
        customerPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        customerPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                customerPanelMouseClicked(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/customerLogo.jpg"))); // NOI18N

        jLabel6.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("CUSTOMERS");

        txtTotalCustomers.setFont(new java.awt.Font("Century Gothic", 0, 48)); // NOI18N
        txtTotalCustomers.setForeground(new java.awt.Color(255, 255, 255));
        txtTotalCustomers.setText("0");

        javax.swing.GroupLayout customerPanelLayout = new javax.swing.GroupLayout(customerPanel);
        customerPanel.setLayout(customerPanelLayout);
        customerPanelLayout.setHorizontalGroup(
            customerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(customerPanelLayout.createSequentialGroup()
                .addContainerGap(52, Short.MAX_VALUE)
                .addGroup(customerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, customerPanelLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(47, 47, 47))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, customerPanelLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(51, 51, 51))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, customerPanelLayout.createSequentialGroup()
                        .addComponent(txtTotalCustomers)
                        .addGap(107, 107, 107))))
        );
        customerPanelLayout.setVerticalGroup(
            customerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(customerPanelLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel2)
                .addGap(24, 24, 24)
                .addComponent(txtTotalCustomers)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        productPanel.setBackground(new java.awt.Color(0, 204, 51));
        productPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        productPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                productPanelMouseClicked(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/productLogo.jpg"))); // NOI18N

        jLabel7.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("PRODUCTS");

        txtTotalProducts.setFont(new java.awt.Font("Century Gothic", 0, 48)); // NOI18N
        txtTotalProducts.setForeground(new java.awt.Color(255, 255, 255));
        txtTotalProducts.setText("0");

        javax.swing.GroupLayout productPanelLayout = new javax.swing.GroupLayout(productPanel);
        productPanel.setLayout(productPanelLayout);
        productPanelLayout.setHorizontalGroup(
            productPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(productPanelLayout.createSequentialGroup()
                .addContainerGap(52, Short.MAX_VALUE)
                .addGroup(productPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, productPanelLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(47, 47, 47))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, productPanelLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(60, 60, 60))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, productPanelLayout.createSequentialGroup()
                        .addComponent(txtTotalProducts)
                        .addGap(110, 110, 110))))
        );
        productPanelLayout.setVerticalGroup(
            productPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(productPanelLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTotalProducts)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(transactionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(customerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(productPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(195, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(productPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(transactionPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(customerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(573, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void transactionPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_transactionPanelMouseClicked
        // TODO add your handling code here:
        Transactions.setBackground(ClickedColor);
        Customers.setBackground(DefaultColor);
        Products.setBackground(DefaultColor);
        
        transactionsLabel.setForeground(Color.BLACK);
        customersLabel.setForeground(Color.WHITE);
        productsLabel.setForeground(Color.WHITE);
        
        ManagerTransactionPanel Transaction = new ManagerTransactionPanel();
        mainPane.removeAll();
        mainPane.add(Transaction).setVisible(true);
    }//GEN-LAST:event_transactionPanelMouseClicked

    private void customerPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_customerPanelMouseClicked
        // TODO add your handling code here:
        Transactions.setBackground(DefaultColor);
        Customers.setBackground(ClickedColor);
        Products.setBackground(DefaultColor);
        
        transactionsLabel.setForeground(Color.WHITE);
        customersLabel.setForeground(Color.BLACK);
        productsLabel.setForeground(Color.WHITE);
        
        ManagerCustomerPanel Customer = new ManagerCustomerPanel();
        mainPane.removeAll();
        mainPane.add(Customer).setVisible(true);
    }//GEN-LAST:event_customerPanelMouseClicked

    private void productPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_productPanelMouseClicked
        // TODO add your handling code here:
        Transactions.setBackground(DefaultColor);
        Customers.setBackground(DefaultColor);
        Products.setBackground(ClickedColor);
        
        transactionsLabel.setForeground(Color.WHITE);
        customersLabel.setForeground(Color.WHITE);
        productsLabel.setForeground(Color.BLACK);
        
        ManagerProductPanel Product = new ManagerProductPanel();
        mainPane.removeAll();
        mainPane.add(Product).setVisible(true);
    }//GEN-LAST:event_productPanelMouseClicked



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel customerPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel productPanel;
    private javax.swing.JPanel transactionPanel;
    private javax.swing.JLabel txtTotalCustomers;
    private javax.swing.JLabel txtTotalProducts;
    private javax.swing.JLabel txtTotalTransactions;
    // End of variables declaration//GEN-END:variables
}