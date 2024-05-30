package parcial2;

import javax.swing.JOptionPane;

import controlador.ControladorCompra;
import controlador.ControladorCompraDetalle;
import controlador.ProductoControlador;
import controlador.UsuarioControlador;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Usuario {
	private Usuario usuario;
	
	  // Constructor sin parámetros
    public Cliente() {
        super("", "", 0, ""); // Llamada al constructor de la superclase Usuario con valores predeterminados o nulos
    }

	public Cliente(String nombre, String contra, int idUsuario, String rol) {
        super(nombre, contra, idUsuario, rol);
    }

	private void mostrarProductos() {
	    ProductoControlador productoControlador = new ProductoControlador();
	    List<Producto> productos = productoControlador.getAllProducts();

	    if (productos.isEmpty()) {
	        JOptionPane.showMessageDialog(null, "No hay productos disponibles.");
	    } else {
	        StringBuilder mensaje = new StringBuilder("Lista de productos:\n");
	        for (Producto producto : productos) {
	            mensaje.append("ID: ").append(producto.getIdProducto()).append(", ")
	                   .append("Nombre: ").append(producto.getNombre()).append(", ")
	                   .append("Precio: ").append(producto.getPrecio()).append(", ")
	                   .append("Descripción: ").append(producto.getDescripcion()).append(", ")
	                   .append("Nivel: ").append(producto.getNivel()).append("\n");
	        }
	        JOptionPane.showMessageDialog(null, mensaje.toString());
	    }
	}
	
	public void mostrarMenu(){
		String[] opciones = {"Ver Productos","Comprar Producto","Salir"};
		int opcion=0;
		
		do {
		
		 opcion = JOptionPane.showOptionDialog(
				null,"Seleccione una opción", "Menú Cliente", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,null,opciones,opciones[0]
				);
		
		  switch (opcion) {
          case 0:
        	  mostrarProductos();
              break;
          case 1:
        	   mostrarProductos();
               realizarCompra();
              break;
          case 2:
        	  System.exit(0);
              break;
          default:
              JOptionPane.showMessageDialog(null, "Opción no válida");
      }
		  
	} while (opcion!=2);
		
	}

	private void realizarCompra() {
		ProductoControlador productoControlador = new ProductoControlador();
		ControladorCompra compraControlador = new ControladorCompra();
		ControladorCompraDetalle controladorCompraDetalle = new ControladorCompraDetalle();
		
		List<Producto> productos = productoControlador.getAllProducts();
		if (productos.isEmpty()) {
			JOptionPane.showMessageDialog(null, "No hay productos disponibles");
			return;
		}
		
		List<CompraDetalle> detalles = new ArrayList<>();
		//double total = 0;
		
		while (true) {
            String idProductoStr = JOptionPane.showInputDialog("Ingrese el ID del producto a comprar (o 'fin' para terminar):");
            if (idProductoStr.equalsIgnoreCase("fin")) {
                break;
            }

            int idProducto = Integer.parseInt(idProductoStr);
            Producto producto = productos.stream().filter(p -> p.getIdProducto() == idProducto).findFirst().orElse(null);
            if (producto == null) {
                JOptionPane.showMessageDialog(null, "Producto no encontrado.");
                continue;
            }

            int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad:"));
            if (cantidad > producto.getStock()) {
                JOptionPane.showMessageDialog(null, "Cantidad no disponible en stock.");
                continue;
            }

            double subtotal = producto.getPrecio() * cantidad;
            //total += subtotal;

            CompraDetalle detalle = new CompraDetalle(0, 0, idProducto, cantidad, producto.getPrecio(), subtotal);
            detalles.add(detalle);

            producto.setStock(producto.getStock() - cantidad);
        }

        if (detalles.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No se ha seleccionado ningún producto.");
            return;
        }

        System.out.println("ID de Usuario para la compra: " + getIdUsuario());
        Compra compra = new Compra(getIdUsuario());
        //compra.setTotal(total);
        int idCompra = compraControlador.crearCompra(compra);

        if (idCompra > 0) {
            for (CompraDetalle detalle : detalles) {
                detalle.setIdCompra(idCompra);
                controladorCompraDetalle.agregarDetalle(detalle);
            }
            JOptionPane.showMessageDialog(null, "Compra realizada exitosamente.");
        } else {
            JOptionPane.showMessageDialog(null, "Error al realizar la compra.");
        }
		
	}
	
	

	

}
