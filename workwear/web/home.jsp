<%-- 
    Document   : home
    Created on : Jan 24, 2026, 1:56:40 PM
    Author     : Toan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Khatann</title>
        <link rel="stylesheet" href="css/style.css">
    </head>
    <body>
        <!-- header-->
        <header class="header">
            <div class="logo">
                <a href="MainController?action=Home">
                    <img src="img/products/LOGO.png" alt="Logo">
                </a>
            </div>


            <nav class="menu">
                <a href="MainController?action=Home">Home</a>
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

        <!--hero-->
        <div class="hero_banner">
            <img src="img/products/hero.png" alt="alt"/>
        </div>



        <!-- Categories / Featured -->
        <section class="categories">
            <h2>Categories</h2>

            <div class="category-list">

                <div class="category-item">
                    <img src="img/products/jacket.jpg" alt="Product 1">
                    <div class="info">
                        <h3>Basic T-Shirt</h3>
                        <p class="price">$19.99</p>
                    </div>
                </div>

                <div class="category-item">
                    <img src="img/products/knee.jpg" alt="Product 2">
                    <div class="info">
                        <h3>Summer Shirt</h3>
                        <p class="price">$29.99</p>
                    </div>
                </div>

                <div class="category-item">
                    <img src="img/products/jacket2.jpg" alt="Product 3">
                    <div class="info">
                        <h3>Casual Jacket</h3>
                        <p class="price">$59.99</p>
                    </div>
                </div>

                <div class="category-item">
                    <img src="img/products/tee.jpg" alt="Product 4">
                    <div class="info">
                        <h3>Denim Pants</h3>
                        <p class="price">$49.99</p>
                    </div>
                </div>

            </div>
        </section>









        <!--footer-->
        <footer class="footer">
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












