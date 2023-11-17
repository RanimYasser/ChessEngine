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
    public boolean isValidMove(Tile Current,Tile Target) {
       if (HorizontalMove(Current.x, Current.y, Target.x, Target.y)||VerticalMove(Current.x, Current.y, Target.x, Target.y)||DiagonalMove(Current.x, Current.y, Target.x, Target.y))
   return true;
       return false;
           }

   

}
