/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TCP;

import genetico2.tools;
import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author carli
 */
public class Individuo {

    private int[] genotipo;
    private int fitness;
    private int n;
    private int[][] caminos;

    public Individuo(int[] genotipo,int[][] caminos) {
        this.genotipo = genotipo;
        this.caminos = caminos;
        calcularFitness();
    }

    public Individuo(Individuo individuo,int[][] caminos) {
        this.genotipo = individuo.getGenotipo();
        this.fitness = individuo.getFitness();
        this.caminos = caminos;
        //this.n = reinita.getN();
    }

    public Individuo(int n,int[][] caminos) {
        this.n = n;
        this.genotipo = herramientas.generaPosi(n);
        this.caminos = caminos;
        calcularFitness();  
    }

    /**
     * @return the genotipo
     */
    public int[] getGenotipo() {
        return genotipo;
    }

    /**
     * @param genotipo the genotipo to set
     */
    public void setGenotipo(int[] genotipo) {
        this.genotipo = genotipo;
    }

    /**
     * @return the fitness
     */
    public int getFitness() {
        return fitness;
    }

    /**
     * @param fitness the fitness to set
     */
    public void setFitness(int fitness) {
        this.fitness = fitness;
    }

    /**
     * @return the n
     */
    public int getN() {
        return n;
    }

    /**
     * @param n the n to set
     */
    public void setN(int n) {
        this.n = n;
    }
    
    public void calcularFitness(){
        for(int x = 0; x<this.genotipo.length-1; x++){
            this.fitness += this.caminos[this.genotipo[x]][this.genotipo[x+1]];
            System.out.println(this.caminos[this.genotipo[x]][this.genotipo[x+1]]); 
        }
        this.fitness += this.caminos[this.genotipo[this.genotipo.length-1]][this.genotipo[0]];
        System.out.println(this.caminos[this.genotipo[this.genotipo.length-1]][this.genotipo[0]]);
    }
    
//    public void iniciarCaminos(){
//        //this.caminos = new int[this.n][this.n];
//        for(int i = 0; i<this.n; i++){
//            for(int j = 0; j<this.n; j++){
//                if(i == j){
//                    this.caminos[i][j] = 0;
//                }else if(this.caminos[i][j] == 0){
//                    int nuevo = herramientas.generarCaminoNuevo();
//                    this.caminos[i][j]=nuevo;
//                    this.caminos[j][i]=nuevo;
//                }
//                
//            }
//        }
//     }
    @Override
    public String toString() {
        return "Individuo{" + "genotipo=" + Arrays.toString(genotipo) + ", fitness=" + fitness + ", n=" + n + ", caminos=" + caminos + '}';
    }

    

    /**
     * @return the caminos
     */
    public int[][] getCaminos() {
        return caminos;
    }

    /**
     * @param caminos the caminos to set
     */
    public void setCaminos(int[][] caminos) {
        this.caminos = caminos;
    }
    
   
}