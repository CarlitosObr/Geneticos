/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAT3;

/**
 *
 * @author carli
 */
public class Subproceso extends Thread{
    public double muta;
    public Genetico3SAT g;
    
    public Subproceso(double muta,Genetico3SAT g){
        this.muta = muta;
        this.g = g;
    }
    
    public void run(){
        g.setPMuta(muta);
    }
}
