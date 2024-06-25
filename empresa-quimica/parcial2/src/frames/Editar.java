package frames;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.UsuarioControlador;
import parcial2.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Editar extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField inpNombre;
	private JTextField inpMail;
	private UsuarioControlador controlador = new UsuarioControlador();


	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public Editar(Usuario usuario) {
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setBounds(148, 49, 46, 14);
		contentPane.add(lblNewLabel);
		
		inpNombre = new JTextField();
		inpNombre.setBounds(37, 104, 268, 20);
		contentPane.add(inpNombre);
		inpNombre.setColumns(10);
		inpNombre.setText(usuario.getNombre());
		
		JTextField inpid= new JTextField();
		inpid.setBounds(37, 73, 268, 20);
		contentPane.add(inpid);
		inpid.setColumns(10);
		inpid.setText(usuario.getRol());
		
		JLabel lblNewLabel_1 = new JLabel("Mail");
		lblNewLabel_1.setBounds(148, 106, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		inpMail = new JTextField();
		inpMail.setBounds(37, 131, 268, 20);
		contentPane.add(inpMail);
		inpMail.setColumns(10);
		
		//inpMail.setText(usuario.getEmail());
		inpMail.setText(usuario.getContra());
		
		JLabel lblid = new JLabel("Id usuario :" + usuario.getIdUsuario());
		lblid.setBounds(278, 49, 135, 14);
		contentPane.add(lblid);
		JButton btnNewButton = new JButton("Editar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (usuario.getContra().equals(inpMail.getText())) {
					JOptionPane.showMessageDialog(null, "Debe poner una contrasenia distinta");
				} else {
					usuario.setContra(inpMail.getText());
					usuario.setNombre(inpNombre.getText());;
					usuario.setRol(inpid.getText());;
					
					//Cambie el codigo del minuto 34:58
					
					try {
					    controlador.updateUser(usuario);
					    JOptionPane.showMessageDialog(null, "Usuario actualizado exitosamente");
					    Admin admin = new Admin(usuario.getNombre());
					    dispose();
					} catch (Exception ee) {
					    JOptionPane.showMessageDialog(null, "No se pudo actualizar el usuario: " + ee.getMessage());
					}
					
				}
				
			}
		});
		btnNewButton.setBounds(123, 184, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblError = new JLabel("");
		lblError.setBounds(232, 105, 46, 14);
		contentPane.add(lblError);
		
	
	}
}
