/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ChessCore;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author nadamourad
 */
public class Main {
    
  
    
    public static void main(String[] args) {
        
    
        //read from file then instantiate the file
       String [] moves=loadMovesFromFile("Input.txt");
        printMoves(moves);
        ChessGame chessGame = new ChessGame(moves);
       // chessGame.start();
    }

    public static String[] loadMovesFromFile(String filePath) {
        ArrayList<String> lines = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception based on your application's needs
        }

        // Convert the List to an array
        String[]  linesArray= new String[lines.size()];
        return linesArray;
    }
    public static void printMoves(String[] moves) {
        for (String move : moves) {
     
            System.out.print(move + " ");
            }
            System.out.println();
        }
    

}
