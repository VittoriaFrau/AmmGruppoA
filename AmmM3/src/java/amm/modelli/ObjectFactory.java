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
public class ObjectFactory {
    
    private static ObjectFactory singleton;
    public static ObjectFactory getInstance() {  
        if (singleton == null) {    //la prima volta che chiamo getinstance singleton sarà null, alle successive restituiscono singleton
            singleton = new ObjectFactory(); //creo un nuovo gestore
        }
        return singleton;
    }
    
private ArrayList <Object> listaOggetti = new ArrayList <Object>();

private ObjectFactory(){//costruttore richiamato da getInstance
    /*inizializzo la lista Oggetti*/
    
    /*primo oggetto*/
    Object obj_1= new Object();
    obj_1.setNome("Borsa in pelle");
    obj_1.setPrezzo(50.0);
    obj_1.setUrl("img/1.jpg");
    obj_1.setDescrizione("Borsa in pelle marrone dimensioni medie");
    obj_1.setNumPezzi(10) ;
    obj_1.setId(610);
    obj_1.setIdV(12); //gli passo l'id del venditore 2
    listaOggetti.add(obj_1); //lo metto nella lista
    
    /*secondo oggetto*/
    Object obj_2= new Object();
    obj_2.setNome("Giacca scamosciata");
    obj_2.setPrezzo(30.0);
    obj_2.setUrl("img/2.jpg");
    obj_2.setDescrizione("Giacca scamosciata tutte le taglie");
    obj_2.setNumPezzi(30) ;
    obj_2.setIdV(440);
    obj_2.setIdV(123); //gli passo l'id del venditore 3
    listaOggetti.add(obj_2);  //lo metto nella lista
    
    /*Terzo oggetto*/
    Object obj_3= new Object();
    obj_3.setNome("Salopette in jeans");
    obj_3.setPrezzo(20.0);
    obj_3.setUrl("img/3.jpg");
    obj_3.setDescrizione("Salopette in jeans per bambino");
    obj_3.setNumPezzi(5) ;
    obj_3.setId(78);
    obj_3.setIdV(77); //gli passo l'id del venditore 1
    listaOggetti.add(obj_3);  //lo metto nella lista
    
    /*Quarto oggetto*/
    Object obj_4= new Object();
    obj_4.setNome("Abito in pizzo");
    obj_4.setPrezzo(25.0);
    obj_4.setUrl("img/4.jpg");
    obj_4.setDescrizione("Abito in pizzo nero da donna");
    obj_4.setNumPezzi(15) ;
    obj_4.setId(89);
    obj_4.setIdV(12); //gli passo l'id del venditore 2
    listaOggetti.add(obj_4);  //lo metto nella lista
    
    /*Quinto oggetto*/
    Object obj_5= new Object();
    obj_5.setNome("Pantaloni in cotone");
    obj_5.setPrezzo(40.0);
    obj_5.setUrl("img/5.jpg");
    obj_5.setDescrizione("Pantaloni in cotone color crema");
    obj_5.setNumPezzi(2) ;
    obj_5.setId(45);
    obj_5.setIdV(77); //gli passo l'id del venditore 1
    listaOggetti.add(obj_5);  //lo metto nella lista
    
    /*Sesto oggetto*/
    Object obj_6= new Object();
    obj_6.setNome("Ballerine bimba");
    obj_6.setPrezzo(15.0);
    obj_6.setUrl("img/6.jpg");
    obj_6.setDescrizione("Ballerine rosa per bambina");
    obj_6.setNumPezzi(20) ;
    obj_6.setId(33);
    obj_6.setIdV(123); //gli passo l'id del venditore 3
    listaOggetti.add(obj_6);  //lo metto nella lista
    
}
 ArrayList <Object> getObjectList () {//restituisce la lista di tutti gli oggetti
        return listaOggetti;
    }
 
 Object getObjectbyId(Integer id){ //ogni oggetto ha un id, quindi mi restituisce ogni oggetto con un certo id
         
        for(Object u : listaOggetti) //scorro la lista di oggetti
        {
            if(Objects.equals(u.id, id)) //se l'id è uguale restituisco l'oggetto
                return u;
        }
        
        return null; //non c'è oggetto con questo id
    }
}