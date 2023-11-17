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
public class Knight extends Piece {
boolean white;
    public Knight(boolean white) {

super(white);
    }

 
//note this piece is the only one that can jump
    @Override
    public boolean isValidMove(int X1 ,int Y1,int X2, int Y2) {
        if((Math.abs(X1-X2))==1 && (Math.abs(Y1-Y2)==2)||(Math.abs(X1-X2))==2 && (Math.abs(Y1-Y2)==1))
                return true;
        return false;
    }

    @Override
    public ArrayList<Tile> updatePath() {
        return null;
    }

    @Override
    protected ArrayList<Tile> getAllValidMoves(Tile center) {
        return null;
    }

}
 