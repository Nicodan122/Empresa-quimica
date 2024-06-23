package vista;

import javax.swing.JOptionPane;

import controlador.ProductoControlador;
import controlador.UsuarioControlador;
import parcial2.Cliente;
import parcial2.Empleado;
import parcial2.Gerente;
import parcial2.Producto;
import parcial2.Ventas;
import parcial2.Usuario;

class Main {

	public static void main(String[] args) {
		
		 
		UsuarioControlador controlar = new UsuarioControlador();
		//JOptionPane.showMessageDialog(null, controlar.getAllUsers());
		
		
		
		// Crear cada tipo de usuario
        Cliente cliente = new Cliente();
        Empleado empleado = new Empleado();
        
        ProductoControlador productoControlador = new ProductoControlador(); // Inicializa ProductoControlador correctamente
        Gerente gerente = new Gerente(productoControlador);
     
        //Cargar Ventas
        Ventas v1 = new Ventas("Dos Quimicos 1", 20, 90000, "29/10");
        Ventas v2 = new Ventas("Dos Quimicos 2", 50, 40000, "9/12");

        
        
        
        
        //Menu para iniciar sesion 
      
        String[] opciones = {"Registrarse", "Iniciar Seson"};
        
        Usuario usuario = new Usuario(null, null, null);

        int eleccion = JOptionPane.showOptionDialog(
            null,"Seleccione entre Registro/Inicio", "Inicio de Sesión", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,null,opciones,opciones[0]
        );

        switch (eleccion) {
            case 0:
            	
            	String[] opcionesRegistro = {"Gerente", "Empleado", "Cliente"};
            	
            	
            	
                int eleccionRegistro = JOptionPane.showOptionDialog(
                    null, "Seleccione el tipo de registro", "Registro de Usuario", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcionesRegistro, opcionesRegistro[0]
                );

                switch (eleccionRegistro) {
                
                    case 0:
                    	String rolG = "gerente";
                    	JOptionPane.showMessageDialog(null, "Te estas registrando como Gerente");
                    	String nombreG = JOptionPane.showInputDialog("Ingrese nombre");
            			String contraG = JOptionPane.showInputDialog("Ingrese contra");
            			controlar.addUser(new Usuario(nombreG, contraG, rolG));
            			int idUsuario = controlar.getIdUsuario(nombreG);
            			gerente.mostrarMenu();
                        break;
                    case 1:
                    	String rolE = "empleado";
                    	JOptionPane.showMessageDialog(null, "Te estas registrando como Empleado");
                    	String nombreE = JOptionPane.showInputDialog("Ingrese nombre");
            			String contraE = JOptionPane.showInputDialog("Ingrese contra");
            			controlar.addUser(new Usuario(nombreE, contraE, rolE));	
            			int idUsuarioE = controlar.getIdUsuario(nombreE);
            			empleado.mostrarMenu();
                        break;
                    case 2:
                    	String rolC = "cliente";
                    	JOptionPane.showMessageDialog(null, "Te estas registrando como Cliente");
                    	String nombreC = JOptionPane.showInputDialog("Ingrese nombre");
            			String contraC = JOptionPane.showInputDialog("Ingrese contra");
            			controlar.addUser(new Usuario(nombreC, contraC, rolC));	
            			int idUsuarioC = controlar.getIdUsuario(nombreC);  //Solo eliminaria esto
            			cliente.mostrarMenu();
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opción no válida");
                        break;
                }
                
                break;
            case 1:
String[] opcionesRegistro2 = {"Gerente", "Empleado", "Cliente"};
            	
            	//Eliminaria este menu y hago el inicio de sesion unico y dentro de iniciodeSesion pido el valor de rol en la tabla usuario
            	//Depenidenod de ese resultado muestro un menu o otro.
            	
                int eleccionRegistro2 = JOptionPane.showOptionDialog(
                    null, "Seleccione el tipo de registro", "Registro de Usuario", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcionesRegistro2, opcionesRegistro2[0]
                );

                switch (eleccionRegistro2) {
                
                    case 0:
                    	if (usuario.iniciarSesionB()) {
                            JOptionPane.showMessageDialog(null, "Iniciaste Sesión correctamente");
                            gerente.mostrarMenu();
                         } else {
                             JOptionPane.showMessageDialog(null, "No se pudo iniciar sesión. Verifica tus credenciales.");
                         }
                        break;
                    case 1:
                    	if (usuario.iniciarSesionB()) {
                            JOptionPane.showMessageDialog(null, "Iniciaste Sesión correctamente");
                            empleado.mostrarMenu();
                         } else {
                             JOptionPane.showMessageDialog(null, "No se pudo iniciar sesión. Verifica tus credenciales.");
                         }
                        break;
                    case 2:
                    	if (usuario.iniciarSesionB()) {
                            JOptionPane.showMessageDialog(null, "Iniciaste Sesión correctamente");
                            cliente.mostrarMenu();
                         } else {
                             JOptionPane.showMessageDialog(null, "No se pudo iniciar sesión. Verifica tus credenciales.");
                         }
                    	break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opción no válida");
        }
                
       }
       
            
      
	}
	

}


