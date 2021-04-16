/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TCP;

import genetico2.Reina;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;

/**
 *
 * @author carli
 */
public class herramientas {

    public static int[] generaPosi(int n) {
        int[] arreglo = new int[n];
        HashMap<Integer, Integer> entrenador = new HashMap();
        Random ran = new Random();
        int primero = ran.nextInt(n);
        arreglo[0] = primero;
        entrenador.put(0, primero);
       // System.out.println(primero);
        for (int x = 1; x < n; x++) {
            primero = generarNumeroAleatorioControlado(n, entrenador);
            //System.out.println(primero);
            arreglo[x] = primero;
            entrenador.put(x, primero);
        }
        return arreglo;
    }

    public static Reina mejorPoblacion(ArrayList<Reina> pob) {
        Reina mejor = new Reina(pob.get(0));
        for (Reina aux : pob) {
            if (aux.getFitness() < mejor.getFitness()) {
                mejor = new Reina(aux);
            }
        }
        return mejor;
    }

    public static int generarNumeroAleatorioControlado(int bound, HashMap entrenador) {
        Random ran = new Random();
        int aux = ran.nextInt(bound);
        while (entrenador.containsValue(aux)) {
            aux = ran.nextInt(bound);
        }
        return aux;
    }

    public static int generarCaminoNuevo() {
        Random ran = new Random();
        int aux = ran.nextInt(100);
        return aux;
    }

    public static int[][] inicializaCaminos(int n) {
        int[][] caminos = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    caminos[i][j] = 0;
                } else if (caminos[i][j] == 0) {
                    int nuevo = generarCaminoNuevo();
                    caminos[i][j] = nuevo;
                    caminos[j][i] = nuevo;
                }

            }
        }
        return caminos;
    }

    public static void imprimirMatriz(int[][] matriz, int n) {
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                System.out.print(matriz[x][y]);
                System.out.print("\t");
            }
            System.out.println();
        }
    }
}
