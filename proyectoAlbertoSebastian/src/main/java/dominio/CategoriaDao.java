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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alberto
 */
public class CategoriaDao {
    private static final String SQL_SELECT = "SELECT * FROM tcategoria";
    private static final String SQL_INSERT = "INSERT INTO tcategoria (nombre_categoria,productos_categoria) VALUES(?,?)";
    private static final String SQL_UPDATE = "UPDATE tcategoria SET productos_categoria = ? WHERE nombre_categoria=?";
    private static final String SQL_DELETE = "DELETE FROM tcategoria WHERE nombre_categoria=?";
    
    public List<Categoria> seleccionar() throws SQLException, IOException{
        //Inicializo mis variables
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Categoria categoria = null;
        List<Categoria> categorias = new ArrayList<>();
        
        conn = getConnection();
        stmt = conn.prepareStatement(SQL_SELECT);
        rs = stmt.executeQuery();
        
        while (rs.next()){
            String nombre = rs.getString("nombre_categoria");           
            int prod = rs.getInt("productos_categoria");
            
            //Instancio un nuevo objeto
            categorias.add(new Categoria(nombre,prod));
        }
        
        close(rs);
        close(stmt);
        close(conn);
        
        return categorias;
    }
    
    public int insertar(Categoria categoria){
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
            stmt.setString(1, categoria.getNombre_categoria());
            stmt.setInt(2, categoria.getProductos_categoria());
            
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
    
    public int actualizar(Categoria categoria){
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
            stmt.setInt(1, categoria.getProductos_categoria());
            stmt.setString(2, categoria.getNombre_categoria());
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
    
    public int eliminar(Categoria categoria){
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
            stmt.setString(1,categoria.getNombre_categoria());
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
