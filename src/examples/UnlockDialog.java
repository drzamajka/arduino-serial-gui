/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package examples;

import java.util.ArrayList;
import model.NewThread;
import model.SerialMesage;

/**
 *
 * @author drzam
 */
public class UnlockDialog extends javax.swing.JFrame {

    UnlockDialog(SerialTerminal parent) {
        UnlockDialog.parent = parent;
        initComponents();
    }

    @Override
    public void setVisible(boolean b) {
        super.setVisible(b);
        if(odblokowywacz != null){
            odblokowywacz.setPentla(false);
        }
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();

        setTitle("Unlock dialog");
        setLocationByPlatform(true);
        setName("Unlock dialog"); // NOI18N
        setType(java.awt.Window.Type.POPUP);

        jTextField1.setText("EC001699");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel2.setLabelFor(jTextField1);
        jLabel2.setText("Seed:");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jButton1.setText("Calculate");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setLabelFor(jTextField2);
        jLabel3.setText("ECU Key:");

        jTextField2.setText("FAFA");

        jButton2.setText("Unlock ECU");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(5, 5, 5)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String seed = jTextField1.getText().trim();
        String appkey = jTextField2.getText().trim();
        jTextArea1.setText(getKey(seed, appkey)+"");


    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String appkey = jTextField2.getText().trim();
        ArrayList<SerialMesage> beforMesages = new ArrayList<>(parent.getjList());
        parent.sendMesage("2703");
        
        odblokowywacz = new NewThread(100){
            @Override
            public void work() {
                ArrayList<SerialMesage> actualMesages = parent.getjList();
                for(int i=beforMesages.size(); i<actualMesages.size(); i++){
                    SerialMesage tmp = actualMesages.get(i);
                    if(tmp.getMesage().startsWith("6703")){
                        String seed = tmp.getMesage().substring(4);
                        jTextField1.setText(seed);
                        String unlockKey = getKey(seed, appkey);
                        System.out.println("Unlock sukcess!\nUnlock key:"+unlockKey);
                        jTextArea1.setText(unlockKey);
                        parent.sendMesage("2704"+unlockKey);
                        this.setPentla(false);
                    }
                }
            }
        };
        
        odblokowywacz.start();
        
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private int transform(int data, int[] sec) {
        if (data > 32767) {
            data = -(32768 - (data % 32768));
        }

        int result = ((((data % sec[0]) * sec[2]) & 0xFFFFFFF) - ((((data / sec[0]) & 0xFFFFFFFF) * sec[1]) & 0xFFFFFFF) & 0xFFFFFFFF);

        if (result < 0) {
            result += (sec[0] * sec[2]) + sec[1];
        }

        return (result & 0xFFFF);
    }

    private String getKey(String seedTXT, String appKeyTXT) {
        String[] seed = new String[]{seedTXT.substring(0, 2),
            seedTXT.substring(2, 4),
            seedTXT.substring(4, 6),
            seedTXT.substring(6, 8)
        };
        String[] appKey = new String[]{appKeyTXT.substring(0, 2),
            appKeyTXT.substring(2, 4)
        };

        // Hardcoded secrets
        int[] sec_1 = new int[]{0xB2, 0x3F, 0xAA};
        int[] sec_2 = new int[]{0xB1, 0x02, 0xAB};
        int res_msb = transform(Integer.parseInt(appKey[0] + appKey[1], 16), sec_1) | transform(Integer.parseInt(seed[0] + seed[3], 16), sec_2);
        int res_lsb = transform(Integer.parseInt(seed[1] + seed[2], 16), sec_1) | transform(res_msb, sec_2);
        Integer res = (res_msb << 16) | res_lsb;
        return Integer.toHexString(res).toUpperCase();
    }

    private static SerialTerminal parent;
    private NewThread odblokowywacz;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
