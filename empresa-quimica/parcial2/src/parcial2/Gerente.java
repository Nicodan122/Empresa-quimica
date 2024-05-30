package parcial2;

import java.util.List;

import javax.swing.JOptionPane;

import controlador.ProductoControlador;
import controlador.UsuarioControlador;
import parcial2.Usuario;

public class Gerente {
	private ProductoControlador productoControlador;
	
	  public Gerente(ProductoControlador productoControlador) {
		this.productoControlador = productoControlador;
	}

	public void agregarProductoManualmente() {
			try {
	        // Ingresar los datos del producto 
		    int idProducto = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id:"));
	        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del producto:");
	        double precio = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio del producto:"));
	        String descripcion = JOptionPane.showInputDialog("Ingrese la descripción del producto:");
	        int nivel = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nivel del producto:"));
	        int stock = Integer.parseInt(JOptionPane.showInputDialog("Cantidad de productos:"));
     
	        // Crear un nuevo producto
	        Producto nuevoProducto = new Producto(idProducto, nombre, precio, descripcion, nivel, stock);
	        productoControlador.addProduct(nuevoProducto);
	        
	        JOptionPane.showMessageDialog(null, "Producto agregado exitosamente.");
			} catch (NumberFormatException e) {
	            JOptionPane.showMessageDialog(null, "Error: Por favor, ingrese valores válidos.");
	        }
	    }
	  
	  public void mostrarProductos() {
	        List<Producto> productos = productoControlador.getAllProducts();
	        StringBuilder mensaje = new StringBuilder("Productos:\n");
	        for (Producto producto : productos) {
	            mensaje.append("ID: ").append(producto.getIdProducto())
	                    .append(", Nombre: ").append(producto.getNombre())
	                    .append(", Precio: ").append(producto.getPrecio())
	                    .append(", Descripción: ").append(producto.getDescripcion())
	                    .append(", Nivel: ").append(producto.getNivel())
	                    .append(", Stock: ").append(producto.getStock())
	                    .append("\n");
	        }
	        JOptionPane.showMessageDialog(null, mensaje.toString());
	    }
	  
	
	public void mostrarMenu(){
		String[] opciones = {"Ver Productos","Crear producto","Cargar Venta","Ver Ventas","Agregar Usuario","Editar usuario","Eliminar usuario","Salir"};
		
		UsuarioControlador controlar = new UsuarioControlador();
		
		int opcion = 0;
		
		do {
		
		opcion = JOptionPane.showOptionDialog(
				null,"Seleccione una opción", "Menú Cliente", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,null,opciones,opciones[0]
				);
		
		  switch (opcion) {
          case 0:
        	  mostrarProductos();
              break;
          case 1:
        	  agregarProductoManualmente();
        	  mostrarProductos();
              break;
          case 2:
        	  Ventas.registrarVenta();
        	  Ventas.verVentas();
              break;
          case 3:
        	  Ventas.verVentas();
        	  break;
          case 4:
        	  //Agregar USUARIO
        	  String nombre = JOptionPane.showInputDialog("Ingrese nombre");
  			  String contra = JOptionPane.showInputDialog("Ingrese contra");
  			  String rol = JOptionPane.showInputDialog("Ingresar rol");
  			  controlar.addUser(new Usuario(nombre,contra,rol));		
  			break;
          case 5:
        	  //Editar
        	  Usuario encontrado = BuscarUsuario(controlar);
  			  String nuevoNombre = JOptionPane.showInputDialog("Ingrese el nuevo nombre de : " + encontrado.getNombre());
  			  String nuevoContra = JOptionPane.showInputDialog("Ingrese el nuevo contra de : " + encontrado.getContra());
  			  String nuevoRol = JOptionPane.showInputDialog("Ingresar el nuevo rol de:" + encontrado.getRol());
  			  encontrado.setNombre(nuevoNombre);
  			  encontrado.setContra(nuevoContra);
  			  encontrado.setRol(nuevoRol);
  			  controlar.updateUser(encontrado);
  			  break;
          case 6:
        	   Usuario eliminar = BuscarUsuario(controlar);
  			   controlar.deleteUser(eliminar.getIdUsuario());
  			break;
          case 7:
              System.exit(0);
              break;
        	  
          default:
              JOptionPane.showMessageDialog(null, "Opción no válida");
      }
		  
		} while (opcion !=4 );
		  
	}

	
	public static Usuario BuscarUsuario(UsuarioControlador controlar) {
		String[] listaUsuarios = new String[controlar.getAllUsers().size()];
		
		
		for (int i = 0; i < listaUsuarios.length; i++) {
			listaUsuarios[i] = Integer.toString(controlar.getAllUsers().get(i).getIdUsuario());
		}
		String elegido =(String) JOptionPane.showInputDialog(null, "Elija un id", null, 0, null, listaUsuarios, listaUsuarios[0]);
		
		Usuario nuevo = controlar.getUserById(Integer.parseInt(elegido));
		return nuevo;
	}
	
}
