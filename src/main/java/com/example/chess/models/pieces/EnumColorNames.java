package com.example.chess.models.pieces;

public enum EnumColorNames {
    WHITE("Blanco"),
    BLACK("Negro");

    private final String colorName;

    EnumColorNames(String colorName) {
        this.colorName = colorName;
    }

    public String getColorName() {
        return colorName;
    }

    @Override
    public String toString() {
        return colorName;
    }
}
