package com.example.chess.services;

import com.example.chess.models.board.Board;
import com.example.chess.models.pieces.IPiece;
import com.example.chess.models.coordinate.Coordinate;
import org.springframework.stereotype.Service;

@Service
public class ChessService {

    private Board board;

    public ChessService() {
        this.board = new Board();
        this.board.initializeBoard();
    }

    public Board getBoard() {
        return this.board;
    }

    public boolean movePiece(IPiece piece, Coordinate targetCoordinate) { 
        Coordinate currentCoordinate = piece.getCoordinate();  // Obtiene la coordenada de la pieza actual
        if (currentCoordinate == null) {
            System.out.println("No hay pieza en la coordenada " + currentCoordinate); 
            return false;
        }
        
        System.out.println("Intentando mover la pieza: " + piece.getName() + " desde " + currentCoordinate + " a " + targetCoordinate);
        
        boolean moveResult = piece.move(targetCoordinate);  // Realiza el movimiento con la nueva coordenada
        if (moveResult) {
            System.out.println("Movimiento exitoso");
            return true;
        } else {
            System.out.println("Movimiento fallido");
            return false;
        }
    }
    
    
    
}
