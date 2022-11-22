/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Alumno Mañana
 */
public class Categoria implements Serializable {
    //atributos
    private String nombre_categoria;
    private int productos_categoria;
    
    //constructores
    public Categoria() {
    }

    public Categoria(String nombre_categoria, int productos_categoria) {
        this.nombre_categoria = nombre_categoria;
        this.productos_categoria = productos_categoria;
    }

    public Categoria(String nombre_categoria) {
        this.nombre_categoria = nombre_categoria;
    }

    public Categoria(int productos_categoria) {
        this.productos_categoria = productos_categoria;
    }
    
    //getter & setter

    public String getNombre_categoria() {
        return nombre_categoria;
    }

    public void setNombre_categoria(String nombre_categoria) {
        this.nombre_categoria = nombre_categoria;
    }

    public int getProductos_categoria() {
        return productos_categoria;
    }

    public void setProductos_categoria(int productos_categoria) {
        this.productos_categoria = productos_categoria;
    }
    
    //toString

    @Override
    public String toString() {
        return "============================================================================\nNombre : " + nombre_categoria + "\nNúmero productos : " + productos_categoria + "\n";
    }
    
    //equelas & hashCode

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + Objects.hashCode(this.nombre_categoria);
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
        final Categoria other = (Categoria) obj;
        if (!Objects.equals(this.nombre_categoria, other.nombre_categoria)) {
            return false;
        }
        return true;
    }
    
    
    
}
