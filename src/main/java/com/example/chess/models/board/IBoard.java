package com.example.chess.models.board;

import com.example.chess.models.coordinate.Coordinate;
import com.example.chess.models.pieces.IPiece;

public interface IBoard {
    /**
     * Inicializa el tablero con las piezas en su estado inicial.
     */
    void initializeBoard();

    /**
     * Obtiene la pieza en una posición específica del tablero.
     *
     * @param coordinate la coordenada de la posición (e.g., "a3").
     * @return la pieza en la posición especificada o null si no hay ninguna.
     */
    IPiece getPieceAt(Coordinate coordinate);

    /**
     * Saca una pieza de una posición específica del tablero.
     *
     * @param coordinate la coordenada de la posición (e.g., "a3").
     * @return la pieza que estaba en la posición, o null si no había ninguna.
     */
    IPiece removePieceAt(Coordinate coordinate);

    /**
     * Coloca una pieza en una posición específica del tablero.
     *
     * @param coordinate la coordenada de la posición (e.g., "a3").
     * @param piece la pieza a colocar, o null para dejar la posición vacía.
     */
    void setPieceAt(Coordinate coordinate, IPiece piece);

    /**
     * Verifica si una posición está dentro de los límites del tablero.
     *
     * @param coordinate la coordenada de la posición (e.g., "a3").
     * @return true si la posición es válida, de lo contrario false.
     */
    boolean isPositionValid(Coordinate coordinate);

}
