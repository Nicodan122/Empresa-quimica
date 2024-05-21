package parcial2;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Ventas {
    private String producto;
    private int cantidad;
    private double precioTotal;
    private String fecha;
    private static List<Ventas> listaVentas = new ArrayList<>();

    public Ventas(String producto, int cantidad, double precioTotal, String fecha) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.precioTotal = precioTotal;
        this.fecha = fecha;
        
        listaVentas.add(this);
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public static List<Ventas> getListaVentas() {
        return listaVentas;
    }

    public static void agregarVenta(Ventas venta) {
        listaVentas.add(venta);
    }

    public static void verVentas() {
        StringBuilder mensaje = new StringBuilder("Lista de ventas:\n");
        for (Ventas venta : listaVentas) {
            mensaje.append("Productos: ").append(venta.getProducto()).append(", ")
                   .append("Cantidad: ").append(venta.getCantidad()).append(", ")
                   .append("Precio Total: ").append(venta.getPrecioTotal()).append(", ")
                   .append("Fecha: ").append(venta.getFecha()).append("\n");
        }
        JOptionPane.showMessageDialog(null, mensaje.toString());
    }

    public static void registrarVenta() {
        // Ingresar los datos de la venta
        String producto = JOptionPane.showInputDialog("Ingrese el nombre de los productos vendidos:");
        int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad vendida:"));
        double precioTotal = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio total:"));
        String fecha = JOptionPane.showInputDialog("Ingrese la fecha de la venta:");

        // Crear una nueva venta
        Ventas nuevaVenta = new Ventas(producto, cantidad, precioTotal, fecha);

        // Mostrar un mensaje de confirmación
        JOptionPane.showMessageDialog(null, "Venta registrada exitosamente.");
    }
}