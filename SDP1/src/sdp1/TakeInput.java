/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sdp1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Writer;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 *
 * @author mehedi
 */
public class TakeInput {
    Scanner sc;
    //1st half of proffesors
    BlockingQueue<String> qA1 = new LinkedBlockingQueue<String>();
    BlockingQueue<String> qE1 = new LinkedBlockingQueue<String>();
    BlockingQueue<String> qC1 = new LinkedBlockingQueue<String>();
    //2nd half of professors
    BlockingQueue<String> qA2 = new LinkedBlockingQueue<String>();
    BlockingQueue<String> qE2 = new LinkedBlockingQueue<String>();
    BlockingQueue<String> qC2 = new LinkedBlockingQueue<String>();
    //for B
    BlockingQueue<String> BFullList = new LinkedBlockingQueue<String>();
    //for D
    BlockingQueue<String> DFullList = new LinkedBlockingQueue<String>();
    private File file;
    
    //random
    Random rand;
    //time
    int time2;
    
    //writing file introducing
    Writer write;
    public TakeInput(Writer write){
        //file to write
        file = new File("in.txt");
        //////
        rand = new Random();
        this.write= write;
        System.out.println("thread started "+ "make input\n");
        
    }
    
    public void getTeachersReady(long time1){
        
        //for prof_A
        prof_A A1 = new prof_A("A1", qA1, time1, BFullList);
        prof_A A2 = new prof_A("A2", qA2, time1, BFullList);
        
        //for prof_E
        prof_E E1 = new prof_E("E1", qE1, time1, BFullList);
        prof_E E2 = new prof_E("E2", qE2, time1, BFullList);
        //for prof_C
        prof_C C1 = new prof_C("C1", qC1, time1, BFullList);
        prof_C C2 = new prof_C("C2", qC2, time1, BFullList);
        //for prof_B
        prof_B B = new prof_B(BFullList, DFullList, time1);
        
        //for prof_D
        prof_D D = new prof_D(DFullList, time1, write);
        //starting thread........
        
        new Thread(A1).start();
        new Thread(A2).start();
        
        new Thread(E1).start();
        new Thread(E2).start();
        
        new Thread(C1).start();
        new Thread(C2).start();
        
        new Thread(B).start();
        
        new Thread(D).start();
        
        
        
    }
    public void getInput() throws FileNotFoundException{
        //sc = new Scanner(System.in);
        
        //FileInputStream fstream = new FileInputStream("in.txt");
        //BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
        String tmp;
        BufferedReader br = new BufferedReader(new FileReader(file));
        while(true){
            try{
                while((tmp = br.readLine()) != null){
                    
                    distribute(tmp);
                    Thread.sleep(1000);
                }
                
                
            }
            catch(Exception e){
                System.out.println("error in reading");
            }
            
        }
    }
    private void distribute(String ID){
        
        int t;
        if(ID.equals("list")){
            qA1.offer(ID);
            qA2.offer(ID);
            qE1.offer(ID);
            qE2.offer(ID);
            qC1.offer(ID);
            qC2.offer(ID);
        }
        else{
            t = rand.nextInt();
            if(t < 0){
                t *= -1;
                
            }
            t%=6;
            System.out.println("random slots : "+t);
            if(t==0) qA1.offer(ID);
            else if(t==1) qA2.offer(ID);

            else if(t==2) qE1.offer(ID);
            else if(t==3) qE2.offer(ID);

            else if(t==4) qC1.offer(ID);
            else if(t==5) qC2.offer(ID);
        }
        
    }
}
