/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TCP;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author carli
 */
public class Poblacion {
    
 private ArrayList<Individuo> poblacion;
    private int i;
    private int inicial;

    public Poblacion(int i,int inicial,int[][] camino,double w1, double w2){
        this.i = i;
        this.inicial=inicial;
        this.poblacion = new ArrayList<>();
        inicializarAleatorimente(camino,w1,w2);
    }

    public Poblacion(ArrayList<Individuo> muestra,int[][] caminos,double w1,double w2){
        this.poblacion = new ArrayList<>();
        for(int x=0;x<muestra.size();x++){
            this.poblacion.add(new Individuo(muestra.get(x).getGenotipo(),caminos,w1,w2));
        }
    }

      public Poblacion(){
        this.poblacion = new ArrayList<>();
        
    }

    public Poblacion(Poblacion n,int[][] camino,double w1, double w2){
        this.poblacion = new ArrayList<>();
        for(Individuo aux: n.getPoblacion()){
            this.poblacion.add(new Individuo(aux.getGenotipo(),camino,w1,w2));

        }

    }

    public void inicializarAleatorimente(int[][] camino,double w1, double w2){

       for(int x=0; x< this.i; x++){
           
           
            this.poblacion.add(new Individuo(this.inicial,camino,w1,w2));

       }

    }
    public ArrayList<Individuo> generarMuestraAleatoria(double p){
        int c = (int)((this.i*p)/100);
        ArrayList<Individuo> muestra = new ArrayList<>();
        int pa = 0;
        Random ran = new Random();
        for(int x=0; x<c;x++){
            pa = ran.nextInt(this.i);
            muestra.add(this.poblacion.get(pa));

        }
     return muestra;
    }

    public ArrayList<Individuo> generarMuestraMejores(double p){
        int c = (int)((this.i*p)/100);
       ArrayList<Individuo> muestra = new ArrayList<>();
     return muestra;
    }
   
   public ArrayList<Individuo> getPoblacion(){

    return poblacion;
   }
   
   public int getFitnessTotal(){
   int fitT=0;
   
   for(int i=0;i<poblacion.size();i++){
    fitT+=poblacion.get(i).getFitness();
   
   }
   return fitT;
   }
   
   public void mostrarPob(){
       System.out.println("HOLA"+poblacion.size());
   for(int z=0;z<poblacion.size();z++){
     String aux = "Genotipo: ";
        for (int i = 0; i < poblacion.get(z).getGenotipo().length; i++) {
            aux += poblacion.get(z).getGenotipo()[i] + ",";
            if (i == poblacion.get(z).getGenotipo().length - 1) {
                aux += poblacion.get(z).getGenotipo()[i];

            }
        }
        aux += " Fenotipo => " + poblacion.get(z).getFitness();
        System.out.println(aux);
   }
   }
}
