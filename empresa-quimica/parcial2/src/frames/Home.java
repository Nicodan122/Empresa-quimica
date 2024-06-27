package frames;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.UsuarioControlador;
import parcial2.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.MediaTracker;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Home extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	
	public Home(String nombre) {
		
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 498, 394);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Bienvenido Cliente " + nombre);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 28));
		lblNewLabel.setBounds(21, 10, 453, 38);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1_1 = new JLabel("Funciones:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(21, 244, 142, 28);
		contentPane.add(lblNewLabel_1_1);
		
		JButton btnProduct = new JButton("Ver Productos");
		btnProduct.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnProduct.setForeground(new Color(255, 255, 255));
		btnProduct.setBackground(new Color(0, 128, 128));
		btnProduct.setBorderPainted(false);
		btnProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
			}
		});
		btnProduct.setBounds(21, 282, 116, 44);
		contentPane.add(btnProduct);
		
		JButton btnSell = new JButton("Realizar Compra");
		btnSell.setBackground(new Color(0, 128, 128));
		btnSell.setBorderPainted(false);
		btnSell.setForeground(new Color(255, 255, 255));
		btnSell.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnSell.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 // Obtener el idUsuario
			    UsuarioControlador usuarioControlador = new UsuarioControlador();
			    int idUsuario = usuarioControlador.getIdUsuario(nombre);

			    // Obtener el Usuario completo usando el idUsuario obtenido
			    Usuario usuarioActual = usuarioControlador.getUserById(idUsuario);

			    // Verificar si el usuario se encontró correctamente
			    if (usuarioActual != null) {
			        // Crear la ventana de venta pasando el usuario
			        VentaForm venta = new VentaForm(usuarioActual);
			        venta.setVisible(true);

			        // Cerrar la ventana actual (Home)
			        dispose();
			    } else {
			        JOptionPane.showMessageDialog(null, "Usuario no encontrado.");
			    }
			}
		});
		btnSell.setBounds(150, 282, 142, 44);
		contentPane.add(btnSell);
		
		JLabel lblImagen = new JLabel("");
		lblImagen.setBounds(132, 53, 194, 181);
		contentPane.add(lblImagen);
		
		 // Load the image from the "imagenes" folder
        ImageIcon imgIcon = new ImageIcon(getClass().getResource("/imagenes/patient.png"));
        if (imgIcon.getImageLoadStatus() == MediaTracker.ERRORED) {
            System.err.println("Error loading image");
        } else {
            Image img = imgIcon.getImage().getScaledInstance(lblImagen.getWidth(), lblImagen.getHeight(), Image.SCALE_SMOOTH);
            lblImagen.setIcon(new ImageIcon(img));
        }
		
	}
}
