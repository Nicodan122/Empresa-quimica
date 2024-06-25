package frames;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import controlador.ProductoControlador;
import parcial2.Producto;

public class EditarProducto extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nombreField;
	private JTextField precioField;
	private JLabel imagenLabel;
	private byte[] imagenData;
	private JLabel label_4;
	private JTextField inpCantidad;
	private JTextField descripcionField;
	private JTextField nivelField;
	private Producto producto;
	
	
	public EditarProducto( Producto seleccionado) {
		this.producto = seleccionado;
		this.setVisible(true);
		 setTitle("Agregar Producto");
	        setSize(484, 465);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setLocationRelativeTo(null);

	        nombreField = new JTextField(seleccionado.getNombre());
	        nombreField.setBounds(237, 6, 191, 40);
	        precioField = new JTextField(String.valueOf(seleccionado.getPrecio()));
	        precioField.setBounds(237, 57, 191, 40);
	        imagenLabel = new JLabel();
	        imagenLabel.setBounds(237, 282, 212, 40);

	        JButton seleccionarImagenBtn = new JButton("Seleccionar Imagen");
	        seleccionarImagenBtn.setBounds(0, 365, 232, 70);
	        seleccionarImagenBtn.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                seleccionarImagen();
	            }
	        });

	        JButton guardarBtn = new JButton("Guardar Actualizacion");
	        guardarBtn.setBounds(237, 365, 232, 70);
	        guardarBtn.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                guardarProducto();
	            }
	        });
	        getContentPane().setLayout(null);

	        JLabel label = new JLabel("Nombre:");
	        label.setBounds(10, 1, 185, 50);
	        getContentPane().add(label);
	        getContentPane().add(nombreField);
	        JLabel label_1 = new JLabel("Precio:");
	        label_1.setBounds(10, 50, 185, 40);
	        getContentPane().add(label_1);
	        getContentPane().add(precioField);
	        JLabel label_5 = new JLabel("Imagen:");
	        label_5.setBounds(10, 282, 185, 40);
	        getContentPane().add(label_5);
	        getContentPane().add(imagenLabel);
	        getContentPane().add(seleccionarImagenBtn);
	        getContentPane().add(guardarBtn);
	        
	        label_4 = new JLabel("cantidad:");
	        label_4.setBounds(10, 217, 185, 40);
	        getContentPane().add(label_4);
	        
	        inpCantidad = new JTextField(String.valueOf(seleccionado.getStock()));
	        inpCantidad.setBounds(237, 217, 191, 40);
	        getContentPane().add(inpCantidad);
	        
	        JLabel label_2 = new JLabel("Descripcion:");
	        label_2.setBounds(10, 113, 185, 40);
	        getContentPane().add(label_2);
	        
	        descripcionField = new JTextField(seleccionado.getDescripcion());
	        descripcionField.setBounds(237, 107, 191, 40);
	        getContentPane().add(descripcionField);
	        
	        JLabel label_3 = new JLabel("Nivel:");
	        label_3.setBounds(10, 158, 185, 40);
	        getContentPane().add(label_3);
	        
	        nivelField = new JTextField(String.valueOf(seleccionado.getNivel()));
	        nivelField.setBounds(237, 157, 191, 40);
	        getContentPane().add(nivelField);
	    }

	    private void seleccionarImagen() {
	        JFileChooser fileChooser = new JFileChooser();
	        int result = fileChooser.showOpenDialog(this);
	        if (result == JFileChooser.APPROVE_OPTION) {
	            File file = fileChooser.getSelectedFile();
	            imagenLabel.setText(file.getName());
	            imagenData = leerImagen(file);
	        }
	    }

	    private byte[] leerImagen(File file) {
	        byte[] bFile = new byte[(int) file.length()];
	        try (FileInputStream fileInputStream = new FileInputStream(file)) {
	            fileInputStream.read(bFile);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return bFile;
	    }

	    private void guardarProducto() {
	        String nombre = nombreField.getText();
	        double precio = Double.parseDouble(precioField.getText());
	        String descripcion = descripcionField.getText();
	        int nivel = Integer.parseInt(nivelField.getText());
	        int cantidad = Integer.parseInt(inpCantidad.getText());    
	        
	        // Usa el producto existente y actualiza sus atributos
	        producto.setNombre(nombre);
	        producto.setPrecio(precio);
	        producto.setDescripcion(descripcion);
	        producto.setNivel(nivel);
	        producto.setStock(cantidad);
	         
	        if (imagenData != null) { // Solo actualiza la imagen si se ha seleccionado una nueva
	            producto.setImagen(imagenData);
	        }
	        
	        ProductoControlador controlador = new ProductoControlador();
	        if (controlador.upDateProduct(producto)) {
	            JOptionPane.showMessageDialog(this, "Producto Actualizado Exitosamente");
	            new ProductoTable().setVisible(true); 
	            dispose();
	        } else {
	            JOptionPane.showMessageDialog(this, "Error al actualizar el producto");
	        }
	    }

	    public static void main(String[] args) {
	        SwingUtilities.invokeLater(new Runnable() {
	            @Override
	            public void run() {
	                new ProductoForm().setVisible(true); //Cambie al ProductoForm x ProductoTable
	            }
	        });
	    }
	}
