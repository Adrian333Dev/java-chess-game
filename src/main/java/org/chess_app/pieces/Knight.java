package org.chess_app.pieces;

import org.chess_app.Coordinates;
import org.chess_app.enums.Color;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Knight extends Piece {
    public Knight(Color color, Coordinates coordinates) {
        super(color, coordinates);
    }

    @Override
    public Set<CoordinatesShift> getPieceMoves() {
        return new HashSet<>(
                Arrays.asList(
                        new CoordinatesShift(1, 2),
                        new CoordinatesShift(2, 1),
                        new CoordinatesShift(2, -1),
                        new CoordinatesShift(1, -2),
                        new CoordinatesShift(-2, -1),
                        new CoordinatesShift(-1, -2),
                        new CoordinatesShift(-2, 1),
                        new CoordinatesShift(-1, 2))
        );
    }
}
