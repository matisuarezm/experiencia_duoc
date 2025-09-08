import java.util.ArrayList;
import java.util.Scanner;

public class VentaOnline {



    public static void main(String[] args) throws InterruptedException {

        //Declaramos 2 arreglos uno como texto para nombre de productos y otro numerico para los precios
        String[] productos = new String[]{"Uvas", "Naranjas", "Mandarinas", "Paltas", "Arandanos", "Cerezas"};
        int[] precioProductos = new int[]{1000, 2000, 3000, 4000, 5000, 6000};

        //Creamos las Variables a utilizar
        int seleccionarProducto = 0;
        int subTotalCarro, valorTotalCarro = 0;
        int cantidadUvas, totalUvas = 0;
        int cantidadNaranjas, totalNaranjas = 0;
        int cantidadMandarinas, totalMandarinas = 0;
        int cantidadPaltas, totalPaltas = 0;
        int cantidadArandanos, totalArandanos = 0;
        int cantidadCerezas, totalCerezas = 0;
        int totalKilos;


        //Saludo de Bienvenida
        System.out.println("BIENVENIDO A LA VENTA ONLINE" + '\n');
        System.out.println("--------------------------------------------"+'\n');
        System.out.println("Opciones del Menu");
        System.out.println("Presiona 7 para ver los Productos");
        System.out.println("Presiona 8 para el Sub-Total");
        System.out.println("Presiona 9 para enviar tu pedido");
        System.out.println("--------------------------------------------"+'\n');


        //Mostramos el listado de productos creados en un arreglo de texto ya definido
        System.out.println("Nuestra lista de productos es el siguiente:");
        for (int i = 0; i < productos.length; i++) {
            System.out.println(i + 1 + " " + productos[i] + ": $" + precioProductos[i] + " x kg");
        }
        System.out.println("--------------------------------------------"+'\n');

        //Creamos el carrito en el cual agregaremos productor a un arreglo que es dinamico (ArrayList) así podemos ingresar N prodcutos
        Scanner input = new Scanner(System.in);
        ArrayList<Integer> carro = new ArrayList();
        System.out.println('\n' + "Selecione el prodcuto a comprar");

        //IMPORTANTE --> Validamos que el usuario ingrese un numero y que este corresponda a los solicitado.(Recordar estudiarlo y analizarlo)
        while (true){
            if (input.hasNextInt()){
                seleccionarProducto = input.nextInt(); //Capturamos el numero ingresado y lo validamos

                if (seleccionarProducto >= 1 && seleccionarProducto <= 9){
                    break; //Numero valido, salimos del ciclo
                }else {
                    System.out.println("Por favor ingrese un numero entre el 1 y el 9");

                }
            }else {
                System.out.println("El dato ingresado no es valido, Intenta nuevamente");
                seleccionarProducto = input.nextInt(); //Pedimos otro numero al usuario y Descartamos la entrada incorrecta (input.next(); igual sirve estudiarlo)

            }

        }

        //Agrega los prodcutos al carro segun un numero ingresado por el usuario correspondiente a la lista de productos
        //Al final del ciclo se solicita al usuario un nuevo numero para ver si repetimos el cliclo de agregar prodcutos
        while (seleccionarProducto > 0 && seleccionarProducto < 9) {
            if (seleccionarProducto == 1) {
                System.out.println("Cuántos kg de Uvas deseas llevar?");
                cantidadUvas = input.nextInt();
                totalUvas += cantidadUvas;
                carro.add(precioProductos[0] * cantidadUvas);
            } else if (seleccionarProducto == 2) {
                System.out.println("Cuántos kg de Naranjas deseas llevar?");
                cantidadNaranjas = input.nextInt();
                totalNaranjas += cantidadNaranjas;
                carro.add(precioProductos[1] * cantidadNaranjas);
            } else if (seleccionarProducto == 3) {
                System.out.println("Cuántos kg de Mandarinas deseas llevar?");
                cantidadMandarinas = input.nextInt();
                totalMandarinas += cantidadMandarinas;
                carro.add(precioProductos[2] * cantidadMandarinas);
            } else if (seleccionarProducto == 4) {
                System.out.println("Cuántos kg de Paltas deseas llevar?");
                cantidadPaltas = input.nextInt();
                totalPaltas += cantidadPaltas;
                carro.add(precioProductos[3] * cantidadPaltas);
            } else if (seleccionarProducto == 5) {
                System.out.println("Cuántos kg de Arandanos deseas llevar?");
                cantidadArandanos = input.nextInt();
                totalArandanos += cantidadArandanos;
                carro.add(precioProductos[4] * cantidadArandanos);
            } else if (seleccionarProducto == 6) {
                System.out.println("Cuántos kg de Cerezas deseas llevar?");
                cantidadCerezas = input.nextInt();
                totalCerezas += cantidadCerezas;
                carro.add(precioProductos[5] * cantidadCerezas);
            } else if (seleccionarProducto == 7) {
                //Mostramos el listado de productos creados en un arreglo de texto ya definido
                System.out.println("Nuestra lista de productos es el siguiente:");
                for (int i = 0; i < productos.length; i++) {
                    System.out.println(i + 1 + " " + productos[i] + ": $" + precioProductos[i]);
                }
            }else if (seleccionarProducto == 8) {
                //Reinicia el subtotal y luego lo calcula nuevamente en caso de que se agreguen nuevos productos de la misma especie
                subTotalCarro = 0;
                for (int k = 0; k < carro.size(); k++) {
                    subTotalCarro = subTotalCarro + carro.get(k);
                }

                //Mostramos un Subtotal por especie de fruta
                if (totalUvas > 0) {
                    System.out.println("Tienes " + totalUvas + " kg Uvas por un monto de: $" + (totalUvas * precioProductos[0]));
                }
                if (totalNaranjas > 0) {
                    System.out.println("Tienes " + totalNaranjas + " kg de Naranjas por un monto de: $" + (totalNaranjas * precioProductos[1]));
                }
                if (totalMandarinas > 0) {
                    System.out.println("Tienes " + totalMandarinas + " kg de Mandarinas por un monto de: $" + (totalMandarinas * precioProductos[2]));
                }
                if (totalPaltas > 0) {
                    System.out.println("Tienes " + totalPaltas + " kg de Paltas por un monto de: $" + (totalPaltas * precioProductos[3]));
                }
                if (totalArandanos > 0) {
                    System.out.println("Tienes " + totalArandanos + " kg de Arandanos por un monto de: $" + (totalArandanos * precioProductos[4]));
                }
                if (totalCerezas > 0) {
                    System.out.println("Tienes " + totalCerezas + " kg de Cerezas por un monto de: $" + (totalCerezas * precioProductos[5]));
                }

                //Aqui mostramos el resumen del subtotal
                totalKilos = totalUvas + totalNaranjas + totalMandarinas + totalPaltas + totalArandanos + totalCerezas;
                System.out.println("Tienes en total: " + totalKilos + "kg con un subtotal de: $" + subTotalCarro + " pesos" + '\n');

            }
            //Aqui finaliza el ciclo y preguntamos al usuario si desea agregar mas productos.
            System.out.println("Por favor Ingrese otro producto o alguna opcion del Menú");
            //System.out.println("Para ver el subtotal presiona 8 y para salir presiona 9");
            seleccionarProducto = input.nextInt();

        }// Fin while carro

        //Aqui enviamos el pedido e indicamos el total
        System.out.println("Procesando...!!!");
        for (int i = 0; i < 3; i++) {
            Thread.sleep(1000); // pausa de 1 segundo
            System.out.print("." + '\n');
        }
        //Aqui recorremos todo el Arreglo dinamico y sumamos los valores para entregar el valor final del carro luego imprimimos el mensaje
        for (int j = 0; j < carro.size(); j++) {
            valorTotalCarro = valorTotalCarro + carro.get(j);
        }
        System.out.println("Su pedido fue enviado con éxito.");
        System.out.println("HASTA PRONTO...!!!");
        System.out.println("El total de su pedido fue: " + valorTotalCarro);


        /* intentaba generar un buscador de los productos sin mostrar la lista de estos pero desisti porque se me complico
        //Buscador de Productos sin mostrar la lista
        Scanner sc = new Scanner(System.in);
        int buscaProducto;
        buscaProducto = sc.nextInt();


        while (buscaProducto<1 ||buscaProducto > 6) {
            System.out.print("El numero ingresado no corresponde a un producto" + '\n' + "Vulve a ingresar un numero" + '\n');
            buscaProducto = sc.nextInt();

        }

        System.out.println("Su producto corresponde a: " + productos[buscaProducto-1] + '\n' + "Este tiene un costo de: " + valorProductos[buscaProducto-1] );

        System.out.println("Para ingresar este prodcuto al carro presione 1 de lo contrario presione 2");
        agregaCarro = sc.nextInt();

       */
    }
}