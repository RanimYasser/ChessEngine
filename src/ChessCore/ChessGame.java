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

    public ChessGame(String[][] moves) {
        //setup game
        this.whitePlayer = new Player(chessGameBoard, isWhite);
        this.blackPlayer = new Player(chessGameBoard, !isWhite);

        this.movesString = moves;
        this.chessGameBoard=new Board();
//        this.whitePlayer.Fill();
//        this.blackPlayer.Fill();
    }

    ArrayList<Tile> getAllValidMoves(Tile currentTile){
        return currentTile.getPiece().getAllValidMoves(currentTile);

    }


// checks the state of the game
    public boolean IsValidMove() {
        //king is under attack


        //checkmate


        //stalemate



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
                if (move.length() == 2) {
                    int[] index = Utils.ConvertToIndex(move);
                    int X1 = index[0];
                    int Y1 = index[1];
                    int X2 = index[2];
                    int Y2 = index[3];


                    Tile currentSquare = chessGameBoard.board[X1][Y1]; // SET AVALIABLE LW EL MOVE SA7 B3D MA YT7ARAK
                    Tile destinationSquare = chessGameBoard.board[X2][Y2]; // IS AVALIABLE  IF YES MOVE
                    if (currentSquare.getPiece().isValidMove(X1, Y1, X2, Y2)) {
                        if(IsValidMove())
                        {
                            move(chessGameBoard.getTile(X1,Y1),chessGameBoard.getTile(X2,Y2));
                        }


                    }

                }

            }


    }

}
