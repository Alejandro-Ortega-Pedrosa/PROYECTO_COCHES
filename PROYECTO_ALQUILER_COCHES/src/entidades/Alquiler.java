package entidades;

import java.io.Serializable;
import java.util.GregorianCalendar;
import java.util.TreeMap;

public class Alquiler implements Serializable{

	private static final long serialVersionUID = 8799656478674716631L;
	private String codigoalquiler;
	private Vehiculo vehiculo;
	private Empleado empleado;
	private Cliente cliente;
	private Oficina oficina;
	private Fecha fechaalquiler;
	private Fecha devolucionprevista;
	private double precio;
	
	//CONSTRUCTOR DE ALQUILER
	public Alquiler(String codigoalquiler, Vehiculo vehiculo, Cliente cliente, Empleado empleado, Oficina oficina, Fecha fechaalquiler, Fecha devolucionprevista, double precio) {
		this.setCodigoalquiler(codigoalquiler);
		this.setVehiculo(vehiculo);
		this.setEmpleado(empleado);
		this.setCliente(cliente);
		this.setOficina(oficina);
		this.setFechaalquiler(fechaalquiler);
		this.setDevolucionprevista(devolucionprevista);
		this.setPrecio(precio);
	}


	//CONSTRUCTOR DE COPIA
	public Alquiler (Alquiler a) throws Exception {
		this.setCodigoalquiler(a.getCodigoalquiler());
		this.setVehiculo(a.getVehiculo());
		this.setEmpleado(a.getEmpleado());
		this.setCliente(a.getCliente());
		this.setOficina(a.getOficina());
		this.setFechaalquiler(a.getFechaalquiler());
		this.setDevolucionprevista(a.getDevolucionprevista());
		this.setPrecio(a.getPrecio());
	}
		
		
	//GETTERS AND SETTERS
	public String getCodigoalquiler() {
		return codigoalquiler;
	}

	public void setCodigoalquiler(String codigoalquiler) {
		this.codigoalquiler = codigoalquiler;
	}
	
	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Oficina getOficina() {
		return oficina;
	}

	public void setOficina(Oficina oficina) {
		this.oficina = oficina;
	}

	public Fecha getFechaalquiler() {
		return fechaalquiler;
	}

	public void setFechaalquiler(Fecha fechaalquiler) {
		this.fechaalquiler = fechaalquiler;
	}

	public Fecha getDevolucionprevista() {
		return devolucionprevista;
	}

	public void setDevolucionprevista(Fecha devolucionprevista) {
		this.devolucionprevista = devolucionprevista;
	}
	
	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
		
	
	
	//METODOS
	@Override
	//METODO TOSTRING
	public String toString() {
		return("VEHÍCULO: "+vehiculo+" | EMPLEADO: "+empleado+" | CLIENTE: "+cliente+" | OFICINA: "+oficina+" | FECHA DE ALQUILER: "+fechaalquiler+" | FECHA DE ENTREGA PREVISTA: "+devolucionprevista);
	}

	
	
	
}
