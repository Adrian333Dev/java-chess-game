package org.chess_app.ui;

import org.chess_app.board.Board;
import org.chess_app.Coordinates;
import org.chess_app.enums.Color;
import org.chess_app.enums.File;
import org.chess_app.enums.PieceCodes;
import org.chess_app.pieces.Piece;

public class BoardConsoleRenderer {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_WHITE_PIECE_COLOR = "\u001B[97m";
    public static final String ANSI_BLACK_PIECE_COLOR = "\u001B[30m";
    public static final String ANSI_WHITE_SQUARE_BACKGROUND = "\u001B[47m";
    public static final String ANSI_BLACK_SQUARE_BACKGROUND = "\u001B[0;100m";
//    public static final String ANSI_HIGHLIGHTED_SQUARE_BACKGROUND = "\u001B[45m";

    public void render(Board board) {
        for (int rank = 8; rank > 0; rank--) {
            StringBuilder line = new StringBuilder();
            line.append(rank);
            for (File file : File.values()) {
                var coordinates = new Coordinates(file, rank);
                if (board.isSquareEmpty(coordinates)) {
                    line.append(getSpriteForEmptySquare(coordinates));
                } else {
                    line.append(getPieceSprite(board.getPiece(coordinates)));
                }
            }
            line.append(ANSI_RESET);
            System.out.println(line);
        }
        System.out.println(" A | B | C | D | E | F | G | H ");

    }

    private String colorizeSprite(String sprite, Color pieceColor, boolean isSquareDark) {
        var result = sprite;

        if (pieceColor == Color.WHITE) {
            result = ANSI_WHITE_PIECE_COLOR + result;
        } else {
            result = ANSI_BLACK_PIECE_COLOR + result;
        }

        if (isSquareDark) {
            result = ANSI_BLACK_SQUARE_BACKGROUND + result;
        } else {
            result = ANSI_WHITE_SQUARE_BACKGROUND + result;
        }

        return result;
    }

    public String selectUnicodeSpriteForPiece(Piece piece) {
        String pieceName = piece.getClass().getSimpleName();
        return PieceCodes.valueOf(pieceName).uniCode;
    }

    private String getSpriteForEmptySquare(Coordinates coordinates) {
        return colorizeSprite("   ", Color.WHITE, Board.isSquareDark(coordinates));
    }

    private String getPieceSprite(Piece piece) {
        return colorizeSprite(" " + selectUnicodeSpriteForPiece(piece) + " ", piece.color, Board.isSquareDark(piece.coordinates));
    }

}
