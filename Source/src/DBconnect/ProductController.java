/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBconnect;


import coffee.ProductForm;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Ngoc Nguyen
 */
public class ProductController {
    //hiển thị danh sách
    public static ArrayList<Product> getAllProducts(){
        ArrayList<Product> list =  new ArrayList<>();
        Connection cnn =  DBConnect.getConnection();
        Statement st;
        try {
            st = cnn.createStatement();
            ResultSet rs = st.executeQuery("select * from Product");           
            while(rs.next()){
                String idproduct = rs.getString("IDProduct");
                String productname = rs.getString("ProductName");
                String idtype = rs.getString("IDType");
                int price = rs.getInt("Price");               
                Product product = new Product(idproduct,productname,idtype,price);
                list.add(product);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductController.class.getName()).log(Level.SEVERE, null, ex);
        }
            return list;
    }
    
    //thêm sản phẩm
    public static void addProduct(String idproduct,String productname,String idtype, int price){
        Connection cnn = DBConnect.getConnection();
        String sqlQuery = ("insert into Product values ('"+idproduct+"',N'"+productname+"','"+idtype+"',"+price+")");
        try {
            PreparedStatement ps = cnn.prepareStatement(sqlQuery);
            int rowInsert = ps.executeUpdate();
            ProductForm.modelproduct.fireTableDataChanged();
            if(rowInsert > 0){
                JOptionPane.showMessageDialog(null, "Thêm thành công sản phẩm");
            } else
            {
                JOptionPane.showMessageDialog(null, "Vui lòng kiểm tra lại!!","Lỗi",JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
    //chỉnh sửa sản phẩm
    public static void updateProduct(String lastID,String idproduct,String productname,String idtype, int price){
        Connection cnn = DBConnect.getConnection();
        String sqlQuery = ("update Product set IDProduct = '"+idproduct+"', ProductName = N'"+productname+"',IDType = '"+idtype+"',Price="+price+" where IDProduct = '"+lastID+"'");
            try {
            PreparedStatement ps = cnn.prepareStatement(sqlQuery);
            int rowUpdated = ps.executeUpdate();
            if(rowUpdated > 0){
                JOptionPane.showMessageDialog(null, "Cập nhật thành công!!");
            } else
            {
                JOptionPane.showMessageDialog(null, "Vui lòng kiểm tra lại!!","Lỗi",JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //xóa sản phẩm
    public static void deleteProduct(String idproduct){
        Connection cnn = DBConnect.getConnection();
        String sqlQuery = ("delete from Product where IDProduct = '"+idproduct+"'");
        try {
            PreparedStatement ps = cnn.prepareStatement(sqlQuery);
            int rowDeleted = ps.executeUpdate();
            if(rowDeleted > 0){
                JOptionPane.showMessageDialog(null, "Xóa thành công!!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductController.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
    //tìm sản phẩm
    public static ArrayList<Product> findProduct(String productnamefind){
       ArrayList<Product> list =  new ArrayList<>();
        Connection cnn =  DBConnect.getConnection();
        Statement st;
        try {
            st = cnn.createStatement();
            ResultSet rs = st.executeQuery("select * from Product where ProductName like N'%"+productnamefind+"%'");
            
            while(rs.next()){
                String idproduct = rs.getString("IDProduct");
                String productname = rs.getString("ProductName");
                String idtype = rs.getString("IDType");
                int price = rs.getInt("Price");               
                Product product = new Product(idproduct,productname,idtype,price);
                list.add(product);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductController.class.getName()).log(Level.SEVERE, null, ex);
        }
            return list;
    } 
}
