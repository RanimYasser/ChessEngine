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

super(white);
    }

 
//note this piece is the only one that can jump
    @Override
    public boolean isValidMove(Tile Current ,Tile Target) {
        if((Math.abs(Current.x-Target.x))==1 && (Math.abs(Current.y-Target.y)==2)||(Math.abs(Current.x-Target.x))==2 && (Math.abs(Current.y-Target.y)==1))
                return true;
        return false;
    }

  

}
 