/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sdp1;

import java.util.Date;
import java.util.UUID;

/**
 *
 * @author mehedi
 */
public class PassGenerator {
    long time1;
    
    public PassGenerator(long time){
        this.time1 = time;
    }
    public void generate(String ID){
        Date date = new Date();
        long time = date.getTime();
        String uuid = UUID.randomUUID().toString();
        System.out.println("ID: "+ID+"  pass: "+uuid+" Time: "+((time/1000)-time1) +"  ");
    }
}
