Algoritmo TeatroMoro
	
	//Declaracion de Variables
	definir AsientosTotales, AsientosVendidos Como Entero;
	definir PorcentajeAsientos Como Real;

	AsientosTotales <- 1000;
	
	//Inicio del Programa	
	Escribir "*****************************************************";
	Escribir "*                                                   *";
	Escribir "*                  Bienvenidos                      *";
	Escribir "*            Teatro Moro te espera!!!               *";
	Escribir "*     Revisa el porcentaje de asientos ocupados     *";
	Escribir "*                                                   *";
	Escribir "*****************************************************";
	
	Escribir " ";
	//Entrada de Datos 
	Escribir "¡Ingresa el número de asientos vendidos!";
	Leer AsientosVendidos;
	
	//Proceso
	Mientras AsientosVendidos > AsientosTotales Hacer
		Escribir "El total de asientos utilizados no puede ser mayor a la capacidad total";
		Escribir "Por favor ingresa el número de asientos vendidos";
		Leer AsientosVendidos;
	FinMientras
	
	PorcentajeAsientos = (AsientosVendidos / AsientosTotales) * 100;
	
	//Salida
	Escribir " " ;
	Escribir " " ;
	Escribir "El porcentaje utilizado de asientos corresponde al ";  
	Escribir "                         ",PorcentajeAsientos,"%" ;
	Escribir "    de la capacidad total de nuestro teatro.!";
	Escribir " " ;
	Escribir " " ;
	Escribir "******************************************************" ;
	Escribir "*           Muchas gracias por visitarnos            *" ;
	Escribir "*                ¡Vuelve pronto!                     *" ;
	Escribir "******************************************************" ;
	Escribir " " ;
FinAlgoritmo
