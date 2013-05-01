
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Subham
 */
public class commandreader {
    
    static ArrayList keywords = new ArrayList();
    static ArrayList commands = new ArrayList();
    
    static void read(String file) throws FileNotFoundException, IOException
    {
        
        keywords.removeAll(keywords);
        commands.removeAll(commands);
        
        if (chassis.debug==true)
        System.out.println(timekeeper.time+" commandreader.read() called.");
        
        
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line="";
        int x=0,y=0;
        int ln=0;
        
        loop:
        for(ln=0 ; (line=br.readLine())!=null ; ln++,y++)
        {
            if (line.length()==0)
            {
                ln=ln-1;
                continue loop;
            }
            else
            {
                
            
            if (isOdd(ln))
            {
                
                commands.add(line);
                
            }
            else
            {
                
                keywords.add(line.substring(1, line.length()));
                
            }
            
            }
            
        }
        
        
        if (chassis.debug==true)
        System.out.println(timekeeper.time+" commandreader.read() finished.");
    }
            
    static boolean isOdd(int n)
    {
        
        boolean ret = true;
        
        if (n%2==0)
        {
            ret = false;
        }
        
        return ret;
        
    }
    
}
