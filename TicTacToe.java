
package tictactoe;

/**
 *
 * @author Jonathan
 */
import java.util.Scanner;


public class TicTacToe {


    /**
     * @param args the command line arguments
     */


    public static void main(String[] args) {
        
     char [][] board = createBoard(); // createsboard
     int k = 1;
     char token = 'X';
     boolean won = false;
     
     printBoard(board); // prints board
     placeToken(board , won); // places token. Method to check if one is placed inside of this method
    }// end of main
   
    // Start of createBoard method
    public static char [][]createBoard(){ // start createboard method
    char [][]board = new char [17][17];//board is 17x17
       
        int row;
        int col;
        // entering blank characters into each array
        for(row = 0; row<17; row++){
          for (col = 0; col<17; col++){
          board[row][col] = ' ';
          }
      }
   
    for (col = 0; col<17; col++){ // first horizontal line
      board [5][col] = '-';
      }  
       
      for (col = 0; col<17; col++){ // second horizontal line
      board [11][col]= '-';
      }
     
      for (row = 0; row<17; row++){ // first vertical line
          board[row][5] = '|';
      }
     
      for (row = 0; row<17; row++){ // second vertical line
          board[row][11] = '|';
      }
     
      // numbers that are displayed in each section of the board
      board[2][2]= '1';
      board[2][8]= '2';
      board[2][14]= '3';
      board[8][2] = '4';
      board[8][8] = '5';
      board[8][14] = '6';
      board[14][2]= '7';
      board[14][8] = '8';
      board[14][14] = '9';
   
      return board;
    } // end makeBoard method
   
    // Start of printBoard method
    public static void printBoard(char[][] A) // start printboard method
    { int row, col;
    for (row = 0; row<17; row++){
          for(col = 0; col<17; col++){
              System.out.print(A[row][col]);
          }
          System.out.println("");
      }
    } // end printBoard method
   
   
    // Start of placeToken method
    public static void placeToken(char[][]board, boolean won){
   
     Scanner scnr = new Scanner(System.in);
     
     char token = 'X';
     int k = 1;
     
     // Start of do while loop which asks the user to place their token until someone wins.
     do {
         System.out.println("Where would you like to place your token?");
         int num = scnr.nextInt();


         switch(num){ // Switch statement is used to replace the number on the board with the players token
             case 1:
                 board[2][2] = token;
                 break;
             case 2:
                 board[2][8] = token;
                 break;
             case 3:
                 board[2][14] = token;
                 break;
             case 4:
                 board[8][2] = token;
                 break;
             case 5:
                 board[8][8] = token;
                 break;
             case 6:
                 board[8][14] = token;
                 break;
             case 7:
                 board[14][2] = token;
                 break;
             case 8:
                 board[14][8] = token;
                 break;
             case 9:
                 board[14][14] = token;
                 break;
             default:
                 System.out.println("Please enter a number");
                 break;    
         }
         printBoard(board); // Reprints the board for the user
     
        won = checkIfWon(board, token, k, won);// Method that checks if the user has won
        // If someone wins it will break out of the do while loop.
        if (won == true){
        break;
        }
         
        // switches the token
         if (token == 'X'){
         token = 'O';
         }
         else if (token == 'O'){
         token = 'X';
         }
         k++;
         
    }while (k < 10 && won == false);
   
    } // end of placeToken method
   
    // Start of checkIfWon method
    public static boolean checkIfWon(char[][]board, char token, int k, boolean won){
        // This method checks if someone has won if the different areas of the board are equal to eachother.
        // Only occurs after the 4th token is placed.
        if (k > 4){
         
         if (board[2][2] == board[2][8] && board[2][8] == board[2][14]){
         System.out.println(token + " Wins");
         won = true;
        }
        if (board[8][2] == board[8][8] && board[8][8] == board[8][14]){
         System.out.println(token + " Wins");
         won = true;
        }
        if (board[14][2] == board[14][8] && board[14][8] == board[14][14]){
         System.out.println(token + " Wins");
         won = true;
        }
        if (board[2][2] == board[8][2] && board[8][2] == board[14][2]){
         System.out.println(token + " Wins");
         won = true;
        }
        if (board[2][8] == board[8][8] && board[8][8] == board[14][8]){
         System.out.println(token + " Wins");
         won = true;
        }
        if (board[2][14] == board[8][14] && board[8][14] == board[14][14]){
         System.out.println(token + " Wins");
         won = true;
        }
        if (board[2][2] == board[8][8] && board[8][8] == board[14][14]){
         System.out.println(token + " Wins");
         won = true;
        }
        else if (k == 9 && won == false){
         System.out.println("Draw");
        }
         }
 
        return won;
    } // end of checkIfWon method
   
} // end class
