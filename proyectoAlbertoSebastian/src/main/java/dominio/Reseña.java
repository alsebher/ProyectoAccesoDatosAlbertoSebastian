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
public class Reseña implements Serializable {
    //atributos
    private int id_reseña;
    private float num_estrellas;
    private String comentario;
    private int id_usuario;
    private int id_producto;
    
    //constructores
    public Reseña() {
    }

    public Reseña(int id_reseña) {
        this.id_reseña = id_reseña;
    }

    public Reseña(int id_reseña, float num_estrellas, String comentario, int id_usuario, int id_producto) {
        this.id_reseña = id_reseña;
        this.num_estrellas = num_estrellas;
        this.comentario = comentario;
        this.id_usuario = id_usuario;
        this.id_producto = id_producto;
    }

    public Reseña(int id_reseña, float num_estrellas, String comentario) {
        this.id_reseña = id_reseña;
        this.num_estrellas = num_estrellas;
        this.comentario = comentario;
    }

    public Reseña(float num_estrellas, String comentario, int id_usuario, int id_producto) {
        this.num_estrellas = num_estrellas;
        this.comentario = comentario;
        this.id_usuario = id_usuario;
        this.id_producto = id_producto;
    }
    
    //getter & setter

    public int getId_reseña() {
        return id_reseña;
    }

    public void setId_reseña(int id_reseña) {
        this.id_reseña = id_reseña;
    }

    public float getNum_estrellas() {
        return num_estrellas;
    }

    public void setNum_estrellas(float num_estrellas) {
        this.num_estrellas = num_estrellas;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }
    
    //toString

    @Override
    public String toString() {
        return "============================================================================\nID : " + id_reseña + "\nValoracion : " + num_estrellas + " estrellas\nComentario : " + comentario + "\nID usuario : " + id_usuario + "\nID producto : " + id_producto + "\n";
    }
    
    //hashCode & equals

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + this.id_reseña;
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
        final Reseña other = (Reseña) obj;
        if (this.id_reseña != other.id_reseña) {
            return false;
        }
        return true;
    }

    
    
    
    
}
