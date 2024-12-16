package com.example.chess.models.pieces;

import com.example.chess.models.coordinate.Coordinate;

public class Queen extends AbstractPiece {

    public Queen(Coordinate coordinate) {
        super(EnumPieceNames.QUEEN, coordinate);
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
        boolean sameRow = currentRow == targetRow;
        boolean sameColumn = currentColumnIndex == targetColumnIndex;
        boolean sameDiagonal = rowDifference == columnDifference;
        if (sameRow || sameColumn || sameDiagonal) {
            this.setCoordinate(targetCoordinate);
            return true;
        }
        return false;
    }
}
