package interfaces;

import java.util.List;

import parcial2.Producto;

public interface ProductoRepository {
	
	//protoripos de metodos
		List<Producto> getAllProducts();
		
		//Producto getProductById(int id);
		
		void addProduct(Producto producto);
		
		//void updateProduct(Producto producto);
		
		//void deleteProduct(int id);

}