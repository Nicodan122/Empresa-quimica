package frames;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CargarVentaForm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_4;

	
	public CargarVentaForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 510, 399);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblProductos = new JLabel("Productos:");
		lblProductos.setBounds(33, 25, 185, 50);
		contentPane.add(lblProductos);
		
		textField = new JTextField();
		textField.setBounds(260, 30, 191, 40);
		contentPane.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setBounds(260, 81, 191, 40);
		contentPane.add(textField_1);
		
		JLabel label_1 = new JLabel("Total:");
		label_1.setBounds(33, 74, 185, 40);
		contentPane.add(label_1);
		
		textField_3 = new JTextField();
		textField_3.setBounds(260, 131, 191, 40);
		contentPane.add(textField_3);
		
		JLabel label_3 = new JLabel("Nivel:");
		label_3.setBounds(33, 132, 185, 40);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("cantidad:");
		label_4.setBounds(33, 191, 185, 40);
		contentPane.add(label_4);
		
		textField_4 = new JTextField();
		textField_4.setBounds(260, 191, 191, 40);
		contentPane.add(textField_4);
		
		JButton seleccionarImagenBtn = new JButton("Seleccionar Imagen");
		seleccionarImagenBtn.setBounds(10, 267, 232, 70);
		contentPane.add(seleccionarImagenBtn);
		
		JButton guardarBtn = new JButton("Guardar Producto");
		guardarBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		guardarBtn.setBounds(247, 267, 232, 70);
		contentPane.add(guardarBtn);
	}

}
