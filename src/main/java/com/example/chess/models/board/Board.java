package com.example.chess.models.board;

public class Board {
    private Piece[][] grid; // Tablero de 8x8 con las piezas

    public Board() {
        this.grid = new Piece[8][8];
        initializeBoard();
    }

    public Piece getPieceAt(int row, int col) {
        return grid[row][col];
    }

    public void setPieceAt(int row, int col, Piece piece) {
        grid[row][col] = piece;
    }

    public void initializeBoard() {
        // Inicializa las piezas en sus posiciones iniciales
        // Ejemplo: grid[0][0] = new Rook("White");
    }
}
