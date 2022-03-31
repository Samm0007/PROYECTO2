/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.arboledecision;

/**
 *Clase para generar un hashtable
 * @author isa
 */
public class HashTable {
    
    
    BinNode tabla[];
    int tamanno_tabla;
    
    /**
     * Constructor de hash table
     * @param tamaño tamanio del table
     */
    public HashTable(int tamaño) {
    this.tamanno_tabla = tamaño;
    this.tabla = new BinNode[tamanno_tabla];
    
    for (int i = 0; i < tamanno_tabla; i++) {
        this.tabla[i] = null;
        }
    }
    /**
     * Crear hash de la tabla
     * @param llave llave para el hash
     * @return hash
     */
    public int hashing (String llave){
        int valor = 0;
        int posicion = 1;
        for (int i = 0; i < llave.length(); i++){
            if (llave.codePointAt(i) == 32){
                valor += 0;
            } else if (llave.codePointAt(i) >= 48 && llave.codePointAt(i) <= 57){
                valor += ((llave.codePointAt(i) - 47)*posicion);
            } else if (llave.codePointAt(i) >= 65 && llave.codePointAt(i) <= 90){
                valor += ((llave.codePointAt(i) - 54)*posicion);
            }else if (llave.codePointAt(i) >= 97 && llave.codePointAt(i) <= 122){
                valor += ((llave.codePointAt(i) - 60)*posicion);
            }
            
            posicion++;
        } return (valor % tamanno_tabla);
    }
    /**
     * Insertar en la tabla hash
     * @param nombre string del valor del nodo
     * @return posicion dentrod e la tabla
     */
    public int insertar(String nombre){
        int posicion = hashing(nombre);
        boolean existe = false;
        if (this.tabla[posicion] != null){
            BinNode temp = this.tabla[posicion];
            if (temp.getQuestOrAns().equals(nombre)){
                existe = true;
            }
            while (temp.getNext() != null){
                temp = temp.getNext();
                if (temp.getQuestOrAns().equals(nombre)){
                    existe = true;
                }
            }
            if (!existe){
                BinNode nuevo2 = new BinNode(posicion, nombre);
                temp.setNext(nuevo2);
            }
        } else{
            BinNode nuevo2 = new BinNode(posicion, nombre);
            this.tabla[posicion] = nuevo2;
        }
        
        return posicion;
    }
    
    /**
     * Busca el nodo correspondiente al String
     * @param nombre String del nodo
     * @return Nodo si este existe
     */
    public BinNode buscar(String nombre){
        int posicion = hashing(nombre);
        BinNode temp = this.tabla[posicion];
        boolean existe = false;
        if (temp != null){
            if (temp.getNext()== null){
                existe = true;
            }else{
                while (temp.getNext() != null && !existe){
                    if (temp.getQuestOrAns().equals(nombre)){
                        existe = true;
                    }else{
                        temp = temp.getNext();
                    }
                }
            }
        }
        if (existe){
            return temp;
        }else{
            return null;
        }
    }
    /**
     * Vacia la tabla hash
     */
    public void vaciado(){
        for (int i = 0; i < tamanno_tabla; i++){
            this.tabla[i] = null;
        }
    }
    /**
     * Imprime la tabla hash
     */
    public void imprimir(){
        for (int i = 0; i < tamanno_tabla; i++){
            if(this.tabla[i] != null){
                BinNode temp = this.tabla[i];
                System.out.println("Id "+temp.getNodeID()+" content "+temp.getQuestOrAns());
            }
        }
    }
    
}
