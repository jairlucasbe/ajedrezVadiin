package com.example.chess.models.pieces;

import com.example.chess.models.coordinate.Coordinate;

public class Pawn extends AbstractPiece {

    public Pawn(Coordinate coordinate) {
        super(EnumPieceNames.PAWN, coordinate); 
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
        int direction = this.getColor() == EnumColorNames.WHITE ? 1 : -1;
        if (currentColumnIndex == targetColumnIndex && targetRow == currentRow + direction) {
            this.setCoordinate(targetCoordinate);
            return true;
        }
        if (currentColumnIndex == targetColumnIndex &&
            (currentRow == 2 || currentRow == 7) &&
            targetRow == currentRow + 2 * direction) {
            this.setCoordinate(targetCoordinate);
            return true;
        }
        if (Math.abs(targetColumnIndex - currentColumnIndex) == 1 && targetRow == currentRow + direction) {
            this.setCoordinate(targetCoordinate);
            return true;
        }
        return false;
    }

}
