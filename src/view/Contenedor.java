package view;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.AncestorListener;


public class Contenedor extends JFrame{
    public JPanel titelbar=new JPanel();
    public JPanel content= new JPanel();
    
    public Contenedor(){
        setSize(800, 800);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        titelbar.setBounds(0,0, 800, 100);
        titelbar.setLayout(null);
        titelbar.setBackground(Color.yellow);
        
        ImageIcon devicesimg= new ImageIcon(getClass().getResource("/img/devices.png"));
       
        JLabel devices= new JLabel();
        devices.setLayout(null);
        devices.setBounds(20, 0, 100,100);
        devices.setIcon(new ImageIcon(devicesimg.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
        devices.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent me) {
                
               content=new Devices();
              // getContentPane().remove(content.getComponentCount());
               getContentPane().repaint();

            }   
         });
        JLabel label= new JLabel();
        label.setBounds(0,70,100,30);
        label.setText("Dispositivos");
        devices.add(label);
     
        titelbar.add(devices);
        
        content.setBounds(0, 100, 800, 700);
        content.setBackground(Color.BLACK);
        
        getContentPane().add(content);
        getContentPane().add(titelbar);
        
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
class Devices extends JPanel{
    public Devices(){
        System.err.println("dadasdasd");
        setBackground(Color.yellow);
    }



}