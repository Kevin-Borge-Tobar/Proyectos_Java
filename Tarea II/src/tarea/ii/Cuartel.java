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
public class Cuartel {
    private String nombre;
    private String codigo;
    private String Ubcacion;
    private List<Compania>Companias;
    
    Cuartel(){
    } 

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getUbcacion() {
        return Ubcacion;
    }

    public void setUbcacion(String Ubcacion) {
        this.Ubcacion = Ubcacion;
    }

    public List<Compania> getCompanias() {
        return Companias;
    }

    public void setCompanias(List<Compania> Companias) {
        this.Companias = Companias;
    }
    
  
}
