/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ChessCore;

/**
 *
 * @author Win11
 */
public class Queen extends Piece{
boolean white;
    public Queen(boolean white) {
    this.white=white;
    }

  

    @Override
    public boolean isValidMove(int CuurentX ,int CurrentY,int TargetX, int TargetY) {
       if (HorizontalMove(CurrentY, CurrentY, TargetX, TargetY)||VerticalMove(CurrentY, CurrentY, TargetX, TargetY)||DiagonalMove(CurrentY, CurrentY, TargetX, TargetY))
   return true;
       return false;
           }
    
}
