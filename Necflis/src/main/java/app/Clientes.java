/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

/**
 *
 * @author Kevin Borge
 */
public class Clientes {
    private String nombre;
    private String direccion;
    private String edad;
    private int noCliente;
    
      public Clientes(){
          
    }


    public Clientes(String nombre, String direccion, String edad, int noCliente) {
        this.nombre = nombre;
        this.edad = edad;
        this.direccion = direccion;
        this.noCliente = noCliente;
    }
    
  
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public int getNoCliente() {
        return noCliente;
    }

    public void setNoCliente(int noCliente) {
        this.noCliente = noCliente;
    }
    
   
    
}
