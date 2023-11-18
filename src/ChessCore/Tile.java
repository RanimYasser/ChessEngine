/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ChessCore;

/**
 *
 * @author Win11
 */
public class Tile {
    int x; // x-coordinate 
    int y; // y-coordinate
   private Piece piece;

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public Tile(int x, int y) {
        this.x = x;
        this.y = y;
     
    }

   public void emptyTile()
   {
   this.piece=null; // f makanha n3ml check isvalid move elawl
   }
   
   
    public boolean isOccupied()
    {
    return this.getPiece()!=null ;
    }


    
    
}
