package org.chess_app;

import org.chess_app.board.Board;
import org.chess_app.enums.Color;
import org.chess_app.enums.File;
import org.chess_app.pieces.Piece;

import java.util.Scanner;
import java.util.Set;

public class CoordinateReader {
  private static final Scanner scanner = new Scanner(System.in);

  public static Coordinates input() {
    Coordinates result;
    while (true) {
      System.out.println("Please enter coordinates (ex. a1)");

      String line = scanner.nextLine();

      char fileChar = Character.toUpperCase(line.charAt(0));
      int rankChar = Character.getNumericValue(line.charAt(1));

      int asciiA = 'A';
      int asciiH = 'H';

      if (((int) fileChar) >= asciiA && ((int) fileChar) <= asciiH && rankChar >= 1 && rankChar <= 8) {
        result = new Coordinates(File.fromChar(fileChar), rankChar);
        break;
      } else System.out.println("Invalid format");
    }
    return result;
  }

  public static Coordinates inputPieceCoordinatesForColor(Color color, Board board) {
    while (true) {
      System.out.println("Enter coordinates for piece to move");
      Coordinates coordinates = input();

      if (board.isSquareEmpty(coordinates)) {
        System.out.println("Empty Square");
        continue;
      }
      Piece piece = board.getPiece(coordinates);

      if (piece.color != color) {
        System.out.println("Wrong Color");
        continue;
      }

      Set<Coordinates> avaliableSquares = piece.getAvailableSquares(board);
      if (avaliableSquares.size() == 0) {
        System.out.println("Blocked Piece");
        continue;
      }

      return coordinates;
    }
  }

  public static Coordinates inputAvailableSquare(Set<Coordinates> coordinates) {
    while (true) {
      System.out.println("Enter coordinates for square to move to");
      Coordinates input = input();

      if (coordinates.contains(input)) {
        return input;
      } else {
        System.out.println("Invalid Square");
      }
    }
  }


  public static void main(String[] args) {

    Board board = new Board();
    board.setDefaultPieces();

    Coordinates coordinates = inputPieceCoordinatesForColor(Color.WHITE, board);
    System.out.println("Coordinates = " + coordinates.file + coordinates.rank);
  }
}
