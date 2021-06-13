/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tsatdist;

import SAT3.Individuo;
import SAT3.Instancias;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author carli
 */
public class ObjRemMuta extends UnicastRemoteObject implements MutaOperaciones{
    
    public ObjRemMuta() throws RemoteException{
        super();
    }
    
    @Override
    public void aplicarMutaAleatoria(Individuo p, ArrayList<Instancias> inst) throws RemoteException {
        Random ran = new Random();
        int pos = ran.nextInt(p.getGenotipo().length);
        if(p.getGenotipo()[pos]==1){
            p.getGenotipo()[pos]=0;

        }else {
            p.getGenotipo()[pos]=1;
        }
        // actualizar el genotipo, fenotipo y fitness
        p.calcularFitness(inst);
    }
    
}
