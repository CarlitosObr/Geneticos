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
public class GeneticoTCP implements Runnable{
    private int tamanoPob;
    private int numGeneraciones;
    private double probMuta,w1,w2;
    private int bits;
    private Poblacion poblacionActual;
    private int[][] caminos;
    private int inicial;
    private JFramePrincipal principal;

    public GeneticoTCP(int tamanoPob, int numGeneraciones, 
            double probMuta,int bits,int inicial,int[][] caminos,JFramePrincipal principal,double w1, double w2) {
        this.tamanoPob = tamanoPob;
        this.numGeneraciones = numGeneraciones;
        this.probMuta = probMuta;
        this.bits =bits;
        this.inicial = inicial;
        this.caminos = caminos;
        this.poblacionActual = new Poblacion(tamanoPob,inicial,caminos,w1,w2);
        this.principal=principal;
        this.w1 = w1;
        this.w2 = w2;
    }
    
    public double[] evolucionar(){
    
    double[] fitness  = new double[this.numGeneraciones];
     ArrayList<Integer> datops = new ArrayList<>();
         Individuo mejor = herramientas.mejorPoblacion(this.poblacionActual.getPoblacion());
        datops.add(mejor.getFitness());
        this.principal.actualizarGrafica(datops);
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
            Individuo hijo = Cruza.cruzaAsexual(madre, padre,this.caminos,this.w1,this.w2);
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
        this.principal.getjTextArea1().append("G: " + g + " Fitness: " + herramientas.mejorPoblacion(this.poblacionActual.getPoblacion()).getFitnessGeneral()+"\n");
        //System.out.println("G: "+g+" Fitness"+herramientas.mejorPoblacion(this.poblacionActual.getPoblacion()).getFitnessGeneral());
        mejor = herramientas.mejorPoblacion(this.poblacionActual.getPoblacion());
             datops.add(mejor.getFitnessGeneral());
             this.principal.actualizarGrafica(datops);
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

    public int getTamanoPob() {
        return tamanoPob;
    }

    public void setTamanoPob(int tamanoPob) {
        this.tamanoPob = tamanoPob;
    }

    public int getNumGeneraciones() {
        return numGeneraciones;
    }

    public void setNumGeneraciones(int numGeneraciones) {
        this.numGeneraciones = numGeneraciones;
    }

    public double getProbMuta() {
        return probMuta;
    }

    public void setProbMuta(double probMuta) {
        this.probMuta = probMuta;
    }

    public int getBits() {
        return bits;
    }

    public void setBits(int bits) {
        this.bits = bits;
    }

    public int[][] getCaminos() {
        return caminos;
    }

    public void setCaminos(int[][] caminos) {
        this.caminos = caminos;
    }

    public int getInicial() {
        return inicial;
    }

    public void setInicial(int inicial) {
        this.inicial = inicial;
    }

    public double getW1() {
        return w1;
    }

    public void setW1(double w1) {
        this.w1 = w1;
    }

    public double getW2() {
        return w2;
    }

    public void setW2(double w2) {
        this.w2 = w2;
    }
    

    @Override
    public void run() {
        evolucionar();
        System.out.println(herramientas.mejorPoblacion(getPoblacionActual().getPoblacion()).toString());
    }

    /**
     * @return the poblacionActual
     */
    
    
}
