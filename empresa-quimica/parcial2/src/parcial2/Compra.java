package parcial2;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JOptionPane;

public class Compra {
	private int idCompra;
	private int idUsuario;
	
	
	public Compra(int idCompra, int idUsuario) {
		super();
		this.idCompra = idCompra;
		this.idUsuario = idUsuario;
	}

	public Compra(int idUsuario) {
		super();
		this.idUsuario = idUsuario;
	}
	
	public int getIdCompra() {
		return idCompra;
	}

	public void setIdCompra(int idCompra) {
		this.idCompra = idCompra;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	
	
	

    
    	
 }