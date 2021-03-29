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
public class Genetico {
    int[] genotipo;
    
    public Genetico(){
        
    }
    
    public int devuelveFenotipo(int[] genotipo){
        int aux = genotipo.length-1;
        int fenotipo = 0;
        for(int i = 0; i< genotipo.length; i++){
            if(genotipo[i]==1){
               fenotipo += Math.pow(2, aux);
            }
            aux--;
        }
        return fenotipo;
    }
    
    public double calculaFitness(int fenotipo){
        return Math.pow(fenotipo, 2);
    }
    
    public int[] cruza(int[] individuo1, int[] individuo2, int[] mascara){
        int[] mejor = new int[individuo1.length];
        int[] mejor2 = new int[individuo2.length];
        for(int x = 0; x<mascara.length; x++){
            if(mascara[x]==1){
                mejor[x] = individuo1[x];
                mejor2[x] = individuo2[x];
            }else{
                mejor[x] = individuo2[x];
                mejor2[x] = individuo1[x];
            }
        }
        double n1, n2;
        n1 = calculaFitness(devuelveFenotipo(mejor));
        n2 = calculaFitness(devuelveFenotipo(mejor2));
        System.out.println();
        if(Math.max(n1, n2) == n1){
            return mejor;
        }else{
            return mejor2;
        }  
        
    }
}
