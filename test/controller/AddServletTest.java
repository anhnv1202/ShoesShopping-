/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package controller;

import entity.Product;
import helper.Helper;
import jakarta.servlet.AsyncContext;
import jakarta.servlet.DispatcherType;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpUpgradeHandler;
import jakarta.servlet.http.Part;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.DAO;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.runners.MockitoJUnitRunner;
import org.powermock.api.mockito.PowerMockito;

/**
 *
 * @author Chold
 */
@RunWith(MockitoJUnitRunner.class)//
public class AddServletTest {

    @Mock
    AddServlet addServlet; // 

    /**
     * Test if AddServlet processes request correctly and redirects after
     * doPost().
     *
     * @throws Exception if there is any exception
     */

    @Test
    public void testProcessRequest() {
        // Tạo mock objects cho HttpServletRequest, HttpServletResponse và DAO
        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
        HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
        DAO dao = Mockito.mock(DAO.class);
        // Thiết lập các giá trị cho các tham số của request
//        Mockito.when(request.getParameter("name")).thenReturn("Product Name");
//        Mockito.when(request.getParameter("image")).thenReturn("product.jpg");
        Mockito.when(request.getParameter("index")).thenReturn("1");
//        Mockito.when(request.getParameter("price")).thenReturn("10.99");
//        Mockito.when(request.getParameter("title")).thenReturn("Product Title");
//        Mockito.when(request.getParameter("description")).thenReturn("Product Description");
//        Mockito.when(request.getParameter("category")).thenReturn("fadsfads");

        try {
            PowerMockito.whenNew(DAO.class).withNoArguments().thenReturn(dao);
            addServlet.processRequest(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
            fail();
        }
    } 
    }

//    @Test
//public void testAddServletWithNegativePriceInput() throws Exception {
//    
//    // Set up fake parameters with negative price value.
//    when(request.getParameter("name")).thenReturn("Product Name");
//    when(request.getParameter("image")).thenReturn("product.jpg");
//    when(request.getParameter("price")).thenReturn("-30.5");
//    when(request.getParameter("title")).thenReturn("Product Title");
//    when(request.getParameter("description")).thenReturn("Product Description");
//    when(request.getParameter("category")).thenReturn("1");
//
//     addServlet.processRequest(request, response);
//
//    verify(response, never()).sendRedirect("managerproduct");
//}

