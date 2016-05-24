/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.modelli;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author vicky
 */
public class SaldoClientiVenditoriFactory {
    
    private static SaldoClientiVenditoriFactory singleton;
    private String connectionString;
    
    public void setConnectionString(String s){
    	this.connectionString = s;
    }

    public String getConnectionString(){
    	return this.connectionString;
    } 
    public static SaldoClientiVenditoriFactory getInstance() {  
        if (singleton == null) {    //la prima volta che chiamo getinstance singleton sarà null, alle successive restituiscono singleton
            singleton = new SaldoClientiVenditoriFactory(); //creo un nuovo gestore
        }
        return singleton;
    }
    
    public SaldoClientiVenditori getSaldo(Integer id, double saldo){
        try{
            String db = "jdbc:derby://localhost:1527/ammdb";
            Connection conn = DriverManager.getConnection(connectionString, "vicky", "123");
             //Sql command
            String query = "select * from SaldoClientiVenditori where id = ? " 
                + "and saldo = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            // Si associano valori e posizioni 
            stmt.setInt(1, id); //1 ->il primo valore che passo
            stmt.setDouble(2, saldo);
            //esegui query
            ResultSet res = stmt.executeQuery(); //prendo i risultati e gli restituisco il valore dell'esecuzione della query
            //per vedere se ci sono i risultati controllo il contenuto di res
            if(res.next())
            {
                SaldoClientiVenditori Saldo = new SaldoClientiVenditori();
                Saldo.setId(res.getInt("id"));
                Saldo.setSaldo(res.getDouble("saldo"));
                
                stmt.close();
                conn.close();
                return Saldo;
            }
        }catch(SQLException e){
            Logger.getLogger(SaldoClientiVenditoriFactory.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    
    }
   
    private SaldoClientiVenditoriFactory(){//costruttore richiamato da getInstance
    /*inizializzo la lista SaldoClientiVenditori*/
   
    }
    

}
