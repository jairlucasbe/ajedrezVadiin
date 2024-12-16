package com.example.chess.models.pieces;

public enum EnumPieceNames {
    KING("Rey"),
    QUEEN("Reina"),
    ROOK("Torre"),
    BISHOP("Alfil"),
    KNIGHT("Caballo"),
    PAWN("Peón");

    private final String name;

    EnumPieceNames(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
