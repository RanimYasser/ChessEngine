/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ChessCore;

/**
 *
 * @author Win11
 */
public class King extends Piece {
boolean white;
    public King(boolean white) {
    this.white=white;
    }

   

    @Override
    public boolean isValidMove(int CuurentX ,int CurrentY,int TargetX, int TargetY) {

if(VerticalMove(CuurentX, CurrentY, TargetX, TargetY)&&(Math.abs(CurrentY-TargetY)==1)) 
return true;

if(HorizontalMove(CuurentX, CurrentY, TargetX, TargetY)&&(Math.abs(CuurentX-TargetX)==1)) 
return true;
if(DiagonalMove(CuurentX, CurrentY, TargetX, TargetY)&&(Math.abs(CuurentX-TargetY)==1)&&(Math.abs(CurrentY-TargetX)==1)) 
return true;
return false;
    }
    
}
