/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.arboledecision;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author isa
 */
class DecisionTree {


    private static BufferedReader keyboardInput = new BufferedReader(new InputStreamReader(System.in));
    private BinNode rootNode = null;
    private String animal = "";
    private boolean animalFinded = false;
    private int totalnodes = 0; //keeps track of the inorder number for horiz. scaling 
    private int maxheight=0;
    private String inputString= new String();


    public DecisionTree() {
    }

    public static BufferedReader getKeyboardInput() {
        return keyboardInput;
    }

    public static void setKeyboardInput(BufferedReader keyboardInput) {
        DecisionTree.keyboardInput = keyboardInput;
    }

    public BinNode getRootNode() {
        return rootNode;
    }

    public void setRootNode(BinNode rootNode) {
        this.rootNode = rootNode;
    }

    public String getAnimal() {
        return animal;
    }

    public void setAnimal(String animal) {
        this.animal = animal;
    }

    public boolean isAnimalFinded() {
        return animalFinded;
    }

    public void setAnimalFinded(boolean animalFinded) {
        this.animalFinded = animalFinded;
    }

    public int getTotalnodes() {
        return totalnodes;
    }

    public void setTotalnodes(int totalnodes) {
        this.totalnodes = totalnodes;
    }

    public int getMaxheight() {
        return maxheight;
    }

    public void setMaxheight(int maxheight) {
        this.maxheight = maxheight;
    }

    public String getInputString() {
        return inputString;
    }

    public void setInputString(String inputString) {
        this.inputString = inputString;
    }


    public void createRoot(int newNodeID, String newQuestAns) {
        rootNode = new BinNode(newNodeID, newQuestAns);
        System.out.println("Creanto nodo raíz " + newNodeID);
    }

    /* ADD YES NODE */
    public void addYesNode(int existingNodeID, int newNodeID, String newQuestAns) {
        // If no root node do nothing

        if (rootNode == null) {
            System.out.println("ERROR: No hay nodo raíz! ");
            return;
        }

        // Search tree
        if (searchTreeAndAddYesNode(rootNode, existingNodeID, newNodeID, newQuestAns)) {
            System.out.println("Añadiendo nodo " + newNodeID
                    + " en la rama \"yes\" del nodo " + existingNodeID);
        } else {
            System.out.println("Nodo " + existingNodeID + " no encontrado");
        }
    }

    /* SEARCH TREE AND ADD YES NODE */
    private boolean searchTreeAndAddYesNode(BinNode currentNode,
            int existingNodeID, int newNodeID, String newQuestAns) {
        if (currentNode.getNodeID() == existingNodeID) {
            // Found node
            if (currentNode.getYesBranch() == null) {
                currentNode.setYesBranch(new BinNode(newNodeID, newQuestAns));
            } else {
                System.out.println("WARNING: Sobrescribiendo nodo previo "
                        + "(id = " + currentNode.getYesBranch().getNodeID()
                        + ") vinculado a la rama si del nodo "
                        + existingNodeID);
                currentNode.setYesBranch(new BinNode(newNodeID, newQuestAns));
            }
            return (true);
        } else {
            // Try yes branch if it exists
            if (currentNode.getYesBranch() != null) {
                if (searchTreeAndAddYesNode(currentNode.getYesBranch(),
                        existingNodeID, newNodeID, newQuestAns)) {
                    return (true);
                } else {
                    // Try no branch if it exists
                    if (currentNode.getNoBranch() != null) {
                        return (searchTreeAndAddYesNode(currentNode.getNoBranch(),
                                existingNodeID, newNodeID, newQuestAns));
                    } else {
                        return (false);	// Not found here
                    }
                }
            }
            return (false);		// Not found here
        }
    }

    /* ADD NO NODE */
    public void addNoNode(int existingNodeID, int newNodeID, String newQuestAns) {
        // If no root node do nothing

        if (rootNode == null) {
            System.out.println("ERROR: No hay nodo raíz! ");
            return;
        }

        // Search tree
        if (searchTreeAndAddNoNode(rootNode, existingNodeID, newNodeID, newQuestAns)) {
            System.out.println("Añadiendo nodo " + newNodeID
                    + " a la rama \"no\" del nodo " + existingNodeID);
        } else {
            System.out.println("Nodo " + existingNodeID + " no encontrado");
        }
    }

    /* SEARCH TREE AND ADD NO NODE */
    private boolean searchTreeAndAddNoNode(BinNode currentNode,
            int existingNodeID, int newNodeID, String newQuestAns) {
        if (currentNode.getNodeID() == existingNodeID) {
            // Found node
            if (currentNode.getNoBranch() == null) {
                currentNode.setNoBranch(new BinNode(newNodeID, newQuestAns));
            } else {
                System.out.println("WARNING: Sobrescribiendo nodo previo de "
                        + "(id = " + currentNode.getNoBranch().getNodeID()
                        + ") linked to yes branch of node "
                        + existingNodeID);
                currentNode.setNoBranch(new BinNode(newNodeID, newQuestAns));
            }
            return (true);
        } else {
            // Try yes branch if it exists
            if (currentNode.getYesBranch() != null) {
                if (searchTreeAndAddNoNode(currentNode.getYesBranch(),
                        existingNodeID, newNodeID, newQuestAns)) {
                    return (true);
                } else {
                    // Try no branch if it exists
                    if (currentNode.getNoBranch() != null) {
                        return (searchTreeAndAddNoNode(currentNode.getNoBranch(),
                                existingNodeID, newNodeID, newQuestAns));
                    } else {
                        return (false);	// Not found here
                    }
                }
            } else {
                return (false);	// Not found here
            }
        }
    }


    public void queryBinTree() throws IOException {
        queryBinTree(rootNode);
    }

    private void queryBinTree(BinNode currentNode) throws IOException {

        // Test for leaf node (answer) and missing branches
        if (currentNode.getYesBranch() == null) {
            if (currentNode.getNoBranch() == null) {
                String[] options = {"Si", "No"};
                int result = JOptionPane.showOptionDialog(
                        null,
                        "¿" + currentNode.getQuestOrAns() + "?",
                        "Es un",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null, //no custom icon
                        options, //button titles
                        options[0] //default button
                );
                System.out.println("¿" + currentNode.getQuestOrAns() + "? ( \"Si\" o \"No\")");
                String answer = result == 0 ? "Si" : "No"; //keyboardInput.readLine();
                if (answer.equalsIgnoreCase("Si")) {
                    animal = currentNode.getQuestOrAns();
                    animalFinded = true;
                } else if (answer.equalsIgnoreCase("No")) {
                    System.out.println("¿En qué animal estabas pensando?");
                    String newAnimal = JOptionPane.showInputDialog("¿En qué animal estabas pensando?");//keyboardInput.readLine();
                    if(newAnimal == null){System.exit(1);}
                    System.out.println("¿Qué diferencia a un " + newAnimal + " de un " + currentNode.getQuestOrAns() + "?");
                    String characteristic = JOptionPane.showInputDialog("¿Qué diferencia a un " + newAnimal + " de un " + currentNode.getQuestOrAns() + "?");//keyboardInput.readLine();
                   if(characteristic == null){System.exit(1);}
                    System.out.println("¿Si el animal fuese un " + newAnimal + " cuál sería la respuesta a la pregunta?");
                    String newAnswer = JOptionPane.showInputDialog("¿Si el animal fuese un " + newAnimal + " cuál sería la respuesta a la pregunta?");//keyboardInput.readLine();
                    if(newAnswer == null){System.exit(1);}
                    
                    StringBuilder sb = new StringBuilder();

                    try ( BufferedReader br = new BufferedReader(new FileReader("animal.csv"))) {
                        String line;

                        while ((line = br.readLine()) != null) {
                            System.out.println("line " + line);
                            System.out.println("line.contains(currentNode.getQuestOrAns()) " + line.contains(currentNode.getQuestOrAns()));
                            if (line.contains(currentNode.getQuestOrAns())) {
                                System.out.println("line.replace(currentNode.getQuestOrAns(), characteristic)");
                                line = line.replace(currentNode.getQuestOrAns(), characteristic);
                                System.out.println("NEW line " + line);
                            }
                            sb.append(line + "\n");
                        }
                    }

                    try ( PrintWriter writer = new PrintWriter(new File("animal.csv"))) {

                        sb.append(characteristic);
                        sb.append(", ");
                        if (newAnswer.equalsIgnoreCase("Si")) {
                            sb.append(currentNode.getQuestOrAns());
                            sb.append(", ");
                            sb.append(newAnimal);
                        } else {
                            sb.append(newAnimal);
                            sb.append(", ");
                            sb.append(currentNode.getQuestOrAns());
                        }

                        writer.write(sb.toString());
                        writer.close();

                    } catch (FileNotFoundException e) {
                        System.out.println(e.getMessage());
                    }

                } else {
                    System.out.println("Error: Falta la rama \"Si\" en la pregunta \""
                            + currentNode.getQuestOrAns() + "\" ");
                }
            } else {
                System.out.println("Error: Falta la rama \"Si\" en la pregunta \""
                        + currentNode.getQuestOrAns() + "\" ");
            }
            return;
        }
        if (currentNode.getNoBranch() == null) {
            System.out.println("Error: Falta la rama \"No\" en la pregunta \""
                    + currentNode.getQuestOrAns() + "\" ");
            return;
        }

        // Question
        askQuestion(currentNode);
    }
    
    private void getComponents(Container c){

    Component[] m = c.getComponents();

    for(int i = 0; i < m.length; i++){

        if(m[i].getClass().getName() == "javax.swing.JPanel")
            m[i].setBackground(Color.white);

        if(c.getClass().isInstance(m[i]));
            getComponents((Container)m[i]);
    }
}

    private void askQuestion(BinNode currentNode) throws IOException {
        String[] options = {"Si", "No"};

        int result = JOptionPane.showOptionDialog(
                null,
                "¿" + currentNode.getQuestOrAns() + "?",
                "Estoy adivinando",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null, //no custom icon
                options, //button titles
                options[0] //default button
        );
        System.out.println("result "+result);
        System.out.println("¿" + currentNode.getQuestOrAns() + "? ( \"Si\" o \"No\")");
        String answer = result == 0 ? "Si" : "No"; //keyboardInput.readLine();
        if (answer.equalsIgnoreCase("Si")) {
            queryBinTree(currentNode.getYesBranch());
        } else {
            if (answer.equalsIgnoreCase("No")) {
                queryBinTree(currentNode.getNoBranch());
            } else {
                System.out.println("ERROR: Debe responder \"Yes\" o \"No\"");
                askQuestion(currentNode);
            }
        }
    }



 /* OUTPUT BIN TREE */
    public void outputBinTree() {

        outputBinTree("1", rootNode);
    }

    private void outputBinTree(String tag, BinNode currentNode) {

        // Check for empty node
        if (currentNode == null) {
            return;
        }

        // Output
        System.out.println("[" + tag + "] nodeID = " + currentNode.getNodeID()
                + ", pregunta/respuesta = " + currentNode.getQuestOrAns());

        // Go down yes branch
        outputBinTree(tag + ".1", currentNode.getYesBranch());

        // Go down no branch
        outputBinTree(tag + ".2", currentNode.getNoBranch());
    }
    
    public int treeHeight(BinNode t){
	if(t==null) return -1;
          else return 1 + max(treeHeight(t.getNoBranch()),treeHeight(t.getYesBranch()));
    }
    public int max(int a, int b){
	  if(a>b) return a; else return b;
    }

    public void computeNodePositions() {
      int depth = 1;
      inorder_traversal(rootNode, depth);
    }

//traverses tree and computes x,y position of each node, stores it in the node

    public void inorder_traversal(BinNode t, int depth) { 
      if (t != null) {
        inorder_traversal(t.getNoBranch(), depth + 1); //add 1 to depth (y coordinate) 
        t.setXpos(totalnodes++) ; //x coord is node number in inorder traversal
        t.setYpos(depth); // mark y coord as depth
        inorder_traversal(t.getYesBranch(), depth + 1);
      }
}
}
