
package ChessCore;

import java.util.ArrayList;

/**
 *
 * @author Win11
 */
public class Pawn extends Piece {

    public Pawn(boolean color) {

      super(color);
    }


    @Override
    public boolean isValidMove(int CurrentX ,int CurrentY,int TargetX, int TargetY) {
        if (this.FirstMove)
        {
        if(TargetX==CurrentX&&TargetY==CurrentY+1||TargetX==CurrentX&&TargetY==CurrentY+2)
        return true;
            }
        else {
        if (TargetX==CurrentX&&TargetY==CurrentY+1)
            return true;
        }
        return false;
    }

    @Override
    public ArrayList<Tile> updatePath() {
        return null;
    }

    @Override
    protected ArrayList<Tile> getAllValidMoves(Tile center) {
        return null;
    }
} 
   

