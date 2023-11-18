package ChessCore;

import javax.naming.InsufficientResourcesException;

public  class GameStates {

    Board board;

    Player player;
    Moves move = new Moves();

    public void setPlayer(Player player) {
        this.player = player;
    }

    public GameStates(Board board) {
        this.board = board;

        //add constructor
    }

    public boolean isGameInProgress() {
        player.isKingInCheck();
        return (!isStalemate() && !isCheckmate() && !InsufficientMaterial());

    }

    public boolean InsufficientMaterial() {


        return true;
    }

    public boolean isCheckmate() {


        return (player.isKingchecked) && player.noLegalMoves();
    }

    public boolean isStalemate() {
        return (player.isKingchecked) && !player.noLegalMoves();

    }

    public boolean isValidMove(Tile current, Tile destination) {
        if (player.isKingchecked) {
            move.move(current, destination, player);
            if (player.isKingInCheck()) {
                System.out.println("not a valid move");

                //move.undoMove();
                return false;
            }
            player.isKingchecked = false;
            return true;
        }
        return true;

    }
}
