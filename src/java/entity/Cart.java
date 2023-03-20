/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.ArrayList;
import java.util.List;
import model.DAO;

/**
 *
 * @author User
 */
public class Cart {

    private List<Item> items;

    public Cart() {
        items = new ArrayList<>();
    }

    public List<Item> getItems() {
        return items;
    }

    public int getQuantity(int pid, int sid) {
        return getItem(pid, sid).getQuantity();
    }

    private Item getItem(int pid, int sid) {
        for (Item i : items) {
            if (i.getProduct().getId() == pid && i.getSize().getId() == sid) {
                return i;
            }
        }
        return null;
    }

    public void addItem(Item t) {
        Item m = getItem(t.getProduct().getId(), t.getSize().getId());
        if (m != null) {
            m.setQuantity(m.getQuantity() + t.getQuantity());
        } else {
            items.add(t);
        }
    }

    public void removeItem(int pid, int sid) {
        Item i = getItem(pid, sid);
        if (i != null) {
            items.remove(i);
        }
    }

    public double getTotalMoney() {
        double t = 0;
        for (Item i : items) {
            t += (i.getQuantity() * i.getPrice());
        }
        return t;
    }

    public Cart(String txt, Account acc) {
        items = new ArrayList();
        DAO d = new DAO();
            try {
                if (txt != null && txt.length() != 0) {
                    String[] s = txt.split("/");
                    for (String i : s) {
                        String[] n = i.split(":");
                        int aid=  Integer.parseInt(n[0]);
                        int pid = Integer.parseInt(n[1]);
                        int sid = Integer.parseInt(n[2]);
                        int quantity = Integer.parseInt(n[3]);
                        Product p = d.getProductbyID(pid);
                        Size size = d.getSizebyID(sid);
                           if (acc != null) {
                        if(aid==0|| aid==acc.getId())
                        addItem(new Item(p, size, quantity, p.getPrice()));
                           } else{
                               if(aid==0) addItem(new Item(p, size, quantity, p.getPrice()));
                           }
                    }
                }
            } catch (Exception e) {

            }
        
    }

    public static void main(String[] args) {
        Cart cart = new Cart("1:108:1:1/1:108:2:1/0:1:2:1",new Account(1, "vietanh", "120202", true));
        for (Item i : cart.getItems()) {
            System.out.println(i.getProduct().getName());
        }
 

    }

}
