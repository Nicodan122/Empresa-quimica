package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import interfaces.UserRepository;
import parcial2.Usuario;

public class UsuarioControlador implements UserRepository {
		private final Connection connection;
		
		public UsuarioControlador() {
			this.connection = DatabaseConnection.getInstance().getConnection();
		}
		
		@Override
		public List<Usuario> getAllUsers() {
			List<Usuario> users = new ArrayList<>();
			try {
				PreparedStatement statement = connection.prepareStatement("SELECT * FROM usuarios ");
				ResultSet resultSet = statement.executeQuery();
				
				while (resultSet.next()) {
					Usuario user = new Usuario(resultSet.getString("nombre"), resultSet.getString("contra"), resultSet.getInt("idUsuario"));
					//Usuario user = new Usuario(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("email"));
					users.add(user);
				}	
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return users;
		}
		
		
		@Override
		public Usuario getUserById(int id) {
			Usuario user = null;
			try {
				PreparedStatement statement = connection.prepareStatement("SELECT * FROM usuarios WHERE idUsuarios = ?");
				statement.setInt(1, id);
				
				ResultSet resultSet = statement.executeQuery();
				
				if (resultSet.next()) {
					 user = new Usuario(resultSet.getString("nombre"), resultSet.getString("contra"), resultSet.getInt("idUsuario"));
					 //user = new Usuario(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("email"));
				}	
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return user;
		}
		
		@Override
		public void addUser(Usuario usuario) {
			try {
				PreparedStatement statement = connection.prepareStatement("INSERT INTO usuarios (nombre, contra) VALUES (?, ?)",
				Statement.RETURN_GENERATED_KEYS);
				
				//Valores insertados
				statement.setString(1, usuario.getNombre());
				statement.setString(2, usuario.getContra());
				
				int rowsInserted = statement.executeUpdate();
				if (rowsInserted > 0) {
					System.out.println("Usuario insertado exitosamente");
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		@Override
		public void updateUser(Usuario usuario) {
			
			try {
				PreparedStatement statement = connection.prepareStatement("UPDATE usuarios SET nombre = ?, contra = ? WHERE idUsuario = ?");
				statement.setString(1, usuario.getNombre());
				statement.setString(2, usuario.getContra());
				statement.setInt(3, usuario.getIdUsuario());
				
				int rowsUpdated = statement.executeUpdate();
				if (rowsUpdated > 0) {
					System.out.println("Usuario Actualizado Exitosamente");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		@Override 
		public void deleteUser(int id) {
			
			try {
				PreparedStatement statement = connection.prepareStatement("DELETE FROM usuarios WHERE idUsuarios =?");
				statement.setInt(1, id);
				
				int rowsDeleted = statement.executeUpdate();
				if (rowsDeleted > 0) {
					System.out.println("Usuario Eliminado Exitosamente");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
		
		//Validar Inicio de sesion para todos los usuarios, sin especificar cLiente,Gerente o empleado
		
		 @Override
		    public boolean validarCredenciales(String nombre, String contra) {
		        try {
		            PreparedStatement statement = connection.prepareStatement("SELECT * FROM usuarios WHERE nombre = ? AND contra = ?");
		            statement.setString(1, nombre);
		            statement.setString(2, contra);
		            ResultSet resultSet = statement.executeQuery();
		            return resultSet.next(); // Devuelve true si encuentra una coincidencia
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		        return false;
		    }

		@Override
		public void addGerente(int idUsuario) {
			 try {
		            PreparedStatement statement = connection.prepareStatement("INSERT INTO gerente (idUsuario) VALUES (?)");
		            statement.setInt(1, idUsuario);

		            int rowsInserted = statement.executeUpdate();
		            if (rowsInserted > 0) {
		                System.out.println("Gerente insertado exitosamente con idUsuario: " + idUsuario);
		            }

		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
			
		}

		@Override
		public void addEmpleado(int idUsuario) {
			 try {
		            PreparedStatement statement = connection.prepareStatement("INSERT INTO empleado (idUsuario) VALUES (?)");
		            statement.setInt(1, idUsuario);

		            int rowsInserted = statement.executeUpdate();
		            if (rowsInserted > 0) {
		                System.out.println("Gerente insertado exitosamente con idUsuario: " + idUsuario);
		            }

		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
			
		}

		@Override
		public void addCliente(int idUsuario) {
			 try {
		            PreparedStatement statement = connection.prepareStatement("INSERT INTO cliente (idUsuario) VALUES (?)");
		            statement.setInt(1, idUsuario);

		            int rowsInserted = statement.executeUpdate();
		            if (rowsInserted > 0) {
		                System.out.println("Gerente insertado exitosamente con idUsuario: " + idUsuario);
		            }

		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
			
		}

		@Override
		public int getIdUsuario(String nombreUsuario) {
			int idUsuario = -1; // Valor por defecto en caso de que no se encuentre el usuario

		    try {
		        PreparedStatement statement = connection.prepareStatement("SELECT idUsuario FROM usuarios WHERE nombre = ?");
		        statement.setString(1, nombreUsuario);
		        ResultSet resultSet = statement.executeQuery();

		        if (resultSet.next()) {
		            idUsuario = resultSet.getInt("idUsuario");
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }

		    return idUsuario;
		}
		
}
