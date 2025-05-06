package com.packages.arrays;

import java.util.Scanner;

public class Vector {
    private int vec[] = new int[100];
    private int n;

    public Vector(int t) {
        this.n = t;
        for (int i = 0; i < n; i++) {
            this.vec[i] = (int) (Math.random() * 201 - 100);
            // (int) (Math.random() * (límSuperior - límInferior + 1) + límInferior).
        }
    }

    public void showVector() {
        for (int i = 0; i < n; i++) {
            System.out.print(this.vec[i] + "  |  ");
        }
        System.out.println("");
    }

    public int searchSecuencial(int datum) {
        int pos = -1;
        int i = 0;
        while (i < n && pos == -1) {
            if (vec[i] == datum) {
                pos = i;
            } else {
                i++;
            }
        }
        return pos;
    }

    public int searchBinary(int datum) {
        int pos = -1;
        int lMin = 0;
        int lMax = this.n;
        int middle;
        while (lMin <= lMax && pos == -1) {
            middle = (lMin + lMax) / 2;
            if (this.vec[middle] == datum) {
                pos = middle;
            } else if (this.vec[middle] > datum) {
                lMax = middle - 1;
            } else {
                lMin = middle + 1;
            }
        }
        return pos;
    }

    public void sortBubble() {
        int aux;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (vec[i] > vec[j]) {
                    aux = vec[i];
                    vec[i] = vec[j];
                    vec[j] = aux;
                }
            }
        }
    }

    public void sortInsertion() {
        int i, j, aux;
        for (i = 1; i < n; i++) {
            j = i - 1;
            aux = vec[i];
            while (j >= 0 && aux < vec[j]) {
                vec[j + 1] = vec[j];
                j--;
            }
            vec[j + 1] = aux;
        }
    }

    public void sortSelection() {
        int i, min, j, k;
        for (i = 0; i < n - 1; i++) {
            min = vec[i];
            k = i;
            for (j = i + 1; j < n; j++) {
                if (vec[j] < min) {
                    min = vec[j];
                    k = j;
                }
            }
            vec[k] = vec[i];
            vec[i] = min;
        }
    }

    public void searchSequential(Scanner input) {
        System.out.print("Ingrese el tamaño del vector: ");
        n = input.nextInt();

        for (int i = 0; i < n; i++) {
            vec[i] = (int) (Math.random() * 201 - 100);
        }

        System.out.println("Vector generado:");
        showVector();

        System.out.print("Ingrese un numero a insertar: ");
        int dato = input.nextInt();

        System.out.print("Ingrese la posicion donde insertarlo (0 a " + (n - 1) + "): ");
        int pos = input.nextInt();

        vec[pos] = dato;

        long inicio = System.nanoTime();
        int r = searchSecuencial(dato);
        long fin = System.nanoTime();

        System.out.println("Dato encontrado en posicion: " + r);
        System.out.println("Tiempo de búsqueda secuencial: " + (fin - inicio) + " ns");
        System.out.println("Complejidades -> min: O(1), prom: O(n), max: O(n)");

        // Memoria usada
        int memoriaBytes = n * Integer.BYTES;
        double memoriaMB = memoriaBytes / (1024.0 * 1024.0);
        System.out.printf("\nMemoria estimada del vector: %d bytes (%.2f MB)\n", memoriaBytes, memoriaMB);
    }

    public void testBinary(Scanner input) {
        System.out.print("Ingrese el tamaño del vector: ");
        n = input.nextInt();

        vec = new int[n];
        for (int i = 0; i < n; i++) {
            vec[i] = (int) (Math.random() * 201 - 100);
        }

        System.out.println("Vector generado:");
        showVector();

        System.out.print("Ingrese un número a insertar: ");
        int dato = input.nextInt();

        System.out.print("Ingrese la posición donde insertarlo (0 a " + (n - 1) + "): ");
        int pos = input.nextInt();

        vec[pos] = dato;

        sortInsertion();
        System.out.println("Vector ordenado:");
        showVector();

        long inicio = System.nanoTime();
        int r = searchBinary(dato);
        long fin = System.nanoTime();

        System.out.println("Dato encontrado en posicion: " + r);
        System.out.println("Tiempo de busqueda binaria: " + (fin - inicio) + " ns");
        System.out.println("Complejidades -> min: O(1), prom: O(log n), max: O(log n)");

        // Memoria usada
        int memoriaBytes = n * Integer.BYTES;
        double memoriaMB = memoriaBytes / (1024.0 * 1024.0);
        System.out.printf("\nMemoria estimada del vector: %d bytes (%.2f MB)\n", memoriaBytes, memoriaMB);

    }

    public void sortingTimes(Scanner input) {
        System.out.print("Ingrese el tamaño del vector: ");
        n = input.nextInt();

        // Vector
        int[] original = new int[n];
        for (int i = 0; i < n; i++) {
            original[i] = (int) (Math.random() * 201 - 100);
        }

        // Burbuja
        System.arraycopy(original, 0, vec, 0, n);
        long start = System.nanoTime();
        sortBubble();
        long end = System.nanoTime();
        System.out.println("Tiempo burbuja: " + (end - start) + " ns");

        // Inserción
        System.arraycopy(original, 0, vec, 0, n);
        start = System.nanoTime();
        sortInsertion();
        end = System.nanoTime();
        System.out.println("Tiempo insercion: " + (end - start) + " ns");

        // Selección
        System.arraycopy(original, 0, vec, 0, n);
        start = System.nanoTime();
        sortSelection();
        end = System.nanoTime();
        System.out.println("Tiempo seleccion: " + (end - start) + " ns");

        System.out.println("Complejidades:");
        System.out.println("- Burbuja     -> min: O(n), prom: O(n²), max: O(n²)");
        System.out.println("- Insercion   -> min: O(n), prom: O(n²), max: O(n²)");
        System.out.println("- Seleccion   -> min: O(n²), prom: O(n²), max: O(n²)");

        // Memoria usada
        int memoriaBytes = n * Integer.BYTES;
        double memoriaMB = memoriaBytes / (1024.0 * 1024.0);
        System.out.printf("\nMemoria estimada del vector: %d bytes (%.2f MB)\n", memoriaBytes, memoriaMB);
    }

}
