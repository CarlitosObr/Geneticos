/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAT3;

import java.io.Serializable;

/**
 *
 * @author carli
 */
public class Instancias implements Serializable{
    int[] elementos;
    
    public Instancias(int[] elementos){
        this.elementos =  elementos;
    }

    public int[] getElementos() {
        return elementos;
    }

    public void setElementos(int[] elementos) {
        this.elementos = elementos;
    }
      
}
