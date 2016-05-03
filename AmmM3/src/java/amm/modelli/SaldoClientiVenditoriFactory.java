/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.modelli;
import java.util.ArrayList;
import java.util.Objects;
/**
 *
 * @author vicky
 */
public class SaldoClientiVenditoriFactory {
    
    private static SaldoClientiVenditoriFactory singleton;
    public static SaldoClientiVenditoriFactory getInstance() {  
        if (singleton == null) {    //la prima volta che chiamo getinstance singleton sarà null, alle successive restituiscono singleton
            singleton = new SaldoClientiVenditoriFactory(); //creo un nuovo gestore
        }
        return singleton;
    }
    private ArrayList <SaldoClientiVenditori> listaSaldoClientiVenditori = new ArrayList <SaldoClientiVenditori>();

    private SaldoClientiVenditoriFactory(){//costruttore richiamato da getInstance
    /*inizializzo la lista SaldoClientiVenditori*/
    
    
    /*Venditore 1*/
    SaldoClientiVenditori scv_1= new SaldoClientiVenditori();
    scv_1.setId(192); //metto l'id conto del venditore
    scv_1.setSaldo(1000.0);
    listaSaldoClientiVenditori.add(scv_1); //lo metto nella lista
    
    /*Venditore 2*/
    SaldoClientiVenditori scv_2= new SaldoClientiVenditori();
    scv_2.setId(337); //metto l'id conto del venditore
    scv_2.setSaldo(600.0);
    listaSaldoClientiVenditori.add(scv_2); //lo metto nella lista
    
    /*Venditore 3*/
    SaldoClientiVenditori scv_3= new SaldoClientiVenditori();
    scv_3.setId(50); //metto l'id conto del venditore
    scv_3.setSaldo(100.0);
    listaSaldoClientiVenditori.add(scv_3); //lo metto nella lista
    
    /*Cliente 1*/
    SaldoClientiVenditori scv_4= new SaldoClientiVenditori();
    scv_4.setId(99); //metto l'id conto del cliente
    scv_4.setSaldo(726.0);
    listaSaldoClientiVenditori.add(scv_4); //lo metto nella lista
    
    /*Cliente 2*/
    SaldoClientiVenditori scv_5= new SaldoClientiVenditori();
    scv_5.setId(004); //metto l'id conto del cliente
    scv_5.setSaldo(329.0);
    listaSaldoClientiVenditori.add(scv_5); //lo metto nella lista
    
    /*Cliente 3*/
    SaldoClientiVenditori scv_6= new SaldoClientiVenditori();
    scv_6.setId(629); //metto l'id conto del cliente
    scv_6.setSaldo(1500.0);
    listaSaldoClientiVenditori.add(scv_6); //lo metto nella lista
    
    }
    
    ArrayList <SaldoClientiVenditori> getSaldoClientiVenditoriList () {//restituisce la lista dei conti
        return listaSaldoClientiVenditori;
    }

    SaldoClientiVenditori getSaldoClientiVenditoribyId(Integer id){ 
         
        for(SaldoClientiVenditori u : listaSaldoClientiVenditori) //scorro la lista 
        {
            if(Objects.equals(u.id, id)) //se l'id è uguale restituisco l'utente
                return u;
        }
        
        return null; //non c'è utente con questo id
    }



}
