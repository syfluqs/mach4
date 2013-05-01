
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Subham <syfluqs@gmail.com>
 */
public class iniparser {
    
     static String iniread(String file, String section, String value) throws FileNotFoundException, IOException
     {
         String property=null;
         String a1[]={"",""};
         String p="";
         String h="";
         String fc = "";   //first char.
         int ln=0;  //line number.
         
         BufferedReader br = new BufferedReader(new FileReader(file));
         
         String line = ""; 
         
         loop:
         
         while ((line=br.readLine())!=null)
                 {
                     
                     if (line.length()>1)
                     {
                     fc = line.substring(0,1);
                     
                     if (fc.equals(";") || fc.equals("#"))
                     {
                         ln+=1;
                         continue loop;       //ignore comments starting with ; or #
                     }
                     else
                     {
                         if (fc.equals("["))
                         {
                             h = line.trim().substring(1, line.trim().length()-1);    //separate out trimmed section name from square brackets.
                             
                         }
                         else   //now to read values and properties
                         {
                             a1 = line.trim().split("=", 2);
                             
                             
                             if (a1[0].trim().equals(value) && h.trim().equals(section))   //mathcing with supplied section name.
                             {
                                 
                                 property = a1[1].trim();   //got the property
                                 
                                 break;
                             }
                             else
                             {
                                 
                                 ln+=1;
                                 continue loop;
                             }
                         }
                     }
                     
                     ln+=1;
                     
                 }
                 
                     else
                     {
                         ln+=1;
                                 continue loop;
                     }
                     
                 }
         
         return property;
     }
    
     static void iniwrite(String file, String section , String value , String property) throws IOException
     {
         
         BufferedWriter bw = new BufferedWriter(new FileWriter(file));
         
         System.err.println("iniwrite -> method not implemented yet.");
         
     }
     
}
