/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.practica_poryecto;

import TresEnRaya.Minimax;
import TresEnRaya.Node;
import TresEnRaya.TotalBoard;
import TresEnRaya.TresPiece;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author 
 */


public class practica_poryecto {
    private TotalBoard board; // Usar TotalBoard
    private Scanner sc = new Scanner(System.in);
    private TresPiece humanPlayer; // Jugador humano
    private TresPiece computerPlayer; // Jugador computadora

    public Proyecto() {
        // Inicializar el tablero
        board = new TotalBoard();
    }

    // Método para convertir el TotalBoard en un Node
    private Node convertBoardToNode(TotalBoard board) {
        return new Node(board, board.getTurn(), null);  // No es necesario pasar el moveIndex aquí
    }

    public void chooseSymbols() {
        String symbol;
        do {
            System.out.println("Elija su símbolo (X o O): ");
            symbol = sc.nextLine().toUpperCase();
            if (symbol.equals("X")) {
                humanPlayer = TresPiece.X;
                computerPlayer = TresPiece.O;
            } else if (symbol.equals("O")) {
                humanPlayer = TresPiece.O;
                computerPlayer = TresPiece.X;
            } else {
                System.out.println("Símbolo no válido. Por favor, elija 'X' o 'O'.");
            }
        } while (!symbol.equals("X") && !symbol.equals("O"));
    }

    public Integer getPlayerMove() {
        Integer move = null; // Cambiar a null para facilitar la validación
        while (move == null || !board.getLegalMoves().contains(move)) {
            System.out.println("Ingrese la casilla a jugar (0-8): ");
            try {
                move = sc.nextInt();  // Intenta leer un número
                if (move < 0 || move > 8) {
                    System.out.println("Por favor, ingrese un número entre 0 y 8.");
                    move = null; // Reiniciar move para que el bucle continúe
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada no válida. Por favor, ingrese un número.");
                sc.next(); // Limpiar el buffer del scanner
                move = null; // Reiniciar move para que el bucle continúe
            }
        }
        return move;
    }

    // Método para jugar el juego
    private void playTres() {
    chooseSymbols(); // Elegir símbolos

    // Movimiento inicial de la computadora
    System.out.println("La computadora comienza el juego...");
    Integer computerMove = Minimax.findBestMove(convertBoardToNode(board), 9); // Cambia el 9 por la profundidad deseada
    if (computerMove != null) {
        board = (TotalBoard) board.move(computerMove); // Realiza el movimiento de la computadora
        System.out.println("La computadora ha decidido: " + computerMove);
        System.out.println(board); // Muestra el tablero
    }

    while (true) {
        // Movimiento del jugador humano
        Integer humanMove = getPlayerMove();
        if (humanMove != null && board.getLegalMoves().contains(humanMove)) {
            board = (TotalBoard) board.move(humanMove); // Realiza el movimiento del jugador
            System.out.println(board); // Muestra el tablero
        }

        if (board.isWin()) {
            System.out.println("¡Felicitaciones, ganaste!");
            break;
        } else if (board.isDraw()) {
            System.out.println("Empate");
            break;
        }
        
        // Movimiento de la computadora
        computerMove = Minimax.findBestMove(convertBoardToNode(board), 9); // Cambia el 9 por la profundidad deseada
        if (computerMove != null) {
            board = (TotalBoard) board.move(computerMove); // Realiza el movimiento de la computadora
            System.out.println("La computadora ha decidido: " + computerMove);
            System.out.println(board); // Muestra el tablero
        }

        if (board.isWin()) {
            System.out.println("¡La computadora ha ganado!");
            break;
        } else if (board.isDraw()) {
            System.out.println("Empate");
            break;
        }
    }
}

    public static void main(String[] args) {
        Proyecto pr = new Proyecto();
        pr.playTres();
    }
}
