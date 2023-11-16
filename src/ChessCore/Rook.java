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
boolean white;
    public Rook(boolean white) {
    this.white=white;

    }

   

    @Override
    public boolean isValidMove(int CurrentX, int CurrentY, int TargetX, int TargetY) {
      if (VerticalMove(CurrentX, CurrentY, TargetX, TargetY)|| HorizontalMove(CurrentX, CurrentY, TargetX, TargetY))
    return true;
      return false;
    
    }
    
}
