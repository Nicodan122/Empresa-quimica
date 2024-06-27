package frames;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import controlador.ControladorCompra;
import controlador.ControladorCompraDetalle;
import parcial2.Compra;
import parcial2.CompraDetalle;
import parcial2.Usuario;

public class VerCompras extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable table;
    private DefaultTableModel model;
    private ControladorCompra controladorCompra;
    private ControladorCompraDetalle controladorCompraDetalle;
    private Compra seleccionada;
    private Usuario usuarioActual;

    public VerCompras(Usuario usuarioActual) {
        this.usuarioActual = usuarioActual;
        this.setVisible(true);
        setTitle("Ver Compras");
        setSize(910, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setLayout(new BorderLayout());

        this.setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 909, 452);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        controladorCompra = new ControladorCompra();
        controladorCompraDetalle = new ControladorCompraDetalle();

        String[] columnNames = {"Id Compra", "Id Usuario"};
        model = new DefaultTableModel(columnNames, 0);
        table = new JTable(model);
        actualizarTabla();
        contentPane.setLayout(null);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(5, 5, 600, 300);
        contentPane.add(scrollPane);

        JButton btnVerDetalles = new JButton("Ver Detalles");
        btnVerDetalles.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                verDetalles();
            }
        });
        btnVerDetalles.setBounds(5, 315, 280, 35);
        contentPane.add(btnVerDetalles);

        ListSelectionModel selectionModel = table.getSelectionModel();
        selectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        selectionModel.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedRow = table.getSelectedRow();
                    if (selectedRow != -1) {
                        int idCompra = (int) table.getValueAt(selectedRow, 0);
                        seleccionada = controladorCompra.getCompraById(idCompra);
                    }
                }
            }
        });
    }

    private void actualizarTabla() {
        model.setRowCount(0);
        List<Compra> compras = controladorCompra.getComprasByUsuarioId(usuarioActual.getIdUsuario());
        for (Compra compra : compras) {
            model.addRow(new Object[] {compra.getIdCompra(), compra.getIdUsuario()});
        }
    }

    private void verDetalles() {
        if (seleccionada != null) {
            List<CompraDetalle> detalles = controladorCompraDetalle.getDetallesByCompraId(seleccionada.getIdCompra());
            StringBuilder detallesMensaje = new StringBuilder();
            double total = 0;
            for (CompraDetalle detalle : detalles) {
                detallesMensaje.append("ID Producto: ").append(detalle.getIdProducto())
                               .append(", Cantidad: ").append(detalle.getCantidad())
                               .append(", Precio: ").append(detalle.getPrecio())
                               .append(", Subtotal: ").append(detalle.getSubtotal())
                               .append("\n");
                total += detalle.getSubtotal();
            }
            detallesMensaje.append("\nTotal: ").append(total);
            JOptionPane.showMessageDialog(this, detallesMensaje.toString(), "Detalles de la Compra", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione una compra.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
