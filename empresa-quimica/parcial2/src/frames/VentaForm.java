package frames;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.util.List;

import controlador.ControladorCompra;
import controlador.ControladorCompraDetalle;
import controlador.ProductoControlador;
import controlador.UsuarioControlador;
import parcial2.Cliente;
import parcial2.Compra;
import parcial2.CompraDetalle;
import parcial2.Producto;
import parcial2.Usuario;

public class VentaForm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	 private JTable table;
	    private DefaultTableModel model;
	    private ProductoControlador controlador;
	    private JLabel imagenLabel;
	    private Producto seleccionado;
    private Usuario usuarioActual;
	
	
	public VentaForm( ) {
		    this.setVisible(true);
	        setTitle("Gestionar Ventas");
	        setSize(910, 350);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setLocationRelativeTo(null);
	        getContentPane().setLayout(new BorderLayout());

	        this.setVisible(true);
		 	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setBounds(100, 100, 909, 452);
	        contentPane = new JPanel();
	        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	        setContentPane(contentPane);

	        // Inicializar controlador y producto seleccionado
	        controlador = new ProductoControlador();
	        seleccionado = new Producto(0, "", 0, "", 0, 0, null);

	        // Crear la tabla y el modelo
	        String[] columnNames = {"ID", "Nombre", "Precio", "Descripcion", "Cantidad"};
	        model = new DefaultTableModel(columnNames, 0);
	        table = new JTable(model);
	        actualizarTabla();
	        contentPane.setLayout(null);

	        // Crear el JScrollPane y agregar la tabla
	        JScrollPane scrollPane = new JScrollPane(table);
	        scrollPane.setBounds(5, 5, 600, 300);
	        contentPane.add(scrollPane);

	        // Crear el JLabel para mostrar la imagen
	        imagenLabel = new JLabel();
	        imagenLabel.setBounds(620, 5, 250, 250);
	        contentPane.add(imagenLabel);
	        
	        JButton btnCompra = new JButton("Comenzar Compra");
	        btnCompra.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		
	        		//Mostrar el metodo de comenzar compra
	        		Cliente cliente = new Cliente();
	        		cliente.realizarCompra();
	        	}
	        });
	        btnCompra.setBounds(615, 268, 270, 35);
	        contentPane.add(btnCompra);

	        // Configurar el modelo de selección
	        ListSelectionModel selectionModel = table.getSelectionModel();
	        selectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

	        // Agregar un escuchador de selección
	        selectionModel.addListSelectionListener(new ListSelectionListener() {
	            @Override
	            public void valueChanged(ListSelectionEvent e) {
	                if (!e.getValueIsAdjusting()) {
	                    int selectedRow = table.getSelectedRow();
	                    if (selectedRow != -1) {
	                    	int id = (int) table.getValueAt(selectedRow, 0);
	    					String nombre = (String) table.getValueAt(selectedRow, 1);
	    					double precio = (Double) table.getValueAt(selectedRow, 2);
	    					String descripcion = (String) table.getValueAt(selectedRow, 3);
	    					int stock = (int) table.getValueAt(selectedRow, 4);
	    					seleccionado = controlador.getProductById(id);
	    					mostrarImagen(seleccionado.getImagen());
	                    }
	                }
	            }
	        });
	    }

	    private void actualizarTabla() {
	        // Limpiar el modelo de la tabla
	        model.setRowCount(0);

	        // Obtener la lista actualizada de productos
	        List<Producto> productos = controlador.getAllProducts();

	        // Agregar los datos al modelo
	        for (Producto producto : productos) {
	        	model.addRow(new Object[] {producto.getIdProducto(), producto.getNombre(), producto.getPrecio(), producto.getDescripcion(), producto.getNivel(), producto.getStock(), producto.getImagen()});
	        }
	    }

	    private void mostrarImagen(byte[] imagen) {
	        if (imagen != null) {
	            ImageIcon icon = new ImageIcon(imagen);
	            Image img = icon.getImage();
	            Image scaledImg = img.getScaledInstance(imagenLabel.getWidth(), imagenLabel.getHeight(), Image.SCALE_SMOOTH);
	            imagenLabel.setIcon(new ImageIcon(scaledImg));
	        } else {
	            imagenLabel.setIcon(null);
	        }
	    }
	}
