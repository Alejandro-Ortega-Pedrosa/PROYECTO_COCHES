package entidades;

import java.io.Serializable;
import java.util.GregorianCalendar;

import excepciones.LongitudExcesivaException;

public abstract class Vehiculo implements Comparable<Vehiculo>, Serializable{

	private static final long serialVersionUID = 8799656478674716616L;
	private String matricula;
	int lmat=7;
	private String marca;
	int lmar=30;
	private String modelo;
	int lmod=25;
	private Fecha fechadealta;
	private int km;
	private Categoria categoria;
	private Oficina oficina;
	
	
	
	//CONSTRUCTORES DE VEHICULO
	//CONSTRUCTOR DE TODAS LAS PROPIEDADES
	public Vehiculo(String matricula, String marca, String modelo, Fecha fechadealta, int km, Categoria categoria, Oficina oficina) throws Exception {
		try 
		{
			this.setMatricula(matricula);
			this.setMarca(marca);
			this.setModelo(modelo);
			this.setFechadealta(fechadealta);
			this.setKm(km);
			this.setCategoria(categoria);
			this.setOficina(oficina);
		}
		catch(Exception e) 
		{
			System.out.println("HA HABIDO UN ERROR AL CREAR VEHÍCULO "+e.getMessage());
		}
	}

	//CONSTRUCTOR CON SOLO LA MATRÍCULA
	public Vehiculo(String matricula) throws Exception {
		this.setMatricula(matricula);
	}
	
	//CONSTRUCTOR DE COPIA
	public Vehiculo (Vehiculo v) throws Exception {
		this.setMatricula(v.getMatricula());
		this.setMarca(v.getMatricula());
		this.setModelo(v.getModelo());
		this.setFechadealta(v.getFechadealta());
		this.setKm(v.getKm());
		this.setCategoria(v.getCategoria());
		this.setOficina(v.getOficina());
	}
	
	
	//GETTERS AND SETTERS
	public String getMatricula() {
		return matricula;
	}



	public void setMatricula(String matricula) throws Exception {
		if(matricula.length()<=lmat) 
		{
			this.matricula = matricula;
		}
		else 
		{
			throw new LongitudExcesivaException("MATRÍCULA: "+matricula+" LA LONGITUD MÁXIMA ES "+lmat);
		}	
	}



	public String getMarca() {
		return marca;
	}



	public void setMarca(String marca) throws Exception {
		if(marca.length()<=lmar) 
		{
			this.marca = marca;
		}
		else 
		{
			throw new LongitudExcesivaException("MARCA: "+marca+" LA LONGITUD MÁXIMA ES "+lmar);
		}	
	}



	public String getModelo() {
		return modelo;
	}



	public void setModelo(String modelo) throws Exception {
		if(modelo.length()<=lmod) 
		{
			this.modelo = modelo;
		}
		else 
		{
			throw new LongitudExcesivaException("MODELO: "+modelo+" LA LONGITUD MÁXIMA ES "+lmod);
		}	
	}



	public Fecha getFechadealta() {
		return fechadealta;
	}



	public void setFechadealta(Fecha fechadealta) {
		this.fechadealta = fechadealta;
	}



	public int getKm() {
		return km;
	}



	public void setKm(int km) {
		this.km = km;
	}



	public Categoria getCategoria() {
		return categoria;
	}



	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}



	public Oficina getOficina() {
		return oficina;
	}



	public void setOficina(Oficina oficina) {
		this.oficina = oficina;
	}
	

	
	//METODOS
	@Override
	//METODO TOSTRING
	public String toString() {
		return("MATRÍCULA: "+matricula+" | MARCA: "+marca+" | MODELO: "+modelo+" | FECHA DE ALTA: "+fechadealta+" | KMs: "+km+" | CATEGORIA: "+categoria+" | OFICINA: "+oficina);
	}
	
	
	@Override
	//METODO EQUALS
	public boolean equals(Object obj) {
		
		Vehiculo guest=(Vehiculo) obj;
		
		if(this.matricula.equals(matricula)) 
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	
	
	@Override
	//METODO COMPARETO PARA ORDENAR POR MARCA
	public int compareTo(Vehiculo v) {
		
		return this.getMarca().compareToIgnoreCase(v.getMarca());
		
	}
	
	
	//METODO PARA CALCULAR EL ALQUILER
	public abstract double calculaAlquiler(int diferencia); 
	
	
	
}
