/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.util.Objects;

/**
 *
 * @author Alumno Mañana
 */
public class Marca {
    //atributos
    private String nombre_marca;
    private int productos_marca;
    
    //constructores
    public Marca() {
    }

    public Marca(String nombre_marca, int productos_marca) {
        this.nombre_marca = nombre_marca;
        this.productos_marca = productos_marca;
    }

    public Marca(String nombre_marca) {
        this.nombre_marca = nombre_marca;
    }

    public Marca(int productos_marca) {
        this.productos_marca = productos_marca;
    }
    
    //getter & setter

    public String getNombre_marca() {
        return nombre_marca;
    }

    public void setNombre_marca(String nombre_marca) {
        this.nombre_marca = nombre_marca;
    }

    public int getProductos_marca() {
        return productos_marca;
    }

    public void setProductos_marca(int productos_marca) {
        this.productos_marca = productos_marca;
    }
    
    //toString

    @Override
    public String toString() {
        return "============================================================================\nNombre : " + nombre_marca + "\nNúmero productos : " + productos_marca + "\n";
    }
    
    //equals & hashCode

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.nombre_marca);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Marca other = (Marca) obj;
        if (!Objects.equals(this.nombre_marca, other.nombre_marca)) {
            return false;
        }
        return true;
    }
    
    
    
}
