/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ChessCore;

import java.util.ArrayList;

/**
 *
 * @author Win11
 */
public class King extends Piece {
    private ArrayList<Tile> CandidateCells;
  
    public King(boolean white) {
        super(white);
        
    }

    @Override
    public boolean isValidMove(int CuurentX, int CurrentY, int TargetX, int TargetY) {
        if (VerticalMove(CuurentX, CurrentY, TargetX, TargetY) && (Math.abs(CurrentY - TargetY) == 1)) 
            return true;
        
        if (HorizontalMove(CuurentX, CurrentY, TargetX, TargetY) && (Math.abs(CuurentX - TargetX) == 1)) 
            return true;
        
        if(DiagonalMove(CuurentX, CurrentY, TargetX, TargetY) && (Math.abs(CuurentX - TargetX) == 1) && (Math.abs(CurrentY - TargetY) == 1)) 
            return true;
        
    return false;
        
    }

    @Override
    public ArrayList<Tile> updatePath() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected ArrayList<Tile> getAllValidMoves(Tile center) {
        return null;
    }


}
