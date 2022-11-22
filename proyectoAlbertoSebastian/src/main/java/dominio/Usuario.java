/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Alumno Mañana
 */
public class Usuario implements Serializable {
    //atributos
    private int id_usuario;
    private String nombre_usuario;
    private String ape_usuario;
    private String direccion;
    private String correo;
    private String contrasenya;
    private Date fecha_alta;
    private double dinero_cuenta;
    private int telefono;
    private int cod_postal;
    private String imagen_usuario;
    
    //constructores
    public Usuario() {
    }

    public Usuario(int id_usuario, String nombre_usuario, String ape_usuario, String direccion, String correo, String contrasenya, Date fecha_alta, double dinero_cuenta, int telefono, int cod_postal) {
        this.id_usuario = id_usuario;
        this.nombre_usuario = nombre_usuario;
        this.ape_usuario = ape_usuario;
        this.direccion = direccion;
        this.correo = correo;
        this.contrasenya = contrasenya;
        this.fecha_alta = fecha_alta;
        this.dinero_cuenta = dinero_cuenta;
        this.telefono = telefono;
        this.cod_postal = cod_postal;
    }

    public Usuario(String nombre_usuario, String ape_usuario, String direccion, String correo, String contrasenya, Date fecha_alta, double dinero_cuenta, int telefono, int cod_postal) {
        this.nombre_usuario = nombre_usuario;
        this.ape_usuario = ape_usuario;
        this.direccion = direccion;
        this.correo = correo;
        this.contrasenya = contrasenya;
        this.fecha_alta = fecha_alta;
        this.dinero_cuenta = dinero_cuenta;
        this.telefono = telefono;
        this.cod_postal = cod_postal;
    }

    public Usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public Usuario(int id_usuario, String nombre_usuario, String ape_usuario, String direccion, String correo, String contrasenya, Date fecha_alta, double dinero_cuenta, int telefono, int cod_postal, String imagen_usuario) {
        this.id_usuario = id_usuario;
        this.nombre_usuario = nombre_usuario;
        this.ape_usuario = ape_usuario;
        this.direccion = direccion;
        this.correo = correo;
        this.contrasenya = contrasenya;
        this.fecha_alta = fecha_alta;
        this.dinero_cuenta = dinero_cuenta;
        this.telefono = telefono;
        this.cod_postal = cod_postal;
        this.imagen_usuario = imagen_usuario;
    }

    public Usuario(String nombre_usuario, String ape_usuario, String direccion, String correo, String contrasenya, Date fecha_alta, double dinero_cuenta, int telefono, int cod_postal, String imagen_usuario) {
        this.nombre_usuario = nombre_usuario;
        this.ape_usuario = ape_usuario;
        this.direccion = direccion;
        this.correo = correo;
        this.contrasenya = contrasenya;
        this.fecha_alta = fecha_alta;
        this.dinero_cuenta = dinero_cuenta;
        this.telefono = telefono;
        this.cod_postal = cod_postal;
        this.imagen_usuario = imagen_usuario;
    }
    
    
    
    
    //getter & setter

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getApe_usuario() {
        return ape_usuario;
    }

    public void setApe_usuario(String ape_usuario) {
        this.ape_usuario = ape_usuario;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasenya() {
        return contrasenya;
    }

    public void setContrasenya(String contrasenya) {
        this.contrasenya = contrasenya;
    }

    public Date getFecha_alta() {
        return fecha_alta;
    }

    public void setFecha_alta(Date fecha_alta) {
        this.fecha_alta = fecha_alta;
    }

    
    public double getDinero_cuenta() {
        return dinero_cuenta;
    }

    public void setDinero_cuenta(double dinero_cuenta) {
        this.dinero_cuenta = dinero_cuenta;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public int getCod_postal() {
        return cod_postal;
    }

    public void setCod_postal(int cod_postal) {
        this.cod_postal = cod_postal;
    }

    public String getImagen_usuario() {
        return imagen_usuario;
    }

    public void setImagen_usuario(String imagen_usuario) {
        this.imagen_usuario = imagen_usuario;
    }
    
    //toString

    @Override
    public String toString() {
        return "============================================================================\nID : " + id_usuario + "\nNombre : " + nombre_usuario + "\nApellido : " + ape_usuario + "\nDireccion : " + direccion + "\nCorreo : " + correo + "\nContraseña : " + contrasenya + "\nFecha de alta : " + fecha_alta + "\nDinero en la cartera : " + dinero_cuenta + " €\nTelefono : " + telefono + "\nCódigo postal : " + cod_postal + "\n";
    }
    

   
    
    //equals & hashCode

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + this.id_usuario;
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
        final Usuario other = (Usuario) obj;
        if (this.id_usuario != other.id_usuario) {
            return false;
        }
        return true;
    }
    
    
}
