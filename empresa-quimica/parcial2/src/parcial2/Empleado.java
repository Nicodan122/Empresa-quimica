package parcial2;

import javax.swing.JOptionPane;

class Empleado extends Usuario{
	private int idEmpleado;

	public Empleado(String nombre, String contra, int idUsuario, int idEmpleado) {
		super(nombre, contra, idUsuario);
		this.idEmpleado = idEmpleado;
	}

	public int getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}
	
	public void mostrarMenu(){
		String[] opciones = {"Ver Productos","Comprar Producto","Salir"};
		
		int eleccion = JOptionPane.showOptionDialog(
				null,"Seleccione una opción", "Menú Cliente", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,null,opciones,opciones[0]
				);
		
		  switch (eleccion) {
          case 0:
        	  Producto.verProductos();
              break;
          case 1:
        	  Ventas.registrarVenta();
        	  Ventas.verVentas();
              break;
          case 2:
        	  System.exit(0);
              break;
          default:
              JOptionPane.showMessageDialog(null, "Opción no válida");
      }
		  
	}
	
	
	
	

}
