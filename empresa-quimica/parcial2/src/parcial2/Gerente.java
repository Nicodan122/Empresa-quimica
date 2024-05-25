package parcial2;

import javax.swing.JOptionPane;
import controlador.UsuarioControlador;
import parcial2.Usuario;

public class Gerente extends Usuario {
	private int idGerente;

	public Gerente(String nombre, String contra, int idUsuario, int idGerente) {
		super(nombre, contra, idUsuario);
		this.idGerente = idGerente;
	}

	public int getIdGerente() {
		return idGerente;
	}

	public void setIdGerente(int idGerente) {
		this.idGerente = idGerente;
	}
	
	  public void agregarProductoManualmente() {
		  
	        // Ingresar los datos del producto 
		    int idProducto = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id:"));
	        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del producto:");
	        double precio = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio del producto:"));
	        String descripcion = JOptionPane.showInputDialog("Ingrese la descripción del producto:");
	        int nivel = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nivel del producto:"));
	        int stock = Integer.parseInt(JOptionPane.showInputDialog("Cantidad de productos:"));
     
	        // Crear un nuevo producto
	        Producto nuevoProducto = new Producto(idProducto, nombre, precio, descripcion, nivel, stock);

	        // Agregar el nuevo producto a la lista de productos
	        Producto.agregarProducto(nuevoProducto);

	        // Mostrar un mensaje de confirmación
	        JOptionPane.showMessageDialog(null, "Producto agregado exitosamente.");
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
        	  Producto.verProductos();
              break;
          case 1:
        	  agregarProductoManualmente();
        	  Producto.verProductos();
              break;
          case 2:
        	  Ventas.registrarVenta();
        	  Ventas.verVentas();
              break;
          case 3:
        	  Ventas.verVentas();
        	  break;
          case 4:
        	  String nombre = JOptionPane.showInputDialog("Ingrese nombre");
  			  String contra = JOptionPane.showInputDialog("Ingrese contra");
  			  controlar.addUser(new Usuario(nombre,contra));		
  			break;
          case 5:
        	  Usuario encontrado = BuscarUsuario(controlar);
  			  String nuevoNombre = JOptionPane.showInputDialog("Ingrese el nuevo nombre de : " + encontrado.getNombre());
  			  String nuevoContra = JOptionPane.showInputDialog("Ingrese el nuevo email de : " + encontrado.getContra());
  			  encontrado.setContra(nuevoContra);
  			  encontrado.setNombre(nuevoNombre);
  			  controlar.updateUser(encontrado);
  			  break;
          case 6:

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
