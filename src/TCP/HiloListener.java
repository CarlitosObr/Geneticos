/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TCP;

import SAT3.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author carli
 */
public class HiloListener implements ActionListener{
    private JFramePrincipal hl;
    private GeneticoTCP g;
    
    public HiloListener(JFramePrincipal hl, GeneticoTCP g){
        this.hl = hl;
        this.g = g;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(hl.getjTextField1().getText().isEmpty()){
            
        }else{
          double pmuta = Double.parseDouble(hl.getjTextField1().getText());  
          g.setProbMuta(pmuta);
        }
        
        
        if(hl.getjTextFieldGen().getText().isEmpty()){
            
        }else{
            int gen = Integer.parseInt(hl.getjTextFieldGen().getText());  
            g.setNumGeneraciones(gen);
        }
        
        if(hl.getjTextFieldPobla().getText().isEmpty()){
            
        }else{
            int pob = Integer.parseInt(hl.getjTextFieldPobla().getText());  
            g.setTamanoPob(pob);
        }
        if(hl.getW1().getText().isEmpty()){
            
        }else{
            double w1 = Double.parseDouble(hl.getW1().getText());  
            g.setW1(w1);
        }
        
        if(hl.getW2().getText().isEmpty()){
            
        }else{
            double w2 = Double.parseDouble(hl.getW2().getText());  
            g.setW2(w2);
        }
        
    }
    
    
}
