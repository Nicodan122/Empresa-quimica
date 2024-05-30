package controlador;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;


import interfaces.CompraRepository;
import parcial2.Compra;

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
	
}
