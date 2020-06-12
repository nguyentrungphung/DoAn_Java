/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBconnect;

import coffee.EmployeeForm;
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
public class EmployeeController {
    //hiển thị danh sách
    public static ArrayList<Employee> getAllEmployee(){
        ArrayList<Employee> list =  new ArrayList<>();
        Connection cnn =  DBConnect.getConnection();
        Statement st;
        try {
            st = cnn.createStatement();
            ResultSet rs = st.executeQuery("select * from Employee");
            
            while(rs.next()){
                String name = rs.getString("NameEmp");
                String sex = rs.getString("Gender");
                String birthday = rs.getString("Birthday");
                String phone = rs.getString("Phone");
                String email = rs.getString("Email");
                String address = rs.getString("Address");
                String acount = rs.getString("UsernameEmp");
                Employee employee = new Employee(name, sex, birthday, phone, email, address,acount);
                list.add(employee);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeController.class.getName()).log(Level.SEVERE, null, ex);
        }
            return list;
    }
    //tìm nhân viên
    public static ArrayList<Employee> findEmployees(String findbyName){
        ArrayList<Employee> list =  new ArrayList<>();
        Connection cnn =  DBConnect.getConnection();
        Statement st;
        try {
            st = cnn.createStatement();
            ResultSet rs = st.executeQuery("select * from Employee where NameEmp like N'%"+findbyName+"%'");
            
            while(rs.next()){
                String name = rs.getString("NameEmp");
                String sex = rs.getString("Gender");
                String birthday = rs.getString("Birthday");
                String phone = rs.getString("Phone");
                String email = rs.getString("Email");
                String address = rs.getString("Address");
                String acount = rs.getString("UsernameEmp");
                Employee employee = new Employee(name, sex, birthday, phone, email, address,acount);
                list.add(employee);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeController.class.getName()).log(Level.SEVERE, null, ex);
        }
            return list;
    }
    
    //thêm nhân viên
    public static void addEmployee(String acount,String name,String gender, String birthday ,String phone,String email, String address){
        Connection cnn = DBConnect.getConnection();
        String sqlQuery = ("insert into Employee values ('"+acount+"','123',N'"+name+"',N'"+gender+"','"+birthday+"','"+phone+"',N'"+email+"',N'"+address+"','khongcohinh.jpg')");
        try {
            PreparedStatement ps = cnn.prepareStatement(sqlQuery);
            int rowInsert = ps.executeUpdate();
            EmployeeForm.modelemployee.fireTableDataChanged();
            if(rowInsert > 0){
                JOptionPane.showMessageDialog(null, "Thêm thành công!! mật khẩu mặc định là: 123");
            } else
            {
                JOptionPane.showMessageDialog(null, "Vui lòng kiểm tra lại!!","Lỗi",JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Employee.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
    //cập nhật nhân viên
    public static void updateEmployee(String acount,String name, String gender, String birthday ,String phone,String email, String address){
        Connection cnn = DBConnect.getConnection();
        String sqlQuery = ("update Employee set NameEmp = N'"+name+"', Gender = N'"+gender+"',Birthday = '"+birthday+"',Phone='"+phone+"',Email = '"+email+"',Address = N'"+address+"' where UsernameEmp = '"+acount+"'");
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
            Logger.getLogger(EmployeeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //xóa nhân viên
    public static void deleteEmployee(String acount){
        Connection cnn = DBConnect.getConnection();
        String sqlQuery = ("delete from Employee where UsernameEmp = '"+acount+"'");
        try {
            PreparedStatement ps = cnn.prepareStatement(sqlQuery);
            int rowDeleted = ps.executeUpdate();
            if(rowDeleted > 0){
                JOptionPane.showMessageDialog(null, "Xóa thành công!!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeController.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
}
