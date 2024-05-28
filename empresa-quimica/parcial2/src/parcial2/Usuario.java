package parcial2;

import javax.swing.JOptionPane;

import controlador.UsuarioControlador;

public class Usuario {
	private String nombre;
	private String contra;
	private int idUsuario;
	public Usuario(String nombre, String contra, int idUsuario) {
		super();
		this.nombre = nombre;
		this.contra = contra;
		this.idUsuario = idUsuario;
	}
	
	public Usuario(String nombre, String contra) {
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
	
	public boolean iniciarSesion() {
		
        String nombre1 = JOptionPane.showInputDialog("Ingrese su nombre de usuario:");
        String contra1 = JOptionPane.showInputDialog("Ingrese su contraseña:");

       
        if (this.nombre.equals(nombre1) && this.contra.equals(contra1)) {
            return true;
        }else {
        	return false;
        }
    }
	
	public boolean iniciarSesionB() {
		
		// Solicitar nombre de usuario y contraseña al usuario
		
        String nombreIngresado = JOptionPane.showInputDialog("Ingrese su nombre de usuario:");
        String contraIngresada = JOptionPane.showInputDialog("Ingrese su contraseña:");

        // Consultar la base de datos para validar las credenciales
        
        UsuarioControlador controlador = new UsuarioControlador();
        return controlador.validarCredenciales(nombreIngresado, contraIngresada);
	}
	
	
	
	
	@Override
	public String toString() {
		return "Usuario [id=" + idUsuario + ", nombre=" + nombre + ", email=" + contra + "]\n";
	}
	
	

}
