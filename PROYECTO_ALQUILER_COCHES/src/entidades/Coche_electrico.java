package entidades;

import java.io.Serializable;
import java.util.GregorianCalendar;

public class Coche_electrico extends Electrico implements Serializable{

	private static final long serialVersionUID = 8799656478674716636L;
	private int nplazas;
	private String tipo;
	
	//CONSTRUCTOR COCHE EL�CTRICO
	public Coche_electrico(String matricula, String marca, String modelo, Fecha fechadealta, int km,
			Categoria categoria, Oficina oficina, String autonomia, String tiempoderecarga, int nplazas, String tipo) throws Exception {
		super(matricula, marca, modelo, fechadealta, km, categoria, oficina, autonomia, tiempoderecarga);
		
		try 
		{
			this.setNplazas(nplazas);
			this.setTipo(tipo);
		}
		catch(Exception e) 
		{
			System.out.println("HA HABIDO UN ERROR AL CREAR COCHE EL�CTRICO "+e.getMessage());
		}
	}

	//CONSTRUCTOR DE COPIA
	public Coche_electrico(Coche_electrico ce) throws Exception {
		super(ce.getMatricula(), ce.getMarca(), ce.getModelo(), ce.getFechadealta(), ce.getKm(), 
			ce.getCategoria(), ce.getOficina(), ce.getAutonomia(), ce.getTiempoderecarga());
		this.setNplazas(ce.getNplazas());
		this.setTipo(ce.getTipo());
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
		return("MATR�CULA: "+getMatricula()+" | MARCA: "+getMarca()+" | MODELO: "+getModelo()+" | FECHA DE ALTA: "+getFechadealta()+" | KMs: "+getKm()+" | CATEGORIA: "+getCategoria()+" | OFICINA: "+getOficina()+" | AUTONOM�A: "+getAutonomia()+" | TIEMPO DE RECARGA: "+getTiempoderecarga()+" | N�PLAZAS: "+nplazas+" | TIPO: "+tipo);
	}

	@Override
	/**
	 * M�TODO PARA CALCULAR EL ALQUILER DEL COCHE EL�TRICO
	 */
	public double calculaAlquiler(int diferencia) {
		
		double precio=diferencia*50;	
		precio=(precio*getCategoria().getRecargo())/100;
		precio*=1.15;	
		
		if(getOficina().getAeropuerto().equals("SI")) 
		{
			precio*=1.1;
		}
		
		return precio;
	}

	
	
	
	
	
	
	
	
	
	
}
