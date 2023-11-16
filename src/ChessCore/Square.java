/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ChessCore;

/**
 *
 * @author Win11
 */
public class Square {
    int x; // x-coordinate 
    int y; // y-coordinate
   Piece piece; 

    public Square(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
   public void SetPositionAvaliable()
   {
   this.piece=null; // f makanha n3ml check isvalid move elawl
   }
   
   
    public boolean IsAvaliable(Square position)
    {
    return position.piece==null ;
    }

   
    
    
}
