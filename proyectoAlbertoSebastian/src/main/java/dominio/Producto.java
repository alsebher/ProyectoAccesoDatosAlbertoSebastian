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
public class Producto implements Serializable {
    //atributos
    private int id_producto;
    private String nombre_producto;
    private double precio;
    private int stock;
    private double descuento;
    private boolean existencia_oferta;
    private String imagen_producto;
    private String nombre_marca;
    private String nombre_categoria;
    
    //constructores
    public Producto() {
    }

    public Producto(int id_producto, String nombre_producto, double precio, int stock, double descuento, boolean existencia_oferta, String imagen_producto, String nombre_marca, String nombre_categoria) {
        this.id_producto = id_producto;
        this.nombre_producto = nombre_producto;
        this.precio = precio;
        this.stock = stock;
        this.descuento = descuento;
        this.existencia_oferta = existencia_oferta;
        this.imagen_producto = imagen_producto;
        this.nombre_marca = nombre_marca;
        this.nombre_categoria = nombre_categoria;
    }

    public Producto(String nombre_producto, double precio, int stock, double descuento, boolean existencia_oferta, String imagen_producto, String nombre_marca, String nombre_categoria) {
        this.nombre_producto = nombre_producto;
        this.precio = precio;
        this.stock = stock;
        this.descuento = descuento;
        this.existencia_oferta = existencia_oferta;
        this.imagen_producto = imagen_producto;
        this.nombre_marca = nombre_marca;
        this.nombre_categoria = nombre_categoria;
    }

    
    public Producto(int id_producto, double precio, int stock, double descuento, boolean existencia_oferta, String nombre_marca, String nombre_categoria) {
        this.id_producto = id_producto;
        this.precio = precio;
        this.stock = stock;
        this.descuento = descuento;
        this.existencia_oferta = existencia_oferta;
        this.nombre_marca = nombre_marca;
        this.nombre_categoria = nombre_categoria;
    }

    public Producto(double precio, int stock, double descuento, boolean existencia_oferta, String nombre_marca, String nombre_categoria) {
        this.precio = precio;
        this.stock = stock;
        this.descuento = descuento;
        this.existencia_oferta = existencia_oferta;
        this.nombre_marca = nombre_marca;
        this.nombre_categoria = nombre_categoria;
    }

    public Producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public Producto(int id_producto, double precio, int stock, double descuento, boolean existencia_oferta, String imagen_producto, String nombre_marca, String nombre_categoria) {
        this.id_producto = id_producto;
        this.precio = precio;
        this.stock = stock;
        this.descuento = descuento;
        this.existencia_oferta = existencia_oferta;
        this.imagen_producto = imagen_producto;
        this.nombre_marca = nombre_marca;
        this.nombre_categoria = nombre_categoria;
    }

    public Producto(double precio, int stock, double descuento, boolean existencia_oferta, String imagen_producto, String nombre_marca, String nombre_categoria) {
        this.precio = precio;
        this.stock = stock;
        this.descuento = descuento;
        this.existencia_oferta = existencia_oferta;
        this.imagen_producto = imagen_producto;
        this.nombre_marca = nombre_marca;
        this.nombre_categoria = nombre_categoria;
    }
    
    
    
    
    
    //getter & setter

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }
    

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public boolean isExistencia_oferta() {
        return existencia_oferta;
    }

    public void setExistencia_oferta(boolean existencia_oferta) {
        this.existencia_oferta = existencia_oferta;
    }

    public String getImagen_producto() {
        return imagen_producto;
    }

    public void setImagen_producto(String imagen_producto) {
        this.imagen_producto = imagen_producto;
    }
    

    public String getNombre_marca() {
        return nombre_marca;
    }

    public void setNombre_marca(String nombre_marca) {
        this.nombre_marca = nombre_marca;
    }

    public String getNombre_categoria() {
        return nombre_categoria;
    }

    public void setNombre_categoria(String nombre_categoria) {
        this.nombre_categoria = nombre_categoria;
    }
    
    //toString

    @Override
    public String toString() {
        if(existencia_oferta == false){
            return "============================================================================\nID : " + id_producto + "\nNombre : " + nombre_producto + "\nPrecio : " + precio + " €\nStock : " + stock + "\nMarca : " + nombre_marca + "\nCategoria : " + nombre_categoria + "\n";
        }else{
            return "============================================================================\nID : " + id_producto + "\nNombre : " + nombre_producto + "\nPrecio : " + precio + " €\nStock : " + stock + "\nDescuento : " + descuento + "%\nMarca : " + nombre_marca + "\nCategoria : " + nombre_categoria + "\n";
        }
        
    }

    

    
    
    //equals & hashCode

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.id_producto;
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
        final Producto other = (Producto) obj;
        if (this.id_producto != other.id_producto) {
            return false;
        }
        return true;
    }

    
    
    
    
}
