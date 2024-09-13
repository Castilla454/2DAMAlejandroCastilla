import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    public String[][] pedirMovimiento() {
        System.out.println("Introduzca el movimiento que desee hacer con el submarino");

        String movimiento = sc.nextLine();

        String[][] conjuntoMovimiento = movimiento.split("\n");
        return conjuntoMovimiento;

    }


}