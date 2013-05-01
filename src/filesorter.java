
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
public class filesorter {
    
    static ArrayList filename = new ArrayList();
    static ArrayList filepath = new ArrayList();
    static ArrayList result = new ArrayList();
    
    
    
   static void scan() throws IOException, InterruptedException
   {
       System.out.println(timekeeper.time+" Starting file scan");
       Process pr = processor.rt.exec("AutoHotkey.exe filescanner.module");
       pr.waitFor();
       System.out.println(timekeeper.time+" Reading the file database");
       read();
       System.out.println(timekeeper.time+" Reading file database complete");
   }
            
   static void read() throws FileNotFoundException, IOException
   {
       filename.addAll(commandreader.keywords);
       
       BufferedReader br = new BufferedReader(new FileReader("filedb.txt"));
       
       String l= "";
       
       while((l=br.readLine())!=null)
       {
           if (!l.equals(""))
           {
               filename.add(l);
           }
           l = br.readLine();
           if (!l.equals(""))
           {
               filepath.add(l);
           }
       }
      
       
   }
   
   static void generateresults(String s)
   {

       int i=0;
       while(i<filename.toArray().length)
       { if (filename.get(i).toString().contains(s)==true)
               result.add(filename.get(i));
       i=i+1;
       }
       
       


   }
   
}
