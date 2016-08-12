/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sdp1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mehedi
 */
public class prof_D implements Runnable{
    public BlockingQueue<String> FullList;
    public Queue<String> q;
    PassGenerator passwd ;
    long time1;
    public prof_D(BlockingQueue<String> list, long time){
        this.FullList = list;
        q = new LinkedList<String>();
        this.time1 = time;
        passwd = new PassGenerator(this.time1);
        
    }

    

    @Override
    public void run() {
        
        //sleep till B sends data to D for password generating
        System.out.println("prof D started ****************\n");
        try {
            Thread.sleep(20000);
        } catch (InterruptedException ex) {
            Logger.getLogger(prof_B.class.getName()).log(Level.SEVERE, null, ex);
        }
        while(true){
            System.out.println("prof D started to read all ID's in Full List ****************\n");
            try{
                String temp = this.FullList.take();
                passwd.generate(temp);
                System.out.println("ID in D :::   ^^***^ : "+temp);
                
                
            }
            catch(Exception e){
                System.out.println("error");
            }
             
        
        }
    }
}
