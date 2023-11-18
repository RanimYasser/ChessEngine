package ChessCore;

public class Moves {

    public Moves() {
    }

    public void move(Tile source, Tile destination, Player player) {
        // after checking on the validity of the move "100% sure  en el move dy sa7 5alas"

        //if the destination is occupied then it is definitely the other color as the get valid paths handles the same color
        if (destination.isOccupied()){
            kill(source.getPiece(),destination);
            switch (destination.getPiece().getPiecesType()){
                case KING -> player.kings--;
                case PAWN -> player.pawns--;
                case ROOK -> player.rooks--;
                case QUEEN -> player.queens--;
                case KNIGHT -> player.knights--;
                case BISHOP -> player.bishops--;
            }

        }
        else {
            destination.setPiece(source.getPiece());
            source.emptyThisTile();
        }
    }
    public void kill(Piece Killer,Tile currentTile){

        currentTile.emptyThisTile();
        currentTile.setPiece(Killer);

    }
    public void Promotion(Tile destinationSquare, char promotedTo,Player player){
        switch(promotedTo){
            case 'K': destinationSquare.setPiece(new Knight(player.white));
            player.knights++;
                break;
            case 'Q':destinationSquare.setPiece(new Queen(player.white));
                player.queens++;
                break;
            case 'B':destinationSquare.setPiece(new Bishop(player.white));
                player.bishops++;
                    break;
            case 'R':destinationSquare.setPiece(new Rook(player.white));
                player.rooks++;
                break;

        }

    }
}
