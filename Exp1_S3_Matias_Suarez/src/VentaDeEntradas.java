import java.util.Scanner;

public class VentaDeEntradas {

    public static void main(String[] args) {

        //Matriz para mostrar la tabla de entradas y precios
        String[] entradas = new String[]{"VIP", "Platea Baja", "Platea Alta", "Palcos"};
        int[] estudiante = {20000, 15000, 10000, 5000};
        int[] publicoGeneral = new int[]{35000, 25000, 15000, 11000};

        //Variables pedidas al usuario e iniciamos su futura lectura
        String tipoEntrada;
        String tipoTarifa;
        Scanner input = new Scanner(System.in);

        //Bienvenida
        System.out.println("--------------------------------------------------------");
        System.out.println("Bienvenido al Teatro Moro");
        System.out.println("En la siguiente tabla encontrara el tipo y los precios de las entradas para la función" + '\n');

        //Encabezado de la Tabla
        System.out.printf("%-15s | %-15s | %-15s\n", "Tipo Entrada", "Tarifa Estudiante", "Tarifa General");
        System.out.println("--------------------------------------------------------");

        // Filas de la tabla
        for (int i = 0; i < entradas.length; i++) {
            System.out.printf("%-15s | %-15d | %-15d\n", entradas[i], estudiante[i], publicoGeneral[i]);
        }

        //Ingreso y Validacion del Tipo de Entrada para la compra
        System.out.println('\n' + "Ingrese el tipo de entrada que desea comprar:");

        while (true) {
            tipoEntrada = input.nextLine();

            if (!(tipoEntrada.equals("VIP") || tipoEntrada.equals("Platea Baja") ||
                    tipoEntrada.equals("Platea Alta") || tipoEntrada.equals("Palcos"))) {

                System.out.println("Opción Inválida, Las Entradas son: ");
                for (int i = 0; i < entradas.length; i++) {
                    System.out.println(entradas[i]);
                }

            } else {
                break; //para salir del ciclo
            }
        }

        //Ingreso y Validacion del Ingreso de la tipo de Tarifa a pagar
        System.out.println("Ingrese la tarifa que desea comprar:");

        while (true) {
            tipoTarifa = input.nextLine();

            if (!(tipoTarifa.equals("Estudiante") || tipoTarifa.equals("General"))) {
                System.out.println("Opción inválida, debe ingresar Estudiante o General");
            } else {
                break; //para salir del ciclo
            }
        }

        //Busca el precio segun lo ingresado e incoorporamos IVA y Descuentos Extras

        double descuento = 0.10; //10% descuento adicional
        double iva = 1.19;       //19% Sobre precio final
        double precioFinal = 0;  //inicializa valriable
        double totalDescuento;
        double subTotal;
        double totalAPagar;

        //VIP
        if (tipoEntrada.equals("VIP") && tipoTarifa.equals("Estudiante")) {
            precioFinal = 20000.00;
        } else if (tipoEntrada.equals("VIP") && tipoTarifa.equals("General")) {
            precioFinal = 35000.00;
        }

        //Platea Baja
        if (tipoEntrada.equals("Platea Baja") && tipoTarifa.equals("Estudiante")) {
            precioFinal = 15000.00;
        } else if (tipoEntrada.equals("Platea Baja") && tipoTarifa.equals("General")) {
            precioFinal = 25000.00;
        }

        //Platea Alta
        if (tipoEntrada.equals("Platea Alta") && tipoTarifa.equals("Estudiante")) {
            precioFinal = 10000.00;
        } else if (tipoEntrada.equals("Platea Alta") && tipoTarifa.equals("General")) {
            precioFinal = 15000.00;
        }

        //Palcos
        if (tipoEntrada.equals("Palcos") && tipoTarifa.equals("Estudiante")) {
            precioFinal = 5000.00;
        } else if (tipoEntrada.equals("Palcos") && tipoTarifa.equals("General")) {
            precioFinal = 11000.00;
        }

        //Calculamos el IVA y los Descuentos + una bromita jajajaj

        totalDescuento = precioFinal * descuento;
        subTotal = precioFinal - totalDescuento;
        totalAPagar = subTotal * iva;

        System.out.println('\n' + "El resumen de tu compra es el siguiente:");
        System.out.println("Tipo Entrada --> " + tipoEntrada);
        System.out.println("Tipo Tarifa --> " + tipoTarifa);
        System.out.println("Subtotal --> " + precioFinal);
        System.out.println('\n' + "Por ser un buen profe te has ganado un descuento del 10%");
        System.out.println("El descuento aplicado corresponde a: " + totalDescuento);
        System.out.println("El precio neto con descuento es: " + subTotal);
        System.out.println("El pago final con IVA es: " + totalAPagar);
        System.out.println('\n' + "Gracias por su compra, disfrute la función");

        input.close();
    }
}
