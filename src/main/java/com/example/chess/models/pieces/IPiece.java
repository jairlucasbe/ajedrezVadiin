package com.example.chess.models.pieces;

import com.example.chess.models.coordinate.Coordinate;

public interface IPiece {

    /**
     * Obtiene el nombre de la pieza.
     * 
     * @return el nombre de la pieza (por ejemplo, "pawn" o "rock").
     */
    EnumPieceNames getName();
    
    /**
     * Obtiene el color de la pieza.
     * 
     * @return el color de la pieza (por ejemplo, "blanco" o "negro").
     */
    EnumColorNames getColor();

    /**
     * Verifica si la pieza puede moverse a una posición específica.
     * 
     * @param start la posición de inicio.
     * @param end la posición de destino.
     * @return true si el movimiento es válido, de lo contrario false.
     */
    boolean canMove(Coordinate start, Coordinate end);

    /**
     * Mueve la pieza de una posición a otra.
     * 
     * @param start la posición de inicio.
     * @param end la posición de destino.
     */
    void move(Coordinate start, Coordinate end);

    /**
     * Genera una representación textual de la pieza, útil para depuración.
     * 
     * @return una cadena que representa la pieza.
     */
    String toString();
}
