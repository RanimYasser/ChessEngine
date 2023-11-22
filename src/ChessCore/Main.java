/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ChessCore;

import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author nadamourad
 */
public class Main {

    
  
    
    public static void main(String[] args) {

        ArrayList<String >output;
        //read from file then instantiate the file
       String [] moves=loadMovesFromFile("Input.txt");
        printMoves(moves);
        ChessGame chessGame = new ChessGame(moves);
        output=chessGame.start();
        printToFile(output);

    }

    public static String[] loadMovesFromFile(String filePath) {
        ArrayList<String> lines = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }



       return lines.toArray(new String[lines.size()]);
    }
    public static void printMoves(String[] moves) {
        for (String move : moves) {
     
            System.out.print(move + " ");
            }
            System.out.println();
        }
        public static void printToFile(ArrayList<String> output){
            try {
                BufferedWriter writer=new BufferedWriter(new FileWriter("output.txt"));
                for(String line: output){
                    writer.write(line);
                    writer.newLine();
                }
                writer.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }



        }
    

}
