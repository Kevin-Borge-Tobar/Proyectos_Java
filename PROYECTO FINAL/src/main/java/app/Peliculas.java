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
public class Peliculas {
public  String nombre;
public String tipo;
public String genero;
public String sinopsis;
public int noPelicula;

public Peliculas(){
}

    public Peliculas(String nombre, String tipo, String genero, String Sinopsis, int noPelicula) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.genero = genero;
        this.sinopsis = Sinopsis;
        this.noPelicula = noPelicula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getsinopsis() {
        return sinopsis;
    }

    public void setsinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public int getNoPelicula() {
        return noPelicula;
    }

    public void setNoPelicula(int noPelicula) {
        this.noPelicula = noPelicula;
    }

}
