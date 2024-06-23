package frames;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Empleado extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	
	public Empleado(String nombre) {
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 469, 483);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Bienvenido Empleado <dynamic>");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblNewLabel.setBounds(21, 10, 416, 38);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1_1 = new JLabel("Funciones:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(39, 285, 142, 28);
		contentPane.add(lblNewLabel_1_1);
		
		JButton btnProduct = new JButton("Ver Productos");
		btnProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ProductoTable table = new ProductoTable();
			}
		});
		btnProduct.setBounds(39, 338, 116, 44);
		contentPane.add(btnProduct);
		
		JButton btnCargarVenta = new JButton("Cargar Venta");
		btnCargarVenta.setBounds(165, 338, 116, 44);
		contentPane.add(btnCargarVenta);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(114, 71, 194, 181);
		contentPane.add(lblNewLabel_1);
	}

}
