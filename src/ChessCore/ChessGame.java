/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ChessCore;

import java.util.ArrayList;

/**
 * @author Win11
 */
public class ChessGame {
    private String[] movesString;
    boolean isWhite = true;
    Board chessGameBoard = new Board();

    //    ArrayList<String> moves = new ArrayList<>();
    boolean isInProgress;
    Player whitePlayer;
    Player blackPlayer;
    Player nowPlaying;
    Player opponent;
    boolean WhitePlayingFlag = true;
    Moves moves;
    GameStates game;

    public ChessGame(String[] moves) {

        // Ensure the Board is initialized
        this.whitePlayer = new Player(chessGameBoard, isWhite);
        this.blackPlayer = new Player(chessGameBoard, !isWhite);
        this.movesString = moves;
        this.moves = new Moves();
        this.game = new GameStates(chessGameBoard);

        start();
    }


    public void start() {

        printBoard();
        for (String move : movesString) {

            swapTurn();
            //check if game is in progress
            if (isInProgress) {
                //get move
                Object[] index = Utils.ConvertToIndex(move);
                int X1 = (int) index[0];
                int Y1 = (int) index[1];
                int X2 = (int) index[2];
                int Y2 = (int) index[3];

                Tile currentSquare = chessGameBoard.board[X1][Y1]; // SET AVALIABLE LW EL MOVE SA7 B3D MA YT7ARAK
                Tile destinationSquare = chessGameBoard.board[X2][Y2]; // IS AVALIABLE  IF YES MOVE

                //handles jumping and handles pieces valid direction and handles if cell is occupied by my piece
                if (currentSquare.getPiece().isValidMove(currentSquare, destinationSquare, chessGameBoard)) {

                    //check if after this move my king is in check or not
                    if (game.isValidMove(currentSquare, destinationSquare)) {

                        // regular move
                        if (move.length() == 2) {
                            moves.move(chessGameBoard.getTile(X1, Y1), chessGameBoard.getTile(X2, Y2),opponent);
                            WhitePlayingFlag = !WhitePlayingFlag;
                        } //promotion
                        else {
                            char promotedTo = (char) index[4];
                            if (destinationSquare.getPiece().color == isWhite && destinationSquare.y == 0 || destinationSquare.getPiece().color != isWhite && destinationSquare.y == 7) {
                                moves.move(chessGameBoard.getTile(X1, Y1), chessGameBoard.getTile(X2, Y2),nowPlaying);
                                moves.Promotion(destinationSquare, promotedTo,nowPlaying);
                                WhitePlayingFlag = !WhitePlayingFlag;


                            } else System.out.println("Invalid promotion");

                        }
                    }
                    System.out.println("invalid move");//Illegal move my king is in check


                }
                System.out.println("Invalid move");//player can't play this move

            } else System.out.println("Game already ended");

           isInProgress= game.isGameInProgress();

        }

    }

    public void swapTurn() {
        if (WhitePlayingFlag) {
            nowPlaying = whitePlayer;
            opponent=blackPlayer;
            game.setPlayer(nowPlaying);
        } else {
            nowPlaying = blackPlayer;
            opponent=whitePlayer;
            game.setPlayer(nowPlaying);
        }
    }
public ArrayList<Tile> getAllMovesFromSquare(Tile current){
    ArrayList<Tile>allmoves=new ArrayList<Tile>();
        for(int i =0;i<8;i++){
            for(int j=0;j<8;j++){
                Tile target=chessGameBoard.board[i][j];
              if(current.getPiece().isValidMove(current,target,chessGameBoard)){
                  allmoves.add(target);
              }

            }
        }
       return allmoves;

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
                    System.out.print("- "); // Placeholder for empty tile
                }
            }
            System.out.println(); // Move to the next row
        }
    }


    private String getPieceName(Piece piece) {
        return switch (piece) {
            case Pawn pawn -> piece.color ? "WP" : "BP";
            case Rook rook -> piece.color ? "WR" : "BR";
            case Bishop bishop -> piece.color ? "WB" : "BB";
            case Knight knight -> piece.color ? "WN" : "BN";
            case Queen queen -> piece.color ? "WQ" : "BQ";
            case King king -> piece.color ? "WK" : "BK";
            case null, default -> "Unknown Piece";
        };
    }


}
            
