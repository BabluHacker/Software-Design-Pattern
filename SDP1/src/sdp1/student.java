/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sdp1;

/**
 *
 * @author mehedi
 */
public class student {
    private String ID;
    private int arrival_time;
    private String pass;
    
    public void setID(String id){
        this.ID = id;
    }
    
    public String getID(){
        return this.ID;
    }
    
    public void setArrivalTime(int time){
        this.arrival_time = time;
    }
    public int getArrivalTime(){
        return this.arrival_time;
    }
    public void setPassword(String pass){
        this.pass = pass;
    }
    public String getPassword(){
        return this.pass;
    }
    
}
