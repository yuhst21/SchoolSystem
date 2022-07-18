<%-- 
    Document   : login
    Created on : Jul 15, 2022, 3:04:59 AM
    Author     : win
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/login.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <form action="login" method="POST">
            <div class="header-logo">
                <img src="https://upload.wikimedia.org/wikipedia/vi/1/1d/Logo_%C4%90%E1%BA%A1i_h%E1%BB%8Dc_FPT.png" >
            </div>
            <div class="wrapper fadeInDown">
                <div id="formContent">
                    <!-- Tabs Titles -->
                    <h2 class="active"> Sign In </h2>
                    <!-- Icon -->
                    <div class="fadeIn first">
                    </div>
                    <!-- Login Form -->
                    <form>
                        <input type="text" id="login" class="fadeIn second" name="user" placeholder="login">
                        <input type="password" id="password" class="fadeIn third" name="pass" placeholder="password">
                        <input type="submit" class="fadeIn fourth" value="Log In">
                    </form>

                    <!-- Remind Passowrd -->
                    <div id="formFooter">

                    </div>

                </div>
            </div>
        </form>
        ${mess}
    </body>
</html>
