/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TCP;

import java.io.IOException;
import java.util.Random;

/**
 *
 * @author carli
 */
public class Muta {

    public static void mutaSimple(Individuo ind) {
        Random ran = new Random();
        int pos = ran.nextInt(ind.getGenotipo().length);
        int nuevapos = ran.nextInt(ind.getGenotipo().length);
        while (pos == nuevapos || pos == 0 || nuevapos==0) {
             pos = ran.nextInt(ind.getGenotipo().length);
             nuevapos = ran.nextInt(ind.getGenotipo().length);
        }
        int aux=ind.getGenotipo()[pos];
        ind.getGenotipo()[pos] = ind.getGenotipo()[nuevapos];
        ind.getGenotipo()[nuevapos] = aux;
        ind.calcularFitness();
    }
    
   /* public static void main(String args[]) throws IOException{
        int[][] hola = LeerDatos.tokenizarDataSet();
        Individuo n = new Individuo(3,hola);
        System.out.println(n.toString());
        mutaSimple(n);
        System.out.println(n.toString());
    }*/
}
