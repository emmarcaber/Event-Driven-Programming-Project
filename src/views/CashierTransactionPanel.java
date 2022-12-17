/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package views;

import javax.swing.plaf.basic.BasicInternalFrameUI;
import java.sql.*;
import java.text.DateFormat;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Anaclita
 */
public class CashierTransactionPanel extends javax.swing.JInternalFrame {

    Statement stmt = null;
    ResultSet rs = null;
    PreparedStatement pstmt = null;

    private String name = "";
    
    HashMap<String, Integer> productsMap = new HashMap<>();
    HashMap<String, Float> pricesMap = new HashMap<>();
    HashMap<String, Integer> customersMap = new HashMap<>();
    HashMap<String, Integer> cashiersMap = new HashMap<>();

    /**
     * Creates new form TableCashier
     */
    public CashierTransactionPanel(String name) {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI ui = (BasicInternalFrameUI) this.getUI();
        ui.setNorthPane(null);

        this.name = name;
        
        getCashiersFromDB();
        getCustomersFromDB();
        getProductsFromDB();
        getTransactionsFromDB();
    }

    private void getCustomersFromDB() {
        try {
            stmt = DBConnect.getInstance().createStatement();

            String sql = "SELECT CONCAT(FirstName, ' ', LastName) AS 'Name', CustomerID FROM customer";
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                customersMap.put(rs.getString("Name"), rs.getInt("CustomerID"));
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private void getCashiersFromDB() {
        try {
            stmt = DBConnect.getInstance().createStatement();

            String sql = "SELECT CONCAT(FirstName, ' ', LastName) AS 'Name', UserID FROM `user` WHERE UserType = 'Cashier'";
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                cashiersMap.put(rs.getString("Name"), rs.getInt("UserID"));
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private void getProductsFromDB() {
        try {
            stmt = DBConnect.getInstance().createStatement();

            String sql = "SELECT CONCAT(ContainerType, ' ', WaterType) AS 'Name', ProductID, Price FROM product";
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                productsMap.put(rs.getString("Name"), rs.getInt("ProductID"));
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void getTransactionsFromDB() {
        try {
            stmt = DBConnect.getInstance().createStatement();

            String sql = "SELECT CONCAT(customer.FirstName, ' ', customer.Lastname) AS 'CustomerName', \n"
                    + "CONCAT(ContainerType, ' ', WaterType) AS 'Product', Quantity, Total, TransactionType,\n"
                    + "TransactionDate FROM transactions\n"
                    + "INNER JOIN customer ON transactions.CustomerID = customer.CustomerID\n"
                    + "INNER JOIN `user` ON transactions.CashierID = `user`.UserID\n"
                    + "INNER JOIN product ON transactions.ProductID = product.ProductID"
                    + " WHERE UserID = " + cashiersMap.get(name);
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                String customerName = rs.getString("CustomerName");
                String product = rs.getString("Product");
                String quantity = String.valueOf(rs.getInt("Quantity"));
                String total = "Php " + String.valueOf(rs.getFloat("Total")) + "0";
                String typeOfTransaction = rs.getString("TransactionType");
                String dateOfTransaction = DateFormat.getDateInstance().format(rs.getDate("TransactionDate"));

                String[] data = {customerName, product, quantity, total, typeOfTransaction, dateOfTransaction};

                DefaultTableModel tblModel = (DefaultTableModel) tblTransaction.getModel();
                tblModel.addRow(data);
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblTransaction = new javax.swing.JTable();
        btnAddTransaction = new javax.swing.JButton();
        btnEditTransaction = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setVisible(true);

        tblTransaction.setAutoCreateRowSorter(true);
        tblTransaction.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        tblTransaction.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Customer Name", "Product", "Quantity ", "Total", "Type", "Date Transacted"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblTransaction.setMinimumSize(new java.awt.Dimension(50, 0));
        jScrollPane1.setViewportView(tblTransaction);
        if (tblTransaction.getColumnModel().getColumnCount() > 0) {
            tblTransaction.getColumnModel().getColumn(0).setPreferredWidth(200);
            tblTransaction.getColumnModel().getColumn(1).setPreferredWidth(150);
            tblTransaction.getColumnModel().getColumn(2).setPreferredWidth(50);
            tblTransaction.getColumnModel().getColumn(3).setPreferredWidth(100);
            tblTransaction.getColumnModel().getColumn(4).setPreferredWidth(50);
        }

        btnAddTransaction.setBackground(new java.awt.Color(0, 153, 0));
        btnAddTransaction.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btnAddTransaction.setForeground(new java.awt.Color(255, 255, 255));
        btnAddTransaction.setText("ADD TRANSACTION");
        btnAddTransaction.setFocusable(false);
        btnAddTransaction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddTransactionActionPerformed(evt);
            }
        });

        btnEditTransaction.setBackground(new java.awt.Color(255, 255, 0));
        btnEditTransaction.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btnEditTransaction.setText("EDIT TRANSACTION");
        btnEditTransaction.setFocusable(false);
        btnEditTransaction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditTransactionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAddTransaction)
                        .addGap(82, 82, 82)
                        .addComponent(btnEditTransaction))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 846, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(126, 126, 126))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddTransaction)
                    .addComponent(btnEditTransaction))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 514, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddTransactionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddTransactionActionPerformed
        // TODO add your handling code here:
        new CashierAddTransactionDialog(null, true, cashiersMap.get(this.name));
    }//GEN-LAST:event_btnAddTransactionActionPerformed

    private void btnEditTransactionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditTransactionActionPerformed
        // TODO add your handling code here:

        DefaultTableModel tblModel = (DefaultTableModel) tblTransaction.getModel();

        if (tblTransaction.getSelectedRowCount() == 1) {
            int customerID = customersMap.get(tblModel.getValueAt(tblTransaction.getSelectedRow(), 0).toString());
            int productID = productsMap.get(tblModel.getValueAt(tblTransaction.getSelectedRow(), 1).toString());
            int quantity = Integer.parseInt(tblModel.getValueAt(tblTransaction.getSelectedRow(), 2).toString());
            String typeOfTransaction = tblModel.getValueAt(tblTransaction.getSelectedRow(), 4).toString();
            new CashierEditTransactionDialog(null, true, getTransactionID(customerID, cashiersMap.get(name), productID, quantity, typeOfTransaction));
        } else {
            if (tblTransaction.getRowCount() == 0) {
                JOptionPane.showMessageDialog(null, "Table is empty!", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Please select a single row!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnEditTransactionActionPerformed

    private int getTransactionID(int customerID, int cashierID, int productID, int quantity, String typeOfTransaction) {
        int toDeleteID = 0;
        try {
            stmt = DBConnect.getInstance().createStatement();

            String sql = "SELECT TransactionID from transactions WHERE "
                    + "CustomerID = " + customerID
                    + " AND CashierID = " + cashierID
                    + " AND ProductID = " + productID
                    + " AND Quantity = " + quantity
                    + " AND TransactionType = '" + typeOfTransaction + "'";
            rs = stmt.executeQuery(sql);

            rs.next();
            toDeleteID = rs.getInt("TransactionID");

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return toDeleteID;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddTransaction;
    private javax.swing.JButton btnEditTransaction;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable tblTransaction;
    // End of variables declaration//GEN-END:variables
}