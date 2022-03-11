package entidades;

import java.io.Serializable;

public class Categoria implements Serializable{

	private static final long serialVersionUID = 8799656478674716633L;
	private String codigo;
	private String descripcion;
	private int recargo;
	
	//CONSTRUCTOR DE CATEGORIA
	public Categoria(String codigo, String descripcion, int recargo) throws Exception {
		this.setCodigo(codigo);
		this.setDescripcion(descripcion);	
		this.setRecargo(recargo);
	}

	//CONSTRUCTOR CON SOLO CODIGO
	public Categoria(String codigo) throws Exception {
		this.setCodigo(codigo);
	}
	
	//CONSTRUCTOR DE COPIA
	public Categoria (Categoria c) throws Exception {
		this.setCodigo(c.getCodigo());
		this.setDescripcion(c.getDescripcion());
		this.setRecargo(c.getRecargo());
	}
	
	
	//GETTERS AND SETTERS
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getRecargo() {
		return recargo;
	}

	public void setRecargo(int recargo) {
		this.recargo = recargo;
	}
	
	@Override
	//METODO TOSTRING
	public String toString() {
		return("CÓDIGO: "+codigo+" | DESCRIPCIÓN: "+descripcion+" | RECARGO %: "+recargo);
	}
	
}
