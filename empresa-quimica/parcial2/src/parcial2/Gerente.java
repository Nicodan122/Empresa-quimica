package parcial2;

import javax.swing.JOptionPane;

class Gerente extends Usuario {
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
	        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del producto:");
	        double precio = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio del producto:"));
	        String descripcion = JOptionPane.showInputDialog("Ingrese la descripción del producto:");
	        int nivel = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nivel del producto:"));
	        int stock = Integer.parseInt(JOptionPane.showInputDialog("Cantidad de productos:"));
     
	        // Crear un nuevo producto
	        Producto nuevoProducto = new Producto(nombre, precio, descripcion, nivel, stock);

	        // Agregar el nuevo producto a la lista de productos
	        Producto.agregarProducto(nuevoProducto);

	        // Mostrar un mensaje de confirmación
	        JOptionPane.showMessageDialog(null, "Producto agregado exitosamente.");
	    }
	
	public void mostrarMenu(){
		String[] opciones = {"Ver Productos","Crear producto","Cargar Venta","Ver Ventas","Salir"};
		
		int eleccion = JOptionPane.showOptionDialog(
				null,"Seleccione una opción", "Menú Cliente", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,null,opciones,opciones[0]
				);
		
		  switch (eleccion) {
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
              System.exit(0);
              break;
        	  
          default:
              JOptionPane.showMessageDialog(null, "Opción no válida");
      }
		  
	}
	
	
}
