package entidades;

import java.io.Serializable;
import java.util.GregorianCalendar;

public class Moto extends Electrico implements Serializable{

	private static final long serialVersionUID = 8799656478674716613L;
	private String cilindrada;
	private Carnet_de_conducir carnet;
	
	//CONSTRUCTOR DE MOTO
	public Moto(String matricula, String marca, String modelo, Fecha fechadealta, int km, 
			Categoria categoria, Oficina oficina, String autonomia, String tiempoderecarga, 
			String cilindrada, Carnet_de_conducir carnet) throws Exception {
		
		super(matricula, marca, modelo, fechadealta, km, categoria, oficina, autonomia, tiempoderecarga);
		this.setCilindrada(cilindrada);
		this.setCarnet(carnet);
	}


	//CONSTRUCTOR DE COPIA
	public Moto(Moto m) throws Exception {
		super(m.getMatricula(), m.getMarca(), m.getModelo(), m.getFechadealta(), m.getKm(), 
			m.getCategoria(), m.getOficina(), m.getAutonomia(), m.getTiempoderecarga());
		this.setCilindrada(m.getCilindrada());
		this.setCarnet(m.getCarnet());
	}

	
	//GETTERS AND SETTERS
	public String getCilindrada() {
		return cilindrada;
	}


	public void setCilindrada(String cilindrada) {
		this.cilindrada = cilindrada;
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
		return("MATRÍCULA: "+getMatricula()+" | MARCA: "+getMarca()+" | MODELO: "+getModelo()+" | FECHA DE ALTA: "+getFechadealta()+" | KMs: "+getKm()+" | CATEGORIA: "+getCategoria()+" | OFICINA: "+getOficina()+" | AUTONOMÍA: "+getAutonomia()+" | TIEMPO DE RECARGA: "+getTiempoderecarga()+" | CILINDRADA: "+cilindrada+" | CARNET: "+carnet);
	}


	@Override
	/**
	 * CALCULA EL PRECIO DE ALQUILER DE UNA MOTO
	 */
	public double calculaAlquiler(int diferencia) {

		double precio=diferencia*10;	
		precio=(precio*getCategoria().getRecargo())/100;
		precio*=1.15;	
		
		if(getOficina().getAeropuerto().equals("SI")) 
		{
			precio*=1.1;
		}
		
		return precio;
	}
			
}
