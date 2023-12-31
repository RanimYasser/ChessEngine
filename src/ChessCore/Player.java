package ChessCore;



public class Player {
    String color;

    Board chessGameBoard;
    int pawns,knights,kings,queens,rooks,bishops,base,pawnbase,totalPieces;
    boolean isKingchecked,hasLegalMoves,white;

    public Player(Board chessGameBoard, boolean white) {
        this.chessGameBoard = chessGameBoard;
        this.white = white;
        this.pawns = 8;
        this.rooks = 2;
        this.bishops = 2;
        this.knights = 2;
        this.queens = 1;
        this.kings = 1;
        this.totalPieces = 16;
        this.pawnbase = white ? 6 : 1;
        this.base = white ? 7 : 0;
        isKingchecked = false;
        this.Fill();
        if (white) this.color = "white";
        else this.color = "black";
        this.hasLegalMoves=true;

    }

    public void Fill() {

        for (int i = 0; i < 8; i++) {
            chessGameBoard.board[pawnbase][i].setPiece(new Pawn(white));
        }

        chessGameBoard.board[base][0].setPiece(new Rook(white));
        chessGameBoard.board[base][7].setPiece(new Rook(white));
        chessGameBoard.board[base][2].setPiece(new Bishop(white));
        chessGameBoard.board[base][5].setPiece(new Bishop(white));
        chessGameBoard.board[base][1].setPiece(new Knight(white));
        chessGameBoard.board[base][6].setPiece(new Knight(white));
        chessGameBoard.board[base][3].setPiece(new Queen(white));
        chessGameBoard.board[base][4].setPiece(new King(white));

    }


    Tile findMyKingTile() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Tile tile = chessGameBoard.getTile(i, j);
                if ((tile.getPiece() instanceof King) && tile.getPiece().color == white) {
                    return tile;
                }
            }
        }
        return null;
    }

    Tile findMyKingSideRookTile() {

        int base = white ? 7 : 0; // Assuming base 7 for white, 0 for black
        int kingSideRookColumn = 7; // Assuming king-side rook is always in the last column

        return chessGameBoard.getTile(base, kingSideRookColumn);
    }

    Tile findMyQueenSideRookTile() {

        int base = white ? 7 : 0; // Assuming base 7 for white, 0 for black
        int rookColumn = 0; // Assuming king-side rook is always in the last column

        return chessGameBoard.getTile(base, rookColumn);
    }

    public boolean isKingInCheck() {
        Tile kingTile = findMyKingTile();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Tile currentTile = chessGameBoard.getTile(i, j);
                if (currentTile.isOccupied()&&(currentTile.getPiece().isValidMove(currentTile, kingTile, chessGameBoard)))
                {
                        isKingchecked = true;
                        return true;
                }

            }
        }
        return false;
    }



}
