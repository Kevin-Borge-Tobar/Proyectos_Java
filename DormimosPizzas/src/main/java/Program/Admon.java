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
public class Admon {
    private String Sucursal;
    private String Nombre;
    private String Precio;
    private  String Descripcion;

    public Admon(String Sucursal, String Nombre, String Precio, String Descripcion) {
        this.Sucursal = Sucursal;
        this.Nombre = Nombre;
        this.Precio = Precio;
        this.Descripcion = Descripcion;
    }
    Admon(){
    
    }

    public String getSucursal() {
        return Sucursal;
    }

    public void setSucursal(String Sucursal) {
        this.Sucursal = Sucursal;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getPrecio() {
        return Precio;
    }

    public void setPrecio(String Precio) {
        this.Precio = Precio;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }
    
    
    
}
