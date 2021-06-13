/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAT3;

import binario.Herramientas;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author carli
 */
public class Individuo implements Serializable{

    // atributos de un individuo simple
    private int[] genotipo;
    private int fenotipo;
    private int fitness;
    private ArrayList<Instancias> inst;

    public Individuo(int n, ArrayList<Instancias> inst) {
        // valorar su inicio aleatorio
        this.genotipo = Herramientas.generarArregloBinarios(n);
        calcularFitness(inst);
    }

    public Individuo(int[] gen, ArrayList<Instancias> inst) {
        // valorar su inicio aleatorio
        this.genotipo = gen.clone();
        calcularFitness(inst);
    }

    public Individuo(Individuo i) {
        this.genotipo = i.getGenotipo().clone();
        this.fenotipo = i.getFenotipo();
        this.fitness = i.getFitness();
    }

    private void calcularFenotipo() {
        // conversión entre la  representacion del arreglo de enteros a un valor decimal
        int acu = 0;
        int s = 0;
        for (int x = genotipo.length - 1; x >= 0; x--) {
            if (genotipo[x] == 1) {
                acu += Math.pow(2, s);
            }
            s++;
        }
        this.fenotipo = acu;
    }

    public void calcularFitness(ArrayList<Instancias> inst) {
        //calcularFenotipo();
        // evaluar el fenotipo en la función f(x)=x2
        this.fitness = 0;
        for (int i = 0; i < inst.size(); i++) {
            if (validaInstancia(inst.get(i).getElementos())) {
                this.fitness++;
            }
        }
        //this.fitness = this.fenotipo*this.fenotipo;

    }

    public boolean isMejor(Individuo ind) {
//       double distancia = ind.getFitnessDistancias();
//       double inclinacion = ind.getFitnessInclinaciones();
        if (this.fitness > ind.getFitness()) {

            return true;
        }
        return false;
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
     * @return the fenotipo
     */
    public int getFenotipo() {
        return fenotipo;
    }

    /**
     * @param fenotipo the fenotipo to set
     */
    public void setFenotipo(int fenotipo) {
        this.fenotipo = fenotipo;
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

    private boolean validaInstancia(int[] elementos) {
        int ev, cont = 0;
        // System.out.println("PRUEBA ");
        for (int x = 0; x < elementos.length; x++) {
            // System.out.println("VALOR "+ x);
            ev = getGenotipo()[Math.abs(elementos[x]) - 1];
            // System.out.print("VALOR evaluado: "+(Math.abs(elementos[x])-1));
            // System.out.print(" VALOR: "+ elementos[x]+ " BINARIO: "+ev);
            if (elementos[x] * -1 == Math.abs(elementos[x])) {
                ev = ev - 1;
            }
            //System.out.print(" cambio?: "+ ev);
            //System.out.println(ev);
            if (Math.abs(ev) == 1) {
                cont++;
            }

            // System.out.print(" cambio a: "+ Math.abs(ev));
            //System.out.println();
        }
        if (cont != 0) {
            // System.out.println("----- CLARO QUE YES------");
            return true;
        } else {
            return false;
        }

    }

    @Override
    public String toString() {
        return "Individuo{" + "genotipo=" + Arrays.toString(genotipo) + ", fitness=" + fitness + '}';
    }

}
