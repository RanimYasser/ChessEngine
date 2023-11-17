
package ChessCore;



/**
 *
 * @author Win11
 */
public class Pawn extends Piece {

    public Pawn(boolean color) {

      super(color);
    }


    @Override
    public boolean isValidMove(Tile Current , Tile Target) {
     /* Tile targetTile=new Tile(TargetX, TargetY);
      Tile currentTile=new Tile(CurrentX, CurrentY);*/
        if (this.color)
       {
        if (this.FirstMove)
        {
        if(Target.x==Current.x&&Target.y==Current.y-1||Target.x==Current.x&&Target.y==Current.y-2)
        return true;
            }
        else {
        if (Target.x==Current.x&&Target.y==Current.y-1)
            return true;
        }
         if (Target.isOccupied()&&Target.getPiece().color!=Current.getPiece().color)
         {
         if (Target.y-Current.y==-1&&Math.abs(Target.x-Current.x)==1)
         {
         return true;
         }
       }
       }
       else{
        
        if (this.FirstMove)
        {
        if(Target.x==Current.x&&Target.y==Current.y+1||Target.x==Current.x&&Target.y==Current.y+2)
        return true;
            }
        else {
        if (Target.x==Current.x&&Target.y==Current.y+1)
            return true;
        }
         if (Target.isOccupied()&&Target.getPiece().color!=Current.getPiece().color)
         {
         if (Target.y-Current.y==1&&Math.abs(Target.x-Current.x)==1)
         {
         return true;
         }
         }
       }   
      
        return false;
    }

 
   
  
} 
   

