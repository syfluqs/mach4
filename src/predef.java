
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Subham
 */
public class predef {
    
    
        static ScriptEngineManager mgr=new ScriptEngineManager();
        static ScriptEngine engine=mgr.getEngineByName("JavaScript");
    
   static void Do(String command,String arg) throws FileNotFoundException, IOException, InterruptedException, ScriptException
    {
        if (chassis.debug==true)
        System.out.println(timekeeper.time+" predef shooted with "+"\""+command+"\"");
        
        if (command.equals("exit") || command.equals("bye"))
        {
            exit();
        }
        else
        {
            if (command.equals("about"))
            {
                about();
            }
            else
            {
                if (command.equals("settings"))
                {
                    settings();
                }
                else
                {
                    if (command.equals("lock"))
                    {
                        lock();
                    }
                    else
                    {
                        if (command.equals("reread"))
                        {
                            reread();
                        }
                        else
                        {
                            if (command.equals("setdefaultposition"))
                            {
                                setdefaultlocation();
                            }
                            else
                            {
                                if (command.equals("notes"))
                                {
                                    new widget_notes().setVisible(true);
                                }
                                else
                                {
                                    if (command.equals("restart"))
                                    {
                                        processor.rt.exec("..\\mach4.exe");
                                        System.exit(0);
                                    }
                                    else
                                    {
                                        if (command.equals("volume"))
                                        {
                                            volume(arg);
                                        }
                                        else
                                        {
                                            if (command.equals("mute"))
                                            {
                                                mute();
                                            }
                                            else
                                            {
                                                if (command.equals("calc"))
                                                {
                                                    calc(arg);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
   
   static void exit()
   {
       if (chassis.debug==true)
       System.out.println(timekeeper.time+" exiting...");
       System.exit(0);
   }
   
   static void about() throws FileNotFoundException, IOException
   {
       new about().setVisible(true);
   }
   
   static void settings() throws FileNotFoundException, IOException, FileNotFoundException, InterruptedException
   {
       new settings().setVisible(true);
       
   }
   
   static void lock() throws FileNotFoundException, IOException
   {
       new lock().setVisible(true);
   }
   
   static void reread() throws FileNotFoundException, IOException
   {
       commandreader.read("commands.cfg");
   }

    static void setdefaultlocation() {
        try {
            
           String x = (iniparser.iniread("settings.ini","gui","xpos"));
           String y = (iniparser.iniread("settings.ini","gui","ypos"));
           
            if (x.equals("") || y.equals(""))
            {
                Dimension dim = Toolkit.getDefaultToolkit().getScreenSize(); 
                int height=dim.height;
                int width=dim.width;
                int ypos = height-chassis.gh-skinner.h-60;  //considering taskbar in windows.
                int xpos = width-chassis.gw-skinner.w-20;   //considering scrollbars in windows.
                chassis.frame.setBounds(xpos,ypos,skinner.w,skinner.h); 
                

                
            }
            else
            {
                chassis.frame.setBounds(Integer.parseInt(x),Integer.parseInt(y),skinner.w,skinner.h); 
            }
            
            
            
            
        } catch (IOException ex) {
            Logger.getLogger(chassis.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void volume(String arg) throws IOException {
        if (arg.equals("f"))
        processor.rt.exec("AutoHotkey.exe vol.module 2 100");
        else
        {
         if (arg.equals("h"))
                processor.rt.exec("AutoHotkey.exe vol.module 2 50");
        else
        processor.rt.exec("AutoHotkey.exe vol.module 2 "+arg);
        }
    }

    private static void mute() throws IOException {
        processor.rt.exec("AutoHotkey.exe vol.module 2 0");
    }

    private static void calc(String arg) throws ScriptException, InterruptedException {
        chassis.input.setText(""+engine.eval(arg));

    }


}
