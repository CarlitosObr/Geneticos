/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TCP;

import genetico2.*;
import java.util.ArrayList;

/**
 *
 * @author carli
 */
public class GeneticoTCP {
    private int tamanoPob;
    private int numGeneraciones;
    private double probMuta;
    private int bits;
    private Poblacion poblacionActual;
    private int[][] caminos;
    private int inicial;

    public GeneticoTCP(int tamanoPob, int numGeneraciones, 
            double probMuta,int bits,int inicial,int[][] caminos) {
        this.tamanoPob = tamanoPob;
        this.numGeneraciones = numGeneraciones;
        this.probMuta = probMuta;
        this.bits =bits;
        this.inicial = inicial;
        this.caminos = caminos;
        this.poblacionActual = new Poblacion(tamanoPob,inicial,caminos);
    }
    
    public double[] evolucionar(){
    
    double[] fitness  = new double[this.numGeneraciones];
    //generarPoblacionInicial();    
    // proceso evolutivo que tiene relación con el numero de generaciones
    //fitness[0] = tools.mejorPoblacion(getPoblacionActual()).getFitness();
    for(int g=1;g<this.numGeneraciones;g++){
        Poblacion nuevaPob = new Poblacion();
        // garantizar que se va a generar una población nueva 
        for (int i=0; i<this.tamanoPob;i++){
            // Seleccion de una madre 
            Individuo madre = Seleccion.seleccionAleatoria(this.poblacionActual);
            // Seleccion de un padre
            Individuo padre = Seleccion.seleccionAleatoria(this.poblacionActual);
            // cruza (Retornar el mejor ind de la cruza)
            //int[] mask = binario.Herramientas.generarArregloBinarios(madre.getGenotipo().length-1);
            Individuo hijo = Cruza.cruzaAsexual(madre, padre,this.caminos);
            // Se aplica una muta evaluando una probabilidad
            if (generarProbabilidadMuta()){
                // System.out.println("ESTOY AQUÍ");
               Muta.mutaSimple(hijo);
               //System.out.println("JEJE");
            }
            nuevaPob.getPoblacion().add(hijo);
        }
        //System.out.println("ESTOY AQUÍ");
        // actualización de la población
        sustituirPoblacion(nuevaPob);
        System.out.println("G: "+g+" Fitness"+herramientas.mejorPoblacion(this.poblacionActual.getPoblacion()).getFitnessGeneral());
        fitness[g] = herramientas.mejorPoblacion(this.poblacionActual.getPoblacion()).getFitnessGeneral();
    }
    
    
    return fitness;
    
    }

//    private void generarPoblacionInicial() {
//       // generar un población aleatoria de individuos
//       for(int i=0; i < this.tamanoPob;i++){
//           this.getPoblacionActual().add(new Reina(this.bits));
//       }
//       
//    }

    private boolean generarProbabilidadMuta() {
       
        if (this.probMuta>Math.random()){
           return true;
       } else{ return false;}
        
    }

    private void sustituirPoblacion(Poblacion nuevaPob) {
        this.poblacionActual.getPoblacion().clear();
       for(Individuo aux:nuevaPob.getPoblacion()){
           this.poblacionActual.getPoblacion().add(new Individuo(aux));
       }
    }

    public Poblacion getPoblacionActual() {
        return poblacionActual;
    }

    public void setPoblacionActual(Poblacion poblacionActual) {
        this.poblacionActual = poblacionActual;
    }

    /**
     * @return the poblacionActual
     */
    
    
}
