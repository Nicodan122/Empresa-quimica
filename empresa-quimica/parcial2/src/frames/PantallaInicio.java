package frames;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import parcial2.Usuario;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PantallaInicio extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField inpNombre;
	private JPasswordField inpContrasenia;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaInicio frame = new PantallaInicio();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PantallaInicio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 357, 451);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("Usuario:");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNombre.setBounds(55, 23, 174, 47);
		contentPane.add(lblNombre);
		
		inpNombre = new JTextField();
		inpNombre.setBounds(55, 80, 236, 47);
		contentPane.add(inpNombre);
		inpNombre.setColumns(10);
		
		JLabel lblContrasenia = new JLabel("Contrasenia:");
		lblContrasenia.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblContrasenia.setBounds(55, 135, 174, 47);
		contentPane.add(lblContrasenia);
		
		inpContrasenia = new JPasswordField();
		inpContrasenia.setBounds(55, 192, 236, 45);
		contentPane.add(inpContrasenia);
		
		JLabel lblError = new JLabel("Error al ingresar datos");
		lblError.setEnabled(false);
		lblError.setBounds(55, 247, 236, 20);
		contentPane.add(lblError);
		lblError.setVisible(false);
		JButton btnIngresar = new JButton("Iniciar Sesion");
		
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String respuesta = Usuario.iniciarSesionFrame(inpNombre.getText(),inpContrasenia.getText());
				if (respuesta.equals("rol:cliente")) {
				    // Cliente
				    Home home = new Home(inpNombre.getText());
				    dispose(); 
				} else if (respuesta.equals("rol:gerente")) {
				    // Gerente
					
					Admin admin = new Admin(inpNombre.getText());
				
				    dispose(); 
				} else if (respuesta.equals("rol:empleado")) {
				    // Empleado
				    Empleado empleado = new Empleado(inpNombre.getText());
				    dispose(); 
				} else {
				   
				    lblError.setText(respuesta);
				    lblError.setVisible(true);
				}	
			}
		});
		btnIngresar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnIngresar.setBounds(55, 277, 236, 37);
		contentPane.add(btnIngresar);
		
		JButton btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				PantallaRegistro registo = new PantallaRegistro();
				dispose();
			
			}
		});
		btnRegistrarse.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnRegistrarse.setBounds(55, 326, 236, 37);
		contentPane.add(btnRegistrarse);
		
		
	}
}
