/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.io.Serializable;
import java.util.Objects;
import java.util.Date;

/**
 *
 * @author Alumno Mañana
 */
public class Compra implements Serializable {
    //atributos
    private int id_compra;
    private double gastos_envio;
    private double importe;
    private Date fecha_compra;
    private int id_usuario;
    private int id_producto;
    
    //constructores
    public Compra() {
    }

    public Compra(int id_compra, double gastos_envio, double importe, Date fecha_compra, int id_usuario) {
        this.id_compra = id_compra;
        this.gastos_envio = gastos_envio;
        this.importe = importe;
        this.fecha_compra = fecha_compra;
        this.id_usuario = id_usuario;
    }

    public Compra(int id_compra) {
        this.id_compra = id_compra;
    }

    public Compra(double gastos_envio, double importe, Date fecha_compra, int id_usuario) {
        this.gastos_envio = gastos_envio;
        this.importe = importe;
        this.fecha_compra = fecha_compra;
        this.id_usuario = id_usuario;
    }

    public Compra(int id_compra, double gastos_envio, double importe, Date fecha_compra) {
        this.id_compra = id_compra;
        this.gastos_envio = gastos_envio;
        this.importe = importe;
        this.fecha_compra = fecha_compra;
    }

    public Compra(int id_compra, double gastos_envio, double importe, Date fecha_compra, int id_usuario, int id_producto) {
        this.id_compra = id_compra;
        this.gastos_envio = gastos_envio;
        this.importe = importe;
        this.fecha_compra = fecha_compra;
        this.id_usuario = id_usuario;
        this.id_producto = id_producto;
    }

    public Compra(double gastos_envio, double importe, Date fecha_compra, int id_usuario, int id_producto) {
        this.gastos_envio = gastos_envio;
        this.importe = importe;
        this.fecha_compra = fecha_compra;
        this.id_usuario = id_usuario;
        this.id_producto = id_producto;
    }
    
    
    
    
    //getter & setter

    public int getId_compra() {
        return id_compra;
    }

    public void setId_compra(int id_compra) {
        this.id_compra = id_compra;
    }

    public double getGastos_envio() {
        return gastos_envio;
    }

    public void setGastos_envio(double gastos_envio) {
        this.gastos_envio = gastos_envio;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public Date getFecha_compra() {
        return fecha_compra;
    }

    public void setFecha_compra(Date fecha_compra) {
        this.fecha_compra = fecha_compra;
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
        return "============================================================================\nID : " + id_compra + "\nGastos de envio : " + gastos_envio + "\nImporte : " + importe + "\nFecha de compra : " + fecha_compra + "\nID usuario : " + id_usuario + "\nID producto : "+id_producto+"\n";
    }
    
    //equals & hashCode

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + this.id_compra;
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
        final Compra other = (Compra) obj;
        if (this.id_compra != other.id_compra) {
            return false;
        }
        return true;
    }

    
    
    
    
}
