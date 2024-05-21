package parcial2;

import javax.swing.JOptionPane;

public class Compra {
    private Producto productoComprado;
    private int cantidad;
    private double precioTotal;

    // Constructor
    public Compra(Producto productoComprado, int cantidad) {
        this.productoComprado = productoComprado;
        this.cantidad = cantidad;
        this.precioTotal = productoComprado.getPrecio() * cantidad;
    }

    // Getters y Setters
    public Producto getProductoComprado() {
        return productoComprado;
    }

    public void setProductoComprado(Producto productoComprado) {
        this.productoComprado = productoComprado;
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

    // Método para realizar una compra
    public static void realizarCompra(Cliente cliente) {
        Producto.verProductos(); // Mostrar lista de productos disponibles
        String nombreProducto = JOptionPane.showInputDialog("Ingrese el nombre del producto que desea comprar:");
        Producto productoSeleccionado = null;

        // Buscar el producto en la lista de productos
        for (Producto producto : Producto.getListaProductos()) {
            if (producto.getNombre().equalsIgnoreCase(nombreProducto)) {
                productoSeleccionado = producto;
                break;
            }
        }

        if (productoSeleccionado != null) {
            int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad que desea comprar:"));

            // Verificar si hay suficiente stock
            if (productoSeleccionado.getStock() >= cantidad) {
            	
                // Realizar la compra
                Compra compra = new Compra(productoSeleccionado, cantidad);
                cliente.agregarCompra(compra);
                JOptionPane.showMessageDialog(null, "Compra realizada con éxito.");
            } else {
                JOptionPane.showMessageDialog(null, "No hay suficiente stock disponible para realizar la compra.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "El producto ingresado no existe.");
        }
    }
}