/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ChessCore;

/**
 *
 * @author Win11
 */
public class Knight extends Piece {
boolean white;
    public Knight(boolean white) {
        this.white=white;
    }

 
//note this piece is the only one that can jump
    @Override
    public boolean isValidMove(int CuurentX ,int CurrentY,int TargetX, int TargetY) {
     return true;  
    }
    
}
