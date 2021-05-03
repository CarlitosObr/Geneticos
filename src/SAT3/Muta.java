/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAT3;

import binario.*;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author carli
 */
public class Muta {
    public static void aplicarMutaAleatoria(Individuo p,ArrayList<Instancias> inst){
        Random ran = new Random();
        int pos = ran.nextInt(p.getGenotipo().length);
        if(p.getGenotipo()[pos]==1){
            p.getGenotipo()[pos]=0;

        }else {
            p.getGenotipo()[pos]=1;
        }
        // actualizar el genotipo, fenotipo y fitness
        p.calcularFitness(inst);

    }
}
