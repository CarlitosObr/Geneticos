/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAT3;

import graficar.Grafica;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import org.jfree.chart.ChartPanel;

/**
 *
 * @author carli
 */
public class JFramePrincipal extends javax.swing.JFrame {

    /**
     * Creates new form JFramePrincipal
     */
    //Genetico3SAT g; 
    Manager m;
    int ident;
    Genetico3SAT g;
    JFrameGestor jfg;
    
    public JFramePrincipal(int ident,ArrayList<Instancias> inst, Manager m) {
        initComponents();
        //this.jDesktopPane1.setVisible(true);
        this.setTitle("Genético #"+ident);
        this.m = m;
        this.ident = ident;
        g = new Genetico3SAT(10000, 0.5, 500, 100, inst, this);

        HiloListener hl = new HiloListener(this, g);
        Thread h1 = new Thread(g);
        h1.start();
        
        
        this.jButton1.addActionListener(hl);
        this.jfg= new JFrameGestor(this.g,ident);
        this.jfg.setVisible(true);
    }
    
     public JFramePrincipal(ArrayList<Instancias> inst) {
        initComponents();
        //this.jDesktopPane1.setVisible(true);
        //this.m = m;
        //this.ident = ident;
        g = new Genetico3SAT(10000, 0.5, 500, 100, inst, this);

        HiloListener hl = new HiloListener(this, g);
        Thread h1 = new Thread(g);
        h1.start();
        
        
        this.jButton1.addActionListener(hl);
        this.jfg= new JFrameGestor(this.g,ident);
        this.jfg.setVisible(true);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        seleccion = new javax.swing.ButtonGroup();
        jTfProbMut = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jPanelDeGrafica = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldGen = new javax.swing.JTextField();
        jTextFieldPobla = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        aleatoria = new javax.swing.JRadioButton();
        torneo = new javax.swing.JRadioButton();
        ruleta = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        jButtonEnviar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Cambiar");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        jLabel1.setText("Probabilidad de muta ");

        jPanelDeGrafica.setBorder(new javax.swing.border.MatteBorder(null));

        javax.swing.GroupLayout jPanelDeGraficaLayout = new javax.swing.GroupLayout(jPanelDeGrafica);
        jPanelDeGrafica.setLayout(jPanelDeGraficaLayout);
        jPanelDeGraficaLayout.setHorizontalGroup(
            jPanelDeGraficaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 491, Short.MAX_VALUE)
        );
        jPanelDeGraficaLayout.setVerticalGroup(
            jPanelDeGraficaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel2.setText("Generaciones");

        jTextFieldGen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldGenActionPerformed(evt);
            }
        });

        jLabel3.setText("Población");

        seleccion.add(aleatoria);
        aleatoria.setText("Aleatoria");

        seleccion.add(torneo);
        torneo.setText("Torneo");

        seleccion.add(ruleta);
        ruleta.setText("Ruleta");

        jLabel4.setText("Tipo de Selección");

        jButtonEnviar.setText("Enviar");
        jButtonEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEnviarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jTextFieldPobla, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                                .addComponent(jTextFieldGen)
                                .addComponent(jLabel2))
                            .addComponent(jLabel3))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addComponent(aleatoria)
                                .addGap(18, 18, 18)
                                .addComponent(ruleta)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(77, 77, 77)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addComponent(jTfProbMut, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jLabel1)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(85, 85, 85)
                                        .addComponent(torneo))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel4)
                                        .addGap(15, 15, 15)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButtonEnviar, javax.swing.GroupLayout.Alignment.TRAILING))))))
                .addGap(18, 18, 18)
                .addComponent(jPanelDeGrafica, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addComponent(jButtonEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jTfProbMut, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldGen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jTextFieldPobla, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(23, 23, 23))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(7, 7, 7)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(aleatoria)
                                            .addComponent(ruleta))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(torneo)
                                        .addGap(10, 10, 10)))))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 29, Short.MAX_VALUE))
                    .addComponent(jPanelDeGrafica, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldGenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldGenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldGenActionPerformed

    private void jButtonEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEnviarActionPerformed
        // TODO add your handling code here:
        this.m.intercambiarIndividuos(this.ident, Integer.parseInt(jfg.getGdestino().getText()),Integer.parseInt(jfg.getTamMues().getText()));
    }//GEN-LAST:event_jButtonEnviarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton aleatoria;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonEnviar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanelDeGrafica;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextFieldGen;
    private javax.swing.JTextField jTextFieldPobla;
    private javax.swing.JTextField jTfProbMut;
    private javax.swing.JRadioButton ruleta;
    public static javax.swing.ButtonGroup seleccion;
    private javax.swing.JRadioButton torneo;
    // End of variables declaration//GEN-END:variables

    public JTextField getjTextField1() {
        return jTfProbMut;
    }

    /**
     * @return the jTextArea1
     */
    public javax.swing.JTextArea getjTextArea1() {
        return jTextArea1;
    }

    public JPanel getjPanelDeGrafica() {
        return jPanelDeGrafica;
    }

    public void setjPanelDeGrafica(JPanel jPanelDeGrafica) {
        this.jPanelDeGrafica = jPanelDeGrafica;
    }
    
    
    public void actualizarGrafica(ArrayList<Integer> datops) {
        Grafica grafica = new Grafica("Generacion", "Fitness", "Algoritmo Genético");
        grafica.agregarSerie("Generaciones", datops);
        grafica.crearGrafica();
        ChartPanel cp = grafica.crearChartPanel(getjPanelDeGrafica().getSize());

        getjPanelDeGrafica().removeAll();
        //jfp.getjPanelGrafica().remove(0);
        getjPanelDeGrafica().add(cp, BorderLayout.CENTER);
        getjPanelDeGrafica().updateUI();
        
        /*
        try{sleep(2000);}catch(InterruptedException e){e.printStackTrace();}
         */
    }

    /**
     * @return the jTextFieldGen
     */
    public javax.swing.JTextField getjTextFieldGen() {
        return jTextFieldGen;
    }

    /**
     * @return the jTextFieldPobla
     */
    public javax.swing.JTextField getjTextFieldPobla() {
        return jTextFieldPobla;
    }
    
    public int saberSeleccion(){
        if(this.aleatoria.isSelected()){
            return 1;
        }else if(this.torneo.isSelected()){
            return 2;
        }else if(this.ruleta.isSelected()){
            return 3;
        }else{
            return 0;
        }
    }

    public JRadioButton getAleatoria() {
        return aleatoria;
    }

    public void setAleatoria(JRadioButton aleatoria) {
        this.aleatoria = aleatoria;
    }

    public JRadioButton getRuleta() {
        return ruleta;
    }

    public void setRuleta(JRadioButton ruleta) {
        this.ruleta = ruleta;
    }

    public JRadioButton getTorneo() {
        return torneo;
    }

    public void setTorneo(JRadioButton torneo) {
        this.torneo = torneo;
    }

    /**
     * @param jTextFieldPobla the jTextFieldPobla to set
     */
    public void setjTextFieldPobla(javax.swing.JTextField jTextFieldPobla) {
        this.jTextFieldPobla = jTextFieldPobla;
    }
    
    
}
