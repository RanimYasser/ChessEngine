package ChessCore;

import javax.naming.InsufficientResourcesException;

public class GameStates {

    Board board;

    Player player;

    public void setOpponent(Player opponent) {
        this.opponent = opponent;
    }

    Player opponent;
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
        return (!isStalemate() && !isCheckmate() && !InsufficientMaterial(player)&&!InsufficientMaterial(opponent));

    }

    public boolean InsufficientMaterial( Player player) {
if (player.totalPieces==1&&player.kings==1
        ||player.totalPieces==2&&player.knights==1&&player.kings==1
        ||player.totalPieces==2&&player.kings==1&&player.bishops==1)
        return true;
return false;
    } //check on both players &&
    
    public boolean AresquaresInBetweenEmpty(Tile kingTile, Tile rookTile, Board board) {
    int startX = Math.min(kingTile.x, rookTile.x);
    int endX = Math.max(kingTile.x, rookTile.x);

    for (int x = startX + 1; x < endX; x++) {
        Tile intermediateTile = board.getTile(x, kingTile.y);
        if (intermediateTile.isOccupied()) {
            return false;
        }
    }
    // All squares between the king and rook are unoccupied
    return true;
}

    public void castling(){
        Tile kingTile=player.findMyKingTile();
        Tile kingSideRookTile=player.findMyKingSideRookTile();
        Tile queenSideRookTile=player.findMyQueenSideRookTile();
        int X=player.base;
  // &&square under attack
  if(kingSideCastling(kingTile,kingSideRookTile))  
  {
  move.move(kingTile, board.getTile(X, kingTile.y+2), player);
  move.move(kingSideRookTile, board.getTile(X, kingSideRookTile.y-2), player);
 //castle move
  }
  else if(queenideCastling(kingTile, queenSideRookTile))
  {
      
  //castling move
       move.move(kingTile, board.getTile(X, kingTile.y-2), player);
  move.move(queenSideRookTile, board.getTile(X, queenSideRookTile.y+3), player);
  }
    }
    
    public boolean kingSideCastling ( Tile kingTile,Tile kingSideRookTile)
    {
      if (kingTile.getPiece().moves==0&&kingSideRookTile.getPiece().moves==0&&!player.isKingchecked&&AresquaresInBetweenEmpty(kingTile, kingSideRookTile,board))
              {
              return true;
              }
    
    return false;          
}
    
     public boolean queenideCastling( Tile kingTile, Tile queenSideRookTile)
     {
      if (kingTile.getPiece().moves==0&&queenSideRookTile.getPiece().moves==0&&!player.isKingchecked&&AresquaresInBetweenEmpty(kingTile, queenSideRookTile,board))
              {
              return true;
              }
    
    return false;          
}
    
    
    
   

    public boolean isCheckmate() {


        return (player.isKingchecked) && player.noLegalMoves()|| ((opponent.isKingInCheck())&& (opponent.noLegalMoves()));
    }

    public boolean isStalemate() {
        return (player.isKingchecked) && !player.noLegalMoves()|| opponent.isKingInCheck()&& opponent.noLegalMoves();

    }

    public boolean isValidMove(Tile current, Tile destination) {
        if (player.isKingchecked) {
            Piece killedPiece = move.move(current, destination, player);
            if (player.isKingInCheck()) {
                System.out.println("not a valid move");
                //move.undoMove();

                move.move(destination, current, player);
                if (killedPiece != null) {
                    destination.setPiece(killedPiece);
            current.getPiece().moves-=1;
                }

                return false;
            }
            player.isKingchecked = false;
            return true;
        }
        return true;

    }
}
