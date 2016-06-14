/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servlet;

import amm.modelli.utenteVenditore;
import amm.modelli.Object;
import amm.modelli.ObjectFactory;
import amm.modelli.utenteCliente;
import amm.modelli.SaldoClientiVenditori;
import amm.modelli.SaldoClientiVenditoriFactory;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;

/**
 *
 * @author vicky
 */
@WebServlet(name = "cliente", urlPatterns = {"/cliente.html"})
public class cliente extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        //non creo nuovamente la sessione nel caso ci sia già
        HttpSession session = request.getSession(false);
        
        //Nel caso l’utente non sia autenticato o non sia un cliente, deve mostrare un messaggio di accesso negato
        if(session==null || !(session.getAttribute("username") instanceof utenteCliente)){
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
        
        //Nel caso l’utente sia un cliente, deve mostrare la lista degli oggetti.
        if(request.getParameter("Submit") == null){
            request.getRequestDispatcher("cliente.jsp").forward(request, response);
        }else{ //se l'utente ha premuto submit
        
        /**Nel caso l’utente selezioni il link per comprare un oggetto,
        deve mostrare solo un riepilogo dei dati dell’oggetto ed un pulsante 
        per la conferma di acquisto **/
        utenteCliente cliente = (utenteCliente)session.getAttribute("nome");
        int id = -1;
        
        //converto l'intero per prenderlo come parametro
        try{
            id = Integer.parseInt(request.getParameter("id"));
        }catch (RuntimeException e){
            request.getRequestDispatcher("cliente.jsp").forward(request, response);
        }
        
        //creo un nuovo oggetto con l'id dell'oggetto selezionato
        Object comprami = ObjectFactory.getInstance().getObjectById(id);
        
        if(comprami == null){ //controllo che l'oggetto selezionato abbia un id valido
            request.setAttribute("error", true);
            request.setAttribute("listaOggetti", ObjectFactory.getInstance().getObjectList());
            request.getRequestDispatcher("cliente.jsp").forward(request, response);
        } 
         
        if(request.getParameter("compra") == null){ //controllo se nella pagina di riepilogo il cliente ha premuto il pulsante procedi
            //l'utente non ha premuto procedi
            request.setAttribute("newObj", comprami);
            request.getRequestDispatcher("riepilogo.jsp").forward(request, response);
        } else { 
            //l'utente ha premuto procedi
            if(comprami.getPrezzo() > SaldoClientiVenditoriFactory.getInstance().getSaldoClientiVenditoribyId(cliente.getId()).getSaldo()){
                //Non ha abbastanza soldi
                request.setAttribute("error", true);
                request.setAttribute("listaOggetti", ObjectFactory.getInstance().getObjectList());
                request.getRequestDispatcher("cliente.jsp").forward(request, response);
            }else{
                //Ha abbastanza soldi
                cliente.aggiungiAlCarrello(comprami);
                request.setAttribute("listaOggetti", ObjectFactory.getInstance().getObjectList());
                request.getRequestDispatcher("cliente.jsp").forward(request, response);
            }
        }
      }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
