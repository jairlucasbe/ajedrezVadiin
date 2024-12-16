package com.example.chess.views.chess;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("")
public class ChessBoardView extends VerticalLayout {

    private static final String LIGHT_COLOR = "#F0D9B5";
    private static final String DARK_COLOR = "#B58863";
    private static final String[] COLUMNS = {"a", "b", "c", "d", "e", "f", "g", "h"};
    private static final String[] ROWS = {"8", "7", "6", "5", "4", "3", "2", "1"};

    public ChessBoardView() {
        setSizeFull();
        setJustifyContentMode(JustifyContentMode.CENTER);
        setAlignItems(Alignment.CENTER);

        Div container = createContainer();
        Div chessBoard = createChessBoard();

        container.add(chessBoard);
        add(container);
    }

    private Div createContainer() {
        Div container = new Div();
        container.getStyle().set("display", "flex");
        container.getStyle().set("justify-content", "center");
        container.getStyle().set("align-items", "center");
        container.getStyle().set("width", "100%");
        container.getStyle().set("height", "100%");
        container.getStyle().set("padding", "2rem");
        return container;
    }

    private Div createChessBoard() {
        Div chessBoard = new Div();
        chessBoard.getStyle().set("display", "grid");
        chessBoard.getStyle().set("grid-template-columns", "auto repeat(8, 1fr) auto");
        chessBoard.getStyle().set("grid-template-rows", "auto repeat(8, 1fr) auto");
        chessBoard.getStyle().set("width", "80vmin");
        chessBoard.getStyle().set("height", "80vmin");
        chessBoard.getStyle().set("box-sizing", "border-box");

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
        return label;
    }

    private Div createCell(int row, int col) {
        Div cell = new Div();
        cell.getStyle().set("background-color", (row + col) % 2 == 0 ? LIGHT_COLOR : DARK_COLOR);
        cell.getStyle().set("width", "100%");
        cell.getStyle().set("height", "100%");
        cell.getStyle().set("box-sizing", "border-box");
        cell.getStyle().set("cursor", "pointer");

        String cellCoordinate = COLUMNS[col] + ROWS[row];
        cell.addClickListener(event -> Notification.show("Coordenada: " + cellCoordinate));

        return cell;
    }
}
