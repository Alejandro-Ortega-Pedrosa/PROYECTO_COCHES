package entidades;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;

import excepciones.LongitudExcesivaException;

abstract class Persona implements Comparable<Persona>, Serializable{  

	private static final long serialVersionUID = 8799656478674716615L;
	private String dni;
	private String nombre;
	int lnombre=25;
	private String apellido1;
	int lape1=30;
	private String apellido2;
	int lape2=30;
	private GregorianCalendar fecha;
	
	//CONSTRUCTORES DE PERSONA
	//CONSTRUCTOR DE TODAS LAS PROPIEDADES
	public Persona(String dni, String nombre, String apellido1, String apellido2, GregorianCalendar fecha) throws Exception {
		this.setDni(dni);
		this.setNombre(nombre);
		this.setApellido1(apellido1);
		this.setApellido2(apellido2);
		this.setFecha(fecha);
	}
	
	//CONSTRUCTOR CON SOLO EL DNI
	public Persona(String dni) throws Exception {
		this.setDni(dni);
	}
	
	//CONSTRUCTOR CON SOLO EL DNI Y EL NOMBRE COMPLETO
	public Persona(String dni, String nombre, String apellido1, String apellido2) throws Exception {
		this.setDni(dni);
		this.setNombre(nombre);
		this.setApellido1(apellido1);
		this.setApellido2(apellido2);
	}
	

	//CONSTRUCTOR DE COPIA
	public Persona (Persona p) throws Exception {
		this.setDni(p.getDni());
		this.setNombre(p.getNombre());
		this.setApellido1(p.getApellido1());
		this.setApellido2(p.getApellido2());
	}

	//GETTERS AND SETTERS
	public String getDni() {
		return dni;
	}

	private void setDni(String dni) throws Exception {
	if(metodos.MetodosValidadores.validarDni(dni)) {
		this.dni = dni;
	}
	else
	{
		throw new Exception("EL DNI NO ES VÁLIDO");
	}
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) throws Exception {
		if(nombre.length()<=lnombre) 
		{
			this.nombre = nombre;
		}
		else 
		{
			throw new Exception("NOMBRE: "+nombre+" LA LONGITUD MÁXIMA ES "+lnombre);
		}
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) throws Exception {
		if(apellido1.length()<=lape1) 
		{
			this.apellido1 = apellido1;
		}
		else 
		{
			throw new LongitudExcesivaException("APELLIDO 1: "+apellido1+" LA LONGITUD MÁXIMA ES "+lape1);
		}
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) throws Exception {
		if(apellido2.length()<=lape2) 
		{
			this.apellido2 = apellido2;
		}
		else 
		{
			throw new LongitudExcesivaException("APELLIDO 2: "+apellido2+" LA LONGITUD MÁXIMA ES "+lape2);
		}	
	}
	
	public GregorianCalendar getFecha() {
		return fecha;
	}

	public void setFecha(GregorianCalendar fecha) {
		this.fecha = fecha;
	}
	
	
	//METODOS
	
	@Override
	//METODO TOSTRING
	public String toString() {
		return("DNI: "+dni+" | NOMBRE: "+nombre+" | APELLIDOS: "+apellido1+" "+apellido2);
	}
	
	/**
	 * EL MÉTODO DEVUELVE UNA STRING CON EL NOMBRE EN EL FORMATO APELLIDO1+APELLIDO2+NOMBRE
	 * @return
	 */
	public String nombreCompleto() {
	
		String nombreYapellidos=apellido1+" "+apellido2+" "+nombre;
		
		return nombreYapellidos;
		
	}
	
	@Override
	//METODO EQUALS
	public boolean equals(Object obj) {
		
		Persona guest=(Persona) obj;
		
		if(this.dni.equals(dni)) 
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	
	@Override
	//METODO COMPARETO PARA ORDENAR POR ORDEN ALFABÉTICO
	public int compareTo(Persona p) {
		
		return nombreCompleto().compareToIgnoreCase(p.nombreCompleto());
		
	}
	
	//METODO ES CUMPLEAÑOS
	public boolean esCumpleaños(GregorianCalendar fechanacimiento)
	{
		GregorianCalendar FechaActual=new GregorianCalendar();
		int diaActual=FechaActual.get(Calendar.DAY_OF_MONTH);
		int mesActual=FechaActual.get(Calendar.MONTH);
		
		if(diaActual==fechanacimiento.DAY_OF_MONTH && mesActual==fechanacimiento.MONTH)
		{
			return true;
		}
		else
		{
			return false;
		}
	}	
	
	
	
	
	
}
