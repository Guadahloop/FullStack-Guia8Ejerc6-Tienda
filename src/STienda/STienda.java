package STienda;

import java.util.HashMap;
import java.util.Scanner;
import ETienda.ETienda;
import java.util.Map;

public class STienda {

    Scanner leer = new Scanner(System.in).useDelimiter("\n");
    HashMap<String, Double> appTienda = new HashMap();

    public void creaProducto() {

        String Producto;
        Double Precio;
        System.out.println("Ingrese un producto:");
        Producto = leer.next();
        System.out.println("Ingrese su precio:");
        Precio = leer.nextDouble();

        ETienda productos = new ETienda();
        productos.setProducto(Producto);
        productos.setPrecio(Precio);
        appTienda.put(Producto, Precio);
    }

    public void muestraProducto() {

        for (Map.Entry<String, Double> entry : appTienda.entrySet()) {
            String key = entry.getKey();
            Double value = entry.getValue();
            //key es prodcuto y value es precio
            System.out.println("Los productos son: " + key + " $" + value);

        }
    }

    public void modificaPrecio() {

        String precioModif;
        Double nuevoPrecio;
        System.out.println("¿Qué precio desea modificar?, ingrese el producto:");
        precioModif = leer.next();

        for (Map.Entry<String, Double> entry : appTienda.entrySet()) {
            String Producto = entry.getKey();
//          Double value = entry.getValue(); Porque solo busca el producto, no el precio.

            if (precioModif.equalsIgnoreCase(Producto)) {
                System.out.println("Ingrese el nuevo precio:");
                nuevoPrecio = leer.nextDouble();
                appTienda.replace(Producto, nuevoPrecio);
            }
        }
    }

    public void eliminaProducto() {

        String productoEliminado;
        System.out.println("Ingrese el producto a eliminar:");
        productoEliminado = leer.next();

        //Siempre recorrer la lista así:
        for (Map.Entry<String, Double> entry : appTienda.entrySet()) {
            String Producto = entry.getKey();
//          Double value = entry.getValue();

            if (productoEliminado.equalsIgnoreCase(Producto)) {
                appTienda.remove(Producto);
            }

        }

    }

    public void menu() {

        System.out.println("");
        System.out.println("*--------------------------*");
        String opcion;
        do {
            System.out.println("0 = Salir del programa");
            System.out.println("1 = Agregar Producto");
            System.out.println("2 = Cambiar Precio");
            System.out.println("3 = Eliminar Producto");
            System.out.println("4 = Mostrar Productos");
            System.out.println("Ingrese una opción:");
            
            opcion = leer.next();

            switch (opcion) {

                case "1":
                    creaProducto();
                    break;
                case "2":
                    modificaPrecio();
                    break;
                case "3":
                    eliminaProducto();
                    break;
                case "4":
                    muestraProducto();
                    break;
                case "0":
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (!opcion.equals("0"));
        System.out.println(" ");
        System.out.println("*--------------------------*");
    }

}
