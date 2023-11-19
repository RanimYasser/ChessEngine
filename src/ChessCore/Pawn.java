package ChessCore;

/**
 * @author Win11
 */
public class Pawn extends Piece {

    PiecesType piecesType;
    boolean twoSteps;

    public Pawn(boolean color) {
        super(color);
        piecesType = PiecesType.PAWN;
        twoSteps = false;
    }

    @Override
    public boolean isValidMove(Tile Current, Tile Target, Board board) {
        /* Tile targetTile=new Tile(TargetX, TargetY);
      Tile currentTile=new Tile(CurrentX, CurrentY);*/
 Pawn pawn = (Pawn) Current.getPiece();
        //pawns only go in one direction so we need one for black and one for white
        if ((!Target.isOccupied()) || (Target.isOccupied() && (Target.getPiece().color != this.color))) {
            if (this.color) {
               
                //moves two tiles only in first move
                if (this.FirstMove) {
                    if (Target.x == Current.x && Target.y == Current.y - 1) {
                        return true;
                    } 
                    else if (Target.x == Current.x && Target.y == Current.y - 2) {
                       pawn.twoSteps= true;
                        return true;
                    }
                } else //move one tile in first move
                {
                    if (Target.x == Current.x && Target.y == Current.y - 1) {
                        return true;
                    }
                }
                //kill in first move

                if (Target.isOccupied() && Target.getPiece().color != Current.getPiece().color) {
                    if (Target.y - Current.y == -1 && Math.abs(Target.x - Current.x) == 1) {
                        return true;
                    }
                }

            } else {

                if (this.FirstMove) {
                    if (Target.x == Current.x && Target.y == Current.y + 1) {
                        return true;
                    }
                 else if (Target.x == Current.x && Target.y == Current.y + 2) {

                    pawn.twoSteps= true;
                    return true;
                 }
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
            if (enpassant(Current, Target, board)) {
                return true;
            }
            return false;
        }
        return false;
    }

    public PiecesType getPiecesType() {
        return piecesType;
    }

    public boolean enpassant(Tile current, Tile target, Board board) {
        Tile left = board.getTile(current.x - 1, current.y);
        Tile right = board.getTile(current.x + 1, current.y);
        Tile temp = null;
        Pawn leftPawn = null;
        Pawn rightPawn=null;
        Pawn currentPawn=null;
     
    if (left.getPiece() instanceof Pawn)
  leftPawn=(Pawn)left.getPiece();
    if (right.getPiece() instanceof Pawn)
 rightPawn=(Pawn)right.getPiece();
    if (current.getPiece() instanceof Pawn)
 currentPawn=(Pawn) current.getPiece();
   // two opponent pawns next to each other (same y diffrent x)
        if (leftPawn!=null && leftPawn.color !=currentPawn.color &&leftPawn.moves == 1&&leftPawn.twoSteps) {
            if (currentPawn.color) {
                temp = board.getTile(left.x, left.y - 1);

            } else {
                temp = board.getTile(left.x, left.y + 1);

            }
        } else if (rightPawn!=null &&  rightPawn.color != currentPawn.color && rightPawn.moves == 1&&rightPawn.twoSteps) {
            if (currentPawn.color) {
                temp = board.getTile(right.x, right.y - 1);

            } else {
                temp = board.getTile(right.x, right.y + 1);
            }
        }
        if (temp == target) {
            return true;
        }
        return false;
    }
}
