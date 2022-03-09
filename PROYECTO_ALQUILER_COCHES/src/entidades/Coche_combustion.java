package entidades;

import java.io.Serializable;
import java.util.GregorianCalendar;

public class Coche_combustion extends Combustion implements Serializable{

	private static final long serialVersionUID = 8799656478674716635L;
	private int nplazas;
	private String tipo;
	
	//CONSTRUCTOR DE COCHE DE COMBUSTIÓN
	public Coche_combustion(String matricula, String marca, String modelo, Fecha fechadealta, int km,
			Categoria categoria, Oficina oficina, int consumo, int potencia, int nplazas, String tipo) throws Exception {
		super(matricula, marca, modelo, fechadealta, km, categoria, oficina, consumo, potencia);
		this.setNplazas(nplazas);
		this.setTipo(tipo);
	}


	//CONSTRUCTOR DE COPIA
	public Coche_combustion(Coche_combustion cc) throws Exception {
		super(cc.getMatricula(), cc.getMarca(), cc.getModelo(), cc.getFechadealta(), cc.getKm(),
			cc.getCategoria(), cc.getOficina(), cc.getConsumo(), cc.getPotencia());
		this.setNplazas(cc.getNplazas());
		this.setTipo(cc.getTipo());
	}

	//GETTERS AND SETTERS
	public int getNplazas() {
		return nplazas;
	}



	public void setNplazas(int nplazas) {
		this.nplazas = nplazas;
	}



	public String getTipo() {
		return tipo;
	}



	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	//METODOS
	@Override
	//METODO TOSTRING
	public String toString() {
		return("MATRÍCULA: "+getMatricula()+" | MARCA: "+getMarca()+" | MODELO: "+getModelo()+" | FECHA DE ALTA: "+getFechadealta()+" | KMs: "+getKm()+" | CATEGORIA: "+getCategoria()+" | OFICINA: "+getOficina()+" | CONSUMO: "+getConsumo()+" | POTENCIA: "+getPotencia()+" | NºPLAZAS: "+nplazas+" | TIPO: "+tipo);
	}


	//METODO PARA CALCULAR EL ALQUILER
	@Override
	public double calculaAlquiler(int diferencia) {
		
		double precio=diferencia*50;
		precio*=1+(getCategoria().getRecargo()/100);
		
		if(getOficina().getAeropuerto().equalsIgnoreCase("SI")) 
		{
			precio*=1.1;
		}
		
		return precio;
	}

	
	
	
}
