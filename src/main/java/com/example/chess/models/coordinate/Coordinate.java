package com.example.chess.models.coordinate;

public class Coordinate implements ICoordinate {

    private final Character column;
    private final Integer row;

    public Coordinate(Character column, Integer row) {
        if (!isValid(column, row)) {
            throw new IllegalArgumentException("Coordenada inválida: " + column + row);
        }
        this.column = column;
        this.row = row;
    }
    
    public Coordinate(String coordinateString) {
        this(coordinateString.charAt(0), Character.getNumericValue(coordinateString.charAt(1)));
    }
    
    @Override
    public Character getColumn() {
        return column;
    }

    @Override
    public Integer getRow() {
        return row;
    }

    @Override
    public Integer getColumnIndex() {
        return column - 'a';
    }

    @Override
    public Integer getRowIndex() {
        return 8 - row;
    }

    @Override
    public boolean isValid() {
        return isValid(this.column, this.row);
    }

    private boolean isValid(Character column, Integer row) {
        if (column == null || row == null) {
            return false;
        }
        boolean isColumnValid = column >= 'a' && column <= 'h';
        boolean isRowValid = row >= 1 && row <= 8;
        return isColumnValid && isRowValid;
    }
    
    @Override
    public String toString() {
        return String.valueOf(column) + row;
    }
    
}