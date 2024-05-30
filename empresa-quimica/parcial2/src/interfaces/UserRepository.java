package interfaces;

import java.util.List;


import parcial2.Usuario;

public interface UserRepository {
	
	//protoripos de metodos
	List<Usuario> getAllUsers();
	
	Usuario getUserById(int id);
	
	int getIdUsuario(String nombreUsuario); 
	
	void addUser(Usuario user);
	
	
	void updateUser(Usuario user);
	
	void deleteUser(int id);
	
	boolean validarCredenciales(String nombre, String contra);

	String getRolUsuario(int idUsuario);
	
	
	
	
	
}
