package entidades;

public class Devolucion {

	private Vehiculo vehiculo;
	private int kms;
	private Fecha fecha;
	private Empleado empleado;
	private double precio;
	
	//CONSTRUCTOR DE DEVOLUCIÓN
	public Devolucion(Vehiculo vehiculo, int kms, Fecha fecha, Empleado empleado, double precio) {
		
		this.setVehiculo(vehiculo);
		this.setKms(kms);
		this.setFecha(fecha);
		this.setEmpleado(empleado);
		this.setPrecio(precio);
	}
	

	//CONSTRUCTOR DE COPIA
	public Devolucion(Devolucion d) {
		
		this.setVehiculo(d.getVehiculo());
		this.setKms(d.getKms());
		this.setEmpleado(d.getEmpleado());
		this.setPrecio(d.getPrecio());
	}

	
	//GETTERS AND SETTERS
	public Vehiculo getVehiculo() {
		return vehiculo;
	}
	
	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}
	
	public int getKms() {
		return kms;
	}
	
	public void setKms(int kms) {
		this.kms = kms;
	}
	
	public Fecha getFecha() {
		return fecha;
	}

	public void setFecha(Fecha fecha) {
		this.fecha = fecha;
	}
	
	public Empleado getEmpleado() {
		return empleado;
	}
	
	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
	
	public double getPrecio() {
		return precio;
	}
	
	public void setPrecio(double precio) {
		this.precio = precio;
	}

	
	
	
	
	
	
}
