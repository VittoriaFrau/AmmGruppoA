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
public class VenditoreFactory {
    
    private static VenditoreFactory singleton;
    public static VenditoreFactory getInstance() {  
        if (singleton == null) {    //la prima volta che chiamo getinstance singleton sarà null, alle successive restituiscono singleton
            singleton = new VenditoreFactory(); //creo un nuovo gestore
        }
        return singleton;
    }
    
     /*creo  un attributo da richiamare nel costruttore*/
    public ArrayList <utenteVenditore> listaVenditori = new ArrayList <utenteVenditore>();
    
    
    public VenditoreFactory(){  //costruttore richiamato da getInstance
        /*inizializzo la listaVenditori*/
        
        /*Venditore 1*/
        utenteVenditore venditore_1 = new utenteVenditore();//creo un venditore
        venditore_1.setUser("Paolo22"); //aggiungo gli attributi
        venditore_1.setPwd("atene43");
        venditore_1.setId(77);
        venditore_1.setIdConto(192);
        listaVenditori.add(venditore_1);// lo metto nella lista
        
        /*Venditore 2*/
        utenteVenditore venditore_2 = new utenteVenditore();//creo un venditore
        venditore_2.setUser("Vale91"); //aggiungo gli attributi
        venditore_2.setPwd("ciccioevale");
        venditore_2.setId(12);
        venditore_2.setIdConto(337);
        listaVenditori.add(venditore_2);// lo metto nella lista
        
        /*Venditore 3*/
        utenteVenditore venditore_3 = new utenteVenditore();//creo un venditore
        venditore_3.setUser("LeoxD"); //aggiungo gli attributi
        venditore_3.setPwd("DarkSouls");
        venditore_3.setId(123);
        venditore_3.setIdConto(50);
        listaVenditori.add(venditore_3);// lo metto nella lista
       
        
    }

    
    public ArrayList <utenteVenditore> getVenditoreList () {//restituisce la lista di tutti i venditori nel sistema
        return listaVenditori;
    }

    utenteVenditore getVenditorebyId(Integer idV){ //ogni venditore ha un id, quindi mi restituisce ogni venditore con un certo id
         
        for(utenteVenditore u : listaVenditori) //scorro la lista di venditori
        {
            if(Objects.equals(u.idV, idV)) //se l'id è uguale restituisco il venditore
                return u;
        }
        
        return null; //non c'è venditore con questo id
    }

}
