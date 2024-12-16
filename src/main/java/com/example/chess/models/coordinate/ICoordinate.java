package com.example.chess.models.coordinate;

public interface ICoordinate {

    /**
     * Obtiene la columna de la coordenad@a en formato algebraico (e.g., 'b' de 'b3').
     * @return la columna en formato algebraico como Character.
     */
    Character getColumn();

    /**
     * Obtiene la fila de la coordenada en formato algebraico (e.g., '3' de 'b3').
     * @return la fila en formato algebraico como Integer.
     */
    Integer getRow();

    /**
     * Convierte la columna de la coordenada a índice de matriz (0-7).
     * @return el índice de columna como Integer.
     */
    Integer getColumnIndex();

    /**
     * Convierte la fila de la coordenada a índice de matriz (0-7).
     * @return el índice de fila como Integer.
     */
    Integer getRowIndex();

    /**
     * Verifica si la coordenada es válida dentro de los límites del tablero.
     * @return true si la coordenada es válida, de lo contrario false.
     */
    boolean isValid();
}
