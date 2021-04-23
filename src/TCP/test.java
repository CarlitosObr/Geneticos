/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TCP;

import java.io.IOException;

/**
 *
 * @author carli
 */
public class test {

    public static void main(String args[]) throws IOException {
//        Individuo n = new Individuo(8);
//        System.out.println(); 
        int n1 = 10;
        int[][] hola = LeerDatos.tokenizarDataSet();
        //System.out.println("hola perro: " + hola.length);
        //herramientas.imprimirMatriz(hola);
        GeneticoTCP g = new GeneticoTCP(20,15,0.12,hola.length,1,hola);
        double[] evolucion = g.evolucionar();
//        System.out.println("hola perro: " + hola.length);
//        Poblacion n = g.getPoblacionActual();
//        System.out.println("hola perro: " + hola.length);
//          Individuo n = new Individuo(n1,hola);
//          System.out.println(n.toString()); 
          //Grafica g = new Grafica("Generación", "Fitness", "TSP");
//        g.agregarSerie("Evolucion", evolucion);
//        g.crearGrafica();
//        g.muestraGrafica();

    }

}
