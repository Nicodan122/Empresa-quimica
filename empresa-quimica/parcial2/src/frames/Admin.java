package frames;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.MediaTracker;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Admin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	
	public Admin(String nombre) {
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 515, 419);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Bienvenido Gerente " + nombre);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 28));
		lblNewLabel.setBounds(21, 10, 470, 38);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1_1 = new JLabel("Funciones:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(39, 285, 142, 28);
		contentPane.add(lblNewLabel_1_1);
		
		JButton btnProduct = new JButton("Ver Productos");
		btnProduct.setForeground(new Color(255, 255, 255));
		btnProduct.setBorderPainted(false);
		btnProduct.setBackground(new Color(0, 128, 128));
		btnProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ProductoTable table = new ProductoTable();
			}
		});
		btnProduct.setBounds(39, 323, 116, 44);
		contentPane.add(btnProduct);
		
		JButton btnSell = new JButton("Cargar Producto");
		btnSell.setFont(new Font("Tahoma", Font.BOLD, 9));
		btnSell.setForeground(new Color(255, 255, 255));
		btnSell.setBorderPainted(false);
		btnSell.setBackground(new Color(0, 128, 128));
		btnSell.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ProductoForm form = new ProductoForm();
			}
		});
		btnSell.setBounds(294, 323, 116, 44);
		contentPane.add(btnSell);
		
		JButton btnVerUsuarios = new JButton("Ver Usuarios");
		btnVerUsuarios.setForeground(new Color(255, 255, 255));
		btnVerUsuarios.setBackground(new Color(0, 128, 128));
		btnVerUsuarios.setBorderPainted(false);
		btnVerUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TablaUsuarios usuarios = new TablaUsuarios();
				dispose();
			}
		});
		btnVerUsuarios.setBounds(168, 323, 116, 44);
		contentPane.add(btnVerUsuarios);
		
		 JLabel lblImage = new JLabel("");
	        lblImage.setBounds(143, 70, 194, 181);
	        contentPane.add(lblImage);

	        // Load the image from the "imagenes" folder
	        ImageIcon imgIcon = new ImageIcon(getClass().getResource("/imagenes/manager.png"));
	        if (imgIcon.getImageLoadStatus() == MediaTracker.ERRORED) {
	            System.err.println("Error loading image");
	        } else {
	            Image img = imgIcon.getImage().getScaledInstance(lblImage.getWidth(), lblImage.getHeight(), Image.SCALE_SMOOTH);
	            lblImage.setIcon(new ImageIcon(img));
	        }

	}
}
