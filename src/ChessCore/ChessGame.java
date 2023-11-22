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
    private boolean isWhite = true;
    Board chessGameBoard;
    private boolean isInProgress = true;
    private Player whitePlayer,blackPlayer,nowPlaying,opponent;
    private boolean WhitePlayingFlag = true;
    private Moves moves;
    private GameStates game;
    private ArrayList<String> output = new ArrayList<>();

    public ChessGame(String[] moves) {

        // Ensure the Board is initialized
        this.chessGameBoard = new Board();
        this.whitePlayer = new Player(chessGameBoard, isWhite);
        this.blackPlayer = new Player(chessGameBoard, !isWhite);
        this.movesString = moves;
        this.moves = new Moves();
        this.game = new GameStates(chessGameBoard);

    }


    public ArrayList<String> start() {

        printBoard();
        for (String move : movesString) {


            Turn();
            hasLegalMoves(nowPlaying);
            hasLegalMoves(opponent);
            isInProgress = game.isGameInProgress();
            //check if game is in progress
            if (isInProgress) {


                //get move
                Object[] index = Utils.ConvertToIndex(move);
                int X1 = (int) index[0];
                int Y1 = (int) index[1];
                int X2 = (int) index[2];
                int Y2 = (int) index[3];

                Tile currentSquare = chessGameBoard.getTile(X1, Y1);

                Tile destinationSquare = chessGameBoard.getTile(X2, Y2);

                //handles jumping and handles pieces valid direction and handles if cell is occupied by my piece
                if (currentSquare.getPiece().isValidMove(currentSquare, destinationSquare, chessGameBoard)) {

                    //check if after this move my king is in check or not
                    if (game.isValidMove(currentSquare, destinationSquare)) {
                   // regular move
                        if (move.length() == 5) {
                            Piece killed = moves.move(chessGameBoard.getTile(X1, Y1), chessGameBoard.getTile(X2, Y2), opponent);
                            if (killed != null) {
                                System.out.println("CAPTURED " + killed.getPiecesType());
                                output.add("CAPTURED " + killed.getPiecesType());
                            }
                            if (nowPlaying.isKingInCheck()) {
                                System.out.println(nowPlaying.color + " is in check!");
                                output.add(nowPlaying.color + " is in check!");
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

            } else {
                System.out.println("Game already ended");
                output.add("Game already ended");
                String color = nowPlaying.isKingchecked ? opponent.color : nowPlaying.color;
                System.out.println(color.toUpperCase() + " HAS WON");
                break;
            }



            hasLegalMoves(opponent);
            hasLegalMoves(nowPlaying);

            isInProgress = game.isGameInProgress();


        }
        if (!isInProgress) {
            String color = nowPlaying.isKingInCheck() ? opponent.color : nowPlaying.color;
            System.out.println(color.toUpperCase() + " WON");
            output.add(color.toUpperCase() + " WON");
        }

return output;
    }

    public void Turn() {
        nowPlaying=WhitePlayingFlag?whitePlayer:blackPlayer;
        opponent= WhitePlayingFlag?blackPlayer:whitePlayer;
        game.setPlayer(nowPlaying);
        game.setOpponent(opponent);

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
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
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
        player.hasLegalMoves = false;
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
            
