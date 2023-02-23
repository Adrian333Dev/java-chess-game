package org.chess_app;

import org.chess_app.board.Board;

public class Main {
    public static void main(String[] args) {
        var board = new Board();
        board.setDefaultPieces();

        Game game = new Game(board);
        game.gameLoop();
    }
}