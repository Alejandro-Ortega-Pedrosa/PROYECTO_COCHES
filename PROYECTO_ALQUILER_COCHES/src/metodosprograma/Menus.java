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
 * METODO PARA PINTAR EL MEN� PRINCIPAL 
 * SI SE ELIGE LA OPCI�N DE FINALIZAR PROGRAMA SE ACABA EL PROGRAMA Y GRABA LA EMPRESA
 */
public static int pintaMenuPrincipal(Empresa e) throws Exception {
	

	String lista[]={ "GESTI�N DE NEGOCIO", "GESTI�N DE ALQUILERES", "LISTADOS", "FINALIZAR PROGRAMA" }; 
	int valoresvalidos[]={ 1, 2, 3, 4};
	
	int opcion=metodos.MetodosPintarPantalla.menu(lista, valoresvalidos, "MEN� PRINCIPAL" , "ELIJA UNA OPCI�N" );

	switch (opcion) {
	
		case 1: pintaMenuGestion(e); //PINTA EL MEN� DE GESTI�N
		break;	
		
		case 2: pintaMenuAlquiler(e); //PINTA EL MEN� DE LOS ALQUILERES
		break;	
	
		case 3: pintaMenuListados(e); //PINTA EL MEN� DE LOS LISTADOS
		break;	
	
		case 4: Empresa.grabaEmpresa(e);
		System.out.println("FIN DEL PROGRAMA"); //FIN DEL PROGRAMA
		break;
	}
		
	return opcion;
}


/*
 * METODO PARA PINTAR EL MEN� DE LA GESTI�N 
 */
public static void pintaMenuGestion(Empresa e) throws Exception {
	
	String lista[]={ "A�ADIR", "MODIFICAR", "BORRAR", "BUSCAR", "MEN� PRINCIPAL" }; 
	int valoresvalidos[]={ 1, 2, 3, 4, 5};
	
	int opcion=metodos.MetodosPintarPantalla.menu(lista, valoresvalidos, "GESTI�N DE NEGOCIO" , "ELIJA UNA OPCI�N" );
	
	switch (opcion) {
	
		case 1: pintaMenuAdd(e); //PINTA EL MEN� DE LOS LISTADOS
		break;	

		case 2: pintaMenuModificar(e); //PINTA EL MEN� DE MODIFICAR
		break;	

		case 3: pintaMenuBorrar(e); //PINTA EL MEN� DE BORRAR
		break;	

		case 4: pintaMenuBuscar(e); //PINTA EL MEN� DE BUSCAR
		break;	

		case 5: pintaMenuPrincipal(e); //PINTA EL MEN� PRINCIPAL
	}

}


/*
 * METODO PARA PINTAR EL MEN� DE A�ADIR UN CLIENTE, EMPLEADO, COCHE, OFICINA
 */
public static void pintaMenuAdd(Empresa e) throws Exception {
	
	String lista[]={ "CLIENTE", "EMPLEADO", "VEH�CULO", "OFICINA", "GESTI�N DE NEGOCIO", "MEN� PRINCIPAL"}; 
	int valoresvalidos[]={ 1, 2, 3, 4, 5, 6};
	int opcion;
	
	
	opcion=metodos.MetodosPintarPantalla.menu(lista, valoresvalidos, "�QUE QUIERES A�ADIR?" , "ELIJA UNA OPCI�N" );
		
	switch (opcion) {
	
	   case 1: 
			
			do {
				
				e.addCliente(); //A�ADE UN CLIENTE
				opcion=menuSiNo("�QUIERES A�ADIR ALGUNO M�S?"); //PREGUNTA SI QUIERE A�ADIR M�S
			
			}while(opcion==1);
			
			if(opcion==2) 
			{
				pintaMenuGestion(e); //SI ELIJE NO PINTA MEN� DE GESTI�N
			}
			
		break;
	
		
		case 2: 
			
			do {
		
				e.addEmpleado(e); //A�ADE UN EMPLEADO
				opcion=menuSiNo("�QUIERES A�ADIR ALGUNO M�S?"); //PREGUNTA SI QUIERE A�ADIR M�S
	
			}while(opcion==1);
	
			if(opcion==2) 
			{
				pintaMenuGestion(e); //SI ELIJE NO PINTA EL MEN� DE GESTI�N
			}
	
		break;
		
		case 3: 
		
			do {
			
				e.addVehiculo(e); //A�ADE UN VEH�CULO
				opcion=menuSiNo("�QUIERES A�ADIR ALGUNO M�S?"); //PREGUNTA SI QUIERE A�ADIR M�S

			}while(opcion==1);

			if(opcion==2) 
			{
				pintaMenuGestion(e); //SI ELIJE NO PINTA EL MEN� DE GESTI�N
			}

		break;	
		
		case 4: 
			
			do {
		
				e.addOficina(); //A�ADE UNA OFICINA
				opcion=menuSiNo("�QUIERES A�ADIR ALGUNA M�S?"); //PREGUNTA SI QUIERE A�ADIR M�S

			}while(opcion==1);

			if(opcion==2) 
			{
				pintaMenuGestion(e); //SI ELIJE NO PINTA EL MEN� DE GESTI�N
			}

			break;

	
		case 5: pintaMenuGestion(e); //PINTA EL MEN� DE GESTI�N
		break;	
	
		case 6: pintaMenuPrincipal(e); //PINTA EL MEN� PRINCIPAL
		break;
	}
	
}


/*
 * METODO PARA PINTAR EL MEN� DE MODIFICAR DATOS
 */
public static void pintaMenuModificar(Empresa e) throws Exception {
	
	String lista[]={ "CLIENTE", "EMPLEADO", "VEH�CULO", "OFICINA", "GESTI�N DE NEGOCIO", "MEN� PRINCIPAL"}; 
	int valoresvalidos[]={ 1, 2, 3, 4, 5, 6};
	int opcion;
	

	opcion=metodos.MetodosPintarPantalla.menu(lista, valoresvalidos, "�QUE QUIERES MODIFICAR?" , "ELIJA UNA OPCI�N" );
		
	switch (opcion) {
	
	    case 1: 
	    	do {
				
				Cliente c= metodosprograma.Interfazdeusuario.pideClienteExiste(e);
				
				opcion=menuModificarCliente(); //PINTA EL MEN� DE MODIFICAR CLIENTE
				
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
					c.setId(metodos.MetodosInterfazUsuario.pideStringValidada("Introduzca el C�digo del Cliente", 10)); //SI QUIERE MODIFICAR EL ID SE LO PIDE
				break;
				
				case 6:
					pintaMenuModificar(e);
				break;
				
				}
				
				
				opcion=menuSiNo("�QUIERES MODIFICAR ALGUNO M�S?"); //ELIJA SI O NO PREGUNTA SI SE QUIERE BORRAR ALGUNO M�S
			
			}while(opcion==1);
			
			if(opcion==2) 
			{
				pintaMenuGestion(e); //SI NO PINTA MEN� DE GESTI�N
			}
			
		break;
	
		
		case 2: 
			do {
				
				Empleado em= metodosprograma.Interfazdeusuario.pideEmpleadoExiste(e);
				
				opcion=menuModificarEmpleado(); //PINTA EL MEN� DE MODIFICAR EMPLEADO
				
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
					pintaMenuModificar(e); //SI QUIERE VOLVER ATR�S
				break;
				
				}
				
				
				opcion=menuSiNo("�QUIERES MODIFICAR ALGUNO M�S?"); //ELIJA SI O NO PREGUNTA SI SE QUIERE BORRAR ALGUNO M�S
			
			}while(opcion==1);
			
			if(opcion==2) 
			{
				pintaMenuGestion(e); //SI NO PINTA MEN� DE GESTI�N
			}
			
		break;
		
		case 3: 
			
				opcion=menuVehiculoAModificar();
			
				switch(opcion) {
				
					case 1: //COCHE COMBUSTI�N
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
					
						case 5: //CATEGOR�A
							cc.setCategoria(metodosprograma.Interfazdeusuario.pideCategoria()); //SI QUIERE MODIFICAR LA CATEGOR�A SE LA PIDE
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
					
						case 9: //N� PLAZAS 
							cc.setNplazas(metodos.MetodosInterfazUsuario.pideIntValidado("Introduzca el N�mero de Plazas del Coche", 10, 1)); //SI QUIERE MODIFICAR EL N� DE PLAZAS SE LO PIDE
						break;
					
						case 10: //TIPO
							cc.setTipo(metodos.MetodosInterfazUsuario.pideStringValidada("Introduzca el Tipo de Coche", 15)); //SI QUIERE MODIFICAR EL TIPO SE LO PIDE
						break;
					
						case 11:
							menuVehiculoAModificar();
						break;
					
						
						}
				
				
						opcion=menuSiNo("�QUIERES MODIFICAR ALGUNO M�S?"); //ELIJA SI O NO PREGUNTA SI SE QUIERE BORRAR ALGUNO M�S
					
					}while(opcion==1);
			
					if(opcion==2) 
					{
						pintaMenuGestion(e); //SI NO PINTA MEN� DE GESTI�N
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
					
					case 5: //CATEGOR�A
						f.setCategoria(metodosprograma.Interfazdeusuario.pideCategoria()); //SI QUIERE MODIFICAR LA CATEGOR�A SE LA PIDE
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
			
					opcion=menuSiNo("�QUIERES MODIFICAR ALGUNO M�S?"); //ELIJA SI O NO PREGUNTA SI SE QUIERE BORRAR ALGUNO M�S
				
				}while(opcion==1);
		
				if(opcion==2) 
				{
					pintaMenuGestion(e); //SI NO PINTA MEN� DE GESTI�N
				}
		
			break;
				
				case 3: //COCHE EL�CTRICO
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
					
					case 5: //CATEGOR�A
						ce.setCategoria(metodosprograma.Interfazdeusuario.pideCategoria()); //SI QUIERE MODIFICAR LA CATEGOR�A SE LA PIDE
					break;
						
					case 6: //OFICINA
						ce.setOficina(metodosprograma.Interfazdeusuario.pideOficinaExiste(e)); //SI QUIERE MODIFICAR LA OFICINA SE LA PIDE
					break;
					
					case 7: //AUTONOM�A 
						ce.setAutonomia(metodos.MetodosInterfazUsuario.pideStringValidada("Introduzca la Autonom�a", 25)); //SI QUIERE MODIFICAR LA AUTONOM�A SE LA PIDE
					break;
					
					case 8:	//TIEMPO DE RECARGA
						ce.setTiempoderecarga(metodos.MetodosInterfazUsuario.pideStringValidada("Introduzca el Tiempo de Recarga", 25)); //SI QUIERE MODIFICAR EL TIEMPO DE RECARGA SE LO PIDE
					break;
					
					case 9: //N� PLAZAS 
						ce.setNplazas(metodos.MetodosInterfazUsuario.pideIntValidado("Introduzca el N�mero de Plazas del Coche", 10, 1)); //SI QUIERE MODIFICAR EL N� DE PLAZAS SE LO PIDE
					break;
					
					case 10: //TIPO
						ce.setTipo(metodos.MetodosInterfazUsuario.pideStringValidada("Introduzca el Tipo de Coche", 15)); //SI QUIERE MODIFICAR EL TIPO SE LO PIDE
					break;
					
					case 11:
						menuVehiculoAModificar();
					break;
				
					
					}
			
					opcion=menuSiNo("�QUIERES MODIFICAR ALGUNO M�S?"); //ELIJA SI O NO PREGUNTA SI SE QUIERE BORRAR ALGUNO M�S
				
				}while(opcion==1);
		
				if(opcion==2) 
				{
					pintaMenuGestion(e); //SI NO PINTA MEN� DE GESTI�N
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
					
					case 5: //CATEGOR�A
						m.setCategoria(metodosprograma.Interfazdeusuario.pideCategoria()); //SI QUIERE MODIFICAR LA CATEGOR�A SE LA PIDE
					break;
						
					case 6: //OFICINA
						m.setOficina(metodosprograma.Interfazdeusuario.pideOficinaExiste(e)); //SI QUIERE MODIFICAR LA OFICINA SE LA PIDE
					break;
					
					case 7: //AUTONOM�A 
						m.setAutonomia(metodos.MetodosInterfazUsuario.pideStringValidada("Introduzca la Autonom�a", 25)); //SI QUIERE MODIFICAR LA AUTONOM�A SE LA PIDE
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
			
			
					opcion=menuSiNo("�QUIERES MODIFICAR ALGUNO M�S?"); //ELIJA SI O NO PREGUNTA SI SE QUIERE BORRAR ALGUNO M�S
				
				}while(opcion==1);
		
				if(opcion==2) 
				{
					pintaMenuGestion(e); //SI NO PINTA MEN� DE GESTI�N
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
				
				opcion=menuModificarOficina(); //PINTA EL MEN� DE MODIFICAR OFICINA
				
				switch (opcion) {
				
				case 1: 
					o.setDescripcion(metodos.MetodosInterfazUsuario.pideStringValidada("Introduzca una Descripci�n", 30)); //SI QUIERE MODIFICAR LA DESCRIPCI�N SE LA PIDE
				break;
				
				case 2:
					o.setLocalidad(metodos.MetodosInterfazUsuario.pideStringValidada("Introduzca la Localidad", 30)); //SI QUIERE MODIFICAR LA LOCALIDAD SE LA PIDE
				break;
				
				case 3:	
					o.setProvincia(metodos.MetodosInterfazUsuario.pideStringValidada("Introduzca la Provincia", 30)); //SI QUIERE MODIFICAR LA PROVINCIA SE LA PIDE
				break;
				
				case 4:
					
					String aeropuerto="";
					int respuesta=metodosprograma.Menus.menuSiNo("�Es una Oficina de Aeropuerto?"); //SI QUIERE MODIFICAR SI ES DE AEROPUERTO SE LO PREGUNTA
					
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
				
				opcion=menuSiNo("�QUIERES MODIFICAR ALGUNO M�S?"); //ELIJA SI O NO PREGUNTA SI SE QUIERE BORRAR ALGUNO M�S
			
			}while(opcion==1);
			
			if(opcion==2) 
			{
				pintaMenuGestion(e); //SI NO PINTA MEN� DE GESTI�N
			}
	
		break;
			
		case 5: pintaMenuGestion(e); //PINTA EL MEN� DE GESTI�N
		break;	
	
		case 6: pintaMenuPrincipal(e); //PINTA EL MEN� PRINCIPAL
		break;
	}
	
}



/*
 * PINTA MEN� PARA BORRAR DATOS
 */
public static void pintaMenuBorrar(Empresa e) throws Exception {
	
	String lista[]={ "CLIENTE", "EMPLEADO", "VEH�CULO", "OFICINA", "GESTI�N DE NEGOCIO", "MEN� PRINCIPAL"}; 
	int valoresvalidos[]={ 1, 2, 3, 4, 5, 6};
	int opcion;
	
	
	opcion=metodos.MetodosPintarPantalla.menu(lista, valoresvalidos, "�QUE QUIERES BORRAR?" , "ELIJA UNA OPCI�N" );
		
	switch (opcion) {
	
	   case 1: 
			
			do {
				
				String dni=metodos.MetodosValidadores.pideDniCorrecto("Introduce el DNI del Cliente"); //PIDE EL DNI DEL CLIENTE A BORRAR
				
				opcion=menuSiNo("�SEGURO QUE QUIERE BORRAR AL CLIENTE: "+e.buscaCliente(dni)+"?");
				
				switch(opcion) {
				
				case 1: e.borraCliente(dni); //BORRA AL CLIENTE SI ELIGE SI
				break;
				
				}
				
				opcion=menuSiNo("�QUIERES BORRAR ALGUNO M�S?"); //ELIJA SI O NO PREGUNTA SI SE QUIERE BORRAR ALGUNO M�S
			
			}while(opcion==1);
			
			if(opcion==2) 
			{
				pintaMenuGestion(e); //SI NO PINTA MEN� DE GESTI�N
			}
			
		break;
	
		
		case 2: 
			
			do {
			
				String dni=metodos.MetodosValidadores.pideDniCorrecto("Introduce el DNI del Empleado"); //PIDE EL DNI DEL EMPLEADO A BORRAR
					
				opcion=menuSiNo("�SEGURO QUE QUIERE BORRAR AL EMPLEADO: "+e.buscaEmpleado(dni)+"?");
				
				switch(opcion) {
				
				case 1: e.borraEmpleado(dni); //BORRA AL EMPLEADO SI ELIGE SI
				break;
				
				}
				
				opcion=menuSiNo("�QUIERES BORRAR ALGUNO M�S?"); //ELIJA SI O NO PREGUNTA SI QUIERE BORRAR ALGUNO M�S
		
			}while(opcion==1);
		
			if(opcion==2) 
			{
				pintaMenuGestion(e); //SI NO PINTA MEN� DE GESTI�N
			}
			
		break;	
	
		case 3:
			
			do {
			
				String matricula=metodos.MetodosInterfazUsuario.pideStringValidada("Introduzca la Matr�cula", 7); //PIDE LA MATR�CULA DEL VEH�CULO A BORRAR
			
				opcion=menuSiNo("�SEGURO QUE QUIERE BORRAR EL VEH�CULO: "+e.buscaVehiculo(matricula)+"?");
				
				switch(opcion) {
				
				case 1: e.borraVehiculo(matricula); //BORRA AL VEH�CULO SI ELIGE SI
				break;
				
				}
			
				opcion=menuSiNo("�QUIERES BORRAR ALGUNO M�S?"); //PREGUNTA SI QUIERE BORRAR ALGUNO M�S
			
			}while(opcion==1);
		
			if(opcion==2) 
			{
				pintaMenuGestion(e); //SI NO PINTA EL MEN� DE GESTI�N
			}
		
			break;
		
		case 4:  
			
			do {
				
				String codigo=metodos.MetodosInterfazUsuario.pideStringValidada("Introduzca el C�digo de la Oficina", 10); //PIDE EL C�DIGO DE LA OFICINA A BORRAR
			
				opcion=menuSiNo("�SEGURO QUE QUIERE BORRAR LA OFICINA: "+e.buscaOficina(codigo)+"?");
				
				switch(opcion) {
				
				case 1: e.borraOficina(codigo); //BORRA AL VEH�CULO SI ELIGE SI
				break;
				
				}
			
			
				opcion=menuSiNo("�QUIERES BORRAR ALGUNA M�S?"); //PREGUNTA SI QUIERE BORRAR ALGUNA M�S
			
			}while(opcion==1);
		
			if(opcion==2) 
			{
				pintaMenuGestion(e); //SI NO PINTA EL MEN� DE GESTI�N
			}
		
			break;

	
		case 5: pintaMenuGestion(e); //PINTA EL MEN� DE GESTI�N
		break;	
	
		case 6: pintaMenuPrincipal(e); //PINTA EL MEN� PRINCIPAL
		break;
	}
	
}


/*
 * METODO PARA PINTAR EL MEN� DE BUSCAR
 */
public static void pintaMenuBuscar(Empresa e) throws Exception {
	
	String lista[]={ "CLIENTE", "EMPLEADO", "VEH�CULO", "OFICINA", "GESTI�N DE NEGOCIO", "MEN� PRINCIPAL"}; 
	int valoresvalidos[]={ 1, 2, 3, 4, 5, 6};
	int opcion;
	
	
	opcion=metodos.MetodosPintarPantalla.menu(lista, valoresvalidos, "�QUE QUIERES BUSCAR?" , "ELIJA UNA OPCI�N" );
		
	switch (opcion) {
	
	   case 1: 
			
			do {
				
				String dni=metodos.MetodosValidadores.pideDniCorrecto("Introduce el DNI del Cliente"); //PIDE EL DNI DEL CLIENTE A BUSCAR
				
				System.out.println(e.buscaCliente(dni)); //PINTA EL CLIENTE
				
				opcion=menuSiNo("�QUIERES BUSCAR ALGUNO M�S?"); //PREGUNTA SI QUIERE BORRA ALGUNO M�S
			
			}while(opcion==1);
			
			if(opcion==2) {
				pintaMenuGestion(e); //SI NO PINTA EL MEN� DE GESTI�N
			}
			
		break;
	
		
		case 2: 
			
			do {
			
				String dni=metodos.MetodosValidadores.pideDniCorrecto("Introduce el DNI del Empleado");
			
				System.out.println(e.buscaEmpleado(dni));  //PINTA EL EMPLEADO
			
				opcion=menuSiNo("�QUIERES BUSCAR ALGUNO M�S?"); //PREGUNTA SI QUIERE BUSCAR ALGUNO M�S
		
			}while(opcion==1);
		
			if(opcion==2) {
				pintaMenuGestion(e); //SI NO PINTA EL MEN� DE GESTI�N
			}
			
		break;	
	
		case 3:
			
			do {
			
				String matricula=metodos.MetodosInterfazUsuario.pideStringValidada("Introduzca la Matr�cula", 7); //PIDE LA MATR�CULA DEL VEH�CULO A BORRAR
		
				System.out.println(e.buscaVehiculo(matricula)); //PINTA EL VEH�CULO
		
				opcion=menuSiNo("�QUIERES BUSCAR ALGUNO M�S?"); //PREGUNTA SI QUIERE BUSCAR ALGUN M�S
		
			}while(opcion==1);
	
			if(opcion==2) 
			{
				pintaMenuGestion(e); //SI NO PINTA EL MEN� DE GESTI�N
			}
	
		break;	
		
		case 4:  
		
			do {
			
				String codigo=metodos.MetodosInterfazUsuario.pideStringValidada("Introduzca el C�digo de la Oficina", 10); //PIDE EL C�DIGO DE LA OFICINA A BORRAR
	
				System.out.println(e.buscaOficina(codigo)); //BUSCA LA OFICINA
	
				opcion=menuSiNo("�QUIERES BUSCAR ALGUNA M�S?"); //PREGUNTA SI QUIERE BUSCAR ALGUNA M�S 
	
			}while(opcion==1);

			if(opcion==2) 
			{
				pintaMenuGestion(e); //SI NO PINTA EL MEN� DE GESTI�N
			}

			break;	
	
		case 5: pintaMenuGestion(e); //PINTA EL MEN� DE GESTI�N
		break;	
	
		case 6: pintaMenuPrincipal(e); //PINTA EL MEN� PRINCIPAL
		break;
	}
	
}


/*
 * METODO PARA PINTAR EL MEN� DE LOS ALQUILERES
 */
public static void pintaMenuAlquiler(Empresa e) throws Exception {
	
	String lista[]={ "REALIZAR ALQUILER", "DEVOLUCI�N DE VEH�CULO", "MEN� PRINCIPAL" }; 
	int valoresvalidos[]={ 1, 2, 3};
	
	int opcion=metodos.MetodosPintarPantalla.menu(lista, valoresvalidos, "GESTI�N DE ALQUILERES" , "ELIJA UNA OPCI�N" );
	
	switch (opcion) {
	
		case 1: Alquiler a1=metodosprograma.Interfazdeusuario.pideDatosAlquiler(e); //PIDE LOS DATOS DEL ALQUILER
				System.out.println("ALQUILER REALIZADO EL PRECIO ESTIMADO SER�A: "+a1.getPrecio()+"�");
				pintaMenuGestion(e);
		break;	

		case 2: Alquiler a2=e.buscaAlquiler(metodos.MetodosInterfazUsuario.pideStringValidada("Introduzca el c�digo del Alquiler", 7));
				Devolucion d=metodosprograma.Interfazdeusuario.pideDatosDevolucion(e, a2); 
				System.out.println("LA DEVOLUCI�N SE HA REALIZADO, EL PRECIO FINAL SER�A: "+d.getPrecio()+"�");
				pintaMenuGestion(e);
		break;	

		case 3: pintaMenuPrincipal(e); //PINTA EL MEN� PRINCIPAL
		break;	

	}
	
}


/*
 * METODO PARA PINTAR LOS LISTADOS
 */
public static void pintaMenuListados(Empresa e) throws Exception {
	
	String lista[]={ "VEH�CULOS ALQUILADOS", "VEH�CULOS DISPONIBLES", "OFICINAS", "CLIENTES", "EMPLEADOS", "MEN� PRINCIPAL"}; 
	int valoresvalidos[]={ 1, 2, 3, 4, 5, 6};
	
	int opcion=metodos.MetodosPintarPantalla.menu(lista, valoresvalidos, "LISTADOS" , "ELIJA UNA OPCI�N" );
	
	switch (opcion) {
	
		case 1: 
			do {
		
				e.pintaListadeVehiculosNoDisponibles(); //SACA LA LISTA DE VEH�CULOS QUE NO EST�N DISPONIBLES
				opcion=menuSiNo("�QUIERES VOLVER AL MEN� DE LISTADOS?");

			}while(opcion==2);

			if(opcion==1) 
			{
				pintaMenuListados(e); //SI ELIJE SI PINTA EL MEN� DE LISTADOS
			}

			break;

		case 2:
			do {
		
				e.pintaListadeVehiculos(); //SACA LA LISTA DE LOS VEH�CULOS DISPONIBLES
				opcion=menuSiNo("�QUIERES VOLVER AL MEN� DE LISTADOS?"); //PREGUNTA SI QUIERE VOLVER AL MEN� ANTERIOR
	
			}while(opcion==2);
	
			if(opcion==1) 
			{
				pintaMenuListados(e); //SI ELIJE SI PINTA EL MEN� DE LOS LISTADOS
			}
	
		break;
	
	
		case 3: 
			do {
	
				e.pintaListadeOficinas(); //SACA LA LISTA DE LAS OFICINAS
				opcion=menuSiNo("�QUIERES VOLVER AL MEN� DE LISTADOS?"); //PREGUNTA SI QUIERE VOLVER AL MEN� ANTERIOR

			}while(opcion==2);

			if(opcion==1) 
			{
				pintaMenuListados(e); //SI ELIJE SI PINTA EL MEN� DE LOS LISTADOS
			}
		
		break;	

		case 4: 
			do {
				
				e.pintaListadeClientes(); //SACA LA LISTA DE LOS CLIENTES
				opcion=menuSiNo("�QUIERES VOLVER AL MEN� DE LISTADOS?"); //PREGUNTA SI QUIERE VOLVER AL MEN� ANTERIOR
			
			}while(opcion==2);
			
			if(opcion==1) 
			{
				pintaMenuListados(e); //SI ELIJE SI PINTA EL MEN� DE LISTADOS
			}
				
		break;	

		case 5: 
			do {
			
				e.pintaListadeEmpleados(); //SACA LA LISTA DE LOS EMPLEADOS
				opcion=menuSiNo("�QUIERES VOLVER AL MEN� DE LISTADOS?"); //PREGUNTA SI QUIERE VOLVER AL MEN� ANTERIOR
		
			}while(opcion==2);
		
			if(opcion==1) 
			{
				pintaMenuListados(e); //SI ELIJE SI PINTA EL MEN� DE LISTADOS
			}
		
		break;	

		case 6: pintaMenuPrincipal(e); //PINTA EL MEN� PRINCIPAL
	}
	
	
}


/*
 * MENU PARA QUE EL USUARIO ELIJA SI QUIERE COMBUSTI�N O EL�TRICO
 * SI ELIGE 1 QUIERE COMBUSTI�N SI ELIGE 2 QUIERE EL�CTRICO
 */
public static int menuElecOComb() throws OpcionNoValidaException  {

	String lista[]={ "COMBUSTI�N", "EL�CTRICO" }; 
	int valoresvalidos[]={ 1, 2 };
	
	int opcion=metodos.MetodosPintarPantalla.menu(lista, valoresvalidos, "�QUE TIPO DE VEH�CULO QUIERES A�ADIR?" , "ELIJA UNA OPCI�N" );
	
	return opcion;
}


/*
 * MENU PARA QUE EL USUARIO ELIJA QUE MODELO DE VEH�CULO EL�TRICO QUIERE
 * SI ELIGE 1 QUIERE COCHE SI ELIGE 2 QUIERE MOTO
 */
public static int menuElectricos() {
	
	String lista[]={ "COCHE", "MOTO" }; 
	int valoresvalidos[]={ 1, 2 };
	
	int opcion=metodos.MetodosPintarPantalla.menu(lista, valoresvalidos, "�QUE MODELO DE VEH�CULO QUIERES A�ADIR?" , "ELIJA UNA OPCI�N" );
	
	return opcion;
	
}


/*
 * MENU PARA QUE EL USUARIO ELIJA QUE MODELO DE VEH�CULO DE COMBUSTI�N QUIERE
 * SI ELIGE 1 QUIERE COCHE SI ELIGE 2 QUIERE FURGONETA
 */
public static int menuCombustion() {
	
	String lista[]={ "COCHE", "FURGONETA" }; 
	int valoresvalidos[]={ 1, 2 };
	
	int opcion=metodos.MetodosPintarPantalla.menu(lista, valoresvalidos, "�QUE MODELO DE VEH�CULO QUIERES A�ADIR?" , "ELIJA UNA OPCI�N" );
	
	return opcion;
	
}


/*
 * MENU PARA QUE EL USUARIO ELIJA SI O NO
 * SI ELIJE 1 QUIERE CONTINUAR SI ELIJE 2 NO QUIERE
 */
public static int menuSiNo(String titulo) {
	
	String lista[]={ "SI", "NO" }; 
	int valoresvalidos[]={ 1, 2 };
	
	int opcion=metodos.MetodosPintarPantalla.menu(lista, valoresvalidos, titulo , "ELIJA UNA OPCI�N" );
	
	return opcion;
}

/*
 * MEN� PARA MODIFICAR UN CLIENTE
 * MUESTRA LAS PROPIEDADES DE CLIENTE 
 */
public static int menuModificarCliente() {
	
	String lista[]={ "NOMBRE", "PRIMER APELLIDO", "SEGUNDO APELLIDO", "TIPO DE CARNET DE CONDUCIR", "C�DIGO DE CLIENTE", "VOLVER"}; 
	int valoresvalidos[]={ 1, 2, 3, 4, 5, 6 };
	
	int opcion=metodos.MetodosPintarPantalla.menu(lista, valoresvalidos, "�QU� QUIERES MODIFICAR?" , "ELIJA UNA OPCI�N" );

	return opcion;
}


/*
 * MEN� PARA MODIFICAR UN CLIENTE
 * MUESTRA LAS PROPIEDADES DE CLIENTE 
 */
public static int menuModificarEmpleado() {
	
	String lista[]={ "NOMBRE", "PRIMER APELLIDO", "SEGUNDO APELLIDO", "FECHA DE ALTA", "OFICINA", "VOLVER" }; 
	int valoresvalidos[]={ 1, 2, 3, 4, 5, 6 };
	
	int opcion=metodos.MetodosPintarPantalla.menu(lista, valoresvalidos, "�QU� QUIERES MODIFICAR?" , "ELIJA UNA OPCI�N" );

	return opcion;
}


/*
 * MEN� PARA MODIFICAR UN VEH�CULO
 * MUESTRA LAS PROPIEDADES DE UN VEH�CULO
 */
public static int menuModificarVehiculo() {
	
	int opcion=0;
	return opcion;
}


/*
 * MEN� MODIFICAR OFICINA
 * MUESTRA LAS PROPIEDADES DE OFICINA
 */
public static int menuModificarOficina() {
	
	String lista[]={ "DESCRIPCI�N", "LOCALIDAD", "PROVINCIA", "TIENE AEROPUERTO", "VOLVER" }; 
	int valoresvalidos[]={ 1, 2, 3, 4, 5 };
	
	int opcion=metodos.MetodosPintarPantalla.menu(lista, valoresvalidos, "�QU� QUIERES MODIFICAR?" , "ELIJA UNA OPCI�N" );

	return opcion;
	
}


/*
 * MEN� PARA ELEGIR SI QUIERE SACAR LOS VEH�CULOS POR CATEGOR�A O POR OFICINA
 */
public static int menuCategoriaOficina() {
	
	String lista[]={ "CATEGOR�A", "OFICINA" }; 
	int valoresvalidos[]={ 1, 2 };
	
	int opcion=metodos.MetodosPintarPantalla.menu(lista, valoresvalidos, "�POR QU� QUIERES BUSCAR?" , "ELIJA UNA OPCI�N" );

	return opcion;
	
}


/*
 * MEN� PARA ELEGIR QUE VEH�CULO QUIERE MODIFICAR
 */
public static int menuVehiculoAModificar() {
	
	String lista[]={ "COCHE DE COMBUSTI�N", "FURGONETA", "COCHE EL�CTRICO", "MOTO", "VOLVER" }; 
	int valoresvalidos[]={ 1, 2, 3, 4, 5 };
	
	int opcion=metodos.MetodosPintarPantalla.menu(lista, valoresvalidos, "�QU� VEH�CULO QUIERES MODIFICAR?" , "ELIJA UNA OPCI�N" );

	return opcion;
	
}


/*
 * MEN� MODIFICAR COCHE DE COMBUSTI�N
 * MUESTRA LAS PROPIEDADES DE COCHE DE COMBUSTI�N
 */
public static int menuModificarCocheCombustion() {
	
	String lista[]={ "MARCA", "MODELO", "FECHA DE ALTA", "KM", "CATEGOR�A", "OFICINA", "CONSUMO", "POTENCIA", "N� PLAZAS", "TIPO", "VOLVER"  }; 
	int valoresvalidos[]={ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
	
	int opcion=metodos.MetodosPintarPantalla.menu(lista, valoresvalidos, "�QU� QUIERES MODIFICAR?" , "ELIJA UNA OPCI�N" );

	return opcion; 
	
}


/*
 * MEN� MODIFICAR FURGONETA
 * MUESTRA LAS PROPIEDADES DE FURGONETA
 */
public static int menuModificarFurgoneta() {
	
	String lista[]={ "MARCA", "MODELO", "FECHA DE ALTA", "KM", "CATEGOR�A", "OFICINA", "CONSUMO", "POTENCIA", "CAPACIDAD", "CARNET", "VOLVER"  }; 
	int valoresvalidos[]={ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
	
	int opcion=metodos.MetodosPintarPantalla.menu(lista, valoresvalidos, "�QU� QUIERES MODIFICAR?" , "ELIJA UNA OPCI�N" );

	return opcion;
	
}


/*
 * MEN� MODIFICAR COCHE EL�CTRICO
 * MUESTRA LAS PROPIEDADES DE COCHE EL�CTRICO
 */
public static int menuModificarCocheElectrico() {
	
	String lista[]={ "MARCA", "MODELO", "FECHA DE ALTA", "KM", "CATEGOR�A", "OFICINA", "AUTONOM�A", "TIEMPO DE RECARGA", "N� PLAZAS", "TIPO", "VOLVER"  }; 
	int valoresvalidos[]={ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
	
	int opcion=metodos.MetodosPintarPantalla.menu(lista, valoresvalidos, "�QU� QUIERES MODIFICAR?" , "ELIJA UNA OPCI�N" );

	return opcion;
	
}


/*
 * MEN� MODIFICAR MOTO
 * MUESTRA LAS PROPIEDADES DE MOTO
 */
public static int menuModificarMoto() {
	
	String lista[]={ "MARCA", "MODELO", "FECHA DE ALTA", "KM", "CATEGOR�A", "OFICINA", "AUTONOM�A", "TIEMPO DE RECARGA", "CILINDRADA", "CARNET", "VOLVER"  }; 
	int valoresvalidos[]={ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
	
	int opcion=metodos.MetodosPintarPantalla.menu(lista, valoresvalidos, "�QU� QUIERES MODIFICAR?" , "ELIJA UNA OPCI�N" );

	return opcion;
	
}




	
}
