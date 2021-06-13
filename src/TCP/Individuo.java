/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TCP;

import genetico2.tools;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author carli
 */
public class Individuo {
     public double w1,w2;
    private int[] genotipo;
    private int fitness;
    private int n;
    private int[][] caminos;
    private int[][] matInclinacion;
    private int fitnessGeneral;
    private int fitnessIncli;

    public Individuo(int[] genotipo, int[][] caminos,double w1, double w2) {
        this.genotipo = genotipo;
        this.caminos = caminos;
        this.w1 = w1;
        this.w2 = w2;
        crearMatInclinacion(caminos);
        calcularFitness();
        calculaFitnessGeneral();
    }

    public Individuo(Individuo individuo) {
        this.genotipo = individuo.getGenotipo();
        this.fitness = individuo.getFitness();
        this.caminos = individuo.getCaminos();
        this.matInclinacion = individuo.getMatInclinacion();
        this.fitnessGeneral = individuo.getFitnessGeneral();
        //this.n = reinita.getN();
    }

    public Individuo(int in, int[][] caminos,double w1, double w2) {
        this.n = in;
        this.genotipo = herramientas.generaPosi(caminos.length, in);
        this.caminos = caminos;
        this.w1 = w1;
        this.w2 = w2;
        crearMatInclinacion(caminos);
        calcularFitness();
        calculaFitnessGeneral();
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

    public void calcularFitness() {
        this.fitness=0;
        for (int x = 0; x < this.genotipo.length - 1; x++) {
            this.fitness += this.caminos[this.genotipo[x]][this.genotipo[x + 1]];
            //System.out.println(this.caminos[this.genotipo[x]][this.genotipo[x+1]]); 
        }
        this.fitness += this.caminos[this.genotipo[this.genotipo.length - 1]][this.genotipo[0]];
        //System.out.println(this.caminos[this.genotipo[this.genotipo.length-1]][this.genotipo[0]]);
    }

    public void calculaFitnessGeneral(){
        this.fitnessIncli=0;
        for (int x = 0; x < this.genotipo.length - 1; x++) {
            this.fitnessIncli += this.matInclinacion[this.genotipo[x]][this.genotipo[x + 1]];
            //System.out.println(this.caminos[this.genotipo[x]][this.genotipo[x+1]]); 
        }
        this.fitnessIncli += this.matInclinacion[this.genotipo[this.genotipo.length - 1]][this.genotipo[0]];
        
        this.fitnessGeneral = (int) (w1*this.fitness + w2*this.fitnessIncli);
    }
    @Override
    public String toString() {
        return "Individuo{" + "genotipo=" + Arrays.toString(genotipo) + ", fitness=" + fitnessGeneral + '}';
    }

    /**
     * @return the caminos
     */
    public int[][] getCaminos() {
        return caminos;
    }

    public int[][] getMatInclinacion() {
        return matInclinacion;
    }

    public void setMatInclinacion(int[][] matInclinacion) {
        this.matInclinacion = matInclinacion;
    }

    public int getFitnessGeneral() {
        return fitnessGeneral;
    }

    public void setFitnessGeneral(int fitnessGeneral) {
        this.fitnessGeneral = fitnessGeneral;
    }
    
    /**
     * @param caminos the caminos to set
     */
    public void setCaminos(int[][] caminos) {
        this.caminos = caminos;
    }

    public boolean isMejor(Individuo ind) {
        if (this.fitnessGeneral < ind.getFitnessGeneral()) {

            return true;
        }
        return false;
    }

    public void crearMatInclinacion(int[][] caminos) {
        this.matInclinacion = new int[caminos.length][caminos.length];
        for (int i = 0; i < caminos.length; i++) {
            for (int j = 0; j < caminos.length; j++) {
                this.matInclinacion[j][i] = caminos[j][i];
                this.matInclinacion[i][j] = -1 * caminos[i][j];
            }
        }
    }

    public void imprimeMatInclinacion() {
        for (int i = 0; i < caminos.length; i++) {
            for (int j = 0; j < caminos.length; j++) {
                System.out.print(this.matInclinacion[i][j] + "\t");
            }
            System.out.println();
        }
    }
    
    public static void main(String args[]) throws IOException{
        int n1 = 10;
        int[][] hola = LeerDatos.tokenizarDataSet();
        Individuo i = new Individuo(2,hola,1.1,.2);
        i.imprimeMatInclinacion();
    }

    
}
