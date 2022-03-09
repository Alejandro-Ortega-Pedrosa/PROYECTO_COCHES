package entidades;

import java.io.Serializable;
import java.util.GregorianCalendar;

public class Empleado extends Persona implements Serializable{

	private static final long serialVersionUID = 8799656478674716639L;
	private Fecha fechadealta;
	private Oficina oficina;

	//CONSTRUCTOR DE EMPLEADO
	public Empleado(String dni, String nombre, String apellido1, String apellido2, Fecha fechadealta, Oficina oficina) throws Exception {
		super(dni, nombre, apellido1, apellido2);
		this.setFechadealta(fechadealta);
		this.setOficina(oficina);
	}
	
	//CONSTRUCTOR CON LOS ATRIBUTOS DE PERSONA
	public Empleado(String dni, String nombre, String apellido1, String apellido2) throws Exception {
		super(dni, nombre, apellido1, apellido2);
	}

	//CONSTRUCTOR CON SOLO EL DNI
	public Empleado(String dni) throws Exception {
		super(dni);
	}
	
	//CONSTRUCTOR DE COPIA
	public Empleado(Empleado e) throws Exception {
		super(e.getDni(),e.getNombre(),e.getApellido1(),e.getApellido2());
		this.setFechadealta(e.getFechadealta());
		this.setOficina(e.getOficina());
	}
		

	//GETTERS AND SETTERS
	public Fecha getFechadealta() {
		return fechadealta;
	}

	public void setFechadealta(Fecha fechadealta) {
		this.fechadealta = fechadealta;
	}

	public Oficina getOficina() {
		return oficina;
	}

	public void setOficina(Oficina oficina) {
		this.oficina = oficina;
	}

	//METODOS
	@Override
	//METODO TOSTRING
	public String toString() {
		return("DNI: "+getDni()+" | NOMBRE: "+getNombre()+" | APELLIDOS: "+getApellido1()+" "+getApellido2()+" | FECHA DE ALTA: "+fechadealta+" | OFICINA: "+oficina);
	}
	
}
