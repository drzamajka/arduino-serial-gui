/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author drzam
 */
public class SerialMesage {
    
    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss:SSS");
    private final boolean sendet;
    private final String mesage;
    private final Date reciveTime;

    public SerialMesage(String mesage) {
        this.sendet = false;
        this.mesage = mesage;
        this.reciveTime = new Date();
    }
    
    public SerialMesage(boolean sendet, String mesage) {
        this.sendet = sendet;
        this.mesage = mesage;
        this.reciveTime = new Date();;
    }

    public boolean isSendet() {
        return sendet;
    }

    public String getMesage() {
        return mesage;
    }

    public Date getReciveTime() {
        return reciveTime;
    }


    @Override
    public String toString() {
        String output = simpleDateFormat.format(reciveTime)+" ";

        if(sendet){
            output += ">>";
        }
        else{
            output += "<<";
        }
        
        output += " "+mesage;
        return output;
    }
    
    
    
    
    
    
}
