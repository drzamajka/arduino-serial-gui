/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examples;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author drzam
 */
public class NewThread extends Thread {
    private final int duration;
    
    private Boolean pentla = true;
    int counter = 0;
    

    NewThread(int duration) {
        this.duration = duration;
    }
    


    
    @Override
    public void run() {
        while (pentla) {
           //System.out.println(this.getName() + "I'm runing");
           work();
            try {
                Thread.sleep(duration);
            } catch (InterruptedException ex) {
                Logger.getLogger(NewThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void work(){
      
    }

    public Boolean getPentla() {
        return pentla;
    }

    public void setPentla(Boolean pentla) {
        this.pentla = pentla;
    }
    
    
}
