/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAT3;

import graficar.Grafica;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author carli
 */
public class test {

    public static void main(String args[]) throws IOException {
        ArrayList<Instancias> inst = archivo3SAT.tokenizarDataSet();
        Individuo i1 = new Individuo(new int[]{1,1,0,0,0,0,0,1,1,0,1,1,1,1,1,1,0,1,0,1,1,0,1,1,0,0,1,1,1,1,1,1,1,0,1,1,0,1,1,0,1,0,1,1,1,0,1,0,1,0,0,1,1,1,1,0,0,0,0,1,1,1,1,0,1,0,1,1,1,1,0,1,0,1,1,1,0,0,1,0,0,1,0,1,1,1,0,1,0,1,0,0,0,0,1,0,1,1,0,1,1},inst);
        Genetico3SAT g = new Genetico3SAT(10000, 0.5, 500, 100, inst);
        
        System.out.println(i1.toString());
//        double[] evolucion = g.evolucionar();
//        System.out.println(herramientas.mejorPoblacion3SAT(g.getPoblacionActual().getPoblacion()).toString());
//        Grafica g1 = new Grafica("Generación", "Fitness", "3SAT");
//        g1.agregarSerie("Evolucion", evolucion);
//        g1.crearGrafica();
//        g1.muestraGrafica();
    }
}
