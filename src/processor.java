

import java.io.FileNotFoundException;
import java.io.IOException;
import javax.script.ScriptException;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Subham <syfluqs@gmail.com>
 */
public class processor {
    
static Runtime rt = Runtime.getRuntime();
static Process pr = null;
static String delimiter = "";


    
    static String process(String cmd) throws IOException, FileNotFoundException, InterruptedException, ScriptException
    {
        delimiter = iniparser.iniread("settings.ini", "core", "delimiter");
        String[] cmarray = cmd.split(delimiter);
        cmd=cmarray[0];
        //separating arguements
        String arg = "";
        int i=1; 
                while (i<cmarray.length)
                {
                    if (i!=cmarray.length-1)
                    arg=arg+cmarray[i]+"-";
                    else
                    arg=arg+cmarray[i];
                    
                    i=i+1;
                }
        //done separating arguements.
                
        if (chassis.debug==true)
        System.out.println(timekeeper.time+" Command sent: "+cmd);
        String ret = "";
        String command="";
        
        int keyindex = commandreader.keywords.lastIndexOf(cmd);
        
        
        if (keyindex==-1)
        {
            pr = rt.exec("AutoHotkey.exe balloonify.module \"Not Found\" \"Keyword '"+cmd+"' not found.\" \"2\" \"2\"");
            if (chassis.debug==true)
            System.out.println(timekeeper.time+" "+"Command \""+cmd+"\" not found.");
        }
        else
        {
            command = commandreader.commands.get(keyindex).toString();
            
            if (command.startsWith("{") && command.endsWith("}"))
            {
                command = command.substring(1, command.length()-1);
                
                predef.Do(command,arg);
                
            }
            else
            {
            
                
            if (cmarray.length>=2)
                //arguements passed. Arguements may contain '-' in between.
            {
                i=1; String cm = "";
                while (i<cmarray.length)
                {
                    if (i!=cmarray.length-1)
                    cm=cm+cmarray[i]+"-";
                    else
                    cm=cm+cmarray[i];
                    
                    i=i+1;
                }
                pr = rt.exec("AutoHotkey.exe run.module"+" "+"\""+command.replaceAll("%%t", cm).toString()+"\"");
            }
            else
              //No arguements passed.
              pr = rt.exec("AutoHotkey.exe run.module"+" "+""+command.replaceAll("%%t","")+"");
            
            }
            
        }
        
        
        return ret;
    }
    
}
