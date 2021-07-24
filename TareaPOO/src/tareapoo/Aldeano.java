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
public class Aldeano extends Personaje{
    
    public Aldeano(){
    super();
    setNombre("Aldeano");
    setVida("300");
        
    }

    @Override
    public String modificarVida() {
    String vida = this.getVida();
    String resultado = "la vida del Aldeano es de "+ vida+" Puntos";
    return resultado;
      
    }
    
    
    
}
