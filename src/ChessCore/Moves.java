package ChessCore;

public class Moves {

    public Moves() {
    }

    public Piece move(Tile source, Tile destination, Player player) {

        //if the destination is occupied then it is definitely the other color as the get valid paths handles the same color
            source.getPiece().moves+=1;
                 
       if (destination.isOccupied()) {
            Piece killedPiece= kill(source, destination);
            player.totalPieces-=1;
            switch (destination.getPiece().getPiecesType()) {
                case KING ->
                    player.kings--;
                case PAWN ->
                    player.pawns--;
                case ROOK ->
                    player.rooks--;
                case QUEEN ->
                    player.queens--;
                case KNIGHT ->
                    player.knights--;
                case BISHOP ->
                    player.bishops--;

            }
            
        return killedPiece;
        }
       else {
            
            destination.setPiece(source.getPiece());
        //   System.out.println("moved"+destination.getPiece().getPiecesType()+" to "+destination.x+" "+destination.y);
            source.emptyThisTile();
            
        }
       
        return null;
    }

    public Piece kill(Tile KillerTile, Tile currentTile) {
        Piece killedPiece = currentTile.getPiece();
        currentTile.emptyThisTile();
        currentTile.setPiece(KillerTile.getPiece());
        KillerTile.emptyThisTile();// empty killer's tile
        //System.out.println("Captured "+killedPiece.getPiecesType());
        
        return killedPiece;
    }

    public void Promotion(Tile destinationSquare, char promotedTo, Player player) {
        switch (promotedTo) {
            case 'K':
                destinationSquare.setPiece(new Knight(player.white));
                player.knights++;
                break;
            case 'Q':
                destinationSquare.setPiece(new Queen(player.white));
                player.queens++;
                break;
            case 'B':
                destinationSquare.setPiece(new Bishop(player.white));
                player.bishops++;
                break;
            case 'R':
                destinationSquare.setPiece(new Rook(player.white));
                player.rooks++;
                break;

        }

    }
}
