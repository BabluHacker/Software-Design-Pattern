/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sdp1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mehedi
 */
public class prof_E implements Runnable{
    private String prof; 
    public BlockingQueue<student> queue;
    public BlockingQueue<student> BList;
    public Queue<String> QStudentE1;
    private long time2;
    private long time1;
    public prof_E(String prof_in, BlockingQueue<student> q, long time1, BlockingQueue<student> BList){
        this.prof = prof_in;
        this.queue = q;
        this.QStudentE1 = new LinkedList <String> ();
        this.time1 = time1;
        this.BList = BList;
    }
    
    @Override
    public void run() {
        System.out.println("Associate Prof "+this.prof+" has been started/n");
        
        while(true){
            try{
                student student_id = this.queue.take();
                
                if(student_id.getID().equals("list")){
                    
                    System.out.println("included student id: "+this.QStudentE1.toArray() + " size : "+this.QStudentE1.size()+" in "+this.prof);
                        
                }
                else if(this.QStudentE1.contains(student_id.getID())){
                    //do nothing
                    System.out.println("this id has already been included in "+this.prof);
                }
                
                else{
                    this.QStudentE1.add(student_id.getID());
                    System.out.println(student_id +" has been added in "+this.prof +"at time : "+((System.currentTimeMillis()/1000)-this.time1));
                    BList.add(student_id);
                }
                
            } catch (InterruptedException ex) {
                System.err.println("error : "+ex);
            }
            
            
            
            
        }
    }
    
}
