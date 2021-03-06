
import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * about.java
 *
 * Created on Sep 15, 2012, 10:26:33 AM
 */
/**
 *
 * @author Subham
 */
public class about extends javax.swing.JFrame {

    /** Creates new form about */
    public about() throws FileNotFoundException, IOException {
        initComponents();
        
        //populating info
        
        /* Total number of processors or cores available to the JVM */
        info.append("Available processors (cores): " + 
        Runtime.getRuntime().availableProcessors()+"\n\n");

        /* Total amount of free memory available to the JVM */
        info.append("Free memory (MB): " + 
        Runtime.getRuntime().freeMemory()/(1024*1024)+"\n");

        /* This will return Long.MAX_VALUE if there is no preset limit */
        long maxMemory = Runtime.getRuntime().maxMemory()/(1000*1000);
        /* Maximum amount of memory the JVM will attempt to use */
        info.append("Maximum memory (bytes): " + 
        (maxMemory == Long.MAX_VALUE ? "no limit" : maxMemory)+"\n");

        /* Total memory currently in use by the JVM */
        info.append("Total memory (bytes): " + 
        Runtime.getRuntime().totalMemory()+"\n");

        /* Get a list of all filesystem roots on this system */
        File[] roots = File.listRoots();

        /* For each filesystem root, print some info */
        for (File root : roots) {
            info.append("\n");
            info.append("File system root: " + root.getAbsolutePath()+"\n");
            info.append("Total space (bytes): " + root.getTotalSpace()+"\n");
            info.append("Free space (bytes): " + root.getFreeSpace()+"\n");
            info.append("Usable space (bytes): " + root.getUsableSpace()+"\n\n");
            
         }
        
        info.append((ManagementFactory.getMemoryMXBean().getNonHeapMemoryUsage()).toString()+"\n\n");
        info.append("java.version:"+System.getProperty("java.version")+"\n");
        info.append("java.vendor:"+System.getProperty("java.vendor")+"\n");
        info.append("java.home:"+System.getProperty("java.home")+"\n");
        info.append("java.vm.version:"+System.getProperty("java.vm.version")+"\n");
        info.append("os.name:"+System.getProperty("os.name")+"\n");
        info.append("os.arch:"+System.getProperty("os.arch")+"\n");
        info.append("user.name:"+System.getProperty("user.name")+"\n");

        
        
        //set the version
        version.setText(iniparser.iniread("settings.ini", "version", "version"));
        
        setSize(512,358);
        
        //position the window at center of screen
        //Note: do not run about.java without running chassis.java. Doing so
        //will cause wrong positioning of about window.
        setBounds((int)(chassis.width-505)/2,(int)(chassis.height-370)/2,505,370);

        jTextArea2.setBackground(new Color(0,0,0,0));
        jScrollPane1.setBackground(new Color(0,0,0,0));
        jScrollPane1.getViewport().setOpaque(false);
        jScrollPane1.setBorder(BorderFactory.createEmptyBorder());
        jScrollPane1.setOpaque(false);
        
        BufferedReader br = new BufferedReader(new FileReader("..\\changelog.txt"));
        String line = "";
        while ((line = br.readLine())!=null)
        {
            jTextArea2.append(line+"\n");
        }
        
        
    }

    
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        version = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        info = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("About Mach4");
        setAlwaysOnTop(true);
        setResizable(false);
        getContentPane().setLayout(null);

        jTabbedPane1.setBackground(new java.awt.Color(0, 0, 0));

        jPanel1.setLayout(null);

        version.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        version.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(version);
        version.setBounds(252, 84, 230, 20);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/splash.png"))); // NOI18N
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 500, 315);

        jTabbedPane1.addTab("About", jPanel1);

        jPanel2.setLayout(null);

        jScrollPane1.setBorder(null);
        jScrollPane1.setViewportBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jScrollPane1.setOpaque(false);

        jTextArea2.setColumns(20);
        jTextArea2.setEditable(false);
        jTextArea2.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        jTextArea2.setLineWrap(true);
        jTextArea2.setRows(5);
        jTextArea2.setTabSize(2);
        jTextArea2.setWrapStyleWord(true);
        jTextArea2.setBorder(null);
        jTextArea2.setMargin(new java.awt.Insets(15, 15, 15, 15));
        jScrollPane1.setViewportView(jTextArea2);

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(4, 10, 486, 290);

        jTabbedPane1.addTab("Changelog", null, jPanel2, "");

        jPanel3.setLayout(null);

        info.setColumns(20);
        info.setLineWrap(true);
        info.setRows(5);
        info.setWrapStyleWord(true);
        jScrollPane2.setViewportView(info);

        jPanel3.add(jScrollPane2);
        jScrollPane2.setBounds(0, 0, 490, 310);

        jTabbedPane1.addTab("Info", jPanel3);

        getContentPane().add(jTabbedPane1);
        jTabbedPane1.setBounds(0, 0, 500, 340);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(about.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(about.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(about.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(about.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
               
                    try {
                        new about().setVisible(true);
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(about.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(about.class.getName()).log(Level.SEVERE, null, ex);
                    }
                
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea info;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JLabel version;
    // End of variables declaration//GEN-END:variables
}
