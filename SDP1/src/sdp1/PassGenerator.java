/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sdp1;

import java.io.IOException;
import java.io.Writer;
import java.util.Date;
import java.util.UUID;

/**
 *
 * @author mehedi
 */
public class PassGenerator {
    long time1;
    Writer write;
    public PassGenerator(long time, Writer write){
        this.time1 = time;
        //for writing file
        this.write = write;
        ///
        
    }
    public void generate(String ID) throws IOException{
        Date date = new Date();
        long time = date.getTime();
        String uuid = UUID.randomUUID().toString();
        String IdPasswd = " ID: "+ID+"  pass: "+uuid+" Time: "+((time/1000)-time1);
        System.out.println(IdPasswd);
        //writing...
        write.append(IdPasswd);
        write.append("\r\n");
        write.flush();
        
        
        
    }
}
