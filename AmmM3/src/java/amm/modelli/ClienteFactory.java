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
public class ClienteFactory {
    private static ClienteFactory singleton;
    public static ClienteFactory getInstance() {  
        if (singleton == null) {    //la prima volta che chiamo getinstance singleton sarà null, alle successive restituiscono singleton
            singleton = new ClienteFactory(); //creo un nuovo gestore
        }
        return singleton;
    }
    
     /*creo  un attributo da richiamare nel costruttore*/
     public ArrayList <utenteCliente> listaClienti = new ArrayList <utenteCliente>();
    
    
    public ClienteFactory(){  //costruttore richiamato da getInstance
        /*inizializzo la listaClienti*/
        
        /*Cliente 1*/
        utenteCliente cliente_1 = new utenteCliente();//creo un cliente
        cliente_1.setUsername("GiacomoF"); //aggiungo gli attributi
        cliente_1.setPwd("globuLi");
        cliente_1.setId(43);
        cliente_1.setIdConto(99);
        listaClienti.add(cliente_1);// lo metto nella lista
        
        /*Cliente 2*/
        utenteCliente cliente_2 = new utenteCliente();//creo un cliente
        cliente_2.setUsername("michi91"); //aggiungo gli attributi
        cliente_2.setPwd("tabacco");
        cliente_2.setId(100);
        cliente_2.setIdConto(004);
        listaClienti.add(cliente_2);// lo metto nella lista
        
        /*Cliente 3*/
        utenteCliente cliente_3 = new utenteCliente();//creo un cliente
        cliente_3.setUsername("viola"); //aggiungo gli attributi
        cliente_3.setPwd("peppapig");
        cliente_3.setId(17);
        cliente_3.setIdConto(629);
        listaClienti.add(cliente_3);// lo metto nella lista
       
        
    }

    
    public ArrayList <utenteCliente> getClienteList () {//restituisce la lista di tutti i clienti nel sistema
        return listaClienti;
    }

    utenteCliente getClientibyId(Integer id){ //ogni cliente ha un id, quindi mi restituisce ogni venditore con un certo id
         
        for(utenteCliente u : listaClienti) //scorro la lista di clienti
        {
            if(Objects.equals(u.id, id)) //se l'id è uguale restituisco il cliente
                return u;
        }
        
        return null; //non c'è cliente con questo id
    }
}
