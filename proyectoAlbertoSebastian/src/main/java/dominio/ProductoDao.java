/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import static datos.Conexion.close;
import static datos.Conexion.getConnection;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Alberto
 */
public class ProductoDao {
    private static final String SQL_SELECT = "SELECT * FROM tproducto";
    private static final String SQL_INSERT = "INSERT INTO tproducto (nombre_producto,precio,stock,descuento,existencia_oferta,imagen_producto,nombre_marca,nombre_categoria) VALUES(?,?,?,?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE tproducto SET nombre_producto = ?,precio = ?,stock = ?,descuento = ?,existencia_oferta = ?,imagen_producto = ?,nombre_marca = ?,nombre_categoria = ?  WHERE id_producto=?";
    private static final String SQL_DELETE = "DELETE FROM tproducto WHERE id_producto=?";
    private static final String SQL_BUSCADOR = "SELECT * FROM tproducto WHERE id_producto=?";
    
    public List<Producto> seleccionar() throws SQLException, IOException{
        //Inicializo mis variables
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Producto producto = null;
        List<Producto> productos = new ArrayList<>();
        
        conn = getConnection();
        stmt = conn.prepareStatement(SQL_SELECT);
        rs = stmt.executeQuery();
        
        while (rs.next()){
            int idProducto = rs.getInt("id_producto");
            String nombre_producto = rs.getString("nombre_producto");
            double precio = rs.getDouble("precio");
            int stock = rs.getInt("stock");
            double descuento = rs.getDouble("descuento");
            boolean existencia_oferta = rs.getBoolean("existencia_oferta");
            Blob imagen = rs.getBlob("imagen_producto");
            String nombre_marca = rs.getString("nombre_marca");
            String nombre_categoria = rs.getString("nombre_categoria");
            //conversión de imagen
            InputStream imagenStream = imagen.getBinaryStream();
            ByteArrayOutputStream outputImagen = new ByteArrayOutputStream();
            byte[] buffer = new byte[4096];
            int bytesLeidos = -1;
            
            while((bytesLeidos = imagenStream.read(buffer)) != -1) {
                outputImagen.write(buffer, 0, bytesLeidos);                  
            }
            byte[] imagenBytes = outputImagen.toByteArray();
            String imagen64 = Base64.getEncoder().encodeToString(imagenBytes);
            imagenStream.close();
            outputImagen.close();

            
            //Instancio un nuevo objeto
            productos.add(new Producto(idProducto,nombre_producto,precio,stock,descuento,existencia_oferta,imagen64,nombre_marca,nombre_categoria));
        }
        
        close(rs);
        close(stmt);
        close(conn);
        
        return productos;
    }
    
    public int insertar(Producto producto) throws FileNotFoundException{
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
            stmt.setString(1, producto.getNombre_producto());
            stmt.setDouble(2, producto.getPrecio());
            stmt.setInt(3, producto.getStock());
            stmt.setDouble(4, producto.getDescuento());
            stmt.setBoolean(5, producto.isExistencia_oferta());
            InputStream imagen = new FileInputStream(producto.getImagen_producto());
            stmt.setBlob(6, imagen);
            stmt.setString(7, producto.getNombre_marca());
            stmt.setString(8, producto.getNombre_categoria());
            
            
            
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
    
    public int actualizar(Producto producto) throws FileNotFoundException{
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
            stmt.setString(1, producto.getNombre_producto());
            stmt.setDouble(2, producto.getPrecio());
            stmt.setInt(3, producto.getStock());
            stmt.setDouble(4, producto.getDescuento());
            stmt.setBoolean(5, producto.isExistencia_oferta());
            InputStream imagen = new FileInputStream(producto.getImagen_producto());
            stmt.setBlob(6, imagen);
            stmt.setString(7, producto.getNombre_marca());
            stmt.setString(8, producto.getNombre_categoria());
            stmt.setInt(9, producto.getId_producto());
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
    
    public int eliminar(Producto producto){
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
            stmt.setInt(1,producto.getId_producto());
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
