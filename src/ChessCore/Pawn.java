/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ChessCore;

/**
 *
 * @author Win11
 */
public class Pawn extends Piece {
boolean white;
    public Pawn(boolean white) {
    this.white=white;
    }

   

   

    @Override
    public boolean isValidMove(int CurrentX ,int CurrentY,int TargetX, int TargetY) {
        if (this.FirstMove)
        {
            if (white)
            {
        if(TargetY==CurrentY &&TargetX==CurrentX+1||TargetY==CurrentY&&TargetX==CurrentX+2)
        return true;
            
            }
            else
            {
                if(TargetY==CurrentY &&TargetX==CurrentX-1||TargetY==CurrentY&&TargetX==CurrentX-2)
        return true;
            }   
        }
         
        else {
        if (white&&TargetY==CurrentY&&TargetX==CurrentX+1)
            return true;
        
        else if(!white&&TargetY==CurrentY&&TargetX==CurrentX-1)
        return true;
        }
        return false;
    }
    
}
   

