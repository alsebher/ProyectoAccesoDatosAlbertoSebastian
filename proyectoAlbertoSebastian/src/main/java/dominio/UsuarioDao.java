/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import static datos.Conexion.close;
import static datos.Conexion.getConnection;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

/**
 *
 * @author Alumno Mañana
 */
public class UsuarioDao {
    private static final String SQL_SELECT = "SELECT * FROM tusuario";
    private static final String SQL_INSERT = "INSERT INTO tusuario (nombre_usuario,ape_usuario,direccion,correo,contrasenya,fecha_alta,dinero_cuenta,telefono,cod_postal,imagen_usuario) VALUES(?,?,?,?,?,?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE tusuario SET nombre_usuario = ?,ape_usuario = ?,direccion = ?,correo = ?,contrasenya = ?,fecha_alta = ?,dinero_cuenta = ?,telefono = ?, cod_postal = ?, imagen_usuario = ?  WHERE id_usuario=?";
    private static final String SQL_DELETE = "DELETE FROM tusuario WHERE id_usuario=?";
    
    public String convertToMD5(String input) throws Exception {
    String md5 = null;
    if (null == input)
        return null;
    try {
        // Create MessageDigest object for MD5
        MessageDigest digest = MessageDigest.getInstance("MD5");
        // Update input string in message digest
        digest.update(input.getBytes(), 0, input.length());
        // Converts message digest value in base 16 (hex)
        md5 = new BigInteger(1, digest.digest()).toString(16);
    } catch (NoSuchAlgorithmException e) {

        throw e;
    }
    return md5;
}
    
    public List<Usuario> seleccionar() throws SQLException, IOException{
        //Inicializo mis variables
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Usuario usuario = null;
        List<Usuario> usuarios = new ArrayList<>();
        
        conn = getConnection();
        stmt = conn.prepareStatement(SQL_SELECT);
        rs = stmt.executeQuery();
        
        while (rs.next()){
            int idUsuario = rs.getInt("id_usuario");
            String nombre = rs.getString("nombre_usuario");
            String apellidos = rs.getString("ape_usuario");
            String direccion = rs.getString("direccion");
            String correo = rs.getString("correo");
            String contrasena = rs.getString("contrasenya");
            Date fechaAlta = rs.getDate("fecha_alta");
            Double dinero = rs.getDouble("dinero_cuenta");
            int telef = rs.getInt("telefono");
            int codigoPostal = rs.getInt("cod_postal");
            Blob imagen = rs.getBlob("imagen_usuario");
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
            usuarios.add(new Usuario(idUsuario,nombre,apellidos,direccion,correo,contrasena,fechaAlta,dinero,telef,codigoPostal,imagen64));
        }
        
        close(rs);
        close(stmt);
        close(conn);
        
        return usuarios;
    }
      
    public int insertar(Usuario usuario) throws FileNotFoundException, Exception{
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
            stmt.setString(1, usuario.getNombre_usuario());
            stmt.setString(2, usuario.getApe_usuario());
            stmt.setString(3, usuario.getDireccion());
            stmt.setString(4, usuario.getCorreo());
            String cifrado = convertToMD5(usuario.getContrasenya());
            stmt.setString(5, cifrado);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");          
            String formattedDate = simpleDateFormat.format(usuario.getFecha_alta());
            java.sql.Date date = java.sql.Date.valueOf(formattedDate);
            stmt.setDate(6, date);
            stmt.setDouble(7, usuario.getDinero_cuenta());
            stmt.setInt(8, usuario.getTelefono());
            stmt.setInt(9, usuario.getCod_postal());
            InputStream imagen = new FileInputStream(usuario.getImagen_usuario());
            stmt.setBlob(10, imagen);
            
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
    
    public int actualizar(Usuario usuario) throws FileNotFoundException, Exception{
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
            stmt.setString(1, usuario.getNombre_usuario());
            stmt.setString(2, usuario.getApe_usuario());
            stmt.setString(3, usuario.getDireccion());
            stmt.setString(4, usuario.getCorreo());
            stmt.setString(5, usuario.getContrasenya());
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String formattedDate = simpleDateFormat.format(usuario.getFecha_alta());
            java.sql.Date date = java.sql.Date.valueOf(formattedDate);
            stmt.setDate(6, date);
            stmt.setDouble(7, usuario.getDinero_cuenta());
            stmt.setInt(8, usuario.getTelefono());
            stmt.setInt(9, usuario.getCod_postal());
            if(Pattern.matches("^([A-Za-z0-9+/]{4})*([A-Za-z0-9+/]{3}=|[A-Za-z0-9+/]{2}==)?$", usuario.getImagen_usuario())){
                stmt.setString(10, usuario.getImagen_usuario());
            
            
            }else{
                InputStream imagen = new FileInputStream(usuario.getImagen_usuario());
                stmt.setBlob(10, imagen);
            }
            
            stmt.setInt(11, usuario.getId_usuario());
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
    
    public int eliminar(Usuario usuario){
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
            stmt.setInt(1,usuario.getId_usuario());
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
