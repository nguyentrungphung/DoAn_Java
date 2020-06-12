/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBconnect;

import java.util.Vector;

/**
 *
 * @author Ngoc Nguyen
 */
public class Employee {
    private String name;
    private String sex;
    private String birthday;
    private String phone;
    private String email;
    private String address;
    private String acount;

    public Employee(String name, String sex, String birthday, String phone, String email, String address, String acount) {
        this.name = name;
        this.sex = sex;
        this.birthday = birthday;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.acount = acount;
    }

    public String getAcount() {
        return acount;
    }

    public void setAcount(String acount) {
        this.acount = acount;
    }
    
    public Employee(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String address() {
        return address;
    }

    public void setAddress(String Address) {
        this.address = Address;
    }

    public Object[] toArray(){
        return new Object[] {name,sex,birthday,phone,email,address,acount};
    }  
    public Object[] toFindArray(){
        return new Object[] {name,sex,birthday,phone,email,address};
    }  
}
