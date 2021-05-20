/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAT3;

import binario.*;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author carli
 */
public class Poblacion {

    private ArrayList<Individuo> poblacion;
    private int i, indice;
    private ArrayList<Instancias> inst;
    private Individuo mejor;

    // creacion aleatoria de la población
    public Poblacion(int i, int indice, ArrayList<Instancias> inst) {
        this.i = i;
        this.indice = indice;
        this.poblacion = new ArrayList<>();
        this.inst = inst;
        inicializarAleatorimente();
    }

    // creacion  población con muestreo
    public Poblacion(ArrayList<Individuo> muestra, int i, ArrayList<Instancias> inst) {
        this.poblacion = new ArrayList<>();
        for (int x = 0; x < muestra.size(); x++) {
            this.poblacion.add(new Individuo(muestra.get(x).getGenotipo(), inst));
        }
        // ver como se resolverá el
    }

    // creacion  población con muestreo
    public Poblacion() {
        this.poblacion = new ArrayList<>();

    }

    public Poblacion(Poblacion n) {
        this.poblacion = new ArrayList<>();
        // crear un nueva población en base a otra 
        for (Individuo aux : n.getPoblacion()) {
            this.poblacion.add(new Individuo(aux));

        }

    }

    public void inicializarAleatorimente() {

        // un proceso iterativo con respecto a i
        for (int x = 0; x < this.i; x++) {
            this.poblacion.add(new Individuo(this.indice, this.inst));

        }

    }

    public ArrayList<Individuo> generarMuestraAleatoria(double p) {
        int c = (int) ((this.i * p) / 100);
        ArrayList<Individuo> muestra = new ArrayList<>();
        int pa = 0;
        Random ran = new Random();
        for (int x = 0; x < c; x++) {
            pa = ran.nextInt(this.i);
            muestra.add(this.poblacion.get(pa));

        }
        return muestra;
    }

    public ArrayList<Individuo> generarMuestraMejores(double p) {
        int c = (int) ((this.i * p) / 100);
        ArrayList<Individuo> muestra = new ArrayList<>();
        // ordenar los elementos
        return muestra;
    }

    public ArrayList<Individuo> getPoblacion() {

        return poblacion;
    }

    public int getFitnessTotal() {
        int fitT = 0;

        for (int i = 0; i < poblacion.size(); i++) {
            fitT += poblacion.get(i).getFitness();

        }
        return fitT;
    }
    
     public void calculaMejorIndividuo(){
      int im = 0;
         // recorremos la población 
      for(int i=1;i<this.getPoblacion().size();i++){
         //if(this.getIndividuos().get(im).getFitnessDistancias()>this.getIndividuos().get(i).getFitnessDistancias()){
         if(this.poblacion.get(i).isMejor(this.poblacion.get(im))){
           im=i;
         }
      }
      this.mejor = new Individuo(this.poblacion.get(im));
    }

    public SAT3.Individuo getMejor() {
        return mejor;
    }

    public void setMejor(SAT3.Individuo mejor) {
        this.mejor = mejor;
    }
     
     
}
