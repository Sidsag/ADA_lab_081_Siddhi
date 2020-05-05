import java.util.Scanner;
import java.text.ParseException;
import java.util.concurrent.TimeUnit;
public class nqueenbacktrack{ 
    final int N = 4; 
   public static  void printSolution(int board[][],int n) 
    { 
        for (int i = 0; i < n; i++) { 
            for (int j = 0; j < n; j++) 
                System.out.print(" " + board[i][j] 
                                 + " "); 
            System.out.println(); 
        } 
    } 
  
   public static boolean check(int board[][], int row, int col) 
    { 
        int i, j; 
  
        for (i = 0; i < col; i++) 
            if (board[row][i] == 1) 
                return false; 
  
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--) 
            if (board[i][j] == 1) 
                return false; 
  
        for (i = row, j = col; j >= 0 && i < board.length; i++, j--) 
            if (board[i][j] == 1) 
                return false; 
  
        return true; 
    } 
  
    public static boolean solveNQ(int board[][], int col) 
    { 
        if (col >= board.length) 
            return true; 
        for (int i = 0; i < board.length; i++) { 
            if (check(board, i, col)) { 
                board[i][col] = 1; 
                if (solveNQ(board, col + 1) == true) 
                    return true; 
                board[i][col] = 0; // BACKTRACK 
            } 
        } 
        /* If the queen can not be placed in any row in 
           this colum col, then return false */
        return false; 
    } 
  
  
    // driver program to test above function 
    public static void main(String args[]) throws ParseException
    {   Scanner input=new Scanner(System.in);
         System.out.println("enter ther no. of queen to be placed?");
        int n=input.nextInt();
        System.out.println("This is "+n+"queens problem:");
        int [][] board=new int[n][n];
       
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j]=0;
            }
        }
        long startTime = System.currentTimeMillis();
        if (solveNQ(board, 0) == false) { 
            System.out.println("Solution does not exist");  
        } 
        else
        printSolution(board,n); 
        long endTime = System.currentTimeMillis();
        long duration = (endTime - startTime);  //Total execution time in milli seconds
        System.out.println("time taken to solve:"+duration+" milisecond");
    } 
}