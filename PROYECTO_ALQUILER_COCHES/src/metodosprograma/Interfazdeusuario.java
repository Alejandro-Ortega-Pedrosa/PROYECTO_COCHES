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
		String codigo=metodos.MetodosInterfazUsuario.pideStringValidada("Introduzca el C�digo de la Oficina", 10); //PIDE EL C�DIGO DE LA OFICINA
		String descripcion=metodos.MetodosInterfazUsuario.pideStringValidada("Introduzca una Descripci�n", 30);	//PIDE UNA DESCRIPCI�N
		String localidad=metodos.MetodosInterfazUsuario.pideStringValidada("Introduzca la Localidad", 30); //PIDE LA LOCALIDAD
		String provincia=metodos.MetodosInterfazUsuario.pideStringValidada("Introduzca la Provincia", 30); //PIDE LA PROVINCIA
		int respuesta=metodosprograma.Menus.menuSiNo("�Es una Oficina de Aeropuerto?"); //PREGUNTA SI ES DE AEROPUERTO
		
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
		String id=metodos.MetodosInterfazUsuario.pideStringValidada("Introduzca el C�digo del Cliente", 10); //SE PIDE EL ID DE CLIENTE
		
		
		
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
		//DATOS DE LOS VEH�CULOS
		String matricula=metodos.MetodosInterfazUsuario.pideStringValidada("Introduzca la Matricula", 7); //SE PIDE LA MATR�CULA
		String marca=metodos.MetodosInterfazUsuario.pideStringValidada("Introduzca la Marca", 30); //SE PIDE LA MARCA
		String modelo=metodos.MetodosInterfazUsuario.pideStringValidada("Introduzca el Modelo", 25); //SE PIDE EL MODELO
		System.out.println("INTRODUCE LA FECHA DE ALTA");
		Fecha fa=new Fecha(pideFecha()); //SE PIDE LA FECHA DE ALTA
		int km=metodos.MetodosInterfazUsuario.pideIntValidadoMIN("Introduzca los KM", 0); //SE PIDEN LOS KMS
		Categoria c=pideCategoria();
		Oficina o=pideOficinaExiste(e);
		
		//DATOS DE LOS EL�CTRICOS
		String autonomia=metodos.MetodosInterfazUsuario.pideStringValidada("Introduzca la Autonom�a", 25); //SE PIDE LA AUTONOM�A
		String tiemporecarga=metodos.MetodosInterfazUsuario.pideStringValidada("Introduzca el Tiempo de Recarga", 25); //SE PIDE EL TIEMPO DE RECARGA
		
		//DATOS DE LA MOTO
		String cilindrada=metodos.MetodosInterfazUsuario.pideStringValidada("Introduce la Cilindrada", 10); //SE PIDE EL C�DIGO DE LA OFICINA 
		Carnet_de_conducir carnet=pideCarnet(); //SE PIDE EL TIPO DE CARNET NECESARIO
		
		
		
		
		return new Moto(matricula, marca, modelo, fa, km, c, o, autonomia, tiemporecarga, cilindrada, carnet);
	}
	
	
	/**
	 * PIDE LOS DATOS DE UN COCHE EL�CTRICO Y LO DEVUELVE
	 * @param e
	 * @return COCHE_ELECTRICO
	 * @throws Exception
	 */
	public static Coche_electrico pideDatosCocheElectrico(Empresa e) throws Exception 
	{
		
		//DATOS DE LOS VEH�CULOS
		String matricula=metodos.MetodosInterfazUsuario.pideStringValidada("Introduzca la Matricula", 7); //SE PIDE LA MATR�CULA
		String marca=metodos.MetodosInterfazUsuario.pideStringValidada("Introduzca la Marca", 30); //SE PIDE LA MARCA
		String modelo=metodos.MetodosInterfazUsuario.pideStringValidada("Introduzca el Modelo", 25); //SE PIDE EL MODELO
		System.out.println("INTRODUCE LA FECHA DE ALTA");
		Fecha fa=new Fecha(pideFecha()); //SE PIDE LA FECHA DE ALTA
		int km=metodos.MetodosInterfazUsuario.pideIntValidadoMIN("Introduzca los KM", 0); //SE PIDEN LOS KMS
		Categoria c=pideCategoria();
		Oficina o=pideOficinaExiste(e);
				
		//DATOS DE LOS EL�CTRICOS
		String autonomia=metodos.MetodosInterfazUsuario.pideStringValidada("Introduzca la Autonom�a", 25); //SE PIDE LA AUTONOM�A
		String tiemporecarga=metodos.MetodosInterfazUsuario.pideStringValidada("Introduzca el Tiempo de Recarga", 25); //SE PIDE EL TIEMPO DE RECARGA
				
		//DATOS DEL COCHE EL�CTRICO
		int nplazas=metodos.MetodosInterfazUsuario.pideIntValidado("Introduzca el N�mero de Plazas del Coche", 10, 1); //SE PIDE EL N�MERO DE PLAZAS 
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
		
		//DATOS DE LOS VEH�CULOS
		String matricula=metodos.MetodosInterfazUsuario.pideStringValidada("Introduzca la Matricula", 7); //SE PIDE LA MATR�CULA
		String marca=metodos.MetodosInterfazUsuario.pideStringValidada("Introduzca la Marca", 30); //SE PIDE LA MARCA
		String modelo=metodos.MetodosInterfazUsuario.pideStringValidada("Introduzca el Modelo", 25); //SE PIDE EL MODELO
		System.out.println("INTRODUCE LA FECHA DE ALTA");
		Fecha fa=new Fecha(pideFecha()); //SE PIDE LA FECHA DE ALTA
		int km=metodos.MetodosInterfazUsuario.pideIntValidadoMIN("Introduzca los KM", 0); //SE PIDEN LOS KMS
		Categoria c=pideCategoria();
		Oficina o=pideOficinaExiste(e);
				
		//DATOS DE LOS DE COMBUSTI�N
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
		
		//DATOS DE LOS VEH�CULOS
		String matricula=metodos.MetodosInterfazUsuario.pideStringValidada("Introduzca la Matricula", 7); //SE PIDE LA MATR�CULA
		String marca=metodos.MetodosInterfazUsuario.pideStringValidada("Introduzca la Marca", 30); //SE PIDE LA MARCA
		String modelo=metodos.MetodosInterfazUsuario.pideStringValidada("Introduzca el Modelo", 25); //SE PIDE EL MODELO
		System.out.println("INTRODUCE LA FECHA DE ALTA");
		Fecha fa=new Fecha(pideFecha()); //SE PIDE LA FECHA DE ALTA
		int km=metodos.MetodosInterfazUsuario.pideIntValidadoMIN("Introduzca los KM", 0); //SE PIDEN LOS KMS
		Categoria c=pideCategoria();
		Oficina o=pideOficinaExiste(e);
						
		//DATOS DE LOS DE COMBUSTI�N
		int consumo=metodos.MetodosInterfazUsuario.pideIntValidadoMIN("Introduzca el Consumo", 0); //SE PIDE EL CONSUMO
		int potencia=metodos.MetodosInterfazUsuario.pideIntValidadoMIN("Introduzca la Potencia", 0); //SE PIDE LA POTENCIA 
				
		//DATOS DEL COCHE DE COMBUSTI�N		
		int nplazas=metodos.MetodosInterfazUsuario.pideIntValidado("Introduzca el N�mero de Plazas del Coche", 10, 1); //SE PIDE EL N�MERO DE PLAZAS 
		String tipo=metodos.MetodosInterfazUsuario.pideStringValidada("Introduzca el Tipo de Coche", 15); //SE PIDE EL TIPO DE COCHE
		
		return new Coche_combustion(matricula, marca, modelo, fa, km, c, o, consumo, potencia, nplazas, tipo);
	}
	
	
	/**
	 * PIDE UNA CATEGOR�A Y LA DEVUELVE
	 * @return CATEGORIA
	 * @throws Exception
	 */
	public static Categoria pideCategoria() throws Exception
	{
		String codigo=metodos.MetodosInterfazUsuario.pideStringValidada("Introduzca el C�digo de la Categor�a", 7); //SE PIDE EL C�DIGO DE LA CATEGOR�A
		String descripcion=metodos.MetodosInterfazUsuario.pideStringValidada("Introduzca una descripci�n", 30); //SE PIDE LA DESCRIPCI�N 
		int recargo=metodos.MetodosInterfazUsuario.pideIntValidadoMIN("Introduzca el Recargo en %", 0); //SE PIDE EL RECARGO DE LA CATEGOR�A
		
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
		
		String codigoalquiler=metodos.MetodosInterfazUsuario.pideStringValidada("Introduzca el C�digo del Alquiler", 7);
		
		int opcion=Menus.menuCategoriaOficina(); //SACA EL MEN� PARA QUE ELIJA SI QUIERE VER LOS VEH�CULOS POR CATEGOR�A O POR UNA OFICINA DETERMINADA
		
		switch(opcion) {
			case 1: //SI ELIJE POR CATEGOR�A
				String codigocat=metodos.MetodosInterfazUsuario.pideStringValidada("Introduzca el C�digo de la Categor�a", 7); //SE PIDE EL C�DIGO DE LA CATEGOR�A
				System.out.println("VEH�CULOS DE LA CATEGOR�A: "+codigocat);
				metodosArray.ArrayMetodos.pintaVehiculosPorCategoria(e, codigocat);
			break;
		
			case 2: //SI ELIJE POR OFICINA
				String codigo=metodos.MetodosInterfazUsuario.pideStringValidada("Introduzca el C�digo de la Oficina", 10); //PIDE EL C�DIGO DE LA OFICINA
				System.out.println("VEH�CULOS DE LA OFICINA: "+codigo);
				metodosArray.ArrayMetodos.pintaVehiculosPorOficina(e, codigo);
			break;
		}
		
		//NO COMPRUEBA QUE SEA EL DE ESA OFICINA O CATEGORIA ELEGIDA
		String matricula=metodos.MetodosInterfazUsuario.pideStringValidada("Introduce la Matr�cula del Veh�culo que quiera Alquilar", 7); //SE PIDE LA MATR�CULA DEL VEH�CULO
		Vehiculo v=(e.buscaVehiculo(matricula)); //SE CREA UN VEH�CULO PARA A�ADIRLO AL ALQUILER
		e.addVehiculoAlquilado(v, matricula); //A�ADE EL VEH�CULO A NO DISPONIBLES
		e.borraVehiculo(matricula); //SE BORRA ESE VEH�CULO DE LOS VEH�CULOS DISPONIBLES
		
		Cliente c=pideClienteExiste(e); //SE PIDE EL DNI DE UN CLIENTE QUE EST� REGISTRADO
		
		Empleado em=pideEmpleadoExiste(e); //SE PIDE EL DNI DE UN EMPLEADO QUE EXISTE
		
		Oficina o=pideOficinaExiste(e); //SE PIDE UNA OFICINA QUE EXISTE
		
		System.out.println("INTRODUCE LA FECHA DE RECOGIDA DEL VEH�CULO");
		Fecha fr=new Fecha(pideFecha()); //SE PIDE LA FECHA DE RECOGIDA DEL VEH�CULO
		
		System.out.println("INTRODUCE LA FECHA PREVISTA DE DEVOLUCI�N DEL VEH�CULO");
		Fecha fd=new Fecha(pideFecha()); //SE PIDE LA FECHA DE DEVOLUCI�N DEL VEH�CULO
				
		int diferencia=Fecha.diferencia(fr, fd);
		System.out.println("N�mero de D�as: "+diferencia); //
	
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
		//VEH�CULO QUE SE DEVUELVE
		Vehiculo v=a.getVehiculo();//SE CREA UN VEH�CULO PARA A�ADIRLO AL ALQUILER
		e.addVehiculo(v, v.getMatricula()); //A�ADE EL VEH�CULO A DISPONIBLES
		e.borraVehiculoDeAlquilados(v.getMatricula()); //SE BORRA ESE VEH�CULO DE LOS VEH�CULOS ALQUILADOS
		
		//KMS
		int km=metodos.MetodosInterfazUsuario.pideIntValidadoMIN("Introduzca los KM actuales del Veh�culo", 0); //SE PIDEN LOS KMS
		int kmsrecorridos=km-v.getKm(); //SE CALCULAN LOS KIL�METROS QUE HA RECORRIDO EL VEH�CULO
		v.setKm(kmsrecorridos+v.getKm()); //CAMBIO LOS KMS DEL VEH�CULO Y LE PONGO LOS QUE TIENE DESPU�S DE LA DEVOLUCI�N
		
		//FECHA DE DEVOLUCI�N FINAL
		System.out.println("INTRODUCE LA FECHA DE DEVOLUCI�N DEL VEH�CULO");
		Fecha fd=new Fecha(pideFecha()); //SE PIDE LA FECHA DE DEVOLUCI�N DEL VEH�CULO
		
		//EMPLEADO
		Empleado emp=pideEmpleadoExiste(e); //PIDO EL EMPLEADO QUE SE ENCARGA DE LA DEVOLUCI�N
		
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
			dia=metodos.MetodosInterfazUsuario.pideIntValidado("Introduce el D�A", 31, 1);
			mes=metodos.MetodosInterfazUsuario.pideIntValidado("Introduce el MES", 12, 1);
			year=metodos.MetodosInterfazUsuario.pideIntValidado("Introduce el A�O", 3000, 0);
		
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
			
			codigo=metodos.MetodosInterfazUsuario.pideStringValidada("Introduce el C�digo de la Oficina", 10); //SE PIDE EL C�DIGO DE LA OFICINA 
			
			if(e.buscaOficina(codigo)==null) {
				System.out.println("EL C�DIGO DE LA OFICINA NO ES V�LIDO O NO EXISTE ESA OFICINA");
				
				int opcion=metodosprograma.Menus.menuSiNo("�Quieres ver la lista de Oficinas?"); //DA LA OPCI�N DE MOSTRAR LA LISTA DE OFICINAS
				
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
				System.out.println("EL CLIENTE NO EST� REGISTRADO"); //INFORMA DE QUE EL CLIENTE NO EST� REGISTRADO
				
				int opcion=metodosprograma.Menus.menuSiNo("�Quieres ver la lista de Clientes?"); //DA LA OPCI�N DE MOSTRAR LA LISTA DE CLIENTES
				
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
				
				int opcion=metodosprograma.Menus.menuSiNo("�Quieres ver la lista de empleados?"); //DA LA OPCI�N DE MOSTRAR LA LISTA DE EMPLEADOS
				
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
			
			matricula=metodos.MetodosInterfazUsuario.pideStringValidada("Introduzca la Matricula", 7); //SE PIDE LA MATR�CULA
			
			if(e.buscaMoto(matricula)==null) {
				System.out.println("EL VEH�CULO NO EXISTE");
				
				int opcion=metodosprograma.Menus.menuSiNo("�Quieres ver la lista de veh�culos?"); //DA LA OPCI�N DE MOSTRAR LA LISTA DE EMPLEADOS
				
				switch (opcion) {
				
					case 1: 
						e.pintaListadeVehiculos(); //SACA LA LISTA DE LOS VEH�CULOS
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
	 * PIDE UN COCHE EL�TRICO QUE EXISTE Y LA DEVUELVE SI EXISTE 
	 * SI NO EXISTE MUESTRA LA LISTA DE COCHES ELECTRICOS DISPONIBLES
	 * @param e
	 * @return COCHE_ELECTRICO
	 * @throws Exception
	 */
	public static Coche_electrico pideCocheElectricoExiste(Empresa e) throws Exception 
	{
		
		String matricula;
		
		do {
			
			matricula=metodos.MetodosInterfazUsuario.pideStringValidada("Introduzca la Matricula", 7); //SE PIDE LA MATR�CULA
			
			if(e.buscaCocheElectrico(matricula)==null) {
				System.out.println("EL VEH�CULO NO EXISTE");
				
				int opcion=metodosprograma.Menus.menuSiNo("�Quieres ver la lista de veh�culos?"); //DA LA OPCI�N DE MOSTRAR LA LISTA DE EMPLEADOS
				
				switch (opcion) {
				
					case 1: 
						e.pintaListadeVehiculos(); //SACA LA LISTA DE LOS VEH�CULOS
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
			
			matricula=metodos.MetodosInterfazUsuario.pideStringValidada("Introduzca la Matricula", 7); //SE PIDE LA MATR�CULA
			
			if(e.buscaCocheCombustion(matricula)==null) {
				System.out.println("EL VEH�CULO NO EXISTE");
				
				int opcion=metodosprograma.Menus.menuSiNo("�Quieres ver la lista de veh�culos?"); //DA LA OPCI�N DE MOSTRAR LA LISTA DE EMPLEADOS
				
				switch (opcion) {
				
					case 1: 
						e.pintaListadeVehiculos(); //SACA LA LISTA DE LOS VEH�CULOS
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
			
			matricula=metodos.MetodosInterfazUsuario.pideStringValidada("Introduzca la Matricula", 7); //SE PIDE LA MATR�CULA
			
			if(e.buscaFurgoneta(matricula)==null) {
				System.out.println("EL VEH�CULO NO EXISTE");
				
				int opcion=metodosprograma.Menus.menuSiNo("�Quieres ver la lista de veh�culos?"); //DA LA OPCI�N DE MOSTRAR LA LISTA DE EMPLEADOS
				
				switch (opcion) {
				
					case 1: 
						e.pintaListadeVehiculos(); //SACA LA LISTA DE LOS VEH�CULOS
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

	
	
	
	
	
	
	
	

