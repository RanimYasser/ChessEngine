/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ChessCore;

import java.util.ArrayList;


enum PiecesType{
PAWN,BISHOP,KNIGHT,ROOK,QUEEN,KING;
}
public abstract class Piece {
    boolean FirstMove=true;
    private ArrayList<Tile> candidatePath;
    int x;
    int y;
    boolean color;
   int moves=0;

   public Piece(boolean color) {
        this.color = color;
//        this.x = x;
//        this.y = y;
        candidatePath= new ArrayList<Tile>();


}


   public boolean DiagonalMove(int CurrentX,int CurrentY,int TargetX ,int TargetY)
    {
      if (Math.abs(CurrentX-TargetX)==Math.abs(CurrentY-TargetY))
    return true;
        return false;
            }
    public boolean VerticalMove(int CurrentX,int CurrentY,int TargetX ,int TargetY)
    {
    if (CurrentX == TargetX )
    return true;
    return false;
        }
     public boolean HorizontalMove(int CurrentX,int CurrentY,int TargetX ,int TargetY)
    {
    if (CurrentY == TargetY )
    return true;

    return false;
        }
    public abstract boolean isValidMove(Tile Current,Tile Target,Board board);


    public abstract PiecesType getPiecesType();


     }
