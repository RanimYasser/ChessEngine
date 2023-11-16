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
boolean white;

    public Bishop(boolean white) {
        this.white = white;
    }

   

    

    @Override
    public boolean isValidMove(int CurrentX ,int CurrentY,int TargetX, int TargetY) {
        if (DiagonalMove(CurrentX, CurrentY, TargetX, TargetY))
         return true;
         return false;
    }
    
}
