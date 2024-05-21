package parcial2;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;


public class Producto {
	private String nombre;
	private double precio;
	private String descripcion;
	private int nivel;
	private int stock;
	private static List<Producto> listaProductos = new ArrayList<>();
	
	public Producto(String nombre, double precio, String descripcion, int nivel, int stock) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.descripcion = descripcion;
		this.nivel = nivel;
		this.stock = stock;
		
		listaProductos.add(this);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
	
	
	
	
    public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public static List<Producto> getListaProductos() {
        return listaProductos;
    }
    
    public static void agregarProducto(Producto producto) {
        listaProductos.add(producto);
    }
    

    public static void verProductos() {
        StringBuilder mensaje = new StringBuilder("Lista de productos:\n");
        for (Producto producto : listaProductos) {
            mensaje.append("Nombre: ").append(producto.getNombre()).append(", ")
                   .append("Precio: ").append(producto.getPrecio()).append(", ")
                   .append("Descripción: ").append(producto.getDescripcion()).append(", ")
                   .append("Nivel: ").append(producto.getNivel()).append("\n");
        }
        JOptionPane.showMessageDialog(null, mensaje.toString());
    }


    
    
    
}
	
	
	 
	

	
	

