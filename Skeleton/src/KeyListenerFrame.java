/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.*;


public class KeyListenerFrame {
    JFrame f= new JFrame("KeyListener Tutorial");
    int deltaY,deltaX;
    JTextField dX,dY;
    JLabel xLbl,yLbl;
    JRadioButton automatic,analogue;
    
    KeyListenerFrame(){
        f.setBounds(0,0,200,120);
        f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
        f.setLayout(new GridLayout(3,2));
        
        
        dX = new JTextField("0",3);
        dY = new JTextField("0",3);
        JPanel pane1 = new JPanel(new FlowLayout(2));
        pane1.add(new JLabel("ΔX"));
        pane1.add(dX);
        
        ButtonGroup bg= new ButtonGroup();
        automatic = new JRadioButton("Automatic");

        analogue = new JRadioButton("Use Keys");
        bg.add(automatic);
        bg.add(analogue);
        
        
        JPanel pane2 = new JPanel(new FlowLayout(2));
        pane2.add(new JLabel("ΔY"));
        pane2.add(dY);
        
        
        xLbl = new JLabel("0");
        yLbl = new JLabel("110");
        JPanel pane3 = new JPanel(new FlowLayout(2));
        pane3.add(new JLabel("X : "));
        pane3.add(xLbl);
        
        JPanel pane4 = new JPanel(new FlowLayout(2));
        pane4.add(new JLabel("Y : "));
        pane4.add(yLbl);
        
        
        f.add(pane1);
        f.add(pane2);
        f.add(pane3);
        f.add(pane4);
        f.add(automatic);
        f.add(analogue);
        f.setVisible(true);
    }
    
}
