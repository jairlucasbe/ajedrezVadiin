package com.example.chess.models.pieces;

import com.example.chess.models.coordinate.Coordinate;

public class Knight extends AbstractPiece {

    public Knight(Coordinate coordinate) {
        super(EnumPieceNames.KNIGHT, coordinate);
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
        int rowDifference = Math.abs(targetRow - currentRow);
        int columnDifference = Math.abs(targetColumnIndex - currentColumnIndex);

        if ((rowDifference == 2 && columnDifference == 1) || (rowDifference == 1 && columnDifference == 2)) {
            this.setCoordinate(targetCoordinate);
            return true;
        }

        return false;
    }
}   