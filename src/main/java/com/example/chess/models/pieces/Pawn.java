package com.example.chess.models.pieces;

import com.example.chess.models.coordinate.Coordinate;

public class Pawn extends AbstractPiece {

    public Pawn(Coordinate coordinate) {
        super(PieceNames.PAWN, coordinate);  // Llamada al constructor de la clase base (AbstractPiece)
    }

    @Override
    public boolean move(Coordinate endCoordinate) {
        int rowDifference = Math.abs(this.getCoordinate().getRow() - endCoordinate.getRow());
        int colDifference = Math.abs(this.getCoordinate().getColumn() - endCoordinate.getColumn());

        if (rowDifference == 1 && colDifference == 0) {
            return true;
        }
        
        if (rowDifference == 2 && colDifference == 0 && this.getCoordinate().getRow() == 2) {
            return true;
        }

        if (rowDifference == 1 && colDifference == 1) {
            return true;
        }

        return false;
    }

    @Override
    public EnumColorNames getColor() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getColor'");
    }

    @Override
    public boolean canMove(Coordinate start, Coordinate end) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'canMove'");
    }

    @Override
    public void move(Coordinate start, Coordinate end) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'move'");
    }
}
