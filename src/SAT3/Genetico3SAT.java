/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAT3;

import TCP.herramientas;
import binario.*;
import genetico2.Reina;
import genetico2.tools;
import java.util.ArrayList;

/**
 *
 * @author carli
 */
public class Genetico3SAT {

    private int num_G;
    private double pMuta;
    private Poblacion pobActual;
    private int tamPob;
    private int indice;
    private ArrayList<Instancias> inst;

    public Genetico3SAT(int num_G, double pMuta, int tamPob, int indice, ArrayList<Instancias> inst) {
        this.num_G = num_G;
        this.pMuta = pMuta;
        this.tamPob = tamPob;
        // generamos la población inicial como aleatoria
        this.pobActual = new Poblacion(tamPob, indice, inst);
        this.indice = indice;
        this.inst = inst;

    }

    public double[] evolucionar() {
        double[] fitness = new double[this.num_G];
        //generarPoblacionInicial();    
        // proceso evolutivo que tiene relación con el numero de generaciones
        //fitness[0] = tools.mejorPoblacion(getPoblacionActual()).getFitness();
        for (int g = 1; g < this.num_G; g++) {
            Poblacion nuevaPob = new Poblacion();
            // garantizar que se va a generar una población nueva 
            for (int i = 0; i < this.tamPob; i++) {
                // Seleccion de una madre 
                Individuo madre = Seleccion.seleccionAleatoria(this.pobActual);
                // Seleccion de un padre
                Individuo padre = Seleccion.seleccionAleatoria(this.pobActual);
                // cruza (Retornar el mejor ind de la cruza)
                int[] mask = binario.Herramientas.generarArregloBinarios(madre.getGenotipo().length);
                Individuo hijo = Cruza.cruzaPorMascara(mask, madre, padre,this.inst);
                // Se aplica una muta evaluando una probabilidad
                if (generarProbabilidadMuta()) {
                    // System.out.println("ESTOY AQUÍ");
                    Muta.aplicarMutaAleatoria(hijo,this.inst);
                    //System.out.println("JEJE");
                }
                nuevaPob.getPoblacion().add(hijo);
            }
            //System.out.println("ESTOY AQUÍ");
            // actualización de la población
            sustituirPoblacion(nuevaPob);
            System.out.println("G: " + g + " Fitness" + SAT3.herramientas.mejorPoblacion3SAT(this.pobActual.getPoblacion()).getFitness()+" Con una pMuta de: "+getPMuta());
            fitness[g] = SAT3.herramientas.mejorPoblacion3SAT(this.pobActual.getPoblacion()).getFitness();
        }

        return fitness;
    }

    private boolean generarProbabilidadMuta() {

        if (this.pMuta > Math.random()) {
            return true;
        } else {
            return false;
        }

    }
    
    private void sustituirPoblacion(Poblacion nuevaPob) {
        this.pobActual.getPoblacion().clear();
       for(Individuo aux:nuevaPob.getPoblacion()){
           this.pobActual.getPoblacion().add(new Individuo(aux));
       }
    }
    
     public Poblacion getPoblacionActual() {
        return pobActual;
    }

    public void setPoblacionActual(Poblacion poblacionActual) {
        this.pobActual = poblacionActual;
    }
    
    public void setPMuta(double muta){
        this.pMuta = muta;
    }
    
    public double getPMuta(){
        return pMuta;
    }
}
