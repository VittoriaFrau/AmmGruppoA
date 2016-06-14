/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.modelli;
 
import java.util.logging.Logger;

/**
 *
 * @author vicky
 */
public class Object {
    String nome;
    String url;
    String descrizione;
    double prezzo;
    Integer numPezzi;
    public Integer idV; //creo un id per ogni oggetto per identificare il venditore
    Integer id; //ogni oggetto ha un suo id


    public Object(){

    }

    public Object(String nome, String descrizione, double prezzo, int numPezzi, String url, utenteVenditore venditore) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
    public Integer getId() {
        return id;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    public void setNumPezzi(Integer numPezzi) {
        this.numPezzi = numPezzi;
    }

    public void setIdV(Integer idV) {
        this.idV = idV;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    

    public String getNome() {
        return nome;
    }

    public String getUrl() {
        return url;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public Integer getNumPezzi() {
        return numPezzi;
    }

    public Integer getIdV() {
        return idV;
    }


}
