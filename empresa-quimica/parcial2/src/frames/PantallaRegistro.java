package frames;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import parcial2.Usuario;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class PantallaRegistro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JTextField rolField;

	
	public PantallaRegistro() {
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 462, 546);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("Usuario:");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNombre.setBounds(24, 25, 174, 47);
		contentPane.add(lblNombre);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(24, 72, 236, 47);
		contentPane.add(textField);
		
		JLabel lblContrasenia = new JLabel("Contrasenia:");
		lblContrasenia.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblContrasenia.setBounds(24, 129, 174, 47);
		contentPane.add(lblContrasenia);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(24, 174, 236, 45);
		contentPane.add(passwordField);
		
		JLabel lblError = new JLabel("");
		lblError.setForeground(new Color(255, 0, 0));
		lblError.setBounds(24, 333, 236, 13);
		contentPane.add(lblError);
		
		JButton btnIngresar = new JButton("Iniciar Sesion");
		btnIngresar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnIngresar.setBounds(24, 403, 236, 37);
		contentPane.add(btnIngresar);
		
		JLabel lblRol = new JLabel("Rol:");
		lblRol.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblRol.setBounds(24, 229, 174, 47);
		contentPane.add(lblRol);
		
		rolField = new JTextField();
		rolField.setBounds(24, 274, 236, 49);
		contentPane.add(rolField);
		rolField.setColumns(10);
		
		JButton btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String respuesta = Usuario.Registrarse(textField.getText(), passwordField.getText(), rolField.getText());
				if (respuesta.equals("cliente")) {
				    // Cliente
				    Home home = new Home(textField.getText());
				    dispose(); 
				} else if (respuesta.equals("gerente")) {
				    // Gerente
					Admin admin = new Admin(textField.getText());
					//Lo de abajo meterlo en el menu de admin
				    TablaUsuarios usuarios = new TablaUsuarios();
				    dispose(); 
				} else if (respuesta.equals("empleado")) {
				    // Empleado
				    Empleado empleado = new Empleado(textField.getText());
				    dispose(); 
				} else {
				   
				    lblError.setText(respuesta);
				    lblError.setVisible(true);
				}	
				
			}
		});
		btnRegistrarse.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnRegistrarse.setBounds(24, 356, 236, 37);
		contentPane.add(btnRegistrarse);
		
		
	}
}
