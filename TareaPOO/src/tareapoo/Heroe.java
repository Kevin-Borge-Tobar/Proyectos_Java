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
public class Heroe extends Personaje implements Guerrero {

    public Heroe(){
    super();
    setNombre("Heroe");
    setVida("1200");
    }
    
    @Override
    public String modificarVida() {
      String vida = this.getVida();
      String mensaje = "La vida del Heroe es de "+ vida+" Puntos";
      return mensaje;
    }

    @Override
    public String Atacar() {
        String Ataque ="El "+this.getNombre()+" Esta atancando";
        return Ataque;
    }
    
}
