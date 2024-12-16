package com.example.chess.views.chess;

import com.example.chess.services.ChessService;
import com.example.chess.models.pieces.EnumColorNames;
import com.example.chess.models.pieces.IPiece;

import org.springframework.stereotype.Component;

import com.example.chess.models.coordinate.Coordinate;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.notification.Notification;

@Component
public class ChessPieceTable extends Div {

    private final ChessService chessService;
    private Coordinate sourceCoordinate;  // Coordenada de la pieza seleccionada

    public ChessPieceTable(ChessService chessService) {
        this.chessService = chessService;
        initialize();
    }

    public ChessPieceTable() {
        this.chessService = new ChessService(); // O inyectado de alguna manera
        initialize();
    }

    private void initialize() {
        getStyle().set("position", "absolute");
        getStyle().set("top", "0");
        getStyle().set("left", "0");
        getStyle().set("width", "100%");
        getStyle().set("height", "100%");
        //getStyle().set("pointer-events", "none"); // Permite interacción solo con el tablero principal
        getStyle().set("display", "grid");
        getStyle().set("grid-template-columns", "auto repeat(8, 1fr) auto");
        getStyle().set("grid-template-rows", "auto repeat(8, 1fr) auto");

        add(createEmptyDiv());
        for (String column : ChessBoardView.COLUMNS) {
            add(createTransparentLabel(column));
        }
        add(createEmptyDiv());

        for (int row = 0; row < 8; row++) {
            add(createTransparentLabel(ChessBoardView.ROWS[row]));
            for (int col = 0; col < 8; col++) {
                add(createCellWithPiece(row, col));
            }
            add(createTransparentLabel(ChessBoardView.ROWS[row]));
        }

        add(createEmptyDiv());
        for (String column : ChessBoardView.COLUMNS) {
            add(createTransparentLabel(column));
        }
        add(createEmptyDiv());
    }

   
    
    private Div createCellWithPiece(int row, int col) {
        Div cell = new Div();
        cell.getStyle().set("width", "100%");
        cell.getStyle().set("height", "100%");
        cell.getStyle().set("background-color", "transparent");
        cell.getStyle().set("cursor", "pointer"); // Agregar cursor de puntero para indicar clic
    
        // Agregar transición suave para el cambio de fondo
        cell.getStyle().set("transition", "background-color 0.3s ease");
    
        IPiece piece = chessService.getBoard().getPieceAt(row, col);
        if (piece != null) {
            String pieceSymbol = getPieceSymbol(piece); // Obtener el símbolo de la pieza
            cell.setText(pieceSymbol);
            cell.getStyle().set("font-size", "2rem");
    
            if (piece.getColor() == EnumColorNames.WHITE) {
                cell.getStyle().set("color", "white");
            } else {
                cell.getStyle().set("color", "black");
            }
    
            cell.getStyle().set("display", "flex");
            cell.getStyle().set("align-items", "center");
            cell.getStyle().set("justify-content", "center");
            cell.getStyle().set("font-weight", "bold");
            
    
        } else {
            // Dejar la celda vacía pero asegurarse de que sea clickeable
            cell.setText("\u200B");  // Usamos el espacio invisible (U+200B)
            cell.getStyle().set("cursor", "pointer");
            cell.getStyle().set("background-color", "transparent");
        }

        cell.addClickListener(event -> handleCellClick(row, col, piece));  // Pasar la pieza a handleCellClick
    
        // Evento mouseover
        cell.getElement().addEventListener("mouseover", e -> {
            // Cambiar el fondo a un color más brillante
            cell.getStyle().set("background-color", "rgba(255, 255, 0, 0.7)"); // Amarillo brillante con opacidad
        });
    
        // Evento mouseout
        cell.getElement().addEventListener("mouseout", e -> {
            // Regresar al estado original (puedes elegir el color de fondo base)
            cell.getStyle().set("background-color", "transparent");
        });
    
        return cell;
    }
    
    
    
    private void handleCellClick(int row, int col, IPiece piece) {
        Coordinate clickedCoordinate = new Coordinate((char) ('a' + col), 8 - row); 
        System.out.println(clickedCoordinate); //b2
        
        if (piece != null) {
            String pieceSymbol = getPieceSymbol(piece);
            Notification.show("Pieza seleccionada: " + pieceSymbol);
        }
    
        if (sourceCoordinate == null) {
            if (piece != null) { 
                sourceCoordinate = clickedCoordinate;
                Notification.show("Selecciona la coordenada de destino.");
            } else {
                Notification.show("No hay pieza en esta casilla.");
            }
        } else {
            if (piece == null) {
                // Solo realizar el movimiento si no hay pieza en la celda
                Coordinate targetCoordinate = clickedCoordinate;
                boolean moveSuccess = chessService.movePiece(piece, targetCoordinate);  // Cambiar a solo pasar la pieza y la coordenada de destino
                if (moveSuccess) {
                    Notification.show("Movimiento exitoso: " + sourceCoordinate + " a " + targetCoordinate);
                } else {
                    Notification.show("Movimiento no válido.");
                }
            } else {
                // Si hay una pieza en la celda, actualizamos la fuente
                sourceCoordinate = clickedCoordinate;
                Notification.show("Selecciona la coordenada de destino.");
            }
            sourceCoordinate = null; // Resetear después de realizar el movimiento
        }
    }
    
    

    
    
    
    
    private String getPieceSymbol(IPiece piece) {
        String symbol = "";
    
        // Convertir el nombre de la pieza a minúsculas utilizando name() para obtener el nombre de la constante
        String pieceName = piece.getName().name().toLowerCase();
    
        switch (pieceName) {
            case "king":
                symbol = piece.getColor() == EnumColorNames.WHITE ? ChessSymbols.WHITE_KING : ChessSymbols.BLACK_KING;
                break;
            case "queen":
                symbol = piece.getColor() == EnumColorNames.WHITE ? ChessSymbols.WHITE_QUEEN : ChessSymbols.BLACK_QUEEN;
                break;
            case "rook":
                symbol = piece.getColor() == EnumColorNames.WHITE ? ChessSymbols.WHITE_ROOK : ChessSymbols.BLACK_ROOK;
                break;
            case "bishop":
                symbol = piece.getColor() == EnumColorNames.WHITE ? ChessSymbols.WHITE_BISHOP : ChessSymbols.BLACK_BISHOP;
                break;
            case "knight":
                symbol = piece.getColor() == EnumColorNames.WHITE ? ChessSymbols.WHITE_KNIGHT : ChessSymbols.BLACK_KNIGHT;
                break;
            case "pawn":
                symbol = piece.getColor() == EnumColorNames.WHITE ? ChessSymbols.WHITE_PAWN : ChessSymbols.BLACK_PAWN;
                break;
        }
    
        return symbol;
    }

    private Div createEmptyDiv() {
        return new Div();
    }

    private Div createTransparentLabel(String text) {
        Div label = new Div();
        label.setText(text);
        label.getStyle().set("display", "flex");
        label.getStyle().set("align-items", "center");
        label.getStyle().set("justify-content", "center");
        label.getStyle().set("font-weight", "bold");
        label.getStyle().set("font-size", "calc(1vmin + 0.5rem)");
        label.getStyle().set("color", "transparent");
        return label;
    }
}
