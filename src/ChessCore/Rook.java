/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ChessCore;



/**
 *
 * @author Win11
 */
public class Rook extends Piece {
    PiecesType piecesType;

    public Rook(boolean white) {
        super(white);
        piecesType=PiecesType.ROOK;

    }


    @Override
    public boolean isValidMove(Tile Current, Tile Target, Board board) {
        if ((!Target.isOccupied()) || (Target.isOccupied() && (Target.getPiece().color != this.color)))  {
            if (VerticalMove(Current.x, Current.y, Target.x, Target.y) || HorizontalMove(Current.x, Current.y, Target.x, Target.y)) {
                int rowIncrement = Integer.compare(Target.x, Current.x);
                int colIncrement = Integer.compare(Target.y, Current.y);
                for (int i = Current.x + rowIncrement, j = Current.y + colIncrement; i != Target.x || j != Target.y; i += rowIncrement, j += colIncrement) {

                    if (board.board[i][j].getPiece() != null) {
                        // Path is blocked
                        return false;
                    }
                }
                //valid move for rook and path is empty
                return true;
            }
            //Invalid move for rook
            return false;
        }
        // Invalid move because the cell contains an ally  piece
        return false;
    }

    public PiecesType getPiecesType() {
        return  piecesType;
    }

}

