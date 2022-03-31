/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.arboledecision;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

/**
 *Clase para mostrar el arbol
 * @author isa
 */
public class DisplaySimpleTree extends JFrame {
  JScrollPane scrollpane;
  
  DisplayPanel panel;
  
  /**
   * Muestra la representacion grafica del arbol
   * @param t arbol
   */
  public DisplaySimpleTree(DecisionTree t) {
    panel = new DisplayPanel(t);
    panel.setPreferredSize(new Dimension(300, 300));
    scrollpane = new JScrollPane(panel);
    getContentPane().add(scrollpane, BorderLayout.CENTER);
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    pack();  // cleans up the window panel
  }
}
