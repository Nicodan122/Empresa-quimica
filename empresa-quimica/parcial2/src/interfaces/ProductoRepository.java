package interfaces;

import java.util.List;

import parcial2.Producto;

public interface ProductoRepository {
	
	//protoripos de metodos
		List<Producto> getAllProducts();
		
		Producto getProductById(int id);
		
		void addProduct(Producto producto);
		
		boolean upDateProduct(Producto producto);
		
		public Producto getProductByIdB(int id);
		
		void deleteProduct(int id);
		
	    void actualizarStockProducto(int idProducto, int nuevoStock);

}
