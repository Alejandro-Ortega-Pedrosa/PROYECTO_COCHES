package metodosprograma;

import Excepciones.OpcionNoValidaException;
import entidades.Alquiler;
import entidades.Cliente;
import entidades.Coche_combustion;
import entidades.Coche_electrico;
import entidades.Devolucion;
import entidades.Empleado;
import entidades.Empresa;
import entidades.Furgoneta;
import entidades.Moto;
import entidades.Oficina;
import metodos.MetodosInterfazUsuario;

public class Menus {

	
/*
 * METODO PARA PINTAR EL MENÚ PRINCIPAL 
 * SI SE ELIGE LA OPCIÓN DE FINALIZAR PROGRAMA SE ACABA EL PROGRAMA Y GRABA LA EMPRESA
 */
public static int pintaMenuPrincipal(Empresa e) throws Exception {
	

	String lista[]={ "GESTIÓN DE NEGOCIO", "GESTIÓN DE ALQUILERES", "LISTADOS", "FINALIZAR PROGRAMA" }; 
	int valoresvalidos[]={ 1, 2, 3, 4};
	
	int opcion=metodos.MetodosPintarPantalla.menu(lista, valoresvalidos, "MENÚ PRINCIPAL" , "ELIJA UNA OPCIÓN" );

	switch (opcion) {
	
		case 1: pintaMenuGestion(e); //PINTA EL MENÚ DE GESTIÓN
		break;	
		
		case 2: pintaMenuAlquiler(e); //PINTA EL MENÚ DE LOS ALQUILERES
		break;	
	
		case 3: pintaMenuListados(e); //PINTA EL MENÚ DE LOS LISTADOS
		break;	
	
		case 4: Empresa.grabaEmpresa(e);
		System.out.println("FIN DEL PROGRAMA"); //FIN DEL PROGRAMA
		break;
	}
		
	return opcion;
}


/*
 * METODO PARA PINTAR EL MENÚ DE LA GESTIÓN 
 */
public static void pintaMenuGestion(Empresa e) throws Exception {
	
	String lista[]={ "AÑADIR", "MODIFICAR", "BORRAR", "BUSCAR", "MENÚ PRINCIPAL" }; 
	int valoresvalidos[]={ 1, 2, 3, 4, 5};
	
	int opcion=metodos.MetodosPintarPantalla.menu(lista, valoresvalidos, "GESTIÓN DE NEGOCIO" , "ELIJA UNA OPCIÓN" );
	
	switch (opcion) {
	
		case 1: pintaMenuAdd(e); //PINTA EL MENÚ DE LOS LISTADOS
		break;	

		case 2: pintaMenuModificar(e); //PINTA EL MENÚ DE MODIFICAR
		break;	

		case 3: pintaMenuBorrar(e); //PINTA EL MENÚ DE BORRAR
		break;	

		case 4: pintaMenuBuscar(e); //PINTA EL MENÚ DE BUSCAR
		break;	

		case 5: pintaMenuPrincipal(e); //PINTA EL MENÚ PRINCIPAL
	}

}


/*
 * METODO PARA PINTAR EL MENÚ DE AÑADIR UN CLIENTE, EMPLEADO, COCHE, OFICINA
 */
public static void pintaMenuAdd(Empresa e) throws Exception {
	
	String lista[]={ "CLIENTE", "EMPLEADO", "VEHÍCULO", "OFICINA", "GESTIÓN DE NEGOCIO", "MENÚ PRINCIPAL"}; 
	int valoresvalidos[]={ 1, 2, 3, 4, 5, 6};
	int opcion;
	
	
	opcion=metodos.MetodosPintarPantalla.menu(lista, valoresvalidos, "¿QUE QUIERES AÑADIR?" , "ELIJA UNA OPCIÓN" );
		
	switch (opcion) {
	
	   case 1: 
			
			do {
				
				e.addCliente(); //AÑADE UN CLIENTE
				opcion=menuSiNo("¿QUIERES AÑADIR ALGUNO MÁS?"); //PREGUNTA SI QUIERE AÑADIR MÁS
			
			}while(opcion==1);
			
			if(opcion==2) 
			{
				pintaMenuGestion(e); //SI ELIJE NO PINTA MENÚ DE GESTIÓN
			}
			
		break;
	
		
		case 2: 
			
			do {
		
				e.addEmpleado(e); //AÑADE UN EMPLEADO
				opcion=menuSiNo("¿QUIERES AÑADIR ALGUNO MÁS?"); //PREGUNTA SI QUIERE AÑADIR MÁS
	
			}while(opcion==1);
	
			if(opcion==2) 
			{
				pintaMenuGestion(e); //SI ELIJE NO PINTA EL MENÚ DE GESTIÓN
			}
	
		break;
		
		case 3: 
		
			do {
			
				e.addVehiculo(e); //AÑADE UN VEHÍCULO
				opcion=menuSiNo("¿QUIERES AÑADIR ALGUNO MÁS?"); //PREGUNTA SI QUIERE AÑADIR MÁS

			}while(opcion==1);

			if(opcion==2) 
			{
				pintaMenuGestion(e); //SI ELIJE NO PINTA EL MENÚ DE GESTIÓN
			}

		break;	
		
		case 4: 
			
			do {
		
				e.addOficina(); //AÑADE UNA OFICINA
				opcion=menuSiNo("¿QUIERES AÑADIR ALGUNA MÁS?"); //PREGUNTA SI QUIERE AÑADIR MÁS

			}while(opcion==1);

			if(opcion==2) 
			{
				pintaMenuGestion(e); //SI ELIJE NO PINTA EL MENÚ DE GESTIÓN
			}

			break;

	
		case 5: pintaMenuGestion(e); //PINTA EL MENÚ DE GESTIÓN
		break;	
	
		case 6: pintaMenuPrincipal(e); //PINTA EL MENÚ PRINCIPAL
		break;
	}
	
}


/*
 * METODO PARA PINTAR EL MENÚ DE MODIFICAR DATOS
 */
public static void pintaMenuModificar(Empresa e) throws Exception {
	
	String lista[]={ "CLIENTE", "EMPLEADO", "VEHÍCULO", "OFICINA", "GESTIÓN DE NEGOCIO", "MENÚ PRINCIPAL"}; 
	int valoresvalidos[]={ 1, 2, 3, 4, 5, 6};
	int opcion;
	

	opcion=metodos.MetodosPintarPantalla.menu(lista, valoresvalidos, "¿QUE QUIERES MODIFICAR?" , "ELIJA UNA OPCIÓN" );
		
	switch (opcion) {
	
	    case 1: 
	    	do {
				
				Cliente c= metodosprograma.Interfazdeusuario.pideClienteExiste(e);
				
				opcion=menuModificarCliente(); //PINTA EL MENÚ DE MODIFICAR CLIENTE
				
				switch (opcion) {
				
				case 1: 
					c.setNombre(metodos.MetodosInterfazUsuario.pideStringValidada("Introduzca el Nombre", 25)); //SI QUIERE MODIFICAR EL NOMBRE SE LO PIDE
				break;
				
				case 2:
					c.setApellido1(metodos.MetodosInterfazUsuario.pideStringValidada("Introduzca el PRIMER Apellido", 30)); //SI QUIERE MODIFICAR EL PRIMER APELLIDO SE LO PIDE
				break;
				
				case 3:	
					c.setApellido2(metodos.MetodosInterfazUsuario.pideStringValidada("Introduzca el SEGUNDO Apellido", 30)); //SI QUIERE MODIFICAR EL SEGUNDO APELLIDO SE LO PIDE
				break;
				
				case 4:
					c.setCarnet(metodosprograma.Interfazdeusuario.pideCarnet()); //SI QUIERE MODIFICAR EL CARNET LE PIDE UN CARNET
				break;
				
				case 5:
					c.setId(metodos.MetodosInterfazUsuario.pideStringValidada("Introduzca el Código del Cliente", 10)); //SI QUIERE MODIFICAR EL ID SE LO PIDE
				break;
				
				case 6:
					pintaMenuModificar(e);
				break;
				
				}
				
				
				opcion=menuSiNo("¿QUIERES MODIFICAR ALGUNO MÁS?"); //ELIJA SI O NO PREGUNTA SI SE QUIERE BORRAR ALGUNO MÁS
			
			}while(opcion==1);
			
			if(opcion==2) 
			{
				pintaMenuGestion(e); //SI NO PINTA MENÚ DE GESTIÓN
			}
			
		break;
	
		
		case 2: 
			do {
				
				Empleado em= metodosprograma.Interfazdeusuario.pideEmpleadoExiste(e);
				
				opcion=menuModificarEmpleado(); //PINTA EL MENÚ DE MODIFICAR EMPLEADO
				
				switch (opcion) {
				
				case 1: 
					em.setNombre(metodos.MetodosInterfazUsuario.pideStringValidada("Introduzca el Nombre", 25)); //SI QUIERE MODIFICAR EL NOMBRE SE LO PIDE
				break;
				
				case 2:
					em.setApellido1(metodos.MetodosInterfazUsuario.pideStringValidada("Introduzca el PRIMER Apellido", 30)); //SI QUIERE MODIFICAR EL PRIMER APELLIDO SE LO PIDE
				break;
				
				case 3:	
					em.setApellido2(metodos.MetodosInterfazUsuario.pideStringValidada("Introduzca el SEGUNDO Apellido", 30)); //SI QUIERE MODIFICAR EL SEGUNDO APELLIDO SE LO PIDE
				break;
				
				case 4:
					em.setFechadealta(metodosprograma.Interfazdeusuario.pideFecha()); //SI QUIERE MODIFICAR LA FECHA DE ALTA SE LA PIDE
				break;
				
				case 5:
					em.setOficina(metodosprograma.Interfazdeusuario.pideOficinaExiste(e)); //SI QUIERE MODIFICAR LA OFICINA SE LA PIDE
				break;
				
				case 6:
					pintaMenuModificar(e); //SI QUIERE VOLVER ATRÁS
				break;
				
				}
				
				
				opcion=menuSiNo("¿QUIERES MODIFICAR ALGUNO MÁS?"); //ELIJA SI O NO PREGUNTA SI SE QUIERE BORRAR ALGUNO MÁS
			
			}while(opcion==1);
			
			if(opcion==2) 
			{
				pintaMenuGestion(e); //SI NO PINTA MENÚ DE GESTIÓN
			}
			
		break;
		
		case 3: 
			
				opcion=menuVehiculoAModificar();
			
				switch(opcion) {
				
					case 1: //COCHE COMBUSTIÓN
					do {
						Coche_combustion cc=metodosprograma.Interfazdeusuario.pideCocheCombustionExiste(e);
					
						opcion=menuModificarCocheCombustion();
					
						switch(opcion) {
					
						case 1: //MARCA
							cc.setMarca(metodos.MetodosInterfazUsuario.pideStringValidada("Introduzca la Marca", 30)); //SI QUIERE MODIFICAR LA MARCA SE LA PIDE
							break;
					
						case 2: //MODELO
							cc.setModelo(metodos.MetodosInterfazUsuario.pideStringValidada("Introduzca el Modelo", 25)); //SI QUIERE MODIFICAR EL MODELO SE LO PIDE
						break;
					
						case 3: //FECHA DE ALTA
							cc.setFechadealta(metodosprograma.Interfazdeusuario.pideFecha()); //SI QUIERE MODIFICAR LA FECHA SE LA PIDE
						break;
					
						case 4: //KM
							cc.setKm(metodos.MetodosInterfazUsuario.pideIntValidadoMIN("Introduzca los KM", 0)); //SI QUIERE MODIFICAR LOS KM SE LOS PIDE
							break;
					
						case 5: //CATEGORÍA
							cc.setCategoria(metodosprograma.Interfazdeusuario.pideCategoria()); //SI QUIERE MODIFICAR LA CATEGORÍA SE LA PIDE
						break;
						
						case 6: //OFICINA
							cc.setOficina(metodosprograma.Interfazdeusuario.pideOficinaExiste(e)); //SI QUIERE MODIFICAR LA OFICINA SE LA PIDE
						break;
					
						case 7: //CONSUMO
							cc.setConsumo(metodos.MetodosInterfazUsuario.pideIntValidadoMIN("Introduzca el Consumo", 0)); //SI QUIERE MODIFICAR EL CONSUMO SE LO PIDE
						break;
					
						case 8:	//POTENCIA
							cc.setPotencia(metodos.MetodosInterfazUsuario.pideIntValidadoMIN("Introduzca la Potencia", 0)); //SI QUIERE MODIFICAR LA POTENCIA SE LA PIDE
						break;
					
						case 9: //Nº PLAZAS 
							cc.setNplazas(metodos.MetodosInterfazUsuario.pideIntValidado("Introduzca el Número de Plazas del Coche", 10, 1)); //SI QUIERE MODIFICAR EL Nº DE PLAZAS SE LO PIDE
						break;
					
						case 10: //TIPO
							cc.setTipo(metodos.MetodosInterfazUsuario.pideStringValidada("Introduzca el Tipo de Coche", 15)); //SI QUIERE MODIFICAR EL TIPO SE LO PIDE
						break;
					
						case 11:
							menuVehiculoAModificar();
						break;
					
						
						}
				
				
						opcion=menuSiNo("¿QUIERES MODIFICAR ALGUNO MÁS?"); //ELIJA SI O NO PREGUNTA SI SE QUIERE BORRAR ALGUNO MÁS
					
					}while(opcion==1);
			
					if(opcion==2) 
					{
						pintaMenuGestion(e); //SI NO PINTA MENÚ DE GESTIÓN
					}
			
				break;
				
				case 2: //FURGONETA
				do {	
					
					Furgoneta f=metodosprograma.Interfazdeusuario.pideFurgonetaExiste(e);
					
					opcion=menuModificarFurgoneta();
					
					switch(opcion) {
					
					case 1: //MARCA
						f.setMarca(metodos.MetodosInterfazUsuario.pideStringValidada("Introduzca la Marca", 30)); //SI QUIERE MODIFICAR LA MARCA SE LA PIDE
					break;
					
					case 2: //MODELO
						f.setModelo(metodos.MetodosInterfazUsuario.pideStringValidada("Introduzca el Modelo", 25)); //SI QUIERE MODIFICAR EL MODELO SE LO PIDE
					break;
					
					case 3: //FECHA DE ALTA
						f.setFechadealta(metodosprograma.Interfazdeusuario.pideFecha()); //SI QUIERE MODIFICAR LA FECHA SE LA PIDE
					break;
					
					case 4: //KM
						f.setKm(metodos.MetodosInterfazUsuario.pideIntValidadoMIN("Introduzca los KM", 0)); //SI QUIERE MODIFICAR LOS KM SE LOS PIDE
					break;
					
					case 5: //CATEGORÍA
						f.setCategoria(metodosprograma.Interfazdeusuario.pideCategoria()); //SI QUIERE MODIFICAR LA CATEGORÍA SE LA PIDE
					break;
						
					case 6: //OFICINA
						f.setOficina(metodosprograma.Interfazdeusuario.pideOficinaExiste(e)); //SI QUIERE MODIFICAR LA OFICINA SE LA PIDE
					break;
					
					case 7: //CONSUMO
						f.setConsumo(metodos.MetodosInterfazUsuario.pideIntValidadoMIN("Introduzca el Consumo", 0)); //SI QUIERE MODIFICAR EL CONSUMO SE LO PIDE
					break;
					
					case 8:	//POTENCIA
						f.setPotencia(metodos.MetodosInterfazUsuario.pideIntValidadoMIN("Introduzca la Potencia", 0)); //SI QUIERE MODIFICAR LA POTENCIA SE LA PIDE
					break;
					
					case 9: //CAPACIDAD 
						f.setCapacidad(metodos.MetodosInterfazUsuario.pideStringValidada("Introduzca la Capacidad de la Furgoneta", 10));
					break;
					
					case 10: //CARNET
						f.setCarnet(metodosprograma.Interfazdeusuario.pideCarnet()); 
					break;
					
					case 11:
						menuVehiculoAModificar();
					break;
				
					
					}
			
					opcion=menuSiNo("¿QUIERES MODIFICAR ALGUNO MÁS?"); //ELIJA SI O NO PREGUNTA SI SE QUIERE BORRAR ALGUNO MÁS
				
				}while(opcion==1);
		
				if(opcion==2) 
				{
					pintaMenuGestion(e); //SI NO PINTA MENÚ DE GESTIÓN
				}
		
			break;
				
				case 3: //COCHE ELÉCTRICO
				do {
					Coche_electrico ce= metodosprograma.Interfazdeusuario.pideCocheElectricoExiste(e); 
					
					opcion=menuModificarCocheElectrico();
					
					switch(opcion) {
					
					case 1: //MARCA
						ce.setMarca(metodos.MetodosInterfazUsuario.pideStringValidada("Introduzca la Marca", 30)); //SI QUIERE MODIFICAR LA MARCA SE LA PIDE
					break;
					
					case 2: //MODELO
						ce.setModelo(metodos.MetodosInterfazUsuario.pideStringValidada("Introduzca el Modelo", 25)); //SI QUIERE MODIFICAR EL MODELO SE LO PIDE
					break;
					
					case 3: //FECHA DE ALTA
						ce.setFechadealta(metodosprograma.Interfazdeusuario.pideFecha()); //SI QUIERE MODIFICAR LA FECHA SE LA PIDE
					break;
					
					case 4: //KM
						ce.setKm(metodos.MetodosInterfazUsuario.pideIntValidadoMIN("Introduzca los KM", 0)); //SI QUIERE MODIFICAR LOS KM SE LOS PIDE
					break;
					
					case 5: //CATEGORÍA
						ce.setCategoria(metodosprograma.Interfazdeusuario.pideCategoria()); //SI QUIERE MODIFICAR LA CATEGORÍA SE LA PIDE
					break;
						
					case 6: //OFICINA
						ce.setOficina(metodosprograma.Interfazdeusuario.pideOficinaExiste(e)); //SI QUIERE MODIFICAR LA OFICINA SE LA PIDE
					break;
					
					case 7: //AUTONOMÍA 
						ce.setAutonomia(metodos.MetodosInterfazUsuario.pideStringValidada("Introduzca la Autonomía", 25)); //SI QUIERE MODIFICAR LA AUTONOMÍA SE LA PIDE
					break;
					
					case 8:	//TIEMPO DE RECARGA
						ce.setTiempoderecarga(metodos.MetodosInterfazUsuario.pideStringValidada("Introduzca el Tiempo de Recarga", 25)); //SI QUIERE MODIFICAR EL TIEMPO DE RECARGA SE LO PIDE
					break;
					
					case 9: //Nº PLAZAS 
						ce.setNplazas(metodos.MetodosInterfazUsuario.pideIntValidado("Introduzca el Número de Plazas del Coche", 10, 1)); //SI QUIERE MODIFICAR EL Nº DE PLAZAS SE LO PIDE
					break;
					
					case 10: //TIPO
						ce.setTipo(metodos.MetodosInterfazUsuario.pideStringValidada("Introduzca el Tipo de Coche", 15)); //SI QUIERE MODIFICAR EL TIPO SE LO PIDE
					break;
					
					case 11:
						menuVehiculoAModificar();
					break;
				
					
					}
			
					opcion=menuSiNo("¿QUIERES MODIFICAR ALGUNO MÁS?"); //ELIJA SI O NO PREGUNTA SI SE QUIERE BORRAR ALGUNO MÁS
				
				}while(opcion==1);
		
				if(opcion==2) 
				{
					pintaMenuGestion(e); //SI NO PINTA MENÚ DE GESTIÓN
				}
		
				break;
				
				case 4: //MOTO
				do {
					Moto m= metodosprograma.Interfazdeusuario.pideMotoExiste(e); 
					
					opcion=menuModificarMoto();
					
					switch(opcion) {
					
					case 1: //MARCA
						m.setMarca(metodos.MetodosInterfazUsuario.pideStringValidada("Introduzca la Marca", 30)); //SI QUIERE MODIFICAR LA MARCA SE LA PIDE
					break;
					
					case 2: //MODELO
						m.setModelo(metodos.MetodosInterfazUsuario.pideStringValidada("Introduzca el Modelo", 25)); //SI QUIERE MODIFICAR EL MODELO SE LO PIDE
					break;
					
					case 3: //FECHA DE ALTA
						m.setFechadealta(metodosprograma.Interfazdeusuario.pideFecha()); //SI QUIERE MODIFICAR LA FECHA SE LA PIDE
					break;
					
					case 4: //KM
						m.setKm(metodos.MetodosInterfazUsuario.pideIntValidadoMIN("Introduzca los KM", 0)); //SI QUIERE MODIFICAR LOS KM SE LOS PIDE
					break;
					
					case 5: //CATEGORÍA
						m.setCategoria(metodosprograma.Interfazdeusuario.pideCategoria()); //SI QUIERE MODIFICAR LA CATEGORÍA SE LA PIDE
					break;
						
					case 6: //OFICINA
						m.setOficina(metodosprograma.Interfazdeusuario.pideOficinaExiste(e)); //SI QUIERE MODIFICAR LA OFICINA SE LA PIDE
					break;
					
					case 7: //AUTONOMÍA 
						m.setAutonomia(metodos.MetodosInterfazUsuario.pideStringValidada("Introduzca la Autonomía", 25)); //SI QUIERE MODIFICAR LA AUTONOMÍA SE LA PIDE
					break;
					
					case 8:	//TIEMPO DE RECARGA
						m.setTiempoderecarga(metodos.MetodosInterfazUsuario.pideStringValidada("Introduzca el Tiempo de Recarga", 25)); //SI QUIERE MODIFICAR EL TIEMPO DE RECARGA SE LO PIDE
					break;
					
					case 9: //CILINDRADA 
						m.setCilindrada(metodos.MetodosInterfazUsuario.pideStringValidada("Introduce la Cilindrada", 10));
					break;
					
					case 10: //TIPO
						m.setCarnet(metodosprograma.Interfazdeusuario.pideCarnet());
					break;
					
					case 11:
						menuVehiculoAModificar();
					break;
				
					
					}
			
			
					opcion=menuSiNo("¿QUIERES MODIFICAR ALGUNO MÁS?"); //ELIJA SI O NO PREGUNTA SI SE QUIERE BORRAR ALGUNO MÁS
				
				}while(opcion==1);
		
				if(opcion==2) 
				{
					pintaMenuGestion(e); //SI NO PINTA MENÚ DE GESTIÓN
				}
		
			break;
				case 5:
					pintaMenuModificar(e);
				break;
			}
			
		break;	
		
		case 4: 
			do {
				
				Oficina o= metodosprograma.Interfazdeusuario.pideOficinaExiste(e);
				
				opcion=menuModificarOficina(); //PINTA EL MENÚ DE MODIFICAR OFICINA
				
				switch (opcion) {
				
				case 1: 
					o.setDescripcion(metodos.MetodosInterfazUsuario.pideStringValidada("Introduzca una Descripción", 30)); //SI QUIERE MODIFICAR LA DESCRIPCIÓN SE LA PIDE
				break;
				
				case 2:
					o.setLocalidad(metodos.MetodosInterfazUsuario.pideStringValidada("Introduzca la Localidad", 30)); //SI QUIERE MODIFICAR LA LOCALIDAD SE LA PIDE
				break;
				
				case 3:	
					o.setProvincia(metodos.MetodosInterfazUsuario.pideStringValidada("Introduzca la Provincia", 30)); //SI QUIERE MODIFICAR LA PROVINCIA SE LA PIDE
				break;
				
				case 4:
					
					String aeropuerto="";
					int respuesta=metodosprograma.Menus.menuSiNo("¿Es una Oficina de Aeropuerto?"); //SI QUIERE MODIFICAR SI ES DE AEROPUERTO SE LO PREGUNTA
					
					if(respuesta==1) 
					{
						aeropuerto="SI";
					}
					else
					if(respuesta==2) 
					{
						aeropuerto="NO";
					}	
					
					o.setAeropuerto(aeropuerto);
					
				break;
				
				case 5:
					pintaMenuModificar(e);
				break;
				
				}
				
				opcion=menuSiNo("¿QUIERES MODIFICAR ALGUNO MÁS?"); //ELIJA SI O NO PREGUNTA SI SE QUIERE BORRAR ALGUNO MÁS
			
			}while(opcion==1);
			
			if(opcion==2) 
			{
				pintaMenuGestion(e); //SI NO PINTA MENÚ DE GESTIÓN
			}
	
		break;
			
		case 5: pintaMenuGestion(e); //PINTA EL MENÚ DE GESTIÓN
		break;	
	
		case 6: pintaMenuPrincipal(e); //PINTA EL MENÚ PRINCIPAL
		break;
	}
	
}



/*
 * PINTA MENÚ PARA BORRAR DATOS
 */
public static void pintaMenuBorrar(Empresa e) throws Exception {
	
	String lista[]={ "CLIENTE", "EMPLEADO", "VEHÍCULO", "OFICINA", "GESTIÓN DE NEGOCIO", "MENÚ PRINCIPAL"}; 
	int valoresvalidos[]={ 1, 2, 3, 4, 5, 6};
	int opcion;
	
	
	opcion=metodos.MetodosPintarPantalla.menu(lista, valoresvalidos, "¿QUE QUIERES BORRAR?" , "ELIJA UNA OPCIÓN" );
		
	switch (opcion) {
	
	   case 1: 
			
			do {
				
				String dni=metodos.MetodosValidadores.pideDniCorrecto("Introduce el DNI del Cliente"); //PIDE EL DNI DEL CLIENTE A BORRAR
				
				opcion=menuSiNo("¿SEGURO QUE QUIERE BORRAR AL CLIENTE: "+e.buscaCliente(dni)+"?");
				
				switch(opcion) {
				
				case 1: e.borraCliente(dni); //BORRA AL CLIENTE SI ELIGE SI
				break;
				
				}
				
				opcion=menuSiNo("¿QUIERES BORRAR ALGUNO MÁS?"); //ELIJA SI O NO PREGUNTA SI SE QUIERE BORRAR ALGUNO MÁS
			
			}while(opcion==1);
			
			if(opcion==2) 
			{
				pintaMenuGestion(e); //SI NO PINTA MENÚ DE GESTIÓN
			}
			
		break;
	
		
		case 2: 
			
			do {
			
				String dni=metodos.MetodosValidadores.pideDniCorrecto("Introduce el DNI del Empleado"); //PIDE EL DNI DEL EMPLEADO A BORRAR
					
				opcion=menuSiNo("¿SEGURO QUE QUIERE BORRAR AL EMPLEADO: "+e.buscaEmpleado(dni)+"?");
				
				switch(opcion) {
				
				case 1: e.borraEmpleado(dni); //BORRA AL EMPLEADO SI ELIGE SI
				break;
				
				}
				
				opcion=menuSiNo("¿QUIERES BORRAR ALGUNO MÁS?"); //ELIJA SI O NO PREGUNTA SI QUIERE BORRAR ALGUNO MÁS
		
			}while(opcion==1);
		
			if(opcion==2) 
			{
				pintaMenuGestion(e); //SI NO PINTA MENÚ DE GESTIÓN
			}
			
		break;	
	
		case 3:
			
			do {
			
				String matricula=metodos.MetodosInterfazUsuario.pideStringValidada("Introduzca la Matrícula", 7); //PIDE LA MATRÍCULA DEL VEHÍCULO A BORRAR
			
				opcion=menuSiNo("¿SEGURO QUE QUIERE BORRAR EL VEHÍCULO: "+e.buscaVehiculo(matricula)+"?");
				
				switch(opcion) {
				
				case 1: e.borraVehiculo(matricula); //BORRA AL VEHÍCULO SI ELIGE SI
				break;
				
				}
			
				opcion=menuSiNo("¿QUIERES BORRAR ALGUNO MÁS?"); //PREGUNTA SI QUIERE BORRAR ALGUNO MÁS
			
			}while(opcion==1);
		
			if(opcion==2) 
			{
				pintaMenuGestion(e); //SI NO PINTA EL MENÚ DE GESTIÓN
			}
		
			break;
		
		case 4:  
			
			do {
				
				String codigo=metodos.MetodosInterfazUsuario.pideStringValidada("Introduzca el Código de la Oficina", 10); //PIDE EL CÓDIGO DE LA OFICINA A BORRAR
			
				opcion=menuSiNo("¿SEGURO QUE QUIERE BORRAR LA OFICINA: "+e.buscaOficina(codigo)+"?");
				
				switch(opcion) {
				
				case 1: e.borraOficina(codigo); //BORRA AL VEHÍCULO SI ELIGE SI
				break;
				
				}
			
			
				opcion=menuSiNo("¿QUIERES BORRAR ALGUNA MÁS?"); //PREGUNTA SI QUIERE BORRAR ALGUNA MÁS
			
			}while(opcion==1);
		
			if(opcion==2) 
			{
				pintaMenuGestion(e); //SI NO PINTA EL MENÚ DE GESTIÓN
			}
		
			break;

	
		case 5: pintaMenuGestion(e); //PINTA EL MENÚ DE GESTIÓN
		break;	
	
		case 6: pintaMenuPrincipal(e); //PINTA EL MENÚ PRINCIPAL
		break;
	}
	
}


/*
 * METODO PARA PINTAR EL MENÚ DE BUSCAR
 */
public static void pintaMenuBuscar(Empresa e) throws Exception {
	
	String lista[]={ "CLIENTE", "EMPLEADO", "VEHÍCULO", "OFICINA", "GESTIÓN DE NEGOCIO", "MENÚ PRINCIPAL"}; 
	int valoresvalidos[]={ 1, 2, 3, 4, 5, 6};
	int opcion;
	
	
	opcion=metodos.MetodosPintarPantalla.menu(lista, valoresvalidos, "¿QUE QUIERES BUSCAR?" , "ELIJA UNA OPCIÓN" );
		
	switch (opcion) {
	
	   case 1: 
			
			do {
				
				String dni=metodos.MetodosValidadores.pideDniCorrecto("Introduce el DNI del Cliente"); //PIDE EL DNI DEL CLIENTE A BUSCAR
				
				System.out.println(e.buscaCliente(dni)); //PINTA EL CLIENTE
				
				opcion=menuSiNo("¿QUIERES BUSCAR ALGUNO MÁS?"); //PREGUNTA SI QUIERE BORRA ALGUNO MÁS
			
			}while(opcion==1);
			
			if(opcion==2) {
				pintaMenuGestion(e); //SI NO PINTA EL MENÚ DE GESTIÓN
			}
			
		break;
	
		
		case 2: 
			
			do {
			
				String dni=metodos.MetodosValidadores.pideDniCorrecto("Introduce el DNI del Empleado");
			
				System.out.println(e.buscaEmpleado(dni));  //PINTA EL EMPLEADO
			
				opcion=menuSiNo("¿QUIERES BUSCAR ALGUNO MÁS?"); //PREGUNTA SI QUIERE BUSCAR ALGUNO MÁS
		
			}while(opcion==1);
		
			if(opcion==2) {
				pintaMenuGestion(e); //SI NO PINTA EL MENÚ DE GESTIÓN
			}
			
		break;	
	
		case 3:
			
			do {
			
				String matricula=metodos.MetodosInterfazUsuario.pideStringValidada("Introduzca la Matrícula", 7); //PIDE LA MATRÍCULA DEL VEHÍCULO A BORRAR
		
				System.out.println(e.buscaVehiculo(matricula)); //PINTA EL VEHÍCULO
		
				opcion=menuSiNo("¿QUIERES BUSCAR ALGUNO MÁS?"); //PREGUNTA SI QUIERE BUSCAR ALGUN MÁS
		
			}while(opcion==1);
	
			if(opcion==2) 
			{
				pintaMenuGestion(e); //SI NO PINTA EL MENÚ DE GESTIÓN
			}
	
		break;	
		
		case 4:  
		
			do {
			
				String codigo=metodos.MetodosInterfazUsuario.pideStringValidada("Introduzca el Código de la Oficina", 10); //PIDE EL CÓDIGO DE LA OFICINA A BORRAR
	
				System.out.println(e.buscaOficina(codigo)); //BUSCA LA OFICINA
	
				opcion=menuSiNo("¿QUIERES BUSCAR ALGUNA MÁS?"); //PREGUNTA SI QUIERE BUSCAR ALGUNA MÁS 
	
			}while(opcion==1);

			if(opcion==2) 
			{
				pintaMenuGestion(e); //SI NO PINTA EL MENÚ DE GESTIÓN
			}

			break;	
	
		case 5: pintaMenuGestion(e); //PINTA EL MENÚ DE GESTIÓN
		break;	
	
		case 6: pintaMenuPrincipal(e); //PINTA EL MENÚ PRINCIPAL
		break;
	}
	
}


/*
 * METODO PARA PINTAR EL MENÚ DE LOS ALQUILERES
 */
public static void pintaMenuAlquiler(Empresa e) throws Exception {
	
	String lista[]={ "REALIZAR ALQUILER", "DEVOLUCIÓN DE VEHÍCULO", "MENÚ PRINCIPAL" }; 
	int valoresvalidos[]={ 1, 2, 3};
	
	int opcion=metodos.MetodosPintarPantalla.menu(lista, valoresvalidos, "GESTIÓN DE ALQUILERES" , "ELIJA UNA OPCIÓN" );
	
	switch (opcion) {
	
		case 1: Alquiler a1=metodosprograma.Interfazdeusuario.pideDatosAlquiler(e); //PIDE LOS DATOS DEL ALQUILER
				System.out.println("ALQUILER REALIZADO EL PRECIO ESTIMADO SERÍA: "+a1.getPrecio()+"€");
				pintaMenuGestion(e);
		break;	

		case 2: Alquiler a2=e.buscaAlquiler(metodos.MetodosInterfazUsuario.pideStringValidada("Introduzca el código del Alquiler", 7));
				Devolucion d=metodosprograma.Interfazdeusuario.pideDatosDevolucion(e, a2); 
				System.out.println("LA DEVOLUCIÓN SE HA REALIZADO, EL PRECIO FINAL SERÍA: "+d.getPrecio()+"€");
				pintaMenuGestion(e);
		break;	

		case 3: pintaMenuPrincipal(e); //PINTA EL MENÚ PRINCIPAL
		break;	

	}
	
}


/*
 * METODO PARA PINTAR LOS LISTADOS
 */
public static void pintaMenuListados(Empresa e) throws Exception {
	
	String lista[]={ "VEHÍCULOS ALQUILADOS", "VEHÍCULOS DISPONIBLES", "OFICINAS", "CLIENTES", "EMPLEADOS", "MENÚ PRINCIPAL"}; 
	int valoresvalidos[]={ 1, 2, 3, 4, 5, 6};
	
	int opcion=metodos.MetodosPintarPantalla.menu(lista, valoresvalidos, "LISTADOS" , "ELIJA UNA OPCIÓN" );
	
	switch (opcion) {
	
		case 1: 
			do {
		
				e.pintaListadeVehiculosNoDisponibles(); //SACA LA LISTA DE VEHÍCULOS QUE NO ESTÁN DISPONIBLES
				opcion=menuSiNo("¿QUIERES VOLVER AL MENÚ DE LISTADOS?");

			}while(opcion==2);

			if(opcion==1) 
			{
				pintaMenuListados(e); //SI ELIJE SI PINTA EL MENÚ DE LISTADOS
			}

			break;

		case 2:
			do {
		
				e.pintaListadeVehiculos(); //SACA LA LISTA DE LOS VEHÍCULOS DISPONIBLES
				opcion=menuSiNo("¿QUIERES VOLVER AL MENÚ DE LISTADOS?"); //PREGUNTA SI QUIERE VOLVER AL MENÚ ANTERIOR
	
			}while(opcion==2);
	
			if(opcion==1) 
			{
				pintaMenuListados(e); //SI ELIJE SI PINTA EL MENÚ DE LOS LISTADOS
			}
	
		break;
	
	
		case 3: 
			do {
	
				e.pintaListadeOficinas(); //SACA LA LISTA DE LAS OFICINAS
				opcion=menuSiNo("¿QUIERES VOLVER AL MENÚ DE LISTADOS?"); //PREGUNTA SI QUIERE VOLVER AL MENÚ ANTERIOR

			}while(opcion==2);

			if(opcion==1) 
			{
				pintaMenuListados(e); //SI ELIJE SI PINTA EL MENÚ DE LOS LISTADOS
			}
		
		break;	

		case 4: 
			do {
				
				e.pintaListadeClientes(); //SACA LA LISTA DE LOS CLIENTES
				opcion=menuSiNo("¿QUIERES VOLVER AL MENÚ DE LISTADOS?"); //PREGUNTA SI QUIERE VOLVER AL MENÚ ANTERIOR
			
			}while(opcion==2);
			
			if(opcion==1) 
			{
				pintaMenuListados(e); //SI ELIJE SI PINTA EL MENÚ DE LISTADOS
			}
				
		break;	

		case 5: 
			do {
			
				e.pintaListadeEmpleados(); //SACA LA LISTA DE LOS EMPLEADOS
				opcion=menuSiNo("¿QUIERES VOLVER AL MENÚ DE LISTADOS?"); //PREGUNTA SI QUIERE VOLVER AL MENÚ ANTERIOR
		
			}while(opcion==2);
		
			if(opcion==1) 
			{
				pintaMenuListados(e); //SI ELIJE SI PINTA EL MENÚ DE LISTADOS
			}
		
		break;	

		case 6: pintaMenuPrincipal(e); //PINTA EL MENÚ PRINCIPAL
	}
	
	
}


/*
 * MENU PARA QUE EL USUARIO ELIJA SI QUIERE COMBUSTIÓN O ELÉTRICO
 * SI ELIGE 1 QUIERE COMBUSTIÓN SI ELIGE 2 QUIERE ELÉCTRICO
 */
public static int menuElecOComb() throws OpcionNoValidaException  {

	String lista[]={ "COMBUSTIÓN", "ELÉCTRICO" }; 
	int valoresvalidos[]={ 1, 2 };
	
	int opcion=metodos.MetodosPintarPantalla.menu(lista, valoresvalidos, "¿QUE TIPO DE VEHÍCULO QUIERES AÑADIR?" , "ELIJA UNA OPCIÓN" );
	
	return opcion;
}


/*
 * MENU PARA QUE EL USUARIO ELIJA QUE MODELO DE VEHÍCULO ELÉTRICO QUIERE
 * SI ELIGE 1 QUIERE COCHE SI ELIGE 2 QUIERE MOTO
 */
public static int menuElectricos() {
	
	String lista[]={ "COCHE", "MOTO" }; 
	int valoresvalidos[]={ 1, 2 };
	
	int opcion=metodos.MetodosPintarPantalla.menu(lista, valoresvalidos, "¿QUE MODELO DE VEHÍCULO QUIERES AÑADIR?" , "ELIJA UNA OPCIÓN" );
	
	return opcion;
	
}


/*
 * MENU PARA QUE EL USUARIO ELIJA QUE MODELO DE VEHÍCULO DE COMBUSTIÓN QUIERE
 * SI ELIGE 1 QUIERE COCHE SI ELIGE 2 QUIERE FURGONETA
 */
public static int menuCombustion() {
	
	String lista[]={ "COCHE", "FURGONETA" }; 
	int valoresvalidos[]={ 1, 2 };
	
	int opcion=metodos.MetodosPintarPantalla.menu(lista, valoresvalidos, "¿QUE MODELO DE VEHÍCULO QUIERES AÑADIR?" , "ELIJA UNA OPCIÓN" );
	
	return opcion;
	
}


/*
 * MENU PARA QUE EL USUARIO ELIJA SI O NO
 * SI ELIJE 1 QUIERE CONTINUAR SI ELIJE 2 NO QUIERE
 */
public static int menuSiNo(String titulo) {
	
	String lista[]={ "SI", "NO" }; 
	int valoresvalidos[]={ 1, 2 };
	
	int opcion=metodos.MetodosPintarPantalla.menu(lista, valoresvalidos, titulo , "ELIJA UNA OPCIÓN" );
	
	return opcion;
}

/*
 * MENÚ PARA MODIFICAR UN CLIENTE
 * MUESTRA LAS PROPIEDADES DE CLIENTE 
 */
public static int menuModificarCliente() {
	
	String lista[]={ "NOMBRE", "PRIMER APELLIDO", "SEGUNDO APELLIDO", "TIPO DE CARNET DE CONDUCIR", "CÓDIGO DE CLIENTE", "VOLVER"}; 
	int valoresvalidos[]={ 1, 2, 3, 4, 5, 6 };
	
	int opcion=metodos.MetodosPintarPantalla.menu(lista, valoresvalidos, "¿QUÉ QUIERES MODIFICAR?" , "ELIJA UNA OPCIÓN" );

	return opcion;
}


/*
 * MENÚ PARA MODIFICAR UN CLIENTE
 * MUESTRA LAS PROPIEDADES DE CLIENTE 
 */
public static int menuModificarEmpleado() {
	
	String lista[]={ "NOMBRE", "PRIMER APELLIDO", "SEGUNDO APELLIDO", "FECHA DE ALTA", "OFICINA", "VOLVER" }; 
	int valoresvalidos[]={ 1, 2, 3, 4, 5, 6 };
	
	int opcion=metodos.MetodosPintarPantalla.menu(lista, valoresvalidos, "¿QUÉ QUIERES MODIFICAR?" , "ELIJA UNA OPCIÓN" );

	return opcion;
}


/*
 * MENÚ PARA MODIFICAR UN VEHÍCULO
 * MUESTRA LAS PROPIEDADES DE UN VEHÍCULO
 */
public static int menuModificarVehiculo() {
	
	int opcion=0;
	return opcion;
}


/*
 * MENÚ MODIFICAR OFICINA
 * MUESTRA LAS PROPIEDADES DE OFICINA
 */
public static int menuModificarOficina() {
	
	String lista[]={ "DESCRIPCIÓN", "LOCALIDAD", "PROVINCIA", "TIENE AEROPUERTO", "VOLVER" }; 
	int valoresvalidos[]={ 1, 2, 3, 4, 5 };
	
	int opcion=metodos.MetodosPintarPantalla.menu(lista, valoresvalidos, "¿QUÉ QUIERES MODIFICAR?" , "ELIJA UNA OPCIÓN" );

	return opcion;
	
}


/*
 * MENÚ PARA ELEGIR SI QUIERE SACAR LOS VEHÍCULOS POR CATEGORÍA O POR OFICINA
 */
public static int menuCategoriaOficina() {
	
	String lista[]={ "CATEGORÍA", "OFICINA" }; 
	int valoresvalidos[]={ 1, 2 };
	
	int opcion=metodos.MetodosPintarPantalla.menu(lista, valoresvalidos, "¿POR QUÉ QUIERES BUSCAR?" , "ELIJA UNA OPCIÓN" );

	return opcion;
	
}


/*
 * MENÚ PARA ELEGIR QUE VEHÍCULO QUIERE MODIFICAR
 */
public static int menuVehiculoAModificar() {
	
	String lista[]={ "COCHE DE COMBUSTIÓN", "FURGONETA", "COCHE ELÉCTRICO", "MOTO", "VOLVER" }; 
	int valoresvalidos[]={ 1, 2, 3, 4, 5 };
	
	int opcion=metodos.MetodosPintarPantalla.menu(lista, valoresvalidos, "¿QUÉ VEHÍCULO QUIERES MODIFICAR?" , "ELIJA UNA OPCIÓN" );

	return opcion;
	
}


/*
 * MENÚ MODIFICAR COCHE DE COMBUSTIÓN
 * MUESTRA LAS PROPIEDADES DE COCHE DE COMBUSTIÓN
 */
public static int menuModificarCocheCombustion() {
	
	String lista[]={ "MARCA", "MODELO", "FECHA DE ALTA", "KM", "CATEGORÍA", "OFICINA", "CONSUMO", "POTENCIA", "Nº PLAZAS", "TIPO", "VOLVER"  }; 
	int valoresvalidos[]={ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
	
	int opcion=metodos.MetodosPintarPantalla.menu(lista, valoresvalidos, "¿QUÉ QUIERES MODIFICAR?" , "ELIJA UNA OPCIÓN" );

	return opcion; 
	
}


/*
 * MENÚ MODIFICAR FURGONETA
 * MUESTRA LAS PROPIEDADES DE FURGONETA
 */
public static int menuModificarFurgoneta() {
	
	String lista[]={ "MARCA", "MODELO", "FECHA DE ALTA", "KM", "CATEGORÍA", "OFICINA", "CONSUMO", "POTENCIA", "CAPACIDAD", "CARNET", "VOLVER"  }; 
	int valoresvalidos[]={ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
	
	int opcion=metodos.MetodosPintarPantalla.menu(lista, valoresvalidos, "¿QUÉ QUIERES MODIFICAR?" , "ELIJA UNA OPCIÓN" );

	return opcion;
	
}


/*
 * MENÚ MODIFICAR COCHE ELÉCTRICO
 * MUESTRA LAS PROPIEDADES DE COCHE ELÉCTRICO
 */
public static int menuModificarCocheElectrico() {
	
	String lista[]={ "MARCA", "MODELO", "FECHA DE ALTA", "KM", "CATEGORÍA", "OFICINA", "AUTONOMÍA", "TIEMPO DE RECARGA", "Nº PLAZAS", "TIPO", "VOLVER"  }; 
	int valoresvalidos[]={ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
	
	int opcion=metodos.MetodosPintarPantalla.menu(lista, valoresvalidos, "¿QUÉ QUIERES MODIFICAR?" , "ELIJA UNA OPCIÓN" );

	return opcion;
	
}


/*
 * MENÚ MODIFICAR MOTO
 * MUESTRA LAS PROPIEDADES DE MOTO
 */
public static int menuModificarMoto() {
	
	String lista[]={ "MARCA", "MODELO", "FECHA DE ALTA", "KM", "CATEGORÍA", "OFICINA", "AUTONOMÍA", "TIEMPO DE RECARGA", "CILINDRADA", "CARNET", "VOLVER"  }; 
	int valoresvalidos[]={ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
	
	int opcion=metodos.MetodosPintarPantalla.menu(lista, valoresvalidos, "¿QUÉ QUIERES MODIFICAR?" , "ELIJA UNA OPCIÓN" );

	return opcion;
	
}




	
}
