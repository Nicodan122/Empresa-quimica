package parcial2;

import javax.swing.JOptionPane;

class Main {

	public static void main(String[] args) {
		
		Conexion nc = new Conexion();
		nc.conectar();
		
		
		// Crear cada tipo de usuario
        Cliente cliente = new Cliente("nicoCliente", "1234", 1, 1);
        Empleado empleado = new Empleado("nicoEmpleado", "4567", 2, 1);
        Gerente gerente = new Gerente("nicoGerente", "7890", 3, 1);
        
        // Agregar productos 
        Producto p1 = new Producto("Quimico1", 1000, "Descripción del producto 1", 0, 10);
        Producto p2 = new Producto("Quimico2", 2000, "Descripción del producto 2", 0, 20);
        Producto p3 = new Producto("Quimico3", 1000, "Descripción del producto 1", 1, 30);
        Producto p4 = new Producto("Quimico4", 2000, "Descripción del producto 2", 1, 40);
     
        //Cargar Ventas
        Ventas v1 = new Ventas("Dos Quimicos 1", 20, 90000, "29/10");
        Ventas v2 = new Ventas("Dos Quimicos 2", 50, 40000, "9/12");

        //Menu para iniciar sesion 
        
        String[] opciones = {"Cliente", "Empleado", "Gerente"};

        int eleccion = JOptionPane.showOptionDialog(
            null,"Seleccione el tipo de usuario para iniciar sesión", "Inicio de Sesión", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,null,opciones,opciones[0]
        );

        switch (eleccion) {
            case 0:
                if (cliente.iniciarSesion()) {
                    JOptionPane.showMessageDialog(null, "Bienvenido " + cliente.getNombre());
                    cliente.mostrarMenu();
                } else {
                    JOptionPane.showMessageDialog(null, "No se pudo iniciar sesión.");
                }
                break;
            case 1:
                if (empleado.iniciarSesion()) {
                    JOptionPane.showMessageDialog(null, "Bienvenido " + empleado.getNombre());
                    empleado.mostrarMenu();
                } else {
                    JOptionPane.showMessageDialog(null, "No se pudo iniciar sesión.");
                }
                break;
            case 2:
                if (gerente.iniciarSesion()) {
                    JOptionPane.showMessageDialog(null, "Bienvenido " + gerente.getNombre());
                    gerente.mostrarMenu();
                } else {
                    JOptionPane.showMessageDialog(null, "No se pudo iniciar sesión.");
                }
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opción no válida");
        }
       
            
        
        
	}

}
