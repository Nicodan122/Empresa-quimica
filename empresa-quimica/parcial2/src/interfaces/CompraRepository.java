package interfaces;

import parcial2.Compra;
import parcial2.DetalleCompra;

import java.util.List;

public interface CompraRepository {
	 
	  // Método para realizar una nueva compra
    void realizarCompra(Compra compra);
    
    // Método para mostrar las compras realizadas por un cliente
    List<Compra> mostrarCompras(int idCliente);

    // Método para crear una compra en la base de datos
    Compra crearCompra(int idCliente);

    // Método para crear los detalles de una compra en la base de datos
    void crearDetallesCompra(int idCompra, List<DetalleCompra> detalles);
	
}
