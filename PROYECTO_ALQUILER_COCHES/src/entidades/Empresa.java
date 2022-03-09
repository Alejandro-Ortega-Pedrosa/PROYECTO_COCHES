package entidades;

import java.util.TreeMap;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map.Entry;



public class Empresa implements Serializable{

	private static final long serialVersionUID = 8799656478674716610L;
	String nombre;
	TreeMap <String, Empleado> empleados=new TreeMap <String, Empleado>();
	TreeMap <String, Cliente> clientes=new TreeMap <String, Cliente>();
	TreeMap <String, Vehiculo> vehiculos=new TreeMap <String, Vehiculo>();
	TreeMap <String, Oficina> oficinas=new TreeMap <String, Oficina>();
	TreeMap <String, Vehiculo> alquilados=new TreeMap <String, Vehiculo>();
	TreeMap <String, Alquiler> alquileres=new TreeMap <String, Alquiler>();
	TreeMap <String, Devolucion> devoluciones=new TreeMap <String, Devolucion>();
	TreeMap <String, Moto> motos=new TreeMap <String, Moto>();
	TreeMap<String, Coche_combustion> cochescombustion=new TreeMap <String, Coche_combustion>();
	TreeMap<String, Coche_electrico> cocheselectricos=new TreeMap <String, Coche_electrico>();
	TreeMap<String, Furgoneta> furgonetas=new TreeMap <String, Furgoneta>();
	
	
	//CONSTRUCTOR DE EMPRESA
	public Empresa(TreeMap <String, Empleado> empleados, TreeMap <String, Cliente> clientes, 
			TreeMap <String, Vehiculo> vehiculos, TreeMap <String, Oficina> oficinas, TreeMap <String, Vehiculo> alquilados,
			TreeMap <String, Alquiler> alquileres, TreeMap <String, Devolucion> devoluciones, 
			TreeMap <String, Moto> motos, TreeMap<String, Coche_combustion> cochescombustion,
			TreeMap<String, Coche_electrico> cocheselectricos, TreeMap<String, Furgoneta> furgonetas) {
		this.setEmpleados(empleados);
		this.setClientes(clientes);
		this.setVehiculos(vehiculos);
		this.setOficinas(oficinas);
		this.setAlquilados(alquilados);
		this.setAlquileres(alquileres);
		this.setDevoluciones(devoluciones);
		this.setMotos(motos);
		this.setCocheselectricos(cocheselectricos);
		this.setCochescombustion(cochescombustion);
		this.setFurgonetas(furgonetas);
		
	}
	
	

	


	//CONSTRUCTOR CON SOLO CLIENTES
	public Empresa(String nombre) {
		this.setNombre(nombre);
		inicializaEmpresa();
	}
	
	//CONSTRUCTOR DE COPIA
	public Empresa (Empresa e) throws Exception {
		this.setEmpleados(e.getEmpleados());
		this.setClientes(e.getClientes());
		this.setVehiculos(e.getVehiculos());
		this.setOficinas(e.getOficinas());
		this.setAlquileres(e.getAlquileres());
		this.setDevoluciones(e.getDevoluciones());
		this.setMotos(e.getMotos());
		this.setCocheselectricos(e.getCocheselectricos());
		this.setCochescombustion(e.getCochescombustion());
		this.setFurgonetas(e.getFurgonetas());
	}
	
	//GETTERS AND SETTERS
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public TreeMap<String, Empleado> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(TreeMap<String, Empleado> empleados) {
		this.empleados = empleados;
	}

	public TreeMap<String, Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(TreeMap<String, Cliente> clientes) {
		this.clientes = clientes;
	}

	public TreeMap<String, Vehiculo> getVehiculos() {
		return vehiculos;
	}

	public void setVehiculos(TreeMap<String, Vehiculo> vehiculos) {
		this.vehiculos = vehiculos;
	}
	
	public TreeMap<String, Oficina> getOficinas() {
		return oficinas;
	}


	public void setOficinas(TreeMap<String, Oficina> oficinas) {
		this.oficinas = oficinas;
	}
	
	public TreeMap<String, Vehiculo> getAlquilados() {
		return alquilados;
	}

	public void setAlquilados(TreeMap<String, Vehiculo> alquilados) {
		this.alquilados = alquilados;
	}
	
	public TreeMap<String, Alquiler> getAlquileres() {
		return alquileres;
	}

	public void setAlquileres(TreeMap<String, Alquiler> alquileres) {
		this.alquileres = alquileres;
	}

	public TreeMap<String, Devolucion> getDevoluciones() {
		return devoluciones;
	}

	public void setDevoluciones(TreeMap<String, Devolucion> devoluciones) {
		this.devoluciones = devoluciones;
	}
	
	public TreeMap<String, Moto> getMotos() {
		return motos;
	}


	public void setMotos(TreeMap<String, Moto> motos) {
		this.motos = motos;
	}


	public TreeMap<String, Coche_combustion> getCochescombustion() {
		return cochescombustion;
	}


	public void setCochescombustion(TreeMap<String, Coche_combustion> cochescombustion) {
		this.cochescombustion = cochescombustion;
	}


	public TreeMap<String, Coche_electrico> getCocheselectricos() {
		return cocheselectricos;
	}


	public void setCocheselectricos(TreeMap<String, Coche_electrico> cocheselectricos) {
		this.cocheselectricos = cocheselectricos;
	}


	public TreeMap<String, Furgoneta> getFurgonetas() {
		return furgonetas;
	}


	public void setFurgonetas(TreeMap<String, Furgoneta> furgonetas) {
		this.furgonetas = furgonetas;
	}

	
	//METODOS
	/*
	 * METODO PARA INICIALIZAR LA EMPRESA
	 */
	private void inicializaEmpresa() {
		empleados=new TreeMap <String, Empleado>();
		clientes=new TreeMap <String, Cliente>();
		vehiculos=new TreeMap <String, Vehiculo>();
		oficinas=new TreeMap <String, Oficina>();
		alquilados=new TreeMap <String, Vehiculo>();
		alquileres=new TreeMap <String, Alquiler>();
		devoluciones=new TreeMap <String, Devolucion>();
		motos=new TreeMap <String, Moto>();
		cochescombustion=new TreeMap <String, Coche_combustion>();
		cocheselectricos=new TreeMap <String, Coche_electrico>();
		furgonetas=new TreeMap <String, Furgoneta>();
	}
	
	
	/* 
	 * METODO PARA GRABAR LA EMPRESA
	 * NECESITA UNA EMPRESA PARA TRABAJAR
	 */
	public static void grabaEmpresa(Empresa empresa) {
		
		FileOutputStream f=null;
		ObjectOutputStream o=null;
		
		try {
			f=new FileOutputStream("empresa.ser");
			o=new ObjectOutputStream(f);
			o.writeObject(empresa);
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println("ERROR AL INTENTAR GRABAR: "+ e.getLocalizedMessage());
		} 
		catch (IOException e) {
			System.out.println("ERROR AL INTENTAR GRABAR: "+ e.getLocalizedMessage());
		}
		
	}
	
	/*
	 * METODO PARA LEER LA EMPRESA
	 */
	public static Empresa leeEmpresa() throws Exception {
		
		Empresa empresa=null;
		File f= new File ("empresa.ser");

		if(f.exists()) 
		{
			try 
			{
				FileInputStream file= new FileInputStream("empresa.ser");
				ObjectInputStream input= new ObjectInputStream(file);
				empresa=(Empresa) input.readObject();
			}
			catch(ClassNotFoundException e) 
			{
				System.out.println("ERROR AL INTENTAR LEER: "+ e.getLocalizedMessage());
			}
			catch(IOException e)
			{
				System.out.println("ERROR AL INTENTAR LEER: "+ e.getLocalizedMessage());
			}
		}
		else 
		{
			empresa=metodosprograma.Interfazdeusuario.pideDatosEmpresa();
			grabaEmpresa(empresa);
		}
		
		return empresa;
	
	}
	
	
	
	
	
	/* METODO PARA BORRAR UN EMPLEADO
	 * BORRA UN EMPLEADO DEL TREE
	 * NECESITA UN DNI PARA BORRARLO
	 */
	public void borraEmpleado(String dni) {
		
		empleados.remove(dni);
	
	}
	
	
	/*
	 * METODO PARA BORRAR UN CLIENTE
	 * BORRA UN CLIENTE DEL TREE
	 * NECESITA UN DNI PARA BORRARLO
	 */
	public void borraCliente(String dni) {
		
		clientes.remove(dni);
	}
	
	
	/*
	 * METODO PARA BORRAR UN VEH�CULO
	 * BORRA UN VEH�CULO DEL TREE 
	 * NECESITA UNA MATR�CULA PARA BORRARLO
	 */
	public void borraVehiculo(String matricula) {
			
		vehiculos.remove(matricula);
	}
	
	/*
	 * METODO PARA BORRAR UN VEH�CULO
	 * BORRA UN VEH�CULO DEL TREE 
	 * NECESITA UNA MATR�CULA PARA BORRARLO
	 */
	public void borraMoto(String matricula) {
			
		motos.remove(matricula);
	}
	
	
	/*
	 * METODO PARA BORRAR UN VEH�CULO
	 * BORRA UN VEH�CULO DEL TREE 
	 * NECESITA UNA MATR�CULA PARA BORRARLO
	 */
	public void borraCocheElectrico(String matricula) {
			
		cocheselectricos.remove(matricula);
	}
	
	
	/*
	 * METODO PARA BORRAR UN VEH�CULO
	 * BORRA UN VEH�CULO DEL TREE 
	 * NECESITA UNA MATR�CULA PARA BORRARLO
	 */
	public void borraCocheCombustion(String matricula) {
			
		cochescombustion.remove(matricula);
	}
	
	
	/*
	 * METODO PARA BORRAR UN VEH�CULO
	 * BORRA UN VEH�CULO DEL TREE 
	 * NECESITA UNA MATR�CULA PARA BORRARLO
	 */
	public void borraFurgoneta(String matricula) {
			
		furgonetas.remove(matricula);
	}
	
	/*
	 * METODO PARA BORRAR UNA OFICINA
	 * BORRA UNA OFICINA DEL TREE
	 * NECESITA EL C�DIGO DE LA OFICINA PARA BORRARLA
	 */
	public void borraOficina(String codigo) {
				
		oficinas.remove(codigo);
	}
	
	
	/*
	 * METODO PARA BORRAR UN VEH�CULO DE LA LISTA DE ALQUILADOS PORQUE DEJA DE ESTAR ALQUILADO
	 * BORRA UN VEH�CULO DEL TREE
	 * NECESITA LA MATR�CULA DEL VEH�CULO QUE SE VA A BORRAR
	 */
	public void borraVehiculoDeAlquilados(String matricula) {
		
		alquilados.remove(matricula);
	}
	
	
	/*
	 * METODO PARA BUSCAR UN EMPLEADO
	 * DEVUELVE UN EMPLEADO SI LO ENCUENTRA SI NO DEVUELVE NULL
	 */
	public Empleado buscaEmpleado(String dni) {
		
		return empleados.get(dni);
	}
	
	
	/*
	 * METODO PARA BUSCAR UN CLIENTE
	 * DEVUELVE EL CLIENTE SI LO ENCUENTRA SI NO DEVUELVE NULL
	 * LO BUSCA POR EL DNI
	 */
	public Cliente buscaCliente(String dni) {
		
		return clientes.get(dni);
	}
	
	
	/*
	 * METODO PARA BUSCAR UN VEH�CULO
	 * DEVUELVE EL VEH�CULO SI LO ENCUENTRA SI NO DEVUELVE UN NULL
	 * LO BUSCA POR LA MATR�CULA
	 */
	public Vehiculo buscaVehiculo(String matricula) {
		
		return vehiculos.get(matricula);
	}
	
	
	/*
	 * METODO PARA BUSCAR UN VEH�CULO
	 * DEVUELVE EL VEH�CULO SI LO ENCUENTRA SI NO DEVUELVE UN NULL
	 * LO BUSCA POR LA MATR�CULA
	 */
	public Moto buscaMoto(String matricula) {
		
		return motos.get(matricula);
	}
	
	
	/*
	 * METODO PARA BUSCAR UN VEH�CULO
	 * DEVUELVE EL VEH�CULO SI LO ENCUENTRA SI NO DEVUELVE UN NULL
	 * LO BUSCA POR LA MATR�CULA
	 */
	public Coche_combustion buscaCocheCombustion(String matricula) {
		
		return cochescombustion.get(matricula);
	}
	
	
	/*
	 * METODO PARA BUSCAR UN VEH�CULO
	 * DEVUELVE EL VEH�CULO SI LO ENCUENTRA SI NO DEVUELVE UN NULL
	 * LO BUSCA POR LA MATR�CULA
	 */
	public Coche_electrico buscaCocheElectrico(String matricula) {
		
		return cocheselectricos.get(matricula);
	}
	
	
	/*
	 * METODO PARA BUSCAR UN VEH�CULO
	 * DEVUELVE EL VEH�CULO SI LO ENCUENTRA SI NO DEVUELVE UN NULL
	 * LO BUSCA POR LA MATR�CULA
	 */
	public Furgoneta buscaFurgoneta(String matricula) {
		
		return furgonetas.get(matricula);
	}
	
	
	/*
	 * METODO PARA BUSCAR UNA OFICINA
	 * DEVUELVE UNA OFICINA
	 * LA BUSCA POR SU C�DIGO
	 */
	public Oficina buscaOficina(String codigo) {
		
		return oficinas.get(codigo);
	}
	
	public Alquiler buscaAlquiler(String codigo) {
		
		return alquileres.get(codigo);
	}
	
	/*
	 * A�ADE VEH�CULOS AL TREE DE VEH�CULOS DISPONIBLES
	 */
	public void addVehiculo(Empresa e) throws Exception {
		
		int opcion=metodosprograma.Menus.menuElecOComb(); //MENU PARA ELEJIR COMBUSTI�N O EL�TRICO
		
		switch (opcion) {
		
			case 1:  //SI ELIJE LA OPCI�N 1 SE ABRE EL MEN� PARA ELEGIR VEH�CULOS DE COMBUSTI�N
			
				int opcion1=metodosprograma.Menus.menuCombustion(); //MEN� PARA ELEGIR COCHE O FURGONETA
			
				switch (opcion1) {
			
				case 1: //SI ELIGE LA OPCI�N 1 ES PARA A�ADIR UN COCHE DE COMBUSTI�N
					Coche_combustion cc=metodosprograma.Interfazdeusuario.pideDatosCocheCombustion(e); //PIDE DATOS DEL COCHE DE COMBUSTI�N
					vehiculos.put(cc.getMatricula(), cc); //LO A�ADE A VEH�CULOS DISPONIBLES
					cochescombustion.put(cc.getMatricula(), cc); //LO A�ADE AL TREE DE COCHES DE COMBUSTION
				break;	

				case 2: //SI ELIGE LA OPCI�N 2 ES PARA A�ADIR UNA FURGONETA
					Furgoneta f=metodosprograma.Interfazdeusuario.pideDatosFurgoneta(e); //PIDE DATOS DE LA FURGONETA
					vehiculos.put(f.getMatricula(), f); //LA A�ADE A VEH�CULOS DISPONIBLES
					furgonetas.put(f.getMatricula(), f); //LO A�ADE AL TREE DE FURGONETAS
				break;	

			}
			break;	

			case 2:  //SI ELIJE LA OPCI�N 1 SE ABRE EL MEN� PARA ELEGIR VEH�CULOS DE EL�CTRICOS
			
				int opcion2=metodosprograma.Menus.menuElectricos(); //MENU PARA ELEGIR COCHE O MOTO
			
				switch (opcion2) {
			
				case 1: //SI ELIGE LA OPCI�N 1 ES PARA A�ADIR UN COCHE EL�CTRICO
					Coche_electrico ce=metodosprograma.Interfazdeusuario.pideDatosCocheElectrico(e); //PIDE DATOS DEL COCHE DE COMBUSTI�N
					vehiculos.put(ce.getMatricula(), ce); //LO A�ADE A VEH�CULOS DISPONIBLES
					cocheselectricos.put(ce.getMatricula(), ce); //LO A�ADE AL TREE DE COCHES EL�CTRICOS
				break;	

				case 2: //SI ELIGE LA OPCI�N 2 ES PARA A�ADIR UNA MOTO
					Moto m=metodosprograma.Interfazdeusuario.pideDatosMoto(e); //PIDE DATOS DE LA FURGONETA
					vehiculos.put(m.getMatricula(), m); //LA A�ADE A VEH�CULOS DISPONIBLES
					motos.put(m.getMatricula(), m); //LO A�ADE AL TREE DE MOTOS
				break;	

				}
			break;	
		}
		
	}
	
	
	/*
	 * A�ADE VEH�CULOS A NO DISPONIBLES
	 * PARA ELLO NECESITA UN VEH�CULO Y SU MATRICULA
	 */
	public void addVehiculo(Vehiculo v, String matricula) {
		vehiculos.put(matricula, v);
	}
	
	
	/*
	 * A�ADE UNA MOTO AL TREE DE MOTOS
	 * PARA ELLO NECESITA UNA MOTO Y SU MATRICULA
	 */
	public void addMoto(Moto m, String matricula) {
		motos.put(matricula, m);
	}
	
	
	/*
	 * A�ADE UN COCHE EL�CTRICO AL TREE DE COCHES ELECTRICOS
	 * PARA ELLO NECESITA UN COCHE EL�CTRICO Y SU MATRICULA
	 */
	public void addCocheElectrico(Coche_electrico ce, String matricula) {
		cocheselectricos.put(matricula, ce);
	}
	
	
	/*
	 * A�ADE UN COCHE DE COMBUSTI�N AL TREE DE COCHES DE COMBUSTI�N
	 * PARA ELLO NECESITA UN COCHE DE COMBUSTI�N Y SU MATRICULA
	 */
	public void addCocheCombustion(Coche_combustion cc, String matricula) {
		cochescombustion.put(matricula, cc);
	}
	
	
	/*
	 * A�ADE UNA FURGONETA AL TREE DE FURGONETAS
	 * PARA ELLO NECESITA UNA FURGONETA Y SU MATRICULA
	 */
	public void addFurgoneta(Furgoneta f, String matricula) {
		furgonetas.put(matricula, f);
	}
	/*
	 * A�ADE VEH�CULOS A NO DISPONIBLES
	 * PARA ELLO NECESITA UN VEH�CULO Y SU MATRICULA
	 */
	public void addVehiculoAlquilado(Vehiculo v, String matricula) {
		alquilados.put(matricula, v);
	}
	
	
	/*
	 * A�ADE CLIENTES AL TREE DE EMPRESA
	 * PARA ELLO LLAMA AL METODO DE PIDEDATOSCLIENTE
	 */
	public void addCliente() throws Exception{
		
		Cliente c=metodosprograma.Interfazdeusuario.pideDatosCliente();
		
		clientes.put(c.getDni(), c);
		
	}
	
	
	/*
	 * A�ADE OFICINAS AL TREE DE EMPRESA
	 * PARA ELLO LLAMA AL METODO DE PIDEDATOSOFICINA
	 */
	public void addOficina() throws Exception{
		
		Oficina o=metodosprograma.Interfazdeusuario.pideDatosOficina();
		
		oficinas.put(o.getCodigo(), o);
		
	}
	
	
	/*
	 * A�ADE EMPLEADOS AL TREE DE EMPRESA
	 * PARA ELLO LLAMA AL METODO DE PIDEDATOSEMPLEADO
	 */
	public void addEmpleado(Empresa e) throws Exception{
		
		Empleado em=metodosprograma.Interfazdeusuario.pideDatosEmpleado(e);
		
		empleados.put(em.getDni(), em);
		
	}
	
	
	/**
	 * A�ADE UN ALQUILER AL TREE DE ALQUILERES
	 * @param e
	 * @throws Exception 
	 */
	public void addAlquiler(Empresa e) throws Exception {
		
		Alquiler a=metodosprograma.Interfazdeusuario.pideDatosAlquiler(e);
		
		alquileres.put(a.getCodigoalquiler(), a); //TODO PONER EL C�DIGO DEL ALQUILER
	}
	
	
	/*
	 * PINTA LISTA DE CLIENTES 
	 */
	public void pintaListadeClientes() 
	{
		for(Entry<String, Cliente> item: clientes.entrySet()) 
		{
			String dni = item.getKey();
			Cliente cliente = item.getValue();
			System.out.println(cliente);
			
		}
	}
		
	
	/*
	 * PINTA LISTA DE EMPLEADOS 
	 */
	public void pintaListadeEmpleados() 
	{
		for(Entry<String, Empleado> item: empleados.entrySet()) 
		{
			String dni = item.getKey();
			Empleado empleado = item.getValue();
			System.out.println(empleado);
		}
	}
	
	
	/*
	 * PINTA LISTA DE VEHICULOS DISPONIBLES
	 */
	public void pintaListadeVehiculos() 
	{
		for(Entry<String, Vehiculo> item: vehiculos.entrySet()) 
		{
			String matricula = item.getKey();
			Vehiculo vehiculo = item.getValue();
			System.out.println(vehiculo);
		}
	}
	
	
	/*
	 * PINTA LISTA DE VEHICULOS DE UNA CATEGOR�A
	 */
	public void pintaListadeVehiculosPorCategoria(String codigo) 
	{
		for(Entry<String, Vehiculo> item: vehiculos.entrySet()) 
		{
			String matricula = item.getKey();
			Vehiculo vehiculo = item.getValue();
			
			//if(vehiculo.getCategoria().getCodigo().compareToIgnoreCase(codigo)==0) {
				
				System.out.println(vehiculo); //PINTA LOS VEH�CULOS DE UNA SOLA CATEGOR�A
			//}
		
		}
	}
	
	
	/*
	 * PINTA LISTA DE VEHICULOS POR OFICINA
	 */
	public void pintaListadeVehiculosPorOficina(String codigo) 
	{
		for(Entry<String, Vehiculo> item: vehiculos.entrySet()) 
		{
			String matricula = item.getKey();
			Vehiculo vehiculo = item.getValue();
			
			if(vehiculo.getOficina().getCodigo().compareToIgnoreCase(codigo)==0) {
				
				System.out.println(vehiculo); //PINTA LOS VEH�CULOS DE UNA SOLA OFICINA
			}
		}
	}
	
	
	/*
	 * PINTA LISTA DE VEHICULOS NO DISPONIBLES
	 */
	public void pintaListadeVehiculosNoDisponibles() 
	{
		for(Entry<String, Vehiculo> item: alquilados.entrySet()) 
		{
			String matricula = item.getKey();
			Vehiculo vehiculo = item.getValue();
			System.out.println(vehiculo);
		}
	}
	
	
	/*
	 * PINTA LISTA DE OFICINAS
	 */
	public void pintaListadeOficinas() 
	{
		for(Entry<String, Oficina> item: oficinas.entrySet()) 
		{
			String codigo= item.getKey();
			Oficina oficina = item.getValue();
			System.out.println(oficina);
			
		}
	}
	
	
}
