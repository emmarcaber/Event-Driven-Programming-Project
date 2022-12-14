/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package views;

import javax.swing.plaf.basic.BasicInternalFrameUI;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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

        bgTransactionType.add(rbWalk);
        bgTransactionType.add(rbDelivery);

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

        bgTransactionType = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTransaction = new javax.swing.JTable();
        btnAddTransaction = new javax.swing.JButton();
        btnEditTransaction = new javax.swing.JButton();
        txtSearchCustomer = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        rbWalk = new javax.swing.JRadioButton();
        rbDelivery = new javax.swing.JRadioButton();
        btnRefreshSearch = new javax.swing.JButton();
        dcDOT = new com.toedter.calendar.JDateChooser();
        btnFilterDate = new javax.swing.JButton();

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

        txtSearchCustomer.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtSearchCustomer.setMargin(new java.awt.Insets(3, 6, 3, 6));

        btnSearch.setBackground(new java.awt.Color(0, 102, 255));
        btnSearch.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btnSearch.setForeground(new java.awt.Color(255, 255, 255));
        btnSearch.setText("SEARCH CUSTOMER");
        btnSearch.setFocusable(false);
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        rbWalk.setBackground(new java.awt.Color(255, 255, 255));
        rbWalk.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        rbWalk.setText("Walk-In");
        rbWalk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbWalkActionPerformed(evt);
            }
        });

        rbDelivery.setBackground(new java.awt.Color(255, 255, 255));
        rbDelivery.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        rbDelivery.setText("Delivery");
        rbDelivery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbDeliveryActionPerformed(evt);
            }
        });

        btnRefreshSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/refreshIcon.jpg"))); // NOI18N
        btnRefreshSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshSearchActionPerformed(evt);
            }
        });

        btnFilterDate.setBackground(new java.awt.Color(0, 102, 255));
        btnFilterDate.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btnFilterDate.setForeground(new java.awt.Color(255, 255, 255));
        btnFilterDate.setText("FILTER BY DATE");
        btnFilterDate.setFocusable(false);
        btnFilterDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFilterDateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnRefreshSearch))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(txtSearchCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSearch)
                        .addGap(18, 18, 18)
                        .addComponent(rbWalk)
                        .addGap(18, 18, 18)
                        .addComponent(rbDelivery)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(dcDOT, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnFilterDate)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAddTransaction)
                                .addGap(82, 82, 82)
                                .addComponent(btnEditTransaction))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 846, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(126, 126, 126))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(btnRefreshSearch)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dcDOT, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(rbDelivery)
                        .addComponent(rbWalk)
                        .addComponent(btnSearch)
                        .addComponent(txtSearchCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnFilterDate)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddTransaction)
                    .addComponent(btnEditTransaction))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 514, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
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

    private void removeAllRowsTableTransaction() {
        DefaultTableModel tblModel = (DefaultTableModel) tblTransaction.getModel();

        int rowsToRemove = tblModel.getRowCount();
        //remove rows from the bottom one by one
        for (int i = rowsToRemove - 1; i >= 0; i--) {
            tblModel.removeRow(i);
        }
    }

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        String toSearch = txtSearchCustomer.getText();

        if (toSearch.equals("")) {
            removeAllRowsTableTransaction();
            getTransactionsFromDB();
        } else {
            DefaultTableModel tblModel = (DefaultTableModel) tblTransaction.getModel();

            removeAllRowsTableTransaction();

            try {
                stmt = DBConnect.getInstance().createStatement();

                String sql = "SELECT CONCAT(customer.FirstName, ' ', customer.Lastname) AS 'CustomerName', \n"
                        + "CONCAT(ContainerType, ' ', WaterType) AS 'Product', Quantity, Total, TransactionType,\n"
                        + "customer.LastName, TransactionDate \n"
                        + "FROM transactions\n"
                        + "INNER JOIN customer ON transactions.CustomerID = customer.CustomerID\n"
                        + "INNER JOIN `user` ON transactions.CashierID = `user`.UserID\n"
                        + "INNER JOIN product ON transactions.ProductID = product.ProductID WHERE customer.LastName LIKE '"
                        + toSearch + "%'"
                        + " AND UserID = " + cashiersMap.get(name);

                rs = stmt.executeQuery(sql);

                while (rs.next()) {
                    String customerName = rs.getString("CustomerName");
                    String product = rs.getString("Product");
                    String quantity = String.valueOf(rs.getInt("Quantity"));
                    String total = "Php " + String.valueOf(rs.getFloat("Total")) + "0";
                    String typeOfTransaction = rs.getString("TransactionType");
                    String dateOfTransaction = DateFormat.getDateInstance().format(rs.getDate("TransactionDate"));

                    String[] data = {customerName, product, quantity, total, typeOfTransaction, dateOfTransaction};

                    tblModel.addRow(data);
                }

                rs.close();
                stmt.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void rbWalkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbWalkActionPerformed
        // TODO add your handling code here:
        String toSearch = txtSearchCustomer.getText();

        DefaultTableModel tblModel = (DefaultTableModel) tblTransaction.getModel();

        removeAllRowsTableTransaction();
        String transactionDate = "";
        try {
            SimpleDateFormat DateFor = new SimpleDateFormat("yyyy-MM-dd");
            transactionDate = DateFor.format(dcDOT.getDate());
        } catch (NullPointerException e) {
        }

        try {
            stmt = DBConnect.getInstance().createStatement();

            String sql = "";
            if (transactionDate.equals("")) {
                sql = "SELECT CONCAT(customer.FirstName, ' ', customer.Lastname) AS 'CustomerName', \n"
                        + "CONCAT(ContainerType, ' ', WaterType) AS 'Product', Quantity, Total, TransactionType,\n"
                        + "customer.LastName, TransactionDate \n"
                        + "FROM transactions\n"
                        + "INNER JOIN customer ON transactions.CustomerID = customer.CustomerID\n"
                        + "INNER JOIN `user` ON transactions.CashierID = `user`.UserID\n"
                        + "INNER JOIN product ON transactions.ProductID = product.ProductID WHERE customer.LastName LIKE '"
                        + toSearch + "%'"
                        + " AND TransactionType = 'Walk-In'"
                        + " AND UserID = " + cashiersMap.get(name);
            } else {
                sql = "SELECT CONCAT(customer.FirstName, ' ', customer.Lastname) AS 'CustomerName', \n"
                        + "CONCAT(ContainerType, ' ', WaterType) AS 'Product', Quantity, Total, TransactionType,\n"
                        + "customer.LastName, TransactionDate \n"
                        + "FROM transactions\n"
                        + "INNER JOIN customer ON transactions.CustomerID = customer.CustomerID\n"
                        + "INNER JOIN `user` ON transactions.CashierID = `user`.UserID\n"
                        + "INNER JOIN product ON transactions.ProductID = product.ProductID WHERE customer.LastName LIKE '"
                        + toSearch + "%'"
                        + " AND TransactionType = 'Walk-In'"
                        + " AND TransactionDate = '" + transactionDate + "'"
                        + " AND UserID = " + cashiersMap.get(name);
            }

            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                String customerName = rs.getString("CustomerName");
                String product = rs.getString("Product");
                String quantity = String.valueOf(rs.getInt("Quantity"));
                String total = "Php " + String.valueOf(rs.getFloat("Total")) + "0";
                String typeOfTransaction = rs.getString("TransactionType");
                String dateOfTransaction = DateFormat.getDateInstance().format(rs.getDate("TransactionDate"));

                String[] data = {customerName, product, quantity, total, typeOfTransaction, dateOfTransaction};

                tblModel.addRow(data);
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_rbWalkActionPerformed

    private void rbDeliveryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbDeliveryActionPerformed
        // TODO add your handling code here:
        String toSearch = txtSearchCustomer.getText();

        DefaultTableModel tblModel = (DefaultTableModel) tblTransaction.getModel();

        removeAllRowsTableTransaction();

        String transactionDate = "";
        try {
            SimpleDateFormat DateFor = new SimpleDateFormat("yyyy-MM-dd");
            transactionDate = DateFor.format(dcDOT.getDate());
        } catch (NullPointerException e) {
        }

        try {
            stmt = DBConnect.getInstance().createStatement();

            String sql = "";
            if (transactionDate.equals("")) {
                sql = "SELECT CONCAT(customer.FirstName, ' ', customer.Lastname) AS 'CustomerName', \n"
                        + "CONCAT(ContainerType, ' ', WaterType) AS 'Product', Quantity, Total, TransactionType,\n"
                        + "customer.LastName, TransactionDate \n"
                        + "FROM transactions\n"
                        + "INNER JOIN customer ON transactions.CustomerID = customer.CustomerID\n"
                        + "INNER JOIN `user` ON transactions.CashierID = `user`.UserID\n"
                        + "INNER JOIN product ON transactions.ProductID = product.ProductID WHERE customer.LastName LIKE '"
                        + toSearch + "%'"
                        + " AND TransactionType = 'Delivery'"
                        + " AND UserID = " + cashiersMap.get(name);
            } else {
                sql = "SELECT CONCAT(customer.FirstName, ' ', customer.Lastname) AS 'CustomerName', \n"
                        + "CONCAT(ContainerType, ' ', WaterType) AS 'Product', Quantity, Total, TransactionType,\n"
                        + "customer.LastName, TransactionDate \n"
                        + "FROM transactions\n"
                        + "INNER JOIN customer ON transactions.CustomerID = customer.CustomerID\n"
                        + "INNER JOIN `user` ON transactions.CashierID = `user`.UserID\n"
                        + "INNER JOIN product ON transactions.ProductID = product.ProductID WHERE customer.LastName LIKE '"
                        + toSearch + "%'"
                        + " AND TransactionType = 'Delivery'"
                        + " AND TransactionDate = '" + transactionDate + "'"
                        + " AND UserID = " + cashiersMap.get(name);
            }

            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                String customerName = rs.getString("CustomerName");
                String product = rs.getString("Product");
                String quantity = String.valueOf(rs.getInt("Quantity"));
                String total = "Php " + String.valueOf(rs.getFloat("Total")) + "0";
                String typeOfTransaction = rs.getString("TransactionType");
                String dateOfTransaction = DateFormat.getDateInstance().format(rs.getDate("TransactionDate"));

                String[] data = {customerName, product, quantity, total, typeOfTransaction, dateOfTransaction};

                tblModel.addRow(data);
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_rbDeliveryActionPerformed

    private void btnRefreshSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshSearchActionPerformed
        // TODO add your handling code here:
        removeAllRowsTableTransaction();

        txtSearchCustomer.setText("");
        bgTransactionType.clearSelection();
        dcDOT.setCalendar(null);

        getTransactionsFromDB();
    }//GEN-LAST:event_btnRefreshSearchActionPerformed

    private void btnFilterDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFilterDateActionPerformed
        // TODO add your handling code here:
        String toSearch = txtSearchCustomer.getText();
        String transactionType = "";
        String transactionDate = "";
        try {
            SimpleDateFormat DateFor = new SimpleDateFormat("yyyy-MM-dd");
            transactionDate = DateFor.format(dcDOT.getDate());
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(this, "No selected date to filter!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (rbWalk.isSelected()) {
            transactionType = "Walk-In";
        } else if (rbDelivery.isSelected()) {
            transactionType = "Delivery";
        }

        DefaultTableModel tblModel = (DefaultTableModel) tblTransaction.getModel();

        removeAllRowsTableTransaction();

        try {
            stmt = DBConnect.getInstance().createStatement();

            String sql = "SELECT CONCAT(customer.FirstName, ' ', customer.Lastname) AS 'CustomerName', \n"
                    + "CONCAT(ContainerType, ' ', WaterType) AS 'Product', Quantity, Total, TransactionType,\n"
                    + "customer.LastName, TransactionDate \n"
                    + "FROM transactions\n"
                    + "INNER JOIN customer ON transactions.CustomerID = customer.CustomerID\n"
                    + "INNER JOIN `user` ON transactions.CashierID = `user`.UserID\n"
                    + "INNER JOIN product ON transactions.ProductID = product.ProductID WHERE customer.LastName LIKE '"
                    + toSearch + "%'"
                    + " AND TransactionType LIKE '" + transactionType + "%'"
                    + " AND TransactionDate = '" + transactionDate + "'"
                    + " AND UserID = " + cashiersMap.get(name);

            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                String customerName = rs.getString("CustomerName");
                String product = rs.getString("Product");
                String quantity = String.valueOf(rs.getInt("Quantity"));
                String total = "Php " + String.valueOf(rs.getFloat("Total")) + "0";
                String typeOfTransaction = rs.getString("TransactionType");
                String dateOfTransaction = DateFormat.getDateInstance().format(rs.getDate("TransactionDate"));

                String[] data = {customerName, product, quantity, total, typeOfTransaction, dateOfTransaction};

                tblModel.addRow(data);
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_btnFilterDateActionPerformed

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
    private javax.swing.ButtonGroup bgTransactionType;
    private javax.swing.JButton btnAddTransaction;
    private javax.swing.JButton btnEditTransaction;
    private javax.swing.JButton btnFilterDate;
    private javax.swing.JButton btnRefreshSearch;
    private javax.swing.JButton btnSearch;
    private com.toedter.calendar.JDateChooser dcDOT;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rbDelivery;
    private javax.swing.JRadioButton rbWalk;
    public static javax.swing.JTable tblTransaction;
    private javax.swing.JTextField txtSearchCustomer;
    // End of variables declaration//GEN-END:variables
}
