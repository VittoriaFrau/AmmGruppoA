<%-- 
    Document   : cliente
    Created on : 30-apr-2016, 16.33.53
    Author     : vicky
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
        <!-- titolo -->
        <jsp:include page="WEB-INF/repeat/header.jsp" />
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
        <!-- tabella per gli articoli -->
        <table>
            <!-- la prima riga contiene il nome degli oggetti in formato intestazione -->
            <!-- genero i nomi dinamicamente -->
            
            <tr class="headerTab">
                <th class="th">Nome</th>
                <th class="th">Immagine</th> 
                <th class="th">Quantità</th> 
                <th class="th">Prezzo</th> 
                <th class="th">Compra</th> 
            </tr>
            <c:forEach var="i" items="${listaOggetti}">
                <tr>
            <!-- nella terza riga inserisco le foto descrittive impostando larghezza e 
                lunghezza in modo da non risultare troppo grandi -->
            <!-- genero le immagini dinamicamente --> 
            
            <td class="nome cl1">${i.getNome()}</td>
            
            <td class="url">
            <img src="${i.getUrl()}" title="${i.getNome()}" 
                 alt="${i.getNome()}" width="100" height="90"></td>
                
            
            <!--  Quantità di pezzi disponibili -->
            <!-- genero le quantità dinamicamente -->
            
                <td class="numPezzi cl1">${i.getNumPezzi()}</td>
       
            <!--Prezzo in euro -->
            <!-- genero i prezzi dinamicamente -->
            
                <td class="prezzo">${i.getPrezzo()}€</td>
          
            <!-- link per aggiungere l'oggetto al carrello (per ora rimanda alla stessa pagina -->
            <td class="cl1">
                <a href="cliente.html">Aggiungi al carrello!</a> 
            </td>
            </tr>
            
            </c:forEach>
        </table>
        </div>
        
    
            
        <div class="footer">
             <jsp:include page="WEB-INF/repeat/footer.jsp" />
        </div>
        </div>
        
        
        
    </body>
</html>
