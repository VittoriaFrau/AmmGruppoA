/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.modelli;
 
/**
 *
 * @author vicky
 */
public class utenteVenditore {
    String username;
    String pwd;
    public Integer idV; //creo un id per ogni venditore per identificarlo in maniera univoca
    Integer Idconto;

  
   
    
    utenteVenditore(){
        
    }
    
    public void setId(Integer idV){
        this.idV=idV;
    }
    
      public void setIdConto(Integer Idconto) {
        this.Idconto = Idconto;
    }

      
     public Integer getIdconto() {
        return Idconto;
    }
     
    public void setUser(String username){
        this.username=username;
    }
    
    public void setPwd(String pw){
        this.pwd=pwd;
    }
    
    public String getUser(){
        return username;
    }
    
    public String getPwd(){
        return pwd;
    }
    
    public Integer getId(){
        return idV;
    }
}
