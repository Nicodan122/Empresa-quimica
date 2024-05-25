package interfaces;

import java.util.List;


import parcial2.Usuario;

public interface UserRepository {
	
	//protoripos de metodos
	List<Usuario> getAllUsers();
	
	Usuario getUserById(int id);
	
	void addUser(Usuario user);
	
	void updateUser(Usuario user);
	
	void deleteUser(int id);
	
}
