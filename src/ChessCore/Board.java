/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ChessCore;

/**
 *
 * @author Win11
 */
public class Board {
    Square [][] board = new Square[8][8] ;
    
   

    public Board() {
   for(int i=0; i<8; i++){
            for(int j=0; j<8; j++){
              board[i][j] = new Square(i,j);

            }
          
            
   }
    
    
}

   
}