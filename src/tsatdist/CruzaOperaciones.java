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
public interface CruzaOperaciones extends Remote{
    public Individuo cruzaPorMascara(int mascara[], Individuo madre, Individuo padre,ArrayList<Instancias> inst) throws RemoteException;
}
