/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primero;

/**
 *
 * @author carli
 */
public class test {
    public static void main(String args[]){
        int[] in1 = new int[]{1,0,0,1,1};
        int[] in2 = new int[]{0,1,1,1,1};
        int[] mascara = new int[]{0,1,1,0,0};
        Genetico g = new Genetico();
        int[] cruza = g.cruza(in1, in2, mascara);
        System.out.println();
    }
}
