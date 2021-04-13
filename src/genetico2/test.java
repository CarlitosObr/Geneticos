/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package genetico2;

import graficar.Grafica;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author carli
 */
public class test {

    public static void main(String args[]) throws IOException {
//        int[] gen = new int[]{3,7,1,4,6,2,0,5};
//        Reina r = new Reina(gen);
//        //Reina r2 = new Reina(8);
//        //int fitness = r.calculaAtaqueHor(r.getGenotipo()) + r.calculaAtaqueDiagonal1(r.getGenotipo()) + r.calculaAtaqueDiagonal2(r.getGenotipo());
//        //r.setFitness(fitness);
//        System.out.println(r.getFitness());
//        //System.out.println(r2.getFitness());

        GeneticoReina gb = new GeneticoReina(50, 1000, 0.12, 12);
        //gb.evolucionar();
       double[] evolucion = gb.evolucionar();
//        Grafica g = new Grafica("Generación", "Fitness", "N-Reinas");
//        g.agregarSerie("Evolucion", evolucion);
//        g.crearGrafica();
//        g.muestraGrafica();
        archivero.archivos.escribir(gb.getPoblacionActual());
        
      //  ArrayList<Reina> nueva = archivero.archivos.tokenizarDataSet();
        //System.out.println(nueva.get(0).toString());
        // System.out.println();
       // System.out.println(tools.mejorPoblacion(gb.getPoblacionActual()).toString());
    }
}
