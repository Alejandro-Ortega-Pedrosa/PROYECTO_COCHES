package entidades;

import java.io.Serializable;
import java.util.GregorianCalendar;

public abstract class Combustion extends Vehiculo implements Serializable{

	private static final long serialVersionUID = 8799656478674716637L;
	private int consumo;
	private int potencia;
	
	//CONSTRUCTOR DE COMBUSTION
	public Combustion(String matricula, String marca, String modelo, Fecha fechadealta, int km, 
			Categoria categoria, Oficina oficina, int consumo, int potencia) throws Exception {
		super(matricula, marca, modelo, fechadealta, km, categoria, oficina);
		this.setConsumo(consumo);
		this.setPotencia(potencia);
	}


	//CONSTRUCTOR DE COPIA
	public Combustion(Combustion c) throws Exception {
		super(c.getMatricula(), c.getMarca(), c.getModelo(), c.getFechadealta(), c.getKm(), c.getCategoria(), c.getOficina());
		this.setConsumo(c.getConsumo());
		this.setPotencia(c.getPotencia());
	}
		

	//GETTERS AND SETTERS
	public int getPotencia() {
		return potencia;
	}



	public void setPotencia(int potencia) {
		this.potencia = potencia;
	}



	public int getConsumo() {
		return consumo;
	}



	public void setConsumo(int consumo) {
		this.consumo = consumo;
	}

}
