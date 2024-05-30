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
	

}
