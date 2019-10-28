package draughts.controllers;

import draughts.models.Board;
import draughts.models.Coordinate;
import draughts.models.Game;
import draughts.models.Piece;
import draughts.models.Square;
import draughts.models.State;
import draughts.models.StateValue;
import draughts.models.Turn;
import draughts.types.Color;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;


public class StartControllerTest extends ControllerTest {
    
    private StartController startController;
    
    public StartControllerTest() {}
    
    @Before
    @Override
    public void init() {
        this.game = new Game();
        this.state = new State();
        this.startController = new StartController(this.game, this.state);
    }
    
    @Test
    public void givenStartControllerWhenGameStartWhiteTurnThenNotError() {
       
        Turn turn = this.startController.getTurn();
        assertEquals(turn.getColor(), Color.WHITE);
    }
    
    private void givenStartControllerWhenGameStartWhitePiecesStartInUnknowSquareThenNotError(Color pieceColorToStart) {
        Board board = this.startController.getBoard();
               
        for (int i = 0; i < board.length(); i++) {
            for (int j = 0; j < board.length(); j++) {
                Square square = board.getSquare(i, j);
                Coordinate squareCoordinate = square.getCoordinate();
                Piece piece = this.startController.getPiece(squareCoordinate);
                if (piece != null && piece.getColor() == pieceColorToStart) {
                    assertEquals(square.getColor(), Color.BLACK);
                }
            }
        }
    }
    
    @Test
    public void givenStartControllerWhenGameStartWhitePiecesStartInBlackSquareThenNotError() {
        this.givenStartControllerWhenGameStartWhitePiecesStartInUnknowSquareThenNotError(Color.WHITE);
    }
    
    @Test
    public void givenStartControllerWhenGameStartBlackPiecesStartInBlackSquareThenNotError() {
        this.givenStartControllerWhenGameStartWhitePiecesStartInUnknowSquareThenNotError(Color.BLACK);
    }
    
    @Test
    public void givenStartControllerWhenGameStartBlackPiecesNumberEqualsWhitePiecesNumberThenNotError() {
        Board board = this.startController.getBoard();
        int whiteNumber = 0;
        int blackNumber = 0;
               
        for (int i = 0; i < board.length(); i++) {
            for (int j = 0; j < board.length(); j++) {
                Square square = board.getSquare(i, j);
                Coordinate squareCoordinate = square.getCoordinate();
                Piece piece = this.startController.getPiece(squareCoordinate);
                if (piece != null) {
                    if (piece.getColor() == Color.BLACK)
                        blackNumber++;
                    else if (piece.getColor() == Color.WHITE)
                        whiteNumber++;
                }
            }
        }
        
        assertEquals(whiteNumber, blackNumber);
    }
    
    @Test
    public void givenStartControllerWhenGameStartAllWhiteSquaresHaveNotPieceThenNotError() {
        Board board = this.startController.getBoard();
        
        for (int i = 0; i < board.length(); i++) {
            for (int j = 0; j < board.length(); j++) {
                Square square = board.getSquare(i, j);
                if (square.getColor() == Color.WHITE) {
                    Coordinate squareCoordinate = square.getCoordinate();
                    Piece piece = this.startController.getPiece(squareCoordinate);
                    assertNull(piece);
                }
            }
        }
    }
    
    @Test
    public void givenStartControllerWhenGameStartAllWhitePiecesAreBelowBoardCentralPositionThenNotError() {
        Board board = this.startController.getBoard();
        int boardCentralPosition = board.length() / 2;
        
        for (int i = board.length(); i >= boardCentralPosition; i--) {
            for (int j = 0; j < board.length(); j++) {
                Square square = board.getSquare(i, j);
                Coordinate squareCoordinate = square.getCoordinate();
                Piece piece = this.startController.getPiece(squareCoordinate);
                if (piece != null)
                    assertEquals(piece.getColor(), Color.WHITE);
            }
        }
    }
    
    @Test
    public void givenStartControllerWhenGameStartAllBlackPiecesAreAboveBoardCentralPositionThenNotError() {
        Board board = this.startController.getBoard();
        int boardCentralPosition = board.length() / 2;
        
        for (int i = 0; i <= boardCentralPosition; i++) {
            for (int j = 0; j < board.length(); j++) {
                Square square = board.getSquare(i, j);
                Coordinate squareCoordinate = square.getCoordinate();
                Piece piece = this.startController.getPiece(squareCoordinate);
                if (piece != null)
                    assertEquals(piece.getColor(), Color.BLACK);
            }
        }
    }
    
    @Test
    public void givenStartControllerWhenGameStartAllBoardPiecesHaveDifferentCoordinatesThenNotError() {
        // Arrange
        Board board = this.startController.getBoard();
        List<Coordinate> coordinatePiecesList = new ArrayList<>();
        
        // Act
        for (int i = 0; i < board.length(); i++) {
            for (int j = 0; j < board.length(); j++) {
                Square square = board.getSquare(i, j);
                Coordinate squareCoordinate = square.getCoordinate();
                Piece piece = this.startController.getPiece(squareCoordinate);
                if (piece != null)
                    coordinatePiecesList.add(squareCoordinate);
            }
        }
        
        // Assert
        for (int i = 0; i < coordinatePiecesList.size(); i++) {
            Coordinate coordinatePieceToEvaluate = coordinatePiecesList.get(i);
            
            for (int j = 0; j < coordinatePiecesList.size(); j++) {
                if (j != i) {
                    Coordinate coordinatePieceToCompare = coordinatePiecesList.get(j);
                    assertNotEquals(coordinatePieceToEvaluate, coordinatePieceToCompare);
                }
            }
        }
    }
    
    @Test
    public void givenStartControllerWhenGameStartGameStateValueIsPlayingThenNotError() {
        this.startController.start();
        assertEquals(this.state.getValue(), StateValue.IN_PLAY);
    }
}