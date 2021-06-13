/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TCP;

import graficar.Grafica;
import java.io.IOException;

/**
 *
 * @author carli
 */
public class test {

    public static void main(String args[]) throws IOException {
//        Individuo n = new Individuo(8);
//        System.out.println(); 
//        int n1 = 10;
        int[][] hola = LeerDatos.tokenizarDataSet();
//        //System.out.println("hola perro: " + hola.length);
//        //herramientas.imprimirMatriz(hola);
//        GeneticoTCP g = new GeneticoTCP(250,10000,0.12,hola.length,3,hola);
//        double[] evolucion = g.evolucionar();
////        System.out.println("hola perro: " + hola.length);
////        Poblacion n = g.getPoblacionActual();
////        System.out.println("hola perro: " + hola.length);
////          Individuo n = new Individuo(n1,hola);
////          System.out.println(n.toString()); 
// System.out.println(herramientas.mejorPoblacion(g.getPoblacionActual().getPoblacion()).toString());
//            
//          Grafica g1 = new Grafica("Generación", "Fitness", "TSP");
//       g1.agregarSerie("Evolucion", evolucion);
//        g1.crearGrafica();
//       g1.muestraGrafica();
        JFramePrincipal hr = new JFramePrincipal(hola);
         hr.setVisible(true);

    }

}
