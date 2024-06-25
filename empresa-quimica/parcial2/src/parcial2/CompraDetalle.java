package parcial2;

public class CompraDetalle {
	private int idDetalle;
	private int idCompra;
    private int idProducto;
    private int cantidad;
    private double precio;
    private double subtotal;
    
	public CompraDetalle(int idDetalle, int idCompra, int idProducto, int cantidad, double precio, double subtotal) {
		super();
		this.idDetalle = idDetalle;
		this.idCompra = idCompra;
		this.idProducto = idProducto;
		this.cantidad = cantidad;
		this.precio = precio;
		this.subtotal = subtotal;
	}
	

	public CompraDetalle(int idProducto, int cantidad) {
		super();
		this.idProducto = idProducto;
		this.cantidad = cantidad;
	}







	public int getIdDetalle() {
		return idDetalle;
	}



	public void setIdDetalle(int idDetalle) {
		this.idDetalle = idDetalle;
	}



	public int getIdCompra() {
		return idCompra;
	}

	public void setIdCompra(int idCompra) {
		this.idCompra = idCompra;
	}

	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
	
	
    
    
	
	

}
