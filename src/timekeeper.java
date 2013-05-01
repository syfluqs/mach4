
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Subham
 */
public class timekeeper {
    
    static String time = "";
    static String apmarker = "";
    static String dt = "";
    
    static Timer clocktimer = null;
    static TimerTask tt = null;
    
    static TimerTask set_time = null;
    static Timer time_setter = null;
    
    static boolean time_state = false;
    
  
   static void start()
    {
        if (chassis.debug==true)
        {
        System.out.println(timekeeper.time+" timekeeper.start() called.");
        System.out.println(timekeeper.time+" timekeeper.start() up and running.");}
        
        TimerTask tt = new TimerTask()
    {
        
        public void run()
        {
            DateFormat timeFormat = new SimpleDateFormat("hh:mm:ss");
            DateFormat dateFormat = new SimpleDateFormat("EEEEEE , dd MMMMMM");
            DateFormat ampm = new SimpleDateFormat("a");
            Date date = new Date();
            time= timeFormat.format(date);
            apmarker = ampm.format(date);
            dt = dateFormat.format(date);
            
        }
        
    };
        clocktimer = new Timer("timekeeper",true);
        clocktimer.schedule(tt, 0, 1000);
    }
}
