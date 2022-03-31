/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.arboledecision;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.text.Normalizer;
import javax.swing.JPanel;

/**
 *Clase para pintar el arbol
 * @author isa
 */
class DisplayPanel extends JPanel {

    DecisionTree t;
    int xs;
    int ys;

    public DisplayPanel(DecisionTree t) {
        this.t = t; // allows dispay routines to access the tree
        setBackground(Color.white);
        setForeground(Color.black);
    }

    protected void paintComponent(Graphics g) {
        g.setColor(getBackground()); //colors the window
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(getForeground()); //set color and fonts
        Font MyFont = new Font("SansSerif", Font.PLAIN, 10);
        g.setFont(MyFont);
        xs = 10;   //where to start printing on the panel
        ys = 20;
        g.drawString("Base conocimientos:\n", xs, ys);
        ys = ys + 10;;
        int start = 0;
        //  print input string on panel, 150 chars per line
        // if string longer than 23 lines don't print
//        if (t.getInputString().length() < 23 * 150) {
//            while ((t.getInputString().length() - start) > 150) {
//                g.drawString(t.getInputString().substring(start, start + 150), xs, ys);
//                start += 151;
//                ys += 15;
//            }
//            g.drawString(t.getInputString().substring(start, t.getInputString().length()), xs, ys);
//        }
        MyFont = new Font("SansSerif", Font.BOLD, 14); //bigger font for tree
        g.setFont(MyFont);
        this.drawTree(g, t.getRootNode()); // draw the tree
        revalidate(); //update the component panel
    }

    public void drawTree(Graphics g, BinNode root) {//actually draws the tree
        int dx, dy, dx2, dy2;
        int SCREEN_WIDTH = 800; //screen size for panel
        int SCREEN_HEIGHT = 700;
        int XSCALE, YSCALE;
        XSCALE = SCREEN_WIDTH / t.getTotalnodes(); //scale x by total nodes in tree
        YSCALE = (SCREEN_HEIGHT - ys) / (t.getMaxheight() + 1); //scale y by tree height

        if (root != null) { // inorder traversal to draw each node
            drawTree(g, root.getNoBranch()); // do left side of inorder traversal 
            dx = root.getXpos() * XSCALE; // get x,y coords., and scale them 
            dy = root.getYpos() * YSCALE + ys;
            String s = (String) root.getQuestOrAns(); //get the word at this node
            g.drawString(s, dx, dy); // draws the word
// this draws the lines from a node to its children, if any
            if (root.getNoBranch() != null) { //draws the line to left child if it exists
                dx2 = root.getNoBranch().getXpos() * XSCALE;
                dy2 = root.getNoBranch().getYpos() * YSCALE + ys;
                g.drawLine(dx, dy, dx2, dy2);
            }
            if (root.getYesBranch() != null) { //draws the line to right child if it exists
                dx2 = root.getYesBranch().getXpos() * XSCALE;//get right child x,y scaled position
                dy2 = root.getYesBranch().getYpos() * YSCALE + ys;
                g.drawLine(dx, dy, dx2, dy2);
            }
            drawTree(g, root.getYesBranch()); //now do right side of inorder traversal 
        }
    }
}
