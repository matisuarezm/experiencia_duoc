package exp2_s4_matias_suarez;

import java.util.Scanner;

/*

*/  
public class Exp2_S4_Matias_Suarez {
    

    
    public static void main(String[] args) throws InterruptedException {
        
        //Entrada --> Declaracion de variables
        Scanner input = new Scanner(System.in); 
        int opcion = 0;
                
        //Ubicaciones de Asientos del teatro
        boolean A1 = false, A2 = false, A3 = false, A4 = false, A5 = false;
        boolean B1 = false, B2 = false, B3 = false, B4 = false, B5 = false;
        boolean C1 = false, C2 = false, C3 = false, C4 = false, C5 = false;
        boolean D1 = false, D2 = false, D3 = false, D4 = false, D5 = false;
        boolean E1 = false, E2 = false, E3 = false, E4 = false, E5 = false;
        
        //Proceso -->       
        for (int i = 0; i < 3; i++) {
            
            System.out.println("=======================================");
            System.out.println("===....Bienvenido al teatro Moro....===");
            System.out.println("===............Boleteria............===\n");            
            System.out.println("1.- Comprar Entrada");
            System.out.println("2.- Salir\n");
            System.out.println("=======================================");
            
            System.out.println("Elija una opción del Menu");
            
            
            //Validamos que no ingrese letras o simbolos -- input.hasNextInt() retorna un booleano. numEntero=verdadero; simboloLetra=falso
            if (input.hasNextInt()) {
                opcion = input.nextInt();
                input.nextLine(); //Limpiamos el buffer ya que queda un salto de linea (\n) luego del ingreso
            }else{
                System.out.println("Error.. No has ingresado un numero entero.\n");
                input.next(); //Limpiamos la entrada erronea del usuario
                i--; //descontamos el intento para dejar infinito el for
                continue;
            }
            
            //Desarrollamos según opción indicada
            switch (opcion){
                case 1:
                    
                    String nombreComprador, asientoElegido;
                    byte edadComprador;
                    String aplicaDescuento;
                    double dctoEstudiante = 0.1;//Descuento del 10%
                    double dctoTerceraEdad = 0.15; //Descuento del 15%
                    double valorDescuento=0;
                    double valorFinal;
                    int valorFilaA=35000,valorFilaB=25000,valorFilaC=18000,valorFilaD=12000,valorFilaE=7000;
                    int valorEntrada;
                    char letraFilaAsiento = 'Z';
                    int numeroColumnaAsiento = -1;
                    
                    // Solicitamos el nombre al usuario y lo validamos en este while
                    while (true){
                        System.out.println("Ingrese su Nombre:");
                        nombreComprador = input.nextLine().trim();
                        if (!nombreComprador.isEmpty()) {
                            break;
                        }
                        System.out.println("El nombre no puede estar vacío");
                    }//Fin while nombre    
                    
                    // Solicitamos la edad al usuario y lo validamos en este while
                    while (true){ 
                        System.out.println("Ingrese su Edad:");                        
                        if (input.hasNextByte()) {
                            edadComprador = input.nextByte();
                            input.nextLine(); // Limpiar salto pendiente del nextBye()
                            break;
                        }else{
                            System.out.println("Error.. No has ingresado una edad valida.\n");
                            input.next(); //Limpiamos la entrada erronea del usuario                            
                        }
                    }//Fin while edad
                    
                    //Reserva de asiento - dibujo - validacion de ingreso
                    while (true){
                        System.out.println('\n' + "====...:::RESERVA de ASIENTO:::...====");
                        System.out.println("Estado Asientos: [ ] Libre | [X] Ocupado\n");
                        
                        //Imprime los numero de las Columnas
                        for (int k = 1; k <6; k++) {
                            System.out.print("     " + k);
                        }

                        //Realizamos el dibujo de los asientos con una condicion "if ternaria" dentro del sout para mostrar los asientos
                        System.out.println('\n' + "A" + (A1 ? "   [X]" : "   [ ]" ) + 
                                                        (A2 ? "   [X]" : "   [ ]" ) +
                                                        (A3 ? "   [X]" : "   [ ]" ) +
                                                        (A4 ? "   [X]" : "   [ ]" ) +
                                                        (A5 ? "   [X]" : "   [ ]" ) + "   (" + valorFilaA + ")"
                                );
                        System.out.println('\n' + "B" + (B1 ? "   [X]" : "   [ ]" ) + 
                                                        (B2 ? "   [X]" : "   [ ]" ) +
                                                        (B3 ? "   [X]" : "   [ ]" ) +
                                                        (B4 ? "   [X]" : "   [ ]" ) +
                                                        (B5 ? "   [X]" : "   [ ]" ) + "   (" + valorFilaB + ")"
                                );
                        System.out.println('\n' + "C" + (C1 ? "   [X]" : "   [ ]" ) + 
                                                        (C2 ? "   [X]" : "   [ ]" ) +
                                                        (C3 ? "   [X]" : "   [ ]" ) +
                                                        (C4 ? "   [X]" : "   [ ]" ) +
                                                        (C5 ? "   [X]" : "   [ ]" ) + "   (" + valorFilaC + ")"
                                );
                        System.out.println('\n' + "D" + (D1 ? "   [X]" : "   [ ]" ) + 
                                                        (D2 ? "   [X]" : "   [ ]" ) +
                                                        (D3 ? "   [X]" : "   [ ]" ) +
                                                        (D4 ? "   [X]" : "   [ ]" ) +
                                                        (D5 ? "   [X]" : "   [ ]" ) + "   (" + valorFilaD + ")"
                                );
                        System.out.println('\n' + "E" + (E1 ? "   [X]" : "   [ ]" ) + 
                                                        (E2 ? "   [X]" : "   [ ]" ) +
                                                        (E3 ? "   [X]" : "   [ ]" ) +
                                                        (E4 ? "   [X]" : "   [ ]" ) +
                                                        (E5 ? "   [X]" : "   [ ]" ) + "   (" + valorFilaE + ")"
                                );

                        // Solicitamos ingreso de asiento disponible y validamos             
                        System.out.println('\n' + "Ingrese el Asiento que desea (Ej: A1, C4, E2)");
                        asientoElegido = input.nextLine().trim().toUpperCase();
                        
                        
                        
                        if (asientoElegido.length() < 2) {
                            System.out.println("Ubicación de Asiento Invalida");
                            continue;
                        }else{
                            //Separamos el ingreso del asiento letra y numero para validar que no ingrese AA BB 1H
                            letraFilaAsiento = asientoElegido.charAt(0);                      
                            
                            // Verificamos que el segundo dato se un numero, en caso de no serlo devolvemos un mensaje y no se cae el programa
                            try{
                            numeroColumnaAsiento = Integer.parseInt(asientoElegido.substring(1)); //tomamos el segundo caracter del asienteElegido y lo transformaos en numero
                            }catch(NumberFormatException e){
                                System.out.println("Número de asiento inválido.");
                                
                            }                            
                        }
                        
                        //Validamos que el ingreso de asientoElegido este dentro del rango de los asientos del teatro
                        if (letraFilaAsiento < 'A' || letraFilaAsiento > 'E' || numeroColumnaAsiento > 5 ) {
                            System.out.println("Asiento fuera del rango");
                            continue;
                        }
                        
                        //Ahora validamos si el asiento esta Disponible u Ocupado
                        boolean estadoAsiento = false;
                        
                        if (letraFilaAsiento == 'A') {
                            switch (numeroColumnaAsiento) {
                                case 1:
                                    estadoAsiento = A1;
                                    break;
                                case 2:
                                    estadoAsiento = A2;
                                    break;
                                case 3:
                                    estadoAsiento = A3;
                                    break;
                                case 4:
                                    estadoAsiento = A4;
                                    break;
                                default:
                                    estadoAsiento = A5;
                                    break;
                            }
                        }
                        if (letraFilaAsiento == 'B') {
                            switch (numeroColumnaAsiento) {
                                case 1:
                                    estadoAsiento = B1;
                                    break;
                                case 2:
                                    estadoAsiento = B2;
                                    break;
                                case 3:
                                    estadoAsiento = B3;
                                    break;
                                case 4:
                                    estadoAsiento = B4;
                                    break;
                                default:
                                    estadoAsiento = B5;
                                    break;
                            }
                        }
                        if (letraFilaAsiento == 'C') {
                            switch (numeroColumnaAsiento) {
                                case 1:
                                    estadoAsiento = C1;
                                    break;
                                case 2:
                                    estadoAsiento = C2;
                                    break;
                                case 3:
                                    estadoAsiento = C3;
                                    break;
                                case 4:
                                    estadoAsiento = C4;
                                    break;
                                default:
                                    estadoAsiento = C5;
                                    break;
                            }
                        }
                        if (letraFilaAsiento == 'D') {
                            switch (numeroColumnaAsiento) {
                                case 1:
                                    estadoAsiento = D1;
                                    break;
                                case 2:
                                    estadoAsiento = D2;
                                    break;
                                case 3:
                                    estadoAsiento = D3;
                                    break;
                                case 4:
                                    estadoAsiento = D4;
                                    break;
                                default:
                                    estadoAsiento = D5;
                                    break;
                            }
                        }
                        if (letraFilaAsiento == 'E') {
                            switch (numeroColumnaAsiento) {
                                case 1:
                                    estadoAsiento = E1;
                                    break;
                                case 2:
                                    estadoAsiento = E2;
                                    break;
                                case 3:
                                    estadoAsiento = E3;
                                    break;
                                case 4:
                                    estadoAsiento = E4;
                                    break;
                                default:
                                    estadoAsiento = E5;
                                    break;
                            }
                        }
                        
                        if (estadoAsiento) {
                            System.out.println("[X] Lo sentimos, este asiento no esta disponible");
                            System.out.println("Por favor seleccione otro asiento");
                            continue;                            
                        }
                        break;
                        
                    }//Fin while asiento 
                        
                    //Validamos el precio del asiento
                    if (letraFilaAsiento == 'A') valorEntrada=valorFilaA;
                    else if (letraFilaAsiento == 'B') valorEntrada=valorFilaB;
                    else if (letraFilaAsiento == 'C') valorEntrada=valorFilaC;
                    else if (letraFilaAsiento == 'D') valorEntrada=valorFilaD;
                    else valorEntrada=valorFilaE;

                    //Verificamos segun la edad del comprador si aplicaria para un descuento
                    if (edadComprador <= 22) aplicaDescuento = "Estudiante";
                    else if (edadComprador >= 60) aplicaDescuento = "Tercera Edad";
                    else aplicaDescuento = "Sin Descuento";

                    //Entregamos informacion al usuario para confirmar la reserva o compra
                    System.out.println("El asiento " + asientoElegido + " tiene un valor de: " + valorEntrada);
                    if (aplicaDescuento.equals("Estudiante")) {
                        System.out.println("Por ser " + aplicaDescuento + " tienes un descuento del 10%");
                    }else if (aplicaDescuento.equals("Tercera Edad")){
                        System.out.println("Por ser " + aplicaDescuento + " tienes un descuento del 15%");
                    }else System.out.println("No existen descuento para su edad");

                    //Confirmacion de la reserva 
                    String validaReserva;
                    char confirmaReserva;
                    while (true){
                        System.out.println('\n' + "¿Deseas Realizar la reserva: S/N?");
                        validaReserva = input.nextLine().trim().toUpperCase();
                        if (validaReserva.length() == 1) {
                            confirmaReserva = validaReserva.charAt(0);
                            if (confirmaReserva == 'S' || confirmaReserva == 'N') break;

                        System.out.println("Error: Ingrese nuevamente su confirmacion S/N");
                        }
                        
                    }//Fin while confirmacion reserva
                    
                    //Cambiamos el valor del asienteElegido por verdadero para dejar reservado el asiento
                    if (confirmaReserva == 'S') {
                        if (letraFilaAsiento == 'A'){
                        if (numeroColumnaAsiento == 1) A1 = true;
                        else if (numeroColumnaAsiento == 2) A2 = true;
                        else if (numeroColumnaAsiento == 3) A3 = true;
                        else if (numeroColumnaAsiento == 4) A4 = true;
                        else A5 = true;
                        }
                        if (letraFilaAsiento == 'B'){
                            if (numeroColumnaAsiento == 1) A1 = true;
                            else if (numeroColumnaAsiento == 2) B2 = true;
                            else if (numeroColumnaAsiento == 3) B3 = true;
                            else if (numeroColumnaAsiento == 4) B4 = true;
                            else B5 = true;
                        }
                        if (letraFilaAsiento == 'C'){
                            if (numeroColumnaAsiento == 1) C1 = true;
                            else if (numeroColumnaAsiento == 2) C2 = true;
                            else if (numeroColumnaAsiento == 3) C3 = true;
                            else if (numeroColumnaAsiento == 4) C4 = true;
                            else C5 = true;
                        }
                        if (letraFilaAsiento == 'D'){
                            if (numeroColumnaAsiento == 1) D1 = true;
                            else if (numeroColumnaAsiento == 2) D2 = true;
                            else if (numeroColumnaAsiento == 3) D3 = true;
                            else if (numeroColumnaAsiento == 4) D4 = true;
                            else D5 = true;
                        }
                        if (letraFilaAsiento == 'E'){
                            if (numeroColumnaAsiento == 1) E1 = true;
                            else if (numeroColumnaAsiento == 2) E2 = true;
                            else if (numeroColumnaAsiento == 3) E3 = true;
                            else if (numeroColumnaAsiento == 4) E4 = true;
                            else E5 = true;
                        }
                        
                    }else continue;
                    
                //Generamos la boleta de compra    
                    char reimprimeBoleta;
                    do {
                        System.out.println("");
                        System.out.println("=====--->>>Boleta de Reserva<<<---====" + '\n');
                        System.out.println("Ubicación del asiento: " + asientoElegido);

                        //Precio base segun fila
                        int valorBaseBoleta = 0;
                        switch (letraFilaAsiento) {
                            case 'A': valorBaseBoleta = valorFilaA; break;
                            case 'B': valorBaseBoleta = valorFilaB; break;
                            case 'C': valorBaseBoleta = valorFilaC; break;
                            case 'D': valorBaseBoleta = valorFilaD; break;
                            case 'E': valorBaseBoleta = valorFilaD; break;
                        }
                        System.out.println("Precio base de la entrada: " + valorBaseBoleta );

                        //Mostramos el Descuento segun la fila
                        if (edadComprador <= 22) {
                            valorDescuento = valorBaseBoleta * dctoEstudiante;
                            System.out.println("Descuento aplicado: " + valorDescuento);
                        }else if (edadComprador >=60) {
                            valorDescuento = valorBaseBoleta * dctoTerceraEdad;
                            System.out.println("Descuento aplicado: " + valorDescuento);
                        }else {
                            valorDescuento = 0;
                            System.out.println("Descuento aplicado: Sin Descuento");
                        }
                        
                        //Precio Final
                        valorFinal = valorBaseBoleta - valorDescuento;
                        System.out.println("Precio final a pagar: " + valorFinal);

                        System.out.println("Gracias por su compra " + nombreComprador + " , Disfrute la función");
                        System.out.println('\n' + "============================================");
                        
                        //Validamos Reimprime Boleta
                        do {                            
                            System.out.println('\n' + "Desea reemprimir su comprobante? S/N");
                            reimprimeBoleta = input.next().trim().toUpperCase().charAt(0);
                        } while (reimprimeBoleta != 'S' && reimprimeBoleta != 'N' );
                    
                    }while (reimprimeBoleta == 'S');
                    i--; //para seguir con el ciclo    
                    break;
                case 2:
                    i = 3; // para salir del for (i)
                    System.out.println("...Saliendo");
                    for (int j = 0; j < 3; j++) {
                        Thread.sleep(1000); // pausa de 1 segundo
                         System.out.print("." + '\n');
                    }
                    
                break;
                default:
                    System.out.println("Opcion ingresada no es valida, Intente nuevamente");
                    i--; //descontamos el intento para dejar infinito el for
                    
            }//Fin de switch
            
            
        }//Fin del for (i)  
        
        input.close();
        
    }//Fin del Main
    
}//Fin de la clase
