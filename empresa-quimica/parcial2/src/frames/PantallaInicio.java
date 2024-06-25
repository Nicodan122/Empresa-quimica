package frames;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import parcial2.Usuario;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Image;
import java.awt.MediaTracker;

import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Color;

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
		setBounds(100, 100, 342, 542);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("Usuario:");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNombre.setBounds(47, 155, 174, 47);
		contentPane.add(lblNombre);
		
		inpNombre = new JTextField();
		inpNombre.setBounds(47, 192, 236, 47);
		contentPane.add(inpNombre);
		inpNombre.setColumns(10);
		
		JLabel lblContrasenia = new JLabel("Contrasenia:");
		lblContrasenia.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblContrasenia.setBounds(47, 267, 174, 47);
		contentPane.add(lblContrasenia);
		
		inpContrasenia = new JPasswordField();
		inpContrasenia.setBounds(47, 304, 236, 45);
		contentPane.add(inpContrasenia);
		
		JLabel lblError = new JLabel("Error al ingresar datos");
		lblError.setBackground(new Color(255, 0, 0));
		lblError.setForeground(new Color(255, 0, 0));
		lblError.setFont(new Font("Tahoma", Font.ITALIC, 10));
		lblError.setEnabled(false);
		lblError.setBounds(47, 359, 236, 20);
		contentPane.add(lblError);
		lblError.setVisible(false);
		JButton btnIngresar = new JButton("Iniciar Sesion");
		btnIngresar.setForeground(new Color(255, 255, 255));
		btnIngresar.setBorderPainted(false);
		btnIngresar.setBackground(new Color(0, 128, 128));
		
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
		btnIngresar.setBounds(47, 389, 236, 37);
		contentPane.add(btnIngresar);
		
		JButton btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.setForeground(new Color(255, 255, 255));
		btnRegistrarse.setBackground(new Color(0, 128, 128));
		btnRegistrarse.setBorderPainted(false);
		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				PantallaRegistro registo = new PantallaRegistro();
				dispose();
			
			}
		});
		btnRegistrarse.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnRegistrarse.setBounds(47, 438, 236, 37);
		contentPane.add(btnRegistrarse);
		
		JLabel lblImagen = new JLabel("");
		lblImagen.setBounds(94, 29, 127, 116);
		contentPane.add(lblImagen);
		
		// Load the image from the "imagenes" folder
        ImageIcon imgIcon = new ImageIcon(getClass().getResource("/imagenes/compound.png"));
        if (imgIcon.getImageLoadStatus() == MediaTracker.ERRORED) {
            System.err.println("Error loading image");
        } else {
            Image img = imgIcon.getImage().getScaledInstance(lblImagen.getWidth(), lblImagen.getHeight(), Image.SCALE_SMOOTH);
            lblImagen.setIcon(new ImageIcon(img));
        }
		
		
	}
}
