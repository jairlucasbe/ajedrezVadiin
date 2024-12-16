package com.example.chess.models.board;

import com.example.chess.models.pieces.*;
import org.springframework.stereotype.Component;
import com.example.chess.models.coordinate.Coordinate;

@Component
public class Board {
    private IPiece[][] grid; // Tablero de 8x8 con las piezas

    public Board() {
        this.grid = new IPiece[8][8];
        initializeBoard();
    }

    public IPiece getPieceAt(int row, int col) {
        return grid[row][col];
    }

    public void setPieceAt(int row, int col, IPiece piece) {
        grid[row][col] = piece;
    }

    public void initializeBoard() {
        // Colocando los peones
        for (int col = 0; col < 8; col++) {
            grid[1][col] = new Pawn(new Coordinate((char) ('a' + col), 2)); // Peones blancos en fila 2
            grid[1][col].setColor(EnumColorNames.WHITE);
            grid[6][col] = new Pawn(new Coordinate((char) ('a' + col), 7)); // Peones negros en fila 7
            grid[6][col].setColor(EnumColorNames.BLACK);
        }
        
        // Colocando las piezas mayores
        initializeMajorPieces(0, EnumColorNames.WHITE); // Piezas blancas en fila 1
        initializeMajorPieces(7, EnumColorNames.BLACK); // Piezas negras en fila 8
    }

    private void initializeMajorPieces(int row, EnumColorNames color) {
        // Piezas mayores en la fila especificada
        grid[row][0] = new Rook(new Coordinate('a', row == 0 ? 1 : 8)); // Torre
        grid[row][1] = new Knight(new Coordinate('b', row == 0 ? 1 : 8)); // Caballo
        grid[row][2] = new Bishop(new Coordinate('c', row == 0 ? 1 : 8)); // Alfil
        grid[row][3] = new Queen(new Coordinate('d', row == 0 ? 1 : 8)); // Reina
        grid[row][4] = new King(new Coordinate('e', row == 0 ? 1 : 8)); // Rey
        grid[row][5] = new Bishop(new Coordinate('f', row == 0 ? 1 : 8)); // Alfil
        grid[row][6] = new Knight(new Coordinate('g', row == 0 ? 1 : 8)); // Caballo
        grid[row][7] = new Rook(new Coordinate('h', row == 0 ? 1 : 8)); // Torre

        // Establecer el color de todas las piezas en la fila
        for (int col = 0; col < 8; col++) {
            grid[row][col].setColor(color);
        }
    }
}
