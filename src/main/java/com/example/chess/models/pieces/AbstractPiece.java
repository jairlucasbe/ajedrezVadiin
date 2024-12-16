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
        return this.name;
    }

    public void setName(EnumPieceNames name) {
        this.name = name;
    }

    public EnumColorNames getColor() {
        return this.color;
    }

    public void setColor(EnumColorNames color) {
        this.color = color;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public abstract boolean move(Coordinate coordinate);
}
