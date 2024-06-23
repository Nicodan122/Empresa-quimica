package frames;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class Home extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	
	public Home(String nombre) {
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 473, 524);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Bienvenido Cliente " + nombre);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblNewLabel.setBounds(21, 10, 416, 38);
		contentPane.add(lblNewLabel);
		
		JLabel lblNombre = new JLabel("New label");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNombre.setBounds(196, 245, 142, 44);
		contentPane.add(lblNombre);
		
		JLabel lblRol = new JLabel("New label");
		lblRol.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblRol.setBounds(348, 245, 142, 44);
		contentPane.add(lblRol);
		
		JLabel lblId = new JLabel("New label");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblId.setBounds(44, 245, 142, 44);
		contentPane.add(lblId);
		
		JLabel lblNewLabel_1 = new JLabel("Datos Personales:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(173, 207, 142, 28);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Funciones:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(44, 327, 142, 28);
		contentPane.add(lblNewLabel_1_1);
		
		JButton btnProduct = new JButton("Ver Productos");
		btnProduct.setBounds(45, 408, 116, 44);
		contentPane.add(btnProduct);
		
		JButton btnSell = new JButton("Realizar Compra");
		btnSell.setBounds(174, 408, 116, 44);
		contentPane.add(btnSell);
		
		JButton btnUsers = new JButton("Ver Compras");
		btnUsers.setBounds(300, 408, 116, 44);
		contentPane.add(btnUsers);
	}
}
