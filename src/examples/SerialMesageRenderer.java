/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examples;

import com.formdev.flatlaf.intellijthemes.FlatArcOrangeIJTheme;
import java.awt.Color;
import java.awt.Component;
import java.text.SimpleDateFormat;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import model.SerialMesage;

/**
 *
 * @author drzam
 */
public class SerialMesageRenderer  extends CustomCell implements ListCellRenderer<SerialMesage> {
    
    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss:SSS");
    public boolean withDate;

    public SerialMesageRenderer() {
        setOpaque(true);
        withDate = false;
    }

    @Override
    public Component getListCellRendererComponent(JList<? extends SerialMesage> list, SerialMesage serialMesage, int index,
            boolean isSelected, boolean cellHasFocus) {

        String mesage = serialMesage.getMesage();


        jLabelMesage.setText("FRAME:"+ serialMesage.getFrameId() + ";" + mesage);
        
        String stringOperation = "";
        if(withDate){
            stringOperation += simpleDateFormat.format(serialMesage.getReciveTime())+" ";
        }
        if(serialMesage.isSendet()){
            stringOperation += ">>";
        }
        else{
            stringOperation += "<<";
        }
        
        jLabelOperation.setText(stringOperation);

        if (isSelected) {
            jLabelOperation.setForeground(Color.decode("#6b3600"));
            setBackground(list.getSelectionBackground());
            setForeground(list.getSelectionForeground());
        } else {
            jLabelOperation.setForeground(Color.decode("#f57900"));
            setBackground(list.getBackground());
            setForeground(list.getForeground());
        }

        return this;
    }
}
