/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sdp1;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;
import java.util.Timer;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 *
 * @author mehedi
 */
public class SDP1 {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here
        //timer
        //Timer time = new Timer();
        Writer write = new FileWriter("out.txt");
        
        
        TakeInput Input = new TakeInput(write);
        long time1 = (long) (System.currentTimeMillis()/1000);
        System.out.println("syyyyyyyyyyyyyyyyy :  "+time1);
        Input.getTeachersReady(time1);
        Input.getInput();
        
        
    }
    
}
