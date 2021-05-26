/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TCP;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

/**
 *
 * @author carli
 */
public class Cruza {

    public static Individuo cruzaPorMascaraBinaria(int inicio, Individuo madre, Individuo padre,
            int[] mask, int[][] caminos) {
        int[] gen1 = new int[madre.getGenotipo().length];
        int[] gen2 = new int[madre.getGenotipo().length];
        // recorrer la mascara ¿
        int[] maskarita = mask;
        do {
            gen1[0] = inicio;
            gen2[0] = inicio;
            for (int x = 0; x < maskarita.length; x++) {
                // padre jeje
                if (maskarita[x] == 0) {
                    gen1[x + 1] = padre.getGenotipo()[x + 1];
                    gen2[x + 1] = madre.getGenotipo()[x + 1];
                } // información madre
                else {
                    gen1[x + 1] = madre.getGenotipo()[x + 1];
                    gen2[x + 1] = padre.getGenotipo()[x + 1];
                }
            }
            //System.out.println("Hijo 1: " + Arrays.toString(gen1));
            //System.out.println("Hijo 2: " + Arrays.toString(gen2));
            maskarita = binario.Herramientas.generarArregloBinarios(madre.getGenotipo().length - 1);
        } while (!validaHijo(gen1) && !validaHijo(gen2));

        Individuo i1 = new Individuo(gen1, caminos);
        Individuo i2 = new Individuo(gen2, caminos);
        //System.out.println("INDIVIDUO 1: " +i1.toString());
        //System.out.println("INDIVIDUO 2: " + i2.toString());
        if (i1.getFitness() <= i2.getFitness()) {
            return i1;
        } else {
            return i2;
        }
    }

    public static boolean validaHijo(int[] gen) {
        HashMap<Integer, Integer> entrenador = new HashMap();
        entrenador.put(0, gen[0]);
        for (int i = 1; i < gen.length; i++) {
            if (entrenador.containsValue(gen[i])) {
                return false;
            } else {
                entrenador.put(i, gen[i]);
            }
        }
        return true;
    }

    public static Individuo cruzaAsexual(Individuo padre, Individuo madre, int[][] caminos) {
        int maskIndices[] = new int[padre.getGenotipo().length - 1];
        // creo la mascara de índices 
        for (int ii = 0; ii < maskIndices.length; ii++) {
            maskIndices[ii] = -1;
        }
        for (int i = 1; i <= maskIndices.length; i++) {
            int ind = generarIndiceValido(maskIndices);
            maskIndices[ind] = i;
        }
        int geno1[] = new int[padre.getGenotipo().length];
        int geno2[] = new int[madre.getGenotipo().length];
        geno1[0] = padre.getGenotipo()[0];
        geno2[0] = madre.getGenotipo()[0];
        // construimos los nuevos genotipos
        for (int x = 1; x < geno1.length; x++) {
            geno1[maskIndices[x - 1]] = padre.getGenotipo()[x];
            geno2[maskIndices[x - 1]] = madre.getGenotipo()[x];
        }
        Individuo hijo1 = new Individuo(geno1, caminos);
        Individuo hijo2 = new Individuo(geno2, caminos);

        ArrayList<Individuo> lista = new ArrayList<>();
        lista.add(madre);
        lista.add(padre);
        lista.add(hijo1);
        lista.add(hijo2);
        return retornaMejor(lista);
    }

    public static int generarIndiceValido(int[] ruta) {
        Random r = new Random();
        int indice = r.nextInt(ruta.length);
        while (ruta[indice] != -1) {
            indice = r.nextInt(ruta.length);
        }

        return indice;
    }

    private static Individuo retornaMejor(ArrayList<Individuo> lista) {
        Individuo mejor = lista.get(0);

        for (int x = 1; x < lista.size(); x++) {
            // if(lista.get(x).getFitnessDistancias()<mejor.getFitnessDistancias()){
            if (lista.get(x).isMejor(mejor)) {
                mejor = lista.get(x);
            }
        }
        return mejor;
    }
    /*public static void main(String args[]) throws IOException {
           int[][] prueba = LeerDatos.tokenizarDataSet();
           Individuo padre = new Individuo(2,prueba);
           Individuo madre = new Individuo(2,prueba);
           int[] maska = binario.Herramientas.generarArregloBinarios(madre.getGenotipo().length-1);
           Individuo ne = cruzaPorMascaraBinaria(2,padre,madre,maska,prueba);
           System.out.println("EL MEJOR: " + ne.toString());
    }*/
}
