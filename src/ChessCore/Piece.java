/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ChessCore;


enum PiecesType{
PAWN,BISHOP,KNIGHT,ROOK,QEEN,KING;
}
public abstract class Piece {
    boolean white;
    boolean FirstMove;
    //int x;
    //int y;

  /*  public Piece(Color color, int x, int y) {
        this.color = color;
        this.x = x;
        this.y = y;
    }*/
    
    
   public boolean DiagonalMove(int CurrentX,int CurrentY,int TargetX ,int TargetY)
    {
      if (CurrentX-TargetX==CurrentY-TargetY)
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
    public abstract boolean isValidMove(int CurrentX,int CurrentY,int TargetX ,int TargetY);
 
    
     

            
            }
