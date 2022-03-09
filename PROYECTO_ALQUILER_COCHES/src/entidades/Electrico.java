package entidades;

import java.io.Serializable;
import java.util.GregorianCalendar;

public abstract class Electrico extends Vehiculo implements Serializable{

	private static final long serialVersionUID = 8799656478674716638L;
	private String autonomia;
	private String tiempoderecarga;
	
	//CONSTRUCTOR DE ELÉTRICO
	public Electrico(String matricula, String marca, String modelo, Fecha fechadealta, int km,
			Categoria categoria, Oficina oficina, String autonomia, String tiempoderecarga) throws Exception {
	
		super(matricula, marca, modelo, fechadealta, km, categoria, oficina);
		try 
		{
			this.setAutonomia(autonomia);
			this.setTiempoderecarga(tiempoderecarga);
		}
		catch(Exception e) 
		{
			System.out.println("HA HABIDO UN ERROR AL CREAR UN VEHÍCULO ELÉCTRICO "+e.getMessage());
		}
	
	
		
		
	}

	//CONSTRUCTOR DE COPIA
	public Electrico(Electrico e) throws Exception {
		super(e.getMatricula(), e.getMarca(), e.getModelo(), e.getFechadealta(), e.getKm(), e.getCategoria(), e.getOficina());
		this.setAutonomia(e.getAutonomia());
		this.setTiempoderecarga(e.getTiempoderecarga());
	}

	//GETTERS AND SETTERS
	public String getAutonomia() {
		return autonomia;
	}

	public void setAutonomia(String autonomia) {
		this.autonomia = autonomia;
	}

	public String getTiempoderecarga() {
		return tiempoderecarga;
	}

	public void setTiempoderecarga(String tiempoderecarga) {
		this.tiempoderecarga = tiempoderecarga;
	}
	
	
	
	
	
	
	
	
	
	
	
}
