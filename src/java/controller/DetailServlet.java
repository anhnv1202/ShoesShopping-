package controller;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import entity.Cart;
import entity.Product;
import entity.Category;
import entity.Item;
import entity.ProductSize;
import entity.Size;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import model.*;

/**
 *
 * @author User
 */
public class DetailServlet extends HttpServlet {

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
        int id= Integer.parseInt(request.getParameter("pid"));
        DAO dao= new DAO();
        String size= request.getParameter("sid");
        if(size!=null){
            request.setAttribute("size",Integer.parseInt(size));
             ProductSize p= dao.getProductSize(id, Integer.parseInt(size));
            int numstore=p.getQuantity();
             request.setAttribute("numstore",numstore);
        }
        
        Product pro= dao.getProductbyID(id);
        request.setAttribute("detail", pro);
         request.setAttribute("tag", pro.getName());
        List<Category> listC= dao.getCategoryList();
        request.setAttribute("listC",listC);
        request.setAttribute("current", "detail");
        List<Size> listS= new ArrayList<Size>();
        List<ProductSize> listPS= dao.productSizelist(id);
        if(!listPS.isEmpty()){
        for (ProductSize list: listPS) {
            if(list.getQuantity()>0){
                listS.add(dao.getSizebyID(list.getSid()));
            }
        }
        }
         
         String num=request.getParameter("num");
          int nums,quantity=1;
         if(num!=null){
             String num_raw=request.getParameter("numm");
                quantity=Integer.parseInt(num);
             nums=Integer.parseInt(num_raw);
             ProductSize p= dao.getProductSize(id, Integer.parseInt(size));
             int numstore=p.getQuantity();
             if(nums==-1&&quantity!=1){
                 quantity=quantity-1;
             }
              if(nums==1 && quantity < numstore){
                     quantity=quantity+1;
              }
        } else quantity=1;
         request.setAttribute("listP", dao.getProductListbyCID(dao.getCategoryIdbyPid(id)));
       request.setAttribute("num", quantity);
        request.setAttribute("listS", listS);
        request.getRequestDispatcher("detail.jsp").forward(request, response);
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
