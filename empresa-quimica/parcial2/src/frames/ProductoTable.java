package frames;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.util.List;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controlador.ProductoControlador;
import parcial2.Producto;

public class ProductoTable extends JFrame {

	private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable table;
    private DefaultTableModel model;
    private ProductoControlador controlador;
    private JLabel imagenLabel;
    private Producto seleccionado;
    private JTextField filtrar;

	
	public ProductoTable() {
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
	        String[] columnNames = {"ID", "Nombre", "Precio", "Descripcion", "Nivel", "Stock"};
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
	    					int nivel = (int) table.getValueAt(selectedRow, 4);
	    					int stock = (int) table.getValueAt(selectedRow, 5);
	    					seleccionado = controlador.getProductById(id);
	    					mostrarImagen(seleccionado.getImagen());
	                    }
	                }
	            }
	        });

	        // Botón para eliminar el producto seleccionado
	        JButton btnEliminar = new JButton("Eliminar");
	        btnEliminar.setBounds(620, 270, 120, 30);
	        contentPane.add(btnEliminar);
	        btnEliminar.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                if (seleccionado.getIdProducto() != 0) {
	                    controlador.deleteProduct(seleccionado.getIdProducto());
	                    JOptionPane.showMessageDialog(null, "Producto eliminado");
	                    actualizarTabla();
	                    imagenLabel.setIcon(null);
	                } else {
	                    JOptionPane.showMessageDialog(null, "Seleccione un producto");
	                }
	            }
	        });

	        // Botón para editar el producto seleccionado
	        JButton btnEditar = new JButton("Editar");
	        btnEditar.setBounds(750, 270, 120, 30);
	        contentPane.add(btnEditar);
	        
	        filtrar = new JTextField();
	        filtrar.setBounds(15, 316, 86, 20);
	        contentPane.add(filtrar);
	        filtrar.setColumns(10);
	        
	        JLabel lblNewLabel = new JLabel("Criterio");
	        lblNewLabel.setBounds(127, 319, 62, 14);
	        contentPane.add(lblNewLabel);
	        
	        JButton btnNewButton = new JButton("Filtrar");
	        btnNewButton.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		
	        		Filtrar(filtrar.getText());
	        		
	        	}
	        });
	        btnNewButton.setBounds(238, 316, 89, 23);
	        contentPane.add(btnNewButton);
	        btnEditar.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                if (seleccionado != null && seleccionado.getIdProducto() != 0) {
	                    // Aquí puedes llamar a tu ventana de edición, pasando el producto seleccionado
	                     new EditarProducto(seleccionado).setVisible(true);
	                } else {
	                    JOptionPane.showMessageDialog(null, "Seleccione un producto");
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
	    private void Filtrar(String criterio) {
	        // Limpiar el modelo de la tabla
	        model.setRowCount(0);

	        // Obtener la lista actualizada de productos
	        List<Producto> productos = controlador.getAllProducts();

	        // Agregar los datos al modelo
	        for (Producto producto : productos) {
	        	if(producto.getNombre().contains(criterio)) {
	        		model.addRow(new Object[] {producto.getIdProducto(), producto.getNombre(), producto.getPrecio(), producto.getDescripcion(), producto.getNivel(), producto.getStock(), producto.getImagen()});
	        	}
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