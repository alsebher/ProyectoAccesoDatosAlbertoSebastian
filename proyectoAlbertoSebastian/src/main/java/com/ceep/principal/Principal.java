/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ceep.principal;

import dominio.Categoria;
import dominio.CategoriaDao;
import dominio.Compra;
import dominio.CompraDao;
import dominio.Marca;
import dominio.MarcaDao;
import dominio.Producto;
import dominio.ProductoDao;
import dominio.Reseña;
import dominio.ReseñaDao;
import dominio.Usuario;
import dominio.UsuarioDao;
import ficheros.Archivos;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alumno Mañana
 */
public class Principal {
    static Scanner ent = new Scanner(System.in);
    static UsuarioDao usuarioDao = new UsuarioDao();
    static ProductoDao productoDao = new ProductoDao();
    static MarcaDao marcaDao = new MarcaDao();
    static CategoriaDao categoriaDao = new CategoriaDao(); 
    static CompraDao compraDao = new CompraDao();
    static ReseñaDao reseñaDao = new ReseñaDao();
    static Date d1 = new Date();
    static Date d = sumarDia(d1,1);
    
    public static void main(String[] args) throws Exception {  
        
        /*Reseña r1 = new Reseña((float) 3.5,"Muy buen producto",2,5);
        Reseña r2 = new Reseña((float) 1.5,"Muy mal producto",3,7);
        Reseña r3 = new Reseña((float) 5.0,"Excelente",4,3);
        Compra co1 = new Compra(9.55,1400.45,d,4,10);
        Compra co2 = new Compra(4.55,10050.45,d,1,6);
        Compra co3 = new Compra(1.75,2000.07,d,2,2);
        reseñaDao.insertar(r1);
        reseñaDao.insertar(r2);
        reseñaDao.insertar(r3);
        compraDao.insertar(co1);
        compraDao.insertar(co2);
        compraDao.insertar(co3);*/
        
        /*
        Marca m1 = new Marca("Apple",23);
        Marca m2 = new Marca("Xiaomi",20);
        Marca m3 = new Marca("Razer",10);
        Marca m4 = new Marca("Logitech",30);
        Marca m5 = new Marca("Ozone",14);
        Marca m6 = new Marca("Nvidia",50);
        Marca m7 = new Marca("AMD",31);
        Marca m8 = new Marca("Samsung",20);
        Categoria c1 = new Categoria("Sobremesa",40);
        Categoria c2 = new Categoria("Portatiles",34);
        Categoria c3 = new Categoria("Auriculares",69);
        Categoria c4 = new Categoria("Monitores",40);
        Categoria c5 = new Categoria("Tarjetas",34);
        Categoria c6 = new Categoria("Teclados",69);
        Categoria c7 = new Categoria("Ratones",40);
        Categoria c8 = new Categoria("Tablets",34);
        Producto p1 = new Producto("MacBook",1350.37,15,0.25,true,"C://manga.png","Apple","Ordenadores");
        Producto p2 = new Producto("iPad",950.50,45,0,false,"C://manga.png","Apple","Tablets");
        Producto p3 = new Producto("Blackwidow",150.50,25,0.5,true,"C://manga.png","Razer","Teclados");
        Producto p4 = new Producto("Viper",99.95,25,0,false,"C://manga.png","Razer","Ratones");
        Producto p5 = new Producto("Void",50,5,0.63,true,"C://manga.png","Ozone","Auriculares");
        Producto p6 = new Producto("4090Ti",2999.99,80,0,false,"C://manga.png","Nvidia","Tarjetas");
        Producto p7 = new Producto("Radeon",599.99,20,0.45,true,"C://manga.png","AMD","Tarjetas");
        Producto p8 = new Producto("Vision",1999.99,4,0,false,"C://manga.png","Samsung","Monitores");
        Producto p9 = new Producto("Vengeance",5999.99,1,0,false,"C://manga.png","AMD","Sobremesa");
        Producto p10 = new Producto("Mate",699.99,10,0.1,true,"C://manga.png","Xiaomi","Portatiles");
        marcaDao.insertar(m1);
        marcaDao.insertar(m2);
        marcaDao.insertar(m3);
        marcaDao.insertar(m4);
        marcaDao.insertar(m5);
        marcaDao.insertar(m6);
        marcaDao.insertar(m7);
        marcaDao.insertar(m8);
        categoriaDao.insertar(c1);
        categoriaDao.insertar(c2);
        categoriaDao.insertar(c3);
        categoriaDao.insertar(c4);
        categoriaDao.insertar(c5);
        categoriaDao.insertar(c6);
        categoriaDao.insertar(c7);
        categoriaDao.insertar(c8);
        productoDao.insertar(p1);
        productoDao.insertar(p2);
        productoDao.insertar(p3);
        productoDao.insertar(p4);
        productoDao.insertar(p5);
        productoDao.insertar(p6);
        productoDao.insertar(p7);
        productoDao.insertar(p8);
        productoDao.insertar(p9);
        productoDao.insertar(p10);*/
        
        
               
        /*Usuario us1 = new Usuario("Alberto","Sebastian","c/Matilde Hernandez","alsebher@gmail.com","2345",d1,100.89,608506937,28019,"C:/xampp/htdocs/interfaz1/img/huawei.png");
        Usuario us2 = new Usuario(1,"Antonio","Roda","c/Faustino Osorio","rodamegia@gmail.com","1234",d1,400.89,601501931,28025,"C:/xampp/htdocs/interfaz1/img/p1.png");
        Usuario us3 = new Usuario("Lucas","Moura","c/Oca","lucas@gmail.com","1234",d1,600.89,601502222,28004,"C:/xampp/htdocs/interfaz1/img/p1.png");
        
        Producto p1 = new Producto("imac",35.37,15,0.25,true,"C:/xampp/htdocs/interfaz1/img/apple.png","Apple","Ordenadores");
        Producto p2 = new Producto(1,"imac",35.37,12,0,false,"C:/xampp/htdocs/interfaz1/img/apple.png","Apple","Ordenadores");
        Producto p3 = new Producto(2);
        Producto p4 = new Producto("Botas",50.37,154,0.6,true,"C:/xampp/htdocs/interfaz1/img/apple.png","Kalenji","Montaña");
        
        Compra co1 = new Compra(9.55,70.45,d1,2);
        Compra co2 = new Compra(1,4.55,50.45,d1,2);
        Compra co3 = new Compra(1.75,90.07,d1,2);
        
        
        Reseña r1 = new Reseña((float) 3.5,"Muy buen producto",2,2);
        Reseña r2 = new Reseña(1,(float) 1.5,"Muy mal producto",2,2);
        Reseña r3 = new Reseña((float) 5.0,"Excelente",1,2);*/
        
        //registrarUsuario();
        
        menu();
        
       
        /*
        try {
            
            //usuarioDao.insertar(us1);
            //usuarioDao.insertar(us3);
            //usuarioDao.actualizar(us2);
            //usuarioDao.eliminar(us2);
           
            //marcaDao.insertar(m1);
            //categoriaDao.insertar(c1);
            
            //productoDao.insertar(p1);
            //productoDao.insertar(p4);
            //productoDao.actualizar(p2);
            //productoDao.eliminar(p3);
            List<Producto> productos = productoDao.seleccionar();
            for(Producto p:productos){
                System.out.println(p.toString());
            }
            
            //compraDao.insertar(co1);
            //compraDao.insertar(co3);
            //compraDao.actualizar(co2);
            //compraDao.eliminar(co2);
            List<Compra> compras = compraDao.seleccionar();
            for(Compra c:compras){
                System.out.println(c.toString());
            }
            
            //reseñaDao.insertar(r1);
            //reseñaDao.insertar(r3);
            //reseñaDao.actualizar(r2);
            //reseñaDao.eliminar(r2);
            List<Reseña> reseñas = reseñaDao.seleccionar();
            for(Reseña r:reseñas){
                System.out.println(r.toString());
            }
            
            
            //marcaDao.insertar(m3);
            //marcaDao.actualizar(m2);
            //marcaDao.eliminar(m2);
            List<Marca> marcas = marcaDao.seleccionar();
            for(Marca m:marcas){
                System.out.println(m.toString());
            }
            
            //categoriaDao.insertar(c3);
            //categoriaDao.actualizar(c2);
            //categoriaDao.eliminar(c2);
            List<Categoria> categorias = categoriaDao.seleccionar();
            for(Categoria c:categorias){
                System.out.println(c.toString());
            }
            
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }*/
    }
    
    public static Date sumarDia(Date fecha, int dias){
       Calendar calendar = Calendar.getInstance();
       calendar.setTime(fecha); // Configuramos la fecha que se recibe
       calendar.add(Calendar.DAY_OF_YEAR, dias);  // numero de días a añadir, o restar en caso de días<0
       return calendar.getTime(); // Devuelve el objeto Date con los nuevos días añadidos	
    }
    
    //este método constituye el menú principal de la aplicación, desde el que se harán la inmensa mayoría de operaciones, incluido la redirección al menú usuarios
    public static void menu() throws SQLException, IOException, Exception{
        int opcion=-1;
	while(opcion!=0){
		System.out.println("");
                System.out.println("");
                System.out.println("");
		System.out.printf("\tPCCOMPONENTES\n");
		System.out.printf("========================================================================\n");
		System.out.printf("1.- Ver usuarios registrados en el sistema (Administrador)\n");
		System.out.printf("2.- Registrar un nuevo usuario \n");
		System.out.printf("3.- Iniciar sesión \n");
		System.out.printf("4.- Ver productos de la tienda\n");
                System.out.printf("5.- Buscar producto por nombre\n");
                System.out.printf("6.- Buscar productos pertenecientes a una categoría concreta\n");
                System.out.printf("7.- Buscar productos en función de un límite de precio\n");
                System.out.printf("8.- Buscar productos pertenecientes a una marca concreta\n");
                System.out.printf("9.- Buscar productos en oferta\n");
                System.out.printf("10.- Ver categorías de la tienda\n");
                System.out.printf("11.- Ver marcas de la tienda\n");
                System.out.printf("12.- Ver las reseñas de un producto\n");
                System.out.printf("13.- Modificar la cantidad de productos disponibles pertenecientes a una categoría (Administrador)\n");
                System.out.printf("14.- Modificar la cantidad de productos disponibles pertenecientes a una marca (Administrador)\n");
                System.out.printf("15.- Introducir una nueva categoría (Administrador)\n");
                System.out.printf("16.- Introducir una nueva marca (Administrador)\n");
		System.out.printf("0.- SALIR\n");
		System.out.println("\n\tSeleccione una de las siguientes opciones: ");
		opcion = ent.nextInt();
		switch(opcion){
			case 1:
				verUsuarios();
				break;
			case 2:
				registrarUsuario();
				
				break;
			case 3:
                                iniciarSesion();
				
				
				break;
			case 4:
                                verProductos();
                                
				break;
                        case 5:
                                buscarProductoPorNombre();
				break;
                        case 6:
                                buscarProductosPorCategoria();                           
				break;
                        case 7:
                                buscarProductosPorLimiteDePrecio();
				break;
                        case 8:
                                buscarProductosPorMarca();                           
				break;
                        case 9:
                                buscarProductosEnOferta();                           
				break;
                        case 10:
                                verCategorias();                           
				break;
                        case 11:
                                verMarcas();                           
				break;
                        case 12:
                                String productoBuscar;
                                System.out.println("Introduzca el nombre del producto cuyas reseñas desea observar:");
                                ent.nextLine();
                                productoBuscar = ent.nextLine();
                                verReseñas(productoBuscar);
				break;
                        case 13:
                                alterarCategoria();
                                break;
                        case 14:
                                alterarMarca();
                                break;
                        case 15:
                                nuevaCategoria();
                                break;
                        case 16:
                                nuevaMarca();
                                break;
			case 0:
                                System.out.println("Gracias por usar la aplicación");
				break;
			default:
				System.out.printf("\nElija entre 0 y 16\n\n");
				break;
		}
                ent.nextLine();
                ent.nextLine();
                
		
	}
    }
    
    //este método se encarga de codificar en MD5 cadenas de caracteres. Concretamente, yo lo aplico para codificar contraseñas y compararlas en distintos momentos. También se puede encontrar este mismo método en UsuarioDao
    public static String convertToMD5(String input) throws Exception {
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
    
    //este método es la implementación dinámica del método seleccionar de UsuarioDao, y también se encarga de actualizar el archivo usuarios.txt 
    public static void verUsuarios(){
        List<Usuario> usuarios;
        try {
            usuarios = usuarioDao.seleccionar();
            for(Usuario u:usuarios){
                System.out.println(u.toString());              
            }
            usuariosTexto();
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    //este método constituye una interacción con archivos de texto, ya que al ejecutarse graba en un archivo de texto usuarios.txt los datos de tusuarios en el momento, separados por |
    public static void usuariosTexto(){
        Archivos.crearArchivo("usuarios.txt");
        List<Usuario> usuarios;
        try {
            usuarios = usuarioDao.seleccionar();
            for(Usuario u:usuarios){
                Archivos.agregarArchivo("usuarios.txt", u.getId_usuario()+"|"+u.getNombre_usuario()+"|"+u.getApe_usuario()+"|"+u.getDireccion()+"|"+u.getCorreo()+"|"+u.getContrasenya()+"|"+u.getDinero_cuenta()+"|"+u.getTelefono()+"|"+u.getCod_postal()+"|"+u.getFecha_alta()+"\n");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //este método es la implementación del método insertar de UsuarioDao, de tal manera que el usuario de mi aplicación puede crear e insertar un objeto usuario registrándose como se hace en cualquier ecommerce habitual. Obviamente, si la cuenta que quiere registrar ya existe, se le notificará y no podrá continuar
    public static void registrarUsuario() throws Exception{
        try {
            List<Usuario> usuarios = usuarioDao.seleccionar();
            String nombre;
            String apellido;
            String direccion;
            String correo;
            String contrasenya;
            double dinero;
            int telefono;
            int cod_postal;
            String imagen;
            System.out.println("Introduzca el correo:");
            ent.nextLine();
            correo = ent.nextLine();
            for(Usuario u:usuarios){
                if(u.getCorreo().equalsIgnoreCase(correo)){
                    System.out.println("Ya existe un usuario con ese correo, cámbielo:");
                    correo = ent.nextLine();
                }
            }
            System.out.println("Introduzca el nombre del nuevo usuario:");
            nombre = ent.nextLine();
            System.out.println("Introduzca el apellido:");
            apellido = ent.nextLine();
            System.out.println("Introduzca la dirección:");
            direccion = ent.nextLine();          
            System.out.println("Introduzca la contraseña:");
            contrasenya = ent.nextLine();
            System.out.println("Introduzca el dinero que tiene en la cuenta:");
            dinero = ent.nextDouble();
            System.out.println("Introduzca el número de teléfono:");
            telefono = ent.nextInt();
            System.out.println("Introduzca el código postal:");
            cod_postal = ent.nextInt();
            System.out.println("Introduzca la ruta de la imagen de perfil:");
            ent.nextLine();
            imagen = ent.nextLine();
            Usuario us = new Usuario(nombre,apellido,direccion,correo,contrasenya,d,dinero,telefono,cod_postal,imagen);
            usuarioDao.insertar(us);
            usuariosTexto();
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    //este método menú es la implementacion de los métodos actualizar y eliminar de usuarioDao, y se presenta como si un usuario accediese a los datos de su cuenta trs iniciar sesión. Recibe como parámetro el objeto usuario al que se ha iniciado sesión, tras introducir correctamente su contraseña en el método iniciarSesion()
    public static void menuUsuarios(Usuario u) throws SQLException, IOException, Exception{
        int opcion=-1;
	while(opcion!=0){
		System.out.println("");
                System.out.println("");
                System.out.println("");
		System.out.printf("========================================================================\n");
                System.out.println(u.toString());
                System.out.printf("\t¿QUÉ DATOS DE SU USUARIO DESEA MODIFICAR?\n");
		System.out.printf("========================================================================\n");
		System.out.printf("1.- Nombre\n");
		System.out.printf("2.- Apellido \n");
		System.out.printf("3.- Dirección \n");
		System.out.printf("4.- Contraseña \n");
                System.out.printf("5.- Dinero en la cartera electrónica \n");
                System.out.printf("6.- Teléfono \n");
                System.out.printf("7.- Código postal \n");
                System.out.printf("8.- Imagen de perfil \n");
                System.out.printf("9.- Compras en curso \n");
                System.out.printf("10.- Hacer una nueva compra \n");
                System.out.printf("11.- ELIMINAR CUENTA \n");
		System.out.printf("0.- CERRAR SESIÓN\n");
		System.out.println("\n\tSeleccione una de las siguientes opciones: ");
		opcion = ent.nextInt();
		switch(opcion){
			case 1:
				String nombreNuevo;
                                System.out.println("Introduzca el nuevo nombre : ");
                                ent.nextLine();
                                nombreNuevo = ent.nextLine();
                                u.setNombre_usuario(nombreNuevo);
                                usuarioDao.actualizar(u);
                                usuariosTexto();
				break;
			case 2:
				String apellidoNuevo;
                                System.out.println("Introduzca el nuevo apellido : ");
                                ent.nextLine();
                                apellidoNuevo = ent.nextLine();
                                u.setApe_usuario(apellidoNuevo);
                                usuarioDao.actualizar(u);
                                usuariosTexto();
				break;
				
				
			case 3:
				String direcNueva;
                                System.out.println("Introduzca su nueva dirección : ");
                                ent.nextLine();
                                direcNueva = ent.nextLine();
                                u.setDireccion(direcNueva);
                                usuarioDao.actualizar(u);
                                usuariosTexto();
				
				break;
			case 4:
				String contraNueva;
                                System.out.println("Introduzca su nueva contraseña : ");
                                ent.nextLine();
                                contraNueva = ent.nextLine();
                                u.setContrasenya(convertToMD5(contraNueva));
                                usuarioDao.actualizar(u);
                                usuariosTexto();
                                
				break;
                        case 5:
				double dineroNuevo;
                                System.out.println("Introduzca su saldo actual : ");
                                dineroNuevo = ent.nextDouble();
                                u.setDinero_cuenta(dineroNuevo);
                                usuarioDao.actualizar(u);
                                usuariosTexto();
                                
				break;
                        case 6:
				int telfNuevo;
                                System.out.println("Introduzca su nuevo teléfono : ");
                                telfNuevo = ent.nextInt();
                                u.setTelefono(telfNuevo);
                                usuarioDao.actualizar(u);
                                usuariosTexto();
                                
				break;
                        case 7:
				int postalNuevo;
                                System.out.println("Introduzca su nuevo código postal : ");
                                postalNuevo = ent.nextInt();
                                u.setTelefono(postalNuevo);
                                usuarioDao.actualizar(u);
                                usuariosTexto();
                                
				break;
                        case 8:
				String imgNueva;
                                System.out.println("Introduzca la ruta de su nueva foto de perfil : ");
                                ent.nextLine();
                                imgNueva = ent.nextLine();
                                u.setImagen_usuario(imgNueva);
                                usuarioDao.actualizar(u);
                                
                                
				break;
                        case 9:
                                verCompras(u);
                                break;
                        case 10:
                                nuevaCompra(u);
                                break;
                        case 11:
                                String confirmar;
                                System.out.println("¿Está seguro de querer eliminar el archivo?(Y/n):");
                                ent.nextLine();
                                confirmar = ent.nextLine();
                                if(confirmar.equalsIgnoreCase("Y")){
                                    eliminarCompras(u);
                                    usuarioDao.eliminar(u);
                                    usuariosTexto();
                                    opcion=0;
                                }                              
                                break;
			case 0:
                                
				break;
			default:
				System.out.printf("\nElija entre 0 y 11\n\n");
				break;
		}
                ent.nextLine();
                ent.nextLine();
                
		
	}
    }
    
    //este método actua como un inicio de sesión habitual, el usuario ha de meter un correo válido y su contraseña asociada correctamenmte para poder acceder. Cumplido esto, llama al menú de datos de dicho usuario
    public static void iniciarSesion() throws SQLException, IOException, Exception{
        List<Usuario> usuarios = usuarioDao.seleccionar();
        String correo;
        String contrasenya;
        char sw = 'n';
        System.out.println("\tINICIAR SESIÓN");
        System.out.println("Introduzca su correo electrónico: ");
        ent.nextLine();
        correo = ent.nextLine();
        for(Usuario u:usuarios){
            if(u.getCorreo().equals(correo)){
                sw = 's';
                System.out.println("Introduzca la contraseña: ");
                contrasenya = ent.nextLine();
                if(convertToMD5(contrasenya).equals(u.getContrasenya())){
                    System.out.println("Contraseña aceptada, sesión iniciada con éxito");
                    menuUsuarios(u);
                }else{
                    System.out.println("Contraseña incorrecta");
                }
            }
        }
        if(sw == 'n'){
            System.out.println("Correo no encontrado");
        }
       
        
    }
    
    //este método es un buscador común de productos de una tienda, el usuario introduce el nombre del producto que desea buscar y este muestra los datos de dicho objeto por pantalla
    public static void buscarProductoPorNombre() throws SQLException, IOException{
        List<Producto> productos = productoDao.seleccionar();
        String nombre;
        String res = "El producto introducido no existe";
        System.out.println("Introduzca el nombre del producto a buscar:");
        ent.nextLine();
        nombre = ent.nextLine();
        for(Producto p:productos){
            if(p.getNombre_producto().equalsIgnoreCase(nombre)){
                System.out.println(p.toString());
                res = "";
            }
        }
        System.out.println(res);
        
    }
    
    //este método es también un buscador de productos, pero esta vez con un filtro que se encarga de mostrar únicamente los productos pertenecientes a la categoría especificada por el usuario
    public static void buscarProductosPorCategoria() throws SQLException, IOException{
        List<Producto> productos = productoDao.seleccionar();
        String cate;
        String res = "No hay productos pertenecientes a esa categoría";
        System.out.println("Introduzca la categoria de los producto a buscar:");
        ent.nextLine();
        cate = ent.nextLine();
        for(Producto p:productos){
            if(p.getNombre_categoria().equalsIgnoreCase(cate)){
                System.out.println(p.toString());
                res = "";
            }
        }
        System.out.println(res);
        
    }
    
    //este método busca y muestra únicamente los productos con un precio igual o inferior al límite especificado por el usuario
    public static void buscarProductosPorLimiteDePrecio() throws SQLException, IOException{
        List<Producto> productos = productoDao.seleccionar();
        double limite;
        String res = "No hay productos en ese rango de precio";
        System.out.println("Introduzca límite de precio de los producto a buscar:");
        limite = ent.nextDouble();
        for(Producto p:productos){
            if(p.getPrecio()<=limite){
                System.out.println(p.toString());
                res = "";
            }
        }
        System.out.println(res);
        
    }
    
    //este método busca y muestra únicamente los productos pertenecientes a la marca especificada por el usuario
    public static void buscarProductosPorMarca() throws SQLException, IOException{
        List<Producto> productos = productoDao.seleccionar();
        String marca;
        String res = "No hay productos pertenecientes a esa marca";
        System.out.println("Introduzca la marca de los producto a buscar:");
        ent.nextLine();
        marca = ent.nextLine();
        for(Producto p:productos){
            if(p.getNombre_marca().equalsIgnoreCase(marca)){
                System.out.println(p.toString());
                res = "";
            }
        }
        System.out.println(res);
        
    }
    
    //este método busca y muestra únicamente los productos que se encuentran en oferta
    public static void buscarProductosEnOferta() throws SQLException, IOException{
        List<Producto> productos = productoDao.seleccionar();
        String res = "Lamentablemente, no hay productos en oferta en estos momentos";
        for(Producto p:productos){
            if(p.isExistencia_oferta() == true){
                System.out.println(p.toString());
                res = "";
            }
        }
        System.out.println(res);
        
    }
    
    //este método es la implementación del método seleccionar de ProductoDao
    public static void verProductos(){
        List<Producto> productos;
        try {
            productos = productoDao.seleccionar();
            for(Producto p:productos){
                System.out.println(p.toString());              
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    //este método es la implementación del método seleccionar de MarcaDao
    public static void verMarcas(){
        List<Marca> marcas;
        try {
            marcas = marcaDao.seleccionar();
            for(Marca m:marcas){
                System.out.println(m.toString());              
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    //este método es la implementación del método seleccionar de CategoriaDao
    public static void verCategorias(){
        List<Categoria> categorias;
        try {
            categorias = categoriaDao.seleccionar();
            for(Categoria c:categorias){
                System.out.println(c.toString());              
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    //este método es la implementación del método seleccionar de CompraDao, el cual se apilca desde la cuenta de un usuario concreto para ver las compras que tiene en el carrito dicho usuario
    public static void verCompras(Usuario u){
        List<Compra> compras;
        String res = "No hay ninguna compra en curso en estos momentos";
        try {
            compras = compraDao.seleccionar();
            for(Compra co:compras){
                if(co.getId_usuario() == u.getId_usuario()){
                    System.out.println(co.toString());
                    res = "";
                }
                             
            }
            System.out.println(res);
           
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    //este método es la implementación del método seleccionar de ReseñaDao, el cual será aplicado para ver las reseñas existentes de un producto concreto
    public static void verReseñas(String prod){
        List<Reseña> reseñas;
        List<Producto> productos;
        String res = "No hay ninguna reseña para el producto introducido";
        int idp;
        try {
            reseñas = reseñaDao.seleccionar();
            productos = productoDao.seleccionar();
            for(Producto p:productos){
                if(p.getNombre_producto().equalsIgnoreCase(prod)){
                    idp = p.getId_producto();
                    for(Reseña r:reseñas){
                        if(r.getId_producto() == idp){
                            System.out.println(r.toString());
                            res = "";
                        }
                    }
                }
            }
            System.out.println(res);
            
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    //este método sirve para que el administrador pueda cambiar el número de productos de una categoría haciendo uso del método actualizar de CategoriaDao
    public static void alterarCategoria(){
        List<Categoria> categorias;
        String cate;
        String res = "No hay ninguna categoría con ese nombre";
        int num;
        System.out.println("Introduzca el nombre de la categoria cuyo número de productos disponibles desea alterar:");
        ent.nextLine();
        cate = ent.nextLine();
        try {
            categorias = categoriaDao.seleccionar();
            for(Categoria c:categorias){
               if(c.getNombre_categoria().equalsIgnoreCase(cate)){
                   System.out.println("Introduzca la nueva cantidad de productos de la categoría:");
                   num = ent.nextInt();
                   c.setProductos_categoria(num);
                   categoriaDao.actualizar(c);
                   res = "";
               }             
            }
            System.out.println(res);
            
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    //este método sirve para que el administrador pueda cambiar el número de productos de una marca haciendo uso del método actualizar de MarcaDao
    public static void alterarMarca(){
        List<Marca> marcas;
        String marc;
        String res = "No hay ninguna marca con ese nombre";
        int num;
        System.out.println("Introduzca el nombre de la marca cuyo número de productos disponibles desea alterar:");
        ent.nextLine();
        marc = ent.nextLine();
        try {
            marcas = marcaDao.seleccionar();
            for(Marca m:marcas){
               if(m.getNombre_marca().equalsIgnoreCase(marc)){
                   System.out.println("Introduzca la nueva cantidad de productos de la marca:");
                   num = ent.nextInt();
                   m.setProductos_marca(num);
                   marcaDao.actualizar(m);
                   res = "";
               }             
            }
            System.out.println(res);
            
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    //este método implementa el método insertar de categoriaDao para que el admin pueda introducir nuevas categorías
    public static void nuevaCategoria(){
        String nuevaCate;
        System.out.println("Introduzca el nombre de la categoría a introducir:");
        ent.nextLine();
        nuevaCate = ent.nextLine();
        Categoria c = new Categoria(nuevaCate,0);
        categoriaDao.insertar(c);
        System.out.println("Se ha introducido la categoría con éxito");
    }
    
    //este método implementa el método insertar de marcaDao para que el admin pueda introducir nuevas marcas
    public static void nuevaMarca(){
        String nuevaMarc;
        System.out.println("Introduzca el nombre de la marca a introducir:");
        ent.nextLine();
        nuevaMarc = ent.nextLine();
        Marca m = new Marca(nuevaMarc,0);
        marcaDao.insertar(m);
        System.out.println("Se ha introducido la marca con éxito");
    }
    
    //este método implementa el método insertar de compraDao para que un usuario pueda hacer compras desde su cuenta. Establezco 5,75 euros como el estándar de gastos de envío.
    public static void nuevaCompra(Usuario u){
        List<Producto> productos;
        double importe;
        String productoCompra;
        String res = "El producto que desea comprar no existe";
        System.out.println("Introduzca el nombre del producto que desea comprar");
        ent.nextLine();
        productoCompra = ent.nextLine();
        try {
            productos = productoDao.seleccionar();
            for(Producto p:productos){
                if(p.getNombre_producto().equalsIgnoreCase(productoCompra)){
                    Compra c = new Compra(5.75,p.getPrecio(),d,u.getId_usuario(),p.getId_producto());
                    compraDao.insertar(c);
                    System.out.println("Se ha introducido la compra a su carrito");
                    res = "";
                }
            }
            System.out.println(res);
           
            
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //este método implementa el método eliminar de compraDao para que cuando un usuario elimine su cuenta, se eliminen sus compras en curso del carrito
    public static void eliminarCompras(Usuario u){
        List<Compra> compras;
        try {
            compras = compraDao.seleccionar();
            for(Compra co:compras){
                if(co.getId_usuario() == u.getId_usuario()){
                    compraDao.eliminar(co);                   
                }
                             
            }           
           
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    //ALBERTO SEBASTIÁN HERNÁNDEZ
    
    
}
