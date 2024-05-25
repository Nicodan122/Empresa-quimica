package parcial2;

import javax.swing.JOptionPane;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Usuario {
	private int idCliente;
	private List<Compra> comprasRealizadas;

	public Cliente(String nombre, String contra, int idUsuario, int idCliente) {
		super(nombre, contra, idUsuario);
		this.idCliente = idCliente;
		this.comprasRealizadas = new ArrayList<>();
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	
	public List<Compra> getComprasRealizadas() {
        return comprasRealizadas;
    }
	
	

    public void agregarCompra(Compra compra) {
        comprasRealizadas.add(compra);
    }
    
    public void mostrarCompras() {
        StringBuilder mensaje = new StringBuilder("Lista de compras realizadas:\n");
        for (Compra compra : comprasRealizadas) {
            mensaje.append("Producto: ").append(compra.getProductoComprado().getNombre()).append(", ")
                   .append("Cantidad: ").append(compra.getCantidad()).append(", ")
                   .append("Precio Total: ").append(compra.getPrecioTotal()).append("\n");
        }
        JOptionPane.showMessageDialog(null, mensaje.toString());
    }
	
	public void mostrarMenu(){
		String[] opciones = {"Ver Productos","Comprar Producto","Salir"};
		int opcion=0;
		
		do {
		
		 opcion = JOptionPane.showOptionDialog(
				null,"Seleccione una opción", "Menú Cliente", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,null,opciones,opciones[0]
				);
		
		  switch (opcion) {
          case 0:
              Producto.verProductos();
              break;
          case 1:
              Compra.realizarCompra(this);
              mostrarCompras();
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
