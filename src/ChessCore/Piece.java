/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ChessCore;

import java.util.ArrayList;


enum PiecesType{
PAWN,BISHOP,KNIGHT,ROOK,QEEN,KING;
}
public abstract class Piece {
    boolean white;
    boolean FirstMove;
    private ArrayList<Tile> candidatePath;
    int x;
    int y;
    boolean color;

   public Piece(boolean color) {
        this.color = color;
//        this.x = x;
//        this.y = y;
        candidatePath= new ArrayList<Tile>();
        
                
}
    
    
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
    
    protected abstract ArrayList<Tile> updatePath();
    protected abstract ArrayList<Tile>getAllValidMoves(Tile center);
            
     }
