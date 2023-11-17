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
    private String[][] movesString;
    boolean isWhite=true;
    Board chessGameBoard ;
    ArrayList<String> moves = new ArrayList<>();
    Player whitePlayer;
    Player blackPlayer ;
  Player nowPlaying;
  boolean WhitePlayingFlag=true;
 
    public ChessGame(String[][] moves) {
        //setup game
        this.whitePlayer = new Player(chessGameBoard, isWhite);
        this.blackPlayer = new Player(chessGameBoard, !isWhite);
       Board chessGameBoard=new Board();

        this.movesString = moves;
        start();
      //this.whitePlayer.Fill();
      //this.blackPlayer.Fill();
    }

   /* ArrayList<Tile> getAllValidMoves(Tile currentTile){
        return currentTile.getPiece().getAllValidMoves(currentTile);

    }*/


// checks the state of the game
    public boolean IsValidMove() {
        //king is under attack


        //checkmate


        //stalemate


return true;
    }


//moves the piece
    public void move(Tile source, Tile destination) {
        // after checking on the validity of the move "100% sure  en el move dy sa7 5alas"
        //if the destination is occupied then it is definately the other color as the get valid paths handles the same color
        if (destination.isOccupied()){
            kill(source.getPiece(),destination);
        }
        else {
            destination.setPiece(source.getPiece());
            source.emptyTile();
        }
    }
    public void kill(Piece Killer,Tile currentTile){

        currentTile.emptyTile();
        currentTile.setPiece(Killer);

    }
 

    public void start() {

            for (String move : moves) {
          if (WhitePlayingFlag==true)
              nowPlaying=whitePlayer;
          else
              nowPlaying=blackPlayer;
                    Object[] index =Utils.ConvertToIndex(move);
                    int X1 = (int)index[0];
                    int Y1 = (int)index[1];
                    int X2 = (int)index[2];
                    int Y2 = (int)index[3];
                    Tile currentSquare = chessGameBoard.board[X1][Y1]; // SET AVALIABLE LW EL MOVE SA7 B3D MA YT7ARAK
                    Tile destinationSquare = chessGameBoard.board[X2][Y2]; // IS AVALIABLE  IF YES MOVE
     if (currentSquare.getPiece().isValidMove(currentSquare,destinationSquare)) {
                        if(IsValidMove())
                        {
                            if (move.length() == 2) 
                    
                        {
                            move(chessGameBoard.getTile(X1,Y1),chessGameBoard.getTile(X2,Y2));
                            WhitePlayingFlag=!WhitePlayingFlag;
                        }
                else 
                {
                    char promotedTo=(char)index[4];
                    if(destinationSquare.getPiece().color&&destinationSquare.y==7||!destinationSquare.getPiece().color&&destinationSquare.y==0)
                    {
                        move(chessGameBoard.getTile(X1,Y1),chessGameBoard.getTile(X2,Y2));
                    
                    nowPlaying.Promotion(destinationSquare, promotedTo, nowPlaying.white);
                   WhitePlayingFlag=!WhitePlayingFlag;
                    
                    }
                    else
                        System.out.println("Invalid promotion");
                
                }
                            
               
            }
                        System.out.println("invalid move");


    }
                System.out.println("Invalid move");

}
    }
    }
            
