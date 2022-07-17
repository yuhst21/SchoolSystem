<%-- 
    Document   : checklogin
    Created on : Jul 18, 2022, 1:14:34 AM
    Author     : win
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <script>
            var count = 2;
            function redirect()
            {
                count--;
                document.getElementById('timer').innerHTML = count;
                if(count <= 0)
                {
                    window.location.href = '';
                }
            }
            setInterval(redirect,1000);
        </script>
         ${mes}</br>
        Redirect to login page after <span id="timer">2</span> seconds!
    </body>
</html>
