/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TCP;

/**
 *
 * @author carli
 */
public class test {

    public static void main(String args[]) {
//        Individuo n = new Individuo(8);
//        System.out.println(); 
          int[][] hola =  herramientas.inicializaCaminos(8);
          herramientas.imprimirMatriz(hola, 8);
          Individuo n = new Individuo(8,hola);
          System.out.println(n.toString()); 
          
          
    }

}
