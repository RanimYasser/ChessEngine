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
    public abstract boolean isValidMove(Tile Current,Tile Target);
    
   public ArrayList<Tile> getAllValidMoves(Tile center,Board chessGameBoard) {
        ArrayList<Tile> path=new ArrayList<>();
        for(int i=0;i<8;i++)
        {
        for(int j=0;j<8;j++)
        {
       Tile temp=chessGameBoard.getTile(i, j);
        if(center.getPiece().isValidMove(center,temp))
        {
            if(temp.getPiece()==null|| center.getPiece() instanceof Knight) //lw el square  fady add to the path   --> king check check
                path.add(temp);
        
            else if(temp.getPiece().color!=center.getPiece().color) // if this tile has an opponent piece add it to the valid path " can kill" and break "can't jump"
            {
            path.add(temp);
            break;
            } 
            else 
                break; //has a piece from my color 
        }
    }
}
        return path;
   }
            
     }
