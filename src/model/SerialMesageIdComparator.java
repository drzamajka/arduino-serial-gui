/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Comparator;

/**
 *
 * @author drzam
 */
public class SerialMesageIdComparator implements Comparator<SerialMesage> {

    @Override
    public int compare(SerialMesage o1, SerialMesage o2) {
        return Integer.compare(o1.getFrameId(), o2.getFrameId());
    }
    
}
