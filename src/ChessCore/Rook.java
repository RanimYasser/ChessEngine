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

    public Rook(boolean white) {
    super(white);

    }

   

    @Override
    public boolean isValidMove(Tile Current,Tile Target) {
      if (VerticalMove(Current.x, Current.y, Target.x, Target.y)|| HorizontalMove(Current.x, Current.y, Target.x, Target.y))
    return true;
      return false;
    
    }

   

}
