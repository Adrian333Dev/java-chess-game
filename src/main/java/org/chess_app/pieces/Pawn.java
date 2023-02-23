package org.chess_app.pieces;

import org.chess_app.Coordinates;
import org.chess_app.enums.Color;

import java.util.Set;

public class Pawn extends Piece {
    public Pawn(Color color, Coordinates coordinates) {
        super(color, coordinates);
    }

    @Override
    public Set<CoordinatesShift> getPieceMoves() {
        return null;
    }
}
