/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package genetico2;

/**
 *
 * @author carli
 */
public class test {

    public static void main(String args[]) {
//        int[] gen = new int[]{3,7,1,4,6,2,0,5};
//        Reina r = new Reina(gen);
//        //Reina r2 = new Reina(8);
//        //int fitness = r.calculaAtaqueHor(r.getGenotipo()) + r.calculaAtaqueDiagonal1(r.getGenotipo()) + r.calculaAtaqueDiagonal2(r.getGenotipo());
//        //r.setFitness(fitness);
//        System.out.println(r.getFitness());
//        //System.out.println(r2.getFitness());

       GeneticoReina gb = new GeneticoReina(50, 50, 0.12,8);
       gb.evolucionar();
      // System.out.println();
        System.out.println(tools.mejorPoblacion(gb.getPoblacionActual()).toString());
    }
}
