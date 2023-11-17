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
public class Rook extends Piece {

    public Rook(boolean white) {
    super(white);

    }

   

    @Override
    public boolean isValidMove(int CurrentX, int CurrentY, int TargetX, int TargetY) {
      if (VerticalMove(CurrentX, CurrentY, TargetX, TargetY)|| HorizontalMove(CurrentX, CurrentY, TargetX, TargetY))
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
