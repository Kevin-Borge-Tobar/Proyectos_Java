/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea.ii;

import java.util.List;

/**
 *
 * @author Kevin Borge
 */
public class Compania {
    private String actividad;
    private String numero;
    private List<Cuartel> cuarteles;
    
    public Compania(){
    
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String Actividad) {
        this.actividad = Actividad;
    }

    public List<Cuartel>  getCuarteles() {
        return cuarteles;
    }

    public void setCuarteles(List<Cuartel>cuarteles) {
        this.cuarteles = cuarteles;
    }
    
    
}
