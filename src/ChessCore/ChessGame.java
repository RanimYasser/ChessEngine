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
public class ChessGame {
    boolean White  ;
    Board chessGameBoard=new Board() ;
    ArrayList<String> moves=new ArrayList<>();
      Player whitePlayer=new Player(chessGameBoard,true);
      Player blackPlayer=new Player(chessGameBoard,false);
    
    public ChessGame() {
    
        
    }
   
    
public int[] ConvertToIndex(String move) {
    String[] s = move.split(",");
    String move1 = s[0];
    String move2 = s[1];
    int X1 = move1.charAt(0) - 'a';
    int Y1 = Character.getNumericValue(move1.charAt(1));
    int X2 = move2.charAt(0) - 'a';
    int Y2 = Character.getNumericValue(move2.charAt(1));
    int[] indexes = {X1, Y1, X2, Y2};
    return indexes;
}
   public boolean IsValidMove(){
     return true;  
   }
   
   public void move(Square current,Square distination)
   {
     // after checking on the validity of the move "100% sure  en el move dy sa7 5alas" 
      Piece temp=current.piece;
      
      current.piece=distination.piece;
      distination.piece=temp;
   }
   
   
    public void Game()
    {
    for (String move:moves)
    {
     if(move.length()==2)
     {
        int[] index= ConvertToIndex(move);
        int X1=index[0];
        int Y1=index[1];
        int X2=index[2];
        int Y2=index[3];
    
     
    Square currentSquare =chessGameBoard.board[X1][Y1]; // SET AVALIABLE LW EL MOVE SA7 B3D MA YT7ARAK
    Square destinationSquare=chessGameBoard.board[X2][Y2]; // IS AVALIABLE  IF YES MOVE
     if (currentSquare.piece.isValidMove(X1, Y1, X2, Y2))
     {
     IsValidMove();
     }
    }
    
     }
    }
    
}
