/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica_poryecto;

/**
 *
 * @author 
 */
public class TotalBoard {
    private TresPiece[][] board; // Representación del tablero
    private TresPiece turn; // Turno del jugador actual

    public TotalBoard() {
        board = new TresPiece[3][3]; // Inicializa el tablero vacío
        turn = TresPiece.X; // Comienza con el jugador X
    }

    public List<Integer> getLegalMoves() {
        List<Integer> legalMoves = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == null) {
                    legalMoves.add(i * 3 + j); // Agrega el índice de la casilla vacía
                }
            }
        }
        return legalMoves;
    }

    public TotalBoard move(Integer index) {
        int row = index / 3;
        int col = index % 3;
        if (board[row][col] == null) {
            TotalBoard newBoard = new TotalBoard();
            newBoard.board = this.copyBoard();// Copia el estado actual del tablero
            newBoard.board[row][col] = turn; // Realiza el movimiento
            newBoard.turn = turn.opposite(); // Cambia el turno
        
            return newBoard;
        }
        return null; // Movimiento no válido
    }

    private TresPiece[][] copyBoard() {
        TresPiece[][] newBoard = new TresPiece[3][3];
        for (int i = 0; i < 3; i++) {
            System.arraycopy(this.board[i], 0, newBoard[i], 0, 3);
        }
        return newBoard;
    }

    public boolean isWin() {
        // Lógica para verificar si hay un ganador
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != null && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                return true; // Ganó en fila
            }
            if (board[0][i] != null && board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
                return true; // Ganó en columna
            }
        }
        if (board[0][0] != null && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            return true; // Ganó en diagonal
        }
        if (board[0][2] != null && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            return true; // Ganó en diagonal inversa
        }
        return false; // No hay ganador
    }

    public boolean isDraw() {
        // Verifica si el tablero está lleno y no hay ganador
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == null) {
                    return false; // Hay al menos una casilla vacía
                }
            }
        }
        return !isWin(); // Es empate si no hay ganador
    }

    public TresPiece getWinner() {
    // Devuelve el ganador si hay uno
    for (int i = 0; i < 3; i++) {
        // Verificar filas
        if (board[i][0] != null && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
            return board[i][0]; // Ganador en fila
        }
        // Verificar columnas
        if (board[0][i] != null && board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
            return board[0][i]; // Ganador en columna
        }
    }
    // Verificar diagonal principal
    if (board[0][0] != null && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
        return board[0][0]; // Ganador en diagonal
    }
    // Verificar diagonal secundaria
    if (board[0][2] != null && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
        return board[0][2]; // Ganador en diagonal inversa
    }
    return null; // No hay ganador
    
          }

    public TresPiece getTurn() {
        return turn;
    }

    public TresPiece getPiece(int row, int col) {
        return board[row][col];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                sb.append(board[i][j] == null ? " " : board[i][j].toString());
                if (j < 2) sb.append(" | "); // Separador de columnas
            }
            sb.append("\n");
            if (i < 2) sb.append("---------\n"); // Separador de fila
        }
        return sb.toString();
    }
}
