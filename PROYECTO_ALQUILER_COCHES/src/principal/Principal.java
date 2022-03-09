package principal;

import java.util.TreeMap;

import entidades.Cliente;
import entidades.Empleado;
import entidades.Empresa;
import entidades.Oficina;
import entidades.Vehiculo;
import metodos.MetodosInterfazUsuario;
import metodosprograma.Interfazdeusuario;

public class Principal 
{

	public static void main(String[] args) throws Exception 
	{
		// TODO Auto-generated method stub
		
		Empresa e=Empresa.leeEmpresa();

		metodosprograma.Menus.pintaMenuPrincipal(e);
	}

}