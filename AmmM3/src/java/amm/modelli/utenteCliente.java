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
public class utenteCliente {
    
    String username;
    public String pwd;
    public Integer id; //creo un id per ogni cliente per identificarlo in maniera univoca
    Integer IdConto; 

    
    utenteCliente(){
        
    }
    
    public void setId(Integer id){
        this.id=id;
    }
    
    public void setUsername(String username){
        this.username=username;
    }
    
    public void setPwd(String pwd){
        this.pwd=pwd;
    }
    
    
    public String getPwd(){
        return pwd;
    }
    
    public Integer getId(){
        return id;
    }
    public String getUsername() {
        return username;
    }

    public Integer getIdConto() {
        return IdConto;
    }
    
    
    public void setIdConto(Integer IdConto) {
        this.IdConto = IdConto;
    }

    
}
