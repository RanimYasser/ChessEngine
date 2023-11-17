/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ChessCore;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 *
 * @author nadamourad
 */
public class Main {
    String filename;
    public  void main(String[] args) {


        String[][] moves = new String[0][];

        //read from file then instantiate the file
        loadMovesFromFile();

        ChessGame chessGame = new ChessGame(moves);
        chessGame.start();
    }
    public  void loadMovesFromFile(){
        try {
            BufferedReader read=new BufferedReader( new FileReader(filename));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }


    }
}
