package metodosArray;

import java.util.ArrayList;
import java.util.TreeMap;

import entidades.Empresa;
import entidades.Vehiculo;

public class ArrayMetodos {

	/**
	 * METODO QUE CREA UN ARRAY DE VEH�CULOS DEVUELVE EL ARRAY
	 * @param e
	 * @return ARRAYLIST DE VEH�CULOS
	 */
	public static ArrayList creaArrayVehiculos(Empresa e) {
		
		ArrayList<Vehiculo> ArrayVehiculos=new ArrayList<Vehiculo>(e.getVehiculos().values());
		
		return ArrayVehiculos;
	}
	
	
	/**
	 * PINTA EL ARRAY DE VEH�CULOS SEG�N SU CATEGOR�A
	 * @param e
	 * @param codigo
	 */
	public static void pintaVehiculosPorCategoria(Empresa e, String codigo) {
		
		ArrayList <Vehiculo> Array=creaArrayVehiculos(e);		
		
		for(int i=0;i<Array.size();i++) 
		{
			if(Array.get(i).getCategoria().getCodigo().equalsIgnoreCase(codigo)) 
			{
				System.out.println(Array.get(i));
			}
		}
		
	}
	
	
	/**
	 * PINTA EL ARRAY DE VEH�CULOS SEG�N SU OFICINA
	 * @param e
	 * @param codigo
	 */
	public static void pintaVehiculosPorOficina(Empresa e, String codigo) {
		
		ArrayList <Vehiculo> Array=creaArrayVehiculos(e);		
		
		for(int i=0;i<Array.size();i++) 
		{
			if(Array.get(i).getOficina().getCodigo().equalsIgnoreCase(codigo)) 
			{
				System.out.println(Array.get(i));
			}
		}
		
	}
	
	
	
	
	
	
}
