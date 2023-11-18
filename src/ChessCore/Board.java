/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ChessCore;



/**
 *
 * Nada Mourad
 */
public class Board {
    Tile[][] board = new Tile[8][8];

    public Board() {
        fillBoard(); 
    }

    public Tile getTile(int x, int y) {
        return board[x][y];
    }

    public void fillBoard() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = new Tile(i, j); // Initialize each Tile object
            }
        }
    }
}