package entidades;

import java.io.Serializable;

public class Fecha implements Serializable{

	private static final long serialVersionUID = 8799656478674716611L;
	private int dia;
	private int mes;
	private int year;
	
	//CONSTRUCTOR DE FECHA
	public Fecha(int dia, int mes, int year) {
		this.setDia(dia);
		this.setMes(mes);
		this.setYear(year);
	}
	
	//CONSTRUCTOR DE COPIA
	public Fecha(Fecha f) {
		this.setDia(f.getDia());
		this.setMes(f.getMes());
		this.setYear(f.getYear());	
	}

	//GETTERS AND SETTERS
	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
	//METODOS
	@Override
	//METODO TOSTRING
	public String toString() {
		return(dia+"/"+mes+"/"+year);
	}
	
	//METODO PARA SABER LA DIFERENCIA ENTRE DOS FECHAS
	public static int diferencia(Fecha f1, Fecha f2) {
		
		int tiempo1=(365*f1.getYear()-1)+30*f1.getMes()+f1.getDia();
		int tiempo2=(365*f2.getYear()-1)+30*f2.getMes()+f2.getDia();
		
		return tiempo2-tiempo1;
		
	}
	
	
	
	
	
	
	
	
	
}
