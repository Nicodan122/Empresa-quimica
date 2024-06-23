package parcial2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JOptionPane;

import controlador.UsuarioControlador;

public class Usuario {
	private String nombre;
	private String contra;
	private int idUsuario;
	private String rol;
	
	public Usuario() {
		
	}
	
	public Usuario(String nombre, String contra, int idUsuario, String rol) {
		super();
		this.nombre = nombre;
		this.contra = contra;
		this.idUsuario = idUsuario;
		this.rol = rol;
	}
	
	public Usuario(String nombre, String contra, String rol) {
		this.nombre = nombre;
		this.contra = contra;
		this.rol = rol;
	}
	
	
	
	public Usuario(String nombre, String contra, int idUsuario) {
		super();
		this.nombre = nombre;
		this.contra = contra;
		this.idUsuario = idUsuario;
	}

	public Usuario(String nombre, String contra) {
		super();
		this.nombre = nombre;
		this.contra = contra;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getContra() {
		return contra;
	}
	public void setContra(String contra) {
		this.contra = contra;
	}
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public boolean iniciarSesionB() {
		
		// Solicitar nombre de usuario y contraseña al usuario
		
        String nombreIngresado = JOptionPane.showInputDialog("Ingrese su nombre de usuario:");
        String contraIngresada = JOptionPane.showInputDialog("Ingrese su contraseña:");       
        UsuarioControlador controlador = new UsuarioControlador();
        return controlador.validarCredenciales(nombreIngresado, contraIngresada);
	}
	
	
public static String iniciarSesionFrame(String nombreIngresado, String contraIngresada) {
		UsuarioControlador controlador = new UsuarioControlador();
	    
	    // Validar las credenciales
	    if (!controlador.validarCredenciales(nombreIngresado, contraIngresada)) {
	        return "No se encontró un usuario con esos datos";
	    }
	    
	    // Obtener todos los usuarios (si es necesario)
	    List<Usuario> usuarios = controlador.getAllUsers();
	    
	    // Si no hay usuarios registrados
	    if (usuarios.isEmpty()) {
	        return "No hay usuarios";
	    }
	    
	    // Buscar el usuario específico por nombre y contraseña
	    for (Usuario usuario : usuarios) {
	        if (usuario.getNombre().equals(nombreIngresado) && usuario.getContra().equals(contraIngresada)) {
	            return "rol:" + usuario.getRol();
	        }
	    }
	    
	    // Si no se encontró el usuario con nombre y contraseña específicos
	    return "No se encontró un usuario con esos datos";
}


	public static String Registrarse(String nombre, String contra, String rol) {
		
		UsuarioControlador controlador = new UsuarioControlador();
		
		if (nombre.length()>3) {
			if(contra.length()>6) {
				for(Usuario usuario : controlador.getAllUsers() ) {
					if (usuario.getNombre().equals(nombre)) {
						return "Usuario existente";
						
					}
				}
				
				Usuario nuevoUsuario = new Usuario(nombre, contra, rol);
				controlador.addUser(nuevoUsuario);
				return nuevoUsuario.getRol();
				
				//controlador.addUser(new Usuario(nombre,contra,rol));
				//return "Ok";
			
				
			}else {
				
			return "Ingrese una contrasenia valida (+6 caracteres)";
				
		}
			
		}else {
			
			return "Ingrese un nombre de usuario valido (+3 caracteres)";
			
		}
		
	}
	
	
	
	
	
	
	@Override
	public String toString() {
		return "Usuario [id=" + idUsuario + ", nombre=" + nombre + ", contra=" + contra + ", rol=" + rol + "]\n";
	}
	
	

}
