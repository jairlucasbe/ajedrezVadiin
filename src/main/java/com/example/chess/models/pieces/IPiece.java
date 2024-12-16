package com.example.chess.models.pieces;

import com.example.chess.models.coordinate.Coordinate;

public interface IPiece {

    /**
     * Obtiene el nombre de la pieza.
     * @return el nombre de la pieza (por ejemplo, "pawn" o "rock").
     */
    EnumPieceNames getName();
    
    /**
     * Obtiene el color de la pieza.
     * @return el color de la pieza (por ejemplo, "blanco" o "negro").
     */
    EnumColorNames getColor();

    Coordinate getCoordinate();

    /**
     * Establece el color de la pieza.
     */
    void setColor(EnumColorNames color);

    /**
     * Mueve la pieza de una posición a otra.
     * @param start la posición de inicio.
     * @param end la posición de destino.
     */
    boolean move(Coordinate coordinate);

    /**
     * Genera una representación textual de la pieza, útil para depuración.
     * @return una cadena que representa la pieza.
     */
    String toString();
}
