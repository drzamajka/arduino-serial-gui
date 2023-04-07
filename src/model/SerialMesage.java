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
    private final int frameId;
    private final int frameLen;
    private final String mesage;
    private final Date reciveTime;

    public SerialMesage(String mesage) {
        this.sendet = false;

        if (mesage.startsWith("FRAME:")) {
            String[] mesageArray = mesage.split(";");
            this.frameId = Integer.parseInt(mesageArray[0].substring(6));
            this.frameLen = Integer.parseInt(mesageArray[1]);
            this.mesage = mesageArray[2];

        } else {
            this.frameId = 0;
            this.frameLen = 0;
            this.mesage = mesage;
        }

        this.reciveTime = new Date();

    }

    public SerialMesage(boolean sendet, String mesage) {
        this.sendet = sendet;
        if (mesage.startsWith("FRAME:")) {
            String[] mesageArray = mesage.split(";");
            this.frameId = Integer.parseInt(mesageArray[0].substring(6));
            this.frameLen = Integer.parseInt(mesageArray[1]);
            this.mesage = mesageArray[2];
        } else {
            this.frameId = 0;
            this.frameLen = 0;
            this.mesage = mesage;
        }
        this.reciveTime = new Date();
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

    public int getFrameId() {
        return frameId;
    }

    public int getFrameLen() {
        return frameLen;
    }

    @Override
    public String toString() {
        String output = simpleDateFormat.format(reciveTime) + " ";

        if (sendet) {
            output += ">>";
        } else {
            output += "<<";
        }

        output += "FRAME:" + frameId + ";" + mesage;
        return output;
    }

}
