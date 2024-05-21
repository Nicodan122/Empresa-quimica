package parcial2;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class Conexion {
	
	Connection con;
	
	public Connection conectar() {
		
		try {
			con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/prueba","root","");
			JOptionPane.showMessageDialog(null, "Funciona anda a saber como");
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Base que no funciona esta chota");
		}
		
		
		return con;
	}

}
