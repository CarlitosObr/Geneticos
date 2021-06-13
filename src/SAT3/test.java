/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAT3;

import graficar.Grafica;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author carli
 */
public class test {

    public static void main(String args[]) throws IOException {
        ArrayList<Instancias> inst = archivo3SAT.tokenizarDataSet();
//        
         JFramePrincipal hr = new JFramePrincipal(inst);
         hr.setVisible(true);
     //       Manager m = new Manager(2);
    }
}
