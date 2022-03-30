/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.arboledecision;

/**
 *
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

    /* CONSTRUCTOR */
    public BinNode(int newNodeID, String newQuestAns) {
        nodeID = newNodeID;
        questOrAns = newQuestAns;
    }

    public int getXpos() {
        return xpos;
    }

    public void setXpos(int xpos) {
        this.xpos = xpos;
    }

    public int getYpos() {
        return ypos;
    }

    public void setYpos(int ypos) {
        this.ypos = ypos;
    }

    public int getFatherNodeID() {
        return fatherNodeID;
    }

    public void setFatherNodeID(int fatherNodeID) {
        this.fatherNodeID = fatherNodeID;
    }

    public String getFatherQuestOrAns() {
        return fatherQuestOrAns;
    }

    public void setFatherQuestOrAns(String fatherQuestOrAns) {
        this.fatherQuestOrAns = fatherQuestOrAns;
    }

    public BinNode getNext() {
        return next;
    }

    public void setNext(BinNode next) {
        this.next = next;
    }

    
    
    public int getNodeID() {
        return nodeID;
    }

    public void setNodeID(int nodeID) {
        this.nodeID = nodeID;
    }

    public String getQuestOrAns() {
        return questOrAns;
    }

    public void setQuestOrAns(String questOrAns) {
        this.questOrAns = questOrAns;
    }

    public BinNode getYesBranch() {
        return yesBranch;
    }

    public void setYesBranch(BinNode yesBranch) {
        this.yesBranch = yesBranch;
    }

    public BinNode getNoBranch() {
        return noBranch;
    }

    public void setNoBranch(BinNode noBranch) {
        this.noBranch = noBranch;
    }

}
