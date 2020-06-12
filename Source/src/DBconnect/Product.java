/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBconnect;

/**
 *
 * @author Ngoc Nguyen
 */
public class Product {
    private String idproduct;
    private String productname;
    private String idtype;
    private int price;

    public Product(String idproduct, String productname, String idtype, int price) {
        this.idproduct = idproduct;
        this.productname = productname;
        this.idtype = idtype;
        this.price = price;
    }
    
    //construct có số lượng
    private int sl;
    public Product(String idproduct, String productname, String idtype, int price,int sl) {
        this.idproduct = idproduct;
        this.productname = productname;
        this.idtype = idtype;
        this.price = price;
        this.sl = sl;
    }
    
    public Product(){}

    public String getIdproduct() {
        return idproduct;
    }

    public void setIdproduct(String idproduct) {
        this.idproduct = idproduct;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getIdtype() {
        return idtype;
    }

    public void setIdtype(String idtype) {
        this.idtype = idtype;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    
    public Object[] toArray(){
        return new Object[] {idproduct,productname,idtype,price};
    }
    public Object[] toArray2(){
        return new Object[] {idproduct,productname,idtype,price,sl};
    }
}
