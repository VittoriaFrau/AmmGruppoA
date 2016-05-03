<%-- 
    Document   : cliente
    Created on : 30-apr-2016, 16.33.53
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
        <!-- titolo -->
        <jsp:include page="WEB-INF/repeat/header.jsp" />
        <h2 id="white">In vetrina...</h2>
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
            <c:forEach var="i" items="${listaOggetti}">
               <tr class="cl2">
                    <th class="nome">${i.getNome()}</th> 
               </tr>
            <!-- nella terza riga inserisco le foto descrittive impostando larghezza e 
                lunghezza in modo da non risultare troppo grandi -->
            <!-- genero le immagini dinamicamente -->
            <tr>
                <td class="url">
                   <img src="${i.getUrl()}" title="${i.getNome()}" 
                   alt="${i.getNome()}" width="100" height="90"> </td>
                
            </tr>
            <!--  Quantità di pezzi disponibili -->
            <!-- genero le quantità dinamicamente -->
            <tr class="cl1">
                <td class="numPezzi">${i.getNumPezzi()}</td>
            </tr>
            <!--Prezzo in euro -->
            <!-- genero i prezzi dinamicamente -->
            <tr>
                <td class="prezzo">${i.getPrezzo()}</td>
            </tr>
            <!-- link per aggiungere l'oggetto al carrello (per ora rimanda alla stessa pagina -->
            <tr class="cl1">
                <td><a href="cliente.html">Aggiungi al carrello!</a> </td>
            </tr>
            
            </c:foreach>
        </table>
        </div>
            
    
            
        <div class="footer">
             <jsp:include page="WEB-INF/repeat/footer.jsp" />
        </div>
            
    
        
        </div>
    </body>
</html>
