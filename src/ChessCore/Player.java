/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ChessCore;

/**
 *
 * @author Win11
 */
public class Player {
    boolean white ;
    Board chessGameBoard;
    int pawns;
    int knights;
    int kings;
    int queens;
    int rooks;
    int bishops;
    int base=0;

    public Player(Board chessGameBoard, boolean white) {
        this.chessGameBoard = chessGameBoard;
        this.white=white;
        if(white){
            base=7;
        }
        
        Fill();
    }
    
    
 public void Fill()
    {
      
        
        if (white)
        {
        for (int i = 0; i < 8; i++) {
        chessGameBoard.board[base+1][i].piece=new Pawn(true);
        pawns=8;
        }
        chessGameBoard.board[base][0].piece=new Rook(white);
        chessGameBoard.board[base][7].piece=new Rook(white);
        chessGameBoard.board[base][2].piece=new Bishop(white);
        chessGameBoard.board[base][5].piece=new Bishop(white);
        chessGameBoard.board[base][1].piece=new Knight(white);
        chessGameBoard.board[base][6].piece=new Knight(white);
        chessGameBoard.board[base][3].piece=new Queen(white);
        chessGameBoard.board[base][4].piece=new King(white);
        rooks=2;
        bishops=2;
        knights=2;
        queens=1;
        kings=1;
       
        }
        else
        {
                
        for (int i = 0; i < 8; i++) {
        
        chessGameBoard.board[base-1][i].piece=new Pawn(white);
        pawns=8;
        }
        chessGameBoard.board[base][0].piece=new Rook(white);
        chessGameBoard.board[base][7].piece=new Rook(white);
        chessGameBoard.board[base][2].piece=new Bishop(white);
        chessGameBoard.board[base][5].piece=new Bishop(white);
        chessGameBoard.board[base][1].piece=new Knight(white);
        chessGameBoard.board[base][6].piece=new Knight(white);
        chessGameBoard.board[base][3].piece=new Queen(white);
        chessGameBoard.board[base][4].piece=new King(white);
        rooks=2;
        bishops=2;
        knights=2;
        queens=1;
        kings=1;
    }
}
 
}