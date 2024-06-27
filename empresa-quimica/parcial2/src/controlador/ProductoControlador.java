package controlador;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import interfaces.ProductoRepository;
import parcial2.Producto;


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
				resultSet.getInt("stock"),
				resultSet.getBytes("imagen")           //Fijarme si el getByte que puse es el correcto elegi el de String en vez de int.
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
			PreparedStatement statement = connection.prepareStatement("INSERT INTO productos (nombre, precio, descripcion, nivel, stock, imagen) VALUES (?, ?, ?, ?, ?, ?)");
			statement.setString(1, producto.getNombre());
			statement.setDouble(2, producto.getPrecio());
			statement.setString(3, producto.getDescripcion());
			statement.setInt(4, producto.getNivel());
			statement.setInt(5, producto.getStock());
			statement.setBytes(6, producto.getImagen()); //Fijarme si el setBytes esta bien
			
			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("Producto Creado Exitosamente.");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean upDateProduct(Producto producto) {

		try {
			PreparedStatement statement = connection.prepareStatement("UPDATE productos SET nombre=?, precio=?, descripcion=?, nivel=?, stock=?, imagen=? WHERE idProducto = ?");
			statement.setString(1, producto.getNombre());
			statement.setDouble(2, producto.getPrecio());
			statement.setString(3, producto.getDescripcion());
			statement.setInt(4, producto.getNivel());
			statement.setInt(5, producto.getStock());
			statement.setBytes(6, producto.getImagen());
			 statement.setInt(7, producto.getIdProducto());
			//Puede ser que vaya getIdPrODUCTO, LO VI EN LA RAMA DE GAMALIEL
					
			int rowsUpdated = statement.executeUpdate();
			if (rowsUpdated > 0) {
				System.out.println("Producto Actualizado Exitosamente.");
				return true;
			}
			return false;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
		
	}

	
	@Override
	public Producto getProductById(int id) {
		Producto producto = null;
		try {
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM productos WHERE idProducto = ?");
			statement.setInt(1, id);
			
			ResultSet resultSet = statement.executeQuery();
			
			if (resultSet.next()) {
				 producto = new Producto(resultSet.getInt("idProducto"),
						 resultSet.getString("nombre"),
						 resultSet.getDouble("precio"),
						 resultSet.getString("descripcion"),
						 resultSet.getInt("nivel"),
						 resultSet.getInt("stock"),
						 resultSet.getBytes("imagen"));
						 
				
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return producto;
		
	}
	
	@Override
	public Producto getProductByIdB(int id) {
		Producto producto = null;
		try {
			PreparedStatement statement = connection.prepareStatement("SELECT idProducto, nombre, precio, descripcion, stock, imagen WHERE idProducto = ?");
			statement.setInt(1, id);
			
			ResultSet resultSet = statement.executeQuery();
			
			if (resultSet.next()) {
				 producto = new Producto(resultSet.getInt("idProducto"),
						 resultSet.getString("nombre"),
						 resultSet.getDouble("precio"),
						 resultSet.getString("descripcion"),
						 resultSet.getInt("stock"),
						 resultSet.getBytes("imagen"));
						 
				
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return producto;
		
	}

	@Override
	public void deleteProduct(int id) {
		
		try {
			PreparedStatement statement = connection.prepareStatement("DELETE FROM productos WHERE idProducto =?");
			statement.setInt(1, id);
			
			int rowsDeleted = statement.executeUpdate();
			if (rowsDeleted > 0) {
				System.out.println("Producto Eliminado Exitosamente");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void actualizarStockProducto(int idProducto, int nuevoStock) {
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE productos SET stock = ? WHERE idProducto = ?");
            statement.setInt(1, nuevoStock);
            statement.setInt(2, idProducto);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

	
	
	
}
