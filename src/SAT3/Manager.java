/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAT3;

import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author carli
 */
public class Manager {
     private final ArrayList<JFramePrincipal> geneticos = new ArrayList<>();

    public Manager(int numGeneticos) throws IOException {
        ArrayList<Instancias> inst = archivo3SAT.tokenizarDataSet();
       for (int x=0; x<numGeneticos;x++){
           JFramePrincipal Aux = new JFramePrincipal(x,inst,this);
           Aux.setVisible(true);
           geneticos.add(Aux);
              //geneticos.add(Aux);
        }
    }
    
    public void intercambiarIndividuos(int origen,int destino, int muestra){
     // el criterio de intercambio es el primero
     JFramePrincipal destinoGen =  this.geneticos.get(destino);
     JFramePrincipal origenGen = this.geneticos.get(origen);
     
     destinoGen.g.setmuestraPob(origenGen.g.getmuestraPob(muestra));
     destinoGen.getjTextFieldPobla().setText(""+origenGen.g.getTamPob());
     destinoGen.jfg.getjTextField2().setText(""+origenGen.g.getTamPob());
    }
}
