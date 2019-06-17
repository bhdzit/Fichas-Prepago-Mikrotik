/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author bhdz
 */
public class AddDevice extends JFrame{
    public AddDevice(){
        setLayout(null);
        setSize(300, 300);
        setLocationRelativeTo(null);
        setTitle("Agregar Dispositivo");
        
        JLabel nombrejl= new JLabel();
        nombrejl.setBounds(10, 10, 280, 30);
        nombrejl.setText("Nombre:");
        add(nombrejl);
        
        JTextField nombrejtf= new JTextField();
        nombrejtf.setBounds(10, 35, 280, 25);
        add(nombrejtf);
        
        JLabel ipjl= new JLabel();
        ipjl.setBounds(10, 55, 280, 30);
        ipjl.setText("Ip:");
        add(ipjl);
        
        JTextField ipjtf= new JTextField();
        ipjtf.setBounds(10, 80, 280, 25);
        add(ipjtf);
        
        JLabel usujl= new JLabel();
        usujl.setBounds(10, 105, 280, 30);
        usujl.setText("Usuario:");
        add(usujl);
        
        JTextField usujtf= new JTextField();
        usujtf.setBounds(10, 130, 280, 25);
        add(usujtf);
        
        JLabel passjl= new JLabel();
        passjl.setBounds(10, 155, 280, 30);
        passjl.setText("Password:");
        add(passjl);
        
        JTextField passjtf= new JTextField();
        passjtf.setBounds(10, 180, 280, 25);
        add(passjtf);
        JButton addDevice= new JButton();
        addDevice.setBounds(10, 210, 280, 25);
        addDevice.setText("Agregar Dispositivo");
        add(addDevice);
        addDevice.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
           DevicesView.setDevicesAtList(nombrejtf.getText(),ipjtf.getText());
                dispose();
//     throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        
        
    
    }
    
}
