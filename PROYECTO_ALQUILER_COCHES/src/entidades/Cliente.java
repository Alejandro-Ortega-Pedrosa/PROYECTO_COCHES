package entidades;

import java.io.Serializable;

public class Cliente extends Persona implements Serializable{
	
	private static final long serialVersionUID = 8799656478674716634L;
	private String id;
	private Carnet_de_conducir carnet;

	//CONSTRUCTOR DE CLIENTES
	public Cliente(String dni, String nombre, String apellido1, String apellido2, Carnet_de_conducir carnet, String id) throws Exception {
		super(dni, nombre, apellido1, apellido2);
		this.setId(id);
		this.setCarnet(carnet);
		
	}
	
	//CONSTRUCTOR CON LOS ATRIBUTOS DE PERSONA
	public Cliente(String dni, String nombre, String apellido1, String apellido2) throws Exception {
		super(dni, nombre, apellido1, apellido2);
	}

	//CONSTRUCTOR CON SOLO EL DNI
	public Cliente(String dni) throws Exception {
		super(dni);
	}
	
	//CONSTRUCTOR DE COPIA
	public Cliente(Cliente c) throws Exception {
		super(c.getDni(),c.getNombre(),c.getApellido1(),c.getApellido2());
		this.setId(c.getId());
		this.setCarnet(c.getCarnet());
		
	}
	
	//GETTERS AN SETTERS
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Carnet_de_conducir getCarnet() {
		return carnet;
	}

	public void setCarnet(Carnet_de_conducir carnet) {
		this.carnet = carnet;
	}
	
	//METODOS
	@Override
	//METODO TOSTRING
		public String toString() {
			return("DNI: "+getDni()+" | NOMBRE: "+getNombre()+" | APELLIDOS: "+getApellido1()+" "+getApellido2()+" | TIPO DE CARNET: "+carnet+" | Nº TARJETA DE CLIENTE: "+id);
		}
		
	
	
	
	
	
}
