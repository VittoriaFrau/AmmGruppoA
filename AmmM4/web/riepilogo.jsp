<%-- 
    Document   : riepilogo
    Created on : 13-mag-2016, 15.22.08
    Author     : vicky
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="style.css" rel="stylesheet" type="text/css" media="screen" />
        <title>Riepilogo</title>
    </head>
    <body>
        <div class="page">
        <div class="header">
        <jsp:include page="WEB-INF/repeat/header.jsp" />
        </div>
            
            <ul>
                <li>
                    Hai scelto ${newObj.getNome()};
                    <li>
                        Per ${newObj.getPrezzo()};
                    </li>
                
                </li>
               
            </ul>
                    
            <div>
                 <input type="hidden" name="id" value="${newObj.getId()}" />
                 <input class="bottone" type="submit" name="compra" value="Procedi"/>
            </div>
                   
         <div class="footer">
             <jsp:include page="WEB-INF/repeat/footer.jsp" />
        </div>
        </div>
    </body>
</html>
