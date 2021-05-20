/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAT3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author carli
 */
public class HiloListener implements ActionListener{
    private JFramePrincipal hl;
    private Genetico3SAT g;
    
    public HiloListener(JFramePrincipal hl, Genetico3SAT g){
        this.hl = hl;
        this.g = g;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(hl.getjTextField1().getText().isEmpty()){
            
        }else{
          double pmuta = Double.parseDouble(hl.getjTextField1().getText());  
          g.setPMuta(pmuta);
        }
        
        
        if(hl.getjTextFieldGen().getText().isEmpty()){
            
        }else{
            int gen = Integer.parseInt(hl.getjTextFieldGen().getText());  
            g.setNum_G(gen);
        }
        
        if(hl.getjTextFieldPobla().getText().isEmpty()){
            
        }else{
            int pob = Integer.parseInt(hl.getjTextFieldPobla().getText());  
            g.setTamPob(pob);
        }
        
        if(this.hl.getAleatoria().isSelected()){
            this.g.setSeleccion(1);
        }else if(this.hl.getTorneo().isSelected()){
            this.g.setSeleccion(2);
        }else if(this.hl.getRuleta().isSelected()){
            this.g.setSeleccion(3);
        }
    }
    
    
}
