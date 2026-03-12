<%-- 
    Document   : sa
    Created on : Jan 31, 2026, 9:23:05 PM
    Author     : Toan
--%>

<%@page import="model.dto.CategoryDTO"%>
<%@page import="model.dto.CategoryDTO"%>
<%@page import="model.dto.ProductDTO"%>
<%@page import="model.dto.ProductDTO"%>
<%@page import="model.dto.ProductDTO"%>
<%@page import="model.dto.UserDTO"%>
<%@page import="model.dto.UserDTO"%>

<%@page import="java.util.List"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <!DOCTYPE html>
    <html lang="vi">
        <head>
            <meta charset="UTF-8">
            <title>Admin Dashboard</title>
            <link rel="stylesheet" href="css/admin.css"/>
        </head>
        <body>
            <%
                UserDTO loginUser = (UserDTO) session.getAttribute("LOGIN_USER");
                if (loginUser == null || !"AD".equals(loginUser.getRoleID())) {
                    loginUser = new UserDTO();
                    response.sendRedirect("login.jsp");
                    return;
                }
            %>
            <% String pageType = (String) request.getAttribute("LIST_TYPE");%>

            <div class="container">



                <!-- Sidebar -->
                <aside class="sidebar">
                    <form action="MainController" method="post">
                        <div class="avatar">admin</div>
                        <ul>
                            <li>
                                <button class="menu-item"
                                        name="action" value="PRODUCT_GETALL" >
                                    Product
                                </button>
                            </li>
                            <li>
                                <button class="menu-item "
                                        name="action" value="CATEGORY_GETALL">
                                    Category
                                </button>
                            </li>
                            <li>
                                <button class="menu-item"
                                        name="action" value="USER_GETALL">
                                    User
                                </button>
                            </li>
                            <li class="bottom">Settings</li>
                        </ul>
                    </form>
                    
                    
                    <div>
                        <form action="MainController" method="post">
                            <input type="submit" name="action" value="USER_LOGOUT">
                        </form>
                    </div>
                </aside>



                <!-- Main -->
                <main class="main">

                    <!-- Search -->
                    <div class="top-bar">

                        <form action="MainController" method="get">
                            <input type="text" placeholder="Search...">
                            <input type="submit" name="action" value="Search">
                        </form>
                    </div>

                    <!-- Table -->

                    <table class="table">
                        <thead>
                            <tr>
                                <th>ID</th>



                                <% if ("PRODUCT".equals(pageType)) { %>
                                <th>Name</th>
                                <th>Price</th>
                                <th>Category</th>

                                <% } else if ("CATEGORY".equals(pageType)) { %>
                                <th>Category Name</th>

                                <% } else if ("USER".equals(pageType)) { %>
                                <th>User ID</th>
                                <th>Full Name</th>
                                <th>Role</th>
                                    <% }%>

                                <th>Action</th>
                            </tr>
                        </thead>
                        <tbody>
                            <% if ("PRODUCT".equals(pageType)) {
                                    List<ProductDTO> list
                                            = (List<ProductDTO>) request.getAttribute("PRODUCT_LIST");

                                    if (list != null) {
                                        for (ProductDTO p : list) {%>
                            <tr>
                                <td><%= p.getProductId()%></td>
                                <td><%= p.getProductName()%></td>
                                <td><%= p.getPrice()%></td>
                                <td><%= p.getCategoryId()%></td>
                                <td class="action">
                                    <form action="MainController" method="post">
                                        <input type="hidden" name="productId" value="${p.getProductId()}">
                                        <button type="subAction" name="action" value="add_product" class="add">+</button>
                                        <button type="subAction" name="action" value="view_product" class="view">👁</button>
                                        <button type="subAction" name="action" value="edit_product" class="edit">✏</button>
                                        <button type="subAction" name="action" value="delete_product" class="delete">🗑</button>
                                    </form>

                                </td>
                            </tr>
                            <%      }
                                    }
                                }%>
                            <% if ("CATEGORY".equals(pageType)) {
                                    List<CategoryDTO> list
                                            = (List<CategoryDTO>) request.getAttribute("CATEGORY_LIST");

                                    if (list != null) {
                                        for (CategoryDTO c : list) {%>
                            <tr>
                                <td><%= c.getCategory_id()%></td>
                                <td><%= c.getCategory_name()%></td>
                                <td class="action">
                                    <form action="MainController" method="post">
                                        <input type="hidden" name="CategoryId" value="${c.getCategory_id()}">
                                        <button type="submit" name="subAction" value="add_Category" class="add">+</button>
                                        <button type="submit" name="subAction" value="view_Category" class="view">👁</button>
                                        <button type="submit" name="subAction" value="edit_Category" class="edit">✏</button>
                                        <button type="submit" name="subAction" value="delete_Category" class="delete">🗑</button>
                                    </form>
                                </td>
                            </tr>
                            <%      }
                                    }
                                }%>
                            <% if ("USER".equals(pageType)) {
                                    List<UserDTO> list
                                            = (List<UserDTO>) request.getAttribute("USER_LIST");

                                    if (list != null) {
                                        for (UserDTO u : list) {%>
                            <tr>
                                <td><%= u.getUserID()%></td>
                                <td><%= u.getFullname()%></td>
                                <td><%= u.getRoleID()%></td>
                                <td class="action">
                                    <input type="hidden" name="UserId" value="${u.getUserID()}">
                                    <button type="submit" name="subAction" value="add_User" class="add">+</button>
                                    <button type="submit" name="subAction" value="view_User" class="view">👁</button>
                                    <button type="submit" name="subAction" value="edit_User" class="edit">✏</button>
                                    <button type="submit" name="subAction" value="delete_User" class="delete">🗑</button>
                                </td>
                            </tr>
                            <%      }
                                    }
                                }%>
                        </tbody>

                    </table>

                    <!-- Footer -->
                    <div class="table-footer">
                        <span>Showing 1–10</span>
                        <div class="pagination">
                            <button>&lt;</button>
                            <button class="active">1</button>
                            <button>2</button>
                            <button>&gt;</button>
                        </div>
                    </div>

                </main>
                        
                        
                        
                        
                        

            </div>

        </body>
    </html>

</body>
</html>
