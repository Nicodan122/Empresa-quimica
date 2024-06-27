package controlador;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;


import interfaces.CompraRepository;
import parcial2.Compra;
import parcial2.Producto;

public class ControladorCompra implements  CompraRepository{
	private final Connection connection;
	
	public ControladorCompra() {
        this.connection = DatabaseConnection.getInstance().getConnection();
    }

	@Override
    public int crearCompra(Compra compra) {
        int idCompra = -1;
        try {
            String sql = "INSERT INTO compra (idUsuario) VALUES (?)";
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, compra.getIdUsuario());
            statement.executeUpdate();

            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                idCompra = generatedKeys.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return idCompra;
    }
	
	@Override
	public Compra getCompraById(int id) {
		Compra compra  = null;
		try {
			PreparedStatement statement = connection.prepareStatement("SELECT idCompra, idUsuario FROM compra WHERE idCompra = ?");
			statement.setInt(1, id);
			
			ResultSet resultSet = statement.executeQuery();
			
			if (resultSet.next()) {
				compra = new Compra(
						resultSet.getInt("idCompra"),
						resultSet.getInt("idUsuario"));
						 
				
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return compra;
		
	}
	
	 public List<Compra> getComprasByUsuarioId(int idUsuario) {
	        List<Compra> compras = new ArrayList<>();

	        try {
	            // Preparar la consulta SQL para seleccionar las compras por idUsuario
	            String sql = "SELECT idCompra, idUsuario FROM compra WHERE idUsuario = ?";
	            PreparedStatement statement = connection.prepareStatement(sql);
	            statement.setInt(1, idUsuario);

	            // Ejecutar la consulta
	            ResultSet resultSet = statement.executeQuery();

	            // Procesar el resultado
	            while (resultSet.next()) {
	                Compra compra = new Compra(
	                    resultSet.getInt("idCompra"),
	                    resultSet.getInt("idUsuario")
	                );
	                compras.add(compra);
	            }
	        } catch (SQLException e) {
	            // Imprimir la traza de la excepción en caso de error
	            e.printStackTrace();
	        }

	        return compras;
	    }
	
}
