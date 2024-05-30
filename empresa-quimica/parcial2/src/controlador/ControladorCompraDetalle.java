package controlador;

import java.sql.Connection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

}
