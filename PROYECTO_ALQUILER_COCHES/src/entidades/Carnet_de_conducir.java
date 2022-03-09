package entidades;

import java.io.Serializable;

public class Carnet_de_conducir implements Serializable{

	private static final long serialVersionUID = 8799656478674716632L;
	private String tipo;
	int ltipo=5;

	
	//CONSTRUCTORES DE PERSONA
	//CONSTRUCTOR DE TODAS LAS PROPIEDADES
	public Carnet_de_conducir(String tipo) throws Exception {
		this.setTipo(tipo);
	}

	
	//CONSTRUCTOR DE COPIA
	public Carnet_de_conducir(Carnet_de_conducir c) throws Exception {
		this.setTipo(c.getTipo());
	}
	
	
	//GETTERS AND SETTERS
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) throws Exception {
		if(tipo.length()<=ltipo) {
			this.tipo = tipo;
		}
		else
		{
			throw new Exception("LONGITUD DE DATO EXCESIVA");
		}
	}

	//METODOS
	@Override
	//METODO TOSTRING
	public String toString() {
		return(tipo);
	}
		
	
}
