/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica_poryecto;

/**
 *
 * @author CltControl
 */
public class Tablero {
    private char[][] tablero;
    private char turno;

    // Constructor para inicializar el tablero vacío
    public Tablero() {
        tablero = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tablero[i][j] = ' '; // Inicializamos con espacios vacíos
            }
        }
        turno = 'X'; // Empieza el jugador X
    }

    // Método para mostrar el tablero
    public void mostrar() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(tablero[i][j]);
                if (j < 2) System.out.print(" | ");
            }
            System.out.println();
            if (i < 2) System.out.println("---------");
        }
    }
    
    public boolean esEmpate() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tablero[i][j] == ' ') {
                    return false; // Hay una casilla vacía, por lo que no es empate
                }
            }
        }
        return true; // No hay casillas vacías, es empate
    }
    
    public boolean verificarGanador() {
        // Comprobamos las filas
        for (int i = 0; i < 3; i++) {
            if (tablero[i][0] != ' ' && tablero[i][0] == tablero[i][1] && tablero[i][1] == tablero[i][2]) {
                return true;
            }
        }    
        // Comprobamos las columnas
        for (int j = 0; j < 3; j++) {
            if (tablero[0][j] != ' ' && tablero[0][j] == tablero[1][j] && tablero[1][j] == tablero[2][j]) {
                return true;
            }
        }
        // Comprobamos las diagonales
        if (tablero[0][0] != ' ' && tablero[0][0] == tablero[1][1] && tablero[1][1] == tablero[2][2]) {
            return true;
        }
        if (tablero[0][2] != ' ' && tablero[0][2] == tablero[1][1] && tablero[1][1] == tablero[2][0]) {
            return true;
        }
        return false; // Si no hay ganador
    }
    
    // Getter y setter para el tablero y turno
    public char getCasilla(int fila, int columna) {
        return tablero[fila][columna];
    }

    public void setCasilla(int fila, int columna, char simbolo) {
        tablero[fila][columna] = simbolo;
    }
    public char getTurno() {
        return turno;
    }
    public void cambiarTurno() {
        // Si el turno actual es 'X', lo cambiamos a 'O', y viceversa
        if (turno == 'X') {
            turno = 'O'; // Cambiar el turno a 'O'
        } else {
            turno = 'X'; // Cambiar el turno a 'X'
        }
    }
    
    
    
    
    
}
