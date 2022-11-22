/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import static datos.Conexion.close;
import static datos.Conexion.getConnection;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

/**
 *
 * @author Alberto
 */
public class ReseñaDao {
    private static final String SQL_SELECT = "SELECT * FROM treseña";
    private static final String SQL_INSERT = "INSERT INTO treseña (num_estrellas,comentario,id_usuario,id_producto) VALUES(?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE treseña SET num_estrellas = ?,comentario = ?,id_usuario = ?,id_producto = ? WHERE id_reseña=?";
    private static final String SQL_DELETE = "DELETE FROM treseña WHERE id_reseña=?";
    
    public List<Reseña> seleccionar() throws SQLException, IOException{
        //Inicializo mis variables
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Reseña reseña = null;
        List<Reseña> reseñas = new ArrayList<>();
        
        conn = getConnection();
        stmt = conn.prepareStatement(SQL_SELECT);
        rs = stmt.executeQuery();
        
        while (rs.next()){
            int idResenya = rs.getInt("id_reseña");
            float estrellas = rs.getFloat("num_estrellas");
            String comentario = rs.getString("comentario");
            int id_usuario = rs.getInt("id_usuario");
            int id_producto = rs.getInt("id_producto");

            
            //Instancio un nuevo objeto
            reseñas.add(new Reseña(idResenya,estrellas,comentario,id_usuario,id_producto));
        }
        
        close(rs);
        close(stmt);
        close(conn);
        
        return reseñas;
    }
    
    public int insertar(Reseña reseña){
        //Declaro e inicializo mis variables
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        
        try {
            //1 Establecemos la conexion
            conn = getConnection();
            //2 Preparo mi instrucción para ejecutarla en la BD
            stmt = conn.prepareStatement(SQL_INSERT);
            //Asignar los valores de los ? de la consulta
            stmt.setFloat(1, reseña.getNum_estrellas());
            stmt.setString(2, reseña.getComentario());
            stmt.setInt(3, reseña.getId_usuario());
            stmt.setInt(4, reseña.getId_producto());
            
            //3 Ejecuto mi query
            registros = stmt.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        
        return registros;
        
    }
    
    public int actualizar(Reseña reseña){
        //Declaro e inicializo mis variables
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        
        try {
            //1 Establecemos la conexion
            conn = getConnection();
            //2 Preparo mi instrucción para ejecutarla en la BD
            stmt = conn.prepareStatement(SQL_UPDATE);
            //Asignar los valores de los ? de la consulta
            stmt.setFloat(1, reseña.getNum_estrellas());
            stmt.setString(2, reseña.getComentario());
            stmt.setInt(3, reseña.getId_usuario());
            stmt.setInt(4, reseña.getId_producto());
            stmt.setInt(5, reseña.getId_reseña());
            //3 Ejecuto mi query
            registros = stmt.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        
        return registros;
        
    }
    
    public int eliminar(Reseña reseña){
        //Declaro e inicializo mis variables
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        
        try {
            //1 Establecemos la conexion
            conn = getConnection();
            //2 Preparo mi instrucción para ejecutarla en la BD
            stmt = conn.prepareStatement(SQL_DELETE);
            //Asignar los valores de los ? de la consulta
            stmt.setInt(1,reseña.getId_reseña());
            //3 Ejecuto mi query
            registros = stmt.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        
        return registros;
        
    }
    
}
