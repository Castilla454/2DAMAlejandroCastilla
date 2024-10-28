package UD1;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    static Submarino submarino = new Submarino();

    public static void main(String[] args) {
        String[] movimientos = pedirMovimiento();
        System.out.println("El total es de " + submarino.calcularTotal(movimientos));



    }

    public  static String[] pedirMovimiento() {
        System.out.println("Introduzca los movimientos del submarino (deje la línea en blanco para terminar):");

        // Usamos un ArrayList para ir capturando todas las líneas de movimiento
        ArrayList<String> movimientos = new ArrayList<>();

    for(int i =0; i< movimientos.size();i++){
            // Leer cada línea de la entrada
            String movimiento = sc.nextLine().trim();

            // Si la línea está vacía, se rompe el bucle
            if (movimiento.isEmpty()) {
                break;
            }

            // Agregar el movimiento a la lista
            movimientos.add(movimiento);


        // Convertir la lista a un array de String

    }
        return movimientos.toArray(new String[0]);
    }



}