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
return true;
    }
    
}
