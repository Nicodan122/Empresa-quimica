package controlador;

import java.sql.Connection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;


import interfaces.CompraRepository;
import parcial2.Compra;

import interfaces.CompraDetalleRepository;
import parcial2.CompraDetalle;

public class ControladorCompraDetalle implements CompraDetalleRepository {
	private final Connection connection;

    public ControladorCompraDetalle() {
        this.connection = DatabaseConnection.getInstance().getConnection();
    }

	@Override
	public void agregarDetalle(CompraDetalle detalle) {
		try {
            String sql = "INSERT INTO compradetalle (idCompra, idProducto, cantidad, precio, subtotal) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, detalle.getIdCompra());
            statement.setInt(2, detalle.getIdProducto());
            statement.setInt(3, detalle.getCantidad());
            statement.setDouble(4, detalle.getPrecio());
            statement.setDouble(5, detalle.getSubtotal());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
	
	@Override
	 public List<CompraDetalle> getDetallesByCompraId(int idCompra) {
	        List<CompraDetalle> detalles = new ArrayList<>();

	        try {
	            // Preparar la consulta SQL para seleccionar los detalles de la compra por idCompra
	            String sql = "SELECT idDetalle, idCompra, idProducto, cantidad, precio, subtotal FROM compradetalle WHERE idCompra = ?";
	            PreparedStatement statement = connection.prepareStatement(sql);
	            statement.setInt(1, idCompra);

	            // Ejecutar la consulta
	            ResultSet resultSet = statement.executeQuery();

	            // Procesar el resultado
	            while (resultSet.next()) {
	                CompraDetalle detalle = new CompraDetalle(
	                    resultSet.getInt("idDetalle"),
	                    resultSet.getInt("idCompra"),
	                    resultSet.getInt("idProducto"),
	                    resultSet.getInt("cantidad"),
	                    resultSet.getDouble("precio"),
	                    resultSet.getDouble("subtotal")
	                );
	                detalles.add(detalle);
	            }
	        } catch (SQLException e) {
	            // Imprimir la traza de la excepción en caso de error
	            e.printStackTrace();
	        }

	        return detalles;
	    }

}
