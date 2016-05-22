<%-- 
    Document   : error
    Created on : 12-mag-2016, 17.19.15
    Author     : vicky
    
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="style.css" rel="stylesheet" type="text/css" media="screen" />
        <title>JSP Page</title>
    </head>
    <body>
        <!-- file per l'accesso negato -->
        <div class="page">
            
            <div class="header">
                <jsp:include page="WEB-INF/repeat/header.jsp" />
            </div>
            
        <h1 id="error">Access denied</h1>
        <h3 id="error2">Sorry, an error occured. If you are unsure on how to use a feature,
            or don't know why you got this error message, try looking through the
            help files for more information.</h3>
        <div class="footer">
            <jsp:include page="WEB-INF/repeat/footer.jsp" />
        </div>
        </div>
    </body>
</html>
