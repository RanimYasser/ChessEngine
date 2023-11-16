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
        if(TargetX==CurrentX&&TargetY==CurrentY+1||TargetX==CurrentX&&TargetY==CurrentY+2)
        return true;
            }
        else {
        if (TargetX==CurrentX&&TargetY==CurrentY+1)
            return true;
        }
        return false;
    }
} 
   

