/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.modelli;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vicky
 */
public class ObjectFactory {
    
    private static ObjectFactory singleton;
    private String connectionString;
    
    public void setConnectionString(String s){
    	this.connectionString = s;
    }

    public String getConnectionString(){
    	return this.connectionString;
    } 
    
    
    public static ObjectFactory getInstance() {  
        if (singleton == null) {    //la prima volta che chiamo getinstance singleton sarà null, alle successive restituiscono singleton
            singleton = new ObjectFactory(); //creo un nuovo gestore
        }
        return singleton;
    }
    

private ObjectFactory(){//costruttore richiamato da getInstance
}

 public Object getOggetti (String nome, String url, String descrizione, double prezzo, Integer numPezzi, Integer idV, Integer id)
    {
        try{
            Connection conn = DriverManager.getConnection(connectionString, "vicky", "123");
            //Sql command
            String query = "select * from Object where "
                + "id = ? and nome = ? and url = ? and descrizione = ? "
                + "prezzo = ? and numPezzi = ? and idV = ?";
            
            PreparedStatement stmt = conn.prepareStatement(query);
            // Si associano valori e posizioni 
            stmt.setString(1, nome);
            stmt.setString(2, url);
            stmt.setString(3, descrizione);
            stmt.setDouble(4, prezzo);
            stmt.setInt(5, numPezzi);
            stmt.setInt(6, idV);
           
            ResultSet res = stmt.executeQuery(); //prendo i risultati e gli restituisco il valore dell'esecuzione della query
            if(res.next())
            {
                Object o = new Object();
                o.setNome(res.getString("nome"));
                o.setUrl(res.getString("url"));
                o.setDescrizione(res.getString("description"));
                o.setId(res.getInt(numPezzi));
                o.setPrezzo(res.getDouble("prezzo"));
                o.setNumPezzi(res.getInt(numPezzi));
                
                
                stmt.close();
                conn.close();
                return o;
            }
        }catch (SQLException e) {
            Logger.getLogger(ObjectFactory.class.getName()).log(Level.SEVERE, null, e);
        }
        
        return null;
        
    }
}