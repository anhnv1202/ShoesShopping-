/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import entity.*;
import entity.Cart;
import entity.Product;
import entity.Category;
import entity.Customer;
import entity.Item;
import entity.Order;
import entity.ProductSize;
import entity.Size;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class DAO extends MyDAO {

    public List<Product> getProductList() { // from worker and province tables
        List<Product> t = new ArrayList<Product>();
        xSql = "select * from Product";
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            while (rs.next()) {
                t.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5), rs.getString(6)));
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (t);
    }

    public List<Product> pagingProduct(int index) { // from worker and province tables
        List<Product> t = new ArrayList<Product>();
        xSql = "select * from Product \n"
                + "order by id\n"
                + " offset ? rows fetch next 6 rows only";
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, (index - 1) * 6);
            rs = ps.executeQuery();
            while (rs.next()) {
                t.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5), rs.getString(6)));
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (t);
    }
    public List<Product> pagingProduct(int index, int cid) { // from worker and province tables
        List<Product> t = new ArrayList<Product>();
        xSql = "select * from Product \n"
                + "where cid=?\n"
                + "order by id\n"
                + " offset ? rows fetch next 6 rows only";
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, cid);
            ps.setInt(2, (index - 1) * 6);
            rs = ps.executeQuery();
            while (rs.next()) {
                t.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5), rs.getString(6)));
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (t);
    }

    public List<Product> pagingProductDesc(int index) { // from worker and province tables
        List<Product> t = new ArrayList<Product>();
        xSql = "select * from Product \n"
                + "order by id desc\n"
                + " offset ? rows fetch next 6 rows only";
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, (index - 1) * 6);
            rs = ps.executeQuery();
            while (rs.next()) {
                t.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5), rs.getString(6)));
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (t);
    }
      public int getTotalOrder() {
        xSql = "select count(*) from [Order]";

        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

     public List<Order> pagingOrder(int index) { // from worker and province tables
        List<Order> t = new ArrayList();
        xSql = "select * from [Order] \n"
                + "order by id\n"
                + " offset ? rows fetch next 6 rows only";
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, (index - 1) * 6);
            rs = ps.executeQuery();
            while (rs.next()) {
                t.add(new Order(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getDouble(4)));
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (t);
    }
     public int getTotalProductCart(int oid) {
        xSql = "select count(*) from [OrderDetail] where oid=?";

        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, oid);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

     public List<OrderDetail> pagingProductCart(int index,int oid) { // from worker and province tables
        List<OrderDetail> t = new ArrayList();
        xSql = "select * from [OrderDetail] \n"
                 + "where oid=?\n"
                + "order by oid\n"
                + " offset ? rows fetch next 6 rows only";
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, oid);
            ps.setInt(2, (index - 1) * 6);
            rs = ps.executeQuery();
            while (rs.next()) {
                t.add(new OrderDetail(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getInt(4),rs.getDouble(5)));
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (t);
    }

    public List<Product> pagingProduct(int index, int cid, String name) { // from worker and province tables
        List<Product> t = new ArrayList<Product>();
        xSql = "select * from Product \n"
                + "where cid=? and name like ?\n"
                + "order by id\n"
                + " offset ? rows fetch next 6 rows only";
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, cid);
            ps.setString(2, "%" + name + "%");
            ps.setInt(3, (index - 1) * 6);
            rs = ps.executeQuery();
            while (rs.next()) {
                t.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5), rs.getString(6)));
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (t);
    }

    public List<Product> pagingProduct(int index, String name) { // from worker and province tables
        List<Product> t = new ArrayList<Product>();
        xSql = "select * from Product \n"
                + "where name like ?\n"
                + "order by id\n"
                + " offset ? rows fetch next 6 rows only";
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, "%" + name + "%");
            ps.setInt(2, (index - 1) * 6);
            rs = ps.executeQuery();
            while (rs.next()) {
                t.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5), rs.getString(6)));
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (t);
    }

    public List<Product> pagingProduct(int index, String name, int cid) { // from worker and province tables
        List<Product> t = new ArrayList<Product>();
        xSql = "select * from Product \n"
                + "where name like ? and cid=?\n"
                + "order by id\n"
                + " offset ? rows fetch next 6 rows only";
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, "%" + name + "%");
            ps.setInt(2, cid);
            ps.setInt(3, (index - 1) * 6);
            rs = ps.executeQuery();
            while (rs.next()) {
                t.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5), rs.getString(6)));
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (t);
    }

    /**
     *
     * getSize by id
     */
    public Size getSizebyID(int id) {
        xSql = "select * from Size where id=?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Size(rs.getInt(1), rs.getDouble(2));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     *
     * getProductSize by id
     *
     * @param pid
     * @param sid
     * @return
     */
    public ProductSize getProductSize(int pid, int sid) {
        xSql = "select * from SizeProduct where pid=? and sid=?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, pid);
            ps.setInt(2, sid);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new ProductSize(rs.getInt(1), rs.getInt(2), rs.getInt(3));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public int getCategoryIdbyPid(int pid) {
        xSql = "select cid from Product where id=?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, pid);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public List<ProductSize> productSizelist(int pid) {
        List<ProductSize> t = new ArrayList<>();
        xSql = "select * from SizeProduct where pid=?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, pid);
            rs = ps.executeQuery();
            while (rs.next()) {
                t.add(new ProductSize(rs.getInt(1), rs.getInt(2), rs.getInt(3)));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return t;
    }

    public List<Size> sizelist() {
        List<Size> t = new ArrayList<>();
        xSql = "select * from Size";
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            while (rs.next()) {
                t.add(new Size(rs.getInt(1), rs.getDouble(2)));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return t;
    }

    public void updateSize(int pid, int sid, int quantity) {
        xSql = "update SizeProduct set quantity=? where pid=? and sid=?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, quantity);
            ps.setInt(2, pid);
            ps.setInt(3, sid);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public List<Product> pagingProductbyPriceIn(int index) { // from worker and province tables
        List<Product> t = new ArrayList<Product>();
        xSql = "select * from Product \n"
                + "order by price\n"
                + " offset ? rows fetch next 6 rows only";
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, (index - 1) * 6);
            rs = ps.executeQuery();
            while (rs.next()) {
                t.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5), rs.getString(6)));
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (t);
    }

    public List<Product> pagingProductbyPriceDown(int index) { // from worker and province tables
        List<Product> t = new ArrayList<Product>();
        xSql = "select * from Product \n"
                + "order by price desc\n"
                + " offset ? rows fetch next 6 rows only";
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, (index - 1) * 6);
            rs = ps.executeQuery();
            while (rs.next()) {
                t.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5), rs.getString(6)));
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (t);
    }
    public List<Product> pagingProductdesc(int index, String name,int cid) { // from worker and province tables
        List<Product> t = new ArrayList<Product>();
        xSql = "select * from Product \n"
                + "where name like ? and cid=?\n"
                + "order by id desc\n"
                + " offset ? rows fetch next 6 rows only";
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, "%"+name+"%");
            ps.setInt(2, cid);
            ps.setInt(3, (index - 1) * 6);
            rs = ps.executeQuery();
            while (rs.next()) {
                t.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5), rs.getString(6)));
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (t);
    }
      public List<Product> pagingProductbyPriceIn(int index, String name,int cid) { // from worker and province tables
        List<Product> t = new ArrayList<Product>();
        xSql = "select * from Product \n"
                + "where name like ? and cid=?\n"
                + "order by price \n"
                + " offset ? rows fetch next 6 rows only";
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, "%"+name+"%");
            ps.setInt(2, cid);
            ps.setInt(3, (index - 1) * 6);
            rs = ps.executeQuery();
            while (rs.next()) {
                t.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5), rs.getString(6)));
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (t);
    }
       public List<Product> pagingProductbyPriceDesc(int index, String name,int cid) { // from worker and province tables
        List<Product> t = new ArrayList<Product>();
        xSql = "select * from Product \n"
                + "where name like ? and cid=?\n"
                + "order by price desc \n"
                + " offset ? rows fetch next 6 rows only";
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, "%"+name+"%");
            ps.setInt(2, cid);
            ps.setInt(3, (index - 1) * 6);
            rs = ps.executeQuery();
            while (rs.next()) {
                t.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5), rs.getString(6)));
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (t);
    }
        public List<Product> pagingProductdesc(int index, String name) { // from worker and province tables
        List<Product> t = new ArrayList<Product>();
        xSql = "select * from Product \n"
                + "where name like ?\n"
                + "order by id desc\n"
                + " offset ? rows fetch next 6 rows only";
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, "%"+name+"%");
            ps.setInt(2, (index - 1) * 6);
            rs = ps.executeQuery();
            while (rs.next()) {
                t.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5), rs.getString(6)));
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (t);
    }
         public List<Product> pagingProductbyPriceIn(int index, String name) { // from worker and province tables
        List<Product> t = new ArrayList<Product>();
        xSql = "select * from Product \n"
                 + "where name like ?\n"
                + "order by price \n"
                + " offset ? rows fetch next 6 rows only";
        try {
            ps = con.prepareStatement(xSql);
           ps.setString(1, "%"+name+"%");
            ps.setInt(2, (index - 1) * 6);
            rs = ps.executeQuery();
            while (rs.next()) {
                t.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5), rs.getString(6)));
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (t);
    }
          public List<Product> pagingProductbyPriceDesc(int index, String name) { // from worker and province tables
        List<Product> t = new ArrayList<Product>();
        xSql = "select * from Product \n"
                 + "where name like ?\n"
                + "order by price desc\n"
                + " offset ? rows fetch next 6 rows only";
        try {
            ps = con.prepareStatement(xSql);
             ps.setString(1, "%"+name+"%");
            ps.setInt(2, (index - 1) * 6);
            rs = ps.executeQuery();
            while (rs.next()) {
                t.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5), rs.getString(6)));
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (t);
    }

    public List<Product> pagingProductdesc(int index, int cid) { // from worker and province tables
        List<Product> t = new ArrayList<Product>();
        xSql = "select * from Product \n"
                + "where cid=?\n"
                + "order by id desc\n"
                + " offset ? rows fetch next 6 rows only";
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, cid);
            ps.setInt(2, (index - 1) * 6);
            rs = ps.executeQuery();
            while (rs.next()) {
                t.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5), rs.getString(6)));
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (t);
    }
    
     public List<Product> pagingProductbyPriceIn(int index, int cid) { // from worker and province tables
        List<Product> t = new ArrayList<Product>();
        xSql = "select * from Product \n"
                + "where cid=?\n"
                + "order by price \n"
                + " offset ? rows fetch next 6 rows only";
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, cid);
            ps.setInt(2, (index - 1) * 6);
            rs = ps.executeQuery();
            while (rs.next()) {
                t.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5), rs.getString(6)));
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (t);
    }

    public List<Product> pagingProductbyPriceDesc(int index, int cid) { // from worker and province tables
        List<Product> t = new ArrayList<Product>();
        xSql = "select * from Product \n"
                + "where cid=?\n"
                + "order by price desc\n"
                + " offset ? rows fetch next 6 rows only";
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, cid);
            ps.setInt(2, (index - 1) * 6);
            rs = ps.executeQuery();
            while (rs.next()) {
                t.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5), rs.getString(6)));
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (t);
    }

    public List<Product> getProductListbyCID(int cid) { // from worker and province tables
        List<Product> t = new ArrayList<Product>();
        xSql = "select * from Product where cid=?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, cid);
            rs = ps.executeQuery();
            while (rs.next()) {
                t.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5), rs.getString(6)));
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (t);
    }

    /**
     *
     * getProduct by id
     *
     * @param id
     */
    public Product getProductbyID(int id) {
        xSql = "select * from Product where id=?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5), rs.getString(6));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    public Product getLastProduct() {
        xSql = "select top 1 * from Product  order by id desc";
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5), rs.getString(6));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    public List<Category> getCategoryList() { // from worker and province tables
        List<Category> t = new ArrayList<Category>();
        xSql = "select * from Category";
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            while (rs.next()) {
                t.add(new Category(rs.getInt(1), rs.getString(2)));
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (t);
    }

    public Category getCategorybyID(int id) {
        xSql = "select * from Category where id=?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Category(rs.getInt(1), rs.getString(2));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    public List<Product> getProductbyName(String name) {
        List<Product> t = new ArrayList<Product>();
        xSql = "select * from Product where name like ?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, "%" + name + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                t.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5), rs.getString(6)));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return t;

    }

    public List<Product> getProductbyName(String name, int cid) {
        List<Product> t = new ArrayList<Product>();
        xSql = " select * from Product \n"
                + "where name like ? and cid=?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, "%" + name + "%");
            ps.setInt(2, cid);
            rs = ps.executeQuery();
            while (rs.next()) {
                t.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5), rs.getString(6)));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return t;

    }

    public int getTotalProduct(String name, int cid) {
        xSql = "select count(*) from Product where name like ? and cid=?";

        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, "%" + name + "%");
            ps.setInt(2, cid);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int getTotalProduct(String name) {
        if (name.equals("")) {
            xSql = "select count(*) from Product";
        } else {
            xSql = "select count(*) from Product where name like ?";
        }
        try {
            ps = con.prepareStatement(xSql);
            if (!name.equals("")) {
                ps.setString(1, "%" + name + "%");
            }
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int getTotalProduct(int id) {
        xSql = "select count(*) from Product where cid=?";

        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int getTotalProductbySellID(int id) {
        xSql = "select count(*) from Product where sid=?";

        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int getCidProduct(int id) {
        xSql = "select cid from Product where id=?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public Account login(String user, String pass) {
        xSql = "select * from Account where username=? and password=?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, user);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Account(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getBoolean(4));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /* 
    signUp
     */
    public void signUp(String user, String pass, String name, String address, String number) {
        xSql = "insert into Account values(?,?,0)";
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, user);
            ps.setString(2, pass);
            ps.executeUpdate();
            xSql = "select top 1 id from [Account] order by id desc";
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            if (rs.next()) {
                int aid = rs.getInt(1);
                xSql = "insert into Customer values(?,?,?,?)";
                ps = con.prepareStatement(xSql);
                ps.setString(1, name);
                ps.setString(2, number);
                ps.setString(3, address);
                ps.setInt(4, aid);
                ps.executeUpdate();
            }
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* 
    deleteProduct
     */
    public void deleteProduct(int pid) {
        xSql = "delete from SizeProduct where pid=?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, pid);
            ps.executeUpdate();
            xSql = "delete from Product where id=?";
            ps = con.prepareStatement(xSql);
            ps.setInt(1, pid);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* 
    updateProduct
     */
    public void updateProduct(int id, String name, String image, double price, String title, String description, int cid) {
        xSql = "update Product\n"
                + "set [name]=?,[image]=?,price=?,title=?,[description]=?,cid=?\n"
                + "where id=?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, name);
            ps.setString(2, image);
            ps.setDouble(3, price);
            ps.setString(4, title);
            ps.setString(5, description);
            ps.setInt(6, cid);
            ps.setInt(7, id);

            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void insertProduct(String name, String image, double price, String title, String description, int cid) {
        xSql = "insert into Product values(?,?,?,?,?,?)";
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, name);
            ps.setString(2, image);
            ps.setDouble(3, price);
            ps.setString(4, title);
            ps.setString(5, description);
            ps.setInt(6, cid);
            ps.executeUpdate();
            xSql = "select top 1 id from [Product] order by id desc";
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            if (rs.next()) {
                int pid = rs.getInt(1);
                xSql = "select id from Size";
                ps = con.prepareStatement(xSql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    xSql = "insert into SizeProduct values(?,?,0)";
                    ps = con.prepareStatement(xSql);
                    ps.setInt(1, pid);
                    ps.setInt(2, rs.getInt(1));
                    ps.executeUpdate();
                }
            }
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    

    public Customer getCusByAid(int aid) {
        xSql = "select * from Customer where aid=?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, aid);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
     public Customer getCusByid(int id) {
        xSql = "select * from Customer where id=?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /* 
    checkAccountExist
     */
    public Account checkAccountExist(String user) {
        xSql = "select * from Account where username=?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, user);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Account(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getBoolean(4));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void addCustomer(String name, String address, String number, String aid) {
        xSql = "insert into [Customer] values(?,?,?,?)";
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, name);
            ps.setString(2, number);
            ps.setString(3, address);
            ps.setString(4, aid);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void updateCustomer(String name, String address, String number, String aid) {
        xSql = "update customer set name=?,phoneNumber=?,address=? where aid=?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, name);
            ps.setString(2, number);
            ps.setString(3, address);
            ps.setString(4, aid);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public Customer getLastCustomer() {
        xSql = "select top 1 * from [Customer] order by id desc";
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            if (rs.next()) {
                return new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
            }
        } catch (Exception e) {
        }
        return null;
    }

    /**
     * Add to order
     *
     * @param c
     * @param cart
     */
    public void addOrder(Customer c, Cart cart) {
        LocalDate curDate = LocalDate.now();
        String date = curDate.toString();
        xSql = "insert into [Order] values(?,?,?)";
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, date);
            ps.setInt(2, c.getId());
            ps.setDouble(3, cart.getTotalMoney());
            ps.executeUpdate();
            //lay id vua add
            xSql = "select top 1 id from [Order] order by id desc";
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            //add bang orderDetail
            if (rs.next()) {
                int oid = rs.getInt(1);
                for (Item i : cart.getItems()) {
                    xSql = "insert into [OrderDetail] values(?,?,?,?,?)";
                    ps = con.prepareStatement(xSql);
                    ps.setInt(1, oid);
                    ps.setInt(2, i.getProduct().getId());
                    ps.setInt(3, i.getSize().getId());
                    ps.setInt(4, i.getQuantity());
                    ps.setDouble(5, i.getPrice());
                    ps.executeUpdate();
                }
                xSql = "update SizeProduct set quantity=quantity-? where pid=? and sid=?";
                ps = con.prepareStatement(xSql);
                for (Item i : cart.getItems()) {
                    ps.setInt(1, i.getQuantity());
                    ps.setInt(2, i.getProduct().getId());
                    ps.setInt(3, i.getSize().getId());
                    ps.executeUpdate();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public int countProductById(int cid) {
        xSql = "select count(*) from product where cid=?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, cid);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static void main(String[] args) {
        DAO dao= new DAO();
        System.out.println(dao.getTotalOrder());
    }

}
