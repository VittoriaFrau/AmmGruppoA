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
public class SaldoClientiVenditori {
    Integer id;
    double saldo;
    
    public SaldoClientiVenditori (){
        
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Integer getId() {
        return id;
    }

    public double getSaldo() {
        return saldo;
    }
    
    
}
