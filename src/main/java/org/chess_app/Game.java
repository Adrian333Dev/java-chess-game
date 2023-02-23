package org.chess_app;

import org.chess_app.board.Board;
import org.chess_app.enums.Color;
import org.chess_app.pieces.Piece;
import org.chess_app.ui.BoardConsoleRenderer;

import java.util.Set;

public class Game {
  private final Board board;
  private final BoardConsoleRenderer renderer = new BoardConsoleRenderer();

  public Game(Board board) {
    this.board = board;
  }

  public void gameLoop() {
    boolean isWhiteTurn = true;
    while (true) {
      // render
      renderer.render(board);

      if (isWhiteTurn) {
        System.out.println("White's turn");
      } else {
        System.out.println("Black's turn");
      }

      // input
      Coordinates sourceCoordinates = CoordinateReader.inputPieceCoordinatesForColor(
              isWhiteTurn ? Color.WHITE : Color.BLACK, board
      );
      Piece piece = board.getPiece(sourceCoordinates);
      Set<Coordinates> availableSquares = piece.getAvailableSquares(board);
      Coordinates targetCoordinates = CoordinateReader.inputAvailableSquare(availableSquares);

      // make move
      board.movePiece(sourceCoordinates, targetCoordinates);

      // pass move
      isWhiteTurn = !isWhiteTurn;
    }
  }
}
