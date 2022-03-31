/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.arboledecision;

/**
 *  Clase para los nodos del arbol
 * @author isa
 */
public class BinNode {

    /* FIELDS */
    private int nodeID;
    private int fatherNodeID;
    private String questOrAns = null;
    private BinNode yesBranch = null;
    private BinNode noBranch = null;
    private String fatherQuestOrAns;
    private BinNode next;
    private int xpos;  //stores x and y position of the node in the tree
    private int ypos;  

    /**
     * @author samm
     * Constructor
     * @param newNodeID nuevo id para el nodo
     * @param newQuestAns valor string del nodo
     */
    public BinNode(int newNodeID, String newQuestAns) {
        nodeID = newNodeID;
        questOrAns = newQuestAns;
    }

    /**
     * Devuelve la posicion en x
     * @return posicion en x del nodo
     */
    public int getXpos() {
        return xpos;
    }
    /**
     * Asigna la posicion en x
     * @param xpos posicion en x del nodo
     */
    public void setXpos(int xpos) {
        this.xpos = xpos;
    }
    /**      
     * Devuelve la posicion en y
     * @return posicion en y del nodo
     */
    public int getYpos() {
        return ypos;
    }
    /**
     * Asigna la posicion en y 
     * @param ypos posicion en x del nodo
     */
    public void setYpos(int ypos) {
        this.ypos = ypos;
    }
    /**
     * Devuelve el ID del padre
     * @return ID del padre
     */
    public int getFatherNodeID() {
        return fatherNodeID;
    }
    /**
     * Asigna el ID del padre
     * @param fatherNodeID ID del padre
     */
    public void setFatherNodeID(int fatherNodeID) {
        this.fatherNodeID = fatherNodeID;
    }
    
    /**
     * Devuelve el valor string del padre
     * @return Valor del padre (Pregunta)
     */
    public String getFatherQuestOrAns() {
        return fatherQuestOrAns;
    }
    /**
     * Asigna el valor string del padre
     * @param fatherQuestOrAns  Valor del padre (Pregunta)
     */
    public void setFatherQuestOrAns(String fatherQuestOrAns) {
        this.fatherQuestOrAns = fatherQuestOrAns;
    }
    
    /**
     * Devuelve el siguiente nodo
     * @return Nodo siguiente
     */
    public BinNode getNext() {
        return next;
    }

    /**
     * Asigna el siguiente nodo
     * @param next  Nodo siguiente
     */
    public void setNext(BinNode next) {
        this.next = next;
    }

    
    /**
     * Devuelve el ID del nodo
     * @return ID
     */
    public int getNodeID() {
        return nodeID;
    }
    /**
     * Asigna ID al nodo
     * @param nodeID ID
     */
    public void setNodeID(int nodeID) {
        this.nodeID = nodeID;
    }
/**
 * Devuelve el valor String del nodo
 * @return String del nodo
 */
    public String getQuestOrAns() {
        return questOrAns;
    }
    /**
     * Asigna la pregunta o respuesta del Nodo
     * @param questOrAns Pregunta o respuesta
     */
    public void setQuestOrAns(String questOrAns) {
        this.questOrAns = questOrAns;
    }
    /**
     * Devuelve el nodo que corresponde al si
     * @return Nodo "SI"
     */
    public BinNode getYesBranch() {
        return yesBranch;
    }
 /**
     * Asigna el nodo que corresponde al si
     * @param yesBranch "SI"
     */
    public void setYesBranch(BinNode yesBranch) {
        this.yesBranch = yesBranch;
    }
 /**
     * Devuelve el nodo que corresponde al NO
     * @return Nodo "NO"
     */
    public BinNode getNoBranch() {
        return noBranch;
    }
 /**
     * Asigna el nodo que corresponde al no
     * @param noBranch Nodo "NO"
     */
    public void setNoBranch(BinNode noBranch) {
        this.noBranch = noBranch;
    }

}
