
import java.io.FileNotFoundException;
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
public class history {
    static ArrayList history  = new ArrayList();
    static int index = 0;
    static String p ="";
    static int count = 50;

    static void add(String a) throws FileNotFoundException, IOException
    {
        
        count = Integer.parseInt(iniparser.iniread("settings.ini", "core", "history_count"));
        
        history.add(a);
        //index = index+1;
        if (history.toArray().length>count)
        {
            history.remove(0); 
        }
        index = history.toArray().length;
        
        
    }
    
    static String next1() //deprciated
    {
        String ret="";
        if (index<history.toArray().length)
        {
            
            ret = (String) history.get(index);
            p=ret;
            index = index +1;
        }
        else
        {
            index=history.toArray().length;
            ret = p;
        }
        return ret;
    }
    
    static String prev1() //depreciated
    {
        
        String ret="";
        if (index>0)
        {
            
            ret = (String) history.get(index);
            p=ret;
            index = index -1;
            
        }
        else
        {
            index=1;
            ret = p;
        }
        return ret;
    }
    
    static String next()
    {
        String ret="";
        
        if (index<history.toArray().length-1)
        {
            
        }
        else
        {
            index = history.toArray().length-1;
        }
        ret = (String) history.get(index);
        index = index+1;
        return ret;
    }
    
    static String prev()
    {
        String ret="";
        
        
        if (index>1)
        {
            
        }
        else
        
        { index=1;}
        
            ret = (String) history.get(index-1);
            index = index-1;
        return ret;
    }
}
