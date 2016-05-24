/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import amm.modelli.ClienteFactory;
import amm.modelli.ObjectFactory;
import amm.modelli.VenditoreFactory;
import amm.modelli.utenteCliente;
import amm.modelli.utenteVenditore;
import amm.modelli.SaldoClientiVenditoriFactory;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vicky
 */
@WebServlet(name = "login", urlPatterns = {"/login.html"}, loadOnStartup = 0)
public class login extends HttpServlet {
    
        private static final String JDBC_DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
        private static final String DB_CLEAN_PATH = "../../web/WEB-INF/db/ammdb";
        private static final String DB_BUILD_PATH = "WEB-INF/db/ammdb";
        
 
        @Override 
         public void init(){
        String dbConnection = "jdbc:derby:" + this.getServletContext().getRealPath("/") + DB_BUILD_PATH;
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);

        }
        ObjectFactory.getInstance().setConnectionString(dbConnection);
        ClienteFactory.getInstance().setConnectionString(dbConnection);
        VenditoreFactory.getInstance().setConnectionString(dbConnection);
        SaldoClientiVenditoriFactory.getInstance().setConnectionString(dbConnection);
    }
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
            // Preleva i dati inviati e controlla se sono giusti
            String username = request.getParameter("nome");
            String pwd = request.getParameter("pw");
            
            //se è un cliente
            utenteCliente client = ClienteFactory.getInstance().getClienti(username, pwd);
           
                if(client.getUsername().equals(username) && client.getPwd().equals(pwd))
                {
                    session.setAttribute("loggedIn", true);
                    session.setAttribute("username", client);
                    session.setAttribute("id", client.getId());
                    session.setAttribute("logVenditore", false);
                    session.setAttribute("logCliente", true);
                    
                    request.setAttribute("cliente", client);
                    request.getRequestDispatcher("cliente.jsp").forward(request, response);
                    
                  
                   }
        
            // se è un venditore
            utenteVenditore vend = VenditoreFactory.getInstance().getVenditori(username, pwd);
                if(vend.getUser().equals(username) && vend.getPwd().equals(pwd))
                    {
                        session.setAttribute("loggedIn", true);
                        session.setAttribute("username", vend);
                        session.setAttribute("idV", vend.getId());
                        session.setAttribute("logVenditore", true);
                        session.setAttribute("logCliente", false);
                        
                        request.setAttribute("venditore", vend);
                        request.getRequestDispatcher("venditore.jsp").forward(request, response);
                        
                        
                    } 
            
            //se non sono autenticato
            request.setAttribute("error", true);
              
        }
        //Nel caso l’utente non sia autenticato, deve mostrare il form di login
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
