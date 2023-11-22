/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ChessCore;



enum PiecesType {
    PAWN, BISHOP, KNIGHT, ROOK, QUEEN, KING;
}

public abstract class Piece {
    protected boolean FirstMove = true;

    boolean color;
    int moves = 0;

    public Piece(boolean color) {
        this.color = color;


    }


    public boolean DiagonalMove(int CurrentX, int CurrentY, int TargetX, int TargetY) {
        if (Math.abs(CurrentX - TargetX) == Math.abs(CurrentY - TargetY))
            return true;
        return false;
    }

    public boolean VerticalMove(int CurrentX, int CurrentY, int TargetX, int TargetY) {
        if (CurrentX == TargetX)
            return true;
        return false;
    }

    public boolean HorizontalMove(int CurrentX, int CurrentY, int TargetX, int TargetY) {
        if (CurrentY == TargetY)
            return true;

        return false;
    }

    public abstract boolean isValidMove(Tile Current, Tile Target, Board board);


    public abstract PiecesType getPiecesType();


}
