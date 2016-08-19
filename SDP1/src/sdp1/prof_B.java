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
public class prof_B implements Runnable{
    public BlockingQueue<student> FullList;
    public BlockingQueue<student> FullListForD;
    public Queue<String> q;
    long time1;
    
    public prof_B(BlockingQueue<student> list, BlockingQueue<student> listForD, long time){
        this.FullList = list; 
        this.FullListForD = listForD;
        q = new LinkedList<String>();
        this.time1 = time;
    }

    @Override
    public void run() {
        
        //sleep till all inputs are being arrived at desk of B
        System.out.println("prof B started ****************\n");
        try {
            Thread.sleep(15000);
        } catch (InterruptedException ex) {
            Logger.getLogger(prof_B.class.getName()).log(Level.SEVERE, null, ex);
        }
        while(true){
            System.out.println("prof B started to read all ID's in Full List ****************\n");
            try{
                //String temp = this.FullList.take();
                student tmp = FullList.take();
                if(q.contains(tmp.getID())){
                    System.out.println("Already Listed in the Full List of prof_B , ID: "+tmp);
                }
                else{
                    q.add(tmp.getID());
                    FullListForD.offer(tmp);
                    System.out.println("ID:::   ^^^ : "+tmp);
                }
                
            }
            catch(Exception e){
                System.out.println("error");
            }
             
        
        }
    }
    
}
