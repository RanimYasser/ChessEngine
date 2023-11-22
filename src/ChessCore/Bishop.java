/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ChessCore;


/**
 *
 * @author Win11
 */
public class Bishop extends Piece {

   private PiecesType piecesType;


    public Bishop(boolean white) {
        super(white);
        this.piecesType=PiecesType.BISHOP;
    }

    @Override
    public boolean isValidMove(Tile Current ,Tile Target,Board board) {

        if ((!Target.isOccupied()) || (Target.isOccupied() && (Target.getPiece().color != this.color))) {
            if (DiagonalMove(Current.x, Current.y, Target.x, Target.y)) {


                int rowSteps = Integer.compare(Target.x, Current.x);
                int colSteps = Integer.compare(Target.y, Current.y);
                for (int i = Current.x + rowSteps, j = Current.y + colSteps;i != Target.x || j != Target.y; i += rowSteps, j += colSteps) {

                    if (board.board[i][j].getPiece() != null) {

                        return false; // Path is blocked
                    }
                }
                return true;
            }

            return false;
        }

        return false;
    }
    public PiecesType getPiecesType() {

        return  piecesType;
    }

}
