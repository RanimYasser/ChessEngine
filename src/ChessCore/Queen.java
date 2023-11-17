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
public class Queen extends Piece{

    public Queen(boolean white) {
    super(white);
    }

  

    @Override
    public boolean isValidMove(int CuurentX ,int CurrentY,int TargetX, int TargetY) {
       if (HorizontalMove(CurrentY, CurrentY, TargetX, TargetY)||VerticalMove(CurrentY, CurrentY, TargetX, TargetY)||DiagonalMove(CurrentY, CurrentY, TargetX, TargetY))
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
