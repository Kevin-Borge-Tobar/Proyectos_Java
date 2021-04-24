/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
*/


package lista;

/**
 *
 * @author Kevin Borge
 */
public class Lista {
    private String nombreCompleto;
    private int cont;
    
    public Lista(){
    
    }
    public Lista(String nombreCompleto, int cont) {
        this.nombreCompleto = nombreCompleto;
        this.cont = cont;
    }
    public String getNombreCompleto() {
        return nombreCompleto;
    }
    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }
    public int getCont() {
        return cont;
    }
    public void setCont(int cont) {
        this.cont = cont;
    }
}
