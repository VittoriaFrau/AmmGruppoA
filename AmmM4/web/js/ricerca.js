/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function ()
{
    $("#filtra").keyup(function()
 { 
    // Preleva il valore
    var text = $("#filtra").val();
    
    $.ajax(
        {
            url: "filter.json", //richiesta ajax
            data:{
              cmd: "search",
              q: text
            },
            dataType: 'json',
            success : function(data, state){
                Success(data);
            },
            error : function(data, state){
            }
        });
        
        // Funzione che viene richiamata in caso di successo
        function Success(listaOggetti){
            //elimino tutte le righe della tabella tranne la prima
            $("tr:not(#headerTab)").remove();
            
            //ricostruisco le righe se la condizione è soddisfatta
            if(listaOggetti.length !== 0)
            {
                //per ogni oggetto che è stato trovato nel database
                 for(var o in listaOggetti)
                {
                    
                    //NOME
                    //creo un nuovo tag tr
                    var Tr = document.createElement("tr");
                    Tr.setAttribute("nome");
                    //testo
                    var text = document.createTextNode(listaOggetti[o].nome);
                    //creo un nuovo tag td
                    var Td = document.createElement("td");
                    Td.appendChild(text);
                    Tr.appendChild(Td);
                    
                    
                    //URL
                    var Td = document.createElement("td");
                    var img = document.createElement("img");
                    img.setAttribute("src", listaOggetti[o].url);
                    img.setAttribute("alt" + listaOggetti[o].nome);
                    Td.appendChild(img);
                    Tr.appendChild(Td);
                    
                    //NUMERO PEZZI
                    var text = document.createTextNode(listaOggetti[o].numPezzi);
                    var Td = document.createElement("td");
                    Td.appendChild(text);
                    Tr.appendChild(Td);
                    
                    //PREZZO
                    var text = document.createTextNode(listaOggetti[o].prezzo);
                    var Td = document.createElement("td");
                    Td.appendChild(text);
                    Tr.appendChild(Td);
                    
                    //AGGIUNGI AL CARRELLO
                    var Td = document.createElement("td");
                    var a = document.createElement("Aggiungi");
                    a.setAttribute("href", "cliente.html?id="+ listaOggetti[o].id);
                    Td.appendChild(a);
                    Tr.appendChild(Td);
                    
                    //aggiungo la nuova riga alla tabella
                    $("table").append(Tr);
                }
            }else{
                var error;
                error.innerHTML="La ricerca non ha prodotto risultati";
            }
        }
   }); 
});