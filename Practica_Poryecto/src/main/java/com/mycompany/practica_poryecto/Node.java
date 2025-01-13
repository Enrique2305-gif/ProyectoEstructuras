/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica_poryecto;

import java.util.LinkedList;

/**
 *
 * @author 
 */

import java.util.LinkedList;
import java.util.List;

public class Node {
    private TotalBoard board;  // Estado del tablero
    private TresPiece turn;     // Turno del jugador
    private LinkedList<Node> children = new LinkedList<>();  // Hijos del nodo (posibles movimientos)
    private Integer moveIndex;  // Índice del movimiento realizado

    // Constructor
    public Node(TotalBoard board, TresPiece turn, Integer moveIndex) {
        this.board = board;
        this.turn = turn;
        this.moveIndex = moveIndex;
    }

    public TotalBoard getBoard() {
        return board;
    }

    public TresPiece getTurn() {
        return turn;
    }

    public Integer getMoveIndex() {
        return moveIndex;
    }

    public LinkedList<Node> getChildren() {
        return children;
    }

    // Genera todos los posibles estados del tablero para el jugador dado
    public LinkedList<Node> generatePossibleStates() {
        LinkedList<Node> possibleStates = new LinkedList<>();
        List<Integer> legalMoves = board.getLegalMoves();

        for (Integer move : legalMoves) {
            TotalBoard newBoard = (TotalBoard) board.move(move);  // Crear un nuevo tablero con el movimiento
            Node newNode = new Node(newBoard, turn.opposite(), move);  // Crear un nuevo nodo con el nuevo estado y el índice de movimiento
            possibleStates.add(newNode);
        }
        return possibleStates;
    }
}
