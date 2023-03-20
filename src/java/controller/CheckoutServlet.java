/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import entity.Account;
import entity.Cart;
import entity.Category;
import entity.Customer;
import java.io.IOException;
import java.io.PrintWriter;
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
public class CheckoutServlet extends HttpServlet {

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
        DAO d = new DAO();
        Account a = (Account) request.getSession().getAttribute("acc");
        if (a != null) {
            request.setAttribute("cus", d.getCusByAid(a.getId()));
        }
        Cookie[] arr = request.getCookies();
        PrintWriter pr = response.getWriter();
        String txt = "";
        if (arr != null) {
            for (Cookie o : arr) {
                if (o.getName().equals("cart")) {
                    txt += o.getValue();
                }
            }
        }
        Cart cart = new Cart(txt, a);
        request.setAttribute("cart", cart);
        request.setAttribute("listCart", cart.getItems());
        List<Category> listC = d.getCategoryList();
        request.setAttribute("listC", listC);
        request.setAttribute("tag", "Checkout");
        request.setAttribute("current", "pages");
        request.setAttribute("detail", d.getLastProduct());

        request.getRequestDispatcher("checkout.jsp").forward(request, response);
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
        Cookie[] arr = request.getCookies();
        PrintWriter pr = response.getWriter();
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
        DAO dao = new DAO();
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        if (a != null) {
            Customer cus = dao.getCusByAid(a.getId());
            if (!name.equals(cus.getName()) || !phone.equals(cus.getPhoneNumber()) || !address.equals(cus.getAddress())) {
                dao.updateCustomer(name, address, phone, "" + a.getId());
                cus=dao.getCusByAid(a.getId());
                dao.addOrder(cus, cart);
                
            }
            dao.addOrder(cus, cart);

        } else {
            dao.addCustomer(name, address, phone, null);
            dao.addOrder(dao.getLastCustomer(), cart);
        }
        String[] ids = txt.split("/");
        String out = "";
        for (int i = 0; i < ids.length; i++) {
            String[] s = ids[i].split(":");
            if (a != null) {
                if (!s[0].equals("" + a.getId())) {
                    if (out.isEmpty()) {
                        out = ids[i];
                    } else {
                        out += "/" + ids[i];
                    }
                }
            } else {
                if (!s[0].equals("0") ) {
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
        response.sendRedirect("home");
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
