package parcial2;

import javax.swing.JOptionPane;

public class Empleado{
	
	public void mostrarMenu(){
		String[] opciones = {"Ver Productos","Registrar venta","Salir"};
		
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
        	  Ventas.registrarVenta();
        	  Ventas.verVentas();
              break;
          case 2:
        	  System.exit(0);
              break;
          default:
              JOptionPane.showMessageDialog(null, "Opción no válida");
      }
		  
		} while (opcion!=2);
		  
	}
	
	
	
	

}
