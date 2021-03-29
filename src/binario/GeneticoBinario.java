/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binario;

/**
 *
 * @author carli
 */
public class GeneticoBinario {
     private int num_G;
    private double pMuta;
    private Poblacion pobActual;
    private int tamPob;
    private int indice;

    public GeneticoBinario(int num_G,double pMuta,int tamPob,int indice){
        this.num_G = num_G;
        this.pMuta = pMuta;
        this.tamPob = tamPob;
        // generamos la población inicial como aleatoria
        this.pobActual = new Poblacion(tamPob,indice);
        this.indice = indice;

    }

    public void evolucionar(){
        int mascara [] = new int[]{0,1,1,1,0,0,0,0};
        // proceso evolutivo donde se generan nuevas poblaciones
        Individuo mejor;
        for(int g=0; g<this.num_G; g++){
            Poblacion nueva = new Poblacion();
            // se agregan los individuos de la población
            mejor = new Individuo(new int[this.indice]);
            for(int i=0; i<this.tamPob;i++){
                // proceso de Selección
                Individuo madre = Seleccion.seleccionAleatoria(this.pobActual);
                Individuo padre = Seleccion.seleccionAleatoria(this.pobActual);
                // proceso de Cruza
                Individuo hijo = Cruza.cruzaPorMascara(mascara, madre, padre);
                // proceso de Mutación
            
                if(Math.random()<this.pMuta){
                    Muta.aplicarMutaAleatoria(hijo);
                    // mutar por referencia al hijo
                }
                // el hijo generado se agregar a la nueva población
                nueva.getPoblacion().add(hijo);
                if (hijo.getFitness()>mejor.getFitness()){
                    mejor = new Individuo(hijo.getGenotipo());
                }
            }
            System.out.println("G"+g+"-"+mejor.toString());
            // actualizar la población actual 
            this.pobActual = new Poblacion(nueva);

        }
        System.out.println();

    }
    
    public static void main(String args[]){
        GeneticoBinario g = new GeneticoBinario(20,0.12,8,8);
        g.evolucionar();
        System.out.println();
    }
}
