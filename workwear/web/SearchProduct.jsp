<%-- 
    Document   : SearchProduct
    Created on : Jan 28, 2026, 11:03:01 AM
    Author     : Toan
--%>

<%@page import="java.util.List"%>
<%@page import="model.ProductDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/search.css"/>
        <title>Product</title>
    </head>
    <body>
        <!-- header-->
        <header class="header">
            <div class="logo">
                <img src="img/products/LOGO.png" alt="alt"/>
            </div>

            <nav class="menu">
                <a href="#">Home</a>
                <a href="#">Sale</a>
                <a href="#">Man</a>
                <a href="#">Woman</a>
            </nav>

            <div class="search">
                <form action="MainController" method="post">
                    <input type="text" name="search" placeholder="Search...">
                    <input type="submit" name="action" value="Search">
                </form>
            </div>

            <div class="login">
                <a href="login.jsp">Login</a>
            </div>
        </header>
        <main>
            <%
                List<ProductDTO> list = (List<ProductDTO>) request.getAttribute("LIST_PRODUCT");
            %>


            <%if (list != null && !list.isEmpty()) {%>
            <div class="product_list">
                <% for (ProductDTO pr : list) {%>
                <div class="product_card">
                
                    <img src="img/products/<%= pr.getImage() %>" alt="product"/>

                    <h3><%= pr.getProductName()%></h3>
                    <p class="Price">
                        <%= pr.getPrice()%>
                    </p>
                </div>
                <% }%>
            </div>
            <% } else if (list != null) {%> 
            <p>No products found</p>
            <% }%>
        </main>





        <!--footer-->
        <footer class="footer1">
            <div class="footer-top">
                <div class="footer-logo">
                    <h2>Khatann<br></h2>
                </div>

                <div class="footer-cols">
                    <div class="col">
                        <h4>Accessibility</h4>
                        <a href="#">Accessibility Statement</a>
                        <a href="#">ADA Compliance</a>
                        <a href="#">Assistive Technologies</a>
                        <a href="#">Accessibility Resources</a>
                        <a href="#">Design Guidelines</a>
                    </div>

                    <div class="col">
                        <h4>Store</h4>
                        <a href="#">Shop Now</a>
                        <a href="#">Product Categories</a>
                        <a href="#">Special Offers</a>
                        <a href="#">New Releases</a>
                        <a href="#">Exclusive Deals</a>
                    </div>

                    <div class="col">
                        <h4>Partnerships</h4>
                        <a href="#">Partners</a>
                        <a href="#">Affiliates</a>
                        <a href="#">Collaborations</a>
                        <a href="#">Strategic Alliances</a>
                    </div>

                    <div class="col">
                        <h4>Communities</h4>
                        <a href="#">Contributors</a>
                        <a href="#">Community Engagement</a>
                        <a href="#">Events</a>
                        <a href="#">Volunteer Opportunities</a>
                        <a href="#">Community Partnerships</a>
                    </div>
                </div>

                <div class="social">
                    <a href="#">⭘</a>
                    <a href="#">⭘</a>
                    <a href="#">⭘</a>
                    <a href="#">⭘</a>
                </div>
            </div>

            <div class="footer-bottom">
                <p>© 2024. All Rights Reserved.</p>
                <div class="footer-links">
                    <a href="#">Shipping</a>
                    <a href="#">Refund</a>
                    <a href="#">Warranty</a>
                    <a href="#">Privacy</a>
                    <a href="#">Security</a>
                </div>
            </div>
        </footer>

    </body>
</html>
