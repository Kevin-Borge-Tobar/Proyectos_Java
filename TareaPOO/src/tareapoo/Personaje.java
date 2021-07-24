/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tareapoo;

/**
 *
 * @author Kevin Borge
 */
public  abstract class Personaje {
    private String nombre;
    private String vida = "100";
    
    public Personaje(){}

    public String getNombre() {
        return nombre;
    }

    public String getVida() {
        return vida;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setVida(String vida) {
        this.vida = vida;
    }
    
    
    public abstract String modificarVida();
        
    
}
