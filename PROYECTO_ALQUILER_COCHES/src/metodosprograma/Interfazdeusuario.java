package metodosprograma;

import java.util.Scanner;
import java.util.GregorianCalendar;
import java.util.Map.Entry;

import entidades.Alquiler;
import entidades.Carnet_de_conducir;
import entidades.Categoria;
import entidades.Cliente;
import entidades.Coche_combustion;
import entidades.Coche_electrico;
import entidades.Devolucion;
import entidades.Empleado;
import entidades.Empresa;
import entidades.Fecha;
import entidades.Furgoneta;
import entidades.Moto;
import entidades.Oficina;
import entidades.Vehiculo;


public class Interfazdeusuario {

	/**
	 * PIDE LOS DATOS DE LA EMPRESA DEVUELVE UNA EMPRESA
	 * @return EMPRESA
	 * @throws Exception
	 */
	public static Empresa pideDatosEmpresa() throws Exception
	{
		String nombre=metodos.MetodosInterfazUsuario.pideStringValidada("Introduzca el Nombre de la Empresa", 25); //SE PIDE EL NOMBRE DE LA EMPRESA
		
		return new Empresa(nombre);
	
	}
	
	
	/**
	 * PIDE LOS DATOS DE UNA OFICINA Y DEVUELVE UNA OFICINA
	 * @return OFICINA
	 * @throws Exception
	 */
	public static Oficina pideDatosOficina() throws Exception
	{
		
		String aeropuerto="";
		String codigo=metodos.MetodosInterfazUsuario.pideStringValidada("Introduzca el Código de la Oficina", 10); //PIDE EL CÓDIGO DE LA OFICINA
		String descripcion=metodos.MetodosInterfazUsuario.pideStringValidada("Introduzca una Descripción", 30);	//PIDE UNA DESCRIPCIÓN
		String localidad=metodos.MetodosInterfazUsuario.pideStringValidada("Introduzca la Localidad", 30); //PIDE LA LOCALIDAD
		String provincia=metodos.MetodosInterfazUsuario.pideStringValidada("Introduzca la Provincia", 30); //PIDE LA PROVINCIA
		int respuesta=metodosprograma.Menus.menuSiNo("¿Es una Oficina de Aeropuerto?"); //PREGUNTA SI ES DE AEROPUERTO
		
		if(respuesta==1) 
		{
			aeropuerto="SI";
		}
		else
		if(respuesta==2) 
		{
			aeropuerto="NO";
		}
		
		return new Oficina(codigo, descripcion, localidad, provincia, aeropuerto);
	
	}
	

	/**
	 * PIDE LOS DATOS DE UN CLIENTE Y LO DEVUELVE
	 * @return CLIENTE
	 * @throws Exception
	 */
	public static Cliente pideDatosCliente() throws Exception 
	{
			
		String dni=metodos.MetodosValidadores.pideDniCorrecto("Introduce el DNI del Cliente"); //SE PIDE EL DNI DEL CLIENTE
		String nombre=metodos.MetodosInterfazUsuario.pideStringValidada("Introduzca el Nombre", 25); //SE PIDE EL NOMBRE DEL CLIENTE 
		String apellido1=metodos.MetodosInterfazUsuario.pideStringValidada("Introduzca el PRIMER Apellido", 30); //SE PIDE EL PRIMER APELLIDO DEL CLIENTE
		String apellido2=metodos.MetodosInterfazUsuario.pideStringValidada("Introduzca el SEGUNDO Apellido", 30); //SE PIDE EL SEGUNDO APELLIDO DEL CLIENTE
		Carnet_de_conducir carnet=pideCarnet(); //SE PIDE EL TIPO DE CARNET DE EL CLIENTE
		String id=metodos.MetodosInterfazUsuario.pideStringValidada("Introduzca el Código del Cliente", 10); //SE PIDE EL ID DE CLIENTE
		
		
		
		return new Cliente(dni, nombre, apellido1, apellido2, carnet, id);
	
	}
	
	
	/**
	 * PIDE UN CARNET DE CONDUCIR Y LO DEVUELVE
	 * @return CARNET_DE_CONDUCIR
	 * @throws Exception
	 */
	public static Carnet_de_conducir pideCarnet() throws Exception
	{
			
		String tipo=metodos.MetodosInterfazUsuario.pideStringValidada("Introduzca Tipo de Carnet", 6);
		
		return new Carnet_de_conducir(tipo);
	
	}
	
	
	/**
	 * PIDE LOS DATOS DE UN EMPLEADO Y LO DEVUELVE 
	 * @param e
	 * @return EMPLEADO
	 * @throws Exception
	 */
	public static Empleado pideDatosEmpleado(Empresa e) throws Exception
	{
			
		String dni=metodos.MetodosValidadores.pideDniCorrecto("Introduce el DNI del Empleado"); //SE PIDE EL DNI DEL EMPLEADO
		String nombre=metodos.MetodosInterfazUsuario.pideStringValidada("Introduzca el Nombre", 25); //SE PIDE EL NOMBRE DEL EMPLEADO
		String apellido1=metodos.MetodosInterfazUsuario.pideStringValidada("Introduzca el PRIMER Apellido", 30); //SE PIDE EL PRIMER APELLIDO DEL EMPLEADO
		String apellido2=metodos.MetodosInterfazUsuario.pideStringValidada("Introduzca el SEGUNDO Apellido", 30); //SE PIDE EL SEGUNDO APELLIDO DEL EMPLEADO
		System.out.println("INTRODUCE LA FECHA DE ALTA EN LA EMPRESA");
		Fecha fa=new Fecha(pideFecha()); //SE PIDE LA FECHA DE ALTA EN LA EMPRESA
		Oficina o=pideOficinaExiste(e); //SE PIDE UNA OFICINA QUE EXISTE
		
		
		return new Empleado(dni, nombre, apellido1, apellido2, fa, o);
	
	}
	
	
	/**
	 * PIDE LOS DATOS DE UNA MOTO Y LA DEVUELVE
	 * @param e
	 * @return MOTO
	 * @throws Exception
	 */
	public static Moto pideDatosMoto(Empresa e) throws Exception 
	{
		//DATOS DE LOS VEHÍCULOS
		String matricula=metodos.MetodosInterfazUsuario.pideStringValidada("Introduzca la Matricula", 7); //SE PIDE LA MATRÍCULA
		String marca=metodos.MetodosInterfazUsuario.pideStringValidada("Introduzca la Marca", 30); //SE PIDE LA MARCA
		String modelo=metodos.MetodosInterfazUsuario.pideStringValidada("Introduzca el Modelo", 25); //SE PIDE EL MODELO
		System.out.println("INTRODUCE LA FECHA DE ALTA");
		Fecha fa=new Fecha(pideFecha()); //SE PIDE LA FECHA DE ALTA
		int km=metodos.MetodosInterfazUsuario.pideIntValidadoMIN("Introduzca los KM", 0); //SE PIDEN LOS KMS
		Categoria c=pideCategoria();
		Oficina o=pideOficinaExiste(e);
		
		//DATOS DE LOS ELÉCTRICOS
		String autonomia=metodos.MetodosInterfazUsuario.pideStringValidada("Introduzca la Autonomía", 25); //SE PIDE LA AUTONOMÍA
		String tiemporecarga=metodos.MetodosInterfazUsuario.pideStringValidada("Introduzca el Tiempo de Recarga", 25); //SE PIDE EL TIEMPO DE RECARGA
		
		//DATOS DE LA MOTO
		String cilindrada=metodos.MetodosInterfazUsuario.pideStringValidada("Introduce la Cilindrada", 10); //SE PIDE EL CÓDIGO DE LA OFICINA 
		Carnet_de_conducir carnet=pideCarnet(); //SE PIDE EL TIPO DE CARNET NECESARIO
		
		
		
		
		return new Moto(matricula, marca, modelo, fa, km, c, o, autonomia, tiemporecarga, cilindrada, carnet);
	}
	
	
	/**
	 * PIDE LOS DATOS DE UN COCHE ELÉCTRICO Y LO DEVUELVE
	 * @param e
	 * @return COCHE_ELECTRICO
	 * @throws Exception
	 */
	public static Coche_electrico pideDatosCocheElectrico(Empresa e) throws Exception 
	{
		
		//DATOS DE LOS VEHÍCULOS
		String matricula=metodos.MetodosInterfazUsuario.pideStringValidada("Introduzca la Matricula", 7); //SE PIDE LA MATRÍCULA
		String marca=metodos.MetodosInterfazUsuario.pideStringValidada("Introduzca la Marca", 30); //SE PIDE LA MARCA
		String modelo=metodos.MetodosInterfazUsuario.pideStringValidada("Introduzca el Modelo", 25); //SE PIDE EL MODELO
		System.out.println("INTRODUCE LA FECHA DE ALTA");
		Fecha fa=new Fecha(pideFecha()); //SE PIDE LA FECHA DE ALTA
		int km=metodos.MetodosInterfazUsuario.pideIntValidadoMIN("Introduzca los KM", 0); //SE PIDEN LOS KMS
		Categoria c=pideCategoria();
		Oficina o=pideOficinaExiste(e);
				
		//DATOS DE LOS ELÉCTRICOS
		String autonomia=metodos.MetodosInterfazUsuario.pideStringValidada("Introduzca la Autonomía", 25); //SE PIDE LA AUTONOMÍA
		String tiemporecarga=metodos.MetodosInterfazUsuario.pideStringValidada("Introduzca el Tiempo de Recarga", 25); //SE PIDE EL TIEMPO DE RECARGA
				
		//DATOS DEL COCHE ELÉCTRICO
		int nplazas=metodos.MetodosInterfazUsuario.pideIntValidado("Introduzca el Número de Plazas del Coche", 10, 1); //SE PIDE EL NÚMERO DE PLAZAS 
		String tipo=metodos.MetodosInterfazUsuario.pideStringValidada("Introduzca el Tipo de Coche", 15); //SE PIDE EL TIPO DE COCHE
			
		return new Coche_electrico(matricula, marca, modelo, fa, km, c, o, autonomia, tiemporecarga, nplazas, tipo);
	}
	
	
	/**
	 * PIDE LOS DATOS DE UNA FURGONETA Y LA DEVUELVE
	 * @param e
	 * @return FURGONETA
	 * @throws Exception
	 */
	public static Furgoneta pideDatosFurgoneta(Empresa e) throws Exception 
	{
		
		//DATOS DE LOS VEHÍCULOS
		String matricula=metodos.MetodosInterfazUsuario.pideStringValidada("Introduzca la Matricula", 7); //SE PIDE LA MATRÍCULA
		String marca=metodos.MetodosInterfazUsuario.pideStringValidada("Introduzca la Marca", 30); //SE PIDE LA MARCA
		String modelo=metodos.MetodosInterfazUsuario.pideStringValidada("Introduzca el Modelo", 25); //SE PIDE EL MODELO
		System.out.println("INTRODUCE LA FECHA DE ALTA");
		Fecha fa=new Fecha(pideFecha()); //SE PIDE LA FECHA DE ALTA
		int km=metodos.MetodosInterfazUsuario.pideIntValidadoMIN("Introduzca los KM", 0); //SE PIDEN LOS KMS
		Categoria c=pideCategoria();
		Oficina o=pideOficinaExiste(e);
				
		//DATOS DE LOS DE COMBUSTIÓN
		int consumo=metodos.MetodosInterfazUsuario.pideIntValidadoMIN("Introduzca el Consumo", 0); //SE PIDE EL CONSUMO
		int potencia=metodos.MetodosInterfazUsuario.pideIntValidadoMIN("Introduzca la Potencia", 0); //SE PIDE LA POTENCIA 
		
		//DATOS DE LA FURGONETA
		String capacidad=metodos.MetodosInterfazUsuario.pideStringValidada("Introduzca la Capacidad de la Furgoneta", 10); //SE PIDE LA CAPACIDAD 
		Carnet_de_conducir carnet=pideCarnet(); //SE PIDE EL TIPO DE CARNET NECESARIO
		
		return new Furgoneta(matricula, marca, modelo, fa, km, c, o, consumo, potencia, capacidad, carnet);
	}
	
	
	/**
	 * PIDE LOS DATOS DE UN COCHE DE COMBUSTION Y LO DEVUELVE
	 * @param e
	 * @return COCHE_COMBUSTION
	 * @throws Exception
	 */
	public static Coche_combustion pideDatosCocheCombustion(Empresa e) throws Exception 
	{
		
		//DATOS DE LOS VEHÍCULOS
		String matricula=metodos.MetodosInterfazUsuario.pideStringValidada("Introduzca la Matricula", 7); //SE PIDE LA MATRÍCULA
		String marca=metodos.MetodosInterfazUsuario.pideStringValidada("Introduzca la Marca", 30); //SE PIDE LA MARCA
		String modelo=metodos.MetodosInterfazUsuario.pideStringValidada("Introduzca el Modelo", 25); //SE PIDE EL MODELO
		System.out.println("INTRODUCE LA FECHA DE ALTA");
		Fecha fa=new Fecha(pideFecha()); //SE PIDE LA FECHA DE ALTA
		int km=metodos.MetodosInterfazUsuario.pideIntValidadoMIN("Introduzca los KM", 0); //SE PIDEN LOS KMS
		Categoria c=pideCategoria();
		Oficina o=pideOficinaExiste(e);
						
		//DATOS DE LOS DE COMBUSTIÓN
		int consumo=metodos.MetodosInterfazUsuario.pideIntValidadoMIN("Introduzca el Consumo", 0); //SE PIDE EL CONSUMO
		int potencia=metodos.MetodosInterfazUsuario.pideIntValidadoMIN("Introduzca la Potencia", 0); //SE PIDE LA POTENCIA 
				
		//DATOS DEL COCHE DE COMBUSTIÓN		
		int nplazas=metodos.MetodosInterfazUsuario.pideIntValidado("Introduzca el Número de Plazas del Coche", 10, 1); //SE PIDE EL NÚMERO DE PLAZAS 
		String tipo=metodos.MetodosInterfazUsuario.pideStringValidada("Introduzca el Tipo de Coche", 15); //SE PIDE EL TIPO DE COCHE
		
		return new Coche_combustion(matricula, marca, modelo, fa, km, c, o, consumo, potencia, nplazas, tipo);
	}
	
	
	/**
	 * PIDE UNA CATEGORÍA Y LA DEVUELVE
	 * @return CATEGORIA
	 * @throws Exception
	 */
	public static Categoria pideCategoria() throws Exception
	{
		String codigo=metodos.MetodosInterfazUsuario.pideStringValidada("Introduzca el Código de la Categoría", 7); //SE PIDE EL CÓDIGO DE LA CATEGORÍA
		String descripcion=metodos.MetodosInterfazUsuario.pideStringValidada("Introduzca una descripción", 30); //SE PIDE LA DESCRIPCIÓN 
		int recargo=metodos.MetodosInterfazUsuario.pideIntValidadoMIN("Introduzca el Recargo en %", 0); //SE PIDE EL RECARGO DE LA CATEGORÍA
		
		return new Categoria(codigo, descripcion, recargo);
	}
	
	
	/**
	 * PIDE LOS DATOS DE UN ALQUILER Y LO DEVUELVE
	 * @param e
	 * @return ALQUILER
	 * @throws Exception
	 */
	public static Alquiler pideDatosAlquiler(Empresa e) throws Exception 
	{
		
		String codigoalquiler=metodos.MetodosInterfazUsuario.pideStringValidada("Introduzca el Código del Alquiler", 7);
		
		int opcion=Menus.menuCategoriaOficina(); //SACA EL MENÚ PARA QUE ELIJA SI QUIERE VER LOS VEHÍCULOS POR CATEGORÍA O POR UNA OFICINA DETERMINADA
		
		switch(opcion) {
			case 1: //SI ELIJE POR CATEGORÍA
				String codigocat=metodos.MetodosInterfazUsuario.pideStringValidada("Introduzca el Código de la Categoría", 7); //SE PIDE EL CÓDIGO DE LA CATEGORÍA
				System.out.println("VEHÍCULOS DE LA CATEGORÍA: "+codigocat);
				metodosArray.ArrayMetodos.pintaVehiculosPorCategoria(e, codigocat);
			break;
		
			case 2: //SI ELIJE POR OFICINA
				String codigo=metodos.MetodosInterfazUsuario.pideStringValidada("Introduzca el Código de la Oficina", 10); //PIDE EL CÓDIGO DE LA OFICINA
				System.out.println("VEHÍCULOS DE LA OFICINA: "+codigo);
				metodosArray.ArrayMetodos.pintaVehiculosPorOficina(e, codigo);
			break;
		}
		
		//NO COMPRUEBA QUE SEA EL DE ESA OFICINA O CATEGORIA ELEGIDA
		String matricula=metodos.MetodosInterfazUsuario.pideStringValidada("Introduce la Matrícula del Vehículo que quiera Alquilar", 7); //SE PIDE LA MATRÍCULA DEL VEHÍCULO
		Vehiculo v=(e.buscaVehiculo(matricula)); //SE CREA UN VEHÍCULO PARA AÑADIRLO AL ALQUILER
		e.addVehiculoAlquilado(v, matricula); //AÑADE EL VEHÍCULO A NO DISPONIBLES
		e.borraVehiculo(matricula); //SE BORRA ESE VEHÍCULO DE LOS VEHÍCULOS DISPONIBLES
		
		Cliente c=pideClienteExiste(e); //SE PIDE EL DNI DE UN CLIENTE QUE ESTÁ REGISTRADO
		
		Empleado em=pideEmpleadoExiste(e); //SE PIDE EL DNI DE UN EMPLEADO QUE EXISTE
		
		Oficina o=pideOficinaExiste(e); //SE PIDE UNA OFICINA QUE EXISTE
		
		System.out.println("INTRODUCE LA FECHA DE RECOGIDA DEL VEHÍCULO");
		Fecha fr=new Fecha(pideFecha()); //SE PIDE LA FECHA DE RECOGIDA DEL VEHÍCULO
		
		System.out.println("INTRODUCE LA FECHA PREVISTA DE DEVOLUCIÓN DEL VEHÍCULO");
		Fecha fd=new Fecha(pideFecha()); //SE PIDE LA FECHA DE DEVOLUCIÓN DEL VEHÍCULO
				
		int diferencia=Fecha.diferencia(fr, fd);
		System.out.println("Número de Días: "+diferencia); //
	
		double precio=v.calculaAlquiler(diferencia);
		
		return new Alquiler(codigoalquiler, v, c, em, o, fr, fd, precio);
	}
	
	
	/**
	 * PIDE LOS DATOS DE UNA DEVOLUCION Y LA DEVUELVE
	 * @param e
	 * @param a
	 * @return DEVOLUCION
	 * @throws Exception
	 */
	public static Devolucion pideDatosDevolucion (Empresa e, Alquiler a) throws Exception
	{
		//VEHÍCULO QUE SE DEVUELVE
		Vehiculo v=a.getVehiculo();//SE CREA UN VEHÍCULO PARA AÑADIRLO AL ALQUILER
		e.addVehiculo(v, v.getMatricula()); //AÑADE EL VEHÍCULO A DISPONIBLES
		e.borraVehiculoDeAlquilados(v.getMatricula()); //SE BORRA ESE VEHÍCULO DE LOS VEHÍCULOS ALQUILADOS
		
		//KMS
		int km=metodos.MetodosInterfazUsuario.pideIntValidadoMIN("Introduzca los KM actuales del Vehículo", 0); //SE PIDEN LOS KMS
		int kmsrecorridos=km-v.getKm(); //SE CALCULAN LOS KILÓMETROS QUE HA RECORRIDO EL VEHÍCULO
		v.setKm(kmsrecorridos+v.getKm()); //CAMBIO LOS KMS DEL VEHÍCULO Y LE PONGO LOS QUE TIENE DESPUÉS DE LA DEVOLUCIÓN
		
		//FECHA DE DEVOLUCIÓN FINAL
		System.out.println("INTRODUCE LA FECHA DE DEVOLUCIÓN DEL VEHÍCULO");
		Fecha fd=new Fecha(pideFecha()); //SE PIDE LA FECHA DE DEVOLUCIÓN DEL VEHÍCULO
		
		//EMPLEADO
		Empleado emp=pideEmpleadoExiste(e); //PIDO EL EMPLEADO QUE SE ENCARGA DE LA DEVOLUCIÓN
		
		int diferencia=Fecha.diferencia(a.getFechaalquiler(), fd);
	
		double precio=v.calculaAlquiler(diferencia);
		
		return new Devolucion(v, kmsrecorridos, fd, emp, precio);
		
	}
	
	
	/**
	 * PIDE UNA FECHA Y LA DEVUELVE
	 * @return
	 */
	public static Fecha pideFecha()
	{
		
		int dia;
		int mes;
		int year;
		
		do {
			dia=metodos.MetodosInterfazUsuario.pideIntValidado("Introduce el DÍA", 31, 1);
			mes=metodos.MetodosInterfazUsuario.pideIntValidado("Introduce el MES", 12, 1);
			year=metodos.MetodosInterfazUsuario.pideIntValidado("Introduce el AÑO", 3000, 0);
		
		}while(!metodos.MetodosValidadores.validaFecha(dia, mes, year));
		
		
		return new Fecha(dia,mes,year);
	}
	
	
	/**
	 * PIDE UNA OFICINA QUE EXISTE Y LA DEVUELVE SI EXISTE 
	 * SI NO EXISTE MUESTRA LA LISTA DE OFICINAS DISPONIBLES
	 * @param e
	 * @return OFICINA
	 * @throws Exception
	 */
	public static Oficina pideOficinaExiste(Empresa e) throws Exception 
	{
		
		String codigo;
		
		do {
			
			codigo=metodos.MetodosInterfazUsuario.pideStringValidada("Introduce el Código de la Oficina", 10); //SE PIDE EL CÓDIGO DE LA OFICINA 
			
			if(e.buscaOficina(codigo)==null) {
				System.out.println("EL CÓDIGO DE LA OFICINA NO ES VÁLIDO O NO EXISTE ESA OFICINA");
				
				int opcion=metodosprograma.Menus.menuSiNo("¿Quieres ver la lista de Oficinas?"); //DA LA OPCIÓN DE MOSTRAR LA LISTA DE OFICINAS
				
				switch (opcion) {
				
					case 1: 
						e.pintaListadeOficinas(); //SACA LA LISTA DE LAS OFICINAS
					break;	
			
				}
			}
			
			
		}while(e.buscaOficina(codigo)==null);
		
		Oficina o=e.buscaOficina(codigo);
		
		if(o==null) {
			return new Oficina(e.buscaOficina(codigo));
		}
		else {
			return o;
		}
	}
	
	
	/**
	 * PIDE UN CLIENTE QUE EXISTE Y LO DEVUELVE SI EXISTE 
	 * SI NO EXISTE MUESTRA LA LISTA DE CLIENTES DISPONIBLES
	 * @param e
	 * @return CLIENTE
	 * @throws Exception
	 */
	public static Cliente pideClienteExiste(Empresa e) throws Exception 
	{
		
		String dni;
		
		do {
			
			dni=metodos.MetodosValidadores.pideDniCorrecto("Introduce el DNI del Cliente"); //PIDE EL DNI
			
			if(e.buscaCliente(dni)==null) {
				System.out.println("EL CLIENTE NO ESTÁ REGISTRADO"); //INFORMA DE QUE EL CLIENTE NO ESTÁ REGISTRADO
				
				int opcion=metodosprograma.Menus.menuSiNo("¿Quieres ver la lista de Clientes?"); //DA LA OPCIÓN DE MOSTRAR LA LISTA DE CLIENTES
				
				switch (opcion) {
				
					case 1: 
						e.pintaListadeClientes(); //SACA LA LISTA DE LOS CLIENTES
					break;	
			
				}
			}
			
			
		}while(e.buscaCliente(dni)==null);
		
		Cliente c=e.buscaCliente(dni);
		
		if(c==null) {
			return new Cliente(e.buscaCliente(dni));
		}
		else {
			return c;
		}
	}
	
	
	/**
	 * PIDE UN EMPLEADO QUE EXISTE Y LO DEVUELVE SI EXISTE 
	 * SI NO EXISTE MUESTRA LA LISTA DE EMPLEADOS DISPONIBLES
	 * @param e
	 * @return EMPLEADO
	 * @throws Exception
	 */
	public static Empleado pideEmpleadoExiste(Empresa e) throws Exception 
	{
		
		String dni;
		
		do {
			
			dni=metodos.MetodosValidadores.pideDniCorrecto("Introduce el DNI del Empleado"); //PIDE EL DNI
			
			if(e.buscaEmpleado(dni)==null) {
				System.out.println("EL EMPLEADO NO EXISTE");
				
				int opcion=metodosprograma.Menus.menuSiNo("¿Quieres ver la lista de empleados?"); //DA LA OPCIÓN DE MOSTRAR LA LISTA DE EMPLEADOS
				
				switch (opcion) {
				
					case 1: 
						e.pintaListadeEmpleados(); //SACA LA LISTA DE LOS EMPLEADOS
					break;	
			
				}
			}
			
			
		}while(e.buscaEmpleado(dni)==null);
		
		Empleado emp=e.buscaEmpleado(dni);
		
		if(emp==null) {
			return new Empleado(e.buscaEmpleado(dni));
		}
		else {
			return emp;
		}
	}
	
	
	/**
	 * PIDE UNA MOTO QUE EXISTE Y LA DEVUELVE SI EXISTE 
	 * SI NO EXISTE MUESTRA LA LISTA DE MOTOS DISPONIBLES
	 * @param e
	 * @return MOTO
	 * @throws Exception
	 */
	public static Moto pideMotoExiste(Empresa e) throws Exception 
	{
		
		String matricula;
		
		do {
			
			matricula=metodos.MetodosInterfazUsuario.pideStringValidada("Introduzca la Matricula", 7); //SE PIDE LA MATRÍCULA
			
			if(e.buscaMoto(matricula)==null) {
				System.out.println("EL VEHÍCULO NO EXISTE");
				
				int opcion=metodosprograma.Menus.menuSiNo("¿Quieres ver la lista de vehículos?"); //DA LA OPCIÓN DE MOSTRAR LA LISTA DE EMPLEADOS
				
				switch (opcion) {
				
					case 1: 
						e.pintaListadeVehiculos(); //SACA LA LISTA DE LOS VEHÍCULOS
					break;	
			
				}
			}
			
			
		}while(e.buscaMoto(matricula)==null);
		
		Moto m=e.buscaMoto(matricula);
		
		if(m==null) {
			return new Moto(e.buscaMoto(matricula));
		}
		else {
			return m;
		}
		
	}
	
	
	/**
	 * PIDE UN COCHE ELÉTRICO QUE EXISTE Y LA DEVUELVE SI EXISTE 
	 * SI NO EXISTE MUESTRA LA LISTA DE COCHES ELECTRICOS DISPONIBLES
	 * @param e
	 * @return COCHE_ELECTRICO
	 * @throws Exception
	 */
	public static Coche_electrico pideCocheElectricoExiste(Empresa e) throws Exception 
	{
		
		String matricula;
		
		do {
			
			matricula=metodos.MetodosInterfazUsuario.pideStringValidada("Introduzca la Matricula", 7); //SE PIDE LA MATRÍCULA
			
			if(e.buscaCocheElectrico(matricula)==null) {
				System.out.println("EL VEHÍCULO NO EXISTE");
				
				int opcion=metodosprograma.Menus.menuSiNo("¿Quieres ver la lista de vehículos?"); //DA LA OPCIÓN DE MOSTRAR LA LISTA DE EMPLEADOS
				
				switch (opcion) {
				
					case 1: 
						e.pintaListadeVehiculos(); //SACA LA LISTA DE LOS VEHÍCULOS
					break;	
			
				}
			}
			
			
		}while(e.buscaCocheElectrico(matricula)==null);
		
		Coche_electrico ce=e.buscaCocheElectrico(matricula);
		
		if(ce==null) {
			return new Coche_electrico(e.buscaCocheElectrico(matricula));
		}
		else {
			return ce;
		}
		
	}
	
	
	/**
	 * PIDE UN COCHE DE COMBUSTION QUE EXISTE Y LO DEVUELVE SI EXISTE 
	 * @param e
	 * @return COCHE_COMBUSTION
	 * @throws Exception
	 */
	public static Coche_combustion pideCocheCombustionExiste(Empresa e) throws Exception 
	{
		
		String matricula;
		
		do {
			
			matricula=metodos.MetodosInterfazUsuario.pideStringValidada("Introduzca la Matricula", 7); //SE PIDE LA MATRÍCULA
			
			if(e.buscaCocheCombustion(matricula)==null) {
				System.out.println("EL VEHÍCULO NO EXISTE");
				
				int opcion=metodosprograma.Menus.menuSiNo("¿Quieres ver la lista de vehículos?"); //DA LA OPCIÓN DE MOSTRAR LA LISTA DE EMPLEADOS
				
				switch (opcion) {
				
					case 1: 
						e.pintaListadeVehiculos(); //SACA LA LISTA DE LOS VEHÍCULOS
					break;	
			
				}
			}
			
			
		}while(e.buscaCocheCombustion(matricula)==null);
		
		Coche_combustion cc=e.buscaCocheCombustion(matricula);
		
		if(cc==null) {
			return new Coche_combustion(e.buscaCocheCombustion(matricula));
		}
		else {
			return cc;
		}
		
	}
	
	
	/**
	 * PIDE UNA FURGONETA QUE EXISTE Y LA DEVUELVE SI EXISTE 
	 * SI NO EXISTE MUESTRA LA LISTA DE FURGONETAS DISPONIBLES
	 * @param e
	 * @return FURGONETA
	 * @throws Exception
	 */
	public static Furgoneta pideFurgonetaExiste(Empresa e) throws Exception 
	{
		
		String matricula;
		
		do {
			
			matricula=metodos.MetodosInterfazUsuario.pideStringValidada("Introduzca la Matricula", 7); //SE PIDE LA MATRÍCULA
			
			if(e.buscaFurgoneta(matricula)==null) {
				System.out.println("EL VEHÍCULO NO EXISTE");
				
				int opcion=metodosprograma.Menus.menuSiNo("¿Quieres ver la lista de vehículos?"); //DA LA OPCIÓN DE MOSTRAR LA LISTA DE EMPLEADOS
				
				switch (opcion) {
				
					case 1: 
						e.pintaListadeVehiculos(); //SACA LA LISTA DE LOS VEHÍCULOS
					break;	
			
				}
			}
			
			
		}while(e.buscaFurgoneta(matricula)==null);
		
		Furgoneta f=e.buscaFurgoneta(matricula);
		
		if(f==null) {
			return new Furgoneta(e.buscaFurgoneta(matricula));
		}
		else {
			return f;
		}
		
	}
	
}

	
	
	
	
	
	
	
	

