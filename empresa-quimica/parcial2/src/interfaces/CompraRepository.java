package interfaces;

import java.util.List;

import parcial2.Compra;
import parcial2.Producto;

public interface CompraRepository {

	int crearCompra(Compra compra);
	
	public Compra getCompraById(int id);
	
	 public List<Compra> getComprasByUsuarioId(int idUsuario);
	
}
