
package ChessCore;


import java.util.ArrayList;

public class Player {
    boolean color ;
    Board chessGameBoard;
    int pawns;
    int knights;
    int kings;
    int queens;
    int rooks;
    int bishops;
    int base;
    int pawnbase;
    boolean isKingchecked;

    public Player(Board chessGameBoard, boolean color) {
        this.chessGameBoard = chessGameBoard;
        this.color=color;
        this.pawns = 8;
        this.rooks = 2;
        this.bishops = 2;
        this.knights = 2;
        this.queens = 1;
        this.kings = 1;
        this.pawnbase = color ? 6 : 1;
        this.base = color ? 7 : 0;
        isKingchecked=false;
        this.Fill();

    }
    
    
 public void Fill() {

     for (int i = 0; i < 8; i++) {
         chessGameBoard.board[pawnbase][i].setPiece(new Pawn(color));
     }

     chessGameBoard.board[base][0].setPiece(new Rook(color));
     chessGameBoard.board[base][7].setPiece(new Rook(color));
     chessGameBoard.board[base][2].setPiece(new Bishop(color));
     chessGameBoard.board[base][5].setPiece(new Bishop(color));
     chessGameBoard.board[base][1].setPiece(new Knight(color));
     chessGameBoard.board[base][6].setPiece(new Knight(color));
     chessGameBoard.board[base][3].setPiece(new Queen(color));
     chessGameBoard.board[base][4].setPiece(new King(color));
 }
 public ArrayList<Tile> getPlayerLegalMoves(){
        return 

 }
}