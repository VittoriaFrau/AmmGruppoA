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
import java.util.List;
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

 public ArrayList <Object> getObjectList ()
    {
        ArrayList <Object> listaOggetti = new ArrayList<>();
        try{
            Connection conn = DriverManager.getConnection(connectionString, "vicky", "123");
            //Sql command
            String query = "select * from Object ";
            
            PreparedStatement stmt = conn.prepareStatement(query);
           //esegui query
            ResultSet res = stmt.executeQuery(); //prendo i risultati e gli restituisco il valore dell'esecuzione della query
            //controllo il contenuto di res
            if(res.next())
            {
                Object o = new Object();
                o.setNome(res.getString("nome"));
                o.setUrl(res.getString("url"));
                o.setDescrizione(res.getString("description"));
                o.setId(res.getInt("id"));
                o.setPrezzo(res.getDouble("prezzo"));
                o.setNumPezzi(res.getInt("numPezzi"));
                listaOggetti.add(o);
                
                
                stmt.close();
                conn.close();
                return listaOggetti;
            }
        }catch (SQLException e) {
            Logger.getLogger(ObjectFactory.class.getName()).log(Level.SEVERE, null, e);
        }
        
        return null;
        
    }
 
    public Object getObjectById (Integer id){
        Object o = null;
        try {
            
            Connection conn = DriverManager.getConnection(connectionString, "vicky", "123");
             //Sql command
            String query = "select * from Object where id = ? ";
            
            PreparedStatement stmt = conn.prepareStatement(query);
            // Si associano valori e posizioni 
            stmt.setInt(1, id);
            //esegui query
            ResultSet res = stmt.executeQuery(); //prendo i risultati e gli restituisco il valore dell'esecuzione della query
            
            //per vedere se ci sono i risultati controllo il contenuto di res
            if(res.next())
            {
                o = new Object();
                o.setNome(res.getString("nome"));
                o.setUrl(res.getString("url"));
                o.setDescrizione(res.getString("description"));
                o.setId(res.getInt("id"));
                o.setPrezzo(res.getDouble("prezzo"));
                o.setNumPezzi(res.getInt("numPezzi"));
                
            }
        }catch (SQLException e) {
            Logger.getLogger(ClienteFactory.class.getName()).log(Level.SEVERE, null, e);
          }
        return o;
    }
    
    
    //metodo per l'aggiunta di un oggetto
    public boolean aggiungiOggetto(String nome, String url, String descrizione, double prezzo, Integer numPezzi, Integer idV, Integer id){
        boolean flag = false;
        try{
            Connection conn = DriverManager.getConnection(connectionString, "vicky", "123");
            //Sql command
         String query = "insert into Object " + "(nome, url, descrizione, prezzo, numPezzi, idV, id) VALUES "
                        + "(?, ?, ?, ?, ?, ?, default)";
         
         PreparedStatement stmt = conn.prepareStatement(query);
            // Si associano valori e posizioni 
            stmt.setString(1, nome);
            stmt.setString(2, url);
            stmt.setString(3, descrizione);
            stmt.setDouble(4, prezzo);
            stmt.setInt(5, numPezzi);
            stmt.setInt(6, idV);
            stmt.setInt(7, id);
            
            int riga = stmt.executeUpdate();
            if(riga == 1){ //se il numero di righe è uno la query ha funzionato
                flag = true;
            }
        }catch (SQLException e) {
            Logger.getLogger(ObjectFactory.class.getName()).log(Level.SEVERE, null, e);
         
    } return flag;

    }
    
    
    //metodo per la rimozione di un oggetto
    public boolean rimuoviOggetto(Integer id){
        boolean flag = false;
        try{
            Connection conn = DriverManager.getConnection(connectionString, "vicky", "123");
            //Sql command
         String query = "delete from Object WHERE id = ? ";
         
         PreparedStatement stmt = conn.prepareStatement(query);
            // Si associano valori e posizioni 
            stmt.setInt(1, id);
            
            int riga = stmt.executeUpdate();
            if(riga == 1){ //se il numero di righe è uno la query ha funzionato
                flag = true;
            }
        }catch (SQLException e) {
            Logger.getLogger(ObjectFactory.class.getName()).log(Level.SEVERE, null, e);
         
    } return flag;

    }
    
    //metodo per la modifica di un oggetto
    
    public boolean modificaOggetto(String nome, String url, String descrizione, double prezzo, Integer numPezzi, Integer idV, Integer id){
        boolean flag = false;
        try{
            Connection conn = DriverManager.getConnection(connectionString, "vicky", "123");
            //Sql command
         String query = "UPDATE Object "
                + "SET nome = ?, descrizione = ?,url = ?, prezzo = ?, numPezzi = ?, idV = ? "
                + "WHERE id = ?";
         
         PreparedStatement stmt = conn.prepareStatement(query);
            // Si associano valori e posizioni 
            stmt.setString(1, nome);
            stmt.setString(2, url);
            stmt.setString(3, descrizione);
            stmt.setDouble(4, prezzo);
            stmt.setInt(5, numPezzi);
            stmt.setInt(6, idV);
            stmt.setInt(7, id);
            
            int riga = stmt.executeUpdate();
            if(riga == 1){ //se il numero di righe è uno la query ha funzionato
                flag = true;
            }
        }catch (SQLException e) {
            Logger.getLogger(ObjectFactory.class.getName()).log(Level.SEVERE, null, e);
         
    } return flag;

    }
    
    public List<Object> ricercaOggetto(String txt){ //metodo che mi servirà per la ricerca tramite tastiera
        List<Object> listaOggetti = new ArrayList<>();
        Object o;
        try{
            Connection conn = DriverManager.getConnection(connectionString, "vicky", "123");
            //Sql command
            String query = "select * from Object "
                + "WHERE nome LIKE ?";
            txt = "%"+txt+"%";
            PreparedStatement stmt = conn.prepareStatement(query);
            // Si associano valori e posizioni 
            stmt.setString(1, txt);
            //esegui query
            ResultSet res = stmt.executeQuery(); //prendo i risultati e gli restituisco il valore dell'esecuzione della query
            //per vedere se ci sono i risultati controllo il contenuto di res
            if(res.next())
            {
                o = new Object();
                o.setNome(res.getString("nome"));
                o.setUrl(res.getString("url"));
                o.setDescrizione(res.getString("description"));
                o.setId(res.getInt("id"));
                o.setPrezzo(res.getDouble("prezzo")); 
                o.setNumPezzi(res.getInt("numPezzi")); 
                
                listaOggetti.add(o);
            }
            
            
        }catch (SQLException e) {
            Logger.getLogger(ObjectFactory.class.getName()).log(Level.SEVERE, null, e);
    } return listaOggetti;
    }
 }