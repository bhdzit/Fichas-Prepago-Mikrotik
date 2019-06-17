/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.prefs.Preferences;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
/**
 *
 * @author bhdz
 */
public class DevicesView extends JPanel{
    
    private JList<DevicesListDitells> listDevices;
    public static Preferences guardarDispositivos;
    private static DefaultListModel<DevicesListDitells> model;
    private static String  listaDispositivos;
    public static int indexSel;
    public static boolean selected;
    public String []dispositivos;
    
    public DevicesView(){
      //  setOpaque(false);
        setBounds(0, 100, 800, 700);
        setLayout(null);
        setBackground(Color.DARK_GRAY);
        guardarDispositivos= Preferences.userRoot().node(this.getClass().getName());
        listaDispositivos=guardarDispositivos.get("1","");
        
        JLabel dispositivosjl =new JLabel();
        dispositivosjl.setBounds(0, 0, 100, 30);
        dispositivosjl.setBackground(Color.DARK_GRAY);
        dispositivosjl.setOpaque(true);
        dispositivosjl.setForeground(Color.RED);
        dispositivosjl.setText("Dispositivos:"); 
        add(dispositivosjl);
        
        JLabel addDevicesjl= new JLabel();
        ImageIcon addDevicesimg=new ImageIcon(getClass().getResource("/img/plus.png"));
        //addDevicesjl.setBackground(Color.blue);
        addDevicesjl.setOpaque(false);
        addDevicesjl.setBounds(120, 0, 30, 30);
        addDevicesjl.setIcon(new ImageIcon(addDevicesimg.getImage().getScaledInstance(30,30, Image.SCALE_SMOOTH)));
        addDevicesjl.addMouseListener(new MouseAdapter() {
        @Override
            public void mouseClicked(MouseEvent me) {
                new AddDevice().setVisible(true);
            }
        });
        
        add(addDevicesjl);
        
        JLabel removeDevicesjl= new JLabel();        
        removeDevicesjl.setOpaque(false);
        ImageIcon removeDevicesimg=new ImageIcon(getClass().getResource("/img/minus.png"));
        removeDevicesjl.setBounds(150, 0, 30, 30);
        removeDevicesjl.setIcon(new ImageIcon(removeDevicesimg.getImage().getScaledInstance(30,30, Image.SCALE_SMOOTH)));
        removeDevicesjl.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(selected){
                    model.remove(indexSel);
                   // System.err.println(dispositivos[indexSel].toString());
                    saveNewDitlls(indexSel);
                }
            }
        });
    
        add(removeDevicesjl);
        add(createMainPanel());
        System.err.println("Lista de Dispositivos:"+listaDispositivos);
            if(!listaDispositivos.equals("")){
            getDevicesList();
            }    
    }
    
    public void saveNewDitlls(int index){
        System.out.print("sdadasd");
        listaDispositivos="";
        for(int i=0;i<dispositivos.length;i++){
            if(i!=index){listaDispositivos+=dispositivos[i]+";";
          //  System.err.print(dispositivos[i]);
            }
        }
          guardarDispositivos.put("1",listaDispositivos);
    }
    
    public  static void setDevicesAtList(String nombre,String ip){
       model.addElement(new DevicesListDitells("router", nombre,ip));
       listaDispositivos+=nombre+","+ip+";";
       guardarDispositivos.put("1", listaDispositivos);
    
    }
    public void getDevicesList(){
      //  System.err.println(listaDispositivos);
        
    dispositivos=listaDispositivos.split(";");
    if(dispositivos.length>0){
        for(String datosDispositivo:dispositivos){
            System.out.println("asdasd"+listaDispositivos);
            String aux[]=datosDispositivo.split(",");
            model.addElement(new DevicesListDitells("router",aux[0],aux[1]));
        }
    }   
 }
    	private JPanel createMainPanel() {
		JPanel panel = new JPanel();
		//panel.setBorder(new EmptyBorder(10, 10, 10, 10));
                panel.setLayout(null);
                panel.setBackground(Color.DARK_GRAY);
                panel.setBounds(0, 25, 190,435);
		// create list book and set to scrollpane and add to panel
                JScrollPane scrollPane= new JScrollPane(listDevices = createListBooks());
		//scrollPane.setAutoscrolls(true); 
                scrollPane.setBounds(0, 5, 190, 430);
                panel.add(scrollPane);
		return panel;
	}

	private JList<DevicesListDitells> createListBooks() {
		// create List model
		model = new DefaultListModel<>();
		// add item to model
		
		JList<DevicesListDitells> list = new JList<DevicesListDitells>(model);
		// set cell renderer
		list.setCellRenderer(new DevicesListView());
		return list;
	}
    
}
