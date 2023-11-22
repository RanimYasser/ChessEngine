
package ChessCore;


public class King extends Piece {

    PiecesType piecesType;
    public King(boolean white) {
        super(white);
        piecesType=PiecesType.KING;
        
    }


    @Override
    public boolean isValidMove(Tile Current,Tile Target,Board board) {
        if ((!Target.isOccupied()) || (Target.isOccupied() && (Target.getPiece().color != this.color)))  {
            if (VerticalMove(Current.x, Current.y, Target.x, Target.y) && (Math.abs(Current.x - Target.x) == 1))
                return true;

            if (HorizontalMove(Current.x, Current.y, Target.x, Target.y) && (Math.abs(Current.y - Target.y) == 1))
                return true;

            if (DiagonalMove(Current.x, Current.y, Target.x, Target.y) && (Math.abs(Current.x - Target.x) == 1) && (Math.abs(Current.y - Target.y) == 1))
                return true;

            return false;

        }
        return false;
    }

    @Override
    public PiecesType getPiecesType() {
       return  piecesType;
    }


}
