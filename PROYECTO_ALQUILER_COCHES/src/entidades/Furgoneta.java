package entidades;

import java.io.Serializable;
import java.util.GregorianCalendar;

public class Furgoneta extends Combustion implements Serializable{

	private static final long serialVersionUID = 8799656478674716612L;
	private String capacidad;
	private Carnet_de_conducir carnet;
	

	//CONSTRUCTOR DE FURGONETA
	public Furgoneta(String matricula, String marca, String modelo, Fecha fechadealta, int km,
			Categoria categoria, Oficina oficina, int consumo, int potencia, String capacidad, Carnet_de_conducir carnet) throws Exception {
		super(matricula, marca, modelo, fechadealta, km, categoria, oficina, consumo, potencia);
		this.setCapacidad(capacidad);
		this.setCarnet(carnet);
	}

	//CONSTRUCTOR DE COPIA
	public Furgoneta(Furgoneta f) throws Exception {
		super(f.getMatricula(), f.getMarca(), f.getModelo(), f.getFechadealta(), f.getKm(),
			f.getCategoria(), f.getOficina(), f.getConsumo(), f.getPotencia());
		this.setCapacidad(f.getCapacidad());
		this.setCarnet(f.getCarnet());
	}
	
	
	
	//GETTERS AND SETTERS
	public String getCapacidad() {
		return capacidad;
	}



	public void setCapacidad(String capacidad) {
		this.capacidad = capacidad;
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
		return("MATRÍCULA: "+getMatricula()+" | MARCA: "+getMarca()+" | MODELO: "+getModelo()+" | FECHA DE ALTA: "+getFechadealta()+" | KMs: "+getKm()+" | CATEGORIA: "+getCategoria()+" | OFICINA: "+getOficina()+" | CONSUMO: "+getConsumo()+" | POTENCIA: "+getPotencia()+" | CAPACIDAD DE CARGA: "+capacidad+" | CARNET: "+carnet);
	}

	@Override
	/**
	 * CALCULA EL PRECIO DE ALQUILER DE UNA FURGONETA
	 */
	public double calculaAlquiler(int diferencia) {
		
		double precio=diferencia*70;
		
		precio=(precio*getCategoria().getRecargo())/100;
		
		if(getOficina().getAeropuerto().equals("SI")) 
		{
			precio*=1.1;
		}		
		
		return precio;
	}
}
