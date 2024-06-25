package frames;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

public class Empleado extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	
	public Empleado(String nombre) {
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 530, 433);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Bienvenido Empleado <dynamic>");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 28));
		lblNewLabel.setBounds(21, 10, 476, 38);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1_1 = new JLabel("Funciones:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(39, 285, 142, 28);
		contentPane.add(lblNewLabel_1_1);
		
		JButton btnProduct = new JButton("Ver Productos");
		btnProduct.setBackground(new Color(0, 128, 128));
		btnProduct.setBorderPainted(false);
		btnProduct.setForeground(new Color(255, 255, 255));
		btnProduct.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ProductoTable table = new ProductoTable();
			}
		});
		btnProduct.setBounds(39, 323, 116, 44);
		contentPane.add(btnProduct);
		
		JButton btnCargarVenta = new JButton("Cargar Venta");
		btnCargarVenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				CargarVentaForm form = new CargarVentaForm();
				
			}
		});
		btnCargarVenta.setBackground(new Color(0, 128, 128));
		btnCargarVenta.setBorderPainted(false);
		btnCargarVenta.setForeground(new Color(255, 255, 255));
		btnCargarVenta.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnCargarVenta.setBounds(165, 323, 116, 44);
		contentPane.add(btnCargarVenta);
		
		JLabel lblImagen = new JLabel("");
		lblImagen.setBounds(145, 71, 194, 181);
		contentPane.add(lblImagen);
		
		JLabel lblImage = new JLabel("");
		lblImage.setBounds(130, 71, 194, 181);
		contentPane.add(lblImage);
		
		 // Load the image from the "imagenes" folder
        ImageIcon imgIcon = new ImageIcon(getClass().getResource("/imagenes/employee.png"));
        if (imgIcon.getImageLoadStatus() == MediaTracker.ERRORED) {
            System.err.println("Error loading image");
        } else {
            Image img = imgIcon.getImage().getScaledInstance(lblImage.getWidth(), lblImage.getHeight(), Image.SCALE_SMOOTH);
            lblImage.setIcon(new ImageIcon(img));
        }
	}
}
