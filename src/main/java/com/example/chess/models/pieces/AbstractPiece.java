package com.example.chess.models.pieces;

import com.example.chess.models.coordinate.Coordinate;

public abstract class AbstractPiece implements IPiece {

    private EnumPieceNames name;
    private Coordinate coordinate;
    private EnumColorNames color;
    
    public AbstractPiece(EnumPieceNames name, Coordinate coordinate) {
        this.name = name;
        this.coordinate = coordinate;
    }

    public EnumPieceNames getName() {
        return name;
    }

    public void setName(EnumPieceNames name) {
        this.name = name;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public abstract boolean move(Coordinate coordinate);
}
