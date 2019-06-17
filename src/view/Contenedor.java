package view;

import com.sun.jmx.defaults.JmxProperties;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.prefs.Preferences;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.event.AncestorListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.plaf.basic.BasicBorders;
import javax.swing.plaf.basic.BasicListUI;
import javax.swing.table.DefaultTableModel;


public class Contenedor extends JFrame{
    private int width = 350;
    private int height = 200;
    public JPanel titelbar=new JPanel();
    public JPanel content= new DevicesView();
    
    
    public Contenedor(){
        
       // guardarDispositivos.remove("1");
        setSize(800, 600);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Fichas Prepago Mikrotik");
        titelbar.setBounds(0,0, 800, 100);
        titelbar.setLayout(null);
        titelbar.setBackground(Color.lightGray);
        
        ImageIcon devicesimg= new ImageIcon(getClass().getResource("/img/devices.png"));
       
        JLabel devices= new JLabel();
        devices.setLayout(null);
        devices.setBounds(20, 0, 100,100);
        devices.setIcon(new ImageIcon(devicesimg.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
        devices.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent me) {
              getContentPane().remove(content); 
              content=new DevicesView();
              // getContentPane().remove(content.getComponentCount());
             content.updateUI();
              getContentPane().add(content);
              getContentPane().repaint();
               

            }   
         });
        JLabel label= new JLabel();
        label.setBounds(0,70,100,30);
        label.setText("Dispositivos");
        devices.add(label);
     
        titelbar.add(devices);
        
        getContentPane().add(titelbar);
        getContentPane().add(content); 
    }
    
    
    
   
    public static void main(String [] args){
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Contenedor().setVisible(true);
            }
        });
    }
}



