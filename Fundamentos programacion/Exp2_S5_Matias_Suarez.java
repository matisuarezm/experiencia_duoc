package exp2_s5_matias_suarez;


import java.util.Scanner;
/**
* @author msuarez
 */

public class Exp2_S5_Matias_Suarez {
    
    static int totalEntradasTeatro = 50;
    static int entradasVendidas = 0;
    static double precioSinDescuento = 0;
    static double totaDescuentoEntrada = 0;
    static double descuentoCantidad = 0;
    static double precioFinal = 0;
    
    
    //Arreglos para guardar las entradas vendidas
    static String[] guardaNombreComprador = new String [totalEntradasTeatro];
    static String[] guardaTipoComprador = new String [totalEntradasTeatro];
    static int[] guardaEdadComprador = new int [totalEntradasTeatro];
    static String[] guardaSectorTeatro = new String [totalEntradasTeatro];
    static double[] guardaPrecioFinal = new double[totalEntradasTeatro];
    
    
    public static void main(String[] args) throws InterruptedException {
        
        Scanner input = new Scanner(System.in);
        byte opcionMenu = 0;
        
        String nombreComprador = "";
        byte edadComprador;
        String tipoComprador = "Normal";
        String sectorTeatro ="";
        double valorEntrada = 0;
        double descuentoTipoComprador = 0;
        int cantidadDeEntradas = 0;
            
        do {            
            System.out.println("=======---->>>Bienvenido a Entradas 2.0<<<----=======\n");
            System.out.println("Seleccione alguna opcion del menú");
            System.out.println("1.- Venta de Entradas");
            System.out.println("2.- Promociones");
            System.out.println("3.- Busqueda");
            System.out.println("4.- Eliminacion de entradas");
            System.out.println("5.- Salir.");
           
           while(true){
                //-- input.hasNextByte() retorna un booleano
                if (input.hasNextByte()) {
                    opcionMenu = input.nextByte();
                    input.nextLine(); // Limpiamo buffer 
                    break;
                }else {
                    System.out.println("Error.. Ingreso fuera de rango.\n");
                    input.nextLine(); //Limpiamos la entrada erronea del usuario
                }
                System.out.println("Ingrese una opción Válida del Menú");
           }//Fin validacion opcion ingresada
                     
            System.out.println("Has ingresado la opcion: " + opcionMenu);
            
            switch (opcionMenu){
                case 1:
                    System.out.println(":::...Bienvenido a la compra de entradas...:::");
                    
                    //verificamos si hay entradas disponibles
                    if (entradasVendidas > totalEntradasTeatro){
                        System.out.println("Lo siento, ya no quedan entradas disponible.");
                        break;
                    } 
                    
                    //Ingreso y Validacion del Nombre
                    while (true){                        
                        System.out.println("Registre su Nombre para la compra:");
                        nombreComprador = input.nextLine().trim();
                        if (!nombreComprador.isEmpty()) {
                            break;
                        }
                        System.out.println("El nombre no puede estar vacío");
                    }//Fin while nombre 
                    
                    //Ingreso y Validacion de la Edad
                    while (true){ 
                        System.out.println("Registre su Edad:");                        
                        if (input.hasNextByte()) {
                            edadComprador = input.nextByte();
                            input.nextLine(); // Limpiar salto pendiente del nextBye()
                            break;
                        }else{
                            System.out.println("Error.. No has ingresado una edad valida.\n");
                            input.next(); //Limpiamos la entrada erronea del usuario                            
                        }
                    }//Fin while edad
                    
                    //Cantidad de entradas a comprar
                    while(true){
                        System.out.println("¿Cuantas entradas desea comprar?");
                        if (input.hasNextInt()) {
                            cantidadDeEntradas = input.nextInt();
                            input.nextLine();
                            if (cantidadDeEntradas > 0 && cantidadDeEntradas <= (totalEntradasTeatro - entradasVendidas) ) {
                                break;
                            }else{
                                System.out.println("Lo siento no tenemos tantas entradas disponibles"); 
                            }                            
                        }else{
                            System.out.println("Error.. Ingreso no es válido");
                            input.nextLine();
                        }
                    }//Fin while cantidad entradas
                    
                    //Definimos el tipo de comprador y verificamos descuento segun edad
                    if (edadComprador <= 25) {
                        tipoComprador = "Estudiante";
                        descuentoTipoComprador = 0.10;
                    }else if (edadComprador >= 65){ 
                        tipoComprador = "Tercera Edad";
                        descuentoTipoComprador = 0.15;
                    }else {
                        tipoComprador = "Normal";
                        descuentoTipoComprador = 0;
                    }
                    
                    //Valor por Sector 
                    while (true){
                        System.out.println("Ingrese la ubicacion de su entrada (VIP, Platea, General)");
                        sectorTeatro = input.nextLine();
                        
                        switch (sectorTeatro.toLowerCase()) {
                            case "vip": valorEntrada = 35000; break;    
                            case "platea": valorEntrada = 25000; break;
                            case "general": valorEntrada = 15000; break;
                            default: System.out.println("Opcion ingresada no valida"); continue;                                
                        }
                        break;
                    }

                    //Descuentos extras por cantidad
                    if (cantidadDeEntradas >= 3 && cantidadDeEntradas <=9 ) {
                        descuentoCantidad = 0.2;
                        precioSinDescuento = cantidadDeEntradas * valorEntrada;
                        totaDescuentoEntrada = precioSinDescuento * descuentoCantidad;
                        precioFinal = precioSinDescuento - totaDescuentoEntrada;
                    }else if (cantidadDeEntradas >= 10){
                        descuentoCantidad = 0.25;
                        precioSinDescuento = cantidadDeEntradas * valorEntrada;
                        totaDescuentoEntrada = precioSinDescuento * descuentoCantidad;
                        precioFinal = precioSinDescuento - totaDescuentoEntrada;
                    }else {
                        precioSinDescuento = cantidadDeEntradas * valorEntrada;
                        totaDescuentoEntrada = precioSinDescuento * descuentoTipoComprador;
                        precioFinal = precioSinDescuento - totaDescuentoEntrada;                        
                    }
                    
                    //Guardando entrada en arreglos 
                    for (int i = 0; i < cantidadDeEntradas; i++) {
                        int indiceArreglos = entradasVendidas + i;
                        guardaNombreComprador[indiceArreglos] = nombreComprador;
                        guardaTipoComprador[indiceArreglos] = tipoComprador;
                        guardaEdadComprador[indiceArreglos] = edadComprador;
                        guardaSectorTeatro[indiceArreglos] = sectorTeatro;
                        guardaPrecioFinal[indiceArreglos] = valorEntrada * (1 - descuentoTipoComprador);
                    }
                    
                    //Informamos la compra y los descuento asociados
                    System.out.println("\n::::::......INFORMACION DE COMPRA......::::::\n");  
                    System.out.println("El sector " + sectorTeatro + " tiene un valor de: " + valorEntrada);
                    
                    if (cantidadDeEntradas >= 3) {
                        System.out.println("Descuento por cantidad de " + cantidadDeEntradas + " entradas es del 20%");
                    }else if (cantidadDeEntradas >= 10){
                        System.out.println("Descuento por cantidad de " + cantidadDeEntradas + " entradas es del 25%");
                    }else if (tipoComprador.equalsIgnoreCase("Estudiante")) {
                        System.out.println("Descuento " + tipoComprador + " es del 10%");
                    }else if (tipoComprador.equalsIgnoreCase("Tercera Edad")) {
                        System.out.println("Descuento " + tipoComprador + " es del 15%");
                    }else {
                        System.out.println("No existen descuento para su edad");
                    }
                    
                    System.out.println("####     DESCUENTOS NO ACUMULABLES     ####");
                    System.out.println("#### SOLO SE APLICA EL DESCUENTO MAYOR ####");
                    
                    //Generamos Boleta
                    System.out.println("\n=====----->>> BOLETA DE COMPRA <<<-----=====\n");
                    System.out.println("Precio de " + cantidadDeEntradas + " entradas: " + precioSinDescuento);
                    System.out.println("Descuento total : " + totaDescuentoEntrada);
                    System.out.println("Total a pagar : "+precioFinal + '\n');
                    System.out.println("¡¡¡Muchas gracias " + nombreComprador + " ,que disfruten la función!!!");
                    System.out.println("\n=====----->>>   FIN DE BOLETA   <<<-----=====\n");
                    
                    //Incrementamos el valor de las entradas vendidas
                    entradasVendidas = entradasVendidas + cantidadDeEntradas;
                    
                    break;//fin break menu (1)
                case 2:
                    System.out.println(":::...Las promociones del Teatro son las siguientes:...:::\n");
                    System.out.println("* 10% de descuento para Estudiantes o menores de 25 años");
                    System.out.println("* 15% de descuento para Tercera Edad o mayores de 65 años");
                    System.out.println("* 20% de descuento por compras desde 3 entradas");
                    System.out.println("* 25% de descuento por compras desde 10 entradas\n");
                    
                    break;//fin break menu (2)
                case 3:                    
                    byte opcionBusqueda = 0;
                    int cantidadEntradas = 0;
                    
                    do {                    
                        System.out.println("\n:::...BUSQUEDA DE ENTRADAS...:::\n");
                        System.out.println("Como deseas buscar las entradas?\n");
                        System.out.println("1.- Nombre del comprado");
                        System.out.println("2.- Edad del comprador");
                        System.out.println("3.- Sector (Ej. VIP - Platea - General");
                        System.out.println("4.- Tipo Comprador: Estudiante o 'Tercera Edad'"); 
                        System.out.println("5.- Numero de entrada");
                        System.out.println("6.- Volver al menú principal.");

                        while(true){
                            //-- input.hasNextByte() retorna un booleano
                            if (input.hasNextByte()) {
                                opcionBusqueda = input.nextByte();
                                input.nextLine(); // Limpiamo buffer 
                                break;
                            }else {
                                System.out.println("Error.. Ingreso fuera de rango.\n");
                                input.nextLine(); //Limpiamos la entrada erronea del usuario
                            }
                            System.out.println("Ingrese una opción de busqueda válida");
                        }//Fin validacion opcion ingresada

                        switch  (opcionBusqueda){
                            case 1:
                                
                                //Ingreso y Validacion del Nombre
                                while (true){                        
                                    System.out.println("Ingrese el Nombre registrado en la compra");
                                    nombreComprador = input.nextLine().trim();
                                    if (!nombreComprador.isEmpty()) {
                                        break;
                                    }
                                    System.out.println("El nombre no puede estar vacío");
                                }//Fin while nombre 

                                //Buscamos en la matriz el nombre
                                System.out.println("\nEncontramos las siguientes entradas\n");
                                cantidadEntradas = 0;
                                for (int i = 0; i < guardaNombreComprador.length; i++) {
                                    if (guardaNombreComprador[i] != null && guardaNombreComprador[i].equalsIgnoreCase(nombreComprador)) {
                                        cantidadEntradas ++ ;
                                        System.out.println("Entrada " + (i + 1) + ": Sector " + guardaSectorTeatro[i] + ", Precio $" + guardaPrecioFinal[i]);
                                    }
                                }
                                System.out.println("\nEn total encontramos " + cantidadEntradas + " entradas a nombre de: " + nombreComprador.toUpperCase() + '\n');
                                break;    
                            case 2:
                                
                                //Ingreso y Validacion de la Edad
                                while (true){ 
                                    System.out.println("Ingrese la edad registrada en la compra:");                        
                                    if (input.hasNextByte()) {
                                        edadComprador = input.nextByte();
                                        input.nextLine(); // Limpiar salto pendiente del nextBye()
                                        break;
                                    }else{
                                        System.out.println("Error.. No has ingresado una edad valida.\n");
                                        input.next(); //Limpiamos la entrada erronea del usuario                            
                                    }
                                }//Fin while edad 

                                //Buscamos en la matriz la edad
                                System.out.println("\nEncontramos las siguientes entradas\n");
                                cantidadEntradas = 0;
                                for (int i = 0; i < guardaEdadComprador.length; i++) {
                                    if (guardaEdadComprador[i] == edadComprador) {
                                        cantidadEntradas ++ ;
                                        System.out.println("Entrada " + (i + 1) + ": Sector " + guardaSectorTeatro[i] + ", Precio $" + guardaPrecioFinal[i]);
                                    }
                                }
                                System.out.println("\nEn total encontramos " + cantidadEntradas + " entradas con edad: " + edadComprador + '\n');

                                break;
                            case 3:
                                
                                //Valor por Sector 
                                while (true){
                                    System.out.println("Ingrese el sector comprado: (VIP, Platea, General)");
                                    sectorTeatro = input.nextLine();
                                    switch (sectorTeatro.toLowerCase()) {
                                        case "vip":  
                                            break;    
                                        case "platea":  
                                            break;
                                        case "general": 
                                            break;
                                        default: System.out.println("Opcion ingresada no valida"); continue;                                
                                    }
                                    break;
                                }//Fin valida sector
                                
                                //Buscamos en la matriz el Sector
                                System.out.println("\nEncontramos las siguientes entradas\n");
                                cantidadEntradas = 0;
                                for (int i = 0; i < guardaSectorTeatro.length; i++) {
                                    if (guardaSectorTeatro[i] != null && guardaSectorTeatro[i].equalsIgnoreCase(sectorTeatro)) {
                                        cantidadEntradas ++ ;
                                        System.out.println("Entrada " + (i + 1) + ": Sector " + guardaSectorTeatro[i] + ", Precio $" + guardaPrecioFinal[i]);
                                    }
                                }
                                System.out.println("\nEn total encontramos " + cantidadEntradas + " entradas para el sector: " + sectorTeatro.toUpperCase() + '\n');
                            
                                break;
                            case 4:
                                
                                //Tipo de comprador
                                while (true){
                                    System.out.println("Ingrese el tipo de comprador asignado: (Estudiante - Tercera Edad)");
                                    tipoComprador = input.nextLine();
                                    switch (tipoComprador.toLowerCase()) {
                                        case "estudiante":  
                                            break;    
                                        case "tercera edad":  
                                            break;
                                        default: System.out.println("Opcion ingresada no valida"); 
                                        continue;                                
                                    }
                                    break;
                                }//Fin valida sector                                
                                
                                //Buscamos en la matriz Tipo de comprador
                                System.out.println("\nEncontramos las siguientes entradas\n");
                                cantidadEntradas = 0;
                                for (int i = 0; i < guardaTipoComprador.length; i++) {
                                    if (guardaTipoComprador[i] != null && guardaTipoComprador[i].equalsIgnoreCase(tipoComprador)) {
                                        cantidadEntradas ++ ;
                                        System.out.println("Entrada " + (i + 1) + ": Sector " + guardaSectorTeatro[i] + ", Precio $" + guardaPrecioFinal[i]);
                                    }
                                }
                                System.out.println("\nEn total encontramos " + cantidadEntradas + " asociadas a: " + tipoComprador + '\n');

                                break;
                            case 5:
                                
                                //Numero de entrada
                                int numeroABuscar = 0;
                                System.out.println("Ingrese el numero de entrada a buscar");
                                if (input.hasNextInt()) {
                                    numeroABuscar = input.nextInt();
                                    input.nextLine();//Limpia buffer
                                    if (numeroABuscar > 0 && numeroABuscar <= entradasVendidas - 1) {
                                        break;
                                    }
                                    else{
                                        System.out.println("Numero ingresado no es valido");
                                    }
                                }else{
                                    System.out.println("Error.. Ingrese un numero valido");
                                    input.nextLine(); //Limpia entrada erronea
                                }
                                
                                //Mostramos informacion de la entrada
                                System.out.println("=== Información de la entrada N° " + numeroABuscar + " ===\n");
                                System.out.println("Nombre: " + guardaNombreComprador[numeroABuscar - 1]);
                                System.out.println("Edad: " + guardaEdadComprador[numeroABuscar - 1]);
                                System.out.println("Tipo: " + guardaTipoComprador[numeroABuscar - 1]);
                                System.out.println("Sector: " + guardaSectorTeatro[numeroABuscar - 1]);
                                System.out.println("Precio $" + guardaPrecioFinal[numeroABuscar - 1]);
                                
                                break;
                            case 6:
                                
                                System.out.println("Gracias por usar nuestro modulo de busqueda\n     Espero le haya servido...");
                                System.out.println("");
                                
                                break;    
                            default:
                                
                                System.out.println("La opcion ingresada no es válida\n");
                        }//Fin switch busqueda
                    }while (opcionBusqueda != 6);
                    
                    break;//fin break menu (3)
                case 4:
                    System.out.println(":::...Eliminación de entradas...:::");
                    
                    byte numeroEntradaEliminada = 0;
                                       
                    System.out.println("\nIngrese el numero de entrada que desea eliminar");
                    if (entradasVendidas == 0) {
                        System.out.println("Aun no hay entradas vendidas que eliminar");
                        break;
                    }

                    while(true) {
                        if (input.hasNextByte()) {
                            numeroEntradaEliminada = input.nextByte();
                            input.nextLine();
                            if (numeroEntradaEliminada > 0 && numeroEntradaEliminada <= entradasVendidas) {
                                break;
                            }else {
                                System.out.println("Numero fuera de rango, Ingrese otro numero");
                            }
                        }else {
                            System.out.println("Error.. No has ingresado un numero valido.\n");
                            input.next(); //Limpiamos la entrada erronea del usuario 
                        }
                    }
                    
                    int posicionEliminada = numeroEntradaEliminada -1;
                    
                    //Elimina la informacion de la entrada en todos los arreglos
                    for (int i = posicionEliminada; i < entradasVendidas - 1; i++) {
                        guardaNombreComprador[i] = guardaNombreComprador[i + 1];
                        guardaEdadComprador[i] = guardaEdadComprador[i + 1];
                        guardaTipoComprador[i] = guardaTipoComprador[i + 1];
                        guardaSectorTeatro[i] = guardaSectorTeatro[i + 1];
                        guardaPrecioFinal [i] = guardaPrecioFinal[i + 1];                        
                    }
                    
                    //Limpiamos la posicion que movimos de los arreglos
                    guardaNombreComprador[entradasVendidas - 1] = null;
                    guardaEdadComprador[entradasVendidas - 1] = 0;
                    guardaTipoComprador[entradasVendidas - 1] = null;
                    guardaSectorTeatro[entradasVendidas -1] = null;
                    guardaPrecioFinal[entradasVendidas - 1] = 0.0;
                    
                    //Rebajamos en 1 las entradas vendidas
                    entradasVendidas --;
                    System.out.println("\nEntrada eliminada exitosamente\n");
                    
                    break;//fin break menu (4)
                case 5:
                    System.out.println("Usted esta saliendo del sistema, Muchas gracias.");
                    for (int i = 0; i < 3; i++) {
                        Thread.sleep(900);
                        System.out.print(".");
                    }
                    System.out.println("");
                    break;//fin break menu (5)
                default:
                    System.out.println("La opcion ingresada no es válida\n");
            }//Fin del Switch
        
        }while(opcionMenu !=5);
        
        input.close();

    }//Fin del Main
    
    
    
}
