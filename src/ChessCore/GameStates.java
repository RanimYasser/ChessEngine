package ChessCore;

public  class GameStates {
Board board;
Player player;
    public GameStates(Board board,Player player) {
        this.board=board;
        this.player=player;

        //add constructor
    }
    protected  boolean noLegalMoves(){
        return true;

    }

}
