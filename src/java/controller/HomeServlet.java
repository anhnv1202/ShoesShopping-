/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import entity.Account;
import entity.Cart;
import entity.Product;
import entity.Category;
import entity.Item;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.*;

/**
 *
 * @author User
 */
public class HomeServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pr = response.getWriter();
        DAO dao = new DAO();
        List<Product> list = dao.getProductList();
        List<Category> listC = dao.getCategoryList();
        request.setAttribute("listP", list);
        request.setAttribute("listC", listC);
        request.setAttribute("tag", "OUT SHOP");
        request.setAttribute("current", "home");
        request.setAttribute("detail", dao.getLastProduct());
        Cookie[] arr = request.getCookies();
        String txt = "";
        Account a = (Account) request.getSession().getAttribute("acc");
        if (arr != null) {
            for (Cookie o : arr) {
                if (o.getName().equals("cart")) {
                    txt += o.getValue();
                }
            }
        }
        Cart cart = new Cart(txt, a);
        List<Item> listItem = cart.getItems();
        int n;
        if (listItem != null) {
            n = listItem.size();
        } else {
            n = 0;
        }
        if (a != null && !txt.isEmpty()) {
            if (arr != null) {
                for (Cookie o : arr) {
                    if (o.getName().equals("cart")) {
                        o.setMaxAge(0);
                        response.addCookie(o);
                    }
                }
            }
            String p[] = txt.split("/");
            txt = "";
            for (int i = 0; i < p.length; i++) {
                String k[] = p[i].split(":");
                if (k[0].equals("0")) {
                    k[0] = "" + a.getId();
                }
                if (i == 0) {
                    txt += k[0] + ":" + k[1] + ":" + k[2] + ":" + k[3];
                } else {
                    txt += "/" + k[0] + ":" + k[1] + ":" + k[2] + ":" + k[3];
                }
            }
            Cookie c = new Cookie("cart", txt);
            c.setMaxAge(60 * 60 * 24 * 2);
            response.addCookie(c);
        }

        request.getSession().setAttribute("amount", n);

        request.getRequestDispatcher("home.jsp").forward(request, response);

    }

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
        processRequest(request, response);
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
        processRequest(request, response);
    }

}
