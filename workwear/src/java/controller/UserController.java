/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.dto.UserDTO;
import service.UserService;

/**
 *
 * @author Toan
 */
@WebServlet(name = "UserController", urlPatterns = {"/UserController"})
public class UserController extends HttpServlet {

    private static final String LOGIN = "LOGIN";
    private static final String LOGOUT = "LOGOUT";
    private static final String GETBYID = "GETBYID";
    private static final String GETALL = "GETALL";
    private static final String CREATE = "CREATE";
    private static final String DELETE = "DELETE";
    private static final String UPDATE = "UPDATE";
    private static final String ERROR = "home.jsp";
    private static final String SUCCESS = "home.jsp";
    private static final String ADMIN_PAGE = "sa.jsp";
    private static final String USER_PAGE = "user.jsp";
    private static final String LOGIN_PAGE = "login.jsp";
    private static final String AD = "AD";
    private static final String US = "US";
    private static final String INCORRECT_MESSAGE = "Incorrect userId or password";
    private static final String NOT_SUPPORT_MESSAGE = "NYour role is not support!";
    private static final String TEST = "login.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");
        String group = "";

        if (action != null && action.contains("_")) {
            group = action.split("_")[1];
        }
        UserService userservice = new UserService();

        String url = ERROR;
        try {
            switch (group) {
                case LOGIN:
                    url = LOGIN_PAGE;
                    String userId = request.getParameter("userID");
                    String password = request.getParameter("password");
                    UserDTO user = userservice.login(userId, password);
                    if (user != null) {
                        HttpSession session = request.getSession();
                        session.setAttribute("LOGIN_USER", user);
                        String roleID = user.getRoleID();
                        if (AD.equals(roleID)) {
                            url = ADMIN_PAGE;
                        } else if (US.equals(roleID)) {
                            url = USER_PAGE;
                        } else {
                            request.setAttribute("ERROR", NOT_SUPPORT_MESSAGE);
                            url = LOGIN_PAGE;
                        }
                    } else {
                        request.setAttribute("ERROR", INCORRECT_MESSAGE);
                        url = LOGIN_PAGE;
                    }
                    break;
                case GETBYID:
                    userservice.getById();
                    break;
                case GETALL:
                    userservice.getAll();
                    break;
                case CREATE:
                    userservice.createUser();
                    break;
                case DELETE:
                    userservice.deleteUser();
                    break;
                case UPDATE:
                    userservice.updateUser();
                    break;
                case LOGOUT:
                    HttpSession session = request.getSession(false);
                    if (session != null) {
                        session.invalidate();
                        url = SUCCESS;
                    }

                    break;

                default:
                    request.setAttribute("ERROR", "Action not supported");
                    url = ERROR;
                    break;

            }

        } catch (SQLException | ClassNotFoundException e) {
            log("Error at MainController: " + e.toString());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
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
