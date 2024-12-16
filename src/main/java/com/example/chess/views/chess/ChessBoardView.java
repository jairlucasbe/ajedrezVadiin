package com.example.chess.views.chess;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("")
public class ChessBoardView extends VerticalLayout {

    private static final String LIGHT_COLOR = "#F0D9B5";
    private static final String DARK_COLOR = "#B58863";
    public static final String[] COLUMNS = {"a", "b", "c", "d", "e", "f", "g", "h"};
    public static final String[] ROWS = {"8", "7", "6", "5", "4", "3", "2", "1"};

    public ChessBoardView() {
        setSizeFull();
        setJustifyContentMode(JustifyContentMode.CENTER);
        setAlignItems(Alignment.CENTER);

        // Contenedor principal para el tablero y las piezas
        Div container = new Div();
        container.getStyle().set("position", "relative");
        container.getStyle().set("width", "80vmin");
        container.getStyle().set("height", "80vmin");

        Div chessBoard = renderBoard();
        container.add(chessBoard);

        ChessPieceTable chessPieceTable = new ChessPieceTable(); 
        container.add(chessPieceTable); // Añadir el tablero de piezas al mismo contenedor

        add(container); // Añadir el contenedor a la vista
    }

    private Div renderBoard() {
        Div chessBoard = new Div();
        chessBoard.getStyle().set("display", "grid");
        chessBoard.getStyle().set("grid-template-columns", "auto repeat(8, 1fr) auto");
        chessBoard.getStyle().set("grid-template-rows", "auto repeat(8, 1fr) auto");
        chessBoard.getStyle().set("width", "100%");
        chessBoard.getStyle().set("height", "100%");
        chessBoard.getStyle().set("position", "relative");

        chessBoard.add(createEmptyDiv());
        for (String column : COLUMNS) {
            chessBoard.add(createLabel(column));
        }
        chessBoard.add(createEmptyDiv());
        for (int row = 0; row < 8; row++) {
            chessBoard.add(createLabel(ROWS[row]));
            for (int col = 0; col < 8; col++) {
                chessBoard.add(createCell(row, col));
            }
            chessBoard.add(createLabel(ROWS[row]));
        }
        chessBoard.add(createEmptyDiv());
        for (String column : COLUMNS) {
            chessBoard.add(createLabel(column));
        }
        chessBoard.add(createEmptyDiv());
        return chessBoard;
    }

    private Div createEmptyDiv() {
        return new Div();
    }

    private Div createLabel(String text) {
        Div label = new Div();
        label.setText(text);
        label.getStyle().set("display", "flex");
        label.getStyle().set("align-items", "center");
        label.getStyle().set("justify-content", "center");
        label.getStyle().set("font-weight", "bold");
        label.getStyle().set("font-size", "calc(1vmin + 0.5rem)");
        label.getStyle().set("width", "100%"); // Asegura que ocupe el espacio completo de la celda
        label.getStyle().set("height", "100%"); // Asegura que ocupe la altura completa de la celda
        label.getStyle().set("box-sizing", "border-box"); // Uniformidad en el tamaño
        return label;
    }
    

    private Div createCell(int row, int col) {
        Div cell = new Div();
        boolean isEvenRow = (row % 2 == 0);
        boolean isEvenCol = (col % 2 == 0);
        if (isEvenRow == isEvenCol) {
            cell.getStyle().set("background-color", LIGHT_COLOR);
        } else {
            cell.getStyle().set("background-color", DARK_COLOR);
        }
        cell.getStyle().set("width", "100%");
        cell.getStyle().set("height", "100%");
        cell.getStyle().set("box-sizing", "border-box");
        return cell;
    }
}