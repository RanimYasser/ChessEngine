
package ChessCore;


/**
 * @author Win11
 */
public class Pawn extends Piece {
PiecesType piecesType;
    public Pawn(boolean color) {
        super(color);
        piecesType=PiecesType.PAWN;
    }


    @Override
    public boolean isValidMove(Tile Current, Tile Target, Board board) {
     /* Tile targetTile=new Tile(TargetX, TargetY);
      Tile currentTile=new Tile(CurrentX, CurrentY);*/

        //pawns only go in one direction so we need one for black and one for white
        if ((!Target.isOccupied()) || (Target.isOccupied() && (Target.getPiece().color != this.color)))  {
            if (this.color) {

                //moves two tiles only in first move
                if (this.FirstMove) {
                    if (Target.x == Current.x && Target.y == Current.y - 1 || Target.x == Current.x && Target.y == Current.y - 2)
                        return true;
                } else
                //move one tile in first move
                {
                    if (Target.x == Current.x && Target.y == Current.y - 1)
                        return true;
                }
                //kill in first move

                if (Target.isOccupied() && Target.getPiece().color != Current.getPiece().color) {
                    if (Target.y - Current.y == -1 && Math.abs(Target.x - Current.x) == 1) {
                        return true;
                    }
                }


            } else {

                if (this.FirstMove) {
                    if (Target.x == Current.x && Target.y == Current.y + 1 || Target.x == Current.x && Target.y == Current.y + 2)
                        return true;
                } else {
                    if (Target.x == Current.x && Target.y == Current.y + 1)
                        return true;
                }

                if (Target.isOccupied() && Target.getPiece().color != Current.getPiece().color) {
                    if (Target.y - Current.y == 1 && Math.abs(Target.x - Current.x) == 1) {
                        return true;
                    }
                }
            }

            return false;
        }
return false;
    }

    public PiecesType getPiecesType() {
        return  piecesType;
    }

} 
   

