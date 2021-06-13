/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tsatdist;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author carli
 */
public class ServidorCruza {
    public static void main(String args[]){
        try { 
            ObjRemCruza obj = new ObjRemCruza();
            //hacer el registro del obj remoto 
            Registry reg = LocateRegistry.createRegistry(1099);                 
            //referencia al objeto remoto 
            reg.rebind("Crucita", obj);
            System.out.println("El servidor de la cruza está listo para cruzar...");
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
    }
}
