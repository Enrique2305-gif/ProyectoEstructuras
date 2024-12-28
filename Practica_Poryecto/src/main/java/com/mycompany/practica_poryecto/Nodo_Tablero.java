/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica_poryecto;

import java.util.LinkedList;

/**
 *
 * @author CltControl
 */
public class Nodo_Tablero {
    private Tablero content;
    private LinkedList<Tree> hijos;
    
    public Nodo_Tablero() {
        this.content = null;
        this.hijos = null;
    }

    public Nodo_Tablero(Tablero content) {
        this.content = content;
        this.hijos = new LinkedList<>();
    }

    public Tablero getContent() {
        return content;
    }

    public LinkedList<Tree> getHijos() {
        return hijos;
    }
    
    private Tablero copiarTablero(Tablero original) {
        Tablero copia = new Tablero();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                copia.setCasilla(i, j, original.getCasilla(i, j));
            }
        }
        return copia;
    }
    
    public void agregarHijo(Tree hijo) {
        hijos.add(hijo);
    }
    
    public void generarPosiblesEstados() {
        char turnoActual = content.getTurno(); // Obtener el turno actual

        // Recorremos todas las casillas del tablero
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (content.getCasilla(i, j) == '-') { // Si la casilla está vacía
                    // Crear una copia del tablero actual
                    Tablero nuevoTablero = copiarTablero(content);
                    nuevoTablero.setCasilla(i, j, turnoActual); // Colocar el símbolo del jugador
                    nuevoTablero.cambiarTurno(); // Cambiar el turno para el siguiente jugador

                    // Crear un nuevo subárbol para el nuevo tablero
                    Tree nuevoArbol = new Tree(nuevoTablero);
                    this.agregarHijo(nuevoArbol); // Añadir el subárbol como hijo
                }
            }
        }
    }
    
}
