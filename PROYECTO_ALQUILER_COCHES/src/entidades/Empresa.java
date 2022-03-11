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
	
	
	/**
	 * METODO QUE GRABA LA EMPRESA
	 * @param empresa
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
	
	/**
	 * METODO PARA LEER LA EMPRESA
	 * @return
	 * @throws Exception
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
	
	
	
	
	
	/**
	 * METODO PARA BORRAR UN EMPLEADO DEL TREE
	 * NECESITA UN DNI PARA SABER EL EMPLEADO QUE BORRAR
	 * @param dni
	 */
	public void borraEmpleado(String dni) {
		
		empleados.remove(dni);
	
	}
	
	
	/**
	 * METODO PARA BORRAR UN CLIENTE DEL TREE
	 * NECESITA UN DNI PARA SABER EL CLIENTE QUE BORRAR
	 * @param dni
	 */
	public void borraCliente(String dni) {
		
		clientes.remove(dni);
	}
	
	
	/**
	 * METODO PARA BORRAR UN VEHICULO DEL TREE
	 * NECESITA UNA MATRÍCULA PARA SABER EL VEHÍCULO QUE BORRAR
	 * @param matricula
	 */
	public void borraVehiculo(String matricula) {
			
		vehiculos.remove(matricula);
	}
	
	/**
	 * METODO PARA BORRAR UNA MOTO DEL TREE
	 * NECESITA UNA MATRÍCULA PARA SABER LA MOTO QUE BORRAR
	 * @param matricula
	 */
	public void borraMoto(String matricula) {
			
		motos.remove(matricula);
	}
	
	
	/**
	 * METODO PARA BORRAR UN COCHE ELÉCTRICO DEL TREE
	 * NECESITA UNA MATRÍCULA PARA SABER EL COCHE ELÉCTRICO QUE BORRAR
	 * @param matricula
	 */
	public void borraCocheElectrico(String matricula) {
			
		cocheselectricos.remove(matricula);
	}
	
	
	/**
	 * METODO PARA BORRAR UN COCHE DE COMBUSTIÓN DEL TREE
	 * NECESITA UNA MATRÍCULA PARA SABER EL COCHE DE COMBUSTIÓN QUE BORRAR
	 * @param matricula
	 */
	public void borraCocheCombustion(String matricula) {
			
		cochescombustion.remove(matricula);
	}
	
	
	/**
	 * METODO PARA BORRAR UNA FURGONETA DEL TREE
	 * NECESITA UNA MATRÍCULA PARA SABER LA FURGONETA QUE BORRAR
	 * @param matricula
	 */
	public void borraFurgoneta(String matricula) {
			
		furgonetas.remove(matricula);
	}
	
	/**
	 * METODO PARA BORRAR UNA OFICINA DEL TREE
	 * NECESITA EL CÓDIGO PARA SABER LA OFICINA QUE BORRAR
	 * @param codigo
	 */
	public void borraOficina(String codigo) {
				
		oficinas.remove(codigo);
	}
	
	
	/**
	 * METODO PARA BORRAR UN VEHICULO DEL TREE DE ALQUILADOS
	 * NECESITA UNA MATRÍCULA PARA SABER EL VEHÍCULO QUE BORRAR
	 * @param matricula
	 */
	public void borraVehiculoDeAlquilados(String matricula) {
		
		alquilados.remove(matricula);
	}
	
	
	/**
	 * EL METODO BUSCA UN EMPLEADO POR SU DNI Y LO DEVUELVE
	 * @param dni
	 * @return EMPLEADO
	 */
	public Empleado buscaEmpleado(String dni) {
		
		return empleados.get(dni);
	}
	
	
	/**
	 * EL METODO BUSCA UN CLIENTE POR SU DNI Y LO DEVUELVE
	 * @param dni
	 * @return CLIENTE
	 */
	public Cliente buscaCliente(String dni) {
		
		return clientes.get(dni);
	}
	
	
	/**
	 * EL METODO BUSCA UN VEHÍCULO POR SU MATRICULA Y LO DEVUELVE
	 * @param matricula
	 * @return VEHICULO
	 */
	public Vehiculo buscaVehiculo(String matricula) {
		
		return vehiculos.get(matricula);
	}
	
	
	/**
	 * EL METODO BUSCA UNA MOTO POR SU MATRÍCULA Y LA DEVUELVE
	 * @param matricula
	 * @return MOTO
	 */
	public Moto buscaMoto(String matricula) {
		
		return motos.get(matricula);
	}
	
	
	/**
	 * EL METODO BUSCA UN COCHE DE COMBUSTION POR SU MATRICULA Y LO DEVUELVE
	 * @param matricula
	 * @return COCHE_COMBUSTION
	 */
	public Coche_combustion buscaCocheCombustion(String matricula) {
		
		return cochescombustion.get(matricula);
	}
	
	
	/**
	 * EL METODO BUSCA UN COCHE ELECTRICO POR SU MATRÍCULA Y LO DEVUELVE
	 * @param matricula
	 * @return COCHE_ELECTRICO
	 */
	public Coche_electrico buscaCocheElectrico(String matricula) {
		
		return cocheselectricos.get(matricula);
	}
	
	
	/**
	 * EL METODO BUSCA UNA FURGONETA POR SU MATRÍCULA Y LA DEVUELVE
	 * @param matricula
	 * @return FURGONETA
	 */
	public Furgoneta buscaFurgoneta(String matricula) {
		
		return furgonetas.get(matricula);
	}
	
	
	/**
	 * EL METODO BUSCA UNA OFICINA POR SU CÓDIGO Y LA DEVUELVE
	 * @param codigo
	 * @return OFICINA
	 */
	public Oficina buscaOficina(String codigo) {
		
		return oficinas.get(codigo);
	}
	
	public Alquiler buscaAlquiler(String codigo) {
		
		return alquileres.get(codigo);
	}
	
	/**
	 * AÑADE UN VEHÍCULO AL TREE DE VEHÍCULOS DISPONIBLES
	 * @param e
	 * @throws Exception
	 */
	public void addVehiculo(Empresa e) throws Exception {
		
		int opcion=metodosprograma.Menus.menuElecOComb(); //MENU PARA ELEJIR COMBUSTIÓN O ELÉTRICO
		
		switch (opcion) {
		
			case 1:  //SI ELIJE LA OPCIÓN 1 SE ABRE EL MENÚ PARA ELEGIR VEHÍCULOS DE COMBUSTIÓN
			
				int opcion1=metodosprograma.Menus.menuCombustion(); //MENÚ PARA ELEGIR COCHE O FURGONETA
			
				switch (opcion1) {
			
				case 1: //SI ELIGE LA OPCIÓN 1 ES PARA AÑADIR UN COCHE DE COMBUSTIÓN
					Coche_combustion cc=metodosprograma.Interfazdeusuario.pideDatosCocheCombustion(e); //PIDE DATOS DEL COCHE DE COMBUSTIÓN
					vehiculos.put(cc.getMatricula(), cc); //LO AÑADE A VEHÍCULOS DISPONIBLES
					cochescombustion.put(cc.getMatricula(), cc); //LO AÑADE AL TREE DE COCHES DE COMBUSTION
				break;	

				case 2: //SI ELIGE LA OPCIÓN 2 ES PARA AÑADIR UNA FURGONETA
					Furgoneta f=metodosprograma.Interfazdeusuario.pideDatosFurgoneta(e); //PIDE DATOS DE LA FURGONETA
					vehiculos.put(f.getMatricula(), f); //LA AÑADE A VEHÍCULOS DISPONIBLES
					furgonetas.put(f.getMatricula(), f); //LO AÑADE AL TREE DE FURGONETAS
				break;	

			}
			break;	

			case 2:  //SI ELIJE LA OPCIÓN 1 SE ABRE EL MENÚ PARA ELEGIR VEHÍCULOS DE ELÉCTRICOS
			
				int opcion2=metodosprograma.Menus.menuElectricos(); //MENU PARA ELEGIR COCHE O MOTO
			
				switch (opcion2) {
			
				case 1: //SI ELIGE LA OPCIÓN 1 ES PARA AÑADIR UN COCHE ELÉCTRICO
					Coche_electrico ce=metodosprograma.Interfazdeusuario.pideDatosCocheElectrico(e); //PIDE DATOS DEL COCHE DE COMBUSTIÓN
					vehiculos.put(ce.getMatricula(), ce); //LO AÑADE A VEHÍCULOS DISPONIBLES
					cocheselectricos.put(ce.getMatricula(), ce); //LO AÑADE AL TREE DE COCHES ELÉCTRICOS
				break;	

				case 2: //SI ELIGE LA OPCIÓN 2 ES PARA AÑADIR UNA MOTO
					Moto m=metodosprograma.Interfazdeusuario.pideDatosMoto(e); //PIDE DATOS DE LA FURGONETA
					vehiculos.put(m.getMatricula(), m); //LA AÑADE A VEHÍCULOS DISPONIBLES
					motos.put(m.getMatricula(), m); //LO AÑADE AL TREE DE MOTOS
				break;	

				}
			break;	
		}
		
	}
	
	
	/**
	 * AÑADE UN VEHÍCULO A NO DISPONIBLES NECESITA UN VEHÍCULO Y SU MATRÍCULA
	 * @param v
	 * @param matricula
	 */
	public void addVehiculo(Vehiculo v, String matricula) {
		vehiculos.put(matricula, v);
	}
	
	
	/**
	 * AÑADE UNA MOTO AL TREE DE MOTOS
	 * @param m
	 * @param matricula
	 */
	public void addMoto(Moto m, String matricula) {
		motos.put(matricula, m);
	}
	
	
	/**
	 * AÑADE UNA MOTO AL TREE DE COCHES ELECTRICOS
	 * @param ce
	 * @param matricula
	 */
	public void addCocheElectrico(Coche_electrico ce, String matricula) {
		cocheselectricos.put(matricula, ce);
	}
	
	
	/**
	 * AÑADE UN COCHE DE COMBUSTIÓN AL TREE DE COCHES DE COMBUSTIÓN
	 * @param cc
	 * @param matricula
	 */
	public void addCocheCombustion(Coche_combustion cc, String matricula) {
		cochescombustion.put(matricula, cc);
	}
	
	
	/**
	 * AÑADE UNA FURGONETA AL TREE DE FURGONETAS 
	 * @param f
	 * @param matricula
	 */
	public void addFurgoneta(Furgoneta f, String matricula) {
		furgonetas.put(matricula, f);
	}
	
	
	/**
	 * AÑADE UN VEHÍCULO A NO DISPONIBLES 
	 * @param v
	 * @param matricula
	 */
	public void addVehiculoAlquilado(Vehiculo v, String matricula) {
		alquilados.put(matricula, v);
	}
	
	
	/**
	 * AÑADE UN CLIETE AL TREE DE CLIENTES
	 * @throws Exception
	 */
	public void addCliente() throws Exception{
		
		Cliente c=metodosprograma.Interfazdeusuario.pideDatosCliente();
		
		clientes.put(c.getDni(), c);
		
	}
	
	
	/**
	 * AÑADE UNA OFICINA AL TREE DE OFICINAS
	 * @throws Exception
	 */
	public void addOficina() throws Exception{
		
		Oficina o=metodosprograma.Interfazdeusuario.pideDatosOficina();
		
		oficinas.put(o.getCodigo(), o);
		
	}
	
	
	/**
	 * AÑADE UN EMPLEADO AL TREE DE EMPLEADOS
	 * @param e
	 * @throws Exception
	 */
	public void addEmpleado(Empresa e) throws Exception{
		
		Empleado em=metodosprograma.Interfazdeusuario.pideDatosEmpleado(e);
		
		empleados.put(em.getDni(), em);
		
	}
	
	
	/**
	 * AÑADE UN ALQUILER AL TREE DE ALQUILERES
	 * @param e
	 * @throws Exception 
	 */
	public void addAlquiler(Empresa e) throws Exception {
		
		Alquiler a=metodosprograma.Interfazdeusuario.pideDatosAlquiler(e);
		
		alquileres.put(a.getCodigoalquiler(), a); //TODO PONER EL CÓDIGO DEL ALQUILER
	}
	
	

	/**
	 * PINTA LA LISTA DE CLIENTES
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
		
	
	/**
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
	
	
	/**
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
	
	
	/**
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
	
	
	/**
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
