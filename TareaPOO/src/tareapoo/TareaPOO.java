/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tareapoo;

import static java.time.Clock.system;

/**
 *
 * @author Kevin Borge
 */
public class TareaPOO {

    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Aldeano rene = new Aldeano();
        System.out.println(rene.modificarVida());
        
        Elfo ignacio = new Elfo();
        System.out.println(ignacio.modificarVida());
        System.out.println(ignacio.Atacar());
        
        Heroe merlin = new Heroe();
        System.out.println(merlin.modificarVida());
        System.out.println(merlin.Atacar());
        
        
    }
    
    
    
}
