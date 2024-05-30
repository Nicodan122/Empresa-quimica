package parcial2;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import controlador.UsuarioControlador;

public class Usuario {
	private String nombre;
	private String contra;
	private int idUsuario;
	private String rol;
	
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
	
	
	
	
	
	
	@Override
	public String toString() {
		return "Usuario [id=" + idUsuario + ", nombre=" + nombre + ", contra=" + contra + ", rol=" + rol + "]\n";
	}
	
	

}
