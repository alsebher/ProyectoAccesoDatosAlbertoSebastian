/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import static datos.Conexion.close;
import static datos.Conexion.getConnection;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Alberto
 */
public class CompraDao {
    private static final String SQL_SELECT = "SELECT * FROM tcompra";
    private static final String SQL_INSERT = "INSERT INTO tcompra (gastos_envio,importe,fecha_compra,id_usuario,id_producto) VALUES(?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE tcompra SET gastos_envio = ?,importe = ?,fecha_compra = ?,id_usuario = ?,id_producto = ? WHERE id_compra=?";
    private static final String SQL_DELETE = "DELETE FROM tcompra WHERE id_compra=?";
    
    public List<Compra> seleccionar() throws SQLException, IOException{
        //Inicializo mis variables
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Compra compra = null;
        List<Compra> compras = new ArrayList<>();
        
        conn = getConnection();
        stmt = conn.prepareStatement(SQL_SELECT);
        rs = stmt.executeQuery();
        
        while (rs.next()){
            int idCompra = rs.getInt("id_compra");
            double gastos_envio = rs.getDouble("gastos_envio");
            double importe = rs.getDouble("importe");
            Date fecha_compra = rs.getDate("fecha_compra");
            int id_usuario = rs.getInt("id_usuario");
            int id_producto = rs.getInt("id_producto");

            
            //Instancio un nuevo objeto
            compras.add(new Compra(idCompra,gastos_envio,importe,fecha_compra,id_usuario,id_producto));
        }
        
        close(rs);
        close(stmt);
        close(conn);
        
        return compras;
    }
    
    public int insertar(Compra compra){
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
            stmt.setDouble(1, compra.getGastos_envio());
            stmt.setDouble(2, compra.getImporte());
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String formattedDate = simpleDateFormat.format(compra.getFecha_compra());
            java.sql.Date date = java.sql.Date.valueOf(formattedDate);
            stmt.setDate(3, date);
            stmt.setInt(4, compra.getId_usuario());
            stmt.setInt(5, compra.getId_producto());
            
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
    
    public int actualizar(Compra compra){
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
            stmt.setDouble(1, compra.getGastos_envio());
            stmt.setDouble(2, compra.getImporte());
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String formattedDate = simpleDateFormat.format(compra.getFecha_compra());
            java.sql.Date date = java.sql.Date.valueOf(formattedDate);
            stmt.setDate(3, date);
            stmt.setInt(4, compra.getId_usuario());
            stmt.setInt(5, compra.getId_producto());
            stmt.setInt(6, compra.getId_compra());
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
    
    public int eliminar(Compra compra){
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
            stmt.setInt(1,compra.getId_compra());
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
