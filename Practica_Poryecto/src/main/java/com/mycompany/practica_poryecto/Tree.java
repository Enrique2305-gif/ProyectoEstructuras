/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica_poryecto;

/**
 *
 * @author CltControl
 */
public class Tree {
    private Nodo_Tablero raiz ;

    public Tree() {
        this.raiz = null;
    }

    public Tree(Tablero tableroInicial) {
        this.raiz = new Nodo_Tablero(tableroInicial);
    }
    public Nodo_Tablero getRaiz() {
        return raiz;
    }
    
    
    
     public void imprimirArbol() {
        imprimirArbolRecursivo(raiz, 0);
    }

    private void imprimirArbolRecursivo(Nodo_Tablero nodo, int nivel) {
        // Imprimir el tablero del nodo actual
        System.out.println("Nivel " + nivel + ":");
        nodo.getContent().mostrar();
        System.out.println("---");

        // Recursivamente imprimir los hijos (subárboles)
        for (Tree hijo : nodo.getHijos()) {
            imprimirArbolRecursivo(hijo.getRaiz(), nivel + 1);
        }
    }
    
    
}
