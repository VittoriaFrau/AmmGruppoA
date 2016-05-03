<%-- 
    Document   : login
    Created on : 30-apr-2016, 16.33.00
    Author     : vicky
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <title>Victoria's Outlet</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Vittoria Frau">
        <meta name="keywords" content="scarpe, vestiti, abbigliamento, moda, saldi, outlet">   
        <link href="style.css" rel="stylesheet" type="text/css" media="screen" />
    </head>
    <body> 
        <div class="page">
            
            <div class="header">
                <jsp:include page="WEB-INF/repeat/header.jsp" />
                <h1>Accedi al tuo account</h1>
            </div>
            
        <div class="sidebarsx">
        <!-- Sezione di navigazione -->
        <nav>
            <ul>
                <li><a href="descrizione.html">Pagina iniziale </a></li>
                <li><a href="venditore.html">Vendi con noi</a></li>
                <li><a href="cliente.html">Compra</a></li>
            </ul>
        </nav>
        </div>
        
        <div class="content">
        <!-- form per l'inserimento delle informazioni sull'account -->
        <form method="GET">
            <!--Nome utente -->
            <label for="nome">Nome utente</label>
            <input type="text" name="nome" id="nome" value="Inserisci nome utente" />
            
            <!-- Password-->
            <label for="pw">Password</label>
            <input type="password" name="pw" id="pw" value="vuoto" />
            
            <!-- Pulsanti submit e reset -->
            <div>
                <input class="bottone" type="submit" value="Vai">
                <input class="bottone" type="reset" value="Resetta">
            </div>
        </form>
        
        </div>
       
        
        <div class="footer">
            <jsp:include page="WEB-INF/repeat/footer.jsp" />
        </div>
        
     </div> 
    </body>
</html>
