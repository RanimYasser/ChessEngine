/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ChessCore;

enum Pieces{
    PAWN,BISHOP,KNIGHT,ROOK,QUEEN,KING;
}
public class Utils {
    public static int[] ConvertToIndex(String move) {
    String[] seperateMoves= move.split(",");
    String firstMove = seperateMoves[0];
    String secondMove = seperateMoves[1];
    int X1 = firstMove.charAt(0) - 'a';
    int Y1 = Character.getNumericValue(firstMove.charAt(1));
    int X2 = secondMove.charAt(0) - 'a';
    int Y2 = Character.getNumericValue(secondMove.charAt(1));
    int[] indexes = {X1, Y1, X2, Y2};
    if(seperateMoves.length==3)
    {

    }


    return indexes;
}
    
}
