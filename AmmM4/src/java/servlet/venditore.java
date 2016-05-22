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
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 *
 * @author vicky
 */
@WebServlet(name = "venditore", urlPatterns = {"/venditore.html"})
public class venditore extends HttpServlet {

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
        
        HttpSession session = request.getSession(false);
        
        //Nel caso l’utente non sia autenticato o non sia un venditore, deve mostrare un messaggio di accesso negato
        if(session==null || !(session.getAttribute("username") instanceof utenteVenditore)){
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
        
        //Nel caso l’utente sia un venditore, deve mostrare il form di inserimento dell’oggetto. 
        if(request.getParameter("Submit") == null){
            request.getRequestDispatcher("venditore.jsp").forward(request, response);
        }
        
        //Nel caso siano inviati i dati relativi all’inserimento di un oggetto, deve 
        //mostrare una conferma dell’avvenuto inserimento ed i dati dell’oggetto inserito
        
        boolean flag=true; //flag per il controllo
        //prendo i parametri in input se ha inviato i dati
        if(request.getParameter("Submit")!= null){
            
            Object newObj = new Object();
            int quant= 0;
            double prez= 0.0;
            
            if(request.getParameter("name")!= null && request.getParameter("Url")!=null && request.getParameter("description")!=null){
                newObj.setNome(request.getParameter("name"));
                newObj.setUrl(request.getParameter("Url"));
                newObj.setDescrizione(request.getParameter("description"));
                
            }else{
                flag=false;
            }try{
                quant=Integer.parseInt(request.getParameter("quantity"));
            } catch(RuntimeException e){
                flag=false;
            } try{
                prez=Double.parseDouble(request.getParameter("price"));
            }catch(RuntimeException e){
                flag=false;
            }
            
            if(flag == true){
                       
                    request.setAttribute("object", newObj);
                   }
                   
                   request.setAttribute("u", "venditore");
                   request.getRequestDispatcher("riepilogo.jsp").forward(request, response);
             
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
