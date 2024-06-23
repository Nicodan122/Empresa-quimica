package frames;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.util.List;

import controlador.ControladorCompra;
import controlador.ControladorCompraDetalle;
import controlador.ProductoControlador;
import controlador.UsuarioControlador;
import parcial2.Compra;
import parcial2.CompraDetalle;
import parcial2.Producto;
import parcial2.Usuario;

public class VentaForm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JComboBox<Producto> productoComboBox;
    private JTextField cantidadField;
    private JButton agregarProductoBtn;
    private JButton guardarVentaBtn;
    private JTextArea ticketArea;
    private Compra ventaActual;
    private ControladorCompra ventaControlador;
    private CompraDetalle ventaDetalleActual;
    private ControladorCompraDetalle ventaDetalleControlador;
    private ProductoControlador productoControlador;
    private UsuarioControlador usuarioControlador;
    private Usuario usuarioActual;
	
	
	public VentaForm(Usuario usuario) {
		 this.usuarioActual = usuario; // Guardar el usuario actual
	        setTitle("Gestionar Ventas");
	        setSize(800, 600);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setLocationRelativeTo(null);
	        setLayout(new BorderLayout());

	        //setContentPane(contentPane);
		
		 // Inicializar controladores
        ventaControlador = new ControladorCompra();
        ventaDetalleControlador = new ControladorCompraDetalle();
        productoControlador = new ProductoControlador();
        
        // Panel de entrada
        JPanel inputPanel = new JPanel(new GridLayout(2, 2));
        productoComboBox = new JComboBox<>();
        cantidadField = new JTextField();
        agregarProductoBtn = new JButton("Agregar Producto");
        guardarVentaBtn = new JButton("Guardar Venta");
        
        inputPanel.add(new JLabel("Producto:"));
        inputPanel.add(productoComboBox);
        inputPanel.add(new JLabel("Cantidad:"));
        inputPanel.add(cantidadField);

        add(inputPanel, BorderLayout.NORTH);
        
        // Área para mostrar el ticket
        ticketArea = new JTextArea();
        add(new JScrollPane(ticketArea), BorderLayout.CENTER);
        
        // Acción del botón Agregar Producto
        agregarProductoBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarProducto();
            }
        });
		
		
	}
	
	 private void agregarProducto() {
	        Producto producto = (Producto) productoComboBox.getSelectedItem();
	        int cantidad = Integer.parseInt(cantidadField.getText());

	        // Verificar si el producto ya está en la venta actual
	        for (CompraDetalle detalle : ventaActual.getDetalles()) {
	            if (detalle.getProductoId() == producto.getIdProducto()) {
	                // Si el producto ya está en la venta, actualizar la cantidad y salir del método
	                detalle.setCantidad(detalle.getCantidad() + cantidad);
	                actualizarTicket();
	                return;
	            }
	        }

	        // Si el producto no está en la venta, agregarlo como un nuevo detalle
	        ventaActual.getDetalles().add(new DetalleVenta(producto.getId(), cantidad));

	        actualizarTicket();
	    }
	 
	 private void actualizarTicket() {
	        ticketArea.setText("Ticket de Venta:\n\n");
	        double total = 0.0;
	        for (CompraDetalle detalle : ventaActual.getDetalles()) {
	            Producto producto = productoControlador.getProductById(detalle.getProductoId());
	            double subtotal = detalle.getCantidad() * producto.getPrecio();
	            total += subtotal;
	            ticketArea.append(producto.getNombre() + "\tCantidad: " + detalle.getCantidad() + "\tSubtotal: $" + subtotal + "\n");
	        }
	        ticketArea.append("\nTotal: $" + total);
	    }
	 

	

}
