<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Login</title>
        <link rel="stylesheet" href="css/login.css">
    </head>
    <body>

        <div class="login-box">

            <h1>Welcome !</h1>
            <p class="subtitle">Please log in to access your account.</p>

            <form action="MainController" method="post">
                User ID <input type="text" name="userID" required=""/></br>
                Password <input type="password" name="password" required=""/></br>

                <a href="#" class="forgot">Forgot your password?</a>
                <input type="submit" name="action" value="USER_LOGIN"/>
            </form>

            <h3 class="register-title">Not registered yet?</h3>
            <button class="btn-register">Create an account</button>
        </div>
        <%
            String error = (String) request.getAttribute("ERROR");
            if (error != null) {
        %>
        <p style="color:red; text-align:center;">
            <%= error%>
        </p>
        <%
            }
        %>

    </body>
</html>
