package controller;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
import entity.Account;
import entity.Cart;
import entity.Category;
import entity.Item;
import entity.ProductSize;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.DAO;

/**
 *
 * @author User
 */
public class ProcessServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DAO dao = new DAO();
        Cookie[] arr = request.getCookies();
        String txt = "";
        if (arr != null) {
            for (Cookie o : arr) {
                if (o.getName().equals("cart")) {
                    txt += o.getValue();
                    o.setMaxAge(0);
                    response.addCookie(o);
                }
            }
        }
        Account a = (Account) request.getSession().getAttribute("acc");
        Cart cart = new Cart(txt, a);
        String num_raw = request.getParameter("num");
        String pid_raw = request.getParameter("pid");
        String sid_raw = request.getParameter("sid");
        int pid, num = 0, sid;
        try {
            pid = Integer.parseInt(pid_raw);
            sid = Integer.parseInt(sid_raw);
            num = Integer.parseInt(num_raw);
            ProductSize p = dao.getProductSize(pid, sid);
            int numstore = p.getQuantity();
            request.setAttribute("store", numstore);
            if (num == -1 && (cart.getQuantity(pid, sid) <= 1)) {
                cart.removeItem(pid, sid);
            } else {
                if (num == 1 && cart.getQuantity(pid, sid) >= numstore) {
                    num = 0;
                }
                double price = dao.getProductbyID(pid).getPrice();
                cart.addItem(new Item(dao.getProductbyID(pid), dao.getSizebyID(sid), num, price));
            }
        } catch (Exception e) {

        }
        List<Item> items = cart.getItems();
        txt = "";
        if (items.size() > 0) {
            if (a != null) {
                txt = a.getId() + ":" + items.get(0).getProduct().getId() + ":" + items.get(0).getSize().getId() + ":" + items.get(0).getQuantity();
                for (int i = 1; i < items.size(); i++) {
                    txt += "/" + a.getId() + ":" + items.get(i).getProduct().getId() + ":" + items.get(i).getSize().getId() + ":" + items.get(i).getQuantity();
                }

            } else {
                txt = 0 + ":" + items.get(0).getProduct().getId() + ":" + items.get(0).getSize().getId() + ":" + items.get(0).getQuantity();
                for (int i = 1; i < items.size(); i++) {
                    txt += "/" + 0 + ":" + items.get(i).getProduct().getId() + ":" + items.get(i).getSize().getId() + ":" + items.get(i).getQuantity();
                }
            }

        }

        int n;
        if (items != null) {
            n = items.size();
        } else {
            n = 0;
        }
        request.getSession().setAttribute("amount", n);
        List<Category> listC = dao.getCategoryList();

        request.setAttribute("listC", listC);
        request.setAttribute("tag", "Cart");
        request.setAttribute("detail", dao.getLastProduct());
        Cookie c = new Cookie("cart", txt);

        c.setMaxAge(2 * 24 * 60 * 60);
        response.addCookie(c);
        request.setAttribute("car", cart);
        request.setAttribute("cart", items);
        request.setAttribute("current", "Pages");
        request.getRequestDispatcher("cart.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DAO dao = new DAO();
        Cookie[] arr = request.getCookies();
        String txt = "";
        if (arr != null) {
            for (Cookie o : arr) {
                if (o.getName().equals("cart")) {
                    txt += o.getValue();
                    o.setMaxAge(0);
                    response.addCookie(o);
                }
            }
        }
        Account a = (Account) request.getSession().getAttribute("acc");
        String pid = request.getParameter("pid");
        String sid = request.getParameter("sid");
        String[] ids = txt.split("/");
        String out = "";
        for (int i = 0; i < ids.length; i++) {
            String[] s = ids[i].split(":");
            if (a != null) {
                if (!(s[0].equals("" + a.getId()) && s[1].equals(pid) && s[2].equals(sid))) {
                    if (out.isEmpty()) {
                        out = ids[i];
                    } else {
                        out += "/" + ids[i];
                    }
                }
            } else {
                if (!(s[0].equals("0") && s[1].equals(pid) && s[2].equals(sid))) {
                    if (out.isEmpty()) {
                        out = ids[i];
                    } else {
                        out += "/" + ids[i];
                    }
                }
            }
        }
        if (!out.isEmpty()) {
            Cookie c = new Cookie("cart", out);
            c.setMaxAge(60 * 60 * 2 * 24);
            response.addCookie(c);
        }
        List<Category> listC = dao.getCategoryList();

        request.setAttribute("listC", listC);
        request.setAttribute("tag", "Cart");
        request.setAttribute("detail", dao.getLastProduct());
        Cart cart = new Cart(out, a);
        List<Item> items = cart.getItems();
        int n;
        if (items != null) {
            n = items.size();
        } else {
            n = 0;
        }
        request.getSession().setAttribute("amount", n);
        request.setAttribute("car", cart);
        request.setAttribute("cart", items);
        request.setAttribute("current", "Pages");
        request.getRequestDispatcher("cart.jsp").forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
