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
public class PeliculaCliente {
    public String No_Cliente;
    public  String cliente;
    public String No_Pelicula;
    public  String pelicula;
    
    PeliculaCliente(){
    
    }

    public PeliculaCliente(String No_Cliente, String cliente,String No_Pelicula, String pelicula) {
        this.No_Cliente = No_Cliente;
        this.cliente = cliente;
        this.No_Pelicula = No_Pelicula;
        this.pelicula = pelicula;
        
        
    }

    public String getNo_Pelicula() {
        return No_Pelicula;
    }

    public void setNo_Pelicula(String No_Pelicula) {
        this.No_Pelicula = No_Pelicula;
    }

    public String getNo_Cliente() {
        return No_Cliente;
    }

    public void setNo_Cliente(String No_Cliente) {
        this.No_Cliente = No_Cliente;
    }

    public String getcliente() {
        return cliente;
    }

    public void setcliente(String cliente) {
        this.cliente = cliente;
    }

    public String getpelicula() {
        return pelicula;
    }

    public void setpelicula(String pelicula) {
        this.pelicula = pelicula;
    }
    
    
}
