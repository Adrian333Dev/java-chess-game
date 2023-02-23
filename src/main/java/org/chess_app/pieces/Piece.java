package org.chess_app.pieces;

import org.chess_app.Coordinates;
import org.chess_app.board.Board;
import org.chess_app.enums.Color;

import java.util.HashSet;
import java.util.Set;

public abstract class Piece {
    public final Color color;
    public Coordinates coordinates;

    public Piece(Color color, Coordinates coordinates) {
        this.color = color;
        this.coordinates = coordinates;
    }

    public Set<Coordinates> getAvailableSquares(Board board) {
        Set<Coordinates> result = new HashSet<>();
        for (CoordinatesShift shift : getPieceMoves()) {
            if (coordinates.canShift(shift)) {
                Coordinates newCoordinated = coordinates.shift(shift);
                if (isSquareAvaliable(newCoordinated, board)) {
                    result.add(newCoordinated);
                }
            }
        }
        return result;
    }

    private boolean isSquareAvaliable(Coordinates coordinates, Board board) {
        return board.isSquareEmpty(coordinates) || board.getPiece(coordinates).color != color;
    }

    public abstract Set<CoordinatesShift> getPieceMoves();
}
