/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Program;

/**
 *
 * @author Kevin Borge
 */
public class Pedidos {
    private String NoOrden;
    private String Pizza;
    private String Descripcion;
    private String Sucursal;

    public Pedidos(String NoOrden, String Pizza, String Descripcion, String Sucursal) {
        this.NoOrden = NoOrden;
        this.Pizza = Pizza;
        this.Descripcion = Descripcion;
        this.Sucursal = Sucursal;
    }
    
  Pedidos(){
      
  }

    public String getNoOrden() {
        return NoOrden;
    }

    public void setNoOrden(String NoOrden) {
        this.NoOrden = NoOrden;
    }

    public String getPizza() {
        return Pizza;
    }

    public void setPizza(String Pizza) {
        this.Pizza = Pizza;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public String getSucursal() {
        return Sucursal;
    }

    public void setSucursal(String Sucursal) {
        this.Sucursal = Sucursal;
    }
  
}
