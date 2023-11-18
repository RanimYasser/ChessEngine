/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ChessCore;

/**
 * @author Win11
 */
public class Queen extends Piece {
PiecesType piecesType;
    public Queen(boolean white) {
        super(white);
        piecesType=PiecesType.QUEEN;

    }


    @Override
    public boolean isValidMove(Tile Current, Tile Target, Board chessboard) {
// destination is either not occupied or occupied by the opponent

        if ((!Target.isOccupied()) || (Target.isOccupied() && (Target.getPiece().color != this.color))) {

            //check if the cell lies in the horizontal or vertical or diagonal paths
            if (HorizontalMove(Current.x, Current.y, Target.x, Target.y) || VerticalMove(Current.x, Current.y, Target.x, Target.y) || DiagonalMove(Current.x, Current.y, Target.x, Target.y)) {

                // Check for obstacle in the path
                int rowIncrement = Integer.compare(Target.x, Current.x);
                int colIncrement = Integer.compare(Target.y, Current.y);

                for (int i = Current.x + rowIncrement, j = Current.y + colIncrement; i != Target.x || j != Target.y; i += rowIncrement, j += colIncrement) {

                    if (chessboard.board[i][j].getPiece() != null) {
                        return false; // Path is blocked
                    }
                }

                return true; // Valid move for a Queen and path is empty
            }

            return false; // Invalid move for a Queen
        }

        return false;// Invalid  because it has a piece that  is mine
    }
    public PiecesType getPiecesType() {
        return  piecesType;
    }


}
