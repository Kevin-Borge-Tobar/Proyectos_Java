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
public class Elfo extends Personaje implements Guerrero {
    
    Elfo(){
    super();
    setNombre("Elfo");
    setVida("800");
    
    }

    @Override
    public String modificarVida() {
        String vida = this.getVida();
        String resultado = "La vida del Elfo es de "+ vida +" Puntos";
        return resultado;
        
    }

    @Override
    public String Atacar() {
        String Ataque ="El "+ this.getNombre()+" Esta atancando";
        return Ataque;
    }
    
    
}
