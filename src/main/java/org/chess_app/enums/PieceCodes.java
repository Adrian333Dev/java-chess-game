package org.chess_app.enums;

public enum PieceCodes {

     Pawn("♟"), Knight("♞"), Bishop("♝"), Rook("♜"), Queen("♛"), King("♚");

    /* Pawn("PN"), Knight("KT"), Bishop("BP"), Rook("RK"), Queen("QN"), King("KG"); */

    public final String uniCode;

    PieceCodes(String uniCode) {
        this.uniCode = uniCode;
    }
}