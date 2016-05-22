<%-- 
    Document   : venditore
    Created on : 30-apr-2016, 16.34.19
    Author     : vicky
--%>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>    
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
            <h1>Vendi con noi!</h1>
         </div>
        
        <div class="sidebarsx">
        <!-- Sezione di navigazione -->
        <nav>
            <ul>
                <li><a href="descrizione.html">Pagina iniziale </a></li>
                <li><a href="login.html">Login</a></li>
            </ul>
        </nav>
        </div>
        
        <div class="content">
        <!-- form per l'inserimento di un oggetto da vendere -->
        <form action="venditore.html" method="POST">
                <!-- Nell'ordine: Nome dell’oggetto, URL di una immagine descrittiva,
                     Descrizione dell’oggetto, Prezzo, Quantità di oggetti disponibili-->
            <label for="name">Nome dell'oggetto</label>
            <input type="text" name="name" id="name" />
            
            
            <label for="Url">Url dell'immagine</label>
            <input type="url" name="Url" id="Url" />
            
            
            <label for="description">Breve descrizione</label>
            <textarea rows="7" cols="10" name="description" id="description">Inserisci una descrizione dell'oggetto
            </textarea>
            
            
            <label for="price">Prezzo</label>
            <input type="number" name="price" id="price" />
            
            
            <label for="quantity">Quantità</label>
            <input type="number" name="quantity" id="quantity" min="1" max="100" />
           
             
            <!-- Pulsanti submit e reset -->
            <div>
                <input class="bottone" type="submit" name="Submit" value="Continua">
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
