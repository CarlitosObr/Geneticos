/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAT3;

import binario.*;
import genetico2.Reina;
import genetico2.tools;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import tsatdist.CruzaOperaciones;
import tsatdist.MutaOperaciones;

/**
 *
 * @author carli
 */
//importante updateUI();
public class Genetico3SAT implements Runnable {

    private int num_G;
    private double pMuta;
    private Poblacion pobActual;
    private int tamPob;
    private int indice;
    private ArrayList<Instancias> inst;
    private LinkedList<int[]> muestras;
    private JFramePrincipal hl;
    private int seleccion = 1;

    public Genetico3SAT(int num_G, double pMuta, int tamPob, int indice, ArrayList<Instancias> inst, JFramePrincipal hl) {
        this.num_G = num_G;
        this.pMuta = pMuta;
        this.tamPob = tamPob;
        // generamos la población inicial como aleatoria
        this.pobActual = new Poblacion(tamPob, indice, inst);
        this.indice = indice;
        this.inst = inst;
        this.hl = hl;
    }

    public double[] evolucionar() {
        double[] fitness = new double[this.getNum_G()];
        ArrayList<Integer> datops = new ArrayList<>();
        Individuo mejor = herramientas.mejorPoblacion3SAT(this.pobActual.getPoblacion());
        datops.add(mejor.getFitness());
        this.hl.actualizarGrafica(datops);
        //generarPoblacionInicial();    
        // proceso evolutivo que tiene relación con el numero de generaciones
        //fitness[0] = tools.mejorPoblacion(getPoblacionActual()).getFitness();
        for (int g = 1; g < this.getNum_G(); g++) {
            Poblacion nuevaPob = new Poblacion();
            // garantizar que se va a generar una población nueva 
            for (int i = 0; i < this.getTamPob(); i++) {
                // Seleccion de una madre 
                Individuo madre = eligeSeleccion(this.seleccion);
                // Seleccion de un padre
                Individuo padre = eligeSeleccion(this.seleccion);
                // cruza (Retornar el mejor ind de la cruza)
                int[] mask = binario.Herramientas.generarArregloBinarios(madre.getGenotipo().length);
                Individuo hijo = Cruza.cruzaPorMascara(mask, madre, padre, this.inst);
                // Se aplica una muta evaluando una probabilidad
                if (generarProbabilidadMuta()) {
                    // System.out.println("ESTOY AQUÍ");
                    Muta.aplicarMutaAleatoria(hijo, this.inst);
                    //System.out.println("JEJE");
                }
                nuevaPob.getPoblacion().add(hijo);
            }
            //System.out.println("ESTOY AQUÍ");
            // actualización de la población
            sustituirPoblacion(nuevaPob);

            this.hl.getjTextArea1().append("G: " + g + " Fitness: " + SAT3.herramientas.mejorPoblacion3SAT(this.pobActual.getPoblacion()).getFitness() + "\n");
            mejor = herramientas.mejorPoblacion3SAT(this.pobActual.getPoblacion());
            datops.add(mejor.getFitness());
            this.hl.actualizarGrafica(datops);
            //System.out.println("G: " + g + " Fitness: " + SAT3.herramientas.mejorPoblacion3SAT(this.pobActual.getPoblacion()).getFitness()+" Con una pMuta de: "+getPMuta());
            fitness[g] = SAT3.herramientas.mejorPoblacion3SAT(this.pobActual.getPoblacion()).getFitness();
        }

        return fitness;
    }
    public double[] evolucionarDistribuido() throws RemoteException, NotBoundException {
        
        Registry reg = LocateRegistry.getRegistry("127.0.0.1", 1099);
        Registry reg2 = LocateRegistry.getRegistry("127.0.0.1", 2010);
            // crear la referencia al objeto remoto 
            CruzaOperaciones objRemoto1;
            objRemoto1 = (CruzaOperaciones) reg.lookup("Crucita");
            MutaOperaciones objRemoto2;
             objRemoto2 = (MutaOperaciones) reg2.lookup("Mutita");
        double[] fitness = new double[this.getNum_G()];
        ArrayList<Integer> datops = new ArrayList<>();
        Individuo mejor = herramientas.mejorPoblacion3SAT(this.pobActual.getPoblacion());
        datops.add(mejor.getFitness());
        this.hl.actualizarGrafica(datops);
        //generarPoblacionInicial();    
        // proceso evolutivo que tiene relación con el numero de generaciones
        //fitness[0] = tools.mejorPoblacion(getPoblacionActual()).getFitness();
        for (int g = 1; g < this.getNum_G(); g++) {
            Poblacion nuevaPob = new Poblacion();
            // garantizar que se va a generar una población nueva 
            for (int i = 0; i < this.getTamPob(); i++) {
                // Seleccion de una madre 
                Individuo madre = eligeSeleccion(this.seleccion);
                // Seleccion de un padre
                Individuo padre = eligeSeleccion(this.seleccion);
                // cruza (Retornar el mejor ind de la cruza)
                int[] mask = binario.Herramientas.generarArregloBinarios(madre.getGenotipo().length);
                Individuo hijo = objRemoto1.cruzaPorMascara(mask, madre, padre, this.inst);
                // Se aplica una muta evaluando una probabilidad
                if (generarProbabilidadMuta()) {
                    // System.out.println("ESTOY AQUÍ");
                    objRemoto2.aplicarMutaAleatoria(hijo, this.inst);
                    //System.out.println("JEJE");
                }
                nuevaPob.getPoblacion().add(hijo);
            }
            //System.out.println("ESTOY AQUÍ");
            // actualización de la población
            sustituirPoblacion(nuevaPob);

            this.hl.getjTextArea1().append("G: " + g + " Fitness: " + SAT3.herramientas.mejorPoblacion3SAT(this.pobActual.getPoblacion()).getFitness() + "\n");
            mejor = herramientas.mejorPoblacion3SAT(this.pobActual.getPoblacion());
            datops.add(mejor.getFitness());
            this.hl.actualizarGrafica(datops);
            //System.out.println("G: " + g + " Fitness: " + SAT3.herramientas.mejorPoblacion3SAT(this.pobActual.getPoblacion()).getFitness()+" Con una pMuta de: "+getPMuta());
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
        for (Individuo aux : nuevaPob.getPoblacion()) {
            this.pobActual.getPoblacion().add(new Individuo(aux));
        }
    }

    private Individuo eligeSeleccion(int s) {
        Individuo i = null;
        switch (s) {
            case 1:
                i = Seleccion.seleccionAleatoria(pobActual);
                break;
            case 2:
                i = Seleccion.seleccionTorneo(pobActual);
                break;
            case 3:
                i = Seleccion.seleccionRuleta(pobActual);
                break;
            default:
                break;

        }
        return i;
    }

    public Poblacion getPoblacionActual() {
        return pobActual;
    }

    public void setPoblacionActual(Poblacion poblacionActual) {
        this.pobActual = poblacionActual;
    }

    public void setPMuta(double muta) {
        this.pMuta = muta;
    }

    public double getPMuta() {
        return pMuta;
    }

    @Override
    public void run() {
       try {
            //evolucionar();
           evolucionarDistribuido();
        } catch (RemoteException ex) {
            Logger.getLogger(Genetico3SAT.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            Logger.getLogger(Genetico3SAT.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @return the num_G
     */
    public int getNum_G() {
        return num_G;
    }

    /**
     * @param num_G the num_G to set
     */
    public void setNum_G(int num_G) {
        this.num_G = num_G;
    }

    /**
     * @return the tamPob
     */
    public int getTamPob() {
        return tamPob;
    }

    /**
     * @param tamPob the tamPob to set
     */
    public void setTamPob(int tamPob) {
        this.tamPob = tamPob;
    }

    public void setSeleccion(int seleccion) {
        this.seleccion = seleccion;
    }

    public ArrayList<Individuo> getmuestraPob(int nmuestra) {
        ArrayList<Individuo> ordenada = (ArrayList<Individuo>) this.pobActual.getPoblacion().clone();
        Collections.sort(ordenada, new Comparator<Individuo>() {

            @Override
            public int compare(Individuo p1, Individuo p2) {
                return (int) (p2.getFitness() - p1.getFitness());
            }
        });
        ArrayList<Individuo> muestras = new ArrayList<>();
        for (int i = 0; i < nmuestra; i++) {
            muestras.add(ordenada.get(i));

        }
        return muestras;
    }

    public void setmuestraPob(ArrayList<Individuo> LL) {
        ArrayList<Individuo> ordenada = (ArrayList<Individuo>) this.pobActual.getPoblacion().clone();
        Collections.sort(ordenada, new Comparator<Individuo>() {

            @Override
            public int compare(Individuo p1, Individuo p2) {
                return (int) (p2.getFitness() - p1.getFitness());
            }
        });

        ArrayList<Individuo> muestras = new ArrayList<>();
        for (int i = this.tamPob - 1; i > this.tamPob - LL.size(); i--) {
            int r = 0;
            this.pobActual.getPoblacion().set(i, LL.get(r));
            r++;
        }
    }

}
