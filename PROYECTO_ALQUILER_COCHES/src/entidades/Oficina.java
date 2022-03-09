package entidades;

import java.io.Serializable;

public class Oficina implements Comparable<Oficina>, Serializable{

	private static final long serialVersionUID = 8799656478674716614L;
	private String codigo;
	int lcod=10;
	private String descripcion;
	int ldesc=30;
	private String localidad;
	int lloc=30;
	private String provincia;
	int lprov=30;
	private String aeropuerto;
	int laeropuerto=10;
	
	//CONSTRUCTORES DE OFICINA
	//CONSTRUCTOR DE TODAS LAS PROPIEDADES
	public Oficina(String codigo, String descripcion, String localidad, String provincia, String aeropuerto) throws Exception {
		this.setCodigo(codigo);
		this.setDescripcion(descripcion);
		this.setLocalidad(localidad);
		this.setProvincia(provincia);
		this.setAeropuerto(aeropuerto);
	}
	
	//CONSTRUCTOR CON SOLO EL DNI
	public Oficina(String codigo) throws Exception {
		this.setCodigo(codigo);
	}
	
	//CONSTRUCTOR DE COPIA
	public Oficina (Oficina o) throws Exception {
		this.setCodigo(o.getCodigo());
		this.setDescripcion(o.getDescripcion());
		this.setLocalidad(o.getLocalidad());
		this.setProvincia(o.getProvincia());
		this.setAeropuerto(o.getAeropuerto());
	}

	//GETTERS AND SETTERS
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) throws Exception {
		if(codigo.length()<=lcod) 
		{
			this.codigo = codigo;
		}
		else 
		{
			throw new Exception("LONGITUD DE DATO EXCESIVA");
		}	
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) throws Exception {
		if(descripcion.length()<=ldesc) 
		{
			this.descripcion = descripcion;
		}
		else 
		{
			throw new Exception("LONGITUD DE DATO EXCESIVA");
		}
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) throws Exception {
		if(localidad.length()<=lloc) 
		{
			this.localidad = localidad;
		}
		else 
		{
			throw new Exception("LONGITUD DE DATO EXCESIVA");
		}	
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) throws Exception {
		if(provincia.length()<=lprov) 
		{
			this.provincia = provincia;
		}
		else 
		{
			throw new Exception("LONGITUD DE DATO EXCESIVA");
		}	
	}

	public String getAeropuerto() {
		return aeropuerto;
	}

	public void setAeropuerto(String aeropuerto) throws Exception {
		if(aeropuerto.length()<=laeropuerto) 
		{
			this.aeropuerto = aeropuerto;
		}
		else 
		{
			throw new Exception("LONGITUD DE DATO EXCESIVA");
		}	
	}
	
	@Override
	//METODO TOSTRING
	public String toString() {
		return("CÓDIGO: "+codigo+" | DESCRIPCIÓN: "+descripcion+" | LOCALIDAD: "+localidad+" | PROVINCIA: "+provincia+" | EN AEROPUERTO: "+aeropuerto);
	}
	
	@Override
	//METODO EQUALS
	public boolean equals(Object obj) {
		
		Oficina guest=(Oficina) obj;
		
		if(this.codigo.equals(codigo)) 
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	
	@Override
	//METODO COMPARETO PARA ORDENAR POR LOCALIDAD
	public int compareTo(Oficina o) {
		
		return this.localidad.compareToIgnoreCase(o.localidad);
		
	}
	
}
