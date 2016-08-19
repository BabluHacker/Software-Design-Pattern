/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sdp1;

import java.io.Writer;
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
    public BlockingQueue<student> FullList;
    public Queue<String> q;
    PassGenerator passwd ;
    long time1;
    //for file writing
    Writer write;
    public prof_D(BlockingQueue<student> list, long time, Writer write){
        this.FullList = list;
        q = new LinkedList<String>();
        this.time1 = time;
        //for file writing
        this.write = write;
        /////
        passwd = new PassGenerator(this.time1, write);
        
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
                student temp = this.FullList.take();
                passwd.generate(temp);
                System.out.println("ID in D :::   ^^***^ : "+temp.getPassword());
                
                
            }
            catch(Exception e){
                System.out.println("error");
            }
            
        }
        
    }
}
