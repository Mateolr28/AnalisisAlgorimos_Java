import java.util.Scanner;

import com.packages.operations.Operations;
import com.packages.arrays.Vector;
import com.packages.linked_list.LinkedSimpleList;

public class MainMenu {
    public static Scanner input = new Scanner(System.in);

    public static void main(String args[]) {
        String op;

        do {
            System.out.println("------------------");
            System.out.println("|Menú de opciones|");
            System.out.println("-----------------");
            System.out.println("1. Operaciones básicas");
            System.out.println("2. Vectores");
            System.out.println("3. LSL");
            System.out.println("S. Salir");
            System.out.print("Ingrese su opción: ");
            op = input.next().toLowerCase();

            switch (op) {
                case "1":
                    menuOperations();
                    break;
                case "2":
                    menuVectors();
                    break;
                case "3":
                    menuLSL();
                    break;
                case "s":
                    System.out.println("Hasta pronto");
                    break;
                default:
                    System.err.println("Opción no válida");
            }
        } while (!op.equals("s"));
    }

    public static void menuOperations() {
        String op;
        int n;
        Operations oper = new Operations();
        System.out.println("------------------");
        System.out.println("|Menú operaciones|");
        System.out.println("-----------------");
        System.out.println("1. Sumatoria");
        System.out.println("2. Productoria");
        System.out.println("3. Factorial iterativo");
        System.out.println("4. Factorial recursivo");
        System.out.println("S. Salir");
        System.out.print("Ingrese su opción: ");
        op = input.next().toLowerCase();

        switch (op) {
            case "1":
                System.err.println("Ingrese un entero positivo: ");
                n = input.nextInt();
                System.err.println("Suma de 1 a " + n + ": " + oper.sumNaturals(n));
                break;
            case "s":

                break;
            default:
                System.err.println("Opción no válida");
        }
    }

    public static void menuVectors() {
        String op;
        int position, datum;
        Vector objVec = new Vector(7);
        do {
            System.out.println("------------------");
            System.out.println("|Menú vectores|");
            System.out.println("-----------------");
            System.out.println("1. Mostrar vector");
            System.out.println("2. Búsqueda secuencial");
            System.out.println("3. Búsqueda binaria");
            System.out.println("4. Ordenar burbuja");
            System.out.println("5. Ordenar inserción");
            System.out.println("6. Ordenar selección");
            System.out.println("7. Medir tiempo búsqueda secuencial");
            System.out.println("8. Medir tiempo búsqueda binaria");
            System.out.println("9. Medir tiempos de ordenamientos");
            System.out.println("S. Salir");
            System.out.print("Ingrese su opción: ");
            op = input.next().toLowerCase();

            switch (op) {
                case "1":
                    objVec.showVector();
                    break;
                case "2":
                    System.err.println("Ingrese un entero: ");
                    datum = input.nextInt();
                    position = objVec.searchSecuencial(datum);
                    if (position == -1) {
                        System.out.println(datum + " no se encuentra en el vector");
                    } else {
                        System.out.println(datum + " se encuentra en posición " + position);
                    }
                    break;
                case "3":
                    System.err.println("Ingrese un entero: ");
                    datum = input.nextInt();
                    position = objVec.searchBinary(datum);
                    if (position == -1) {
                        System.out.println(datum + " no se encuentra en el vector");
                    } else {
                        System.out.println(datum + " se encuentra en posición " + position);
                    }
                    break;
                case "4":
                    objVec.sortBubble();
                    System.out.println("Vector ordenado");
                    break;
                case "5":
                    objVec.sortInsertion();
                    System.out.println("Vector ordenado");
                    break;
                case "6":
                    objVec.sortSelection();
                    System.out.println("Vector ordenado");
                    break;
                case "7":
                    objVec.searchSequential(input);
                    break;
                case "8":
                    objVec.testBinary(input);
                    break;
                case "9":
                    objVec.sortingTimes(input);
                    break;
                case "s":
                    break;
                default:
                    System.err.println("Opción no válida");
            }
        } while (!op.equals("s"));
    }

    public static void menuLSL() {
        String op;
        int datum;
        LinkedSimpleList lsl = new LinkedSimpleList();
        do {
            System.out.println("----------");
            System.out.println("|Menú LSL|");
            System.out.println("----------");
            System.out.println("1. Agregar nodo por el inicio");
            System.out.println("2. Mostrar LSL");
            System.out.println("S. Salir");
            System.out.print("Ingrese su opción: ");
            op = input.next().toLowerCase();
            switch (op) {
                case "1":
                    System.out.print("Ingrese un entero: ");
                    datum = input.nextInt();
                    lsl.CreateBeginLSL(datum);
                    break;
                case "2":
                    if (lsl.getHead() != null) {
                        lsl.showLSL();
                    } else {
                        System.out.println("Lista vacía");
                    }
                default:
                    break;
            }
        } while (!op.equals("s"));
    }

}
