/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tsatdist;

import SAT3.Individuo;
import SAT3.Instancias;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author carli
 */
public interface MutaOperaciones extends Remote{
    public void aplicarMutaAleatoria(Individuo p,ArrayList<Instancias> inst)throws RemoteException;
}
