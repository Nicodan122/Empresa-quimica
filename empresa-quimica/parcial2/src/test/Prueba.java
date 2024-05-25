package test;

import static org.junit.Assert.assertEquals;
//import conexion.Usuario;
import parcial2.Usuario;
import org.junit.Test;

import controlador.UsuarioControlador;

public class Prueba {
	
	@Test
	public void PruebaUsuariosExistentes() { 
		
		UsuarioControlador controlar = new UsuarioControlador();
		boolean prueba = true;
		if (controlar.getAllUsers().isEmpty()) {
			prueba = false;
		} else {

		}
		assertEquals(prueba,true);
		
		
	}
	
	@Test
	public void IgngresarUsuario() { 
		
		UsuarioControlador controlar = new UsuarioControlador();
		
		Usuario nuevo = new Usuario("Nico","nico123");
		boolean prueba = true;
		for (Usuario usuario : controlar.getAllUsers()) {
			
			if(usuario.getContra().equals(nuevo.getContra())) {
				prueba = false;
			}
		}if (prueba == true) {
			controlar.addUser(nuevo);	
		}
		assertEquals(prueba,true);
		
		
	}
	
	
	@Test
	public void IngresarUsuarioExistente() { 
		
		UsuarioControlador controlar = new UsuarioControlador();
		
		Usuario nuevo = new Usuario("Nico","Ghami@gmail.com");
		boolean prueba = true;
		for (Usuario usuario : controlar.getAllUsers()) {
			
			if(usuario.getContra().equals(nuevo.getContra())) {
				prueba = false;
			}
		}if (prueba == true) {
			controlar.addUser(nuevo);	
		}
		assertEquals(prueba,false);
		
		
	}
	

}
