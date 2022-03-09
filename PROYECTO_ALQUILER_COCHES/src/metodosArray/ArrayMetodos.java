package metodosArray;

import java.util.ArrayList;
import java.util.TreeMap;

import entidades.Empresa;
import entidades.Vehiculo;

public class ArrayMetodos {

	public static ArrayList creaArrayVehiculos(Empresa e) {
		
		ArrayList<Vehiculo> ArrayVehiculos=new ArrayList<Vehiculo>(e.getVehiculos().values());
		
		return ArrayVehiculos;
	}
	
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
