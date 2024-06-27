package interfaces;

import java.util.List;

import parcial2.CompraDetalle;

public interface CompraDetalleRepository {
	
	void agregarDetalle(CompraDetalle detalle);
	
	public List<CompraDetalle> getDetallesByCompraId(int idCompra);
}
