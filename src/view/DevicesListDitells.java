/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author bhdz
 */
public class DevicesListDitells {

    

    public String getRouterimg() {
        return routerimg;
    }

    public void setRouterimg(String routerimg) {
        this.routerimg = routerimg;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public DevicesListDitells(String routerimg, String nombre, String ip) {
        this.routerimg = routerimg;
        this.nombre = nombre;
        this.ip = ip;
    }
private String routerimg;
private String nombre;
private String ip;
    
}
