/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ChessCore;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author Win11
 */
public class ChessGame {
    private String[] movesString;
    boolean isWhite = true;
    Board chessGameBoard;

    //    ArrayList<String> moves = new ArrayList<>();
    boolean isInProgress = true;
    Player whitePlayer;
    Player blackPlayer;
    Player nowPlaying;
    Player opponent;
    boolean WhitePlayingFlag = true;
    Moves moves;
    GameStates game;

    public ChessGame(String[] moves) {

        // Ensure the Board is initialized
        this.chessGameBoard = new Board();
        this.whitePlayer = new Player(chessGameBoard, isWhite);
        this.blackPlayer = new Player(chessGameBoard, !isWhite);
        this.movesString = moves;
        this.moves = new Moves();
        this.game = new GameStates(chessGameBoard);

    }


    public void start() {
        System.out.println("entered game");
        printBoard();
        for (String move : movesString) {
           // System.out.println("next move");

            Turn();
            hasLegalMoves(nowPlaying);
            hasLegalMoves(opponent);
            isInProgress = game.isGameInProgress();
            //check if game is in progress
            if (isInProgress) {

               // System.out.println(nowPlaying.color);
                //get move
                Object[] index = Utils.ConvertToIndex(move);
                int X1 = (int) index[0];
                int Y1 = (int) index[1];
                int X2 = (int) index[2];
                int Y2 = (int) index[3];

                Tile currentSquare = chessGameBoard.getTile(X1, Y1); // SET AVALIABLE LW EL MOVE SA7 B3D MA YT7ARAK
                //System.out.println(currentSquare.getPiece().getPiecesType());
                //System.out.println(currentSquare.x + " " + currentSquare.y);
                Tile destinationSquare = chessGameBoard.getTile(X2, Y2); // IS AVALIABLE  IF YES MOVE

                //handles jumping and handles pieces valid direction and handles if cell is occupied by my piece
                if (currentSquare.getPiece().isValidMove(currentSquare, destinationSquare, chessGameBoard)) {

                    //check if after this move my king is in check or not
                    if (game.isValidMove(currentSquare, destinationSquare)) {
//                        System.out.println("game move is valid");
//                        System.out.println(move.length());
//                        // regular move
                        if (move.length() == 5) {
                            moves.move(chessGameBoard.getTile(X1, Y1), chessGameBoard.getTile(X2, Y2), opponent);
if (nowPlaying.isKingInCheck())
{
    System.out.println(nowPlaying.color + " is in check!");
}

                        } //promotion
                        else {
                            char promotedTo = (char) index[4];
                 if (destinationSquare.getPiece().color == isWhite && destinationSquare.y == 0 || destinationSquare.getPiece().color != isWhite && destinationSquare.y == 7) {
                                moves.move(chessGameBoard.getTile(X1, Y1), chessGameBoard.getTile(X2, Y2), nowPlaying);
                                moves.Promotion(destinationSquare, promotedTo, nowPlaying);


                            } else System.out.println("Invalid promotion");

                        }
                    } else {
                        System.out.println("Illegal move");//Illegal move my king is in check}
                    }


                } else {
                    //player can't play this move
                    System.out.println("Invalid move");
                    printBoard();
                }

            }
            else {
                System.out.println("Game already ended");
                String color=nowPlaying.isKingchecked? opponent.color: nowPlaying.color;
                System.out.println(color.toUpperCase()+ " HAS WON");
                break;
            }
           // System.out.println(opponent.isKingInCheck());
            //System.out.println(nowPlaying.isKingInCheck());

            hasLegalMoves(opponent);
            hasLegalMoves(nowPlaying);
          //  System.out.println(opponent.hasLegalMoves);
            //System.out.println(nowPlaying.hasLegalMoves);
            isInProgress=game.isGameInProgress();
//            System.out.println(isInProgress);
printBoard();

}printBoard();
        if(!isInProgress){
            String color=nowPlaying.isKingInCheck()?opponent.color:nowPlaying.color;
            System.out.println(color.toUpperCase()+" WON");
        }
       



    }

    public void Turn() {
        if (WhitePlayingFlag) {
            nowPlaying = whitePlayer;
            opponent = blackPlayer;
            game.setPlayer(nowPlaying);
            game.setOpponent(opponent);
        } else {
            nowPlaying = blackPlayer;
            opponent = whitePlayer;
            game.setPlayer(nowPlaying);
            game.setOpponent(opponent);
        }
    }

    public ArrayList<Tile> getAllMovesFromSquare(Tile current) {
        ArrayList<Tile> allmoves = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Tile target = chessGameBoard.board[i][j];
                    if (current.getPiece().isValidMove(current, target, chessGameBoard) && game.isValidMove(current, target)) {
                        allmoves.add(target);
                    }

            }
        }
        return allmoves;

    }
   void hasLegalMoves(Player player) {
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++) {
                Tile tile = chessGameBoard.board[i][j];
                if (tile.isOccupied()) {
                    if (tile.getPiece().color == player.white) {

                        if (getAllMovesFromSquare(tile).size() > 0) {
                            player.hasLegalMoves = true;
                            return;
                        }
                    }
                }
            }
        }
        player.hasLegalMoves=false;
    }


    public void printBoard() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Tile tile = chessGameBoard.getTile(i, j);
                if (tile.isOccupied()) {
                    Piece piece = tile.getPiece();
                    String pieceName = getPieceName(piece);
                    System.out.print(pieceName + " ");
                } else {
                    System.out.print(" - "); // Placeholder for empty tile
                }
            }
            System.out.println(); // Move to the next row
        }
        System.out.println();
    }


    private String getPieceName(Piece piece) {
        if (piece.getPiecesType() == PiecesType.PAWN) {
            return piece.color ? "WP" : "BP";
        } else if (piece instanceof Rook) {
            return piece.color ? "WR" : "BR";
        } else if (piece instanceof Bishop) {
            return piece.color ? "WB" : "BB";
        } else if (piece instanceof Knight) {
            return piece.color ? "WN" : "BN";
        } else if (piece instanceof Queen) {
            return piece.color ? "WQ" : "BQ";
        } else if (piece instanceof King) {
            return piece.color ? "WK" : "BK";
        } else {
            return "Unknown Piece";
        }
    }


}
            
