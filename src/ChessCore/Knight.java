/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ChessCore;


/**
 * @author Win11
 */
public class Knight extends Piece {
    PiecesType piecesType;
    boolean white;

    public Knight(boolean white) {

        super(white);
        piecesType = PiecesType.KNIGHT;

    }


    //note this piece is the only one that can jump
    @Override
    public boolean isValidMove(Tile Current, Tile Target, Board board) {
        if ((!Target.isOccupied()) || (Target.isOccupied() && (Target.getPiece().color != this.color))) {
            int rowstep = Math.abs(Current.x - Target.x);
            int colStep = Math.abs(Current.y - Target.y);
            //Knight can jump
            if ((rowstep == 1 && colStep == 2 || rowstep == 2 && colStep == 1))
                return true;
            //Invalid move for knight
            return false;

        }   // Invalid move because this tile has my piece
        return false;
    }

    public PiecesType getPiecesType() {
        return piecesType;
    }


}
 