package com.example.chess.models.pieces;

import com.example.chess.models.coordinate.Coordinate;

public class Rook extends AbstractPiece {

    public Rook(Coordinate coordinate) {
        super(EnumPieceNames.ROOK, coordinate);
    }

    @Override
    public boolean move(Coordinate targetCoordinate) {
        if (!targetCoordinate.isValid()) {
            return false;
        }
        Coordinate currentCoordinate = this.getCoordinate();
        int currentRow = currentCoordinate.getRow();
        int currentColumnIndex = currentCoordinate.getColumnIndex();
        int targetRow = targetCoordinate.getRow();
        int targetColumnIndex = targetCoordinate.getColumnIndex();
        boolean sameRow = currentRow == targetRow;
        boolean sameColumn = currentColumnIndex == targetColumnIndex;
        if (sameRow || sameColumn) {
            this.setCoordinate(targetCoordinate);
            return true;
        }
        return false;
    }
}