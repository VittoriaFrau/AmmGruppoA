/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import amm.modelli.ClienteFactory;
import amm.modelli.VenditoreFactory;
import amm.modelli.utenteCliente;
import amm.modelli.utenteVenditore;
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
@WebServlet(name = "login", urlPatterns = {"/login.html"})
public class login extends HttpServlet {

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
        
        HttpSession session = request.getSession(true);
        
        if(request.getParameter("Submit") != null)
        {
            // Preleva i dati inviati
            String username = request.getParameter("username");
            String pwd = request.getParameter("pwd");
            
            //cliente
            ArrayList<utenteCliente> listaClienti = ClienteFactory.getInstance().getClienteList();
            for(utenteCliente u : listaClienti)
            {
                if(u.getUsername().equals(username) && u.getPwd().equals(pwd))
                {
                    session.setAttribute("loggedIn", true);
                    
                    if(u instanceof utenteCliente) 
                    {
                        request.setAttribute("cliente", u);
                        request.getRequestDispatcher("cliente.jsp").forward(request, response);
                    }
                                      
                }
            }
            //venditore
            ArrayList<utenteVenditore> listaVenditori = VenditoreFactory.getInstance().getVenditoreList();
            for(utenteVenditore u : listaVenditori)
            {
                if(u.getUser().equals(username))
                {
                    if(u.getPwd().equals(pwd)) 
                    {
                        session.setAttribute("loggedIn", true);
                        
                        if(u instanceof utenteVenditore)
                        {
                            request.setAttribute("venditore", u);
                            request.getRequestDispatcher("venditore.jsp").forward(request, response);
                        }
                        
                    }
                                      
                }
            }
        }
        
        /*Nel caso l’utente non sia autenticato, deve mostrare il form di login*/
        request.getRequestDispatcher("login.jsp").forward(request, response);
 
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    
     @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    }

   