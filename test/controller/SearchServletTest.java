/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package controller;

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
import org.junit.runner.RunWith;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.powermock.api.mockito.PowerMockito;

/**
 *
 * @author Chold
 */
@RunWith(MockitoJUnitRunner.class)//
public class SearchServletTest {

    @Mock
    SearchServlet searchServlet; // 

    public SearchServletTest() {
    }

    /**
     * test case index is null
     */
//    @Test
//    public void processRequestTest01() {
//        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
//        HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
////        Mockito.doNothing().when(response).setContentType(anyString());
////        DAO dao = Mockito.mock(DAO.class);
//        try {
////            PowerMockito.whenNew(DAO.class).withNoArguments().thenReturn(dao);
////            Mockito.when(dao.pagingProduct(anyInt(), anyString())).thenReturn(new ArrayList<>());
////            Mockito.when(dao.getCategoryList()).thenReturn(new ArrayList<>());
////            Mockito.when(dao.getTotalProduct(anyString())).thenReturn(100);
//              searchServlet.processRequest(request, response);
//        } catch (Exception ex) {
//            ex.printStackTrace();
//            fail();
//        }
//    }

    /**
     * test case index is not null
     */
    @Test
    public void processRequestTest02() {
        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
        HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
        Mockito.when(request.getParameter("index")).thenReturn("1");
        DAO dao = Mockito.mock(DAO.class);
        try {
            PowerMockito.whenNew(DAO.class).withNoArguments().thenReturn(dao);
            searchServlet.processRequest(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
            fail();
        }
    }

    /**
     * test case throws ServletException
     */
//    @Test(expected = ServletException.class)
//    public void processRequestTest03() {
//        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
//        HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
//        RequestDispatcher dispatcher = Mockito.mock(RequestDispatcher.class);
//        try {
//            Mockito.when(request.getRequestDispatcher(anyString())).thenReturn(dispatcher);
//            Mockito.doThrow(ServletException.class).when(dispatcher).forward(any(), any());
//            searchServlet.processRequest(request, response);
//        } catch (Exception ex) {
//            ex.printStackTrace();
////            fail();
//        }
//    }
//
//    @Test
//    public void testProcessRequest() throws Exception {
//    }
//
//    @Test
//    public void testDoGet() throws Exception {
//    }
//
//    @Test
//    public void testDoPost() throws Exception {
//    }
//
//    @Test
//    public void testGetServletInfo() {
//    }
}
