/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import entity.Cart;
import helper.Helper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import entity.Category;
import entity.Item;
import entity.Product;
import jakarta.servlet.http.Cookie;
import model.DAO;

/**
 *
 * @author User
 */
public class ShopServlet extends HttpServlet {

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
        List<Category> listC = dao.getCategoryList();
        String id = request.getParameter("cid");
        String index = request.getParameter("index");
        String search = request.getParameter("search");
        String sort = request.getParameter("sort");
        List<Product> list=new ArrayList<>();
        if(sort==null){
            sort="0";
        }
       
        int count=-1;
        if (index == null) {
            index = "1";
        }
        int indexpage = Integer.parseInt(index);
        
        if (id == null || id.equals("0") && (search==null || search.equals("") )) {
            count = dao.getTotalProduct("");
            request.setAttribute("cid", 0);
                if(sort.equals("1")){
                list = dao.pagingProductDesc(indexpage);  
                 
                }else if(sort.equals("2")){
                     list = dao.pagingProductbyPriceIn(indexpage); 
                }
                else if(sort.equals("3")){
                     list = dao.pagingProductbyPriceDown(indexpage); 
                }
                else{
                     list = dao.pagingProduct(indexpage);
                }
            request.setAttribute("sort", sort);
            
            
             
             request.setAttribute("tag", "OUT SHOP");
        }
        else if ( !id.equals("") && !id.equals("0") && id != null && (search==null || search.equals(""))) {
            count = dao.getTotalProduct(Integer.parseInt(id));
            request.setAttribute("tag", dao.getCategorybyID(Integer.parseInt(id)).getName());
            request.setAttribute("cid", dao.getCategorybyID(Integer.parseInt(id)).getId());
            if(sort.equals("1")){
                list = dao.pagingProductdesc(indexpage,Integer.parseInt(id));  
                 
                }else if(sort.equals("2")){
                     list = dao.pagingProductbyPriceIn(indexpage, Integer.parseInt(id)); 
                }
                else if(sort.equals("3")){
                     list = dao.pagingProductbyPriceDesc(indexpage, Integer.parseInt(id)); 
                }
                else{
                     list = dao.pagingProduct(indexpage,Integer.parseInt(id));
                }
               request.setAttribute("sort", sort);
            
        } 
        else if(id.equals("") || id.equals("0")) {
            count = dao.getTotalProduct(search);
            if(sort.equals("1")){
                list = dao.pagingProductdesc(indexpage,search);  
                 
                }else if(sort.equals("2")){
                     list = dao.pagingProductbyPriceIn(indexpage,search); 
                }
                else if(sort.equals("3")){
                     list = dao.pagingProductbyPriceDesc(indexpage, search); 
                }
                else{
                     list = dao.pagingProduct(indexpage, search);
                }
               request.setAttribute("sort", sort);
            
            request.setAttribute("tag", search);
            request.setAttribute("search", search);
        }
        else if(!id.equals("")&& search!=null){
             count = dao.getTotalProduct(search,Integer.parseInt(id));
             if(sort.equals("1")){
                list = dao.pagingProductdesc(indexpage,search,Integer.parseInt(id));  
                 
                }else if(sort.equals("2")){
                     list = dao.pagingProductbyPriceIn(indexpage,search,Integer.parseInt(id)); 
                }
                else if(sort.equals("3")){
                     list = dao.pagingProductbyPriceDesc(indexpage, search,Integer.parseInt(id)); 
                }
                else{
                     list = dao.pagingProduct(indexpage, search,Integer.parseInt(id));
                }
               request.setAttribute("sort", sort);
            request.setAttribute("tag",dao.getCategorybyID(Integer.parseInt(id)).getName() +"-"+search);
              request.setAttribute("cid", id);
            request.setAttribute("search", search);
        }
        int endPage = Helper.getEndp(count);
        request.setAttribute("endP", endPage);
        request.setAttribute("listP", list);
        request.setAttribute("listC", listC);
        request.setAttribute("tagg", indexpage);
         request.setAttribute("current", "shop");
         request.setAttribute("detail", dao.getLastProduct());
        request.getRequestDispatcher("shop.jsp").forward(request, response);

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
