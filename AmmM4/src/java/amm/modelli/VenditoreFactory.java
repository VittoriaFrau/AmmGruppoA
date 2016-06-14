/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.modelli;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.ArrayList;
import java.util.logging.Logger;

/**
 *
 * @author vicky
 */
public class VenditoreFactory {
    
    private static VenditoreFactory singleton;
    private String connectionString;
    
    public void setConnectionString(String s){
    	this.connectionString = s;
    }

    public String getConnectionString(){
    	return this.connectionString;
    } 
    public static VenditoreFactory getInstance() {  
        if (singleton == null) {    //la prima volta che chiamo getinstance singleton sarà null, alle successive restituiscono singleton
            singleton = new VenditoreFactory(); //creo un nuovo gestore
        }
        return singleton;
    }
    
    
    private VenditoreFactory(){  //costruttore richiamato da getInstance
       
    }

    
    public  ArrayList <utenteVenditore> getVenditoriList (String username, String pwd)
    {
        ArrayList <utenteVenditore> listaVenditori = new ArrayList<>();
        try {
            
            Connection conn = DriverManager.getConnection(connectionString, "vicky", "123");
             //Sql command
            String query = "select * from utenteVenditore where username = ? " 
                + "and pwd = ?";
            
            PreparedStatement stmt = conn.prepareStatement(query);
            // Si associano valori e posizioni 
            stmt.setString(1, username); //1 ->il primo valore che passo
            stmt.setString(2, pwd);
            //esegui query
            ResultSet res = stmt.executeQuery(); //prendo i risultati e gli restituisco il valore dell'esecuzione della query
            
            //per vedere se ci sono i risultati controllo il contenuto di res
            if(res.next())
            {
                utenteVenditore venditore = new utenteVenditore();
                venditore.setUser(res.getString("username"));
                venditore.setPwd(res.getString("pwd"));
                venditore.setId(res.getInt("idV"));
                venditore.setIdConto(res.getInt("idConto"));
                listaVenditori.add(venditore);
                
                // Essendo idConto in un altro database faccio una nuova query
                
                query= "select * from SaldoClientiVenditori " + "join saldo on saldo.id = saldo.id "
                    + "where SaldoClientiVenditori.idConto = " ;
                Statement st = conn.createStatement();
                ResultSet res2 = st.executeQuery(query);
                
                while(res2.next()){ //uso un while 
                SaldoClientiVenditori s=new SaldoClientiVenditori();
                s.setId(res2.getInt("id"));
                s.setSaldo(res2.getDouble("saldo"));
                }
                
                stmt.close(); //chiudo
                conn.close();
                return listaVenditori;
            }
        }catch (SQLException e) {
            Logger.getLogger(VenditoreFactory.class.getName()).log(Level.SEVERE, null, e);
          }
        return null;
    }
    
     public utenteVenditore getVenditoreById (Integer id){
        utenteVenditore vend = null;
        try {
            
            Connection conn = DriverManager.getConnection(connectionString, "vicky", "123");
             //Sql command
            String query = "select * from utenteCliente where id = ? ";
            
            PreparedStatement stmt = conn.prepareStatement(query);
            // Si associano valori e posizioni 
            stmt.setInt(1, id);
            //esegui query
            ResultSet res = stmt.executeQuery(); //prendo i risultati e gli restituisco il valore dell'esecuzione della query
            
            //per vedere se ci sono i risultati controllo il contenuto di res
            if(res.next())
            {
                vend = new utenteVenditore();
                vend.setId(res.getInt("id"));
                vend.setUser(res.getString("username"));
                vend.setPwd(res.getString("pwd"));
                
            }
        }catch (SQLException e) {
            Logger.getLogger(ClienteFactory.class.getName()).log(Level.SEVERE, null, e);
          }
        return vend;
    }
     
     public utenteVenditore getVenditore(String username, String password){
        utenteVenditore vend = null;

        String query = "SELECT * FROM utenteCliente WHERE username = ? AND password = ?";
       
        try(Connection conn = DriverManager.getConnection(connectionString, "vicky", "123");
            PreparedStatement stmt = conn.prepareStatement(query)){

            stmt.setString(1, username);
            stmt.setString(2, password);
            //Eseguo la query
            ResultSet res = stmt.executeQuery();
            
            
            if(res.next()){
                vend = new utenteVenditore();
                vend.setId(res.getInt("id"));
                vend.setUser(res.getString("username"));
                vend.setPwd(res.getString("pwd"));
                
            }
        }catch (SQLException e) {
            Logger.getLogger(ClienteFactory.class.getName()).log(Level.SEVERE, null, e);
          }
        return vend;
    }
}
