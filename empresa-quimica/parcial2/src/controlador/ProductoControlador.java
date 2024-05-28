package controlador;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import interfaces.ProductoRepository;
import parcial2.Producto;
import parcial2.Usuario;

public class ProductoControlador implements ProductoRepository  {
	private final Connection connection;
	
	public ProductoControlador() {
		this.connection = DatabaseConnection.getInstance().getConnection();
	}
	
	@Override
	public List<Producto> getAllProducts() {
		List<Producto> product = new ArrayList<>();
		try {
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM productos ");
			ResultSet resultSet = statement.executeQuery();
			
			while (resultSet.next()) {
				Producto producto = new Producto(resultSet.getInt("idProducto"),
				resultSet.getString("nombre"),
				resultSet.getDouble("precio"),
				resultSet.getString("descripcion"),
				resultSet.getInt("nivel"),
				resultSet.getInt("stock")
				);
				product.add(producto);
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return product;
	}
	
	@Override
	public void addProduct(Producto producto) {
		try {
			PreparedStatement statement = connection.prepareStatement("INSERT INTO productos (nombre, precio, descripcion, nivel, stock) VALUES (?, ?, ?, ?, ?)");
			statement.setString(1, producto.getNombre());
			statement.setDouble(2, producto.getPrecio());
			statement.setString(3, producto.getDescripcion());
			statement.setInt(4, producto.getNivel());
			statement.setInt(5, producto.getStock());
			
			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("Producto Creado Exitosamente.");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
