/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author bhdz
 */
public class DevicesListView extends JPanel implements ListCellRenderer<DevicesListDitells>{

        private JLabel lbIcon = new JLabel();
	private JLabel lbName = new JLabel();
	private JLabel lbIp = new JLabel();
	private JPanel panelText;
	private JPanel panelIcon;
        
        public DevicesListView(){
        
        setLayout(new BorderLayout(0, 5));

		panelText = new JPanel(new GridLayout(0, 1));
		panelText.add(lbName);
		panelText.add(lbIp);

		panelIcon = new JPanel();
		//panelIcon.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelIcon.add(lbIcon);

		add(panelIcon, BorderLayout.WEST);
		add(panelText, BorderLayout.CENTER);        
        }

    @Override
    public Component getListCellRendererComponent(JList<? extends DevicesListDitells> list, DevicesListDitells value, int index, boolean isSelected, boolean cellHasFocus) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                 lbIcon.setIcon(new ImageIcon(getClass().getResource("/img/" + value.getRouterimg()+ ".png")));
		lbName.setText(value.getNombre());
		lbIp.setText(value.getIp());
		lbIp.setForeground(Color.blue);

		// set Opaque to change background color of JLabel
		lbName.setOpaque(true);
		lbIp.setOpaque(true);
		lbIcon.setOpaque(true);
                
                
		
		if (isSelected) {
                        DevicesView.selected=true;
                        DevicesView.indexSel=index;
                        lbName.setBackground(list.getSelectionBackground());
			lbIp.setBackground(list.getSelectionBackground());
			lbIcon.setBackground(list.getSelectionBackground());
			setBackground(list.getSelectionBackground());
			panelIcon.setBackground(list.getSelectionBackground());

                } 
                else { 
                    
                        DevicesView.selected=false;
                        lbName.setBackground(list.getBackground());
			lbIp.setBackground(list.getBackground());
			lbIcon.setBackground(list.getBackground());
			setBackground(list.getBackground());
			panelIcon.setBackground(list.getBackground());
		}
    return this;
    }
    
}
