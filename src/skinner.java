
import java.awt.Color;
import java.awt.Font;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.ImageIcon;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Subham <syfluqs@gmail.com>
 */
public class skinner {
    
    static int h = 0;
    static int w =0;
    private static Font f;
    
    static void applySkin() throws FileNotFoundException, IOException, InterruptedException, InstantiationException, IllegalAccessException
    {
        //get skin name from settings.ini file.
        String skin_name = iniparser.iniread("settings.ini", "gui","skin");
        
        //probe for skin, in the directory skins\<skin_name> and get the values for properties.
        //then set these values in chassis components.
        
        
        
        //set background image, height and width.
        chassis.background.setLocation(Integer.parseInt(iniparser.iniread("skins\\"+skin_name+"\\"+skin_name+".ini", "background", "xpos")), Integer.parseInt(iniparser.iniread("skins\\"+skin_name+"\\"+skin_name+".ini", "background", "ypos")));
        chassis.background.setIcon(new ImageIcon("skins\\"+skin_name+"\\"+iniparser.iniread("skins\\"+skin_name+"\\"+skin_name+".ini", "background", "image")));
        chassis.background.repaint();
        
        //set values to dragger
        chassis.dragger.setLocation(Integer.parseInt(iniparser.iniread("skins\\"+skin_name+"\\"+skin_name+".ini", "dragger", "xpos")), Integer.parseInt(iniparser.iniread("skins\\"+skin_name+"\\"+skin_name+".ini", "dragger", "ypos")));
        chassis.dragger.setSize(Integer.parseInt(iniparser.iniread("skins\\"+skin_name+"\\"+skin_name+".ini", "dragger", "width")), Integer.parseInt(iniparser.iniread("skins\\"+skin_name+"\\"+skin_name+".ini", "dragger", "height")));
        
        //set values to input
        chassis.input.setLocation(Integer.parseInt(iniparser.iniread("skins\\"+skin_name+"\\"+skin_name+".ini", "input", "xpos")), Integer.parseInt(iniparser.iniread("skins\\"+skin_name+"\\"+skin_name+".ini", "input", "ypos")));
        chassis.input.setSize(Integer.parseInt(iniparser.iniread("skins\\"+skin_name+"\\"+skin_name+".ini", "input", "width")), Integer.parseInt(iniparser.iniread("skins\\"+skin_name+"\\"+skin_name+".ini", "input", "height")));
        String[] tc = iniparser.iniread("skins\\"+skin_name+"\\"+skin_name+".ini", "font", "color").split(",");
        String[] sc = iniparser.iniread("skins\\"+skin_name+"\\"+skin_name+".ini", "font", "selected_color").split(",");
        String[] sec = iniparser.iniread("skins\\"+skin_name+"\\"+skin_name+".ini", "font", "selection_color").split(",");
        chassis.input.setForeground(new Color(Integer.parseInt(tc[0]),Integer.parseInt(tc[1]),Integer.parseInt(tc[2]),Integer.parseInt(tc[3])));
        chassis.input.setSelectedTextColor(new Color(Integer.parseInt(sc[0]),Integer.parseInt(sc[1]),Integer.parseInt(sc[2]),Integer.parseInt(sc[3])));
        chassis.input.setSelectionColor(new Color(Integer.parseInt(sec[0]),Integer.parseInt(sec[1]),Integer.parseInt(sec[2]),Integer.parseInt(sec[3])));
        
        //set font style on input
        chassis.input.setFont(new java.awt.Font(iniparser.iniread("skins\\"+skin_name+"\\"+skin_name+".ini", "font", "font_family"), Integer.parseInt(iniparser.iniread("skins\\"+skin_name+"\\"+skin_name+".ini", "font", "font_decor")), Integer.parseInt(iniparser.iniread("skins\\"+skin_name+"\\"+skin_name+".ini", "font", "font_size"))));
        
        //set values to okbutton
        chassis.okbutton.setLocation(Integer.parseInt(iniparser.iniread("skins\\"+skin_name+"\\"+skin_name+".ini", "okbutton", "xpos")), Integer.parseInt(iniparser.iniread("skins\\"+skin_name+"\\"+skin_name+".ini", "okbutton", "ypos")));
        chassis.okbutton.setSize(Integer.parseInt(iniparser.iniread("skins\\"+skin_name+"\\"+skin_name+".ini", "okbutton", "width")), Integer.parseInt(iniparser.iniread("skins\\"+skin_name+"\\"+skin_name+".ini", "okbutton", "height")));
    }
    
    static void getWsize() throws FileNotFoundException, IOException
    {
        
        //get skin name from settings.ini file.
        String skin_name = iniparser.iniread("settings.ini", "gui","skin");
        
        //probe for skin, in the directory skins\<skin_name> and get the values for properties.
        //then set these values in chassis components.
        
        //get window height and width.
        h = Integer.parseInt(iniparser.iniread("skins\\"+skin_name+"\\"+skin_name+".ini", "body", "height"));
        w = Integer.parseInt(iniparser.iniread("skins\\"+skin_name+"\\"+skin_name+".ini", "body", "width"));
    }
    
    static String getskinname() throws FileNotFoundException, IOException
    {
        return iniparser.iniread("settings.ini", "gui","skin");
    }
}
