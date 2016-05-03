<%-- 
    Document   : descrizione
    Created on : 30-apr-2016, 16.34.07
    Author     : vicky
--%>

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
        </div>
        
            <!--collegamento esterno per la pagina di login -->
            <div class="sidebarsx">
            <nav>
                <ul>
                    <li><h2><a href="login.html">Login</a></h2></li> 
                </ul>
            </nav>
            
            <!--collegamenti interni alla pagina -->
            <ul>
                <li><h2><a href="#about"> About us</a></h2> 
              <ul> 
                  <!-- Sotto sezioni -->
                  <li><h3><a href="#clienti"> Clienti</a></h3></li>
                  <li><h3><a href="#venditori"> Venditori</a></h3></li>
              </ul>
            </li>
             <!--collegamenti interni alla pagina -->
            <li><h2><a href="#donna">Donna</a></h2>
                <ul>
                    <!-- Sotto sezioni -->
                    <li><h3><a href="#borseD">Borse</a></h3></li>
                    <li><h3><a href="#scarpeD">Scarpe</a></h3></li>
                    <li><h3><a href="#vestitiD">Vestiti</a></h3></li>
                    <li><h3><a href="#maglieD">Maglie</a></h3></li>
                </ul>
            </li>
             <!--collegamenti interni alla pagina -->
            <li><h2><a href="#uomo">Uomo</a></h2>
                <ul>
                    <!-- Sotto sezioni -->
                    <li><h3><a href="#scarpeU">Scarpe</a></h3></li>
                    <li><h3><a href="#giaccheU">Giacche</a></h3></li>
                    <li><h3><a href="#pantaloniU">Pantaloni</a></h3></li>
                    <li><h3><a href="#maglieU">Maglie</a></h3></li>
                </ul> </li>
                 <!--collegamenti interni alla pagina -->
                <li><h2><a href="#bambino">Bambino</a></h2>
                <ul>
                    <!-- Sotto sezioni -->
                    <li><h3><a href="#accessoriB">Accessori </a></h3></li>
                    <li><h3><a href="#scarpeB">Scarpe</a></h3></li>
                    <li><h3><a href="#vestitiB">Vestiti</a></h3></li>
                    <li><h3><a href="#maglieB">Maglie</a></h3></li>
                </ul></li>
            
        </ul>
        </div>
         
        <div class="content">
        <h2 id = "about">About us</h2>
            <!-- Breve descrizione -->
            <p>
                Sito per la compravendita di abbigliamento firmato a prezzi bassissimi.
                Possibilità di tracciamento del corriere, spedizioni in 3-4 giorni gratuite.<br/>
                Solo le migliori marche, quali: Gucci, Louis Vuitton, Liu-Jo etc...<br/>
                Vuoi diventare un nostro partner e vendere insieme a noi? <br/>
                Scrivici all'indirizzo mail: fakemail@gmail.com
            </p>
            
            <h3 id="clienti">Per la gentile clientela</h3>
             <!-- Informazioni per i clienti -->
                <p>
                    In questo sito troverete solo i migliori brand a prezzi scontatissimi, 
                    le condizioni dell'usato sono garantite grazie a un'attenta verifica
                    eseguita su ogni capo dai nostri dipendenti.<br/>
                    La nostra assistenza clienti vanta di un servizio 24h su 24, al numero
                    verde: 12345678. Per qualsiasi problema non esitate a contattarci.<br/>
                    Tutti i prezzi includono l'IVA.
                </p>

            <h3 id="venditori">Sei interessato a vendere con noi?</h3>
            <!-- Informazioni per i venditori -->
                <p>
                    Da oggi anche tu potrai esporre i tuoi articoli sul nostro sito,
                    garantendo una visibilità molto superiore a quella di qualsiasi altro sito!
                    Invia una mail all'indirizzo fakemail2@gmail.com e ti invieremo 
                    tutta la documentazione.
                    Per ulteriori informazioni, leggi le nostre condizioni di servizio.<br/>
                    Nota: Victoria's Outlet detiene il 20% su ogni vendita.
                </p>
        
        <h2 id="donna">Per lei...</h2>
        <!-- Descrizione -->
            <p>
                Scopri le nostre proposte per lei, scegli tra borse, scarpe, vestiti 
                e maglie.
                Ricorda che la spedizione è gratuita e, iscrivendoti alla nostra newsletter, 
                avrai diritto a uno sconto del 10% su tutti gli articoli.
            </p>
            
            <h3 id="borseD">Le nostre borse</h3>
            <!-- testo con marche -->
                <p>
                    Marchi trattati:<br/>
                    Armani, Bag Street, Chicca Tutto Moda, ColorMax, 
                    Denny Rose, Desigual, Gucci, Liu-jo, Louis Vuitton, 
                    Michael Kors, Prada, Patizia Pepe, Puma, Samsonite, Twin-Set.
    
                </p>
            <h3 id="scarpeD">Le nostre scarpe</h3>
            <!-- testo con marche -->
                <p>
                    Marchi trattati:<br/>
                    Bata, Bikkembergs, Converse, Dr. Martens, Geox,  
                    Gucci, Hogan, Fornarina, New Balance, Superga, Timberland, Vans.
                </p>
            <h3 id="vestitiD">I nostri vestiti</h3>
            <!-- testo con marche -->
                <p>
                    Marchi trattati:<br/>
                    Aldo, Calvin Klein, Dolce e Gabbana, Emporio Armani,
                    Fred Perry, Lacoste, Sisley, Versace.
                </p>
            <h3 id="maglieD">Le nostre maglie</h3>
            <!-- testo con marche -->
                <p>
                    Marchi trattati:<br/>
                    Aldo, Calvin Klein, Dolce e Gabbana, Emporio Armani,
                    Fred Perry, Lacoste, Sisley, Versace.
                </p>
                
        <h2 id="uomo">Per lui...</h2>
        <!-- Descrizione -->
            <p>
                Scopri le nostre proposte per lui, scegli tra scarpe, giacche, pantaloni 
                e maglie.
                Ricorda che la spedizione è gratuita e, iscrivendoti alla nostra newsletter, 
                avrai diritto a uno sconto del 10% su tutti gli articoli.
            </p>
            
            <h3 id="scarpeU">Le nostre scarpe</h3>
            <!-- testo con marche -->
                <p>
                    Marchi trattati: <br/>
                    Adidas, Birkenstock, Converse, Diadora, Havaianas, 
                    Nike, New Balance, Puma, Superga, Timberland, Vans.
                </p>
            <h3 id="giaccheU">Le nostre giacche</h3>
            <!-- testo con marche -->
                <p>
                    Marchi trattati:<br/>
                    Coats e Coats, Billabong, Volcom, DC, Legea, Lonsdale, 
                    Geox, Puma, Tommy Hilfiger.
                </p>
            <h3 id="pantaloniU">I nostri pantaloni</h3>
            <!-- testo con marche -->
                <p>
                    Marchi trattati:<br/>
                    Adidas, Benetton, Champion, Diesel, Le Coq, Springfield, 
                    Calvin Klein, Volcom, Timberland.
                </p>
            <h3 id="maglieU">Le nostre maglie</h3>
            <!-- testo con marche -->
                <p>
                    Marchi trattati: <br/>
                    All Star, Billabong, Jack Daniel's, Lacoste, Ralph Lauren, 
                    The north face, Tommy Hilfiger.
                </p>
        
        <h2 id="bambino">Per loro...</h2>
        <!-- Descrizione -->
            <p> 
                Scopri le nostre proposte per loro, scegli tra accessori, scarpe, vestiti e maglie.
                Ricorda che la spedizione è gratuita e, iscrivendoti alla nostra newsletter, 
                avrai diritto a uno sconto del 10% su tutti gli articoli.
            </p>
            
            <h3 id="accessoriB">I nostri accessori</h3>
            <!-- testo con marche -->
                <p>
                    Marchi trattati: <br/>
                    ATLANTIS, Avengers, Disney, Ferrari, I Simpson, Minions, 
                    Nike, Spiderman, Spongebob, Star Wars.
                </p>
            <h3 id="scarpeB">Le nostre scarpe</h3>
            <!-- testo con marche -->
                <p>
                    Marchi trattati: <br/>
                    Adidas, Converse, Crocs, Dr. Martens, Havaianas, Superga, 
                    Vans.
                </p>
            <h3 id="vestitiB">I nostri vestiti</h3>
            <!-- testo con marche -->
                <p>
                    Marchi trattati:<br/>
                    Desigual, Coconella, iPretty, Frozen, Disney, Petit Bateau,
                    Sunvary, Pepe, Hello Kitty, Roxy.
                </p>
            <h3 id="maglieB">Le nostre maglie</h3>
            <!-- testo con marche -->
                <p>
                    Marchi trattati:<br/>
                    Art T-shirt, Billabong, Desigual, Disney, Marvel, 
                    Ralph Lauren, Star Wars, Volcom.
                </p>
        </div>
        
        <div class="footer">
             <jsp:include page="WEB-INF/repeat/footer.jsp" />
        </div>
     </div>
    </body>
</html>
