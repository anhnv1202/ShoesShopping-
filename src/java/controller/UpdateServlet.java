/*

 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import entity.Category;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.DAO;

/**
 *
 * @author User
 */
@WebServlet(name = "UpdateServlet", urlPatterns = {"/update"})
public class UpdateServlet extends HttpServlet {

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
       String pid= request.getParameter("pid");
        String index= request.getParameter("index");
        String confirm= request.getParameter("confirm");
        DAO dao = new DAO();
         List<Category> listC = dao.getCategoryList();
        if(confirm.equals("0")){
            request.setAttribute("pro",dao.getProductbyID(Integer.parseInt(pid)) );
            request.setAttribute("index", index);
            request.setAttribute("listS", dao.sizelist());
            request.setAttribute("cid", dao.getCidProduct(Integer.parseInt(pid)));
            request.setAttribute("listC", listC);
            request.getRequestDispatcher("update.jsp").forward(request, response);
        }
        else{
        String sid= request.getParameter("size");
         String quantity= request.getParameter("quantity");
         if(!quantity.equals("")){
            dao.updateSize(Integer.parseInt(pid), Integer.parseInt(sid),Integer.parseInt(quantity));
         }
        String name = request.getParameter("name");
        String image = request.getParameter("image");
        String price = request.getParameter("price");
        double pricee=Double.parseDouble(price);
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String category = request.getParameter("category");
        int cid= Integer.parseInt(category);
        dao.updateProduct(Integer.parseInt(pid), name, image, pricee, title, description, cid);
        request.setAttribute("indexx", index);
        request.getRequestDispatcher("managerproduct").forward(request, response);
        }
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
